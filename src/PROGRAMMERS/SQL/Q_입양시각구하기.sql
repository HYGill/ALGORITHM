/*
* count(*)와 count(1)은 모든 행의 수를 카운트, count(컬럼)은 해당 컬럼이 null이면 count 안함
*/
SELECT hour(DATETIME) as HOUR, COUNT(*) as COUNT 
FROM ANIMAL_OUTS 
GROUP BY hour(DATETIME)
HAVING HOUR > 8 and HOUR < 20
ORDER BY hour(DATETIME);