BEGIN;
-- Create Customer Tables
CREATE TABLE IF NOT EXISTS customer(
                        id                serial PRIMARY KEY,
                        customer_id       VARCHAR(7) UNIQUE NOT NULL,
                        name              VARCHAR(50) NOT NULL,
                        surname           VARCHAR(50) NOT NULL
);
-- Create currency Tables
CREATE TABLE IF NOT EXISTS  currency(
                         id               serial PRIMARY KEY,
                         code             VARCHAR(3) UNIQUE NOT NULL
);
-- Create account Tables
CREATE TABLE IF NOT EXISTS  account(
                         id               serial PRIMARY KEY,
                         account_number   VARCHAR(50) UNIQUE NOT NULL,
                         balance          numeric,
                         fk_currency_id   integer references currency(id),
                         fk_customer_id   integer references customer(id)
);

COMMIT;
