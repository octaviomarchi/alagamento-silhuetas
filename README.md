# Flooded Silhouettes Calculator #

File's content format must follow this rules:

- First line: An integer that represents the quantity of cases to be analyzed.

- Second line: An integer that represents the length of the matrix, in other words, the number of silhouettes of the case.

- Third line: A sequence of integers separated by blank spaces. Each integer represents the height of the silhouette.

You can repeat lines 2 and 3 for each case you want to include in the calculation.

## Set up ##

** Requirements: **

- Java 8 or newer;
- Maven 3.2+

In order for the application work properly you need to place your file into the ***resources folder*** and put the file name in the variable ***FILE_NAME*** in ***FloodedSilhouettesApplication, line 26***

** Running **

Inside the project folder run:

``` ./mvnw spring-boot:run ```

** Testing **

Inside the project folder run:

```mvn test```

** Output **

There will be a file generated inside ***resources folder*** named:
 ```[file-name]-results.txt```