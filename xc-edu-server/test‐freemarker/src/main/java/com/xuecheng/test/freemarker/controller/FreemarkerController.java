package com.xuecheng.test.freemarker.controller;

import com.xuecheng.test.freemarker.model.Student;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.*;

@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/test1")
    public String freemarker1(Map<String, Object> map) {
        map.put("name", "张松");
        //返回模板文件的名称
        return "test1";
    }

    @RequestMapping("/test2")
    public String freemarker2(Map<String, Object> map) {
        //项数据模型返数据
        map.put("name", "张松");
        Student stu1 = new Student();
        stu1.setName("小明");
        stu1.setAge(18);
        stu1.setBirthday(new Date());
        stu1.setMoney(200.99f);
        Student stu2 = new Student();
        stu2.setName("小红");
        stu2.setAge(20);
        stu2.setBirthday(new Date());
        stu2.setMoney(300.11f);
        List<Student> students = new ArrayList<>();
        students.add(stu1);
        students.add(stu2);
        //向数据模型放数据
        map.put("stus", students);
        //准备map数据
        HashMap<String, Student> stuMap = new HashMap<>();
        stuMap.put("stu1", stu1);
        stuMap.put("stu2", stu2);
        //向数据模型放数据
        map.put("stu1", stu1);
        //向数据模型放数据
        map.put("stuMap", stuMap);
        //返回模板文件名称 return "test2";
        return "test2";
    }

    @RequestMapping("/banner")
    public String index_banner(Map<String, Object> map) throws IOException {
        String dataUrl = "http://localhost:31001/cms/config/getModel/5a791725dd573c3574ee333f";
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(dataUrl, Map.class);
        Map body = forEntity.getBody();
        map.putAll(body);
        InputStream inputStream = IOUtils.toInputStream(map.toString());
        //输出文件
        FileOutputStream fileOutputStream = new FileOutputStream(new File("d:/index_banner.html"));
        int copy = IOUtils.copy(inputStream, fileOutputStream);
        return "index_banner";
    }

}
