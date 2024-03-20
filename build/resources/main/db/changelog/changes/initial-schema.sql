CREATE TABLE IF NOT EXISTS USERS (
    id INT PRIMARY KEY,
    address VARCHAR,
    name VARCHAR,
    user_role VARCHAR,
    success_orders INT,
    mobile_number VARCHAR,
    created_by VARCHAR(255),
    created_date TIMESTAMP,
    last_modified_by VARCHAR(255),
    last_modified_date TIMESTAMP,
    deleted BOOLEAN
);

CREATE TABLE IF NOT EXISTS COFFEESHOP (
    id INT PRIMARY KEY,
    longitude VARCHAR(255),
    latitude VARCHAR(255),
    name VARCHAR(255),
    description VARCHAR(255),
    address VARCHAR(255),
    created_by VARCHAR(255),
    created_date TIMESTAMP,
    last_modified_by VARCHAR(255),
    last_modified_date TIMESTAMP,
    deleted BOOLEAN
);

CREATE TABLE IF NOT EXISTS MENUITEM (
    id INT PRIMARY KEY,
    coffee_shop_id INT,
    size VARCHAR(255),
    price VARCHAR(255),
    created_by VARCHAR(255),
    created_date TIMESTAMP,
    last_modified_by VARCHAR(255),
    last_modified_date TIMESTAMP,
    deleted BOOLEAN
);

CREATE TABLE IF NOT EXISTS ORDERS (
    id INT PRIMARY KEY,
    quantity INT,
    menu_item_id INT,
    order_queue_id INT,
    order_time TIMESTAMP,
    order_state VARCHAR(255),
    user_id INT,
    created_by VARCHAR(255),
    created_date TIMESTAMP,
    last_modified_by VARCHAR(255),
    last_modified_date TIMESTAMP,
    deleted BOOLEAN
);

CREATE TABLE IF NOT EXISTS ORDERQUEUE (
    id INT PRIMARY KEY,
    coffee_shop_id INT,
    capacity INT,
    name VARCHAR(255),
    priority INT,
    created_by VARCHAR(255),
    created_date TIMESTAMP,
    last_modified_by VARCHAR(255),
    last_modified_date TIMESTAMP,
    deleted BOOLEAN
);