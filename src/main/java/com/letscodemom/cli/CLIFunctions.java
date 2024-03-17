package com.letscodemom.cli;

import java.util.HashMap;
import java.util.Map;

public class CLIFunctions {
    public static Map<String, Object> toMap(CLIArguments cli) {
        Map<String, Object> params = new HashMap<>();
        params.put("description", cli.getKeyword());
        params.put("location", cli.getLocation());
        params.put("full_time", cli.isFullTime());
        params.put ("page", cli.getPage());

        return params;
    }
}
