package me.ghisiluizgustavo.customer.model;

import me.ghisiluizgustavo.ID;
import org.apache.logging.log4j.util.Strings;

public record Customer(ID id, String name, String email) {
    public Customer {
        if (Strings.isBlank(name)) {
            throw new IllegalArgumentException("The customer name is a mandatory field");
        }
        if (Strings.isBlank(email)) {
            throw new IllegalArgumentException("The customer email is a mandatory field");
        }
    }
}
