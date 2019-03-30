package cn.huangxulin.jpa.repository;

import cn.huangxulin.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user", nativeQuery = true)
    List<Object[]> query();

    @Query(value = "SELECT id, username FROM user", nativeQuery = true)
    List<Object[]> query1();

    @Query(value = "SELECT name, balance FROM user", nativeQuery = true)
    List<Object[]> query2();

}
