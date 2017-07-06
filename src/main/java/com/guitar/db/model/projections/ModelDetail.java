package com.guitar.db.model.projections;

import com.guitar.db.model.Manufacturer;
import com.guitar.db.model.Model;
import com.guitar.db.model.ModelType;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

@Projection(name = "modelDetail", types = {Model.class})
public interface ModelDetail {

    String getName();
    BigDecimal getPrice();
    int getFrets();
    String getWoodType();
    Manufacturer getManufacturer();
    ModelType getModelType();
}
