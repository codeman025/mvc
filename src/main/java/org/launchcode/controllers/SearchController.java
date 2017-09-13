package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - COMPLETE - Create handler to process search request and display results
    @RequestMapping(value = "results")
    public String search(@RequestParam String searchType, @RequestParam String searchTerm, Model model) {
        Iterable<HashMap<String, String>> jobs;
        if (searchType.equals("all")) {
            jobs = JobData.findByValue(searchTerm);
        }
        else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
            model.addAttribute("selectedColumn", searchType);
        }

        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("jobs", jobs);

        return "search";
    }

}
// should take 2 parameters named after type of search and the search term
    //use correcct annotations for method and parameters, refer to search.html
    //after looking up results via the JobData class youll need to pass them into the search.html
    //also pass listController.columnChoices to the view as the existing search handler does

