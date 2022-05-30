package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping(value="/api/test", produces=MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    @ResponseBody
    @GetMapping("/hello")
    public String getPatientsAppointments() {
        return  "hello world :)";

        
    }
}
