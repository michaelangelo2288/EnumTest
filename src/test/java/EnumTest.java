import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.util.Arrays;
import java.util.Scanner;

@Slf4j
public class EnumTest extends Driver {

    //============== What ENUM does + what is is used for? =============//
    //    enum Color                                                    //
    //    {                                                             //
    //        RED, GREEN, BLUE;                                         //
    //    }                                                             //
    //                                                                  //
    //    Every enum is internally implemented by using Class.          //
    //    Internally, the above enum Color is converted to (below)      //
    //    Think of RED, BLUE, GREEN as constant of Color class/object   //
    //                                                                  //
    //    class Color                                                   //
    //    {                                                             //
    //         public static final Color RED = new Color();             //
    //         public static final Color BLUE = new Color();            //
    //         public static final Color GREEN = new Color();           //
    //    }                                                             //
    //                                                                  //
    //    * Every enum constant represents an object of type enum.      //
    //    * enum type can be passed as an argument to switch statement. //
    //==================================================================//


    private Day day;
    private enum Day {
        SUN, MON, TUES, WED, THURS, FRI, SAT
    }

    // Simple Enum Test
    @Test
    public void enumDayTestNoInput() {
        this.day = Day.WED;                             // setting Enum object using/referencing 'Day day' member variable
        System.out.println("Entered day: " + day);
    }

    // =========== Actually test case for: enumEnterDayTestWithInput() =============
    // *** Need to do 'static void main()' because System.in hangs when used with Junit @Test
    public static void main(String[] args) {
        new EnumTest().enumEnterDayTestWithInput();
    }

    public void enumEnterDayTestWithInput() {
        System.out.print("Enter day (MON-SUN): ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Day dayNickName = Day.valueOf(input);           // setting Enum object WITHOUT using/referencing 'Day day' member variable (above)

        switch(dayNickName) {
            case MON:
                System.out.println("Mellow Monday");
                break;
            case TUES:
                System.out.println("Taco Tuesdays");
                break;
            case WED:
                System.out.println("Humpday");
                break;
            case THURS:
                System.out.println("Throwback Thursday");
                break;
            case FRI:
                System.out.println("Thank God It's FriYaY! TGIF!");
                break;
            case SAT:
                System.out.println("Sunny Saturday");
                break;
            case SUN:
                System.out.println("Sunday Funday");
                break;
        }
    }

    // =========================================================================

    // *** Test with Enum inside Driver class
    @Test
    public void enumDriverTest() {
        Driver driver = new Driver();
        log.info("Driver default license: " + driver.getLicense());
        driver.setLicense(License.BIKER);
        log.info("License set to: " + getLicense());
        log.info(String.format("%s speed is: %s", getLicense(), getDriverSpeed()));
    }

    @Test
    public void foobar1() {
        String[] list = foobar("foo", "bar", "zoo", "bar");
        System.out.println(list.length);
        System.out.println(Arrays.asList(list));
    }

    // argument to allow String parameters using 'String ...'
    public String[] foobar(String... x) {
        System.out.println("print from foobar(): " + Arrays.asList(x));
        return x;
    }
}
