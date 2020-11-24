package com.emse.spring.faircorp;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.HeaterDaoCustom;
import com.emse.spring.faircorp.model.Room;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class HeaterDaoTest {

    @Autowired
    private HeaterDao heaterDao;

    @Test
    public void shouldDeleteHeaterInARoom() {
        heaterDao.deleteHeaterInARoom(-10L);
    }
}
