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

INSERT INTO joueur (nom_de_code, mot_de_passe) VALUES ('Saegusa', 'Mayumi');

INSERT INTO partie (nom, id_joueur) VALUES ('Test Game 1', (SELECT id_joueur FROM joueur WHERE nom_de_code = 'Saegusa' AND mot_de_passe='Mayumi'));