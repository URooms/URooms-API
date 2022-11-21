package com.upc.uroomsapi.users.infrastructure.persistence.values;

import com.upc.uroomsapi.users.domain.aggregates.InstitutionType;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class InstitutionValue {
    private String name;

    @Enumerated(EnumType.STRING)
    private InstitutionType type;

    public InstitutionValue() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public InstitutionType getType() {
        return type;
    }
    public void setType(InstitutionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "InstitutionValue{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
