package com.hospital.crm.main.app.controller;

import com.hospital.crm.main.app.model.Branch;
import com.hospital.crm.main.app.service.api.BranchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.hospital.crm.main.app.controller.ApiConstants.BRANCHES_API;

@RestController
@RequestMapping(BRANCHES_API)
public class BranchController extends EntityController<Branch, UUID> {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        super(branchService);
        this.branchService = branchService;
    }


    @Override
    protected void setId(UUID uuid, Branch entity) {
        entity.setId(uuid);
    }
}
