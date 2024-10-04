DROP TABLE creature,humanoide,type_monstre,type_objet,monde,inventaire,joueur,monstre,objet,partie,sauvegarde,type_humanoide;

CREATE TABLE public.type_objet (
                type_objet VARCHAR(15) NOT NULL,
                CONSTRAINT pk_type_objet PRIMARY KEY (type_objet)
);


CREATE TABLE public.type_monstre (
                type_monstre VARCHAR(15) NOT NULL,
                CONSTRAINT pk_type_monstre PRIMARY KEY (type_monstre)
);


CREATE TABLE public.type_humanoide (
                type_humanoide VARCHAR(15) NOT NULL,
                CONSTRAINT pk_type_humanoide PRIMARY KEY (type_humanoide)
);


CREATE TABLE public.inventaire (
                id_inventaire VARCHAR(40) NOT NULL,
                CONSTRAINT pk_inventaire PRIMARY KEY (id_inventaire)
);


CREATE TABLE public.monstre (
                id_monstre VARCHAR(40) NOT NULL,
                page_esquive INTEGER NOT NULL,
                page_attaque_arme_naturelle INTEGER NOT NULL,
                pt_att_arme_naturelle INTEGER NOT NULL,
                type_monstre VARCHAR(15) NOT NULL,
                CONSTRAINT pk_monstre PRIMARY KEY (id_monstre)
);


CREATE TABLE public.humanoide (
                id_humanoide VARCHAR NOT NULL,
                page_att_arme_poing INTEGER NOT NULL,
                page_par INTEGER NOT NULL,
                dist_att_max INTEGER NOT NULL,
                pt_degats_arme_poing INTEGER NOT NULL,
                nombre_de_fleche INTEGER,
                type_humanoide VARCHAR(15) NOT NULL,
                CONSTRAINT pk_humanoide PRIMARY KEY (id_humanoide)
);


CREATE TABLE public.monde (
                id_monde VARCHAR(50) NOT NULL,
                largeur INTEGER NOT NULL,
                longueur INTEGER NOT NULL,
                id_creature VARCHAR(50),
                CONSTRAINT pk_monde PRIMARY KEY (id_monde)
);


CREATE TABLE public.creature (
                id_creature VARCHAR(50) NOT NULL,
                point_de_vie INTEGER NOT NULL,
                est_le_joueur BOOLEAN NOT NULL,
                position_x INTEGER NOT NULL,
                position_y INTEGER NOT NULL,
                id_monde VARCHAR(50) NOT NULL,
                id_humanoide VARCHAR,
                id_monstre VARCHAR(40),
                id_inventaire VARCHAR(40),
                CONSTRAINT pk_creature PRIMARY KEY (id_creature)
);


CREATE TABLE public.objet (
                id_objet VARCHAR(50) NOT NULL,
                position_x INTEGER,
                position_y INTEGER,
                id_monde VARCHAR(50) NOT NULL,
                id_inventaire VARCHAR(40),
                type_objet VARCHAR(15) NOT NULL,
                CONSTRAINT pk_objet PRIMARY KEY (id_objet)
);


CREATE TABLE public.joueur (
                nom_de_code VARCHAR(40) NOT NULL,
                mot_de_passe VARCHAR(40) NOT NULL,
                CONSTRAINT pk_joueur PRIMARY KEY (nom_de_code)
);


CREATE TABLE public.partie (
                id_partie VARCHAR(40) NOT NULL,
                id_monde_sauvegarde_rapide VARCHAR(50),
                id_monde_initial VARCHAR(50) NOT NULL,
                date_derniere_sauvegarde_rapide DATE,
                nom_de_code VARCHAR(40) NOT NULL,
                nom VARCHAR(30) NOT NULL,
                CONSTRAINT pk_partie PRIMARY KEY (id_partie)
);


CREATE TABLE public.sauvegarde (
                id_monde VARCHAR(50) NOT NULL,
                id_partie VARCHAR(40) NOT NULL,
                date DATE NOT NULL,
                nom VARCHAR(40) NOT NULL,
                CONSTRAINT pk_sauvegarde PRIMARY KEY (id_monde, id_partie)
);


ALTER TABLE public.objet ADD CONSTRAINT type_objet_objet_fk
FOREIGN KEY (type_objet)
REFERENCES public.type_objet (type_objet)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.monstre ADD CONSTRAINT type_monstre_monstre_fk
FOREIGN KEY (type_monstre)
REFERENCES public.type_monstre (type_monstre)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.humanoide ADD CONSTRAINT type_humanoide_humanoide_fk
FOREIGN KEY (type_humanoide)
REFERENCES public.type_humanoide (type_humanoide)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.objet ADD CONSTRAINT inventaire_objet_fk
FOREIGN KEY (id_inventaire)
REFERENCES public.inventaire (id_inventaire)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.creature ADD CONSTRAINT inventaire_creature_fk
FOREIGN KEY (id_inventaire)
REFERENCES public.inventaire (id_inventaire)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.creature ADD CONSTRAINT monstre_creature_fk
FOREIGN KEY (id_monstre)
REFERENCES public.monstre (id_monstre)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.creature ADD CONSTRAINT humanoide_creature_fk
FOREIGN KEY (id_humanoide)
REFERENCES public.humanoide (id_humanoide)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.partie ADD CONSTRAINT monde_partie_fk
FOREIGN KEY (id_monde_initial)
REFERENCES public.monde (id_monde)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.partie ADD CONSTRAINT monde_partie_fk1
FOREIGN KEY (id_monde_sauvegarde_rapide)
REFERENCES public.monde (id_monde)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.objet ADD CONSTRAINT monde_objet_fk
FOREIGN KEY (id_monde)
REFERENCES public.monde (id_monde)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.creature ADD CONSTRAINT monde_creature_fk
FOREIGN KEY (id_monde)
REFERENCES public.monde (id_monde)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.sauvegarde ADD CONSTRAINT monde_sauvegarde_fk
FOREIGN KEY (id_monde)
REFERENCES public.monde (id_monde)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.monde ADD CONSTRAINT creature_monde_fk
FOREIGN KEY (id_creature)
REFERENCES public.creature (id_creature)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.partie ADD CONSTRAINT joueur_partie_fk
FOREIGN KEY (nom_de_code)
REFERENCES public.joueur (nom_de_code)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.sauvegarde ADD CONSTRAINT partie_sauvegarde_fk
FOREIGN KEY (id_partie)
REFERENCES public.partie (id_partie)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;