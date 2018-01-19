package com.wccwin.api.repository;

import com.wccwin.api.entity.TUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TUserRepository extends JpaRepository<TUser, Integer> {

    /**
     * 根据用户手机号码用户信息
     * @param phone
     * @return
     */
    @Query("select u from TUser u where phone = :phone ")
    TUser getTUser(@Param("phone") String phone);

    /**
     * 根据用户手机号码和密码查询用户信息
     * @param phone
     * @param password
     * @return
     */
    @Query("select u from TUser u where phone = :phone and password = :password ")
    TUser getTUser(@Param("phone") String phone, @Param("password") String password);

    @Query("select u from TUser u where phone = :phone and token = :token ")
    TUser getTUserByToken(@Param("token") String token);

}
