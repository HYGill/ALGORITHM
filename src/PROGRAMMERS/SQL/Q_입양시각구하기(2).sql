/*
* set : 쿼리에 변수 사용할 수 있게하는 명령어
* 옆에 끼워맞추기 위해서는 where절하고 같이써야되는군,, 조인할때도 그렇다 나는야 바보
*/
SET @start := -1; 
SELECT (@start := @start + 1) as HOUR,
    (SELECT COUNT(*) FROM ANIMAL_OUTS WHERE @start= HOUR(DATETIME)) as COUNT
FROM ANIMAL_OUTS
WHERE @start < 23