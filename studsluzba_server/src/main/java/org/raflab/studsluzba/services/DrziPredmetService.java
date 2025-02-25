package org.raflab.studsluzba.services;

import org.apache.commons.text.similarity.LevenshteinDistance;
import org.raflab.studsluzba.controllers.request.DrziPredmetNewRequest;
import org.raflab.studsluzba.controllers.request.DrziPredmetRequest;
import org.raflab.studsluzba.controllers.response.DrziPredmetBezPoklapanjaInitResponse;
import org.raflab.studsluzba.controllers.response.DrziPredmetInitResponse;
import org.raflab.studsluzba.controllers.response.DrziPredmetPoklapanjeInitResponse;
import org.raflab.studsluzba.model.DrziPredmet;
import org.raflab.studsluzba.model.Nastavnik;
import org.raflab.studsluzba.model.Predmet;
import org.raflab.studsluzba.model.SkolskaGodina;
import org.raflab.studsluzba.model.dtos.DrziPredmetDTO;
import org.raflab.studsluzba.repositories.DrziPredmetRepository;
import org.raflab.studsluzba.repositories.NastavnikRepository;
import org.raflab.studsluzba.repositories.PredmetRepository;
import org.raflab.studsluzba.repositories.SkolskaGodinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.Normalizer;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DrziPredmetService {

    @Autowired
    DrziPredmetRepository drziPredmetRepository;
    @Autowired
    PredmetRepository predmetRepository;
    @Autowired
    NastavnikRepository nastavnikRepository;
    @Autowired
    SkolskaGodinaService skolskaGodinaService;

    public DrziPredmetInitResponse getDrziPredmetInitResponse(List<DrziPredmetDTO> drziPredmetDTOList) {
        LevenshteinDistance levenshtein = new LevenshteinDistance();

        List<DrziPredmet> drziPredmetAktivnaSkolskaGodina = drziPredmetRepository.getDrziPredmetAktivnaSkolskaGodina();

        List<DrziPredmetDTO> nonMatchDrziPredmetDTO = new ArrayList<>();
        List<DrziPredmetPoklapanjeInitResponse> potpunoPoklapanje = new ArrayList<>();

        for (DrziPredmetDTO drziPredmetDto : drziPredmetDTOList) {
            String dtoNaziv = drziPredmetDto.getSubject().getName().toLowerCase();
            int dtoNazivDuzina = dtoNaziv.length();

            DrziPredmet drziPredmet = drziPredmetAktivnaSkolskaGodina
                    .stream()
                    .filter(drziPredmetFilter -> {
                        String predmetNaziv = drziPredmetFilter.getPredmet().getNaziv().toLowerCase();

                        if (predmetNaziv.length() > dtoNazivDuzina) {
                            predmetNaziv = predmetNaziv.substring(0, dtoNazivDuzina);
                        }
                        int distance = levenshtein.apply(predmetNaziv, dtoNaziv);

                        String dtoNumbers = extractNumbers(dtoNaziv);
                        String predmetNumbers = extractNumbers(predmetNaziv);
                        boolean brojSePoklapa = dtoNumbers.equals(predmetNumbers);

                        return distance <= 2 && brojSePoklapa;
                    })
                    .findFirst()
                    .orElse(null);

            if (drziPredmet == null) {
                nonMatchDrziPredmetDTO.add(drziPredmetDto);
            } else {
                potpunoPoklapanje.add(new DrziPredmetPoklapanjeInitResponse(
                        drziPredmet.getPredmet().getId(),
                        drziPredmet.getPredmet().getNaziv(),
                        drziPredmetDto.getSubject().getName(),
                        drziPredmetDto.getTeacher().getEmail()));
            }
        }

        List<DrziPredmetPoklapanjeInitResponse> delimicnoPoklapanje = new ArrayList<>();
        List<DrziPredmetBezPoklapanjaInitResponse> finalNonMatchDrziPredmetDTO = new ArrayList<>();

        for (DrziPredmetDTO drziPredmetDto : nonMatchDrziPredmetDTO) {
            String dtoNaziv = normalizeString(drziPredmetDto.getSubject().getName());

            Optional<DrziPredmet> matchedPredmet = drziPredmetAktivnaSkolskaGodina
                    .stream()
                    .map(drziPredmet -> new AbstractMap.SimpleEntry<>(
                            drziPredmet, normalizeString(drziPredmet.getPredmet().getNaziv())))
                    .filter(entry -> isPotentialMatch(dtoNaziv, entry.getValue()))
                    .min(Comparator.comparingInt(
                            entry -> levenshtein.apply(dtoNaziv, entry.getValue())))
                    .map(AbstractMap.SimpleEntry::getKey);

            if (matchedPredmet.isPresent()) {
                DrziPredmet drziPredmet = matchedPredmet.get();
                delimicnoPoklapanje.add(new DrziPredmetPoklapanjeInitResponse(
                        drziPredmet.getPredmet().getId(),
                        drziPredmet.getPredmet().getNaziv(),
                        drziPredmetDto.getSubject().getName(),
                        drziPredmetDto.getTeacher().getEmail()
                ));
            } else {
                finalNonMatchDrziPredmetDTO.add(new DrziPredmetBezPoklapanjaInitResponse(
                        drziPredmetDto.getSubject().getName(),
                        drziPredmetDto.getTeacher().getEmail()));
            }
        }

        return new DrziPredmetInitResponse(potpunoPoklapanje, delimicnoPoklapanje, finalNonMatchDrziPredmetDTO);
    }

    private boolean isPotentialMatch(String dtoNaziv, String predmetNaziv) {
        int distance = new LevenshteinDistance().apply(dtoNaziv, predmetNaziv);

        String dtoNumbers = extractNumbers(dtoNaziv);
        String predmetNumbers = extractNumbers(predmetNaziv);
        boolean brojSePoklapa = dtoNumbers.equals(predmetNumbers);

        return (distance <= 2 || dtoNaziv.contains(predmetNaziv) || predmetNaziv.contains(dtoNaziv)) && brojSePoklapa;
    }

    private String normalizeString(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("[^\\p{L}\\p{Nd} ]", "") // Uklanja specijalne karaktere
                .replaceAll("\\s+", " ") // Normalizuje razmake
                .toLowerCase()
                .trim();
    }

    private String extractNumbers(String input) {
        return input.replaceAll("[^0-9]", ""); // Uklanja sve sem brojeva
    }

    @Transactional
    public void saveDrziPredmet(DrziPredmetRequest request) {
        SkolskaGodina skolskaGodina = skolskaGodinaService.getNewSkolskaGodina();

        if (skolskaGodina != null) {
            return;
        }

        List<DrziPredmetNewRequest> drziPredmetList = request.getDrziPredmet();
        List<DrziPredmetNewRequest> newDrziPredmetList = request.getNewDrziPredmet();

        // izvuci sve predmete iz baze po predmetId
        Map<Long, Predmet> predmetMap = predmetRepository.findByIdIn(
                drziPredmetList.stream().map(DrziPredmetNewRequest::getPredmetId).collect(Collectors.toList())
        ).stream().collect(Collectors.toMap(Predmet::getId, Function.identity()));

        // izvuci sve predmete iz baze po predmetNaziv za nove unose
        Map<String, Predmet> newPredmetMap = predmetRepository.findByNazivIn(
                newDrziPredmetList.stream().map(DrziPredmetNewRequest::getPredmetNaziv).collect(Collectors.toList())
        ).stream().collect(Collectors.toMap(Predmet::getNaziv, Function.identity()));

        // izvuci sve nastavnike iz baze po email
        List<String> allEmails = Stream.concat(
                drziPredmetList.stream().map(DrziPredmetNewRequest::getEmailNastavnik),
                newDrziPredmetList.stream().map(DrziPredmetNewRequest::getEmailNastavnik)
        ).distinct().collect(Collectors.toList());

        Map<String, Nastavnik> nastavnikMap = nastavnikRepository.findByEmailIn(allEmails)
                .stream().collect(Collectors.toMap(Nastavnik::getEmail, Function.identity()));

        // kreiranje liste DrziPredmet objekata za cuvanje
        List<DrziPredmet> drziPredmetEntities = new ArrayList<>();

        for (DrziPredmetNewRequest drziPredmetRequest : drziPredmetList) {
            Predmet predmet = predmetMap.get(drziPredmetRequest.getPredmetId());
            Nastavnik nastavnik = nastavnikMap.get(drziPredmetRequest.getEmailNastavnik());

            if (predmet != null && nastavnik != null) {
                DrziPredmet drziPredmet = new DrziPredmet();
                drziPredmet.setPredmet(predmet);
                drziPredmet.setNastavnik(nastavnik);
                drziPredmet.setSkolskaGodina(skolskaGodina);
                drziPredmetEntities.add(drziPredmet);
            }
        }

        for (DrziPredmetNewRequest newDrziPredmetRequest : newDrziPredmetList) {
            Predmet predmet = newPredmetMap.get(newDrziPredmetRequest.getPredmetNaziv());
            Nastavnik nastavnik = nastavnikMap.get(newDrziPredmetRequest.getEmailNastavnik());

            if (predmet != null && nastavnik != null) {
                DrziPredmet drziPredmet = new DrziPredmet();
                drziPredmet.setPredmet(predmet);
                drziPredmet.setNastavnik(nastavnik);
                drziPredmet.setSkolskaGodina(skolskaGodina);
                drziPredmetEntities.add(drziPredmet);
            }
        }
        System.out.println("BROJ DrziPredmet za cuvanje: " + drziPredmetEntities.size());

        drziPredmetRepository.saveAll(drziPredmetEntities);
    }
}