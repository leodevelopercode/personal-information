package com.leo.example.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xiexingxie
 * @date 2023/4/15 下午 04:20
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleVo {

    private String userName;
    private String name;
    private Integer departmentId;
    private String position;
    private String email;
    private String isAdmin;


}
