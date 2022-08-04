package com.sequera.disburse.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sequera.disburse.data.Disburse;
import com.sequera.disburse.repository.DisburseRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(MockitoExtension.class)
public class DisburseServiceTest {
    private static final String MERCHANT_ID = "id";
    @InjectMocks
    private DisburseService service;
    @Mock
    private DisburseRepository repository;

    @Test
    void insert_when_entity_is_null() {
        service.insert(null);

        verify(repository, never()).insert(any());
    }

    @Test
    void insert() {
        Disburse entity = new Disburse();

        service.insert(entity);

        verify(repository, times(1)).insert(entity);
    }

    @Test
    void get_when_merchant_id_is_null() {
        List<Disburse> entityList = new ArrayList<>();
        entityList.add(new Disburse());

        when(repository.getAll()).thenReturn(entityList);

        List<Disburse> result = service.get(null);

        assertTrue("Result should not be empty", ObjectUtils.isNotEmpty(result));
        assertEquals("Result should be equals", entityList, result);

        verify(repository, times(1)).getAll();
        verify(repository, never()).get(any());
    }

    @Test
    void get_when_merchant_id_is_empty() {
        List<Disburse> entityList = new ArrayList<>();
        entityList.add(new Disburse());

        when(repository.getAll()).thenReturn(entityList);

        List<Disburse> result = service.get(StringUtils.EMPTY);

        assertTrue("Result should not be empty", ObjectUtils.isNotEmpty(result));
        assertEquals("Result should be equals", entityList, result);

        verify(repository, times(1)).getAll();
        verify(repository, never()).get(any());
    }

    @Test
    void get_when_merchant_id_is_informed() {
        List<Disburse> entityList = new ArrayList<>();
        entityList.add(new Disburse());

        when(repository.get(MERCHANT_ID)).thenReturn(entityList);

        List<Disburse> result = service.get(MERCHANT_ID);

        assertTrue("Result should not be empty", ObjectUtils.isNotEmpty(result));
        assertEquals("Result should be equals", entityList, result);

        verify(repository, never()).getAll();
        verify(repository, times(1)).get(MERCHANT_ID);
    }
}
