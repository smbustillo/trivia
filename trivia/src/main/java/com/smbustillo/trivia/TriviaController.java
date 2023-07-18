package com.smbustillo.trivia;

import ch.qos.logback.core.net.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smbustillo.trivia.entities.Categoria;
import com.smbustillo.trivia.entities.Pregunta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TriviaController {

    @GetMapping("/question/{cat}")
    public String getQuestion(@PathVariable String cat) {

        ChatGPTClient chatGPT = new ChatGPTClient();
        String respuestaJSON = chatGPT.enviarPregunta("Como estas hoy");

        ObjectMapper convertidor = new ObjectMapper();

        //return convertidor.convertValue(respuestaJSON,Pregunta.class);
        return respuestaJSON;

    }

    @GetMapping("/categories")
    public Categoria [] getCategories() {

        Categoria catCultura = new Categoria();
        catCultura.setCategory("Cultura");
        catCultura.setDescription("Preguntas relacionadas con arte, literatura, música ...");

        Categoria catDeporte = new Categoria();
        catDeporte.setCategory("Deporte");
        catDeporte.setDescription("Preguntas relacionadas con deportes...");

        Categoria catArte = new Categoria();
        catArte.setCategory("Arte");
        catArte.setDescription("Preguntas relacionadas con deportes...");

        Categoria catCine = new Categoria();
        catCine.setCategory("Cine");
        catCine.setDescription("Preguntas relacionadas con deportes...");

        Categoria catHistoria = new Categoria();
        catHistoria.setCategory("Historia");
        catHistoria.setDescription("Preguntas relacionadas con deportes...");

        Categoria catCiencia = new Categoria();
        catCiencia.setCategory("Ciencia");
        catCiencia.setDescription("Preguntas relacionadas con deportes...");


        Categoria[] categorias = new Categoria[2];
        categorias[0] = catCultura;
        categorias[1] = catDeporte;

        return categorias;


/*
        return "[\n" +
                "  {\n" +
                "    \"category\": \"Cultura\",\n" +
                "    \"description\": \"Preguntas relacionadas con arte, literatura, música y otras expresiones culturales.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"category\": \"Prueba\",\n" +
                "    \"description\": \"Preguntas relacionadas con diversos deportes y eventos deportivos.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"category\": \"Arte\",\n" +
                "    \"description\": \"Preguntas relacionadas con pintura, escultura, arquitectura y otras formas de expresión artística.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"category\": \"Cine\",\n" +
                "    \"description\": \"Preguntas relacionadas con películas, directores, actores y otros aspectos del cine.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"category\": \"Historia\",\n" +
                "    \"description\": \"Preguntas relacionadas con eventos históricos, personajes y períodos importantes.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"category\": \"Ciencia\",\n" +
                "    \"description\": \"Preguntas relacionadas con diferentes ramas de la ciencia, descubrimientos y avances científicos.\"\n" +
                "  }\n" +
                "]"; */
    }
}
