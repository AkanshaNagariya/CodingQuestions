# Write your MySQL query statement below

# select all resquest id and union with accepter id so we get all ids of friend people i.e 
# 1 req to 2 2 accepted so both 1 and 2's friend got increased by one 
# so for all now group them by id and count the num of friends for each and is with max num is ans
select id , count(*) AS num
from (
    select requester_id as id from RequestAccepted

    Union ALL

    select accepter_id from RequestAccepted
) AS friend_count
Group BY id
Order by num DESC
LIMIT 1
