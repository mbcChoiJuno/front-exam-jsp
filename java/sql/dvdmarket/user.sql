USE DVDMarketDB;

CREATE TABLE user_tbl_old (
  user_id			VARCHAR(20),
  user_pw			VARCHAR(20),
  user_name			VARCHAR(10),
  user_gender		VARCHAR(4),
  user_birth		VARCHAR(10),
  user_email		VARCHAR(30),
  user_phone		VARCHAR(20),
  user_address		VARCHAR(100),
  user_registdate	DATETIME,
  is_admin			INT,
  auth_token		TEXT,
  PRIMARY KEY (user_id)
) DEFAULT CHARSET = UTF8;

SELECT * FROM user_tbl_old;
DESC user_tbl_old;
DROP TABLE user_tbl_old;

INSERT INTO user_tbl_old VALUES ("testuser1", "1234", "테스트1", "남", "1993/04/20", 
	"testuser1@test.com", "010-1234-5678", "병점동", NOW(), 0, null);
	
INSERT INTO user_tbl_old VALUES ("testuser2", "1234", "테스트2", "남", "1993/04/20", 
	"testuser2@test.com", "010-2222-2222", "병점동", NOW(), 0, null);
	
INSERT INTO user_tbl_old VALUES ("testuser3", "1234", "테스트3", "남", "1993/04/20", 
	"testuser3@test.com", "010-3333-3333", "병점동", NOW(), 0, null);
	
	
INSERT INTO user_tbl_old VALUES ("admin", "1234", "관리자", "남", "1993/04/20", 
	"testuser1@test.com", "010-1234-5678", "MBC아카데미", NOW(), 1, null);
