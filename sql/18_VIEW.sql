/*
  스키마 : 데이터베이스 스키마는 데이터베이스에서 자료의 구조, 자료의 표현 방법,
  		 자료 간의 관계를 형식 언어로 정의한 구조이다
		 ㄴ 풀이 : 사용자가 계정을 받아서 여러가지 방법으로 데이터(자료)를 저장하고 관리하는 공간
				 오라클 등 dbms는 여러 객체를 생성하여 사용합니다.
				 
  실제 비지니스 로직을 처리할 때 SQL이 많이 복잡해질 수 있습니다. (조인 및 서브쿼리 사용 횟수가 많아짐)
  => 자주 사용하면서 일회용으로 처리가 되면 성능이 문제가 생기고 비효율적입니다.
  => 그래서 가상 테이블(view) 또는 프로시저(트랜잭션 단위로 구성)를 사용합니다. 
  
  VIEW(뷰) : 가상 테이블
			ㄴ SELECT 조회 결과를 미리 컴파일하여 오라클 객체로 저장.
			ㄴ SELECT 조회 할 때 테이블 처럼 사용.
			ㄴ 그러나 INSERT,UPDATE,DELETE는 제약이 많고 잘 사용되지 않음. 
  CREATE VIEW : 권한이 별도로 필요합니다. => 관리자 계정 sys 또는 system이 합니다.
  1)SQL PLUS 에서 grant create view to c##idev; 명령 실행하고 
  2)디비버에서 접속 재연결
*/
CREATE OR REPLACE VIEW v_customsale
AS 
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
		tb.CUSTOMID , tb.PCODE;

--일반 테이블의 select 처럼 조회 형식 모두 사용 가능합니다.
SELECT *
FROM  V_CUSTOMSALE vc 
WHERE CUSTOMID  = 'mina012'; 

SELECT *
FROM  V_CUSTOMSALE vc 
WHERE "RANK"=1;