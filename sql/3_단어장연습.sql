/*
 * '단어장' 프로그램을 위한 테이블
 * 0. 테이블명 : tbl_JavaWord
 * 1. 테이블 구조											3.To do : 컬럼값들의 규칙 => 요구사항에 대한 제약조건
 * 			idx			number(8)						같은 값을 가질 수 없다. 반드시 값이 있어야 한다.
 * 			english		varchar2(100)					같은 값을 가질 수 없다. 반드시 값이 있어야 한다.
 * 			korean		nvarchar2(100)					반드시 값이 있어야 한다.
 * 			level		number(1)						반드시 값이 없는 null도 가능하다.1~4 범위도로만 한다.
 * 														
 * 			4.To do : 검색 속도를 향상시키기 위한 컬럼을 정해라.데이터형을 식별할 수 있는 컬럼을 정해라 (기본키 실행)
 *   
 * 2. 테이블에 행 추가 - 데이터 입력하기
 * 
 * ******오랔클의 키워드는 테이블명, 컬럼명으로 사용 못합니다.
 * */

CREATE TABLE tbl_JavaWord(
	idx  		number(8),			
	english 	varchar2(100),		
	korean  	nvarchar2(100),
	step 		number(1)
);

--INSERT INTO 테이블명(컬럼명1,컬럼명2,컬럼명3....) VALUES(값1,값2,값3....),
--		또는 테이블 모든 컬럼을 추가할 때에는
--INSERT INTO 테이블명 VALUES(값1,값2,값3...)
INSERT INTO tbl_JavaWord(idx,english,korean,step) VALUES (12,'public','공용의',2);
INSERT INTO tbl_JavaWord(idx,english,korean,step) VALUES (8,'jisoo','지수',3);
INSERT INTO tbl_JavaWord(idx,english,korean,step) VALUES (9,'cute','귀여운',1);
INSERT INTO tbl_JavaWord(idx,english,korean,step) VALUES (10,'pig','돼지',1);
INSERT INTO tbl_JavaWord(idx,english,korean,step) VALUES (2,'private','사적인',1);
SELECT * FROM TBL_JAVAWORD;

INSERT  INTO
 TBL_JAVAWORD (idx,english,korean,step)
 VALUES
 (4567,'pig','돼지');	         --입력하지 않은 컬럼 step 의 값은 null
 
--SELECT 컬럼명1,컬럼명2,...FROM테이블명 => 모든 컬럼을 지정하는 문자는 (*=와일드카드 문자)  

SELECT 
  	ENGLISH,KOREAN 
FROM
  	TBL_JAVAWORD ;
SELECT * FROM TBL_JAVAWORD ;

--SELECT 컬럼명,컬럼명2,...FROM테이블명 WHERE 컬럼명 =값  => 특정 컬럼을 조건식으로 조회
SELECT * FROM TBL_JAVAWORD WHERE STEP  IS NOT NULL;
SELECT * FROM TBL_JAVAWORD WHERE IDX=2;
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH ='public';
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH ='public' AND STEP =2;  --AND, OR, NOT : 논리연산
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH LIKE '%ic';		--ic로 끝나는, %기호는 don't care
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH LIKE '%ic%';		--ic로 끝나는, %기호는 don't care
SELECT * FROM TBL_JAVAWORD WHERE IDX BETWEEN 10 AND 20;	 	--10~20
SELECT * FROM TBL_JAVAWORD WHERE IDX NOT BETWEEN 10 AND 20; --10~20범위값이 아닌 것
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH <'public';

--새로운 연산자 
INSERT INTO TBL_JAVAWORD VALUES (5,'constraint','제약사항',3);
INSERT INTO TBL_JAVAWORD VALUES (9,'order','순서',1);

--idx 값이 2,5,9 인 것만 조회 
SELECT * FROM TBL_JAVAWORD WHERE IDX=2 OR IDX=5 OR IDX=9;
SELECT * FROM TBL_JAVAWORD WHERE IDX IN (2,5,9); 		--OR 연산을 간단하게

--idx 값이 2~5 조회
SELECT * FROM TBL_JAVAWORD WHERE IDX >=2 AND IDX <=5;   ==AND 연산은 BETWEEN 으로 간단하게

--SELECT 컬럼명1, 컬럼명2,...FROM 테이블명
--					[WHERE 컬럼명 = 깂] => 특정 컬럼을 조건식으로 조회
--					[ORDER BY 컬럼명1,컬럼명2[DESC]]
--				=>지정된 컬럼명으로 정렬. DESC는 내림차순. ASC 오름차순(생략). 컬럼명1이 같은 값이면 컬럼명2로 정렬

SELECT * FROM  TBL_JAVAWORD WHERE IDX IN (2,5,9) ORDER BY IDX;
INSERT INTO TBL_JAVAWORD VALUES (2,'private','개인적인',1);










