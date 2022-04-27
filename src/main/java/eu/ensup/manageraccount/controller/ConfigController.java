package eu.ensup.manageraccount.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConfigController {
    @Value("${server.port}")
    private int port;

    @GetMapping("/config")
    public Map<String, Object> getConfig()
    {
        Map<String, Object> mapConfig = new HashMap<>();
        mapConfig.put("server.port", port);
        return mapConfig;
    }
}
