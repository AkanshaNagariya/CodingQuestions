# Write your MySQL query statement below
# Rows where lat and longitude are diff should be considered so row 2 and row 3 will be removed
# as there lat and long val is same respectively
# then we have row 1 and row 4 here 2nd condn is to check
# if their tiv_2015 val is same yes for row 1 and 4 both has tiv_2015 val 10 means repeated
# so for such rows add their tiv_2016 val 

select ROUND(SUM(tiv_2016),2) As tiv_2016
from Insurance 
where tiv_2015 IN( 
    SELECT tiv_2015
    from Insurance
    GROUP BY tiv_2015
    HAVING COUNT(*) > 1
)  AND (lat,lon) IN (
    SELECT lat,lon 
    from Insurance 
    GROUP BY lat,lon 
    HAVING COUNT(*) = 1
)