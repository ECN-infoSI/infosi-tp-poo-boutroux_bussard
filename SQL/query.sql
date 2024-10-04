/*
I want to write in pl/pgsql
*/

-- This is a comment

-- delete all rows
-- DELETE FROM table_name;

-- INSERT INTO table_name (column1, column2, column3) VALUES (value1, value2, value3);

TRUNCATE creature,humanoide,nomenclature_monstre,nomenclature_objet,monde,inventaire,joueur,monstre,objet,partie,sauvegarde,nomenclature_humanoide;

INSERT INTO nomenclature_objet VALUES ('Epee'),('PotionSoin');

INSERT INTO nomenclature_monstre VALUES ('Lapin'),('Loup');

INSERT INTO nomenclature_humanoide (type_humanoide) VALUES ('Guerrier'), ('Archer'), ('Paysan');

INSERT INTO monde (id_monde, largeur, longueur, id_creature) VALUES ('m1', 50, 50, NULL), ('m2', 55, 100, NULL), ('m3', 60, 10, NULL), ('m4', 20, 50, NULL), ('m5', 50, 50, NULL);

INSERT INTO inventaire (id_inventaire) VALUES ('i2'), ('i3'), ('i4');

INSERT INTO joueur (nom_de_code, mot_de_passe) VALUES ('j1', 'mdpj1'), ('j2', 'mdpj2');

INSERT INTO partie (id_partie, id_monde_initial, nom_de_code, nom) VALUES ('p1', 'm1', 'j1', 'partie1'), ('p2', 'm3', 'j2', 'partie2'), ('p3', 'm3', 'j2', 'partie3');

INSERT INTO humanoide (id_humanoide, type_humanoide, page_att_arme_poing, page_par, dist_att_max, pt_degats_arme_poing, nombre_de_fleche) VALUES ('g1', 'Guerrier', 10, 10, 10, 10, NULL), ('a1', 'Archer', 15, 15, 15, 15, 10), ('g2', 'Guerrier', 10, 10, 10, 10, NULL), ('g3', 'Guerrier', 10, 10, 10, 10, NULL), ('g4', 'Guerrier', 10, 10, 10, 10, NULL), ('g5', 'Guerrier', 10, 10, 10, 10, NULL), ('g6', 'Guerrier', 10, 10, 10, 10, NULL), ('a2', 'Archer', 15, 15, 15, 15, 10);

INSERT INTO objet (id_objet,position_x,position_y,id_monde,type_objet) VALUES ('ps1',10,1,'m1','PotionSoin'),('ps2',15,11,'m2','PotionSoin'),('ps3',12,5,'m4','PotionSoin');

INSERT INTO objet (id_objet,id_monde,id_inventaire,type_objet) VALUES ('e1','m2','i2','Epee'),('e2','m5','i3','Epee'),('e3','m5','i4','Epee'),('ps4','m5','i3','PotionSoin');

INSERT INTO monstre (id_monstre,page_esquive,page_attaque_arme_naturelle,pt_att_arme_naturelle,type_monstre)
VALUES ('m1',20,70,8,'Loup'),('m2',20,70,8,'Loup'),('m3',8,15,2,'Lapin'),('m4',8,15,2,'Lapin'),
('m5',20,70,8,'Loup'),('m6',20,70,8,'Loup'),('m7',20,70,8,'Loup'),('m8',8,15,2,'Lapin');


