package parcatakip.parcatakip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ParcaTakipApplication {

    public static void main(String[] args) {
        //SpringApplication.run(ParcaTakipApplication.class, args);
        SpringApplication app = new SpringApplication(ParcaTakipApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));
        app.run(args);
    }

}
