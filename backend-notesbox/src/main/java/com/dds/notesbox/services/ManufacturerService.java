package com.dds.notesbox.services;

import com.dds.notesbox.models.orders.ManufacturerPart;
import com.dds.notesbox.models.products.Manufacturer;

public interface ManufacturerService {

    public Manufacturer createManufacturer(String name, String phone);

    public void UpdateManufacturer(Manufacturer manufacturer, String name, String phone);
}
