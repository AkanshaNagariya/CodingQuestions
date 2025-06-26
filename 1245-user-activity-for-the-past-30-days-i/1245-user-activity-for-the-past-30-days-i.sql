# Write your MySQL query statement below

# given date is enddate 2019-07-27 and 30 days so start will be 2019-07-27
#so rows that doesn't lie in this activity date range will be out for rest we will group them
#i.e activity dates so we have 2 groups one of date 2019-07-20 now we count the active user for 
#this active dates group so active user i.e no of distinct id's so for this group distinct id=2

SELECT activity_date as day, COUNT(DISTINCT user_id) as active_users
from Activity 
where activity_date >= '2019-06-28' AND activity_date <= '2019-07-27'
GROUP BY activity_date;
