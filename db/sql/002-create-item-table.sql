CREATE TABLE IF NOT EXISTS demoapi.item (
  id VARCHAR(36) PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  price double precision NOT NULL,
  user_id VARCHAR(36) NOT NULL
);

INSERT INTO demoapi.item (id, name, price, user_id) VALUES
    ('ac99dbf1-3f6c-4fc9-801e-aeb666e723aa', 'Item 1', 10.00, 'ac99dbf1-3f6c-4fc9-801e-aeb666e723da'),
    ('74b45ccb-57d8-4f04-be86-ff9423ea41bb', 'Item 2', 20.00, 'ac99dbf1-3f6c-4fc9-801e-aeb666e723da'),
    ('3f093674-a368-4a4c-b79f-dc2c4d5c9ccc', 'Item 3', 30.00, '74b45ccb-57d8-4f04-be86-ff9423ea411a'),
    ('3f093674-a368-4a4c-b79f-dc2c4d5c9cdd', 'Item 4', 40.00, '74b45ccb-57d8-4f04-be86-ff9423ea411a');