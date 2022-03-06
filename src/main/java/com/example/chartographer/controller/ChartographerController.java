package com.example.chartographer.controller;

import com.example.chartographer.model.PapyrusImage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/chartas")
public class ChartographerController {

    @PostMapping("/{id}/")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createPapyrusImage(@PathVariable Long id,
                                           @RequestParam Integer width,
                                           @RequestParam Integer height) {
        // validate request params

        return UUID.randomUUID();
    }
}
