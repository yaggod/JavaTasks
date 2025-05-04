package com.yaggod.budgetcontrolsystem.model;

public record Person (int id, String FullName)
{
    @Override
    public String toString() {
        return FullName;
    }
}