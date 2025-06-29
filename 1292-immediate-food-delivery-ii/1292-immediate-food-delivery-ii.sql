# Write your MySQL query statement below
# we have delieveryid and for each we have customer id to if customer id is occured 2 times 
# we choose the first time it occured and ignore the rows rest of times it occured. like thisfor all customerid then for these rows check if ordered date and delivery date is diffor same if difff then scheduled if same then immediate , at last for all immediate rows
# its sum by total of scheduled and order_date * 100
select ROUND(SUM(IF(order_date = customer_pref_delivery_date, 1,0))*100/COUNT(DISTINCT customer_id),2)  AS immediate_percentage 
from Delivery 
Where(customer_id, order_date) IN (
    SELECT customer_id , MIN(order_date) AS first_order_date
    FROM delivery 
    group by customer_id
)