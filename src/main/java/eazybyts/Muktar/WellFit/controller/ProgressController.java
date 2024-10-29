package eazybyts.Muktar.WellFit.controller;

import eazybyts.Muktar.WellFit.model.Progress;
import eazybyts.Muktar.WellFit.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/progress")
public class ProgressController {
    @Autowired
    private ProgressService progressService;

    @PostMapping
    public ResponseEntity<Progress> logProgress(@RequestBody Progress progress) {
        Progress savedProgress = progressService.logProgress(progress);
        return new ResponseEntity<>(savedProgress, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Progress>> getProgressByUser(@PathVariable Long userId) {
        return new ResponseEntity<>(progressService.getProgressByUser(userId), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/date/{date}")
    public ResponseEntity<List<Progress>> getProgressByDate(
            @PathVariable Long userId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return new ResponseEntity<>(progressService.getProgressByDate(userId, date), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgressEntry(@PathVariable Long id) {
        progressService.deleteProgressEntry(id);
        return ResponseEntity.noContent().build();
    }
}
