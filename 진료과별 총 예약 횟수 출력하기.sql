-- GROUP BY 절
-- ORDER BY 절에 Alias 가능
SELECT
    MCDP_CD AS 진료과코드,
    COUNT(*) AS 5월예약건수
FROM
    APPOINTMENT
WHERE
    APNT_YMD
    LIKE
    '2022-05%'
GROUP BY
    MCDP_CD
ORDER BY
    5월예약건수 ASC,
    진료과코드 ASC
