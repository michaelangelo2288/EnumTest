import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Driver extends Parent {

    private String first;
    private String last;
    private Integer age;
    public static License license;          // *** need static here
    public enum License {
        COMMUTER, TRUCKER, BIKER;

        public void enumMethod() {
            System.out.println("this is method inside of enum: License");
        }
    }

    public Driver() {
        this.setFirst("mike");
        this.setLast("default");
        this.setAge(41);
        license = License.COMMUTER;
    }

    public Driver(String first, String last, Integer age, License licenseParam) {
//        super.setFirst(first);
//        super.setLast(last);
//        super.setAge(age);

        this.setFirst(first);
        this.setLast(last);
        this.setAge(age);
        license = licenseParam;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(final License license) {
        Driver.license = license;
    }

    public String getDriverSpeed() {
        license.enumMethod();                       // invoke method inside of Enum
        switch(license) {
            case COMMUTER:
                return "average";
            case TRUCKER:
                return "slow";
            case BIKER:
                return "fast";
            default:
                return "other speed";
        }
    }

//    @Override
//    public void setFirst(String first) {
//        this.first = first;
//    }

//    @Override
//    public String getFirst() {
//        return this.first;
//    }

    public void printSuperInfo() {
        System.out.println(String.format("parent - %s %s %s", super.getFirst(), super.getLast(), super.getAge()));
    }
}
