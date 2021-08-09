/*
* distinct : 조회하려는 칼럼의 중복되는 값은 제거 후 보여준다.
* select 구문에 여러 컬럼명이 올때 그 중 한개에 대해서만 적용할 수 없다
*/

SELECT COUNT(DISTINCT NAME) as count FROM ANIMAL_INS WHERE NAME IS NOT NULL;