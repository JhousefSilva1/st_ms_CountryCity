//package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;
//
//import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StPersonsStPersonsTypeService;
//import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPersonsStPersonsTypeEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/persons/PersonTypes")
//public class StPersonsStPersonsTypeController {
//
//    @Autowired
//    private StPersonsStPersonsTypeService stPersonsStPersonsTypeService;
//
//    @GetMapping
//    public List<StPersonsStPersonsTypeEntity> getAllPersonsTypePerson() {
//        return stPersonsStPersonsTypeService.getAllPersonsTypePerson();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<StPersonsStPersonsTypeEntity> getPersonTypePersonById(@PathVariable int id) {
//        return stPersonsStPersonsTypeService.getPersonTypePersonById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//    @PostMapping
//    public StPersonsStPersonsTypeEntity createPersonTypePerson(@RequestBody StPersonsStPersonsTypeEntity personTypePerson) {
//        return stPersonsStPersonsTypeService.createPersonTypePerson(personTypePerson);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<StPersonsStPersonsTypeEntity> updatePersonTypePerson(@PathVariable int id, @RequestBody StPersonsStPersonsTypeEntity personTypePersonDetails) {
//        return ResponseEntity.ok(stPersonsStPersonsTypeService.updatePersonTypePerson(id, personTypePersonDetails));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePersonTypePerson(@PathVariable int id) {
//        stPersonsStPersonsTypeService.deletePersonTypePerson(id);
//        return ResponseEntity.noContent().build();
//    }
//
//}
