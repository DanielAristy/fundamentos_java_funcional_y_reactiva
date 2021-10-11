package com.company.monad_map_flatmap;

import java.util.HashMap;
import java.util.Optional;
import java.util.function.Consumer;

public class Main {

    private Consumer<City> proccess = city -> {
        System.out.println(city.name);
    };

    public static void main(String[] args) {
        Main exam = new Main();
        Map<String,Person> personMap = new Map<>();
        personMap.put("Name", new Person(new Address(new City("Medellin"))));
        personMap.put("Cristian", new Person(new Address(new City("Bogota"))));
        personMap.put("Daniel", new Person(new Address(new City("San Francisco"))));

        personMap.find("Daniel")
                .flatMap(Person::getAddress)
                .flatMap(Address::getCity)
                .ifPresent(exam.proccess);
    }

    public static class Person{
        private final Address address;

        public Person(Address address) {
            this.address = address;
        }

        //Buenas practicas para cuando no tengan datos
        public Optional<Address> getAddress(){
            return Optional.of(address);
        }
    }

    public static class Address{
        private final City city;

        public Address(City city) {
            this.city = city;
        }
        public Optional<City> getCity() {
            return Optional.of(city);
        }
    }

    public static class City{
        private final String name;

        public City(String name) {
            this.name = name;
        }
        public Optional<String> getName(){
            return Optional.of(name);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public static class Map<T,U> extends HashMap<T,U>{
        public Optional<U> find(T key){
            return Optional.ofNullable(super.get(key));
        }
    }
}
