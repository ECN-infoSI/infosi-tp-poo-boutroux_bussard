DROP TABLE creature,humanoide,nomenclature_monstre,nomenclature_objet,monde,inventaire,joueur,monstre,objet,partie,sauvegarde,nomenclature_humanoide;


CREATE TABLE public.nomenclature_objet (
                type_objet VARCHAR(15) NOT NULL,
                CONSTRAINT pk_type_objet PRIMARY KEY (type_objet)
);


CREATE TABLE public.nomenclature_monstre (
                type_monstre VARCHAR(15) NOT NULL,
                CONSTRAINT pk_type_monstre PRIMARY KEY (type_monstre)
);


CREATE TABLE public.nomenclature_humanoide (
                type_humanoide VARCHAR(15) NOT NULL,
                CONSTRAINT pk_type_humanoide PRIMARY KEY (type_humanoide)
);


CREATE SEQUENCE public.inventaire_id_inventaire_seq;

CREATE TABLE public.inventaire (
                id_inventaire INTEGER NOT NULL DEFAULT nextval('public.inventaire_id_inventaire_seq'),
                CONSTRAINT pk_inventaire PRIMARY KEY (id_inventaire)
);


ALTER SEQUENCE public.inventaire_id_inventaire_seq OWNED BY public.inventaire.id_inventaire;

CREATE SEQUENCE public.monstre_id_monstre_seq;

CREATE TABLE public.monstre (
                id_monstre INTEGER NOT NULL DEFAULT nextval('public.monstre_id_monstre_seq'),
                page_esquive INTEGER NOT NULL,
                page_attaque_arme_naturelle INTEGER NOT NULL,
                pt_att_arme_naturelle INTEGER NOT NULL,
                type_monstre VARCHAR(15) NOT NULL,
                CONSTRAINT pk_monstre PRIMARY KEY (id_monstre)
);


ALTER SEQUENCE public.monstre_id_monstre_seq OWNED BY public.monstre.id_monstre;

CREATE SEQUENCE public.humanoide_id_humanoide_seq;

CREATE TABLE public.humanoide (
                id_humanoide INTEGER NOT NULL DEFAULT nextval('public.humanoide_id_humanoide_seq'),
                page_att_arme_poing INTEGER NOT NULL,
                page_par INTEGER NOT NULL,
                dist_att_max INTEGER NOT NULL,
                pt_degats_arme_poing INTEGER NOT NULL,
                nombre_de_fleche INTEGER,
                type_humanoide VARCHAR(15) NOT NULL,
                CONSTRAINT pk_humanoide PRIMARY KEY (id_humanoide)
);


ALTER SEQUENCE public.humanoide_id_humanoide_seq OWNED BY public.humanoide.id_humanoide;

CREATE SEQUENCE public.monde_id_monde_seq;

CREATE TABLE public.monde (
                id_monde INTEGER NOT NULL DEFAULT nextval('public.monde_id_monde_seq'),
                largeur INTEGER NOT NULL,
                longueur INTEGER NOT NULL,
                id_creature INTEGER,
                icone BYTEA,
                nom_personnage VARCHAR(15),
                CONSTRAINT pk_monde PRIMARY KEY (id_monde)
);


ALTER SEQUENCE public.monde_id_monde_seq OWNED BY public.monde.id_monde;

CREATE SEQUENCE public.creature_id_creature_seq;

CREATE TABLE public.creature (
                id_creature INTEGER NOT NULL DEFAULT nextval('public.creature_id_creature_seq'),
                point_de_vie INTEGER NOT NULL,
                est_male BOOLEAN NOT NULL,
                position_x INTEGER NOT NULL,
                position_y INTEGER NOT NULL,
                id_monde INTEGER NOT NULL,
                id_humanoide INTEGER,
                id_monstre INTEGER,
                id_inventaire INTEGER,
                CONSTRAINT pk_creature PRIMARY KEY (id_creature)
);


ALTER SEQUENCE public.creature_id_creature_seq OWNED BY public.creature.id_creature;

CREATE SEQUENCE public.objet_id_objet_seq;

CREATE TABLE public.objet (
                id_objet INTEGER NOT NULL DEFAULT nextval('public.objet_id_objet_seq'),
                position_x INTEGER,
                position_y INTEGER,
                id_monde INTEGER NOT NULL,
                id_inventaire INTEGER,
                type_objet VARCHAR(15) NOT NULL,
                CONSTRAINT pk_objet PRIMARY KEY (id_objet)
);


ALTER SEQUENCE public.objet_id_objet_seq OWNED BY public.objet.id_objet;

CREATE SEQUENCE public.joueur_id_joueur_seq;

CREATE TABLE public.joueur (
                id_joueur INTEGER NOT NULL DEFAULT nextval('public.joueur_id_joueur_seq'),
                nom_de_code VARCHAR(40) NOT NULL,
                mot_de_passe VARCHAR(40) NOT NULL,
                CONSTRAINT pk_joueur PRIMARY KEY (id_joueur)
);


ALTER SEQUENCE public.joueur_id_joueur_seq OWNED BY public.joueur.id_joueur;

CREATE SEQUENCE public.partie_id_partie_seq;

CREATE TABLE public.partie (
                id_partie INTEGER NOT NULL DEFAULT nextval('public.partie_id_partie_seq'),
                id_monde_sauvegarde_rapide INTEGER,
                id_monde_initial INTEGER,
                date_derniere_sauvegarde_rapide TIMESTAMP,
                nom VARCHAR(30) NOT NULL,
                id_joueur INTEGER NOT NULL,
                CONSTRAINT pk_partie PRIMARY KEY (id_partie)
);


ALTER SEQUENCE public.partie_id_partie_seq OWNED BY public.partie.id_partie;

CREATE TABLE public.sauvegarde (
                id_monde_sauvegarde INTEGER NOT NULL,
                id_partie INTEGER NOT NULL,
                date_sauvegarde TIMESTAMP NOT NULL,
                nom VARCHAR(40) NOT NULL,
                CONSTRAINT pk_sauvegarde PRIMARY KEY (id_monde_sauvegarde, id_partie)
);


ALTER TABLE public.objet ADD CONSTRAINT type_objet_objet_fk
FOREIGN KEY (type_objet)
REFERENCES public.nomenclature_objet (type_objet)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.monstre ADD CONSTRAINT type_monstre_monstre_fk
FOREIGN KEY (type_monstre)
REFERENCES public.nomenclature_monstre (type_monstre)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.humanoide ADD CONSTRAINT type_humanoide_humanoide_fk
FOREIGN KEY (type_humanoide)
REFERENCES public.nomenclature_humanoide (type_humanoide)
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
FOREIGN KEY (id_monde_sauvegarde)
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
FOREIGN KEY (id_joueur)
REFERENCES public.joueur (id_joueur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.sauvegarde ADD CONSTRAINT partie_sauvegarde_fk
FOREIGN KEY (id_partie)
REFERENCES public.partie (id_partie)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;