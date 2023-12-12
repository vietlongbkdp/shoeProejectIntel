package com.cg.shoeprojectmain.model.dto;

import com.cg.shoeprojectmain.model.CustomerInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CustomerInfoDTO {
    private String fullName;
    private String address;
    private String email;
    private String mobile;
    public CustomerInfo toCustomerInfo(){
        return new CustomerInfo().setFullName(fullName).setAddress(address).setEmail(email).setMobile(mobile);
    }
}
