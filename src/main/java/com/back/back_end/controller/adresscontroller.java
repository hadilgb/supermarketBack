package com.back.back_end.controller;
import com.back.back_end.model.Adress;
import com.back.back_end.repository.adresserepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Adress")
public class adresscontroller {
    private adresserepository repo;
    @Autowired
    public adresscontroller(adresserepository repo){
        this.repo=repo;
    }
    @GetMapping("/get")
    public List<Adress> getall(){
        return repo.findAll();
    }
    @GetMapping("/getbyId/{id}")
    public ResponseEntity<?> getbyid (@PathVariable String id){
        Optional<Adress> optionalcat = repo.findById(id);
        if(optionalcat.isPresent()){
            return new ResponseEntity<>(optionalcat.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("adress not found",HttpStatus.NOT_FOUND);
    }
    @PostMapping("/Createprod")
    public ResponseEntity<?> Create(@RequestBody Adress adr){
        try{
            repo.save(adr);
            return new ResponseEntity<Adress>(adr, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping ("/Update/{id}")
    public ResponseEntity<?>  update (@PathVariable String id,@RequestBody Adress cat){
        Optional <Adress> optionalcat = repo.findById(id);
        if(optionalcat.isPresent()){
            Adress categoryTosave = optionalcat.get();
            categoryTosave.setAdresse(cat.getAdresse() != null ?cat.getAdresse():cat.getAdresse());
            categoryTosave.setGouvernorat(cat.getGouvernorat() != null ? cat.getGouvernorat() : categoryTosave.getGouvernorat());
            repo.save(categoryTosave);
            return new ResponseEntity<>(categoryTosave, HttpStatus.OK);
        }
        return new ResponseEntity<>("adress not found",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable String id){
        try{
            repo.deleteById(id);
            return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }


}
