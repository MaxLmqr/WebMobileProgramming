package com.emse.spring.faircorp;

import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.RoomDaoCustom;
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
public class RoomDaoTest {

    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldFindARoom() {
        List<Room> result = roomDao.findName("Room1");
        Assertions.assertThat(result)
                .hasSize(1)
                .extracting("name")
                .containsExactly("Room1");
    }
}
