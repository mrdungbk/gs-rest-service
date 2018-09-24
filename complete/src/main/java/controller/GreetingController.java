package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import database.entity.Student;
import model.out.Greeting;
import org.apache.ibatis.io.Resources;
import org.springframework.web.bind.annotation.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    @ResponseBody
    public Greeting greeting(@RequestParam(value="name",  required=false, defaultValue="World") String name) {
        try {
            Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();

            //select a particular student  by  id
            Map params = new HashMap();
            params.put("id", 1);
            params.put("email", "mrdungbk@hotmail.com");
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

    @PostMapping("/greeting")
    @ResponseBody
    public Greeting greeting(@RequestBody Map<String, String> body) {
        try {
            Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();

            List students = session.selectList(
                    "Student.callById", body);

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
                String.format(template, "xxxxx"));
    }
}
