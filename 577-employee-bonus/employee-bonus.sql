# Write your MySQL query statement below
select e1.name , b1.bonus from Employee as e1 
LEFT JOIN Bonus as b1 ON e1.empId = b1.empId
 where b1.bonus < 1000 OR b1.bonus is NULL;