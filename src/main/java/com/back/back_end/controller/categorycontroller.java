package com.back.back_end.controller;
import com.back.back_end.model.Product;
import com.back.back_end.model.category;
import com.back.back_end.repository.ProductRepository;
import com.back.back_end.repository.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Category")
public class categorycontroller {
    private categoryRepository categoryrepo;
    @Autowired
    public categorycontroller(categoryRepository categoryrepo){
        this.categoryrepo=categoryrepo;
    }
    @GetMapping("/getcat")
    public List<category> getall(){
        return categoryrepo.findAll();
    }
    @GetMapping("/categorybyId/{id}")
    public ResponseEntity<?> getbyid (@PathVariable String id){
        Optional <category> optionalcat = categoryrepo.findById(id);
        if(optionalcat.isPresent()){
            return new ResponseEntity<>(optionalcat.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("category not found",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/categorybyName/{name}")
    public ResponseEntity<?> getbyname (@PathVariable String name){
        List <category> optionalcat = categoryrepo.findItemByName(name);
        if(optionalcat.size()>0){
            return new ResponseEntity<List<category>>(optionalcat, HttpStatus.OK);
        }
        return new ResponseEntity<>("category not found",HttpStatus.NOT_FOUND);
    }
    @PostMapping("/Createcat")
    public ResponseEntity<?> Create(@RequestBody category cat){
        try{
            categoryrepo.save(cat);
            return new ResponseEntity<category>(cat, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping ("/Updatecat/{id}")
    public ResponseEntity<?>  update (@PathVariable String id,@RequestBody category cat){
        Optional <category> optionalcat = categoryrepo.findById(id);
        if(optionalcat.isPresent()){
            category categoryTosave = optionalcat.get();
            categoryTosave.setNom(cat.getNom() != null ?cat.getNom():cat.getNom());
            categoryTosave.setImage(cat.getImage() != null ? cat.getImage() : categoryTosave.getImage());
            categoryrepo.save(categoryTosave);
            return new ResponseEntity<>(categoryTosave, HttpStatus.OK);
        }
        return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/deletecat/{id}")
    public ResponseEntity<?> delete (@PathVariable String id){
        try{
            categoryrepo.deleteById(id);
            return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }


}
