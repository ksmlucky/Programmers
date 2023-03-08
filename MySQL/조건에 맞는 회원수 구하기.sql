-- BETWEEN이나 AND, IN 중 하나 골라서 쓰면 될듯
SELECT
    COUNT(*)
FROM
    USER_INFO
WHERE
    JOINED
        LIKE
        '2021%'
    AND
    AGE BETWEEN 20 AND 29
