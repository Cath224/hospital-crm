package com.hospital.crm.main.app.controller;

import com.hospital.crm.main.app.model.DiagnosisMedicine;
import com.hospital.crm.main.app.service.api.DiagnosisMedicineService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.hospital.crm.main.app.controller.ApiConstants.DIAGNOSIS_MEDICINE_API;

@RestController
@RequestMapping(DIAGNOSIS_MEDICINE_API)
public class DiagnosisMedicineController extends CompositeEntityController<DiagnosisMedicine> {


    public DiagnosisMedicineController(DiagnosisMedicineService diagnosisMedicineService) {
        super(diagnosisMedicineService);
    }

}
