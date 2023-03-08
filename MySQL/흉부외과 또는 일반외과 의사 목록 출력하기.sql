-- DATE_FORMAT() 숙지 필수
-- ORDER BY 절에 계속 쓰면 같은 경우 다음 기준으로 정렬
SELECT
    DR_NAME,
    DR_ID,
    MCDP_CD,
    DATE_FORMAT(HIRE_YMD, '%Y-%m-%d')
FROM
    DOCTOR
WHERE
    MCDP_CD = 'CS'
    OR
    MCDP_CD = 'GS'
ORDER BY
    HIRE_YMD
    DESC,
    DR_NAME
    ASC
