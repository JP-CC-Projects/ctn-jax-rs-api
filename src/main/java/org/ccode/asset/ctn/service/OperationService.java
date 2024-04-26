package org.ccode.asset.ctn.service;

import org.glassfish.jersey.process.internal.RequestScoped;

@RequestScoped
public class OperationService {
    public String parseOperation(String operation) {
        if (operation == "moveEast"){

            return "Mounted";
        } else {
            return null;
        }
    }
}
