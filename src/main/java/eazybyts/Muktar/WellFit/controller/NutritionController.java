package eazybyts.Muktar.WellFit.controller;


import eazybyts.Muktar.WellFit.model.Nutrition;
import eazybyts.Muktar.WellFit.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/nutrition")
public class NutritionController {
    @Autowired
    private NutritionService nutritionService;

    @PostMapping
    public ResponseEntity<Nutrition> logMeal(@RequestBody Nutrition nutrition) {
        Nutrition savedNutrition = nutritionService.logMeal(nutrition);
        return new ResponseEntity<>(savedNutrition, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Nutrition>> getNutritionByUser(@PathVariable Long userId) {
        return new ResponseEntity<>(nutritionService.getNutritionByUser(userId), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/date/{date}")
    public ResponseEntity<List<Nutrition>> getDailyNutrition(
            @PathVariable Long userId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return new ResponseEntity<>(nutritionService.getDailyNutrition(userId, date), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNutritionEntry(@PathVariable Long id) {
        nutritionService.deleteNutritionEntry(id);
        return ResponseEntity.noContent().build();
    }
}
