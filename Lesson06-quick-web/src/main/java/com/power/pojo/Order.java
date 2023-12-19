package com.power.pojo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;


/**
 * 1.导入校验依赖
 * 2.添加校验规则
 * 3.做异常统一处理
 */
@Data
public class Order {

    @NotBlank(message = "订单名称不能为空")
    private String name;

    @NotNull(message = "商品数量必须有值")
    @Range(min = 1,max = 99,message = "一个订单商品数量在{min}-{max}")
    private Integer amount;

    @NotNull(message = "用户不能为空")
    @Min(value = 1,message = "从 1 开始")
    private Integer userId;

}
