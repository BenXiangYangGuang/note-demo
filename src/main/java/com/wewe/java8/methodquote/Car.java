package com.wewe.java8.methodquote;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fei2 on 2018/5/22.
 * 描述：
 */
class Car {
    
    public static Car create(final Supplier<Car> supplier){
        return supplier.get();
    }
    
    public static void collide(final Car car){
        System.out.println("collided "+car.toString());
    }
    
    public void follow(final Car another){
        System.out.println("Following the " + another.toString());
    }
    
    public void repair(){
        System.out.println("Repaired" + this.toString());
    }
    
    public static void main(String[] args) {
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);
        
        cars.forEach(Car::collide);
        
        cars.forEach(Car::repair);
        
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }

}
@FunctionalInterface
interface Supplier<T>{
    T get();
}
