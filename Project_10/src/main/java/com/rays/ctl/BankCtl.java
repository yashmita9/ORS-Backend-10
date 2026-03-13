
package com.rays.ctl;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.BankDTO;
import com.rays.form.BankForm;
import com.rays.service.BankServiceInt;

@RestController
@RequestMapping(value = "Bank")
public class BankCtl extends BaseCtl<BankForm, BankDTO, BankServiceInt> {

	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "saving");
		map.put(2, "current");
		map.put(3, "fixed deposit");

		res.addResult("banklist", map);
		return res;
	}
}
