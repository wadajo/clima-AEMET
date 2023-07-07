package com.wadajo.clima.application.controller;

import com.wadajo.clima.domain.dto.response.PrediccionHorariaResponseDto;
import com.wadajo.clima.domain.dto.response.PrediccionJornadaResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@SpringBootTest
@AutoConfigureGraphQlTester
public class ClimaGraphqlControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void debeHaberSieteDiasEnLaPrediccionDiaria(){
        this.graphQlTester
                .documentName("clima_test1")
                .execute()
                .path("prediccionDiaria")
                .entity(PrediccionJornadaResponseDto.class)
                .matches(prediccionJornadaResponseDto -> prediccionJornadaResponseDto.prediccion().dia().size()==7);
    }

    @Test
    void elMunicipioDebeSerElIndicadoEnLaPrediccionHoraria(){
        this.graphQlTester
                .documentName("clima_test2")
                .execute()
                .path("prediccionHoraria")
                .entity(PrediccionHorariaResponseDto.class)
                .matches(prediccionHorariaResponseDto -> prediccionHorariaResponseDto.municipio().equals("Alcalá de Henares"));
    }

}
