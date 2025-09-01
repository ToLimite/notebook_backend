package com.example.project.service.impl;

import com.example.project.service.LLMService;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

@Service
public class LLMServiceImpl implements LLMService {

    @Override
    public String askLLM(String text) {
        String t = text;
        t = t.replaceAll("\\t", "");
        t = t.replaceAll("\\n", "");
        HttpResponse<String> response = Unirest.post("https://open.bigmodel.cn/api/paas/v4/chat/completions")
                .header("Authorization", "Bearer 036cb12c2c0841fd8869cbc07aa1d1dc.OyeNpytYJshBVQcX")
                .header("Content-Type", "application/json")
                .body("{\n  \"model\": \"glm-4-flashx-250414\",\n  \"do_sample\": true,\n  \"stream\": false,\n  \"thinking\": {\n    \"type\": \"enabled\"\n  },\n  \"temperature\": 0.6,\n  \"top_p\": 0.95,\n  \"response_format\": {\n    \"type\": \"text\"\n  },\n  \"messages\": [\n    {\n      \"role\": \"user\",\n      \"content\": \""
                        + "请帮我总结一下这段笔记：" + t +
                        "\"\n    }\n  ]\n}")
                .asString();
        String jsonString = response.getBody();
        String content = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonString);
            content = rootNode
                    .path("choices")
                    .get(0)
                    .path("message")
                    .path("content")
                    .asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

}
