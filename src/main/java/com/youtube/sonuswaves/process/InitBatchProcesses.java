package com.youtube.sonuswaves.process;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import static com.youtube.sonuswaves.util.Videos.YOUTUBE_LINKS;

@Slf4j
public class InitBatchProcesses {

    private static final String START_CHROME = "\"start chrome -incognito\"";

    private Map<String, Process> processes = new HashMap<>(YOUTUBE_LINKS.size());

    public void initialize() {

        try {
            int i = 0;
            for (Map.Entry<String, String> entry : YOUTUBE_LINKS.entrySet()) {
                processes.put(entry.getKey(), Runtime.getRuntime().exec(new String[]{"cmd", "/c", START_CHROME, entry.getValue()}));
                processes.get(entry.getKey()).waitFor();
                i++;
                System.out.println(String.format("Google Chrome Tab no.: %-2d | Title: %-20s | URL: %20s", i, entry.getKey(), entry.getValue()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());

        }
    }
}

