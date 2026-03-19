package com.community.springmvcjsonview.controller;

import com.community.springmvcjsonview.entity.Order;
import com.community.springmvcjsonview.entity.User;
import com.community.springmvcjsonview.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testUserSummaryView_shouldNotContainOrders() throws Exception {

        User user = new User();
        user.setId(1L);
        user.setName("John");
        user.setEmail("john@email.com");

        when(userService.getAllUsers())
                .thenReturn(List.of(user));

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].orders").doesNotExist());
    }

    @Test
    void testUserDetailsView_shouldContainOrders() throws Exception {

        User user = new User();
        user.setId(1L);
        user.setName("John");
        user.setEmail("john@email.com");

        Order order = new Order();
        order.setId(1L);
        order.setProduct("Laptop");

        user.setOrders(List.of(order));

        when(userService.getUser(1L)).thenReturn(user);

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orders").exists());
    }
}