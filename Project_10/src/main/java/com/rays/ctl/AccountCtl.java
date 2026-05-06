package com.rays.ctl;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.AccountDTO;
import com.rays.form.AccountForm;
import com.rays.service.AccountServiceInt;

@RestController
@RequestMapping(value = "Account")
public class AccountCtl extends BaseCtl<AccountForm, AccountDTO, AccountServiceInt> {

    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        HashMap<Integer, String> accountTypeMap = new HashMap<>();
        accountTypeMap.put(1, "Saving");
        accountTypeMap.put(2, "Current");
       

        HashMap<Integer, String> statusMap = new HashMap<>();
        statusMap.put(1, "Active");
        statusMap.put(2, "Inactive");

        res.addResult("accountTypeList", accountTypeMap);
        res.addResult("statusList", statusMap);

        return res;
    }
}