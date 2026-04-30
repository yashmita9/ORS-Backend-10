package com.rays.ctl;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.BatchDTO;
import com.rays.form.BatchForm;
import com.rays.service.BatchServiceInt;

@RestController
@RequestMapping(value = "Batch")
public class BatchCtl extends BaseCtl<BatchForm, BatchDTO, BatchServiceInt> {

	@GetMapping("/preload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);
		HashMap<Integer, String> map = new HashMap<>();

		map.put(1, "PENDING");
		map.put(2, "PROCESSING");
		map.put(3, "COMPLETED");

		res.addResult("statusList", map);

		return res;
	}
}