# Openrouter Free LLM API Test

This is a simple Spring Boot project that acts as a wrapper for the [LLM API](https://openrouter.ai/). The project enables you to send a message to the selected LLM API and get a response from it.

## Features
- Integration with LLM API to get responses for user-provided messages.
- Handles API responses and parses out the content.
- REST API endpoint to interact with the LLM API.

## Prerequisites
Before running the project, make sure you have the following installed:
- [Java 17 or above](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)

## Setup

1. **Clone the repository**

   First, clone the project to your local machine:

   ```bash
   git clone https://github.com/Bishal16/Openrouter-free-LLM-API-test.git

2. **Configure application properties**

In the src/main/resources/application.properties file, add your openrouter API key and API URL. Replace the placeholders with actual values:

## properties

```
openrouter.api.key=<openrouter.ai api key>
openrouter.api.url=https://openrouter.ai/api/v1/chat/completions
```

3. **Build the project**

Use Maven to build the project:

```
mvn clean install
```

4. **Run the application**

After building the project, you can run the application using:

```
mvn spring-boot:run
```

This will start the Spring Boot application, and it will be available at http://localhost:9090.

## Usage
Once the application is running, you can interact with the API endpoint to ask questions. Here's how to use it:

Send a POST request

Send a POST request to http://localhost:9090/api/LLM/ask with a JSON body containing the message you want to send to specified LLM.

Example request:

```
{
    "message": "write a c program to print triangle with *"
}
```

The API will respond with the answer from the selected LLM API, parsed and ready to use.

Example response:

```c
#include <stdio.h>

int main() {
  int rows, i, j, space;

  printf("Enter the number of rows for the triangle: ");
  scanf("%d", &rows);

  // Build the triangle row by row
  for (i = 1; i <= rows; i++) { 
    // Print leading spaces to center the triangle
    for (space = 1; space <= rows - i; space++) {
      printf(" ");  
    }

    // Print asterisks for the current row
    for (j = 1; j <= (2 * i - 1); j++) {
      printf("*");
    }

    // Move to the next line after printing the row
    printf("\n");
  }

  return 0;
}
```

**Explanation:**

1. **Include Header:**
   - `stdio.h`:  This header file provides standard input/output functions like `printf` (for printing to the console) and `scanf` (for reading user input).

2. **Declare Variables:**
   - `rows`:  Stores the number of rows the user wants in the triangle.  This determines the triangle's height and width.
   - `i`:  Loop counter for the outer loop (iterating through rows).
   - `j`:  Loop counter for the inner loops (printing spaces and asterisks within each row).
   - `space`: Loop counter for printing the leading spaces needed for alignment.

3. **Get User Input:**
   - `printf("Enter the number of rows for the triangle: ");`: Prompts the user to enter the number of rows.
   - `scanf("%d", &rows);`: Reads the integer value entered by the user and stores it in the `rows` variable.

4. **Outer Loop (Rows):**
   - `for (i = 1; i <= rows; i++)`: This loop iterates from `i = 1` up to `i = rows`.  Each iteration represents one row of the triangle.

5. **Inner Loop 1 (Spaces):**
   - `for (space = 1; space <= rows - i; space++)`: This loop prints the leading spaces before the asterisks in each row.
     - The number of spaces needed decreases as you go down the rows (to create the triangular shape).
     - `rows - i` calculates the number of spaces needed for the current row `i`. As `i` grows, the number of spaces decreases.
     - `printf(" ");`: Prints a single space.

6. **Inner Loop 2 (Asterisks):**
   - `for (j = 1; j <= (2 * i - 1); j++)`: This loop prints the asterisks for the current row.
     - The number of asterisks increases as you go down the rows.
     - `2 * i - 1` calculates the number of asterisks needed for row `i`. The first row has 1 asterisk, the second row has 3, the third row has 5, and so on.
     - `printf("*");`: Prints a single asterisk.

7. **Newline:**
   - `printf("\n");`:  After printing all the spaces and asterisks for a given row, this moves the cursor to the next line to start the next row.

8. **Return 0:**
   - `return 0;`:  Indicates that the program executed successfully.

**How the Spacing Works:**

The key is to calculate the correct number of leading spaces on each row. If you want a 5-row triangle, consider the spacing:

| Row | Spaces | Asterisks |
|-----|--------|-----------|
| 1   | 4      | 1         |
| 2   | 3      | 3         |
| 3   | 2      | 5         |
| 4   | 1      | 7         |
| 5   | 0      | 9         |

The spaces are calculated as `rows - i`.  The asterisks are calculated as `2 * i - 1`.

**Example Usage:**

If the user enters `5` as the number of rows, the output will be:

```
    *
   ***
  *****
 *******
********* 
```

