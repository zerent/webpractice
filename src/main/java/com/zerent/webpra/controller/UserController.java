package com.zerent.webpra.controller;

import com.zerent.webpra.annotation.Encryption;
import com.zerent.webpra.model.entity.UserInfo;
import com.zerent.webpra.model.vo.ResultVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @PostMapping(path = "/saveUser")
    @Encryption
    public ResultVo saveUser(@Validated @RequestBody UserInfo userInfo){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(200);
        resultVo.setMsg("success");
        resultVo.setData(userInfo.getName());
        return resultVo;
    }
}
