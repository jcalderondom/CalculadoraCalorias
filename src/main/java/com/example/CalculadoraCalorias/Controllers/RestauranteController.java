package com.example.CalculadoraCalorias.Controllers;

import com.example.CalculadoraCalorias.DTOS.PlatoDTO;
import com.example.CalculadoraCalorias.DTOS.PlatoRequestDTO;
import com.example.CalculadoraCalorias.Models.Ingrediente;
import com.example.CalculadoraCalorias.Repositories.PlatosRepositoryImp;
import com.example.CalculadoraCalorias.Services.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestauranteController {
    @Autowired
    IngredienteService ingredienteService;

    @GetMapping("/getCalories")
    public ResponseEntity<PlatoDTO> GetCalories(@RequestParam String name,  @RequestParam HashMap<String,String> ingredientsPlate) {
        ingredientsPlate.remove("name");
        PlatoRequestDTO platoRequestDTO = new PlatoRequestDTO(name,ingredientsPlate);
        return new ResponseEntity<>(ingredienteService.getCalories(platoRequestDTO), HttpStatus.OK);
    }
}
