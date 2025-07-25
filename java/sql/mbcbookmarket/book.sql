
USE BookMarketDB;

CREATE TABLE IF NOT EXISTS book(
	b_id VARCHAR(10) NOT NULL,
	b_name VARCHAR(20),
	b_unitPrice  INTEGER,
	b_author VARCHAR(20),
	b_description TEXT,
	b_publisher VARCHAR(20),
   	b_category VARCHAR(20),	
	b_unitsInStock LONG,
	b_releaseDate   VARCHAR(20),
	b_condition VARCHAR(20),
	b_fileName  VARCHAR(20),
	PRIMARY KEY (b_id)
)default CHARSET=utf8;

desc book;

DROP TABLE book;

INSERT INTO book VALUES('ISBN1234', 'C# 프로그래밍', 27000, '우재남','C#을 처음 접하는 독자를 대상으로 일대일 수업처럼 자세히 설명한 책이다. 꼭 알아야 할 핵심 개념은 기본 예제로 최대한 쉽게 설명했으며, 중요한 내용은 응용 예제, 퀴즈, 셀프 스터디, 예제 모음으로 한번 더 복습할 수 있다.', '한빛아카데미', 'IT모바일', 1000,  '2022/10/06', 'new', 'ISBN1234.jpg');
INSERT INTO book VALUES('ISBN1235', '자바마스터', 30000, '송미영', '자바를 처음 배우는 학생을 위해 자바의 기본 개념과 실습 예제를 그림을 이용하여 쉽게 설명합니다. 자바의 이론적 개념→기본 예제→프로젝트 순으로 단계별 학습이 가능하며, 각 챕터의 프로젝트를 실습하면서 온라인 서점을 완성할 수 있도록 구성하였습니다.', '한빛아카데미', 'IT모바일',1000, '2023/01/01', 'new', 'ISBN1235.jpg');
INSERT INTO book VALUES('ISBN1236', '파이썬 프로그래밍', 30000, '최성철', '파이썬으로 프로그래밍을 시작하는 입문자가 쉽게 이해할 수 있도록 기본 개념을 상세하게 설명하며, 다양한 예제를 제시합니다. 또한 프로그래밍의 기초 원리를 이해하면서 파이썬으로 데이터를 처리하는 기법도 배웁니다.', '한빛아카데미', 'IT모바일', 1000, '2023/01/01', 'new', 'ISBN1236.jpg');

select * from book;