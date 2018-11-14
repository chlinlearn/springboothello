package springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
    public class StartApplication {
        @RequestMapping("/")
        String home(){
            return "hello";
        }

        public static void main(String[] args){

            SpringApplication.run(StartApplication.class,args);
        }
    }

