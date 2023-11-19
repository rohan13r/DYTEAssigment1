package testForAllClasses;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LogControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testSearchLogsIntegration() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "/logs/search?level=INFO&message=error",
                String.class
        );

        assertEquals(200, response.getStatusCodeValue());
    }
}
