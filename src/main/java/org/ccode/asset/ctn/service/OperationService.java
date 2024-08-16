package org.ccode.asset.ctn.service;

import org.ccode.asset.ctn.domain.RequestBody;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.jvnet.hk2.annotations.Service;

import java.util.function.Consumer;

@Service
@RequestScoped
public class OperationService {

    //Add logic to iterate though an enum/array of mount operations for a positive match
    public void doOperation(String operation, RequestBody body) {
        parseOperationType.accept(operation);
        var coordinates = body.getProperties();
        System.out.println(coordinates);
    }

    private final Consumer<String> parseOperationType = operation -> {
        switch (operation) {
            case "slew":
                /*Logic for slew*/
                break;
            case "mount":
                /*Logic for mount*/
                break;
            case "move":
                /*Logic for move*/
                break;
            default: throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    };
}
