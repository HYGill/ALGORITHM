/*
* null은 =로 하면 진짜 값의 내용이 NULL인걸 찾아주기때문에 is 써야함
* Column의 값이 NULL을 반환할 때 다른 값으로 출력하는 함수 ( IFNULL )
* if, case, ifnull, isnull, nvl 문이 있다
*/
SELECT ANIMAL_TYPE, IFNULL(NAME, "no name"), SEX_UPON_INTAKE
FROM ANIMAL_INS;