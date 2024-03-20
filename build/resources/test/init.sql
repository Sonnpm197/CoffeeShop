CREATE TABLE USERS
(
    id                 INT PRIMARY KEY,
    address            VARCHAR,
    name               VARCHAR,
    user_role          VARCHAR,
    success_orders     INT,
    mobile_number      VARCHAR,
    created_by         VARCHAR(255),
    created_date       TIMESTAMP,
    last_modified_by   VARCHAR(255),
    last_modified_date TIMESTAMP,
    deleted            BOOLEAN
);

CREATE TABLE COFFEESHOP
(
    id                 INT PRIMARY KEY,
    longitude          VARCHAR(255),
    latitude           VARCHAR(255),
    name               VARCHAR(255),
    description        VARCHAR(255),
    address            VARCHAR(255),
    created_by         VARCHAR(255),
    created_date       TIMESTAMP,
    last_modified_by   VARCHAR(255),
    last_modified_date TIMESTAMP,
    deleted            BOOLEAN
);

CREATE TABLE MENUITEM
(
    id                 INT PRIMARY KEY,
    coffee_shop_id     LONG,
    size               VARCHAR(255),
    price              VARCHAR(255),
    created_by         VARCHAR(255),
    created_date       TIMESTAMP,
    last_modified_by   VARCHAR(255),
    last_modified_date TIMESTAMP,
    deleted            BOOLEAN
);

CREATE TABLE ORDERS
(
    id                 INT PRIMARY KEY,
    quantity           INT,
    menu_item_id       LONG,
    order_queue_id     LONG,
    order_time         TIMESTAMP,
    order_state        VARCHAR(255),
    user_id            LONG,
    created_by         VARCHAR(255),
    created_date       TIMESTAMP,
    last_modified_by   VARCHAR(255),
    last_modified_date TIMESTAMP,
    deleted            BOOLEAN
);

CREATE TABLE IF NOT EXISTS ORDERQUEUE
(
    id                 INT PRIMARY KEY,
    coffee_shop_id     LONG,
    capacity           INT,
    name               VARCHAR(255),
    priority           INT,
    created_by         VARCHAR(255),
    created_date       TIMESTAMP,
    last_modified_by   VARCHAR(255),
    last_modified_date TIMESTAMP,
    deleted            BOOLEAN
);