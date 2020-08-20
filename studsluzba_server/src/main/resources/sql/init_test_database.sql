/*
-- Query: SELECT * FROM studsluzba.student_podaci
LIMIT 0, 5000

-- Date: 2020-08-13 23:12
*/
INSERT INTO `student_podaci` (`adresa`,`adresa_stanovanja`,`broj_licne_karte`,`broj_telefona`,`datum_rodjenja`,`drzava_rodjenja_code`,`drzavljanstvo_code`,`email`,`ime`,`jmbg`,`licnu_kartu_izdao`,`mesto_prebivalista_code`,`mesto_rodjenja_code`,`mesto_stanovanja_code`,`nacionalnost`,`pol`,`prezime`,`slika`,`srednje_ime`) VALUES (NULL,NULL,NULL,NULL,'2020-08-07',NULL,NULL,NULL,'Milica',NULL,NULL,NULL,NULL,NULL,NULL,'\0','Maric',NULL,'');
INSERT INTO `student_podaci` (`adresa`,`adresa_stanovanja`,`broj_licne_karte`,`broj_telefona`,`datum_rodjenja`,`drzava_rodjenja_code`,`drzavljanstvo_code`,`email`,`ime`,`jmbg`,`licnu_kartu_izdao`,`mesto_prebivalista_code`,`mesto_rodjenja_code`,`mesto_stanovanja_code`,`nacionalnost`,`pol`,`prezime`,`slika`,`srednje_ime`) VALUES (NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Milica',NULL,NULL,NULL,NULL,NULL,NULL,'z','Jeftic',NULL,NULL);


INSERT INTO `nastavna_naucna_zvanja` (`id`,`vrsta`,`zvanje`) VALUES (1,'nastavno','predavač');
INSERT INTO `nastavna_naucna_zvanja` (`id`,`vrsta`,`zvanje`) VALUES (2,'nastavno','viši predavač');
INSERT INTO `nastavna_naucna_zvanja` (`id`,`vrsta`,`zvanje`) VALUES (3,'nastavno','profesor strukovnih studija');
INSERT INTO `nastavna_naucna_zvanja` (`id`,`vrsta`,`zvanje`) VALUES (4,'nastavno','docent');
INSERT INTO `nastavna_naucna_zvanja` (`id`,`vrsta`,`zvanje`) VALUES (5,'nastavno','vanredni profesor');
INSERT INTO `nastavna_naucna_zvanja` (`id`,`vrsta`,`zvanje`) VALUES (6,'nastavno','redovni profesor');

INSERT INTO `nastavna_naucna_zvanja` (`id`,`vrsta`,`zvanje`) VALUES (7,'saradnicko','saradnik u nastavi');
INSERT INTO `nastavna_naucna_zvanja` (`id`,`vrsta`,`zvanje`) VALUES (8,'saradnicko','asistent');
INSERT INTO `nastavna_naucna_zvanja` (`id`,`vrsta`,`zvanje`) VALUES (9,'saradnicko','asistent sa doktoratom');

INSERT INTO `studijski_program` (`id`,`godina_akreditacije`,`naziv`,`oznaka`,`trajanje_godina`,`trajanje_semestara`,`vrsta_studija`,`zvanje`) VALUES (1,2020,'Računarske nauke','RN',4,8,'OAS','diplomirani informatičar');
INSERT INTO `studijski_program` (`id`,`godina_akreditacije`,`naziv`,`oznaka`,`trajanje_godina`,`trajanje_semestara`,`vrsta_studija`,`zvanje`) VALUES (2,2020,'Računarsko inšenjerstvo','RI',4,8,'OAS',NULL);

INSERT INTO `srednja_skola` (`id`,`mesto`,`naziv`,`vrsta`) VALUES (1,'Beograd','9. Beogradska','gimnazija');
INSERT INTO `srednja_skola` (`id`,`mesto`,`naziv`,`vrsta`) VALUES (2,'Beograd','Računarska gimnazija','gimnazija');