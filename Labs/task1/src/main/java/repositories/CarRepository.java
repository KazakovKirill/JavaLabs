package repositories;

import entities.Car;
import entities.Configurator;
import java.util.function.Predicate;

public class CarRepository extends AbstractRepository<Car> {
    public CarRepository() {
        items = new Car[8];
        sorter = Configurator.getSort();
        count = 0;
    }

    @Override
    public Repository findAll(Predicate<Car> pred) {
        Repository result = new CarRepository();
        for (Car item : items)
            if (item != null && pred.test(item))
                result.add(item);
        return result;
    }
}
