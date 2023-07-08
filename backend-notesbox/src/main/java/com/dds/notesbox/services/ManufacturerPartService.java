package com.dds.notesbox.services;

import com.dds.notesbox.models.orders.ManufacturerPart;
import com.dds.notesbox.models.orders.Order;
import com.dds.notesbox.models.products.Manufacturer;

import java.time.LocalDate;

public interface ManufacturerPartService {

    public ManufacturerPart createPartToManufacture(Order order, String part, LocalDate dateCreated);

    public void assignPartToManufacturer(ManufacturerPart part, Manufacturer manufacturer);

    public void markPartAsDelivered(ManufacturerPart part, LocalDate deliveryDate);

    //TODO: unassign part?

}
