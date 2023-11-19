package testForAllClasses;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LogControllerSampleQueriesTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testSearchLogsByLevel() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "/logs/search?level=ERROR",
                String.class
        );
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testSearchLogsByMessage() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "/logs/search?message=exception",
                String.class
        );
        assertEquals(200, response.getStatusCodeValue());
    }

}
