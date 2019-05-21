package ru.nsu.server;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.nsu.shift.server.mappers.MyMapper;
import ru.nsu.server.model.Profile;
import ru.nsu.server.model.exchange.RegisterRequest;
import ru.nsu.server.service.EventService;
import ru.nsu.server.service.ProfileService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerApplicationTests {

    private static Profile profile;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private MyMapper myMapper;

    @Autowired
    private EventService eventService;

    @BeforeClass
    public static void init() {
        profile = TestHelper.getFilledProfile();
    }

    @Test
    public void contextLoads() {
    }

    /**
     * Проверка корректрой работы mapstruct
     */
    @Test
    public void mapstructTest() {
        RegisterRequest res = new RegisterRequest();
        res.setLastName("TEST");
        Profile profile = myMapper.registerRequestToProfile(res);
        Assert.assertEquals(res.getLastName(), profile.getLastName());
    }
}

