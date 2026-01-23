package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.TransportationDTO;
import com.rays.form.TransportationForm;
import com.rays.service.TransportationServiceInt;

@RestController
@RequestMapping(value = "Transportation")
public class TransportationCtl extends BaseCtl<TransportationForm, TransportationDTO, TransportationServiceInt>{

}
