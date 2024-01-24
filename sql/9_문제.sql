### 데이터베이스 구축 시나리오

(1월 19일)

식료품을 판매하는 매장의 판매 관리를 위한 시스템을 구축합니다. 이 쇼핑몰에서 `고객` 은  필요한 `상품`을
`구매`할 수 있습니다. 고객은 회원가입 후 상품을 구매할 수 있습니다. 
+ `회원` 은  고유ID , 이름, 이메일, 나이 , 가압날짜로 관리하며
  + PK
  
  CREATE TABLE TBL_CUSTOMER(
    id char(10) PRIMARY KEY,    	
	name varchar(20) NOT NULL,   	
	email varchar(100),  			
	age number(2) NOT NULL,
	join_date DATE DEFAULT sysdate
);

--+ `상품` 은  상품코드, 카테고리, 상품명, 가격이 필요합니다.
  --+ PK
 
CREATE TABLE TBL_EXPRODUCT (
   pdcode varchar(10)PRIMARY KEY,
   category char(5),
   pdname nvarchar2(30) NOT NULL,
   price number(10) NOT NULL
);
  
--+ `구매` 는  상품을 구매한 회원의 고유ID, 상품코드 , 구매수량, 구매날짜를 저장하여 관리합니다. 
 -- + FK
  
CREATE TABLE TBL_EXBUY(
   id char(10),
   pdcode varchar(16) NOT NULL,
   pdcount number(16) NOT NULL,
   buy_date DATE DEFAULT sysdate,
	FOREIGN KEY(id)
   REFERENCES 
			tbl_customer(id),
	FOREIGN KEY
			(pdcode) 		
	REFERENCES 
			tbl_exproduct(pdcode)
 );
    
--+ 회원 예시 데이터

INSERT INTO TBL_CUSTOMER(id,name,email,age,join_date) 
	VALUES('mina012', '김미나', 'kimm@gmail.com', 20, to_date('2022-03-10 14:23:25','yyyy-mm-dd hh24:mi:ss'));

INSERT INTO TBL_CUSTOMER(id,name,email,age,join_date)      
VALUES('hongGD', '홍길동', 'gil@korea.com', 32, to_date('2021-10-21 11:12:23','yyyy-mm-dd hh24:mi:ss'));

INSERT INTO TBL_CUSTOMER(id,name,email,age,join_date) 
VALUES('twice', '박모모', 'momo@daum.net', 29, to_date('2021-12-25 19:23:45','yyyy-mm-dd hh24:mi:ss'));

INSERT INTO TBL_CUSTOMER(id,name,email,age,join_date) 
VALUES('wonder', '이나나', 'lee@naver.com', 40, to_date(sysdate,'yyyy-mm-dd hh24:mi:ss'));

--+ 상품 예시 데이터
INSERT INTO TBL_EXPRODUCT(pdcode,category,pdname,price)
VALUES('DOWON123a', 'B2', '동원참치선물세트', 54000);

INSERT INTO TBL_EXPRODUCT(pdcode,category,pdname,price)
VALUES('CJBAb12g', 'B1', '햇반 12개입', 14500);

INSERT INTO TBL_EXPRODUCT(pdcode,category,pdname,price)
VALUES('JINRMn5', 'B1', '진라면 5개입', 6350);

INSERT INTO TBL_EXPRODUCT(pdcode,category,pdname,price)
VALUES('APLE5kg', 'A1', '청송사과 5kg', 66000);
        
INSERT INTO TBL_EXPRODUCT(pdcode,category,pdname,price)
VALUES('MANGOTK4r', 'A2', '애플망고 1kg', 32000);


--+ 구매
INSERT INTO TBL_EXBUY(id,pdcode,pdcount,buy_date)
VALUES('mina012' , 'CJBAb12g' , 5 , to_date('2022-03-10 14:33:15','yyyy-mm-dd hh24:mi:ss'));

INSERT INTO TBL_EXBUY(id,pdcode,pdcount,buy_date)
VALUES('mina012' , 'APLE5kg' , 2 , to_date('2022-03-10 14:33:15','yyyy-mm-dd hh24:mi:ss'));

INSERT INTO TBL_EXBUY(id,pdcode,pdcount,buy_date)
VALUES('mina012' , 'JINRMn5' , 2 , to_date('2022-03-16 10:13:15','yyyy-mm-dd hh24:mi:ss'));

INSERT INTO TBL_EXBUY(id,pdcode,pdcount,buy_date)
VALUES('twice' , 'JINRMn5' , 3 , to_date('2021-12-25 19:32:15','yyyy-mm-dd hh24:mi:ss'));

INSERT INTO TBL_EXBUY(id,pdcode,pdcount,buy_date)
VALUES('twice' , 'MANGOTK4r' , 2 , to_date('2021-12-25 19:32:15','yyyy-mm-dd hh24:mi:ss'));

INSERT INTO TBL_EXBUY(id,pdcode,pdcount,buy_date)
VALUES('hongGD' , 'DOWON123a' , 1 , to_date('2021-10-21 11:13:25','yyyy-mm-dd hh24:mi:ss'));

INSERT INTO TBL_EXBUY(id,pdcode,pdcount,buy_date)
VALUES('hongGD' , 'APLE5kg' , 1 , to_date('2021-10-21 11:13:25','yyyy-mm-dd hh24:mi:ss'));
    
-- + 테이블 이름은  excustomer,exproduct, exbuy 로 각각하고 
-- 컬럼은 적합한 이름과 형식,제약조건을 정해서 하세요.
 
 
SELECT * FROM  TBL_CUSTOMER tc  ORDER BY NAME DESC;
SELECT pdcode, SUM(pdcount) AS PC FROM TBL_EXBUY GROUP BY pdcode ORDER BY PC DESC;
SELECT * FROM TBL_EXBUY WHERE ID='twice';
SELECT TO_DATE(SYSDATE,'YYYY-MM-DD')-TO_DATE(join_date,'YYYY-MM-DD')
						FROM TBL_CUSTOMER WHERE CUSTOMER_id ='mina012';
SELECT CATEGORY, COUNT(*) FROM TBL_EXPRODUCT GROUP BY CATEGORY;
SELECT * FROM TBL_CUSTOMER  WHERE email LIKE '%gmail%';

--날짜값 조건 예시 - 가입년도가 2022년인 회원
SELECT * FROM TBL_CUSTOMER WHERE  TO_CHAR(JOIN_DATE,'yyyy')='2022';

--구매 테이블에 기본키 만들기

--0) 기본키가 필요한 이유 : 행 식별

--1) 기본키에 들어갈 값은 시퀀스로 만듭니다. exbuy_pk_seq 시작값은 1001로 합시다.
CREATE SEQUENCE EXBUY_PK_SEQ START WITH 2001;

--2) 기본키 컬럼명을 buy_idx로 하여 컬럼추가. number(8) 					==오류
ALTER TABLE TBL_EXBUY ADD buy_idx number(8);

--3) 기본 행에 적용할 buy_idx 컬럼값을 저장하기. not null 과 unique 적용하여 설정하기
--      		디비버의 GUI 메뉴에서 합니다.

--4) buy_idx 컬럼에 ㄷ ㅐ해 primary 키 설정하기
ARTER TABLE TBL_EXBUY ADD CONSTRAINT TBL_EXBUY_PK PRIMARY KEY (buy_idx);

--5) 이제부터 새로운 행을 추가할 때에는 시퀀스 함수로 pk값을 insert합니다.
INSERT INTO TBL_EXBUY (buy_idx,id,pdcode,pdcount)
	VALUES (exbuy_pk_seq.nextval,'mina012','CJBAb12g',5);
SELECT * FROM TBL_EXBUY te ;

