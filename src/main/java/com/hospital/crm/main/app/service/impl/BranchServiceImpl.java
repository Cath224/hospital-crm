package com.hospital.crm.main.app.service.impl;

import com.hospital.crm.main.app.dao.api.BranchDao;
import com.hospital.crm.main.app.model.Branch;
import com.hospital.crm.main.app.service.api.BranchService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BranchServiceImpl extends EntityServiceImpl<Branch, UUID> implements BranchService {

    private final BranchDao branchDao;

    public BranchServiceImpl(BranchDao branchDao) {
        super(branchDao);
        this.branchDao = branchDao;
    }


}
