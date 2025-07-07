
CREATE TABLE session_tbl (
  user_token		VARCHAR(100),
  user_id			VARCHAR(20),
  create_date		DATETIME,
  expiration_date	DATETIME,
  PRIMARY KEY (user_token)
) DEFAULT CHARSET = UTF8;

SELECT * FROM session_tbl;
DESC session_tbl;
DROP TABLE session_tbl;