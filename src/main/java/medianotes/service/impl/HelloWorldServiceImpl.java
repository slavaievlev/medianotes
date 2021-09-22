package medianotes.service.impl;

import medianotes.service.HelloService;
import medianotes.service.HelloWorldService;
import medianotes.service.WorldService;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    private final HelloService helloService;
    private final WorldService worldService;

    public HelloWorldServiceImpl(HelloService helloService,
                                 WorldService worldService) {
        this.helloService = helloService;
        this.worldService = worldService;
    }

    @Override
    public void printString() {
        System.out.printf("%s, %s!", helloService.getHelloAsString(), worldService.getWorldAsString());
    }
}
