package me.becomp.web.controller;

import me.becomp.config.security.SecurityConfig;
import me.becomp.config.security.SecurityInit;
import me.becomp.config.WebConfig;
import me.becomp.config.WebMVCConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by sapun4ik on 17.03.2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfig.class, WebMVCConfig.class,SecurityConfig.class, SecurityInit.class})
public class HomeControllerTest {
    @Autowired
    WebApplicationContext wac;
    @Autowired
    MockHttpSession session;


    private MockMvc mockMvc;
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void givenHomePageURI_whenMockMVC_thenReturnsIndexViewName() throws Exception {
        this.mockMvc.perform(get("/")).andExpect(view().name("template/index.html"));
    }
}