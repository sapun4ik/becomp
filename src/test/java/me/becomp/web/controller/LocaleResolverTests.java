package me.becomp.web.controller;

import me.becomp.config.WebConfig;
import me.becomp.config.WebMVCConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.Filter;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by sapun4ik on 17.03.2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfig.class, WebMVCConfig.class })
public class LocaleResolverTests {
    @Autowired
    WebApplicationContext wac;
    @Autowired
    MockHttpSession session;
    @Autowired
    LocaleResolver localeResolver;
    @Autowired
    MessageSource messageSource;

    private MockMvc mockMvc;


    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    private void localeResolverTests(LocaleResolver localeResolver, boolean shouldSet){
        MockServletContext context = new MockServletContext();
        MockHttpServletRequest request = new MockHttpServletRequest(context);
        request.addPreferredLocale(Locale.UK);
        MockHttpServletResponse response = new MockHttpServletResponse();
        // check original(Default) locale
        Locale locale = localeResolver.resolveLocale(request);
        //
        Locale russian = new Locale("ru", "RUSSIAN");

        assertEquals(locale, russian);
        // set new locale
        try {
            localeResolver.setLocale(request, response, Locale.ENGLISH);
            if (!shouldSet)
                fail("should not be able to set Locale");
            // check new locale
            locale = localeResolver.resolveLocale(request);
            assertEquals(locale, Locale.ENGLISH);
        }
        catch (UnsupportedOperationException ex) {
            if (shouldSet)
                fail("should be able to set Locale");
        }
    }
    //@Test
    public void testAcceptHeaderLocaleResolver() {
        localeResolverTests(new AcceptHeaderLocaleResolver(), false);
    }

    @Test
    public void testCookieLocaleResolver() {
        localeResolverTests(localeResolver, true);
    }
    //@Test
    public void testSessionLocaleResolver() {
        localeResolverTests(new SessionLocaleResolver(), true);
    }


    @Test
    public void testMessageSourcesRU() {
        Locale locale = new Locale("ru", "RUSSIAN");
        String text = messageSource.getMessage("unitest.text", null, locale);
        assertEquals(text, "текст");
    }
    @Test
    public void testMessageSourcesEN() {
        String text = messageSource.getMessage("unitest.text", null, Locale.ENGLISH);
        assertEquals(text, "text");
    }
    @Test
    public void testMessageSourcesOther() {
        String text = messageSource.getMessage("unitest.text", null, Locale.GERMANY);
        assertEquals(text, "текст");
    }
}
