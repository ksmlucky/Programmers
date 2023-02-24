-- 문제 제대로 읽기
-- MONTH()
-- MONTH() 대신에 LIKE도 가능
-- MONTH() 대신에 TO_CHAR(DATE_OF_BIRTH, 'mm')도 가능
SELECT
    MEMBER_ID,
    MEMBER_NAME,
    GENDER,
    DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
FROM
    MEMBER_PROFILE
WHERE
    MONTH(DATE_OF_BIRTH) = '03'
    AND
    GENDER = 'W'
    AND
    TLNO IS NOT NULL
ORDER BY
    MEMBER_ID
    ASC
