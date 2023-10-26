package com.example.demo.enums;

import jakarta.persistence.Entity;

public enum Roles {
    ADMINISTRATION(0),
    STAFF(1),
    MANAGER(2),
    EXECUTIVE(3);

    private int value;

    Roles(int value) {
        this.value = value;
    }
}
