package test;

import com.csg.cn.SpringallApplication;
import javafx.application.Application;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

//让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
    @RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
    @SpringBootTest(classes = SpringallApplication.class)
    @WebAppConfiguration
    public class EncryptorTest {

    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void encryptPwd() {
        String username = stringEncryptor.encrypt("root");


        String password = stringEncryptor.encrypt("123456-a");
        System.out.println("username=="+username);
        System.out.println("password=="+password);
    }

    }