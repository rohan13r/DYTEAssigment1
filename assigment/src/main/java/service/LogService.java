package service;

import entity.Log;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LogRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LogService {
    private final LogRepository logRepository;
    @Transactional
    public void saveLogs(List<Log> logs) {
        for (Log log : logs) {
            logRepository.save(log);
        }
    }
}
