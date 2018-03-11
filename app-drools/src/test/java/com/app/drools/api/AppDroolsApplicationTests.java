//package com.app.drools.api;
//
//import com.app.drools.api.config.DroolsConfig;
//import com.app.drools.api.model.Product;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.kie.api.io.Resource;
//import org.kie.api.runtime.KieSession;
//import org.kie.internal.io.ResourceFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class AppDroolsApplicationTests {
//
//    private KieSession kSession;
//
//    @Before
//    public void setup() {
////        Resource dt
////                = ResourceFactory
////                .newClassPathResource("rules/rules.xls",
////                        getClass());
//        kSession = new DroolsConfig().getKieSession();
//    }
//
//    @Test
//    public void test_discount_for_gold()
//            throws Exception {
//        Product product = new Product();
//        product.setType("gold");
//        kSession.insert(product);
//        kSession.fireAllRules();
//        System.out.println("Product Type:: " + product.getType());
//        System.out.println("Product Discount:: " + product.getDiscount());
//        assertEquals(product.getDiscount(), 25);
//    }
//}
