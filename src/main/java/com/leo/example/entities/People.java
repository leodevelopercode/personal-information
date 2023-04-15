package com.leo.example.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Xiexingxie
 * @date 2023/4/14 下午 11:01
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("people")
public class People implements Serializable {
    
    @TableId
    @TableField("userId")
    private Integer userId;
    @TableField("userName")
    private String userName;
    private String password;
    private String name;
    @TableField("departmentId")
    private Integer departmentId;
    private String position;
    private String email;
    private String phone;
    @TableField("isAdmin")
    private String isAdmin;
    
}
