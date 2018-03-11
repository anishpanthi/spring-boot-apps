package com.app.drools.api.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {

    private KieServices getKieServices(){
        return KieServices.Factory.get();
    }

    @Bean
    public KieSession getKieSession() {
        Resource dt = ResourceFactory.newClassPathResource("rules/rules.xls", getClass());
        KieFileSystem kieFileSystem = getKieServices().newKieFileSystem().write(dt);
        KieBuilder kieBuilder = getKieServices().newKieBuilder(kieFileSystem).buildAll();
        KieRepository kieRepository = getKieServices().getRepository();
        ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();
        KieContainer kieContainer = getKieServices().newKieContainer(krDefaultReleaseId);
        return kieContainer.newKieSession();
    }
}
