package com.guitar.db.handler;

import com.guitar.db.exception.BadRequestException;
import com.guitar.db.model.Manufacturer;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Manufacturer.class)
public class ManufacturerEventHandler {

    @HandleBeforeCreate
    public void handleBeforeCreate(Manufacturer manufacturer) {
        // do a check to see if the name is a valid manufacturer

        // only allow new manufacturers to be created in the active state
        if (!manufacturer.getActive()) {
            throw new BadRequestException("New Manufactures must be 'active'");
        }
    }
}
