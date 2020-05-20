package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    //Tells it that it to handle path at /hello
//    @GetMapping("hello")
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
//    @GetMapping("hello")
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //Responds to get requests at /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
        "<body>" +
        "<form method='post' action='hello'>" + //Default method is get. So you can do it that way.
        "<input type='text' name='name'>" +
        "<input type='submit' value='Greet Me!'>" +
        "</form>" +
        "</body>" +
        "</html>";
    }
    @GetMapping("language")
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



}
