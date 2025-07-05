# Write your MySQL query statement below
# changed price on 2019-08-16
# 1 -> 1's price  changed from 10 to 20 to 30 to 35 so on 16th aug it is 35
# 2 -> 2's price changed from 10 to 50 and 65 on 17th aug but we want price on 16th aug so 
# on 16th aug 2's price is 50 only
# 3-> 3's price will be 10 only on 16th aug 

select product_id, new_price as price  
from products 
where (product_id, change_date) IN 
( # the max of date which is less than = 16 aug where price changed for that id
    SELECT product_id, max(change_date)
    from Products 
    where change_date <= '2019-08-16'
    Group by product_id
)
UNION # combines results of both
SELECT product_id, 10 AS price # if no value of that id changed before aug 16 then 10 is it's
From Products                  # initial value
Where product_id NOT IN
(
    SELECT product_id
    FROM products
    where change_date <= '2019-08-16'
)