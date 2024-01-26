/*
	오라클의 RANK 함수
	예제 : 고객 - 상품별 최대구매금액을 구하고 해당 상품코드 조회하기
		   ㄴ고객 ID로 1차 그룹화, 고객 내에서 상품코드로 2차 그룹화
*/
--준비 : mina012 에게 구매 이력이 있는 상품을 한번 더 구매 시키기
INSERT INTO TBL_BUY tb VALUES (buy_pk_seq.nextval,'mina012','JINRMn5',13,'2024-01-26');
SELECT *
FROM 
	TBL_BUY tb ,TBL_PRODUCT tp 
WHERE 
	tb.PCODE = tp.PCODE;


--1) GROUP BY
SELECT 
	tb.CUSTOMID , tb.PCODE,
 	sum(tp.PRICE*tb.QUANTITY)MONEY   --가격*수량에 대한 그룹화 함수 sum 실행
FROM 
	TBL_BUY tb ,TBL_PRODUCT tp 
WHERE 
	tb.PCODE = tp.PCODE
GROUP BY
	tb.CUSTOMID , tb.PCODE
--2) 결과를 정렬 해봅시다.
ORDER BY 
	tb.CUSTOMID, MONEY DESC;
	
--3) 1)결과에 RANK 함수를 적용해 봅니다.
SELECT 
	tb.CUSTOMID , tb.PCODE,
 	sum(tp.PRICE*tb.QUANTITY)MONEY			--가격*수량에 대한 그룹화 함수 SUM 실행
--,RANK() OVER(ORDER BY sum(tp.PRICE * tb.QUANTITY DESC)"RANK"					--전체MONEY순위 --OVER()안에는 어떤 컬럼으로 정렬해서 순위를 매기는지에 대한 내용 --[MONEY와] 같은 별칭을 사용 못함.
	,RANK() 
	OVER(PARTITION BY tb.CUSTOMID ORDER BY sum(tp.PRICE * tb.QUANTITY) DESC)"RANK"
FROM 
	TBL_BUY tb ,TBL_PRODUCT tp 
WHERE 
	tb.PCODE = tp.PCODE
GROUP BY
	tb.CUSTOMID , tb.PCODE;
	
--4) 3)번을 서브쿼리로 하여 rank=1 인 조건을 적용해보기
WITH CUSTOMSALE
AS
(
	SELECT 
		tb.CUSTOMID , tb.PCODE,
 		sum(tp.PRICE*tb.QUANTITY)MONEY			
		,RANK() 
		OVER(PARTITION BY tb.CUSTOMID ORDER BY sum(tp.PRICE * tb.QUANTITY) DESC)"RANK"
	FROM 
		TBL_BUY tb ,TBL_PRODUCT tp 
	WHERE 
		tb.PCODE = tp.PCODE
	GROUP BY
		tb.CUSTOMID , tb.PCODE
)
SELECT *
FROM  CUSTOMSALE
WHERE RANK =1;






