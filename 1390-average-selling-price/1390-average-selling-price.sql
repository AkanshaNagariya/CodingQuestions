# Write your MySQL query statement below
# basically prices table mein first row mein id = 1 is same is unitssold table and its purchase date is > startdate and <enddate in prices table, in second row also there is same id 1 but its purchase date isn't in range of start and end of first row of prices , its in range of second row where id = 1 so for all id 1 avg = sum(5*100 + 20*15)/100+15 i.e price*units 
# of both row of id =1 divide by total of all units where id = 1, left join for all product id
  
select p.product_id , IFNULL(ROUND(SUM(p.price * u.units)/SUM(u.units),2),0.00) as average_price
From Prices p 
Left join UnitsSold u
On p.product_id = u.product_id
AND u.purchase_date >= p.start_date
AND u.purchase_date <= p.end_date
GROUP BY product_id;