package eazybyts.Muktar.WellFit.service;

import eazybyts.Muktar.WellFit.model.Nutrition;
import eazybyts.Muktar.WellFit.repository.NutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NutritionService {
    @Autowired
    private NutritionRepository nutritionRepository;

    public Nutrition logMeal(Nutrition nutrition) {
        return nutritionRepository.save(nutrition);
    }

    public List<Nutrition> getNutritionByUser(Long userId) {
        return nutritionRepository.findByUserId(userId);
    }

    public List<Nutrition> getDailyNutrition(Long userId, LocalDate date) {
        return nutritionRepository.findByUserIdAndDate(userId, date);
    }

    public void deleteNutritionEntry(Long id) {
        nutritionRepository.deleteById(id);
    }

}
