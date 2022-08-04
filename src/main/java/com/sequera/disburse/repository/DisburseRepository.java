package com.sequera.disburse.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sequera.disburse.data.Disburse;

@Repository
public interface DisburseRepository {

    void insert(Disburse entity);
    List<Disburse> get(String merchantId);
    List<Disburse> getAll();
}
