package controller;

import entity.Log;
import entity.LogRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import service.LogService;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Async
@RestController
@AllArgsConstructor
public class LogController {
    private final LogService logService;

    private final JdbcTemplate jdbcTemplate;

    @PostMapping("/logs")
    public void ingestLog(@RequestBody Log log) {
        logService.saveLogs(Collections.singletonList(log));
    }

    @GetMapping("/logs/search")
    public List<Log> searchLogs(
            @RequestParam(required = false) String level,
            @RequestParam(required = false) String message,
            @RequestParam(required = false) String regex,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate
    ) {
        Map<String, Object> params = new HashMap<>();
        params.put("level", level);
        params.put("message", "%" + message + "%");
        params.put("regex", regex);
        params.put("startDate", startDate);
        params.put("endDate", endDate);

        params = params.entrySet()
                .stream()
                .filter(entry -> entry.getValue() != null)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return jdbcTemplate.query(
                "SELECT timestamp AS log_timestamp, message AS log_message FROM logs WHERE " +
                        "(:level IS NULL OR level = :level) " +
                        "AND (:message IS NULL OR message LIKE :message) " +
                        "AND (:regex IS NULL OR message ~* :regex) " +
                        "AND (:startDate IS NULL OR timestamp >= :startDate) " +
                        "AND (:endDate IS NULL OR timestamp <= :endDate)",
                (PreparedStatementSetter) params,
                new LogRowMapper()
        );
    }
}


//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    @PostMapping("/logs")
//    public void ingestLog(@RequestBody Log log) {
//        if (log.getTimestamp() == null) {
//            log.setTimestamp(LocalDateTime.now());
//        }
//        jdbcTemplate.update(
//                "INSERT INTO logs (timestamp, message) VALUES (?, ?)",
//                log.getTimestamp(), log.getMessage()
//        );
//    }


