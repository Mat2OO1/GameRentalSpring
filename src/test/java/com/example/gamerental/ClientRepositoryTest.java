package com.example.gamerental;

import com.example.gamerental.model.Client;
import com.example.gamerental.repository.ClientRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.postgresql.hostchooser.HostRequirement.any;

public class ClientRepositoryTest {

    @Test
    public void saveClientTest(){
        ClientRepository cr = mock(ClientRepository.class);
        Client newClient = new Client(1L,"Jan",
                "Kowalski","601601601",
                new Date(2022, Calendar.NOVEMBER,11),false,null);
        when(cr.save(any())).thenReturn(newClient);
        Client client = cr.save(newClient);
        assertEquals(client,newClient);

    }


}
