package pck.day16.day16.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.json.Json;
import jakarta.json.JsonObject;

@Controller
@RequestMapping("/home")
public class HomeController {
    
    @GetMapping("/test")
    public String getTestEmployer() {
        JsonObject jEmployee = Json.createObjectBuilder()
            .add("firstName", "Tailor")
            .add("lastName", "Swift")
            .build();

        return jEmployee.toString();
    }
}
