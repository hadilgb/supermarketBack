package com.back.back_end.controller;


import com.back.back_end.model.Reclamation;
import com.back.back_end.repository.ProductRepository;
import com.back.back_end.repository.categoryRepository;
import com.back.back_end.repository.reclamationrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reclamation")
public class reclamationcontroller {

    private reclamationrepository repo;
    @Autowired
    public reclamationcontroller(reclamationrepository repo){
        this.repo=repo;
    }
    @GetMapping("/get")
    public List<Reclamation> getall(){
        return repo.findAll();
    }
    @GetMapping("/getbyId/{id}")
    public ResponseEntity<?> getbyid (@PathVariable String id){
        Optional<Reclamation> optionalcat = repo.findById(id);
        if(optionalcat.isPresent()){
            return new ResponseEntity<>(optionalcat.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Reclamation not found",HttpStatus.NOT_FOUND);
    }
    @PostMapping("/Createprod")
    public ResponseEntity<?> Create(@RequestBody Reclamation adr){
        try{
            repo.save(adr);
            return new ResponseEntity<Reclamation>(adr, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/Update/{id}")
    public ResponseEntity<?>  update (@PathVariable String id,@RequestBody Reclamation cat){
        Optional <Reclamation> optionalcat = repo.findById(id);
        if(optionalcat.isPresent()){
            Reclamation categoryTosave = optionalcat.get();
            categoryTosave.setEtat(cat.getEtat());
            repo.save(categoryTosave);
            return new ResponseEntity<>(categoryTosave, HttpStatus.OK);
        }
        return new ResponseEntity<>("Reclamation not found",HttpStatus.NOT_FOUND);
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
