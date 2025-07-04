# Write your MySQL query statement below
select 
    case 
        when
           id = (select max(id) from seat) AND MOD(id,2)=1
           Then id
        when 
        MOD(id,2) = 1
        THEN id+1
        ELSE 
            id - 1
      END AS id , student
From Seat
ORDER BY id 