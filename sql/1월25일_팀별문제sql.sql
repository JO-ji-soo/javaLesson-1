/*

팀별 예시 문제 : 출제 1월 25일 

*/

--A조

--김미나가 구매한 상품 금액 합계(이광원)
SELECT CUSTOMID  ,SUM(PRICE * QUANTITY) "구매 금액"
FROM  TBL_PRODUCT tp ,TBL_BUY tb
WHERE tp.PCODE = tb.PCODE
AND CUSTOMID ='mina012'
GROUP BY CUSTOMID ;

--홍길동이 구매한 상품의 갯수는?(권태윤) -- 이름에 길동이 들어가는 회원은?
SELECT NAME ,SUM(QUANTITY) "상품 갯수"
FROM  TBL_CUSTOM tc 
JOIN  TBL_BUY tb ON tc.CUSTOM_ID = tb.CUSTOMID 
AND NAME ='홍길동'
GROUP BY NAME ;

--권태윤 문제 : 나의 답
SELECT NAME ,SUM(QUANTITY) "상품 갯수"
FROM  TBL_CUSTOM tc,TBL_BUY tb
WHERE tc.CUSTOM_ID = tb.CUSTOMID 
AND NAME = '홍길동'
GROUP BY NAME;

-- 20살이상 고객님들의 구매한 상품(강주찬) --테이블 3개 [바이, 고객]
SELECT tp.*
FROM TBL_CUSTOM tc2  
JOIN TBL_BUY tb 
ON tp.PCODE  = tb.PCODE 
JOIN TBL_CUSTOM tc
ON tb.CUSTOMID = tc.CUSTOM_ID
WHERE tc.AGE > 20;

--강주찬 문제 : 나의 문제 : 20살 이상의 고객님들이 가장 많이 수량과 품명은? [바이,고객]
SELECT AGE, QUANTITY, PCODE
FROM TBL_CUSTOM tc
JOIN TBL_BUY tb ON tc.CUSTOM_ID = tb.CUSTOMID 
WHERE AGE >=20
GROUP BY AGE, QUANTITY , PCODE
ORDER BY QUANTITY DESC;

--주찬님 답
SELECT CUSTOMID , tc.AGE , tb.PCODE , PNAME 
FROM TBL_CUSTOM tc  
JOIN TBL_BUY tb
ON tc.CUSTOM_ID = tb.CUSTOMID
JOIN TBL_PRODUCT tp 
ON tb.PCODE = tp.PCODE
WHERE tc.AGE > 25;

-- 사과를 구매한 사람의 이름과 구매한 갯수만큼의 가격의 합을 구해줘(고길현) --1)답을 서브쿼리 없이 변경
-- 2) 상품명에 '사과'가 포함된 상품을 구매한 고객별 구매금액의 합계를 구해보세요. 
SELECT tc.NAME, sum("구매 금액의 합") 
FROM 
	(
	 SELECT NAME, tp.PRICE , tp.PRICE * tb.QUANTITY "구매 금액의 합" 
	 FROM TBL_CUSTOM tc 
	 JOIN TBL_BUY tb 
	 ON tc.CUSTOM_ID = tb.CUSTOMID 
	 JOIN TBL_PRODUCT tp 
	 ON tp.PCODE = tb.PCODE 
	 AND tp.PNAME = '청송사과 5kg'
	 ) tc 
GROUP BY tc.NAME;

--2) 상품명에 '사과'가 포함된 상품을 구매한 고객별 구매금액의 합계를 구해보세요.
INSERT INTO TBL_PRODUCT tp VALUES ('BUSA211','B2','부사 사과 3kg 박스',25000);
INSERT INTO TBL_BUY VALUES (buy_pk_seq.nextval,'hongGD','BUSA211',2,'2024-01-03');

SELECT PNAME, QUANTITY, SUM(PRICE * QUANTITY)
FROM TBL_PRODUCT tp 
JOIN TBL_BUY tb ON tp.PCODE = tb.PCODE 
WHERE PNAME LIKE '%사과%'
GROUP BY PNAME, QUANTITY;


-- with 구문이용하여 saleMoney를 그룹으로 묶고 그 중 구매합산 금액 중 20000~70000사이 값을 출력하시오(김태완) --서브쿼리 없이 변경
-- 총 구매합산 그 ㅁ액이 20000~70000값인 고객 ID를 조회하시오.
WITH saleMoney
AS
	(
	  SELECT tp.PCODE, QUANTITY, PRICE, QUANTITY*PRICE "구매 금액"
      FROM TBL_PRODUCT tp ,TBL_BUY tb 
      WHERE tp.PCODE = tb.PCODE
)
SELECT saleMoney.PCODE,SUM(saleMoney.QUANTITY),SUM("구매 금액")
FROM saleMoney
GROUP BY saleMoney.pcode
HAVING SUM("구매 금액") BETWEEN 20000 AND 70000;



--B조
--나이가 30이상인 회원들의 나이와 상품코드를 서브쿼리와 조인을 모두 사용해 조회하세요(이대환)
SELECT abc.age, abc.pcode 
FROM (
	SELECT * FROM TBL_BUY tb
	JOIN TBL_CUSTOM tc 
	ON tb.CUSTOMID = tc.CUSTOM_ID 
	AND age>30) abc
GROUP BY abc.age, abc.pcode;



--물건을 구매한 사람 중, 가장 나이가 많은 고객을 찾으려고 한다.다음 빈칸에 맞는 코드를 넣으시오.(김승한)
--(테이블이 되는 코드는 ‘13_9번문제.sql 파일을 기반으로 한다.’)
SELECT tc.CUSTOM_ID, tc.name, tc.age
	FROM TBL_CUSTOM tc
	JOIN TBL_BUY tb 
	ON CUSTOM_ID=tb.CUSTOMID
WHERE tc.AGE = (SELECT MAX(age)
FROM TBL_CUSTOM);

--나이가 많은 고객님 중에 가장 많이 구매하신 고객님을 조회해라. (김승한 문제) : 조지수 답
SELECT abc.NAME, abc.AGE, 
(SELECT NAME, AGE, QUANTITY
FROM TBL_CUSTOM tc 
JOIN TBL_BUY tb ON tc.CUSTOM_ID = tb.CUSTOMID 
ORDER BY AGE DESC;) abc


--2021년 12월1일 부터 2022년 03월17일 사이에 가장 많이 산 사람의 이름 , 물건이름 , 수량 순으로 조회하시오(노희영)
SELECT A.NAME "이름", C.PNAME "물건이름", MAX(B.QUANTITY) ||'개'"수량"
	FROM TBL_CUSTOM A, TBL_BUY B, TBL_PRODUCT C
	WHERE A.CUSTOM_ID = B.CUSTOMID
	AND B.PCODE = C.PCODE
	AND QUANTITY = (SELECT MAX(QUANTITY)
FROM TBL_BUY
WHERE BUY_DATE BETWEEN TO_DATE('2021-12-01','yyyy-mm-dd')
AND TO_DATE('2022-03-17','yyyy-mm-dd'))
GROUP BY A.NAME,C.PNAME ;



--회원별로 가장 많은 사용금액을 구하시오(이예진)
WITH BIG
AS 
	(
	SELECT TB.PCODE, TB.CUSTOMID,
	MAX(tp.PRICE * tb.QUANTITY) AS "많이 쓴 금액"
FROM
	TBL_PRODUCT tp
JOIN
	TBL_BUY tb ON tp.PCODE = tb.PCODE
GROUP BY
	TB.PCODE,TB.CUSTOMID)
SELECT BIG.CUSTOMID, MAX("많이 쓴 금액") AS "하나"
FROM BIG
GROUP BY BIG.CUSTOMID;



--구매이력이 2 이상인 고객 중에 나이가 20을 초과한 인원만 조회하세요.(이재훈)
SELECT tc.CUSTOM_ID , tc.NAME , tc.EMAIL ,tc.AGE , tb.QUANTITY 
FROM TBL_CUSTOM tc  
LEFT JOIN TBL_BUY tb 
ON tc.CUSTOM_ID = tb.CUSTOMID  
WHERE tb.QUANTITY >=2 AND tc.AGE >20;  



--tbl_student 와 tbl_score 에서 '김모모'라는 이름을 가진 2021001 학번의 점수를 각각 출력하고 평균을 구하시오(민찬희)
SELECT st.stuno 학생번호, st.name 이름,sc.JUMSU 점수,
	(
	SELECT avg(JUMSU) 
	FROM tbl_score 
	WHERE st.STUNO='2021001'),sc.SUBJECT 과목 
	FROM TBL_STUDENT st
INNER JOIN TBL_SCORE sc ON st.stuno = sc.stuno
WHERE st.name = '김모모'



--C조
-- 문제 : 가격이 1만원 이상의 상품마다 각각 고객들이 구매한 개수의 평균을 출력하시오. (출제자 : 임현범)
SELECT tp.PNAME "상품명", avg(tb.QUANTITY) "평균 구매 개수"
FROM TBL_BUY tb 
JOIN TBL_PRODUCT tp ON tb.PCODE = tp.PCODE
WHERE tp.PRICE >= 10000
GROUP BY tp.PNAME;



-- 문제 : 진라면을 구매한 고객의 이름, 구매수량, 구매날짜를 조회하자. (출제자 : 전예진)
WITH bi 
AS (
    SELECT CUSTOMID, PCODE, QUANTITY "구매수량", BUY_DATE "구매날짜"
    FROM TBL_BUY
    WHERE PCODE = 'JINRMn5'
)
SELECT tc.NAME "고객명", bi.구매수량, bi.구매날짜
FROM bi
JOIN TBL_CUSTOM tc 
ON bi.CUSTOMID = tc.CUSTOM_ID;



-- 문제 : 20대 사용자들이 구매한 상품의 평균 가격 조회 (출제자 : 조이루) --이 문제로 정답 제출
SELECT tc.custom_id, tc.name, AVG(tp.price) AS avg_price
FROM TBL_CUSTOM  tc 
JOIN TBL_BUY tb ON tc.custom_id = tb.customId
JOIN TBL_PRODUCT tp ON tb.pcode = tp.pcode
WHERE tc.age BETWEEN 20 AND 29
GROUP BY tc.custom_id, tc.name;



-- 문제 : 2023년에 팔린 상품의 이름과 코드,총 판매액 그리고 총 판매개수를 구하시오. (출제자 : 정제원) --서브쿼리 없이
SELECT total.PCODE,PNAME, SUM(QUANTITY) "총 구매개수", SUM("총 가격")
FROM (
    SELECT tp.PCODE,PNAME, QUANTITY, QUANTITY * PRICE "총 가격", BUY_DATE  
    FROM TBL_PRODUCT tp, TBL_BUY tb 
    WHERE tp.PCODE = tb.PCODE AND to_char(BUY_DATE, 'yyyy') = '2023'
) total
GROUP BY total.PCODE, PNAME;



-- 문제 : 미나와 길동이는 한집에 살고 있습니다. 미나와 길동이가 구매한 상품,수량,가격을 조회하세요. (출제나 : 장성우)
WITH minaGD
as(
	SELECT *
	FROM TBL_BUY tb 
	WHERE CUSTOMID = 'twice' OR  CUSTOMID ='hongGD' 
)
SELECT tp.PNAME, minaGD.quantity,tp.PRICE 
FROM minaGD
JOIN TBL_PRODUCT tp
ON minaGD.PCODE = tp.PCODE ;



--D조
-- 조하연 문제 : 진라면을 가장 많이 구매한 회원을 구매금액이 높은 순으로 회원아이디와
총 진라면 구매금액을 보여주세요.
SELECT X.CUSTOMID, X.SUM
FROM
	(
	SELECT tb.customid, tb.quantity, tp.price, tb.quantity * tp.price AS sum
	FROM TBL_PRODUCT tp, tbl_buy tb
	WHERE tp.pcode = tb.pcode
	AND tp.pcode = 'JINRMn5'
	) X
ORDER BY SUM DESC;


--*********한진만 시험문제***********
-- 한진만 문제 : 팔린 갯수가 가장 많은 순서로 상품(상품코드로 그룹화)로 상품(상품코드와 상품이름)을 정렬하고 총 팔린 금액을 출력하시오
SELECT tp.PCODE, tp.PNAME, tb.QUANTITY "팔린 갯수" , 
		tb.QUANTITY * tp.PRICE "총 팔린 금액"
FROM TBL_PRODUCT tp
LEFT JOIN TBL_BUY tb ON tb.PCODE = tp.PCODE
WHERE tb.BUY_IDX IS NOT NULL
ORDER BY QUANTITY DESC ;



-- 황병훈 문제 : 진라면을 구매한 고객들의 평균 나이를 제품코드(PCODE)와 함께출력해주세요.
SELECT PCODE ,AVG(AGE)" 진라면 구매자의 평균 나이"
FROM
	(
	SELECT AGE, PCODE
	FROM TBL_CUSTOM tc , TBL_BUY tb
	WHERE tc.CUSTOM_ID = tb.CUSTOMID
	AND PCODE = 'JINRMn5'
	)
GROUP BY PCODE;



--조지수 문제 : 30이하 회원별 구매금액을 구하고 회원으로 그룹바이해서 구매금액 합계가 큰 순으로 정렬
--30세 이하[고객], 회원별 구매금액[단가+수량,프로덕트]을 구하고 회원으로 그룹바이해서 구매 금액 합계가 큰 순으로 정렬
SELECT abc.CUSTOMID, sum(pay_sum) AS total
FROM
	(
	SELECT tb.customid, tp.price * tb.quantity AS pay_sum
	FROM TBL_PRODUCT tp, TBL_buy tb
	JOIN TBL_CUSTOM tc ON tb.CUSTOMID = tc.CUSTOM_ID AND age<30
	WHERE tp.pcode = tb.pcode
	) abc
GROUP BY abc.CUSTOMID
ORDER BY total DESC;

--조하연 문제 : 1)조인없는 서브쿼리 또는 2)조인만 하거나
--진라면을 가장 많이 구매한 회원을 구매금액이 높은 순으로 회원아이디와 총 진라면 구매금액을 보여주세요.
SELECT X.CUSTOMID, X.SUM
FROM 
(
   SELECT tb.customid, tb.quantity, tp.price,  tb.quantity * tp.price  AS sum
   FROM TBL_PRODUCT tp,
       tbl_buy tb
   WHERE   tp.pcode = tb.pcode
      AND tp.pcode = 'JINRMn5'
) X
ORDER BY SUM DESC
;


--한주영 문제 2023년 구매 금액 5만원 이상에게 할인쿠폰을 발송하려 한다.
--CUSTOMID,구매 총액, 구매 일자를 구하시오. COUPON 사용하기
SELECT COUPON.CUSTOMID "고객id",
		SUM(COUPON.TOTAL) "구매 총액"
FROM (
	SELECT
	tb.QUANTITY * tp.PRICE AS TOTAL,
	BUY_DATE ,
	tb.CUSTOMID,
	QUANTITY,
	PRICE
	FROM
	TBL_PRODUCT tp,
	TBL_BUY tb
	WHERE
	tp.PCODE = tb.PCODE
	AND TO_CHAR(BUY_DATE,'YYYY')='2023'
	) COUPON
GROUP BY COUPON.CUSTOMID
HAVING SUM(COUPON.QUANTITY * COUPON.PRICE)>50000;



--차정호 문제 : 문제 햇반의 총 매출과 팔린 갯수 산사람의 회원 아이디를 구하세요
SELECT dongwon.CUSTOMID, dongwon.Price1 "가격", dongwon.quantity "개수"
FROM
	(
	SELECT tb.customid, tb.quantity, tp.price, tp.price* tb.quantity AS Price1
	FROM TBL_PRODUCT tp,
	tbl_buy tb
	WHERE tp.pcode = tb.pcode
	AND tp.pcode = 'CJBAb12g'
	)dongwon;


















