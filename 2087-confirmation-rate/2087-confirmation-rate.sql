# Write your MySQL query statement below
# basically signups table mein ek user_id hai woh confirmations table mein foreign key and it is repeated multiple times toh hume har user_id ka confirmation rate chahiye and that is ex
# user_id 3 2 times aaya hai and both time it is timeout so 0/2 and id 7 is 3 times and all 3
# action is confirmed so 3/3 confirmed action/occurence and we are checking this for each id 
# of signups table means left join and group by for ids , if some userid is not in confirmation
#table then confirmed action null so return 0.00 and round confirmation_rate upto 2 decimal

select s.user_id, IFNULL(ROUND(SUM(action = "confirmed")/COUNT(*),2), 0.0) #count* means total of values in that group
as confirmation_rate
from Signups s
Left Join Confirmations c
ON s.user_id = c.user_id
GROUP BY s.user_id;