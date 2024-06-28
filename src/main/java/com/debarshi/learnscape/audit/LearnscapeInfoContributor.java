package com.debarshi.learnscape.audit;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LearnscapeInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, String> learnscapeMap = new HashMap<String, String>();
        learnscapeMap.put("App Name", "Learnscape");
        learnscapeMap.put("App Description", "Learnscape Web Application for Students and Admin");
        learnscapeMap.put("App Version", "1.0.0");
        learnscapeMap.put("Contact Email", "support@learnscape.com");
        learnscapeMap.put("Contact Mobile", "(+91) 7044837799");
        builder.withDetail("learnscape-info", learnscapeMap);
    }

}