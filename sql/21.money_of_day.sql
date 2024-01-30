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

--실행을 위한 주요 sql
--------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE "C##IDEV".money_of_day2(
	vid IN varchar2, 			--고객ID
	vdate IN varchar2,			--날짜
	vtotal_money OUT NUMBER
)
IS
   v_pcode TBL_BUY.PCODE %TYPE;
   v_quantity TBL_BUY.QUANTITY %TYPE;
   v_price TBL_PRODUCT.PRICE %TYPE;
BEGIN
   SELECT PCODE, QUANTITY                --1일 1구매 조건으로 1개의 행이 조회됨
      INTO v_pcode , v_quantity          --조회 결과가 N개의 행이면 프로시저의 커서 기능을 이용(나중에)
      --INTO는 프로시저에서만 사용
   FROM TBL_BUY
   WHERE CUSTOMID = p_id AND TO_CHAR(BUY_DATE,'YYYY-MM-DD') = p_date;
   --테스트를 위한 코드
   DBMS_OUTPUT.PUT_LINE('* p : ' || v_pcode ||','|| v_quantity );
   SELECT PRICE
      INTO v_price
   FROM TBL_PRODUCT
   WHERE PCODE = v_pcode;
   DBMS_OUTPUT.PUT_LINE('* p : ' || v_price);
   SELECT v_quantity * v_price
      INTO p_money      --수량*가격 수식 연산결과를 출력매개변수 P_MONEY에 저장
   FROM dual;         --특정 테이블과 상관 없으므로 DUAL 임시 테이블 사용하여 연산
   DBMS_OUTPUT.PUT_LINE('* m : ' || p_money);
   EXCEPTION
   WHEN no_data_found then
   DBMS_OUTPUT.PUT_LINE('조건에 맞는 데이터가 없습니다.');
   P_MONEY :=0;
END;
   
-----------실행-------------------------------------------------------------
 DECLARE 
    VMONEY NUMBER(8);--프로시저 실행결과 OUT 매개변수 저장(필수)
    vid TBL_CUSTOM.CUSTOM_ID%TYPE; --프로시저 실행에 필요한 IN 매개변수값 저장변수
    VDATE VARCHAR2(20);            --없어도 되지만 출력등 편의상 선언 (VID, VDATE)
 BEGIN
   VID := 'mina012';
   vdate :='2023-11-11';
   --VID, VDATE IN 매개변수값으로 프로시저 실행
   --매개 변수에 저장된 프로시저 실행 결과를 VMONEY에 저장
    MONEY_OF_DAY2(VID,VDATE,vmoney);
    DBMS_OUTPUT.PUT_LINE(CHR(10)||'고객ID: ' || VID|| ' 날짜: '||VDATE);
    DBMS_OUTPUT.PUT_LINE('고객님의 구매금액은 ' || vmoney|| '입니다.');
 END;
   
   
-------------조지수--------------
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
	SELECT PCODE, QUANTITY					--1일1구매 조건으로 오직1개의 행이 조회됩니다
	INTO vpcode,vquantity					--조회 결과가 n개의 행이면 프로시저의 커서 기능을 이용합니다.(나중에 합니다.)
	--INTO는 프로시저에서만 사용합니다. 조회 결과를 변수에 저장합니다.
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

------------------프로시저 실행---------------------------------
	DECLARE
		vmoney number(8);		--프로시저 실행결과를 OUT 매개변수값에 저장.
		vid tbl_custom.custom_id %TYPE  --프로시저 실행에 필요한 IN 매개변수값 저장변수
		vdate varchar2 (20);			--없어도 되지만 출력 등 편의상 선언합니다.
	BEGIN
		vid : ='mina012';
		vdate : ='2023-11-10';
		money_of_day(vid,vdate,vmoney);
		--vid,vdate IN 매개변수값으로 프로시저를 실행합니다.
		--OUT 매개변수에 저장된 프로시저 실행 결과를 vmoney변수에 저장합니다.
		dbms_output.put_line(CHR(10) || '고객ID:'||vid||'날짜:'||vdate);	
		dbms_output.put_line('고객님의 구매금액은' || vmoney ||'입니다.');
	END;
	















