-- Begin the seeding script
BEGIN;

-- insert into currency
-- select *
-- from (
--          select 0, 'USD'
--          union
--          select 1, 'EUR'
--      ) x
-- where not exists(select * from currency);
-- Seed the currency with USD
insert into currency
(
 code
)
values
(
 'USD'
) ON CONFLICT DO NOTHING;

-- Seed the currency with EUR
insert into currency
(
    code
)
values
(
    'EUR'
) ON CONFLICT DO NOTHING;

-- Seed the customer
insert into customer
(
    name,
    customer_id,
    surname
)
VALUES
(
    'Amir',
    '1338508',
    'Bayan'
) ON CONFLICT DO NOTHING;

-- Seed the account
-- insert into account
-- (
--     account_number,
--     balance,
--     fk_currency_id,
--     fk_customer_id
-- )
-- VALUES
-- (
--     '13133850812345',
--     100,
--     (select id from currency where code = 'usd'),
--     (select id from customer where name = 'Amir')
-- ) ;

-- End the seeding script
COMMIT;