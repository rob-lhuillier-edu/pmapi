package org.example.pmapi.controllers;

import jakarta.persistence.EntityNotFoundException;
import org.example.pmapi.dto.DresseurDTO;
import org.example.pmapi.services.DresseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dresseurs")
public class DresseurController {

    @Autowired
    private DresseurService dresseurService;

    @GetMapping("id")
    public ResponseEntity<DresseurDTO> getDresseurById(@RequestParam long id) {
        try{
            return ResponseEntity.ok(dresseurService.get(id));
        } catch (EntityNotFoundException e){
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
