package medianotes.service.impl;

import medianotes.service.HelloService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UpperHelloService implements HelloService {

    @Override
    public String getHelloAsString() {
        return "HELLO";
    }
}
