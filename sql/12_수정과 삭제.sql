/*

	DML : SELECT , INSERT , UPDATE , DELETE 
		: 테이블의 행 데이터에 대한 조작.
	여기서 한번 더 생각할 것은 기본키가 필요한 이유 : 행식별
*/

--update 테이블명
-- 		 set 컬럼명1 = 변경할 값, 컬럼명2 = 변경할 값.....
--		 where 조건식;

--예시 : mina012 회원이 구매한 상품 CJBAb12g 의 수량을 모두 10으로 변경하기
UPDATE TBL_EXBUY 
SET PDCOUNT = 10
WHERE ID = 'mina012' AND PDCODE = 'CJBAb12g';
SELECT * FROM TBL_EXBUY te
ORDER BY ID;

-- 예시 : buy_idx 값이 1001 인 행의 수량을 5로 변경하기
--     : 조건식 컬럼이 pk 컬럼일 때에는 반드시 1개의 행만 수정이 적용됩니다.
UPDATE TBL_EXBUY 
SET PDCOUNT = 5
WHERE BUY_IDX = 2001;
SELECT * FROM TBL_EXBUY te ;

UPDATE TBL_EXBUY 
SET PDCOUNT =5; 			--WHERE 조건 없는 sql은 신중하게. 꼭 필요할 때만 사용됩니다.
SELECT * FROM TBL_EXBUY te ;

--delete frome 테이블명 where 조건식 : 행전체 삭제
--where 조건 없는 sql은 신중하게. 꼭 필요할 때만 사용합니다.
-- 		: 조건식 컬럼이 pk 컬럼(행식별)일 때에는 반드시 1개의 행만 삭제가 적용됩니다.
DELETE FROM TBL_EXBUY te WHERE BUY_IDX = 2001;
SELECT * FROM TBL_EXBUY te ;

--최종결론 : pk컬럼은 응용프로그램 개발할 때에는 없으면 기능을 만들 수 없습니다.
-- 		  행식별을 하여 조회 select, 수정 update, 삭제 delete에 반영되는 행을 지정할 수 있습니다.


-------------------------------------------------------------------------------
-- 트랜잭션 : insert, update, delete 에서 반드시 하나의 단위로 처리해야 할 작업
--		   모모가 미나한테 5만원 이체를 합니다. '모모 계좌는 -5만원 그리고 미나 계좌는 +5만원'
--		   update 2개의 명령어로 실행할 때 2개 모두 실행 또는 2개 모두 실행이 안되거나 해야 하는 트랜잭션입니다.
--		   하나의 단위로 처리해야 하는 것 = 트랜잭션
-- 자동 커밋 : insert, update, delete 가 바로 테이블에 반영되는 것
-- 수동 커밋 : insert, update, delete 명령이 바로 반영되지 않고 commit명령을 통해서 실행됩니다.
--			insert, update, delete 명령 트랜잭션 취소는 rollback으로 합니다.

--sql plus 명령
--show autocommit;
--set autocommit off[on];

--디비버의 auto commuit 해제하기 : 데이터베이스 메뉴 - 트랜잭션 모드 - manual commit으로 변경하기
INSERT INTO TBL_EXBUY (buy_idx,id,pdcode,pdcount)
	VALUES (exbuy_pk_seq.nextval,'mina012','CJBAb12g',5);				--현재 트랜잭션 명령 1)
SELECT * FROM TBL_EXBUY te ;										--현재 트랜잭션 명령 2)

--수동 커밋 상태에서 sql plus 실행 c##idev 계정으로 접속하기
--		 디비버 사용자가 추가한 insert는 커밋을 해야 sqlplus 사용자에게 보입니다.(반영됩니다.)

UPDATE TBL_EXBUY 
SET PDCOUNT = 13
WHERE BUY_IDX = 2002;							--현재 트랜잭션 명령 3)
SELECT * FROM TBL_EXBUY te ;					--현재 트랜잭션 명령 4)

--트랜잭션 취소
ROLLBACK;
SELECT * FROM TBL_EXBUY te ;					--새로운 트랜잭션 명령 1)
--insert 와 update 다시하고 commit 테스트 해보세요.
--						   ㄴsqlplus 사용자에게 보입니다.(반영됩니다.)

INSERT INTO TBL_EXBUY (buy_idx,id,pdcode,pdcount)
	VALUES (exbuy_pk_seq.nextval,'mina012','CJBAb12g',5);		--새로운 트랜잭션 명령 2)

UPDATE TBL_EXBUY 
SET PDCOUNT = 13
WHERE BUY_IDX = 2003;						--시퀀스는 이미 증가하여 롤백 안됩니다. --새로운 트랜잭션 명령 3)

SELECT * FROM TBL_EXBUY te ;				--새로운 트랜잭션 명령 4)

COMMIT;






