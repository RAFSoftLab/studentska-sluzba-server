package org.raflab.studsluzba.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.raflab.studsluzba.controllers.request.DrziPredmetRequest;
import org.raflab.studsluzba.controllers.response.DrziPredmetInitResponse;
import org.raflab.studsluzba.model.dtos.DrziPredmetDTO;
import org.raflab.studsluzba.services.DrziPredmetService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/admin/drzi-predmet")
@AllArgsConstructor
public class DrziPredmetController {

    DrziPredmetService drziPredmetService;
    private final ObjectMapper objectMapper;

    @PostMapping(path = "/upload", consumes = "multipart/form-data")
    public DrziPredmetInitResponse uploadAndGetDrziPredmetList(@RequestParam("file") MultipartFile file) {
        try {
            List<DrziPredmetDTO> drziPredmetDTOList = objectMapper.readValue(
                    file.getInputStream(),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, DrziPredmetDTO.class)
            );

            return drziPredmetService.getDrziPredmetInitResponse(drziPredmetDTOList);
        } catch (IOException e) {
            throw new RuntimeException("Error while reading the file", e);
        }
    }

    @PostMapping(path = "/add")
    public void saveDrziPredmet(@RequestBody DrziPredmetRequest request) {
        drziPredmetService.saveDrziPredmet(request);
    }
}
