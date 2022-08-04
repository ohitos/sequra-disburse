package com.sequera.disburse.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sequera.disburse.data.Disburse;
import com.sequera.disburse.service.DisburseService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DisburseControllerTest {

    private static final String MERCHANT_ID = "id";
    @InjectMocks
    private DisburseController controller;

    @Mock
    private DisburseService service;

    @Test
    public void get_order_list(){
        List<Disburse> orderList = new ArrayList<>();
        orderList.add(new Disburse());

        when(service.get(MERCHANT_ID)).thenReturn(orderList);

        ResponseEntity<List<Disburse>> result = controller.get(MERCHANT_ID);

        assertEquals("Status should be equals", HttpStatus.OK, result.getStatusCode());
        assertEquals("Result should be equals", orderList, result.getBody());
        verify(service, times(1)).get(MERCHANT_ID);
    }
}
