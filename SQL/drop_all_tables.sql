-- drop all tables
-- Usage: psql -U postgres -d mydb -a -f drop_all_tables.sql

-- DO $$ DECLARE
--     r RECORD;
-- BEGIN
--     FOR r IN (SELECT tablename FROM pg_tables WHERE schemaname = current_schema()) LOOP
--         EXECUTE 'DROP TABLE IF EXISTS ' || quote_ident(r.tablename) || ' CASCADE';
--     END LOOP;
-- END $$;


DROP TABLE creature,humanoide,type_monstre,type_objet,monde,inventaire,joueur,monstre,objet,partie,sauvegarde,type_humanoide;