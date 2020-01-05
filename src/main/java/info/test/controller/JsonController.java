package info.test.controller;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

    @RequestMapping(value = "/asjson", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JsonNode getAsJson(HttpServletRequest request) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode actualObj = null;
        try {
            actualObj = objectMapper.readTree("{\"color\":\"yellow\",\"type\":\"renault\"}");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return actualObj;
    }

}
