/*
 * CTN Telescope Operations API - OpenAPI 3.0
 * This is a sample server for Telescope Operations based on the OpenAPI 3.0 specification. This API provides functionality to control telescope mount operations and retrieve astronomical data. For more detailed information and updates, refer to the API documentation.
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: api@telescopeoperations.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */import io.swagger.jaxrs.config.BeanConfig;


package org.openapitools.client;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-02T08:46:40.931666960-05:00[America/Chicago]")
public class Pair {
    private String name = "";
    private String value = "";

    public Pair (String name, String value) {
        setName(name);
        setValue(value);
    }

    private void setName(String name) {
        if (!isValidString(name)) {
            return;
        }

        this.name = name;
    }

    private void setValue(String value) {
        if (!isValidString(value)) {
            return;
        }

        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    private boolean isValidString(String arg) {
        if (arg == null) {
            return false;
        }

        if (arg.trim().isEmpty()) {
            return false;
        }

        return true;
    }
}