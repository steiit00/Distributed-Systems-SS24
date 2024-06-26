package Lab.Tools;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.io.InputStream;

public class Responses {

    public static ResponseEntity okResponse(Object o) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writeValueAsString(o);
        return ResponseEntity.ok(response);
    }

    public static ResponseEntity okFullResponse(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        String response = objectMapper.writeValueAsString(o);
        return ResponseEntity.ok(response);
    }

    public static ResponseEntity okStreamResponse(InputStream inputStream) throws JsonProcessingException, IOException {
        return ResponseEntity
                .ok()
                .contentLength(inputStream.available())
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(new InputStreamResource(inputStream));
    }

    public static ResponseEntity successResponse() {
        ObjectNode jsonResponse = new ObjectMapper().createObjectNode();
        jsonResponse.put("response", "Success");
        String response = jsonResponse.toString();
        return ResponseEntity.ok(response);
    }

    public static ResponseEntity badResponse(Exception e) {
        ObjectNode jsonResponse = new ObjectMapper().createObjectNode();
        jsonResponse.put("response", "Server error: " + e.getMessage());
        String response = jsonResponse.toString();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    public static ResponseEntity conflictResponse(String col) {
        ObjectNode response = new ObjectMapper().createObjectNode();
        response.put("response", "Column conflict - " + col);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response.toString());
    }

    public static ResponseEntity failedDependencyResponse() {
        return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).build();
    }
}
