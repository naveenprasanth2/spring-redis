package com.dailycodebuffer.springredis.repository;

import com.dailycodebuffer.springredis.model.User;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class UserRepository {
    private final RedisTemplate<String, Object> redisTemplate;
    private static final String KEY = "USER";

    public boolean saveUser(User user) {
        try {
            redisTemplate.opsForHash().put(KEY, String.valueOf(user.getId()), user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public User getUser(int id) {
        return (User) redisTemplate.opsForHash().get(KEY, String.valueOf(id));
    }

    public List<User> getAll() {
        return redisTemplate.opsForHash().entries(KEY)
                .values().stream().map(o -> (User) o).toList();
    }
}
