-- 테이블 삭제

DROP TABLE tbl_menu;
DROP TABLE tbl_place_address;
DROP TABLE tbl_place;
DROP TABLE tbl_area_unit;

DROP SEQUENCE place_seq;
DROP SEQUENCE address_seq;
DROP SEQUENCE menu_seq;

-- 가게 정보 테이블
CREATE TABLE tbl_place(
	 place_seq number(8) PRIMARY KEY,
	 name varchar2(100) NOT NULL,
	 phone varchar2(100),
	 rate NUMBER(3,2),
	 open_time varchar2(50) NOT NULL,
	 close_time varchar2(50) NOT NULL,
	 food_type  varchar2(50)	 
);

-- 시퀀스 생성
CREATE SEQUENCE place_seq;

-- 샘플테이터 생성
INSERT INTO tbl_place tp
VALUES (place_seq.nextval, '닭치고낙곱새 현풍직영점', '0507-1346-8818', 4.5, '11:30', '22:00', '한식');


SELECT * FROM tbl_place;


-- 기본 주소록 테이블
CREATE TABLE tbl_place_address (
	address_seq number(8) PRIMARY KEY,  
	address varchar2(500) NOT NULL,
	place_seq NUMBER(8) NOT NULL,
	FOREIGN KEY (place_seq)				
			REFERENCES tbl_place(place_seq)
);

INSERT INTO tbl_place_address tp
VALUES (place_seq.nextval, '닭치고낙곱새 현풍직영점', '0507-1346-8818', 4.5, '11:30', '22:00', '한식');

-- 시퀀스 생성
CREATE SEQUENCE address_seq;

-- 메뉴 정보 테이블
CREATE TABLE tbl_menu (
	menu_seq number(8) PRIMARY KEY ,
	place_seq number(8) NOT NULL,
	menu_name varchar2(100) NOT NULL ,	
	price number(8) NOT NULL,
	FOREIGN KEY (place_seq)				
			REFERENCES tbl_place(place_seq)
);

-- 시퀀스 생성
CREATE SEQUENCE menu_seq;

-- 샘플 데이터 생성

-- 지역 테이블 
CREATE TABLE tbl_area_unit (
	area_unit_code number(8) PRIMARY KEY,  
	unit_name varchar2(50) NOT NULL
);






































