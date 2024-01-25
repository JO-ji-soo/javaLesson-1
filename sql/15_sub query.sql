/*
	서비 쿼리(sub query) : SELECT 조회 결과(여러개의 행)가 다른 DML 명령어에 쓰일 수 있습니다.
													  ㄴselect,insert,update,delete 
						select,insert,update,delete에 포함되는 select 를 서브 쿼리라고 합니다.

   select 함께 쓰이는 서브쿼리
   					 : select 컬럼1, 컬럼2 from (select.....)
   					 					where 컬럼명1 = 값(select....)
   select 서브쿼리는 join으로도 가능합니다.
**/
--1) where에서 쓰는 서브쿼리 : twice가 구매한 상품 정보
SELECT tp.*
FROM TBL_PRODUCT tp ,TBL_BUY tb 
WHERE tp.PCODE = tb.PCODE			--1)크로스 연산
AND tb.CUSTOMID = 'twice';				--2)조건식 연산

--서브쿼리
SELECT tp.*
FROM TBL_PRODUCT tp 
WHERE PCODE IN 							--2) 조건식 연산
--('CJBAb12g','APLE5kg','DOWON123a') --진라면,애플망고
(SELECT PCODE FROM TBL_BUY tb WHERE CUSTOMID='twice');		--1) 조건식 연산

--2) from 에서 사용되는 서브 쿼리 : 컬럼명 또는 테이블명 별칭을 줄 때 한글을 쓰려면 "" 안에 사용합니다.
SELECT 
	saleMoney.PCODE, sum(QUANTITY), sum("구매 금액")
FROM
	(SELECT tp.PCODE, PNAME, QUANTITY, PRICE, QUANTITY * PRICE "구매 금액"
	FROM TBL_PRODUCT tp  ,TBL_BUY tb 
	WHERE tp.PCODE = tb.PCODE) saleMoney
GROUP BY saleMoney.PCODE;

--장성우님
SELECT 
    tp.PCODE, SUM(tb.QUANTITY) AS TotalQuantity, SUM(tp.PRICE * tb.QUANTITY) AS TotalAmount
FROM 
    TBL_PRODUCT tp
JOIN 
    TBL_BUY tb ON tp.PCODE = tb.PCODE
GROUP BY 
    tp.PCODE;
   
--오라클 with 구문 : select 조회 결과를 저장해 놓고 사용하도록 합니다.
WITH saleMoney
AS
(
	SELECT tp.PCODE, PNAME, QUANTITY, PRICE, QUANTITY * PRICE "구매 금액"
	FROM TBL_PRODUCT tp  ,TBL_BUY tb 
	WHERE tp.PCODE = tb.PCODE
)
SELECT SALEMONEY.PCODE, sum(SALEMONEY.QUANTITY), sum("구매 금액")
FROM SALEMONEY
GROUP BY SALEMONEY.pcode;


--서브쿼리와 조인을 이용한 문제를 한 개씩 만들어 팀별로 공유해보세요.
SELECT abc.CUSTOMID, sum(pay_sum) AS TOTAL
FROM
   (
      SELECT tb.CUSTOMID, tp.PRICE * tb.QUANTITY  AS pay_sum
      FROM  TBL_PRODUCT  tp, TBL_BUY tb 
      JOIN TBL_CUSTOM tc ON tb.CUSTOMID = tc.CUSTOM_ID AND AGE<30
      WHERE tp.PCODE = tb.PCODE
   ) abc
GROUP BY abc.CUSTOMID
ORDER BY TOTAL DESC;


/*
 	고객별로 구매금액이 가장 높은 상품코드를 조회하세요.
      ㄴ오라클 RANK 함수 (그룹의 결과에 대한 순위를 제공)
    내림차순 또는 오름차순 정렬된 결과에서 top3 가져오기
*/




























