BEGIN;
-- Create Customer Tables
CREATE TABLE customer(
                        id                serial PRIMARY KEY,
                        name              VARCHAR(50) UNIQUE NOT NULL,
                        surname           VARCHAR(256) NOT NULL
);
-- Create currency Tables
CREATE TABLE currency(
                         id               serial PRIMARY KEY,
                         code             VARCHAR(3) UNIQUE NOT NULL
);
-- Create account Tables
CREATE TABLE account(
                         id               serial PRIMARY KEY,
                         account_number   VARCHAR(50) UNIQUE NOT NULL,
                         balance          numeric,
                         fk_currency_id   integer references currency(id),
                         fk_customer_id   integer references customer(id)
);

COMMIT;