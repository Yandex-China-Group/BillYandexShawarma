-- Пользователь
CREATE TABLE IF NOT EXISTS "users" (
    "id" BIGSERIAL NOT NULL PRIMARY KEY,
    "first_name" VARCHAR(255) NOT NULL,
    "last_name" VARCHAR(255) NOT NULL,
    "surname" VARCHAR(255) NOT NULL,
    "screen_name" VARCHAR(255) NOT NULL,
    "login" VARCHAR(255) NOT NULL,
    "password" VARCHAR(255) NOT NULL
);

-- Банковский счет
CREATE TABLE IF NOT EXISTS "bills" (
    "id" BIGSERIAL NOT NULL PRIMARY KEY,
    "owner_id" BIGINT NOT NULL REFERENCES "users" ("id"),
    "created_at" TIMESTAMP NOT NULL,
    "title" VARCHAR(255) NOT NULL,
    "note" TEXT NOT NULL
);

-- Контекст юзера с его настройками
CREATE TABLE IF NOT EXISTS "users_context" (
    "user_id" BIGINT NOT NULL REFERENCES "users" ("id") PRIMARY KEY,
    "budget_limit_month" NUMERIC(10, 2) NOT NULL,
    "balance_limit_day" NUMERIC(10, 2) NOT NULL
);

-- Типы транзакций
CREATE TABLE IF NOT EXISTS "transaction_types" (
    "name" VARCHAR(255) NOT NULL UNIQUE PRIMARY KEY
);

-- Категории оплат
CREATE TABLE IF NOT EXISTS "payment_categories" (
    "name" VARCHAR(255) NOT NULL UNIQUE PRIMARY KEY
);

-- Банковские операции (транзакции)
CREATE TABLE IF NOT EXISTS "transactions" (
    "id" BIGSERIAL NOT NULL PRIMARY KEY,
    "transaction_type_name" VARCHAR(255) NOT NULL REFERENCES "transaction_types" ("name"),
    "payment_category_name" VARCHAR(255) NOT NULL REFERENCES "payment_categories" ("name"),
    "created_at" TIMESTAMP NOT NULL,
    "amount" NUMERIC(10, 2) NOT NULL,
    "bill_id" BIGINT NOT NULL REFERENCES "bills" ("id")
);

-- Цели пользователя
CREATE TABLE IF NOT EXISTS "goals" (
    "id" BIGSERIAL NOT NULL PRIMARY KEY,
    "user_id" BIGINT NOT NULL REFERENCES "users" ("id"),
    "active" BOOLEAN NOT NULL,
    "title" VARCHAR(255) NOT NULL,
    "category_name" VARCHAR(255) NOT NULL REFERENCES "payment_categories" ("name"),
    "description" TEXT NOT NULL,
    "created_at" TIMESTAMP NOT NULL,
    "end_at" TIMESTAMP NOT NULL,
    "spending_limit" NUMERIC(10, 2) NOT NULL
)

