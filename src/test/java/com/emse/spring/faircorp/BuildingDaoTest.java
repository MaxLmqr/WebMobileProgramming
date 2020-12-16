package com.emse.spring.faircorp;


import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.model.Window;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BuildingDaoTest {
    @Autowired
    BuildingDao buildingDao;

    @Test
    public void shouldFindWindows() {
        List<Window> result = buildingDao.findAllBuildingWindows(-10L);
        Assertions.assertThat(result)
                .hasSize(2)
                .extracting("id")
                .containsExactly(-10L,-9L);
    }
}
