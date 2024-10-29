package eazybyts.Muktar.WellFit.repository;

import eazybyts.Muktar.WellFit.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout,Long> {
    List<Workout> findByUserId(Long userId);
}
