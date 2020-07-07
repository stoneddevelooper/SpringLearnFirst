package org.example.exampleStringFirst;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model) {
        model.put("name", name);
        return "hello";
    }

    @GetMapping("/inputName")
    public String inputName() {
        return "inputName";
    }

    @RequestMapping(params = "username", method = RequestMethod.POST)
    public void inputName( @RequestParam(name = "username", required=false, defaultValue="World") String name,
                           Map<String, Object> model) {
        hello(name, model);
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("hey", "Hello, let's code!");
        return "main";
    }

    @PostMapping("/myName")
    public String myName(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model) {
        return hello(name, model);
    }
}
