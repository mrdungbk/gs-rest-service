package com.management.devices.common.enums;

public enum TableMapper {
    /** insert location */
    INSERT_LOCATION("LOCATION.insert"),
    /** update location */
    UPDATE_LOCATION("LOCATION.update"),
    /** get list locations with location name */
    LOCATION_SELECT_BY_NAME("LOCATION.findLocationByLocationName"),
    /** get all locations */
    LOCATION_SELECT_ALL("LOCATION.findAllLocation"),
    /** insert location history */
    INSERT_LOCATION_HISTORY("LOCATION_HISTORY.insert"),
    /** insert location element */
    INSERT_LOCATION_ELEMENTS("LOCATION_ELEMENTS.insert"),
    /** insert location element */
    INSERT_MESSAGE_NOTIFICATION("MESSAGE_NOTIFICATION.insert"),
    /** get location element by locationId */
    LOCATION_ELEMENT_SELECT_BY_LOCATION_ID("LOCATION_ELEMENTS.findByLocationId"),
    /** get locations by ID */
    REGION_SELECT_BY_ID("REGION.findById"),
    /** get all locations */
    REGION_SELECT_ALL("REGION.findAll"),
    ;
    /** value */
    private String value;

    private TableMapper(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    /**
     * check result value with value define on emum
     *
     * @param value : result value
     * @return boolean (true : equal, false : not equal)
     */
    public boolean eq(String value) {
        return this.value.equals(value);
    }
}