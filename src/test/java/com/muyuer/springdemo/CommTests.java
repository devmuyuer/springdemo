package com.muyuer.springdemo;

import com.muyuer.springdemo.entity.ViewInfo;
import com.muyuer.springdemo.utils.SnowflakeIdHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author muyuer 182443947@qq.com
 * @version 1.0
 * @date 2018-12-05 18:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommTests {
    @Test
    public void testQuery() {
        for (int i = 0; i < 10; i++) {
            System.out.println(SnowflakeIdHelper.getInstance().getId());
        }
    }
}
