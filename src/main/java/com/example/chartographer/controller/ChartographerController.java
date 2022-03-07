package com.example.chartographer.controller;

import com.example.chartographer.service.ImageCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@RestController
@RequestMapping("/chartas")
public class ChartographerController {

    @Autowired
    ImageCreatorService imageCreatorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createPapyrusImage(@RequestParam @Min(1) @Max(20000) Integer width,
                                   @RequestParam @Min(1) @Max(50000) Integer height) {

        return imageCreatorService.createImage(width, height);

//        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid width or height");
    }
}
