package ru.shadrag.hw12.components;

public enum Priority {
    REGULAR_PRIORITY("Обычная задача"),
    HIGH_PRIORITY("Срочная задача");

    private final String description;

    Priority(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
