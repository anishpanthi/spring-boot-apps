package com.app.drools.api.service;

import com.app.drools.api.model.Product;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    private final KieSession kSession;

    @Autowired
    public ProductServiceImpl(KieSession kSession){
        this.kSession = kSession;
    }

    @Override
    public void applyDiscount(Product product) {
        kSession.insert(product);
        kSession.fireAllRules();
    }
}
