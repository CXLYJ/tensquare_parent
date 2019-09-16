package com.lyj.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/9/16
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class User {

    private String userName;

    private Integer age;

}
