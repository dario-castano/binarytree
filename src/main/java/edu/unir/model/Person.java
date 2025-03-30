package edu.unir.model;

import lombok.Data;

@Data
public class Person implements Comparable<Person>{
    private final String name;
    private final Integer age;

    public Person(String name, Integer age) {
        if(age < 0) {
            throw new IllegalArgumentException("Edad no puede ser negativa");
        }
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }

    public Boolean lt(Person other) {
        return compareTo(other) < 0;
    }

    public Boolean le(Person other) {
        return compareTo(other) <= 0;
    }

    public Boolean gt(Person other) {
        return compareTo(other) > 0;
    }

    public Boolean ge(Person other) {
        return compareTo(other) >= 0;
    }

    public Boolean equals(Person other) {
        return compareTo(other) == 0;
    }
}
