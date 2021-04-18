# prime-number-service

This Service to calculate and return a collection of all prime numbers up to a specified upper limit in number

it's Based on Sieve Of Eratosthenes. Time efficiency is O(n logn).

clone the project from master branch

Do the mvn clean install

once after build successful -start the application by running PrimeNumberServiceApplication java file with help of any IDE once application is started Please follow steps to test from post man.

post man URL :

http://localhost:8080/prime/numberList

Headers : Content-Type :application/json UpperLimit: any postive int value Example 10 (MAndatory header).

Please refer the swagger document for the more information .

which will be under prime-number-service\src\main\resources\static

if you face any problem in the above steps - please reach out to rchimalamarri@gmail.com
