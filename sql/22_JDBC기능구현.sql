-- JDBC 프로젝트 위한 SQL 테스트

-- 회원 정보 수정 : email, age
UPDATE TBL_CUSTOM 
	SET EMAIL = 'test@gmail.com',age=22
	WHERE CUSTOM_ID  = 'nayeon33'

-- 회원 탈퇴 : 
DELETE FROM TBL_CUSTOM 
	   WHERE CUSTOM_ID = 'sana77';

--컬럼 조회한 결과는 1개 또는 1개 이상에 따라 리턴 형식을 결정하자 (List ? NOT List?)
--상품 검색하기 SQL : ProductVo, TblProductDao 만들기
--								ㄴselectByCategory,selectByPname 메소드만듭시다.
--카테고리로 검색하기
-- 1) 어떤 카테고리가 있는지 보여주기
SELECT CATEGORY FROM TBL_PRODUCT tp ;  --중복된 값은 한번만.(중복제거)
-- 2) 특정 카테고리에 대한 상품 목록 보여주기	
SELECT * FROM TBL_PRODUCT tp 
WHERE CATEGORY = 'B1';
ORDER BY PNAME;

-- 데이터 추가
INSERT INTO TBL_PRODUCT tp 
		VALUES ('BUSA211','B2','부사 사과 3kg 박스',25000);
		
-- 3) 상품명 유사(like)검색
SELECT * FROM TBL_PRODUCT tp 
--WHERE PNAME LIKE '%사과% --프로그램에서 매 개변수 처리를 위해 연결연산으로 합니다.
WHERE PNAME LIKE '%'|| '사과' || '%'	
ORDER BY CATEGORY;

--MyPage 기능의 메소드를 위한 SQL
--selectCustomerBuyList => TblBuyDao 에 만드세요.
--						=> 아래 조회된 행들에 대해 컬럼과 매핑되는 CustomerBuyVo를 만들어야 합니다.
SELECT BUY_IDX, tb.PCODE, PNAME, PRICE, QUANTITY, BUY_DATE 
FROM TBL_BUY tb
JOIN TBL_PRODUCT tp 
ON tb.PCODE = tp.PCODE 
WHERE tb.CUSTOMID = 'mina012' --mina012는 SQL매개변수입니다.
ORDER BY BUY_DATE DESC;




