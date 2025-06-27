# Write your MySQL query statement below
# we have user_id and contest_id for that user_ids so lets say for contest_id 215
#in register table there are 2 entries one with user id 6 and one with id 7  and 
#in user_id table total 3 ids 6 2 7 so percentage = 2/3(total id) * 100 for percentage
#and grouped by , round and order used as desribed
select contest_id , ROUND((COUNT(distinct user_id))*100/(SELECT COUNT( user_id) FROM
Users),2)
AS percentage
FROM Register 
GROUP BY contest_id
ORDER BY percentage desc, contest_id