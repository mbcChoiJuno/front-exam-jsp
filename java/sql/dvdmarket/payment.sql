 
CREATE TABLE payment_tbl (
  payment_num	INT AUTO_INCREMENT,
  user_id		VARCHAR(20),
  amount		INT,
  PRIMARY KEY (payment_num)
) DEFAULT CHARSET = UTF8;

