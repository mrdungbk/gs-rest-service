package controller;

import java.util.concurrent.atomic.AtomicLong;

import database.entity.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import java.io.*;
import java.sql.SQLException;
import java.util.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        try {
            String resource = "/Users/nguyenvandung/Desktop/spring-boot/gs-rest-service/complete/src/main/java/SqlMapConfig.xml";// path of the mybatis configuration file.
            File file = new File(resource);
            System.out.println(file.getPath());
            System.out.println(file.exists());

            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                System.out.println(st);
            }
            Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
            SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);

            int id = 1;
            System.out.println("Going to read employee name.....");
            Map <String, Integer> hm = new HashMap();
            hm.put("acctID", id);
            Employee e = (Employee) smc.queryForObject ("Employee.getEmpInfo", hm);

            System.out.println("First Name:  " + e.getFirstName());
            System.out.println("Record name Successfully ");
        } catch (Exception ex) {
            System.out.println("error => " + ex);
        }

        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
