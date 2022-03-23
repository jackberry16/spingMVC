package com.chengh.spingmvc;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("test")
//@SessionAttributes(value = {"test1"})
public class TestController {
    @GetMapping("1")
    public String getParam1(@TestAnnotation(value = "s") String s,
                            @Test2Annotation String a) {
        System.out.println("参数为:" + s);
        System.out.println("参数为:" + a);
        return "success";
    }

    @RequestMapping(
            value = {"2", "3"},
            method = {RequestMethod.GET, RequestMethod.POST},
            params = {"name=admin"},
            headers = {"Host=localhost:8080"}
    )
    public String getParam2() {
        return "success";
    }

    @GetMapping("4")
    public String getParam3(
            @RequestParam(name = "name", required = false, defaultValue = "admin") String a,
            @RequestHeader(name = "Host", required = false, defaultValue = "8081") String b) {
        System.out.println("参数:" + a);
        System.out.println("Host:" + b);
        return "success";
    }

    @GetMapping("login")
    public String getParam4(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return "success";
    }

    @GetMapping("5")
    public String getParam5(
            @CookieValue(name = "JSESSIONID", required = false, defaultValue = "123456") String a) {
        System.out.println("JSESSIONID:" + a);
        return "success";
    }

    @GetMapping("6")
    public String testException() {
        if (1 != 2) {
            throw new RuntimeException();
        }
        return "success";
    }

    //@PathVariable 将占位符中数据赋值给控制器方法参数
    @GetMapping("7/{id}/{username}")
    public String test4(@PathVariable("id") long id,
                        @PathVariable String username) {
        return "success";
    }

    @ModelAttribute("test1")
    public String getModel() {
        return "test1的信息";
    }

    @GetMapping("8")
    public String test5(@ModelAttribute("test1") String a, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String s = (String) session.getAttribute("test1");
        return a + s;
    }

    @PostMapping("9")
    public TestEntity test6(@RequestBody(required = false) TestEntity testEntity) {
        System.out.println(testEntity);
        return testEntity;
    }

}
