package cn.szyilin.classroom.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author szyilin
 * @since 2023-12-13 08:32:29
 */
@Tag(name = "User 控制器", description = "用户表 前端控制器")
@RestController
@RequestMapping("/user")
public class UserController {

}
