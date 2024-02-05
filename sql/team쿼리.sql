

--1. 맛집찾기
--(이름,평점,메뉴)

SELECT *
FROM TBL_PLACE tp , TBL_MENU tm 
WHERE tp.PLACE_SEQ  = tm.PLACE_SEQ 
AND tp.NAME LIKE '%' || '낙곱새' || '%'
AND RATE >= 4.5
AND MENU_NAME LIKE '%' || '낙곱새' || '%';

--3. 지역별로 찾기 
SELECT   tp.place_seq
      ,tp.name
      , open_time 
        , close_time
        , tpa.address
FROM  tbl_place tp
   , tbl_place_address tpa
   , tbl_area_unit au
WHERE tp.place_seq = tpa.place_seq
  AND substr(tpa.address,0,2) = au.unit_name
  --  서울 / 인천 /부산 /대구 /광주 / 제주 검색
  AND au.unit_name = '대구'
;  

-- 4. 평점순(5점 만점) 으로 보여주기
SELECT tp.PLACE_SEQ, tp.NAME, open_time , close_time
        , tpa.address, tp.rate
FROM  tbl_place tp
   , tbl_place_address tpa
WHERE tp.place_seq = tpa.place_seq
AND tp.RATE >= 4.0
ORDER BY tp.rate DESC;


SELECT tp.*
FROM TBL_PLACE tp , TBL_MENU tm 
WHERE tp.PLACE_SEQ =tm.PLACE_SEQ 
AND tp.NAME LIKE '%'||'비주비주'||'%';

-- 5. 수정(평점) 
UPDATE tbl_place 
SET rate = '4.7'
WHERE place_seq = 22 ;

--랜덤
SELECT *
FROM
(
SELECT *
FROM TBL_PLACE tp 
WHERE RATE >= 4.5
ORDER BY DBMS_RANDOM.VALUE
)
WHERE ROWNUM <=3;

--
SELECT *
FROM (
   SELECT   tp.place_seq
         ,tp.name
         , open_time 
           , close_time
           , tpa.address
   FROM  tbl_place tp
      , tbl_place_address tpa
      , tbl_area_unit au
   WHERE tp.place_seq = tpa.place_seq
     AND substr(tpa.address,0,2) = au.unit_name
     AND au.unit_name = '대구'
   ORDER BY DBMS_RANDOM.VALUE
)
WHERE ROWNUM <=3;



SELECT tp.place_seq, tp.name, tp.open_time, tp.close_time, tpa.address
FROM tbl_place tp, tbl_place_address tpa, tbl_area_unit au
WHERE tp.place_seq = tpa.place_seq
AND substr(tpa.address, 0, 2) = au.unit_name
AND au.unit_name = '서울';






