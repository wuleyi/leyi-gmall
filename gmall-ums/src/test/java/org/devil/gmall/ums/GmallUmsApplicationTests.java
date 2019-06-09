package org.devil.gmall.ums;

import org.devil.gmall.ums.entity.Role;
import org.devil.gmall.ums.mapper.RoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallUmsApplicationTests {

    @Autowired
    RoleMapper roleMapper;

    @Test
    public void insert(){

        Role role = new Role();
        role.setName("Big leader");
        roleMapper.insert(role);
    }

    @Test
    public void contextLoads() {
    }

}
