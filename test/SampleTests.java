import static org.junit.jupiter.api.Assertions.*;

import com.goundicorp.expenses.exceptions.InvalidEmployeeIdException;
import com.goundicorp.expenses.utilities.EmployeeUtilities;
import org.junit.jupiter.api.Test;

public class SampleTests {



    @Test
    public void testSomething(){
        int a = 4;
        int b = 8;
        int total = a + b;

        assertEquals(12,total);

    }

    @Test
    public void testEmployeeIdNumberIsConvertedCorrectly() throws InvalidEmployeeIdException {
        EmployeeUtilities employeeUtilities = new EmployeeUtilities();
        int result = employeeUtilities.validateEmployeeId("416");

        assertEquals(416,result);

    }

    @Test
    public  void testThatExceptionIsThrownIfEmployeeIsNotAValidNumber(){
        EmployeeUtilities employeeUtilities = new EmployeeUtilities();
        assertThrows(InvalidEmployeeIdException.class,() ->{
            int result = employeeUtilities.validateEmployeeId("Hello");
        });
    }

}
