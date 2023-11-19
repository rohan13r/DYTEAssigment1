package entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogRowMapper implements RowMapper<Log> {

    @Override
    public Log mapRow(ResultSet rs, int rowNum) throws SQLException {
        Log log = new Log();
        log.setTimestamp(rs.getTimestamp("log_timestamp").toLocalDateTime());
        log.setMessage(rs.getString("log_message"));
        return log;
    }
}
