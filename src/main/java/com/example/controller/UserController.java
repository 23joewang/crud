package com.example.controller;

import com.example.common.Result;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController//返回為json
@RequestMapping("/user")//路由
public class UserController {

    @Resource
    private UserService userService;

    // 新增用戶
    @PostMapping
    public Result<?> add(@RequestBody User user) {//json轉java對象
        userService.save(user);
        return Result.success();
    }

    // 修改用戶
    @PutMapping
    public Result<?> update(@RequestBody User user) {
        userService.save(user);
        return Result.success();
    }

    //刪除用戶
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    // 根據id查詢用戶
    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable Long id) {
        return Result.success(userService.findById(id));
    }

    // 查詢所有用戶
    @GetMapping
    public Result<List<User>> findAll() {
        return Result.success(userService.findAll());
    }

    // 分頁查詢用戶
    @GetMapping("/page")
    public Result<Page<User>> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       @RequestParam(required = false) String name) {
        return Result.success(userService.findPage(pageNum, pageSize, name));
    }

}
