package eazybyts.Muktar.WellFit.service;


import eazybyts.Muktar.WellFit.model.Progress;
import eazybyts.Muktar.WellFit.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProgressService {
    @Autowired
    private ProgressRepository progressRepository;

    public Progress logProgress(Progress progress) {
        return progressRepository.save(progress);
    }

    public List<Progress> getProgressByUser(Long userId) {
        return progressRepository.findByUserId(userId);
    }

    public List<Progress> getProgressByDate(Long userId, LocalDate date) {
        return progressRepository.findByUserIdAndDate(userId, date);
    }

    public void deleteProgressEntry(Long id) {
        progressRepository.deleteById(id);
    }
}
