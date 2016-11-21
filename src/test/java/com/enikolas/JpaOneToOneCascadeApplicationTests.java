package com.enikolas;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.enikolas.models.BodyPart;
import com.enikolas.models.BodyPartHit;
import com.enikolas.respositories.BodyPartRespository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaOneToOneCascadeApplicationTests {

    @Autowired
    private BodyPartRespository bodyPartRespository;

    @After
    public void clearDatabase() {
        bodyPartRespository.deleteAll();
    }

    @Test
    public void contextLoads() {
        BodyPart bodyPart = BodyPart.builder()
                .description("aDescription")
                .bodyPartHit(BodyPartHit.builder()
                        .percentDamageHit(BigDecimal.TEN)
                        .build())
                .build();

        bodyPartRespository.saveAndFlush(bodyPart);

        List<BodyPart> all = bodyPartRespository.findAll();

        all.forEach(System.out::println);
    }

}
