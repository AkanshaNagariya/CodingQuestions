# Write your MySQL query statement below
select * , 
if(x+y > z AND y+z > x AND x+z > y, "Yes" , "No") As triangle
From triangle