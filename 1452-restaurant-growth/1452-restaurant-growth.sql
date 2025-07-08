# Write your MySQL query statement below
#cusid min is 1st jan , we want 7days window so start with 7 jan take amount of all entries betwn 1st jan to 7 jan and avg will be amnt/7 , likewise next output take amount of all entries between 2nd jan and 8 jan and take their avg , do this till last 10 jan
SELECT
    visited_on,
    (
        SELECT SUM(amount)
        FROM customer
        WHERE visited_on BETWEEN DATE_SUB(c.visited_on, INTERVAL 6 DAY) AND c.visited_on
    ) AS amount,  # c.visisted_on is 7 jan from subquery and 6 days less so 1st jan to 7 jan
    ROUND(( # date sub , here amount is calculated
            SELECT SUM(amount) / 7
            FROM customer
            WHERE visited_on BETWEEN DATE_SUB(c.visited_on, INTERVAL 6 DAY) AND c.visited_on
        ),2) AS average_amount # same way avg is calculated
FROM customer c
WHERE visited_on >= (
        SELECT DATE_ADD(MIN(visited_on), INTERVAL 6 DAY) # min date in 1stjan and  6 daysmore
        FROM customer # 7 jan from query as date_add
    )
GROUP BY visited_on
order by visited_on