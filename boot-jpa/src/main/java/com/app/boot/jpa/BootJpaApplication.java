package com.app.boot.jpa;

import com.app.boot.jpa.domain.User;
import com.app.boot.jpa.dto.UserRequest;
import com.app.boot.jpa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class BootJpaApplication {

    private final UserService userService;

    @Autowired
    public BootJpaApplication(UserService userService){
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BootJpaApplication.class, args);
    }

    @Bean
    CommandLineRunner prepareData(UserService userService){
        return args-> {

//            UserRequest john1 = new UserRequest("John","Washington","john.washington1@gmail.com","469-111-1111","johnjohn","washington");
//            UserRequest alan1 = new UserRequest("Alan","Smith","alan.smith1@gmail.com","469-222-2222","alanjohn","smith");
//            UserRequest anish1 = new UserRequest("Anish","Panthi","anish.panthi1@gmail.com","469-333-3333","anishjohn","panthi");
//            UserRequest john2 = new UserRequest("John","Washington","john.washington2@gmail.com","469-111-1111","johnjohn1234","washington");
//            UserRequest alan2 = new UserRequest("Alan","Smith","alan.smith2@gmail.com","469-222-2222","aljohnan","smith");
//            UserRequest anish2 = new UserRequest("Anish","Panthi","anish.panthi2@gmail.com","469-333-3333","anjohnish","panthi");
//            UserRequest john3 = new UserRequest("John","Washington","john.washington3@gmail.com","469-111-1111","jojohnhn","washington");
//            UserRequest alan3 = new UserRequest("Alan","Smith","alan.smith3@gmail.com","469-222-2222","aljohnan12","smith");
//            UserRequest anish3 = new UserRequest("Anish","Panthi","anish.panthi3@gmail.com","469-333-3333","anijohnsh1234","panthi");
//            UserRequest john4 = new UserRequest("John","Washington","john.washington4@gmail.com","469-111-1111","jojohnhn12","washington");
//            UserRequest alan4 = new UserRequest("Alan","Smith","alan.smith4@gmail.com","469-222-2222","alajohnn","smith");
//            UserRequest anish4 = new UserRequest("Anish","Panthi","anish.panthi4@gmail.com","469-333-3333","johnanish","panthi");
//            UserRequest john5 = new UserRequest("John","Washington","john.washington5@gmail.com","469-111-1111","johnjohn12","washington");
//            UserRequest alan5 = new UserRequest("Alan","Smith","alan.smith5@gmail.com","469-222-2222","ajohnlan","smith");
//            UserRequest anish5 = new UserRequest("Anish","Panthi","anish.panthi5@gmail.com","469-333-3333","anijo234rgfhnsh23","panthi");
//            UserRequest john6 = new UserRequest("John","Washington","john.washington6@gmail.com","469-111-1111","jjohnohn345","washington");
//            UserRequest alan6 = new UserRequest("Alan","Smith","alan.smith6@gmail.com","469-222-2222","ajohh45hnlan12","smith");
//            UserRequest anish6 = new UserRequest("Anish","Panthi","anish.panthi6@gmail.com","469-333-3333","anijo94hjfhnsh12","panthi");
//            UserRequest john7 = new UserRequest("John","Washington","john.washington7@gmail.com","469-111-1111","jjohnoh63n","washington");
//            UserRequest alan7 = new UserRequest("Alan","Smith","alan.smith7@gmail.com","469-222-2222","ala8345456johnn","smith");
//            UserRequest anish7 = new UserRequest("Anish","Panthi","anish.panthi7@gmail.com","469-333-3333","anisj23457ohnh","panthi");
//            UserRequest john8 = new UserRequest("John","Washington","john.washington8@gmail.com","469-111-1111","jo876hjohnn","washington");
//            UserRequest alan8 = new UserRequest("Alan","Smith","alan.smith8@gmail.com","469-222-2222","alajoh123nn12","smith");
//            UserRequest anish8 = new UserRequest("Anish","Panthi","anish.panthi8@gmail.com","469-333-3333","anbtr564ijohnsh123","panthi");

//            userService.createUser(john1);
//            userService.createUser(alan1);
//            userService.createUser(anish1);
//            userService.createUser(john2);
//            userService.createUser(alan2);
//            userService.createUser(anish2);
//            userService.createUser(john3);
//            userService.createUser(alan3);
//            userService.createUser(anish3);
//            userService.createUser(john4);
//            userService.createUser(alan4);
//            userService.createUser(anish4);
//            userService.createUser(john5);
//            userService.createUser(alan5);
//            userService.createUser(anish5);
//            userService.createUser(john6);
//            userService.createUser(alan6);
//            userService.createUser(anish6);
//            userService.createUser(john7);
//            userService.createUser(alan7);
//            userService.createUser(anish7);
//            userService.createUser(john8);
//            userService.createUser(alan8);
//            userService.createUser(anish8);
//            log.info("3 Users Added Successfully.");
        };
    }
}
