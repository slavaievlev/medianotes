package medianotes.ab_package;

import org.springframework.stereotype.Component;

@Component
public class A {

    private final B b;

    public A(B b) {
        this.b = b;
    }

    public void printString() {
        System.out.println(b.getString());
    }
}
