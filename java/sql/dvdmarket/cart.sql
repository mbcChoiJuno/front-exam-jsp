
CREATE TABLE cart_tbl (
  user_id		VARCHAR(20),
  dvd_id		VARCHAR(10),
  dvd_count		INT,
  PRIMARY KEY (user_id, dvd_id)
) DEFAULT CHARSET = UTF8;

SELECT * FROM cart_tbl;
DESC cart_tbl;
DROP TABLE cart_tbl;
