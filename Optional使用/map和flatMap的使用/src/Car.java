import java.util.Optional;

/**
 * @Description: 车
 * @Auther: 黄世增
 * @Date: 2018-08-13 15:22
 */
public class Car {
    public Car(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }

    private Optional<Insurance> insurance;
    public Optional<Insurance> getInsurance() { return insurance; }
}
