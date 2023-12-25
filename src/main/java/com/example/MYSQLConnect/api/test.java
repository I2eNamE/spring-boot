package com.example.MYSQLConnect.api;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class test {
    @GetMapping
    public String testGet(){
        return "test get complete";
    }

    @PostMapping
    public String testPost(){
        return "test post complete";
    }

    @PutMapping
    public String testPut(){return "test put complete";}

    @PatchMapping
    public String testPatch() {
        return "test patch complete";
    }

    @DeleteMapping
    public String testDelete(){return "test delete complete";}
}
