/*
	프로시저 직접 만들어보기 : money_of_day
	매개변수 IN  : 고객ID , 날짜(패턴은 'yyyy-mm-dd')
	매개변수 OUT : IN으로 받은 값들을 tbl_buy에서 상품코드를 조회하여 '총 구매 금액'을 구합니다. 
	
			 *** 단, 고객은 1일 1품목만 구매 가능합니다. ***

	프로시저 실행
	
	DECLEAR
		vmoney number(8);
	BEGIN
		money_of_day('mina012','2023-11-10',vmoney)
		dbms_output.put_line('고객님의 구매 금액은' || vmoney || '입니다.');
	END;
	
	1) 고객ID, 날짜 값으로 구매 테이블에서 수량과 pcode 조회하고 변수에 저장하기
	2) 1)에서 구한 pcode의 가격을 조회하여 저장하기
	3) 2)번 가격과 1)번 수랴을 곱하기 하여 결과값을 변수에 저장 => 출력 변수
	   곱셈 수식만 계산할 때에는 dual 임시 테이블로 합니다.
*/

CREATE OR REPLACE PROCEDURE "C##IDEV".money_of_day(
	vid IN varchar2, 			--고객ID
	vdate IN varchar2,			--날짜
	vtotal_money OUT NUMBER
)
IS 
    vpcode VARCHAR;
    vquantity NUMBER;
    vprice NUMBER;
BEGIN
	-- 1) 고객ID와 날짜로부터 상품코드와 수량 조회
	SELECT PCODE, QUANTITY
	INTO vpcode,vquantity
	FROM TBL_BUY
	WHERE CUSTOMID = vid AND TO_CHAR(BUY_DATE,'yyyy-mm-dd')=vdate;

    -- 2) 상품코드로부터 해당 상품의 가격 조회
	SELECT PRICE 
	INTO vprice
	FROM TBL_PRODUCT tp 
	WHERE PCODE = vpcode
	
	-- 3) 총 구매 금액 계산 , 출력매개변수에 저장하기
	SELECT vprice*vquantity
	INTO vtotal_money
	FROM DUAL;
	
	

END;


	DECLARE
		vmoney number(8);
		vid varchar2 (20);
		vdate varchar2 (20);
	BEGIN
		vid : ='mina012';
		vdate : ='2023-11-10';
		money_of_day(vid,vdate,vmoney);
		dbms_output.put_line(CHR(10) || '고객ID:'||vid||'날짜:'||vdate);	
		dbms_output.put_line('고객님의 구매금액은' || vmoney ||'입니다.');
	END;
	















