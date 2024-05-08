package com.alimm.tanx.core.web.cache.config;

import android.text.TextUtils;
import java.util.HashSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class CacheExtensionConfig {
    public static final HashSet STATIC = new HashSet() { // from class: com.alimm.tanx.core.web.cache.config.CacheExtensionConfig.1
        {
            add("js");
            add("ico");
            add("css");
            add("png");
            add("jpg");
            add("jpeg");
            add("gif");
            add("bmp");
            add("ttf");
            add("woff");
            add("woff2");
            add("otf");
            add("eot");
            add("svg");
            add("xml");
            add("swf");
            add("txt");
            add("text");
            add("conf");
            add("webp");
        }
    };
    public static final HashSet NO_CACH = new HashSet() { // from class: com.alimm.tanx.core.web.cache.config.CacheExtensionConfig.2
        {
            add("mp4");
            add("mp3");
            add("ogg");
            add("avi");
            add("wmv");
            add("flv");
            add("rmvb");
            add("3gp");
        }
    };
    public final HashSet statics = new HashSet(STATIC);
    public final HashSet no_cache = new HashSet(NO_CACH);

    public static void add(HashSet hashSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hashSet.add(str.replace(".", "").toLowerCase().trim());
    }

    public static void addGlobalExtension(String str) {
        add(STATIC, str);
    }

    public static void remove(HashSet hashSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hashSet.remove(str.replace(".", "").toLowerCase().trim());
    }

    public static void removeGlobalExtension(String str) {
        remove(STATIC, str);
    }

    public CacheExtensionConfig addExtension(String str) {
        add(this.statics, str);
        return this;
    }

    public boolean canCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String trim = str.toLowerCase().trim();
        if (STATIC.contains(trim)) {
            return true;
        }
        return this.statics.contains(trim);
    }

    public void clearAll() {
        clearDiskExtension();
    }

    public void clearDiskExtension() {
        this.statics.clear();
    }

    public boolean isHtml(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("html") || str.toLowerCase().contains("htm");
    }

    public boolean isMedia(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (NO_CACH.contains(str)) {
            return true;
        }
        return this.no_cache.contains(str.toLowerCase().trim());
    }

    public CacheExtensionConfig removeExtension(String str) {
        remove(this.statics, str);
        return this;
    }
}
