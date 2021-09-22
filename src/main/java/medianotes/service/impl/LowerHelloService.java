package medianotes.service.impl;

import medianotes.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class LowerHelloService implements HelloService {

    @Override
    public String getHelloAsString() {
        return "hello";
    }
}
