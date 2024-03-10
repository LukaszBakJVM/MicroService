package com.example.carRent.Car;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/car")
public class UserController {
    private final CarService carService;
    private final ObjectMapper objectMapper;


    public UserController(CarService carService, ObjectMapper objectMapper) {
        this.carService = carService;

        this.objectMapper = objectMapper;
    }

    @GetMapping("/allCars")
    ResponseEntity<List<CarDto>> availableCars() {
        return ResponseEntity.ok(carService.findAllCars());
    }


    @GetMapping("/rent/{id}")
    ResponseEntity<CarDto> rent(@PathVariable long id) {
        return ResponseEntity.ok(carService.findById(id));
    }

    @PatchMapping("/{id}")
    ResponseEntity<?> rentCar(@PathVariable Long id, @RequestBody JsonMergePatch patch) {
        try {
            DtoRent dtoRentBuId = carService.rentById(id);

            DtoRent dtoRent = applyPatch(dtoRentBuId, patch);
            carService.rentCar(dtoRent);

        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.internalServerError().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    private DtoRent applyPatch(DtoRent rentCarDto, JsonMergePatch patch) throws JsonPatchException, JsonProcessingException {
        JsonNode jsonNode = objectMapper.valueToTree(rentCarDto);
        JsonNode apply = patch.apply(jsonNode);
        return objectMapper.treeToValue(apply, DtoRent.class);


    }
}
