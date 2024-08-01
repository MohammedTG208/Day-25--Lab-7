package com.example.lab7week5.Controller;

import com.example.lab7week5.Model.User;
import com.example.lab7week5.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class userController {
    private final UserService userService;

    @GetMapping("/getall")
    public ResponseEntity getAllUsers(){
        if(userService.getAllUsers()==null){
            return ResponseEntity.status(400).body("You do not have any users");
        }else {
            return ResponseEntity.status(200).body(userService.getAllUsers());
        }
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }else {
            userService.addUser(user);
            return ResponseEntity.status(201).body("User added successfully");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable int id, @Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }else {
           if (userService.updateUser(user,id)) {
               return ResponseEntity.status(201).body("User updated successfully");
           }else {
               return ResponseEntity.status(400).body("User update failed check the id");
           }
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable int id){
        if(userService.deleteUser(id)){
            return ResponseEntity.status(201).body("User deleted successfully");
        }else {
            return ResponseEntity.status(400).body("User delete failed check the id");
        }
    }
    @PutMapping("/update/status/{id}")
    public ResponseEntity updateUserStatus(@PathVariable int id){
        if (userService.changeSubscribe(id)){
            return ResponseEntity.status(201).body("User updated successfully");
        }else {
            return ResponseEntity.status(400).body("User update failed check the id");
        }
    }

    @GetMapping("/get/how/subscribe")
    public ResponseEntity getHowSubscribe(){
        if (userService.displayHowSubscribe()==null){
            return ResponseEntity.status(400).body("You do not have any users have subscribe yet");
        }else {
            return ResponseEntity.status(200).body(userService.displayHowSubscribe());
        }
    }
    @PutMapping("/update/pass/{id}/{oldPass}/{newPass}")
    public ResponseEntity updatePass(@PathVariable int id, @PathVariable String oldPass, @PathVariable String newPass){
        if(userService.changePassword(oldPass,newPass,id)){
            return ResponseEntity.status(201).body("Password updated successfully");
        }else {
            return ResponseEntity.status(400).body("Enter valid password");
        }
    }
    @GetMapping("/search/{id}")
    public ResponseEntity searchUser(@PathVariable int id){
        if (userService.getUser(id)==null){
            return ResponseEntity.status(400).body("not found check the id");
        }else {
            return ResponseEntity.status(200).body(userService.getUser(id));
        }
    }
}
