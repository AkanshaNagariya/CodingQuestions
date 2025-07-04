# Write your MySQL query statement below
(select name As results 
from Users 
Inner Join MovieRating Using(user_id)
Group By user_id
Order by count(rating) desc, name
LIMIT 1)
UNION ALL 
(select title As results 
from Movies
Inner Join MovieRating Using(movie_id)
where Month(created_at) = '02' AND YEAR(created_at) = '2020'
Group By title
Order by AVG(rating) desc, title
LIMIT 1)