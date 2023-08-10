package com.smbustillo.trivia;

import ch.qos.logback.core.net.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smbustillo.trivia.entities.Category;
import com.smbustillo.trivia.entities.Question;
import com.smbustillo.trivia.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TriviaController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable Integer id) {

        return categoryRepository.getCategoryById(id);

    }

}
