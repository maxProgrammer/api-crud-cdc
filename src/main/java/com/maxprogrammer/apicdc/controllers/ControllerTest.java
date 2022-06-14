package com.maxprogrammer.apicdc.controllers;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@OpenAPIDefinition(info = @Info(title = "CDC API", version = "1.0", description = "REST API to Handle CDC WebSite."))
public class ControllerTest {

    @GetMapping(value = "/")
    @Operation(summary = "Route test.")
    public String test() {
        return "está configurado";
    }
}
