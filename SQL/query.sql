/*
I want to write in pl/pgsql
*/

-- This is a comment

-- delete all rows
-- DELETE FROM table_name;

-- INSERT INTO table_name (column1, column2, column3) VALUES (value1, value2, value3);

TRUNCATE creature,humanoide,type_monstre,type_objet,monde,inventaire,joueur,monstre,objet,partie,sauvegarde,type_humanoide;

INSERT INTO type_objet VALUES ('Epee'),('PotionSoin');

INSERT INTO type_monstre VALUES ('Lapin'),('Loup');

INSERT INTO monde (id_monde, largeur, longueur, id_creature) VALUES ('m1', 50, 50, NULL), ('m2', 55, 100, NULL), ('m3', 60, 10, NULL), ('m4', 20, 50, NULL), ('m5', 50, 50, NULL);

INSERT INTO inventaire (id_inventaire) VALUES ('i1'), ('i2'), ('i3'), ('i4');

INSERT INTO type_humanoide (type) VALUES ('Guerrier'), ('Archer'), ('Paysan');

INSERT INTO joueur (nom_de_code, mot_de_passe) VALUES ('j1', 'mdpj1'), ('j2', 'mdpj2');