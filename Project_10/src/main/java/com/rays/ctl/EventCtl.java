package com.rays.ctl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.EventDTO;
import com.rays.form.EventForm;
import com.rays.service.EventServiceInt;

@RestController
@RequestMapping(value = "Event")
public class EventCtl extends BaseCtl<EventForm, EventDTO, EventServiceInt> {

	@Autowired
	private EventServiceInt baseService;

	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Active");
		map.put(2, "Inactive");

		res.addResult("eventList", map);

		return res;
	}

}