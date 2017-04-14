package com.tidyjava.petclinic.domain.visits;

public class Pet {
    private String name;
    private Owner owner;

    public Pet(String name, Owner owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return owner.getName();
    }
}
