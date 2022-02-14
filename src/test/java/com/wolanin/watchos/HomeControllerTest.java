//package com.wolanin.watchos;
//
//import com.wolanin.watchos.controller.HomeController;
//import org.apache.catalina.core.ApplicationContext;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.junit.matchers.JUnitMatchers.containsString;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@RunWith(SpringRunner.class)
////@WebMvcTest(HomeController.class)
//@SpringBootTest
////@SpringBootTest(HomeController.class)
//    @AutoConfigureMockMvc
//class HomeControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
////    @MockBean
////    ApplicationService applicationService;
//
//    @MockBean
//    ApplicationContext applicationContext;
//
//    @Test
//    public void HomePageTest() throws Exception {
//        mockMvc.perform(get("/home")).andExpect(view().name("home"))
//               ;
//    }
//
//
////    @Test
////    public void HomePageTest() throws Exception {
////        mockMvc.perform(get("/home").with(userAuth(USER)))
////
////                .andExpect(view().name("home"))
////                .andExpect(content().string(containsString("Zapisz")));
////    }
//
//
//}