package com.dds.notesbox.services;

import com.dds.notesbox.models.products.Manufacturer;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Override
    public Manufacturer createManufacturer(String name, String phone) {
        return new Manufacturer(name, phone);
    }

    @Override
    public void UpdateManufacturer(Manufacturer manufacturer, String name, String phone) {
        manufacturer.setName(name);
        manufacturer.setPhoneNumber(phone);
    }
}
