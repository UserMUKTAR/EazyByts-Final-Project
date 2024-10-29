package eazybyts.Muktar.WellFit.repository;

import eazybyts.Muktar.WellFit.model.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProgressRepository extends JpaRepository<Progress,Long> {
    List<Progress> findByUserId(Long userId);
    List<Progress> findByUserIdAndDate(Long userId, LocalDate date);
}
