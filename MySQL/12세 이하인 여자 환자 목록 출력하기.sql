-- 문제 잘 읽기(12세 이하인 "여자" 환자)
-- IFNULL()과 NULLIF() 차이 숙지 필수
SELECT
    PT_NAME,
    PT_NO,
    GEND_CD,
    AGE,
    IFNULL(TLNO, 'NONE') AS TLNO
FROM
    PATIENT
WHERE
    AGE <= 12
    AND
    GEND_CD = 'W'
ORDER BY
    AGE
    DESC,
    PT_NAME
    ASC
