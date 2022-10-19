package org.example.kotime.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.example.kotime.entity.User;
import org.example.kotime.mapper.User2Mapper;
import org.example.kotime.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuanct
 * @since 1.2
 */
@Service
public class TestService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private User2Mapper user2Mapper;

    public Long aInsert() {
        User user = new User();
        user.setName("小羊");
        user.setAge(3);
        user.setEmail("abc@mp.com");
        userMapper.insert(user);
        // 成功直接拿回写的 ID
        return user.getId();
    }


    public void bDelete() {
        userMapper.deleteById(3L);
        userMapper.delete(new QueryWrapper<User>()
                .lambda().eq(User::getName, "Sandy"));
    }


    public void cUpdate() {
        userMapper.updateById(new User().setId(1L).setEmail("ab@c.c"));
        userMapper.update(
                new User().setName("mp"),
                Wrappers.<User>lambdaUpdate()
                        .set(User::getAge, 3)
                        .eq(User::getId, 2));
        User user = userMapper.selectById(2);


        userMapper.update(
                null,
                Wrappers.<User>lambdaUpdate().set(User::getEmail, null).eq(User::getId, 2)
        );
        user = userMapper.selectById(2);


        userMapper.update(
                new User().setEmail("miemie@baomidou.com"),
                new QueryWrapper<User>()
                        .lambda().eq(User::getId, 2)
        );
        user = userMapper.selectById(2);


        userMapper.update(
                new User().setEmail("miemie2@baomidou.com"),
                Wrappers.<User>lambdaUpdate()
                        .set(User::getAge, null)
                        .eq(User::getId, 2)
        );
        user = userMapper.selectById(2);
    }
}
