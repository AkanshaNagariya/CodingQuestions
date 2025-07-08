# Write your MySQL query statement below

select product_name, SUM(unit) AS unit
from Products Inner JOIN Orders USING(product_id)
WHERE MONTH(order_date) = 2 AND YEAR(order_date) = 2020
GROUP BY product_name
HAVING unit >= 100