package eazybyts.Muktar.WellFit.repository;

import eazybyts.Muktar.WellFit.model.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface NutritionRepository extends JpaRepository<Nutrition, Long> {
    List<Nutrition> findByUserIdAndDate(Long userId, LocalDate date);
    List<Nutrition> findByUserId(Long userId);
}
