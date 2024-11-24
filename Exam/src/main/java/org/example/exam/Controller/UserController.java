package org.example.exam.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.exam.ApiResponse.ApiResponse;
import org.example.exam.Model.User;
import org.example.exam.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/LMS/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUsers(){

        ArrayList<User> users = userService.getUsers();
        return ResponseEntity.status(200).body(users);

    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){


       if(errors.hasErrors())
           return  ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());


       userService.addUser(user);

       return ResponseEntity.status(200).body(new ApiResponse("User added!"));



    }

    @PutMapping("/update/{ID}")
    public ResponseEntity updateUser(@PathVariable String ID, @RequestBody @Valid User user, Errors errors){

        if(errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());


        boolean isUpdated = userService.updateUser(ID, user);

        if(isUpdated)
            return ResponseEntity.status(200).body(new ApiResponse("User updated!"));


        return ResponseEntity.status(400).body(new ApiResponse("User with this ID not found!"));


    }


    @DeleteMapping("/delete/{ID}")
    public ResponseEntity deleteUser(@PathVariable String ID){

        boolean isDeleted = userService.deleteUser(ID);
        if(isDeleted)
            return ResponseEntity.status(200).body(new ApiResponse("User deleted!"));


        return ResponseEntity.status(400).body(new ApiResponse("User not found!"));

    }
    @GetMapping("/same-balance/{balance}")
    public ResponseEntity sameBalance(@PathVariable double balance){

        ArrayList<User> users = userService.sameBalance(balance);

        return ResponseEntity.status(200).body(users);


    }
    @GetMapping("/same-age/{age}")
    public ResponseEntity sameAge(@PathVariable int age){

        ArrayList<User> users = userService.sameAge(age);

        return ResponseEntity.status(200).body(users);


    }




}
