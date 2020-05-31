package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
//@ResponseBody
@RequestMapping("hello")
public class HelloController {
    //Tells it that it to handle path at /hello
//    @GetMapping("hello")
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //lives at /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
//    @GetMapping("hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String aGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", aGreeting); //aGreeting is the attribute value. The attribute name is specified in the template.
        return "hello";
    }

    //Responds to get requests at /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    @GetMapping("form")
//    @ResponseBody
    public String helloForm() {
            return "form";
    }

    @GetMapping("language")
    @ResponseBody
    public String helloLanguage() {
        return "<html>" +
                    "<body>" +
                        "<form method='post' action='world'>" +
                            "<input type='text' name='name'>" +
                            "<label>Select Language</label>" +
                                "<select name = 'language'>" +
                                    "<option value='french'>French</option>" +
                                    "<option value='spanish'>Spanish</option>" +
                                    "<option value='gaelic'>Gaelic</option>" +
                                    "<option selected='selected'>English</option>" +
                                    "<option value='xhosa'>Xhosa</option>" +
                                 "</select>" +
                            "<input type='submit' value='Greet Me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";

        }

    @RequestMapping(value = "world", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public static String createMessage(@RequestParam String name, @RequestParam String language) {
        switch (language) {
            case "french":
                return "Bonjour, " + name + "!";
            case "spanish":
                return "Hola, " + name + "!";
            case "gaelic":
                return "Dia dhuit, " + name + "!";
            case "xhosa":
                return "Mholo, " + name + "!";
        }
       return "Hello, " + name + "!";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        ArrayList<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }



}
