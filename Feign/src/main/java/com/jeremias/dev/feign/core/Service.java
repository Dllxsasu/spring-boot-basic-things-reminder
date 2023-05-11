package com.jeremias.dev.feign.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Service {
    bureau_pf("bureau_pf"),
    BUREAU_PM("bureau_pm"),
    PROSPECTOR_PF("prospector_pf"),
    JUMIO_ID_VALIDATION("jumio_id_validation"),
    RENAPO_CURP("renapo_curp"),
    SAT_1("sat_1"),
    SAT_RFC("sat_rfc"),
    IMSS_JOB_HISTORY("imss_job_history");
    private final String value;
    @JsonValue
    public String getValue() {
        return value;
    }
    @JsonCreator
    public static Service fromValue(String value) {
        for (Service service : Service.values()) {
            if (service.value.equalsIgnoreCase(value)) {
                return service;
            }
        }
        throw new IllegalArgumentException("Invalid value for Service enum: " + value);
    }
}
