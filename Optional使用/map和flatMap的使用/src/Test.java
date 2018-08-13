import java.util.Optional;

/**
 * @Description:
 * @Auther: 黄世增
 * @Date: 2018-08-13 15:24
 */
public class Test {
    public static void main(String[] args) {
        Insurance insurance = null;
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        System.out.println(optInsurance);
        Optional<String> name = optInsurance.map(Insurance::getName); //从保险公司中获取公司名称
        System.out.println(name);

        //从Person获取到保险公司的名称
        Optional<Person> optPerson = Optional.empty();
        //Optional<Person> optPerson = Optional.of(new Person(Optional.of(new Car(Optional.of(new Insurance("平安保险"))))));

        //这样写编译不过，因为optPerson是Optional<Person>类型的，所以可以调用map方法，但getCar返回的是一个Optional<Car>类型，
        //则map返回的是Optional<Optional<Car>>类型的对象，由于Optional<Car>没有getInsurance方法，调用它是非法的，所以报错
//        Optional<String> name1 = optPerson.map(Person::getCar)
//                                            .map(Car::getInsurance)
//                                            .map(Insurance::getName);

        //flatMap会将两层的Optional对象转换为包含单一的Optional对象
        Optional<String> name1 = optPerson.flatMap(Person::getCar)
                                          .flatMap(Car::getInsurance)
                                          .map(Insurance::getName);

        String name2 = optPerson.flatMap(Person::getCar)
                                .flatMap(Car::getInsurance)
                                .map(Insurance::getName)
                                .orElse("太平洋保险");
        System.out.println(name2);
    }
}
