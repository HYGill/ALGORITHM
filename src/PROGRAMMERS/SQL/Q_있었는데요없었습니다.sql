/*
* ID 값이 같은 것만 비교하기 위해 Inner Join 사용
* 내부조인은 join on 생략해서 밑에 방식으로도 사용 가능
*/
SELECT O.ANIMAL_ID, O.NAME
FROM ANIMAL_INS I
JOIN ANIMAL_OUTS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.DATETIME > O.DATETIME
ORDER BY I.DATETIME


SELECT O.ANIMAL_ID, O.NAME
FROM ANIMAL_INS I, ANIMAL_OUTS O
WHERE I.ANIMAL_ID = O.ANIMAL_ID and I.DATETIME > O.DATETIME
ORDER BY I.DATETIME