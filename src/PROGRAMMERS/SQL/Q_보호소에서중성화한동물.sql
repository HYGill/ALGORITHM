SELECT O.ANIMAL_ID, O.ANIMAL_TYPE, O.NAME
FROM ANIMAL_INS I
JOIN ANIMAL_OUTS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE 
 (I.SEX_UPON_INTAKE = 'Intact Male'
 AND O.SEX_UPON_OUTCOME = 'Neutered Male')
 OR (I.SEX_UPON_INTAKE = 'Intact Female'
 AND O.SEX_UPON_OUTCOME = 'Spayed Female');