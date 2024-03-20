INSERT INTO USERS (id, address, name, user_role, success_orders, mobile_number, created_by, created_date, last_modified_by, last_modified_date, deleted)
VALUES (1, '123 Main St', 'John Doe', 'ADMIN', 10, '123-456-7890', 'admin', NOW(), 'admin', NOW(), false);

INSERT INTO COFFEESHOP (id, longitude, latitude, name, description, address, created_by, created_date, last_modified_by, last_modified_date, deleted)
VALUES (1, '123.456', '789.123', 'Coffee House', 'Best coffee in town', '456 Vietnam', 'admin', NOW(), 'admin', NOW(), false);

INSERT INTO MENUITEM (id, coffee_shop_id, size, price, created_by, created_date, last_modified_by, last_modified_date, deleted)
VALUES (1, 1, 'Regular', '2.50', 'admin', NOW(), 'admin', NOW(), false);

INSERT INTO ORDERS (id, quantity, menu_item_id, order_queue_id, order_time, order_state, user_id, created_by, created_date, last_modified_by, last_modified_date, deleted)
VALUES (1, 1, 1, 1, NOW(), 'INIT', 1, 'user1', NOW(), 'user1', NOW(), false);

INSERT INTO ORDERQUEUE (id, coffee_shop_id, capacity, name, priority, created_by, created_date, last_modified_by, last_modified_date, deleted)
VALUES (1, 1, 10, 'Regular Queue', 1, 'admin', NOW(), 'admin', NOW(), false);
