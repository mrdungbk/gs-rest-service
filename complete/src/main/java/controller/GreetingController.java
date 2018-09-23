package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import database.entity.Student;
import model.in.Param;
import org.apache.ibatis.io.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        try {
//            String resource = "/Users/nguyenvandung/Desktop/spring-boot/gs-rest-service/complete/src/main/java/SqlMapConfig.xml";// path of the mybatis configuration file.
//            File file = new File(resource);
//            System.out.println(file.getPath());
//            System.out.println(file.exists());
//
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String st;
//            while ((st = br.readLine()) != null) {
//                System.out.println(st);
//            }
            Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();

            //select a particular student  by  id
            Map params = new HashMap();
            params.put("id", 1);
            params.put("email", "mrdungbkxxxxx@hotmail.com");
            List students = session.selectList(
                    "Student.callById", params);

            //Print the student details
            for (int i = 0; i < students.size(); i++) {
                Student student = (Student) students.get(i);
                System.out.println("Details of the student are:: ");
                System.out.println("Id :"+student.getId());
                System.out.println("Name :"+student.getName());
                System.out.println("Branch :"+student.getBranch());
                System.out.println("Percentage :"+student.getPercentage());
                System.out.println("Email :"+student.getEmail());
                System.out.println("Phone :"+student.getPhone());
            }
            session.commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("error => " + ex);
        }

        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
