package com.fan.fancode.web.controller;


import com.fan.fancode.domain.entity.JsonResult;
import com.fan.fancode.domain.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller层负责请求转发，接受页面过来的参数，传给Service层处理，接到返回值，再传给页面。
 * <p>
 * Controller层常用注解：
 * - @RequestMapping 是一个用来处理请求地址映射的注解，它可以用于类上，也可以用于方法上。
 * 常用的三个属性：
 * value 属性：指定请求的实际地址，value 可以省略不写
 * method 属性：指定请求的类型，主要有 GET、PUT、POST、DELETE，默认为 GET
 * produces属性：指定返回内容类型，如 produces = "application/json; charset=UTF-8"
 * - @GetMapping 表示GET请求
 * - @POSTMapping 表示POST请求
 *
 * @author debug_fan
 * @date 2022/10/15 14:38
 **/
@Api(tags = "用户管理")    // @Api表示该Controller类的作用
@RestController // @RestController表示该类是一个Controller类，包含的@ResponseBody表示将返回的数据结构转换为 Json 格式。
public class UserController {

    /**
     * 2-4. 根据前端提交的Json实体参数，获取并返回User对象,封装到JsonResult
     *
     * @return user
     */
    @ApiOperation(value = "Json实体参数")  // @ApiOperation表示该api的作用，表示一个 http 请求的操作
    @PostMapping(value = "user/object/json/param")
    // @RequestBody表示请求参数为Json实体参数
    public JsonResult<User> getUserByUrlParameter(@RequestBody User user) {
        Map<Long, User> map = new HashMap<>();
        map.put(user.getId(), new User(user.getId(), user.getUsername() + user.getId(), user.getId() + "-123456"));
        return new JsonResult<>(map.get(user.getId()));
    }

    /**
     * 2-3. 根据前端表单提交的参数，获取并返回User对象,封装到JsonResult
     * 一般表单提交的参数比较多，所以封装一个实体类进行一一对应来接收表单数据
     *
     * @return user
     */
    @ApiOperation(value = "表单提交参数")  // @ApiOperation表示该api的作用，表示一个 http 请求的操作
    @PostMapping(value = "user/object/form/param")
    public JsonResult<User> getUserByFormParameter(User user) {
        Map<Long, User> map = new HashMap<>();
        map.put(user.getId(), new User(user.getId(), user.getUsername() + user.getId(), user.getId() + "-123456"));
        return new JsonResult<>(map.get(user.getId()));
    }

    /**
     * 2-2. 根据url中?后面的参数id、参数username获取并返回User对象,封装到JsonResult
     *
     * @return user
     */
    @ApiOperation(value = "url参数")  // @ApiOperation表示该api的作用，表示一个 http 请求的操作
    @GetMapping(value = "user/object/url/param")
    // @RequestParam获取url中?后面的的参数值
    // required表示是否必须传递该参数值，defaultValue表示没有传递该参数值时传递的默认值
    public JsonResult<User> getUserByUrlParameter(@RequestParam(value = "id") @ApiParam(value = "用户唯一标识") Integer id, @RequestParam(value = "username", required = false, defaultValue = "fan") @ApiParam(value = "用户名") String name) {
        Map<Integer, User> map = new HashMap<>();
        map.put(id, new User(Integer.toUnsignedLong(id), name + id, id + "-123456"));
        return new JsonResult<>(map.get(id));
    }

    /**
     * 2-1. 根据url中包含的{id}和{username}获取并返回User对象,封装到JsonResult
     *
     * @return user
     */
    @ApiOperation(value = "url占位符参数")  // @ApiOperation表示该api的作用，表示一个 http 请求的操作
    @GetMapping(value = "user/object/{id}/{username}")
    // @PathVariable获取url占位符{}中的参数值
    // @ApiParam表示对请求参数进行说明
    public JsonResult<User> getUserByUrlId(@PathVariable(value = "id") @ApiParam(value = "用户唯一标识") Integer id, @PathVariable(value = "username") @ApiParam(value = "用户名") String name) {
        Map<Integer, User> map = new HashMap<>();
        map.put(id, new User(Integer.toUnsignedLong(id), name + id, id + "-123456"));
        return new JsonResult<>(map.get(id));
    }


    /**
     * 1-6. 返回map键值对,封装到JsonResult
     *
     * @return map
     */
    @GetMapping(value = "user/result/map")
    public JsonResult<Map<String, Object>> getUserMapResult() {

        Map<String, Object> map = new HashMap<>();
        map.put("作者信息", new User(4L, "fan-4", "4-123456"));
        map.put("博客地址", "https://blog.csdn.net/qq_39393772");
        map.put("所在地", null);
        map.put("粉丝数量", 123);
        return new JsonResult<>(0, "获取用户Map集合成功！", map);
    }

    /**
     * 1-5. 返回List集合,封装到JsonResult
     *
     * @return list
     */
    @GetMapping(value = "user/result/list")
    public JsonResult<List<User>> getUserListResult() {

        List<User> list = new ArrayList<>();
        list.add(new User(2L, "fan-2", "2-123456"));
        list.add(new User(3L, "fan-3", "3-123456"));
        return new JsonResult<>("获取用户List集合成功！", list);
    }

    /**
     * 1-4. 返回User对象,封装到JsonResult
     *
     * @return user
     */
    @GetMapping(value = "user/result/object")
    public JsonResult<User> getUserResult() {
        return new JsonResult<>(new User(1L, "fan-1", "1-123456"));
    }

    /**
     * 1-3. 返回map键值对
     *
     * @return map
     */
    @GetMapping(value = "user/map")
    public Map<String, Object> getUserMap() {

        Map<String, Object> map = new HashMap<>();
        map.put("作者信息", new User(4L, "fan-4", "4-123456"));
        map.put("博客地址", "https://blog.csdn.net/qq_39393772");
        map.put("所在地", null);
        map.put("粉丝数量", 123);
        return map;
    }

    /**
     * 1-2. 返回List集合
     *
     * @return list
     */
    @GetMapping(value = "user/list")
    public List<User> getUserList() {

        List<User> list = new ArrayList<>();
        list.add(new User(2L, "fan-2", "2-123456"));
        list.add(new User(3L, "fan-3", "3-123456"));
        return list;
    }


    /**
     * 1-1. 返回User对象
     *
     * @return user
     */
    @GetMapping(value = "user/object")
    // @GetMapping表示该url请求是一个GET请求，"user/object"表示url请求地址，完整url：http://localhost:9999/user/object
    public User getUser() {
        return new User(1L, "fan-1", "1-123456");
    }

}

