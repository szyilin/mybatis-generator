package cn.szyilin.classroom.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author szyilin
 * @since 2023-12-13 08:32:29
 */
@Data
@Accessors(chain = true)
@Schema(name = "User对象", description = "用户表")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "账号")
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "年龄")
    private Integer age;

    @Schema(description = "职位字段")
    private String position;

    @Schema(description = "创建日期")
    private LocalDateTime createDate;

    @Schema(description = "修改时间")
    private LocalDateTime changeDate;


}
