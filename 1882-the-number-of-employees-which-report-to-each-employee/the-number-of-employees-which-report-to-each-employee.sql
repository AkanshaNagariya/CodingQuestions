# Write your MySQL query statement below
# manager will be the person to whom atleast 1 person is reporting 
# ex 1 id 9 henry didn't reported to anyone and id 6 and 4 reported to id 9 henry so henry is
#manager , id 2 repored to bull but no one reported to it either so it's not manager
# return the managers id, name the no of other employees reported to it and avg of age of those
#employee who repored that manager ex for henry id 6 and 4 reported so avg age = 41+36/2
# there maybe multiple manager 
select E1.employee_id, E1.name, 
     COUNT(E2.employee_id) AS reports_count,
     ROUND(AVG(E2.age)) AS average_age
From 
    Employees E1 INNER JOIN Employees E2
ON
  E1.employee_id = E2.reports_to
GROUP BY
E1.employee_id , E1.name
ORDER BY 
employee_id