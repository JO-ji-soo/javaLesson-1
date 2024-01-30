-- 프로시저 복습하기 위한 테이블. tbl_buy 복사
CREATE TABLE p_buy
AS
SELECT * FROM TBL_BUY tb ;

SELECT * FROM p_buy;

-- 실행을 위해서 시퀀스 생성, money 컬럼 추가
CREATE SEQUENCE pbuy_seq START WITH 1500;

ALTER TABLE p_buy ADD money number(7) CHECK (money >=10000);		--money = 수량*가격 , 수량*가격으로 총 구매금액 컬럼.

-- 웹애플리케이션(인터넷 환경) 개발할 때, ※ JDBC 에서 사용자가 원하는 기능 요청을 서버에 보낼 때, 한번에 sql을 1개씩만 실행을 합니다.
--					   		    ※ 프로시저를 이용하면 요청 한번에 대해 많은 SQL을 실행을 할수 있습니다.
-- JDBC : Java DataBase Connection. 자바와 db(오라클,mysql 등등)를 연결하는 프로토콜(규칙).
-- 데이베이스관점에는 `무결성`(정확성) 을 유지할 수 있는 방법.

-- 프로시저에서 트잰잭션을 관리하는 예시 : 최소구매 금액 10000 미만이면 트랜잭션을 롤백.
CREATE OR REPLACE PROCEDURE "C##IDEV".proc_set_money(	  
	acustom_id IN varchar2, --  회원ID		-- 입력 매개변수 IN
	apcode IN varchar2, 	-- 상품코드
	acnt IN NUMBER , 		-- 수량
	isSuccess OUT varchar2  -- 출력 매개변수 OUT. 트랜잭션 처리 성공여부 저장.
)
IS 
	vseq NUMBER;	--변수선언
	vprice NUMBER;
BEGIN 
	INSERT INTO p_buy(buy_idx,CUSTOMID,PCODE,QUANTITY,BUY_DATE)
		values (pbuy_seq.nextval, acustom_id,apcode,acnt,sysdate);	-- 매개변수값으로 insert
	SELECT pbuy_seq.currval 		-- 방금 insert 한 현재 시퀀스 값 조회
		INTO vseq
		FROM dual;
	dbms_output.put_line('방금 insert 한 현재 시퀀스 값 : ' || vseq);	
	SELECT price 
		INTO vprice 
		FROM tbl_product tp WHERE pcode=apcode;		-- 상품코드에 대한 가격 조회
	dbms_output.put_line('방금 insert 한 상품의 가격 : ' || vprice);	
	UPDATE p_buy SET money = vprice * QUANTITY 
		WHERE BUY_IDX = vseq;						-- 위 INSERT 한 데이터로 가격*수량 수식 구해서 money 컬럼값 수정
	dbms_output.put_line('실행성공');					--가격*수량 값이 10000원 이상일 때만 성공
	isSuccess :='success';							-- 프로시저에서 일반변수 대입문 기호 :=
	commit ;
	EXCEPTION 			-- EXCEPTION 추가하여 처리 -> 메시지 출력, rollback 
		WHEN OTHERS THEN 
		dbms_output.put_line('실행 실패');				--가격*수량 값이 10000원 미만은 실패
		rollback ;		-- 오류가 발생한 sql 앞의 insert,update,delete를 취소.
		isSuccess :='fail';
END;



-- 실행 예시
DECLARE 
	vresult varchar2(20);
BEGIN
--  메세지는 'fail' 이고 p_buy테이블 insert 입력값 없어야 합니다.
--	proc_set_money('twice','SNACK99',1,VRESULT); 

--  메세지는 'success' 이고 p_buy테이블에 값이 insert 됩니다.	
	proc_set_money('mina012','SNACK99',3,VRESULT); 

	dbms_output.put_line('결과 : ' || vresult );
END;

