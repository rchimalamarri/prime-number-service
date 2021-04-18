package com.challenge.primenumberservice.configuration;

import com.challenge.primenumberservice.controller.PrimeNumberController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 17-APR-2021
 ************************************/
@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(PrimeNumberController.class);

    }
}