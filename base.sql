create database voyage;

\c voyage

create table bouquet(
    idBouquet serial Primary Key,
    nomBouquet varchar(20)
);

create table activite(
    idActivite serial Primary Key,
    nomActivite varchar(20)
);

create table typeLocalisation(
    idTypeLocalisation serial Primary Key,
    nomTypeLocalisation varchar(20)
);

create table localisation(
    idLocalisation serial Primary Key,
    nomLocalisation varchar(30),
    idTypeLocalisation int,
    Foreign Key (idTypeLocalisation) References typeLocalisation(idTypeLocalisation)
);

create table activiteBouquet(
    idActiviteBouquet serial Primary Key,
    idActivite int,
    idBouquet int,
    nombre int,
    Foreign Key (idActivite) References activite(idActivite),
    Foreign Key (idBouquet) References bouquet(idBouquet)
);

insert into bouquet(idBouquet,nomBouquet) values(default,'Decouverte'),
(default,'Premium'),
(default,'Gold'),
(default,'VIP');



insert into activite(idActivite,nomActivite) values(default,'Plongee'),
(default,'Randonee'),
(default,'Visite Parc'),
(default,'Peche');



insert into typeLocalisation(idTypeLocalisation,nomTypeLocalisation) values(default,'Regional'),
(default,'Local'),
(default,'International');



insert into localisation(idLocalisation,nomLocalisation,idTypeLocalisation) values(default,'Tamatave',1),
(default,'Majunga',1),
(default,'Tulear',1);



insert into activiteBouquet(idActiviteBouquet,idActivite,idBouquet,nombre) values(default,1,1,1),
(default,1,2,2),
(default,1,3,3),
(default,1,4,4);




create table voyage(
    idVoyage serial Primary Key,
    localisation int,
    bouquet int,
    dureeVoyage int
);

insert into voyage values(default,2,1,10),
(default,1,2,8),
(default,3,3,7),
(default,2,4,5);


select voyage.idVoyage,localisation.nomLocalisation,typeLocalisation.nomTypeLocalisation,bouquet.nomBouquet,voyage.dureeVoyage,activite.nomActivite
from voyage
join localisation on voyage.localisation = localisation.idLocalisation
join typeLocalisation on localisation.idTypeLocalisation = typeLocalisation.idTypeLocalisation
join bouquet on voyage.bouquet = bouquet.idBouquet
join activiteBouquet on activiteBouquet.idBouquet = bouquet.idBouquet
join activite on activiteBouquet.idActivite = activite.idActivite
order by voyage.idVoyage;