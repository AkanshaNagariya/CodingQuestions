# Write your MySQL query statement below

# so there are diff player id , if player id is repeating again on next day ex 1 is event date 
#1st march also 2nd march , no other id is repeating on alternate days 
# give it's fraction / total distinc id so 1/3 = 0.33 , round off 2

select round(count(distinct player_id /*from where condn*/)/(select count(distinct player_id)
from activity),2) as fraction 
from activity
where (player_id, DATE_SUB(event_date, INTERVAL 1 DAY)) IN (
    SELECT player_id, MIN(event_date) AS first_login #min that is first time that player id
    from Activity                                    # occured
    Group by player_id
)
 