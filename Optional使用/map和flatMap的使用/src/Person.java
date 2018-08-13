import java.util.Optional;

/**
 * @Description: 人
 * @Auther: 黄世增
 * @Date: 2018-08-13 15:23
 */
public class Person {
    public Person(Optional<Car> car) {
        this.car = car;
    }

    private Optional<Car> car;
    public Optional<Car> getCar() { return car; }
}
