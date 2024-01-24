/* 수업 날짜 1월 18~19일
 * 
 * 
 * 제약 조건 constraint - 테이블에 저장되는 데이터가 '요구사항에 대한 부적절한 값'을 갖지 않도록 규정
 * 1) 반드시 값이 있어야 한다.  NULL 허용?
 * 2) 같은 값을 가질 수 없다.	 UNIQUE(유일한)
 * 3) 1~4 범위도로만 한다
 * ----------------------------------
 * 4) *****기본키 : 테이블의 행을 식별(구별) where 기본키컬럼=값; 조건실행 했을 때 1개의 행 조회됩니다.
 * 			 	  자동으로 인덱스로 생성이 됩니다. 인덱스는 검색(조회) 속도 향상시키는 방법입니다.
 * 			 	  기본키는 NOT NULL과 UNIQUE 2가지 제약조건에 해당합니다.
 * 			 	  기본키는 테이블에서 1개만 가능합니다. 단, 기본키를 구성하는 컬럼은 1개 이상(2개,3개...)가능합니다.
 * 5) 외래키 : 테이블 간의 참조를 위해서 사용합니다.
 * */

--제약조건 컬럼 레벨 설정하기
CREATE TABLE tbl_constr(  
	aname varchar2(20) NOT NULL,  --1)
	bname varchar2(20) UNIQUE,  --NULL 허용
	cno number(4) NOT NULL UNIQUE,
	dno number(4) CHECK (dno BETWEEN 1 AND 4)  --NULL 허용
	--eno number(4) --형식이 맞는 모든 데이터 허용.
);

INSERT INTO TBL_CONSTR (aname,cno) VALUES ('apple',3);  --필수 입력 컬럼
--1) 입력 오류 발생하는 경우 : unique 위반
--INSERT INTO TBL_CONSTR (aname,bname,cno) VALUES('apple','banana',3);  --cno 컬럼값  중복
INSERT INTO TBL_CONSTR (aname,bname,cno) values('apple','banana',4);  
--INSERT INTO TBL_CONSTR (aname,bname,cno) values('apple','banana',5);  --bname 컬럼값 중복

--2) 입력 오류 발생하는 경우 : not null 위반
--INSERT INTO TBL_CONSTR (cno) VALUES (3);

--3) 입력 오류 발생하는 경우 : check 위반
INSERT INTO TBL_CONSTR (aname,cno,dno) values('apple',7,3);  
INSERT INTO TBL_CONSTR (aname,cno,dno) values('apple',8,13); --값의 범위 1~4 아님 

SELECT * FROM TBL_CONSTR;

--단어장 테이블에 제약조건을 적용해서 다시 만들어 봅시다

DROP TABLE TBL_JAVAWORD;

/*
 * '단어장' 프로그램을 위한 테이블
 * 0. 테이블명 : tbl_JavaWord
 * 1. 테이블 구조											3.To do : 컬럼값들의 규칙 => 요구사항에 대한 제약조건
 * 			idx			number(8)						같은 값을 가질 수 없다. 반드시 값이 있어야 한다.
 * 			english		varchar2(100)					같은 값을 가질 수 없다. 반드시 값이 있어야 한다.
 * 			korean		nvarchar2(100)					반드시 값이 있어야 한다.
 * 			level		number(1)						반드시 값이 없는 null도 가능하다.1~4 범위도로만 한다.
 * 														
 * 			4.To do : 검색 속도를 향상시키기 위한 컬럼을 정해라.데이터형을 식별할 수 있는 컬럼을 정해라 (기본키 실행)
 *   
 * 2. 테이블에 행 추가 - 데이터 입력하기
 * 
 * ******오랔클의 키워드는 테이블명, 컬럼명으로 사용 못합니다.
 * */

CREATE TABLE tbl_JavaWord(
	idx  		number(8) PRIMARY KEY,					--UNIQUE 와 NOT NULL
	english 	varchar2(100) UNIQUE NOT NULL,
	korean  	nvarchar2(100) NOT NULL,
	step 		number(1) CHECK (step BETWEEN 1 AND 4) 	--CHECK() 괄호 필수
);

INSERT INTO TBL_JAVAWORD VALUES (1,'public','공용의',1);
INSERT INTO TBL_JAVAWORD VALUES (1,'private','사적인',1);
INSERT INTO TBL_JAVAWORD VALUES (2,'public','사적인',1);
INSERT INTO TBL_JAVAWORD VALUES (null,'public','사적인',1);














