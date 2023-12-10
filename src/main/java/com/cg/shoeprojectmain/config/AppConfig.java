package com.cg.shoeprojectmain.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {
    @Bean
    public Cloudinary getCloudinary(){
        Map config = new HashMap();
        config.put("cloud_name", "vietlongbk123");
        config.put("api_key", "438417954867965");
        config.put("api_secret", "4MvyMcLVk5lMgKKAn6p_jVRFx_c");
        config.put("secure", true);
        return new Cloudinary(config);
    }
}
