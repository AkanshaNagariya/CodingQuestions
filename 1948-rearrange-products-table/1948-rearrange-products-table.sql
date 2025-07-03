# Write your MySQL query statement below

select product_id, 'store1' as store , store1 AS price
from Products 
where store1 is NOT NUll
UNION
select product_id, 'store2' as store , store2 AS price
from Products 
where store2 is NOT NUll
UNION
select product_id, 'store3' as store , store3 AS price
from Products 
where store3 is NOT NUll;
