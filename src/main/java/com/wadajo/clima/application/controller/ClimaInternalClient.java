package com.wadajo.clima.application.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface ClimaInternalClient {

    @GetExchange("/{location}")
    String getPrediccionRaw(@PathVariable String location);

}
