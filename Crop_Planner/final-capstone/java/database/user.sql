-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER dig_it_owner
WITH PASSWORD 'digit';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO dig_it_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO dig_it_owner;

CREATE USER dig_it_appuser
WITH PASSWORD 'digit';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO dig_it_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO dig_it_appuser;
