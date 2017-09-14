package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @RequestMapping(value = "")//if there is nothing infront of localhost:8080 it directs to this page
    public String index(Model model) {

        HashMap<String, String> actionChoices = new HashMap<>();
        actionChoices.put("search", "Search");//sets the 2 options for redirection search and list
        actionChoices.put("list", "List");

        model.addAttribute("actions", actionChoices);

        return "index";
    }

}
//Basically just points to index.html template