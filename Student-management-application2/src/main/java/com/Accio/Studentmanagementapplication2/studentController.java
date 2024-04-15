package com.Accio.Studentmanagementapplication2;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController

public class studentController {
    Map<Integer,Student> hm = new HashMap<>();
    //we have created a hm which stores key of type integer & value of student .
    //where key is regNo,and value is student class.


    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        hm.put(student.getRegNo(),student);
        return "Student added sucessfully";
        //localhost:8080/add
        /*in Tomcat -> body -> raw -> JSON
        "regNo":1000,
        "name":"sai",
        "age":23,
        "course":"ece",
        "semYear":8
        */
    }
    @GetMapping("/get")
    public Student getStudent(@RequestParam("q") int regNo){
        return hm.get(regNo);
        //localhost:8080/get?q=1000
    }
    @GetMapping("/getbyPath/{id}")
    public Student getStudentbypath(@PathVariable("id") int regNo){
        return hm.get(regNo);
        //localhost:8080/getbyPath/2000
    }

    @PutMapping("/updatebyrequestparam")
    //updating student age by Requestparam
    public Student updateStudentbyrequestparam(@RequestParam("id") int regNo,@RequestParam("age") int newage){
        hm.get(regNo).setAge(newage);
        return hm.get(regNo);
        //localhost:8080/updatebyrequestparam?id=1000&age=23
    }

    @PutMapping("/updatebypathvariable/{id}/{age}")
    public Student updatebypathvariable(@PathVariable("id") int regNo,@PathVariable("age") int newage){
        //updating student age by pathvariable
        hm.get(regNo).setAge(newage);
        return hm.get(regNo);
        //localhost:8080/updatebypathvariable/1000/24
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int regNo){
        hm.remove(regNo);//this only delets given key and its values in hm
        //hm.clear();this is wrong because it delets entire hm
        return "student has been deleted";
        //localhost:8080/delete?id=1000
    }

    @PutMapping("/updatecoursebypathvariable/{id}/{course}")
    public Student updatecourse(@PathVariable("id") int regNo,@PathVariable("course") String course){
        hm.get(regNo).setCourse(course);
        return hm.get(regNo);
        //localhost:8080/updatecoursebypathvariable/1000/it
    }
    @PutMapping("/updatecoursebyreqparam")
    public Student updatecoursebyreqparam( @RequestParam("id") int regNo,@RequestParam("course") String newcourse) {
        hm.get(regNo).setCourse(newcourse);
        return hm.get(regNo);
        //localhost:8080/updatecoursebyreqparam?id=1000&course=it
    }

}
