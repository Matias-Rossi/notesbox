package com.dds.notesbox.services;

import com.dds.notesbox.models.orders.ManufacturerPart;
import com.dds.notesbox.models.orders.Order;
import com.dds.notesbox.models.products.Manufacturer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ManufacturerPartServiceImpl implements ManufacturerPartService {
    @Override
    public ManufacturerPart createPartToManufacture(Order order, String partName, LocalDate dateCreated) {
        return new ManufacturerPart(order, partName, dateCreated);
    }

    @Override
    public void assignPartToManufacturer(ManufacturerPart part, Manufacturer manufacturer) {
        part.setManufacturer(manufacturer);
        manufacturer.addPartToManufacture(part);
    }

    @Override
    public void markPartAsDelivered(ManufacturerPart part, LocalDate deliveryDate) {
        part.markAsDelivered(deliveryDate);
    }
}
