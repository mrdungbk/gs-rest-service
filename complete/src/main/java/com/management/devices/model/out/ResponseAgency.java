package com.management.devices.model.out;

import com.management.devices.database.entity.Agency;

import java.util.ArrayList;
import java.util.List;

public class ResponseAgency extends BaseResponse{
    private List<Agency> agencySeq;

    public ResponseAgency() {
        super();
        agencySeq = new ArrayList<Agency>();
    }

    public List<Agency> getAgencySeq() {
        return agencySeq;
    }

    public void setAgencySeq(List<Agency> agencySeq) {
        this.agencySeq = agencySeq;
    }
}
