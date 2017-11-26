package cn.zhipingok.skatch.serverribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
    @Autowired
    RestTemplate template;
    @RequestMapping(value = "/hi")
    public String hi(String name){
        System.out.println("say hi===");
           return template.getForObject("http://SERVICE-HI/hi?name="+name,String.class);

    }
}
