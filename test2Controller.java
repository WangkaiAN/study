package org.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class test2Controller {
    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public String test2(){     //转发
        return "forward:/home.html";
    }
    @RequestMapping("/3")
    @ResponseBody
    public String test3(){
        return "好了，已经知道了";
    }

    @RequestMapping("/4")
    @ResponseBody
    public Object test4(){
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, "张三");
        map.put(2, 23333);
        map.put(3, true);
        return map;
    }

    @RequestMapping("/5")
    public Object t5(){
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, "乾坤");
        map.put(2, 23333);
        map.put(3, true);
        return ResponseEntity.status(200).body(map);
    }
    @RequestMapping("/6")
    @ResponseBody
    public String test5(){
        return null;
    }
    @RequestMapping("/7")
    @ResponseBody
    public Object test6(){
        return null;
    }
}
