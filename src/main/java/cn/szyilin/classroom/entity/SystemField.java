package cn.szyilin.classroom.entity;

import java.io.Serial;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统字段表，这个表定义了，系统中所有状态与名称对应关系
 * </p>
 *
 * @author szyilin
 * @since 2023-12-13 08:32:29
 */
@Data
@Accessors(chain = true)
@TableName("system_field")
@Schema(name = "SystemField对象", description = "系统字段表，这个表定义了，系统中所有状态与名称对应关系")
public class SystemField implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "系统字段名称")
    private String key;

    @Schema(description = "采用 JSON 风格记录")
    private String value;


}
