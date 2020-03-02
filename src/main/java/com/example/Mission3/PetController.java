package com.example.Mission3;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@EnableAutoConfiguration

//@RestController
//@RequestMapping("/Pet")
public class PetController {
    // creating an instance of PetRepo so that its functions can be used
    PetRepo petRepo;

    public PetController(PetRepo petRepo){
        this.petRepo = petRepo;
    }
    /* create pet */
    @PostMapping("/Pet")
    public String create(@RequestBody Pet pet) {
        String tempStr = "";
        int result = 0;
        try {
            result = petRepo.createPet(pet); /*not sure what this returns,
            for now I'm thinking its the integer that determines got error or nah*/

        } catch (Exception e) {
            tempStr = "Error number: " + result + "\nError message:" + e + "\nHellooooooo";
        }
        return tempStr;
    }

    /* read all pet */
    @GetMapping("/Pet")
    @ResponseBody
    public List<Pet> readAllPets() {
//        List<Pet>localPetList = new ArrayList<>();
//        try{
//            localPetList = petRepo.readAll();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        return localPetList;
        return petRepo.readAll();
    }

    /* read specific pet by id */
    @GetMapping("/Pet/{id}")
    @ResponseBody
    public Pet readById(@PathVariable(value = "id") String iden) {
        return petRepo.readById(iden);
    }

    /* read specific pet by id and name */
    @GetMapping("/Pet/{id}/{name}")
    @ResponseBody
    public List<Pet> readByIdAndName(@PathVariable(value = "id") String iden, @PathVariable(value = "name") String nm) {
        return petRepo.readByIdAndName(iden, nm);
    }

    /* count how many pets in the pet table */
    @GetMapping("/Pet/count")
    @ResponseBody
    public int countPet() throws Exception {
        return petRepo.countPet();
    }

    /* update pet */
    @PutMapping("/Pet/{id}")
    @ResponseBody
    public int updatePet(@PathVariable(value = "id") String iden, @RequestBody Pet tempPet) throws SQLException {
        return petRepo.updatePet(iden, tempPet);
    }

    /* delete pet */
    @DeleteMapping("/Pet/{id}")
    @ResponseBody
    public int deletePet(@PathVariable(value = "id") String iden) throws SQLException {
        return petRepo.deletePet(iden);
    }
}
