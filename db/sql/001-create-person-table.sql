CREATE TABLE IF NOT EXISTS demoapi.person (
    id VARCHAR(36)  PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

INSERT INTO demoapi.person (id, name) VALUES
    ('ac99dbf1-3f6c-4fc9-801e-aeb666e723da', 'John Doe'),
    ('74b45ccb-57d8-4f04-be86-ff9423ea411a', 'Adam Smith'),
    ('3f093674-a368-4a4c-b79f-dc2c4d5c9c35', 'Anna Fleming');