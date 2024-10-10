/*
I want to write in pl/pgsql
*/

-- This is a comment

-- delete all rows
-- DELETE FROM table_name;

-- INSERT INTO table_name (column1, column2, column3) VALUES (value1, value2, value3);

TRUNCATE creature,humanoide,nomenclature_monstre,nomenclature_objet,monde,inventaire,joueur,monstre,objet,partie,sauvegarde,nomenclature_humanoide;

INSERT INTO nomenclature_objet VALUES ('Epee'),('PotionSoin'),('Massue');

INSERT INTO nomenclature_monstre VALUES ('Lapin'),('Loup'),('trolls'),('gobelin');

INSERT INTO nomenclature_humanoide (type_humanoide) VALUES ('Guerrier'), ('Archer'), ('Paysan');

INSERT INTO monde (id_monde, largeur, longueur) 
VALUES ('m1', 50, 50), ('m2', 55, 100),
('m3', 60, 10), ('m4', 20, 50), ('m5', 50, 50);

INSERT INTO inventaire (id_inventaire) VALUES ('i2'), ('i3'), ('i4');

INSERT INTO joueur (nom_de_code, mot_de_passe) VALUES ('j1', 'mdpj1'), ('j2', 'mdpj2');

INSERT INTO partie (id_partie, id_monde_initial, id_joueur, nom) VALUES ('p1', 'm1', '1', 'partie1'), ('p2', 'm3', '2', 'partie2'), ('p3', 'm3', '2', 'partie3');

INSERT INTO humanoide (id_humanoide, type_humanoide, page_att_arme_poing, page_par, dist_att_max, pt_degats_arme_poing, nombre_de_fleche) VALUES ('g1', 'Guerrier', 10, 10, 10, 10, NULL), ('a1', 'Archer', 15, 15, 15, 15, 10), ('g2', 'Guerrier', 10, 10, 10, 10, NULL), ('g3', 'Guerrier', 10, 10, 10, 10, NULL), ('g4', 'Guerrier', 10, 10, 10, 10, NULL), ('g5', 'Guerrier', 10, 10, 10, 10, NULL), ('g6', 'Guerrier', 10, 10, 10, 10, NULL), ('a2', 'Archer', 15, 15, 15, 15, 10);

INSERT INTO objet (id_objet,position_x,position_y,id_monde,type_objet) VALUES ('ps1',10,1,'m1','PotionSoin'),('ps2',15,11,'m2','PotionSoin'),('ps3',12,5,'m4','PotionSoin');

INSERT INTO objet (id_objet,id_monde,id_inventaire,type_objet) VALUES ('e1','m2','i2','Epee'),('e2','m5','i3','Epee'),('e3','m5','i4','Epee'),('ps4','m5','i3','PotionSoin');

INSERT INTO monstre (id_monstre,page_esquive,page_attaque_arme_naturelle,pt_att_arme_naturelle,type_monstre)
VALUES ('m1',20,70,8,'Loup'),('m2',20,70,8,'Loup'),('m3',8,15,2,'Lapin'),('m4',8,15,2,'Lapin'),
('m5',20,70,8,'Loup'),('m6',20,70,8,'Loup'),('m7',20,70,8,'Loup'),('m8',8,15,2,'Lapin');

INSERT INTO sauvegarde (id_monde,id_partie,date_sauvegarde,nom) 
VALUES ('m1','p1','2024-04-10 00:00:00','Sauvegarde_1'),('m2','p1','2024-04-10 03:00:00','Sauvegarde_2'),('m5','p3','2024-04-10 00:00:00','Sauvegarde_1');

INSERT INTO creature (id_creature,point_de_vie,position_x,position_y,id_monde,id_humanoide,id_monstre,id_inventaire,est_male) VALUES 
-- monde 1
('c1',100,10,10,'m1','g1',NULL,NULL,TRUE), ('c2',100,10,10,'m1',NULL,'m1',NULL,FALSE), ('c3',100,10,10,'m1',NULL,'m2',NULL,FALSE), 
-- monde 2
('c4',100,10,10,'m2',NULL,'m3',NULL,FALSE), ('c5',100,10,10,'m2','g2',NULL,'i2',TRUE), 
-- monde 3
('c6',100,10,10,'m3','a1',NULL,NULL,FALSE), ('c7',100,10,10,'m3','g3',NULL,NULL,TRUE), ('c8',100,10,10,'m3','g4',NULL,NULL,FALSE), ('c9',100,10,10,'m3',NULL,'m4',NULL,TRUE), 
--monde 4
('c10',100,10,10,'m4',NULL,'m5',NULL,TRUE), ('c11',100,10,10,'m4',NULL,'m6',NULL,FALSE), ('c12',100,10,10,'m4',NULL,'m7',NULL,FALSE), ('c13',100,10,10,'m4','a2',NULL,NULL,FALSE), ('c14',100,10,10,'m4','g5',NULL,NULL,FALSE),
-- monde 5
('c15',100,10,10,'m5','g6',NULL,'i3',TRUE), ('c16',100,10,10,'m5',NULL,'m8','i4',TRUE);


UPDATE partie SET date_derniere_sauvegarde_rapide='2024-04-01 00:00:10', id_monde_sauvegarde_rapide='m4'
WHERE id_partie='p2';

UPDATE monde SET id_creature='c1',nom_personnage='Conan' WHERE id_monde='m2';
UPDATE monde SET id_creature='c14',nom_personnage='Gurdil' WHERE id_monde='m4';
UPDATE monde SET id_creature='c16',nom_personnage='Jojo' WHERE id_monde='m5';
