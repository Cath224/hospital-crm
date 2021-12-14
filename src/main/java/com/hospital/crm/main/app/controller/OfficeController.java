package com.hospital.crm.main.app.controller;

import com.hospital.crm.main.app.model.Office;
import com.hospital.crm.main.app.service.api.OfficeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.hospital.crm.main.app.controller.ApiConstants.OFFICE_API;

@RestController
@RequestMapping(OFFICE_API)
public class OfficeController extends EntityController<Office, UUID> {

    public OfficeController(OfficeService officeService) {
        super(officeService);
    }

    @Override
    protected void setId(UUID uuid, Office entity) {
        entity.setId(uuid);
    }
}
