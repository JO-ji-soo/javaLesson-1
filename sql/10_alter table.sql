/*
 * 테이블 구조 변경 : alter table
 * 참고 : 오라클에서는 테이블,컬럼명 등 식별지 이름에 쓸 수 있는 기호 _ # $
 */


CREATE TABLE tbl# (
   col1 varchar2(30) CONSTRAINT tbl#_notnull1 NOT NULL,						--CONSTRAINT 제약조건이름 제약조건내용
   col2 varchar2(10) NOT NULL,  -- CONSTRAINT 키워드 생략 
   col3 varchar2(10),
   col4 number(3)
);   -- CREATE 는 1번만 실행합니다. 오라클 객체생성 이후 변경사항은 ALTER 명령으로.

INSERT INTO tbl#(col1) VALUES ('test1');  -- 오류 : 제약조건 위반
INSERT INTO tbl#(col1,col2) VALUES ('test1','test2');  --정상 실행

-- DML 중에서 insert, update,delete 를 했으면 변경 내용 확인
SELECT * FROM tbl#;

-- alter table   테이블명 [변경내용키워드]  (변경내용)  
-- [변경내용키워드]
-- 1) *컬럼 이름 변경 : rename column 
-- 2) 테이블 이름 변경 : rename to 
-- 3) *새로운 컬럼 추가 : add
-- 4) *컬럼 데이터 형식 변경 : modify
-- 5) *제약 조건 추가 : add constraint  
-- 6) 기존 컬럼 삭제 : drop
-- 7) *기존 제약 조건 삭제 : drop constraint 제약조건이름

-- 1) 컬럼 이름 변경                       현재이름  to 새로운 이름
ALTER TABLE tbl# RENAME COLUMN col2 TO col22;
ALTER TABLE tbl# RENAME COLUMN col22 TO col2;
SELECT * FROM TBL#;

-- 2) 아래 컬럼 추가하면 기존 row(행)들도 값이 추가된 컬럼5 의 값 100
ALTER TABLE tbl# ADD (column5 NUMBER(5) DEFAULT 100); -- 예 : 기본값 100
SELECT * FROM TBL#;

-- 2) 번 변경후에 데이터 추가합니다.
INSERT INTO tbl#(col1,col2) VALUES ('테스트11','테스트');
SELECT * FROM TBL#;
-- 오류 : col2 10바이트 초과 -> 한글 3바이트 그외 1바이트 
-- INSERT INTO tbl#(col1,col2) VALUES ('테스트11','테스트22');

-- 컬럼추가 : column6 가변문자열(20) 기본값 'guest' 로 변경해보세요.
ALTER  TABLE tbl# ADD (column6 VARCHAR(20) DEFAULT 'guest');
SELECT * FROM TBL#;
-- 아래 데이터 추가 후 확인
INSERT INTO tbl#(col1,col2) VALUES ('게스트1','게스트2');
SELECT * FROM TBL#;

-- 4) 기존 컬럼 형식 변경
ALTER TABLE tbl# MODIFY (col2 varchar2(50));
SELECT * FROM TBL#;
--col2 에 11바이트 데이터 insert
INSERT INTO tbl#(col1,col2) VALUES ('테스트11','테스트22');
SELECT * FROM TBL#;

-- 5) 제약조건 추가 : 기존에 저장된 데이터 때문에 오류가 생길 수 있는 내용입니다.
--    col3 기존 데이터 중 null 이 있으면 제약조건 위반하여 오류
ALTER TABLE tbl# ADD CONSTRAINT tbl#_notnull2 CHECK (col3 IS NOT NULL);
--    실행 ? or 오류? -> col4 기존데이터가 제약조건에 맞는 값이다. : 오류
ALTER TABLE tbl# ADD CONSTRAINT tbl#_notnull3 CHECK (col4 IS NOT NULL);

-- 7) 제약조건 제거 : 제약조건은 변경은 엇습니다. add와 drop만 있습니다.
ALTER TABLE tbl# DROP CONSTRAINT tbl#_notnull3;

-- 제약조건 키워드없는 not null 을 null로 변경할 때
ALTER TABLE tbl# MODIFY COL2 VARCHAR2(50) NULL;
SELECT * FROM TBL#;

-- col3 데이터 모두 채운 후에 실행확인 해보세요. null -> not null로 변경
ALTER TABLE tbl# MODIFY COL3 VARCHAR2(50) NOT NULL;
SELECT * FROM TBL#;

-- ((참고))테이블의 제약조건 이름 확인하기 : 오라클의 시스템 테이블
--SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS;


-- ** alter table 로 col1을 primary key로 변경하세요. (나중에는 alter table로 fk 추가도 할 수 있어야 합니다.)
ALTER TABLE "TBL#" MODIFY col1 varchar2(30) PRIMARY KEY;
ALTER TABLE "TBL#" MODIFY col1 PRIMARY KEY;

--기본키가 복합컬럼이라면 제약조건 추가 키워드 써야 합니다.
ALTER TABLE "TBL#" ADD CONSTRAINT tbl#_pk PRIMARY KEY (col1);