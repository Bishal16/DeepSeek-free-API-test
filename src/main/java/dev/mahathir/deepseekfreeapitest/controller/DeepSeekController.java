package dev.mahathir.deepseekfreeapitest.controller;

import dev.mahathir.deepseekfreeapitest.service.DeepSeekService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/LLM")
public class DeepSeekController {

    private final DeepSeekService deepSeekService;

    public DeepSeekController(DeepSeekService deepSeekService) {
        this.deepSeekService = deepSeekService;
    }

    @PostMapping("/ask")
    public ResponseEntity<String> askDeepSeek(@RequestBody Map<String, Object> requestBody) {
        if (!requestBody.containsKey("message")) {
            return ResponseEntity.badRequest().body("Missing 'message' parameter.");
        }

        String message = requestBody.get("message").toString();
        String response = deepSeekService.askDeepSeek(message);
        return ResponseEntity.ok(response);
    }
}
