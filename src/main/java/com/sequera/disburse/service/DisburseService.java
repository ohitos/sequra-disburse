package com.sequera.disburse.service;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.sequera.disburse.data.Disburse;
import com.sequera.disburse.repository.DisburseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DisburseService {

    private final DisburseRepository repository;

    public void insert(Disburse entity){
        if (Objects.nonNull(entity)) {
            repository.insert(entity);
        }
    }

    public List<Disburse> get(String merchantId) {
        List<Disburse> result;
        if (StringUtils.isNotEmpty(merchantId)) {
            result = repository.get(merchantId);
        } else {
            result = repository.getAll();
        }
        return result;
    }
}
