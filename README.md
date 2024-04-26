## README

## YOU WILL SEE HERE

- PROJECT TITLE;
- PROJECT DESCRIPTION;
- TECHNOLOGIES USED;
- SOME INSTRUCTIONS;
- LINK TO TASKS SOLUTIONS.
- ANOTHER LINKS;
- AUTHOR

---

## PROJECT TITLE

<p>My Interview Project.</p>

---

## PROJECT DESCRIPTION

This project is a test to see my skills as a Back-end Developer.The objective is to know my technical skills and also help to improve Digiage recruitment methods. There are classes named as TASK 1 to 5 in the project, these TASKS are challenges and each has comments with the objective of respective TASK.

---

## TECHNOLOGIES USED

The TASKS solutions were written and solved using JAVA with Spring Boot framework. In TASK4, as requested, Amazon products were used (AWS and S3 Bucket).

---

## SOME INSTRUCTIONS

TASK1 - Task here is to implement a function that says if a given string is palindrome.

- With the project imported correctely to STS (Spring Tool Suit). Click with right button in TASK1 and select RUN AS -> JAVA APPLICATION. In console, enter the input string as requested (the console requests are in Portuguese BR, if needed, translate to english with Google translator). After this step, prees enter and the input string should be displayed backward, then the function compares the backward input with the original and display if the given string is a palindrome or not.

TASK2 - Task here is to write a list. Each element must know the element before and after it. Them remove the element in the middle of the list.

- With the project imported correctely to STS (Spring Tool Suit). Click with right button in TASK2 and select RUN AS -> JAVA APPLICATION. The console should display a list with 5 itens (1, 2, 3, 4, 5) and then displays the same list but with the middle item removed

TASK3 - Task here is to write a list and add an aleatory number of Strings. In the end, print out how many distinct itens exists on the list.

- With the project imported correctely to STS (Spring Tool Suit). Click with right button in TASK3 and select RUN AS -> JAVA APPLICATION. In console will be displayed a list with minimun 3 strings and maximun 9 strings, after this step, is shown the number of distincts itens in this list.

TASK4 - Task here is to Create an implementation of a Rest API client (API endpoint=> https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda). Prints out how many records exists for each gender and save this file to s3 bucket API endpoint=> AWS s3 bucket => interview-digiage.

- With the project imported correctely to STS (Spring Tool Suit). Click with right button in TASK4 and select RUN AS -> JAVA APPLICATION. In console will be displayed the quantity of each gender separated by "F"(Female) and "M"(Male) exists in the data extrated from the API endpoint by a GET method. Then it will show a message informing that a file with the records was created and saved at the specificated destination (in this code, the file path is a path in my PC). After, a message will be shown to user informing if the file was correctely saved at S3 bucket. **To accsess the Endpoint, AWS access credentials were needed. Not a good practice to set keys in code, but for testing purposes, they are defined in this code**

TASK5 - Task here is to Create an implementation of a Rest API and Exposees it. Its informed to feel free to explore possibilities/functionalities/capabilities following Rest standard. Its suggested that implementation have at least a CRUD scenario.

- With the project imported correctely to STS (Spring Tool Suit). Click with right button in TASK5 and select RUN AS -> JAVA APPLICATION. This will run a API that creates products and set then in to a list with a POST method, gets all products at this list with a GET method, gets a specific product by it's ID, updates the product informations by it's ID with a put method and delete a product by it's ID. **In case, this code don't brings the messages in console because there are no database setted, and so, there aren't informations to bring**

---

## LINK TO TASKS SOLUTIONS

TASK1 - <a href="https://github.com/MgprataMKW/teste-digiage/blob/main/myinterview/src/main/java/com/example/TASK1.java"></a>

TASK2 - <a href="https://github.com/MgprataMKW/teste-digiage/blob/main/myinterview/src/main/java/com/example/TASK2.java"></a>

TASK3 - <a href="https://github.com/MgprataMKW/teste-digiage/blob/main/myinterview/src/main/java/com/example/TASK3.java"></a>

TASK4 - <a href="https://github.com/MgprataMKW/teste-digiage/blob/main/myinterview/src/main/java/com/example/TASK4.java"></a>

TASK5 - <a href="https://github.com/MgprataMKW/teste-digiage/blob/main/myinterview/src/main/java/com/example/TASK5.java"></a>

---

## ANOTHER LINKS

- link to the repository with  solution to the test: <a href="https://github.com/MgprataMKW/teste-digiage"></a>

- link to the project presentation: <a href="https://coodesh.com/pt/assessments/project/83efef75-af54-4345-a279-12bd2996ad76/intro"></a>

---

## AUTHOR

This is a challenge by [Coodesh](https://coodesh.com/) and the TASKS solving were developed by **Matheus Galvão Prata**.
