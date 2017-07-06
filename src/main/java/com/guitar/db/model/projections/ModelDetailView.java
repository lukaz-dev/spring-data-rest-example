package com.guitar.db.model.projections;

import com.guitar.db.model.Model;
import com.guitar.db.model.ModelType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

@Projection(name = "modelDetailView", types = {Model.class})
public interface ModelDetailView {

    @Value("#{target.name}")
    String getModelName();

    BigDecimal getPrice();
    int getFrets();
    String getWoodType();
    ModelType getModelType();

    @Value("#{target.manufacturer.name}")
    String getManufacturerName();

    @Value("#{target.manufacturer.name.split(' ')[0]} #{target.name}")
    String getFullName();
}
