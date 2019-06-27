package com.winter.controller;


import com.winter.model.User;
import com.winter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public int addUser(User user){
        System.out.println(user.getUserName());
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findAllUser(pageNum,pageSize);
    }
}
