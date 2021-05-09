package sk.stuba.fei.uim.oop.assignment3;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")

public class Controller {
    @Autowired
    private IProductService service;

    @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }
    @GetMapping("")
    public String test(){
        return  "test";
    }
}
