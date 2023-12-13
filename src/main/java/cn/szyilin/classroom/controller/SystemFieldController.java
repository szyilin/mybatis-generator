package cn.szyilin.classroom.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统字段表，这个表定义了，系统中所有状态与名称对应关系 前端控制器
 * </p>
 *
 * @author szyilin
 * @since 2023-12-13 08:32:29
 */
@Tag(name = "SystemField 控制器", description = "系统字段表，这个表定义了，系统中所有状态与名称对应关系 前端控制器")
@RestController
@RequestMapping("/system-field")
public class SystemFieldController {

}
