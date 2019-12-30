
DROP TABLE IF EXISTS CURRENCY_TABLE;

CREATE TABLE CURRENCY_TABLE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  source_currency CHAR(3) NOT NULL,
  target_currency CHAR(3) NOT NULL,
  exchange_rate DECIMAL(9,6) DEFAULT 0.0
);

INSERT INTO CURRENCY_TABLE (source_currency, target_currency, exchange_rate) VALUES
  ('SGD', 'USD', 0.742164),
  ('USD', 'SGD', 1.34782);