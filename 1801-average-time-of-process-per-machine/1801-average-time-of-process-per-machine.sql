# Write your MySQL query statement below
select a1.machine_id , ROUND(AVG(a2.timestamp - a1.timestamp),3)
As processing_time
from Activity  a1 
INNER JOIN Activity a2 
ON a1.machine_id = a2.machine_id
and a1.process_id = a2.process_id
and a1.activity_type='start' and a2.activity_type='end'
group by machine_id;