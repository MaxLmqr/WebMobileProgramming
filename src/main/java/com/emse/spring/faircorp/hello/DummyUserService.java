package com.emse.spring.faircorp.hello;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DummyUserService implements UserService {

    @Autowired
    GreetingService gs;

    String[] names= {"Elodie", "Charles"};

    @Override
    public void greetAll() {
        for (int i=0;i<names.length;i++) {
            gs.greet(names[i]);
        }
    }
}
