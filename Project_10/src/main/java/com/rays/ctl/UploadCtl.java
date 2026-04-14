package com.rays.ctl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.UploadDTO;
import com.rays.form.UploadForm;
import com.rays.service.UploadServiceInt;

@RestController
@RequestMapping(value = "Upload")
public class UploadCtl extends BaseCtl<UploadForm, UploadDTO, UploadServiceInt> {

	@Autowired
	private UploadServiceInt baseService;

	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Active");
		map.put(2, "Inactive");

		res.addResult("uploadList", map);
		return res;
	}

}
