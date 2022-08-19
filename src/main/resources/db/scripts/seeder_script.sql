-- Begin the seeding script
BEGIN;
-- Seed the currency with USD
insert into currency
(
 code
)
values
(
 'USD'
);

-- Seed the currency with EUR
insert into currency
(
    code
)
values
(
    'EUR'
);

-- Seed the customer
insert into customer
(
    name,
    surname
)
VALUES
(
    'Amir',
    'Bayan'
);

-- Seed the account
insert into account
(
    account_number,
    balance,
    fk_currency_id,
    fk_customer_id
)
VALUES
(
    '13133850812345',
    100,
    (select id from currency where code = 'usd'),
    (select id from customer where name = 'Amir')
) ;

-- End the seeding script
COMMIT;