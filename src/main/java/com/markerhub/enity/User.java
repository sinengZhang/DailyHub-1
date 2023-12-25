package com.markerhub.enity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "m_user")
@Entity
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    //头像
    private String avatar;

    //微信用户身份id
    @JsonIgnore
    private String openId;

    //上次登录
    private LocalDate lasted;
    private LocalDate created;

    private Integer status;


}
