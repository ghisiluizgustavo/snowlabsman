package me.ghisiluizgustavo.customer.model;

import me.ghisiluizgustavo.ID;
import org.apache.logging.log4j.util.Strings;

public record Customer(ID id, String name) {
    public Customer {
        if (Strings.isBlank(name)) {
            throw new IllegalArgumentException("The customer name is a mandatory field");
        }
    }
}
