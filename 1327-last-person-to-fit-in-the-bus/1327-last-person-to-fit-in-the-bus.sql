# Write your MySQL query statement below


select q1.person_name
from queue q1 inner join queue  q2
on q1.turn >= q2.turn
group by q1.turn
HAVING SUM(q2.weight) <= 1000
ORDER BY SUM(q2.weight) DESC
LIMIT 1