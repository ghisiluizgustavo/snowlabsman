package me.ghisiluizgustavo.customer.model;

import org.apache.logging.log4j.util.Strings;

public record Customer(String id, String name) {
    public Customer {
        if (Strings.isBlank(id)) {
            throw new IllegalArgumentException("The customer id is a mandatory field");
        }
        if (Strings.isBlank(name)) {
            throw new IllegalArgumentException("The customer name is a mandatory field");
        }
    }
}
