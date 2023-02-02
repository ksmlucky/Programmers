-- COUNT()는 NULL을 포함한 행의 개수를 세기 때문에 전체를 세어준 후,
-- 구하고자 하는 컬럼명을 세어서 빼준다.
-- COUNT(*) - COUNT(구하고자 하는 컬럼명)
SELECT COUNT(*) - COUNT(AGE) FROM USER_INFO;
