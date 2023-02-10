-- ORDER BY 절에 계속 쓰면 같은 경우 다음 기준으로 정렬
SELECT
    FLAVOR
FROM
    FIRST_HALF
ORDER BY
    TOTAL_ORDER
    DESC,
    SHIPMENT_ID
    ASC
