
INSERT INTO `studijski_program` (`godina_akreditacije`, `naziv`, `oznaka`, `trajanje_godina`, `trajanje_semestara`, `vrsta_studija`, `zvanje`) VALUES ('2020', 'Računarske nauke', 'RN', '4', '8', 'OAS', 'Diplomirani informatičar');
INSERT INTO `studijski_program` (`godina_akreditacije`, `naziv`, `oznaka`, `trajanje_godina`, `trajanje_semestara`, `vrsta_studija`, `zvanje`) VALUES ('2020', 'Računarsko inženjerstvo', 'Ri', '4', '8', 'OAS', 'Diplomirani inženjer elektrotehnike');


INSERT INTO `srednja_skola` (`id`,`mesto`,`naziv`,`vrsta`) VALUES (1,'Beograd','9. Beogradska','gimnazija');
INSERT INTO `srednja_skola` (`id`,`mesto`,`naziv`,`vrsta`) VALUES (2,'Beograd','Računarska gimnazija','gimnazija');

INSERT INTO `student_podaci` (`adresa`, `broj_licne_karte`, `broj_telefona`, `datum_rodjenja`, `email`, `ime`, `jmbg`, `mesto_prebivalista`, `mesto_rodjenja`, `mesto_stanovanja`, `pol`, `prezime`, `srednje_ime`) VALUES ('Bulevar oslobodjenja 34', '087654343', '065432167', '2000-08-09', 'mjeftic@gmail.com', 'Milica', '1234567897', 'Beograd', 'Novi Sad', 'Beograd', 'z', 'Jeftic', 'Marko');


INSERT INTO `student_indeks` (`aktivan`, `broj`, `godina`, `stud_program`, `student_id`) VALUES (1, '34', '2020', 'RN', 1);

INSERT INTO `predmet` (`espb`, `fond_predavanja`, `fond_vezbe`, `godina_studija`, `naziv`, `semestar`, `sifra`, `stud_program_id`) VALUES ('8', '2', '4', '1', 'Uvod u programiranje', '1', '1002a', 2);
INSERT INTO `predmet` (`espb`, `fond_predavanja`, `fond_vezbe`, `godina_studija`, `naziv`, `semestar`, `sifra`, `stud_program_id`) VALUES ('8', '2', '2', '1', 'Diskretne strukture', '1', '1001a', 1);
INSERT INTO `predmet` (`espb`, `fond_predavanja`, `fond_vezbe`, `godina_studija`, `naziv`, `semestar`, `sifra`, `stud_program_id`) VALUES ('7', '2', '2', '1', 'Linearna algebra i analiticka geometrija', '1', '1002a', 1);

INSERT INTO `predmet` (`espb`, `fond_predavanja`, `fond_vezbe`, `godina_studija`, `naziv`, `semestar`, `sifra`, `stud_program_id`) VALUES ('7', '2', '4', '1', 'Objektno-orijentisano programiranje', '2', '1003a', 1);
INSERT INTO `predmet` (`espb`, `fond_predavanja`, `fond_vezbe`, `godina_studija`, `naziv`, `semestar`, `sifra`, `stud_program_id`) VALUES ('7', '3', '2', '1', 'Osnovi racunarskih sistema', '2', '1005a', 1);
INSERT INTO `predmet` (`espb`, `fond_predavanja`, `fond_vezbe`, `godina_studija`, `naziv`, `semestar`, `sifra`, `stud_program_id`) VALUES ('3', '2', '0', '1', 'Poslovne aplikacije', '2', '1000a', 1);



INSERT INTO `nastavnik` (`ime`, `prezime`) VALUES ('Dragan', 'Urosevic');
INSERT INTO `nastavnik` (`ime`, `prezime`) VALUES ('Bojana', 'Dimic Surla');
INSERT INTO `nastavnik` (`ime`, `prezime`) VALUES ('Irena', 'Jovanovic');
INSERT INTO `nastavnik` (`ime`, `prezime`) VALUES ('Jelena', 'Jovanovic');
INSERT INTO `nastavnik` (`ime`, `prezime`) VALUES ('Milanka', 'Gardasevic');

INSERT INTO `polozen_predmet` (`ocena`, `priznat`, `ispit_id`, `nastavnik_id`, `predmet_id`, `student_indeks_id`) VALUES ('8', 1, NULL, 1, 1, 1);


INSERT INTO `skolska_godina` (`aktivna`, `krajnja`, `pocetna`) VALUES (1, 2020, 2021);

INSERT INTO `ispitni_rok` (`datum_pocetka`, `datum_zavrsetka`, `naziv`, `skolska_godina_id`) VALUES ('2020-01-20', '2020-02-15', 'januarski', 1);

INSERT INTO `drzi_predmet` (`nastavnik_id`, `predmet_id`, `skolska_godina_id`) VALUES ('1', '1', '1');
INSERT INTO `drzi_predmet` (`nastavnik_id`, `predmet_id`, `skolska_godina_id`) VALUES ('1', '2', '1');

INSERT INTO `ispit` (`datum_odrzavanja`, `mesto_odrzavanja`, `zakljucen`, `drzi_predmet_id`, `ispitni_rok_id`) VALUES ('2020-01-30', NULL, 0, 1, 1);
INSERT INTO `ispit` (`datum_odrzavanja`, `mesto_odrzavanja`, `zakljucen`, `drzi_predmet_id`, `ispitni_rok_id`) VALUES ('2020-02-01', NULL, 0, 2, 1);

INSERT INTO `prijava_ispita` (`datum_prijave`, `ispit_id`, `student_indeks_id`) VALUES ('2020-01-15', '1', '1');
INSERT INTO `prijava_ispita` (`datum_prijave`, `ispit_id`, `student_indeks_id`) VALUES ('2020-01-15', '2', '1');



INSERT INTO `izlazak_ispit` (`broj_poena_ispit`, `broj_poena_predispitne`, `ponisten`, `prijava_id`) VALUES ('35', '60', 0, 2);

INSERT INTO `polozen_predmet` (`ocena`, `priznat`, `ispit_id`, `nastavnik_id`, `predmet_id`, `student_indeks_id`) VALUES ('10', 0, 1, 1, 2, 1);

INSERT INTO `upis_godine` (`datum_upisa`, `godina_koja_se_upisuje`, `prenos_espb`, `student_indeks_id`) VALUES ('2020-09-20', '1', '0', '1');

INSERT INTO `uplata` (`iznos`, `kurs`, `nacin_uplate`, `student_indeks_id`) VALUES ('1890', '120', 'banka', '1');

INSERT INTO `slusa_predmet` (`drzi_predmet_id`, `student_indeks_id`) VALUES ('1', '1');
INSERT INTO `slusa_predmet` (`drzi_predmet_id`, `student_indeks_id`) VALUES ('2', '1');

INSERT INTO `obnova_godine` (`godina_koju_obnavlja`, `student_indeks_id`, `datum_obnove`, `napomena`) VALUES ('1', '1', '2020-02-03', 'prprprprprpr');

UPDATE `studsluzba`.`predmet` SET `obavezan` = 1 WHERE (`id` = '1');
UPDATE `studsluzba`.`predmet` SET `obavezan` = 1 WHERE (`id` = '2');
UPDATE `studsluzba`.`predmet` SET `obavezan` = 1 WHERE (`id` = '3');

INSERT INTO `studsluzba`.`drzi_predmet` (`nastavnik_id`, `predmet_id`, `skolska_godina_id`) VALUES ('1', '3', '1');







