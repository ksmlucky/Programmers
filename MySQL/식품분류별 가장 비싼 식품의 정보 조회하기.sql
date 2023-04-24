-- 서브쿼리
-- IN
-- GROUP BY
SELECT
    CATEGORY
    , PRICE AS MAX_PRICE
    , PRODUCT_NAME
FROM
    FOOD_PRODUCT
WHERE
    PRICE
    IN
    (
        SELECT
            MAX(PRICE)
        FROM
            FOOD_PRODUCT
        GROUP BY
            CATEGORY
    )
    AND
    CATEGORY
    IN
    ('과자', '국', '김치', '식용유')
GROUP BY
    CATEGORY
ORDER BY
    PRICE
    DESC
