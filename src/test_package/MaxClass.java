package test_package;
class Max {
    private String name = "Max";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class MaxClass {

    public static void main(String[] args) {
        System.out.println(new Max().getName());
    }

}
