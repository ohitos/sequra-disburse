package com.sequera.disburse.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sequera.disburse.data.Disburse;
import com.sequera.disburse.service.DisburseService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DisburseController {

    private DisburseService disburseService;

    @GetMapping
    public ResponseEntity<List<Disburse>> get(String merchantId) {
        List<Disburse> result = disburseService.get(merchantId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
