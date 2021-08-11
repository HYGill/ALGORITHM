/*
* join 참고 : https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=islove8587&logNo=220953972194
* 곱집합 : 두 집합에서 하나씩 고른 두 원소의 순서쌍들의 집합 
* 합집합 : 한 원소가 두 집합중 하나에 속한다는 것을 의미. 두 집합의 원소를 모을때 사용 -> UNION
* 교집합 : 공통으로 속해있는 원소 전체의 집합 -> INNER JOIN <table> ON <조건>
* 차집합 : 하나의 집합에서 다른 집합을 뺸 나머지 -> LEFT JOIN <table> ON <조건> WHERE ~~ IS NULL
            or RIGHT JOIN
* 대칭 차집합 : 둘 모두에는 속하지 않는 원소들의 집합 -> 겹치는거 뺴서 UNINON ALL
*/
SELECT ANIMAL_OUTS.ANIMAL_ID, ANIMAL_OUTS.NAME
FROM ANIMAL_OUTS LEFT JOIN ANIMAL_INS
ON ANIMAL_OUTS.ANIMAL_ID = ANIMAL_INS.ANIMAL_ID
WHERE ANIMAL_INS.ANIMAL_ID IS NULL;