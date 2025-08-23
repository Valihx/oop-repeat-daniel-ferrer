CREATE DATABASE IF NOT EXISTS music_shop_db;

USE music_shop_db;

DROP TABLE IF EXISTS instruments;

CREATE TABLE instruments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(100),
    stock INT,
    price DOUBLE
);

INSERT INTO instruments (name, type, stock, price) VALUES ('Blue Electric Guitar', 'Guitar', 15, 799.99);
INSERT INTO instruments (name, type, stock, price) VALUES ('Red Electric Guitar', 'Guitar', 12, 1250.50);
INSERT INTO instruments (name, type, stock, price) VALUES ('88-Key Digital Piano', 'Keyboard', 25, 450.00);
INSERT INTO instruments (name, type, stock, price) VALUES ('61-Key Digital Piano', 'Keyboard', 42, 299.00);
INSERT INTO instruments (name, type, stock, price) VALUES ('5-Piece Electronic Drum Kit', 'Drums', 8, 699.95);
INSERT INTO instruments (name, type, stock, price) VALUES ('4-String Bass', 'Bass Guitar', 20, 199.99);
INSERT INTO instruments (name, type, stock, price) VALUES ('Noise-cancelling Microphone', 'Microphone', 50, 99.00);
INSERT INTO instruments (name, type, stock, price) VALUES ('USB Audio Interface', 'Audio Interface', 30, 159.50);
INSERT INTO instruments (name, type, stock, price) VALUES ('Nylon Strings Acoustic Guitar', 'Acoustic Guitar', 10, 2899.00);
INSERT INTO instruments (name, type, stock, price) VALUES ('Steel Strings Acoustic Guitar', 'Acoustic Guitar', 7, 3499.00);
INSERT INTO instruments (name, type, stock, price) VALUES ('Basic Synthesizer', 'Synthesizer', 18, 499.99);
INSERT INTO instruments (name, type, stock, price) VALUES ('Beginner Acoustic Drum Set', 'Drums', 7, 449.00);