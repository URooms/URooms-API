package com.upc.uroomsapi.users.application.dtos.request;

import com.upc.uroomsapi.users.infrastructure.persistence.values.InstitutionValue;

public class StudentRequest extends UserRequest {
    private InstitutionValue institution;

    public StudentRequest() {}

    public InstitutionValue getInstitution() {
        return institution;
    }
    public void setInstitution(InstitutionValue institution) {
        this.institution = institution;
    }
}
