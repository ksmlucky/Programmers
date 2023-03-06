-- LIKE 함수에 한번에 AND, OR 못 걸음
-- GROUP BY
-- '%시트%'나 IN 쓰기
SELECT
    CAR_TYPE
    , COUNT(CAR_ID) AS CARS
FROM
    CAR_RENTAL_COMPANY_CAR
WHERE
    OPTIONS
        LIKE
        '%통풍시트%'
    OR
    OPTIONS
        LIKE
        '%열선시트%'
    OR
    OPTIONS
        LIKE
        '%가죽시트%'
GROUP BY
    CAR_TYPE
ORDER BY
    CAR_TYPE
    ASC
