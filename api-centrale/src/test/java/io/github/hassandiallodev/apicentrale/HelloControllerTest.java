package io.github.hassandiallodev.apicentrale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test automatisé de l'endpoint /hello.
 *
 * But :
 * - vérifier que l'application démarre
 * - vérifier que l'endpoint répond HTTP 200
 * - vérifier que le corps de réponse est bien "ok"
 *
 * Remarque :
 * - On utilise MockMvc : pas besoin d'ouvrir un vrai port (plus rapide et fiable en CI).
 */
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnOk() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("ok"));
    }
}