package dev.mahathir.deepseekfreeapitest.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

@Service
public class DeepSeekService {

    @Value("${openrouter.api.key}")
    private String apiKey;

    @Value("${openrouter.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String askDeepSeek(String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        Map<String, Object> requestBody = Map.of(
                "model", "google/gemini-2.0-flash-001",
                "messages", Collections.singletonList(Map.of("role", "user", "content", message)),
                "stream", false
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);
            return extractContent(response.getBody());
        } catch (Exception e) {
            return "Error: Failed to connect to DeepSeek API. " + e.getMessage();
        }
    }

    private String extractContent(String responseBody) {
        try {
            JsonNode rootNode = objectMapper.readTree(responseBody);
            return rootNode.path("choices").get(0).path("message").path("content").asText();
        } catch (Exception e) {
            return "Error: Failed to parse json response.";
        }
    }
}
