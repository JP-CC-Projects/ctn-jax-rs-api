package org.ccode.asset.ctn.domain;

import java.util.Map;

public class RequestBody {
    private Map<String, Object> properties;

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "RequestBody{" +
                "properties=" + properties +
                '}';
    }
}
