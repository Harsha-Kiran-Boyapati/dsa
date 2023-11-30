package syntax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecordTest {
    @Test
    void accessingFieldsInaRecord() {
        //wow yaar records can be created anywhere ie inside a method too
        //is it also true for classes
        record FullName(String firstName, String lastName){};
        FullName fullName = new FullName("harsha", "boyapati");
        assertEquals("harsha", fullName.firstName());
    }

    @Test
    void canClassBeCreatedInsideAMethod() {
        class InsideMethod{
            void sayhello(){System.out.println("Hello");}
        }

        InsideMethod insideMethod = new InsideMethod();
        insideMethod.sayhello();
    }

    @Test
    void updateFieldInARecord() {
        //records do not provide setter methods
//        record FullName(String firstName, String lastName){
//            void setFirstName(String _firstName){this.firstName = _firstName;}
//        };
//        FullName fullName = new FullName("harsha", "boyapati");

    }
}
