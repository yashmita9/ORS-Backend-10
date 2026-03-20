package com.rays.form;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.InventoryDTO;

public class InventoryForm extends BaseForm {

    @NotEmpty(message = "please enter Supplier Name")
    private String supplierName;

    @NotNull(message = "please enter Date")
    private Date dob;

    @NotNull(message = "please enter Quantity")
    private Long quantity;

    @NotEmpty(message = "please enter Product")
    private String product;

    // Getter & Setter

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    // DTO Mapping

    @Override
    public BaseDTO getDto() {

        InventoryDTO dto = initDTO(new InventoryDTO());

        dto.setSupplierName(supplierName);
        dto.setDob(dob);
        dto.setQuantity(quantity);
        dto.setProduct(product);

        return dto;
    }
}