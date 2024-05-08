package com.alimm.tanx.core.web.cache;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DynamicCacheLoader {
    public static volatile DynamicCacheLoader INSTANCE;

    public static DynamicCacheLoader getInstance() {
        if (INSTANCE == null) {
            synchronized (DynamicCacheLoader.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DynamicCacheLoader();
                }
            }
        }
        return INSTANCE;
    }

    public File getResByUrl(File file, String str) {
        String urlPath = getUrlPath(str);
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    File resByUrl = getResByUrl(file2, str);
                    if (resByUrl != null) {
                        return resByUrl;
                    }
                } else if (urlPath.endsWith(file2.getName())) {
                    return file2;
                }
            }
            return null;
        }
        if (urlPath.endsWith(file.getName())) {
            return file;
        }
        return null;
    }

    public String getUrlPath(String str) {
        try {
            String path = new URL(str).getPath();
            return (!path.startsWith("/") || path.length() == 1) ? path : path.substring(1);
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
