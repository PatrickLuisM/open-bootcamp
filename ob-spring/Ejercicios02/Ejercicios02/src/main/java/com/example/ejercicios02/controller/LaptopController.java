package com.example.ejercicios02.controller;

import com.example.ejercicios02.entitie.Laptop;
import com.example.ejercicios02.respository.LaptopRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.rowset.serial.SerialException;
import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/ejercicio/laptops")
    public List<Laptop> listado(){
        return laptopRepository.findAll();
    }

    @PostMapping("/ejercicio/crear")
    public ResponseEntity<Laptop> crear(@RequestBody Laptop laptop) throws ServerException {
        Laptop laptop1 = laptopRepository.save(laptop);
        if(laptop1 == null){
            throw new ServerException("Error al crear usuario");
        }else{
            return new ResponseEntity<>(laptop1, HttpStatus.CREATED);
        }
    }

}
