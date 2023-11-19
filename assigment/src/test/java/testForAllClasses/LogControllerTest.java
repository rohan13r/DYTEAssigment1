package testForAllClasses;

import controller.LogController;
import entity.Log;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class LogControllerTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private LogController logController;

    @Test
    void testSearchLogs() {
        Mockito.when(jdbcTemplate.query((PreparedStatementCreator) any(), any(), any()))
                .thenReturn(Collections.singletonList(new Log()));

        List<Log> result = logController.searchLogs("INFO", "error", null, null,null);

        assertEquals(1, result.size());
    }
}

