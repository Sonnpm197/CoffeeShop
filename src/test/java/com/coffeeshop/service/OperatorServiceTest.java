package com.coffeeshop.service;

import com.coffeeshop.CoffeeShopApplication;
import com.coffeeshop.model.Order;
import com.coffeeshop.model.enums.OrderState;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = CoffeeShopApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class OperatorServiceTest {

    @Autowired
    private OperatorService operatorService;

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    @Sql(scripts = {"/clean_up.sql"})
    public void cleanUp() {

    }

    @Test
    @Rollback
    @Transactional
    @Sql(scripts = {"/order_test.sql"})
    public void testUpdateOrderService() {
        Order updatedOrder = new Order();
        updatedOrder.setId(1);
        updatedOrder.setOrderState(OrderState.PROCESSING);
        Order order = operatorService.updateOrder(updatedOrder);
        Assertions.assertEquals(OrderState.PROCESSING, order.getOrderState());
        Assertions.assertEquals(order.getId(), 1);
    }

    @Test
    @Sql(scripts = {"/order_test.sql"})
    @Rollback
    @Transactional
    public void integrationTestUpdateOrderService() throws Exception {
        mvc.perform(patch("/api/v1/coffeeshop/operator/update-order")
                        .content("{\n" +
                                "    \"orderState\": \"PROCESSING\",\n" +
                                "    \"id\" : 1\n" +
                                "}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.orderState", is("PROCESSING")));
    }
}
