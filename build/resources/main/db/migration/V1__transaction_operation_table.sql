CREATE TABLE IF NOT EXISTS transaction_operation
(
    id             UUID             NOT NULL PRIMARY KEY,
    account_id     UUID             NOT NULL,
    operation_type VARCHAR(10)      NOT NULL,
    amount         DOUBLE PRECISION NOT NULL
);