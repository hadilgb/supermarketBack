package com.back.back_end.controller;

import com.back.back_end.model.Status;
import com.back.back_end.model.User;
import com.back.back_end.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class usercontroller {
    private userrepository userrepo;
    @Autowired
    public usercontroller(userrepository userrepo){
        this.userrepo=userrepo;
    }
    @GetMapping("/getuser")
    public List<User> getall(){
        return userrepo.findAll();
    }
    @PutMapping ("/Updateuser/{id}")
    public ResponseEntity<?>  update (@PathVariable String id,@RequestBody Status stat){
        Optional <User> optionalcat = userrepo.findById(id);
        if(optionalcat.isPresent()){
            User categoryTosave = optionalcat.get();
            categoryTosave.setStatus(stat);
            userrepo.save(categoryTosave);
            return new ResponseEntity<>(categoryTosave, HttpStatus.OK);
        }
        return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);
    }



}

