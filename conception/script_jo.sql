CREATE TABLE Athlete(
   Id_Athlete NOT NULL AUTO_INCREMENT,
   nomAthlete VARCHAR(500),
   sexe VARCHAR(10),
   age INT,
   taille DECIMAL(3,2),
   poids DECIMAL(3,2),
   PRIMARY KEY(Id_Athlete)
);

CREATE TABLE PaysOrganisateur(
   Id_PaysOrganisateur NOT NULL AUTO_INCREMENT,
   ville VARCHAR(500),
   annee DATE,
   saison VARCHAR(10),
   PRIMARY KEY(Id_PaysOrganisateur)
);

CREATE TABLE Sport(
   Id_Sport NOT NULL AUTO_INCREMENT,
   nomSport VARCHAR(500),
   PRIMARY KEY(Id_Sport)
);

CREATE TABLE TraductionSport(
   codeLangue NOT NULL VARCHAR(10),
   traduction VARCHAR(50),
   Id_Sport INT NOT NULL,
   PRIMARY KEY(codeLangue),
   FOREIGN KEY(Id_Sport) REFERENCES Sport(Id_Sport)
);

CREATE TABLE BanniereOlympique(
   cioCode NOT NULL VARCHAR(10),
   nomPays VARCHAR(500),
   statut LOGICAL,
   PRIMARY KEY(cioCode)
);

CREATE TABLE TraductionBO(
   codeLangue NOT NULL VARCHAR(10),
   traduction VARCHAR(500),
   cioCode INT NOT NULL,
   PRIMARY KEY(codeLangue),
   FOREIGN KEY(cioCode) REFERENCES BanniereOlympique(cioCode)
);

CREATE TABLE Equipe(
   Id_Equipe NOT NULL AUTO_INCREMENT,
   nomEquipe VARCHAR(500),
   cioCode INT NOT NULL,
   PRIMARY KEY(Id_Equipe),
   FOREIGN KEY(cioCode) REFERENCES BanniereOlympique(cioCode)
);

CREATE TABLE Epreuve(
   Id_Epreuve NOT NULL AUTO_INCREMENT,
   nomEpreuve VARCHAR(1000) NOT NULL,
   Id_PaysOrganisateur INT NOT NULL,
   Id_Sport INT NOT NULL,
   PRIMARY KEY(Id_Epreuve),
   FOREIGN KEY(Id_PaysOrganisateur) REFERENCES PaysOrganisateur(Id_PaysOrganisateur),
   FOREIGN KEY(Id_Sport) REFERENCES Sport(Id_Sport)
);

CREATE TABLE TraductionEpreuve(
   codeLangue VARCHAR(10),
   traduction VARCHAR(1000),
   Id_Epreuve INT NOT NULL,
   PRIMARY KEY(codeLangue),
   FOREIGN KEY(Id_Epreuve) REFERENCES Epreuve(Id_Epreuve)
);

CREATE TABLE Medaille(
   Id_Medaille NOT NULL AUTO_INCREMENT,
   couleur VARCHAR(6),
   Id_Epreuve INT NOT NULL,
   Id_Athlete INT NOT NULL,
   PRIMARY KEY(Id_Medaille),
   FOREIGN KEY(Id_Epreuve) REFERENCES Epreuve(Id_Epreuve),
   FOREIGN KEY(Id_Athlete) REFERENCES Athlete(Id_Athlete)
);

CREATE TABLE Athlete_Equipe(
   Id_Athlete INT NOT NULL,
   Id_Equipe INT NOT NULL,
   PRIMARY KEY(Id_Athlete, Id_Equipe),
   FOREIGN KEY(Id_Athlete) REFERENCES Athlete(Id_Athlete),
   FOREIGN KEY(Id_Equipe) REFERENCES Equipe(Id_Equipe)
);

CREATE TABLE Epreuve_Athlete(
   Id_Athlete INT NOT NULL,
   Id_Epreuve INT NOT NULL,
   PRIMARY KEY(Id_Athlete, Id_Epreuve),
   FOREIGN KEY(Id_Athlete) REFERENCES Athlete(Id_Athlete),
   FOREIGN KEY(Id_Epreuve) REFERENCES Epreuve(Id_Epreuve)
);
