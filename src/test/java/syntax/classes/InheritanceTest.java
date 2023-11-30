package syntax.classes;

import org.junit.jupiter.api.Test;
import syntax.classes.inheritance.Child;
import syntax.classes.inheritance.Parent;

public class InheritanceTest {
    @Test
    void willParentPickParentMethodOrChildMethod() {
        Parent parent = new Parent();
        Parent childParent = new Child();
        childParent.call();

    }
}
