-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'dig_it';

DROP DATABASE dig_it;

DROP USER dig_it_owner;
DROP USER dig_it_appuser;
