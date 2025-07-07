
CREATE TABLE dvd_tbl (
  dvd_id				VARCHAR(10),
  dvd_name 				VARCHAR(20),
  dvd_unitPrice  		INT,
  dvd_author			VARCHAR(20),
  dvd_description 		TEXT,
  dvd_publisher 		VARCHAR(20),
  dvd_category 			VARCHAR(20),	
  dvd_unitsInStock 		LONG,
  dvd_releaseDate   	DATETIME,
  dvd_condition 		VARCHAR(20),
  dvd_thumbnailUrl		VARCHAR(100),
  PRIMARY KEY (dvd_id)
) DEFAULT CHARSET = UTF8;

SELECT * FROM dvd_tbl;
DESC dvd_tbl2;
DROP TABLE dvd_tbl;

INSERT INTO dvd_tbl VALUES('DVD1234', '나홀로집에', 7000, '크리스 콜롬버스','《나 홀로 집에》(영어: Home Alone)는 존 휴스가 창시한 일련의 미국 크리스마스 가족 코미디 영화 시리즈 및 관련 프랜차이즈이다. 아이들이 연말연시에 혼자 집에 남아 도둑이나 범죄자들로부터 집을 지키는 것이 주내용이다.', 
'MBC아카데미', '코미디', 1000,  '1990/11/16', 'old', 'DVD1234.jpg');
INSERT INTO dvd_tbl VALUES('DVD1235', '에일리언', 7000, '리들리 스콧', '리들리 스콧의 1979년 영화로 에이리언 시리즈의 첫 번째 작품이다. H. R. 기거의 미술을 바탕으로 미지의 외계 생명체와의 사투를 그로테스크하게 그린 이 작품은 외계인이 등장하는 영화 장르, 더 나아가 SF 호러에 지대한 영향을 주었다. 아카데미 시각 효과상을 수상했고 미국 의회도서관 영구 보존작이다. 로저 이버트의 위대한 영화 리스트도 올랐다.', 
'MBC아카데미', '스릴러', 1000, '2017/05/09', 'old', 'DVD1235.jpg');
INSERT INTO dvd_tbl VALUES('DVD1236', '집으로', 4000, '이정향', '충청북도 영동군 상촌면의 산골짜기 부락인 《지통마》라는 곳을 무대 겸 극 중 배경으로 하여, 여름 동안 시골 할머니(김을분 역)의 집에 맡겨진 어린 외손자 상우(유승호 역)의 이야기를 다루고 있다. 상우가 할머니의 집에서 말썽을 피우다가 할머니와 공감을 가지게 되는 과정을 잔잔하게 잘 담아냈다. 할머니가 상우와 헤어지고 다시 고개를 넘어 집으로 돌아가는 마지막 장면이 눈물을 자아낸다. 이 장면에서 BGM은 굉장히 슬퍼지는 장면에 어울리지 않는 밝은 BGM을 틀어놔 상당한 괴리감을 느끼게 해준다.', 
'MBC아카데미', '가족영화', 1000, '2002/04/05', 'old', 'DVD1236.jpg');
