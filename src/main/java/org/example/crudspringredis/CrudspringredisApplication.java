package org.example.crudspringredis;

import java.net.InetAddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudspringredisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudspringredisApplication.class, args);
        
        String host = "198.50.171.124"; // Altere para o host desejado

        try {
            InetAddress address = InetAddress.getByName(host);
            boolean reachable = address.isReachable(5000); // 5000ms timeout

            if (reachable) {
                System.out.println("Ping bem-sucedido para: " + host);
            } else {
                System.out.println("Falha no ping para: " + host);
            }
        } catch (Exception e) {
            System.err.println("Erro ao tentar ping " + host + ": " + e.getMessage());
        }
    }
        
        
    }
