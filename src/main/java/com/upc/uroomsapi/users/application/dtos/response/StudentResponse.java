package com.upc.uroomsapi.users.application.dtos.response;

import com.upc.uroomsapi.users.infrastructure.persistence.values.InstitutionValue;

public class StudentResponse extends UserResponse {
    private InstitutionValue institution;

    public StudentResponse() {}

    public InstitutionValue getInstitution() {
        return institution;
    }
    public void setInstitution(InstitutionValue institution) {
        this.institution = institution;
    }
}
