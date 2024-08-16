package org.ccode.asset.ctn.service;

import org.ccode.asset.ctn.domain.RequestBody;
import org.jvnet.hk2.annotations.Service;


@Service
public class OperationService {
    public void doOperation(String operation, RequestBody body) {
        System.out.println("Operation: " + operation);
    }
}