package com.chengh.spingmvc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlResolver {
    public static void main(String[] args) throws DocumentException {

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("D:\\workspace\\spingMVC\\src\\main\\java\\com\\chengh\\spingmvc\\test.xml"));
        List<Element> list = document.selectNodes("/emps/emp");
        List<User> userList = resolverUser(list);
        userList.forEach(System.out::println);
    }

    public static List<User> resolverUser(List<Element> list){
        List<User> userList = new ArrayList<>();
        for (Element e : list){
            User user = new User(e.selectSingleNode("id").getText(),
                    e.selectSingleNode("name").getText(),
                    Integer.parseInt(e.selectSingleNode("age").getText()),
                    e.selectSingleNode("gender").getText(),
                    Integer.parseInt(e.selectSingleNode("salary").getText()));
            userList.add(user);
        }
        return userList;
    }
}
