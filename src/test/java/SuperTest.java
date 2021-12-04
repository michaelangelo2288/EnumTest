import org.junit.Test;

public class SuperTest {

    @Test
    public void getInfo() {
        Driver mike = new Driver("mike","tran",40, Driver.License.BIKER);
        System.out.println(String.format("child - %s %s is %s yrs old. %s", mike.getFirst(), mike.getLast(), mike.getAge(), mike.getLicense()));
        mike.printSuperInfo();
    }
}
