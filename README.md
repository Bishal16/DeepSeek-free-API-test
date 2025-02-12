# DeepSeek Free API Test

This is a simple Spring Boot project that acts as a wrapper for the [DeepSeek API](https://openrouter.ai/). The project enables you to send a message to the DeepSeek API and get a response from it.

## Features
- Integration with DeepSeek API to get responses for user-provided messages.
- Handles API responses and parses out the content.
- REST API endpoint to interact with the DeepSeek API.

## Prerequisites
Before running the project, make sure you have the following installed:
- [Java 17 or above](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)

## Setup

1. **Clone the repository**

   First, clone the project to your local machine:

   ```bash
   git clone https://github.com/yourusername/deepseek-free-api-test.git

2. **Configure application properties

In the src/main/resources/application.properties file, add your DeepSeek API key and API URL. Replace the placeholders with actual values:

properties
Copy
Edit
deepseek.api.key=your_deepseek_api_key_fromopenroute.ai
deepseek.api.url=https://openrouter.ai/api/v1/chat/completions

3. **Build the project

Use Maven to build the project:

 ```
    mvn clean install
```

4. **Run the application

After building the project, you can run the application using:

```
mvn spring-boot:run
```

This will start the Spring Boot application, and it will be available at http://localhost:9090.

***Usage
Once the application is running, you can interact with the API endpoint to ask questions. Here's how to use it:

Send a POST request

Send a POST request to http://localhost:9090/api/deepseek/ask with a JSON body containing the message you want to send to DeepSeek.

Example request:

```
{
    "message": "What is the capital of France?"
}
```
Receive a response

The API will respond with the answer from the DeepSeek API, parsed and ready to use.

Example response:

```
{
    "content": "The capital of France is Paris."
}
```
