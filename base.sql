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
    dureeActivite decimal,
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



insert into activiteBouquet(idActiviteBouquet,idActivite,idBouquet,dureeActivite) values(default,1,1,10),
(default,1,2,20),
(default,1,3,30),
(default,1,4,40);

create table typeDuree(
    idTypeDuree serial primary key,
    nomTypeDuree varchar(20),
    duree int
);

insert into typeDuree values(default,'Courte',5);
insert into typeDuree values(default,'Moyenne',7);
insert into typeDuree values(default,'Longue',10);


create table voyage(
    idVoyage serial Primary Key,
    localisation int,
    bouquet int,
    typeDuree int,
    foreign key (typeDuree) references  typeDuree(idTypeDuree)
);

insert into voyage values(default,1,1,1);

Select activite.nomActivite,bouquet.nomBouquet,activiteBouquet.dureeActivite,localisation.nomLocalisation,typeLocalisation.nomTypeLocalisation 
    from voyage 
    join activite on activite.idActivite=activiteBouquet.idActivite 
    join bouquet on bouquet.idBouquet = activiteBouquet.idBouquet 
    join localisation on voyage.localisation = localisation.idLocalisation 
    join typeLocalisation on typeLocalisation.idTypeLocalisation = localisation.idTypeLocalisation where activite.idactivite = 1;