package com.rays.ctl;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.InventoryDTO;
import com.rays.form.InventoryForm;
import com.rays.service.InventoryServiceInt;

@RestController
@RequestMapping("/Inventory")
public class InventoryCtl extends BaseCtl<InventoryForm, InventoryDTO, InventoryServiceInt>{

	@GetMapping("/preload")
	public ORSResponse preload() {

	    ORSResponse res = new ORSResponse(true);

	    HashMap<Integer, String> map = new HashMap<>();

	    map.put(1, "Laptop");
	    map.put(2, "Mobile");
	    map.put(3, "Headphones");
	    map.put(4, "Keyboard");
	    map.put(5, "Mouse");

	    res.addResult("productList", map);

	    return res;
	}
}
