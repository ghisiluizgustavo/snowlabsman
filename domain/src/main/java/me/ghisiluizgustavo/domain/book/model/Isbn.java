package me.ghisiluizgustavo.domain.book.model;

public record Isbn(String value) {
    public Isbn{
        if (checkInvalidEAN(value)) {
            throw new IllegalArgumentException("The first three digits (EAN) of ISBN are invalid, should be 978 or 979");
        }
    }

    private boolean checkInvalidEAN(String isbn){
        final String EAN_DEFAULT_01 = "978";
        final String EAN_DEFAULT_02 = "979";

        final String ean = isbn.substring(0, 3);
        return !EAN_DEFAULT_01.equals(ean) && !EAN_DEFAULT_02.equals(ean);
    }
}
