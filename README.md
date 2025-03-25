# studentska-sluzba-server
Studentska služba - backend

Klijentska strana: https://github.com/RAFSoftLab/studentska-sluzba-desktopclient
Urađeno:

- osnovna maven konfiguracija
- implementacija modela podataka - POJO enity klase korišćenjem lombok biblioteke
- postavljena osnovna Spring arhitektura
- nekoliko REST servisa urađeno - pretraga i preuzimanje studenata, snimanje studenta
- delimično konfigursan JPA (generisanje dela baze)

Potrebno uraditi


- dodati anotacije u entity klase i generisati šemu baze za MySQL
- manipulacija šifarnicima, REST servis za preuzimanje šifranika (stud. programi, zvanja,...)
- servis za snimanje i preuzimanje nastavnika


# Dokumentacija za instalaciju projekta

## Preduslovi za instalaciju

- JDK 11
- Maven
- MySQL Server
- IntelliJ IDEA (ili drugi IDE po izboru).

## Provera instalacije alata

1. Proverite da li su JDK i Maven instalirani:
```
java -version
mvn -version
```
2.Proverite da li je MySQL server pokrenut i dostupan.

## Kloniranje projekta sa Git-a

1. Otvorite terminal i navigirajte do direktorijuma gde želite da klonirate projekat.
2. Klonirajte repozitorijum:
```
git clone https://github.com/RAFSoftLab/studentska-sluzba-server.git
```
3. Uđite u direktorijum projekta:
```
cd studentska-sluzba-server
```

## Konfiguracija baze podataka

1. Otvorite MySQL konzolu i kreirajte bazu podataka:
```
CREATE DATABASE studsluzba;
```
2.Kreirajte korisnika i dodelite privilegije:
```
CREATE USER 'testuser'@'localhost' IDENTIFIED BY 'testpass';
GRANT ALL PRIVILEGES ON studsluzba.* TO 'testuser'@'localhost';
```
3.Otvorite fajl src/main/resources/application.properties i unesite sledeće podatke:
```
# Hibernate konfiguracija
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Konfiguracija konekcije prema bazi podataka
spring.datasource.url=jdbc:mysql://localhost:3306/studsluzba?serverTimezone=UTC
spring.datasource.username=testuser
spring.datasource.password=testpass
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Prikaz SQL upita u konzoli (za debug)
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```
## Instalacija projekta

1.Otvorite projekat u IntelliJ IDEA.

2.Učitajte Maven zavisnosti:
- Desni klik na projekat → Reload Maven Project.

3.Pokrenite aplikaciju:
- Otvorite klasu sa @SpringBootApplication anotacijom.
- Kliknite na ikonu Run ili koristite prečicu Shift + F10.
