# Write your MySQL query statement below
select 
    case 
        when 
           id = (select max(id) from seat) AND MOD(id,2)=1 # when we check last id i.e max and 
           # it is odd so keep id as it is no change
           Then id # same
        when   # if it is not last id then check
        MOD(id,2) = 1   # if id is odd no 
        THEN id+1 # swap it with next id
        ELSE 
            id - 1  # swap it with previous id
      END AS id , student # show as id, student
From Seat
ORDER BY id 