package co.uk.jdreamer.covid19tracker.controllers;

import co.uk.jdreamer.covid19tracker.models.LocationStats;
import co.uk.jdreamer.covid19tracker.services.Covid19DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private Covid19DataService covid19DataService;

    @GetMapping("/")
    public String home(Model model) throws IOException, InterruptedException {
        List<LocationStats> allStats = covid19DataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(state -> state.getLatestTotalCases()).sum();
        int totalNewReportedCases = allStats.stream().mapToInt(state -> state.getDiffFromPreviousDay()).sum();
        model.addAttribute("locationStats",allStats);
        model.addAttribute("totalReportedCases",totalReportedCases);
        model.addAttribute("totalNewReportedCases",totalNewReportedCases);
        return "home";
    }
}
