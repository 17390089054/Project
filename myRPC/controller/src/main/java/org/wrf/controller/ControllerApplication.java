package org.wrf.controller;

import com.momo.ClientApplication;
import com.momo.exection.MoBizExection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ControllerApplication {

    public static void main(String[] args) throws MoBizExection, IOException {
        ClientApplication application=new ClientApplication();
        application.run();
      //  SpringApplication.run(ControllerApplication.class, args);
    }

}
