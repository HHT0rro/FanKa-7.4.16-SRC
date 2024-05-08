package com.ss.android.downloadlib.addownload;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class n {
    private final ConcurrentHashMap<String, String> dk;

    /* renamed from: m, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f38656m;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {

        /* renamed from: m, reason: collision with root package name */
        private static n f38657m = new n();
    }

    private String ej(String str) {
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String lastPathSegment = parse.getLastPathSegment();
            if (!TextUtils.equals("https", scheme) || !lastPathSegment.endsWith(".apk")) {
                return null;
            }
            this.f38656m.put(str, lastPathSegment);
            return lastPathSegment;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static n m() {
        return m.f38657m;
    }

    public void dk(String str) {
        Iterator<Map.Entry<String, String>> iterator2 = this.dk.entrySet().iterator2();
        while (iterator2.hasNext()) {
            Map.Entry<String, String> next = iterator2.next();
            if (TextUtils.equals(next.getValue(), str)) {
                iterator2.remove();
                this.f38656m.remove(next.getKey());
            }
        }
    }

    private n() {
        this.f38656m = new ConcurrentHashMap<>();
        this.dk = new ConcurrentHashMap<>();
    }

    public void m(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || this.dk.containsKey(str2)) {
            return;
        }
        this.dk.put(str2, str);
    }

    public String m(String str) {
        if (TextUtils.isEmpty(str) || this.dk.isEmpty() || !this.dk.containsKey(str)) {
            return null;
        }
        String ej = ej(str);
        if (this.f38656m.containsValue(ej)) {
            for (Map.Entry<String, String> entry : this.f38656m.entrySet()) {
                if (TextUtils.equals(entry.getValue(), ej)) {
                    String str2 = this.dk.get(entry.getKey());
                    this.dk.put(str, str2);
                    if (!this.f38656m.containsKey(str)) {
                        this.f38656m.put(str, ej);
                    }
                    return str2;
                }
            }
        }
        return this.dk.get(str);
    }

    public String m(DownloadModel downloadModel) {
        String ej = ej(downloadModel.getDownloadUrl());
        if (ej == null || TextUtils.isEmpty(ej)) {
            return null;
        }
        String md5Hex = DownloadUtils.md5Hex(ej + downloadModel.getPackageName());
        this.dk.put(downloadModel.getDownloadUrl(), md5Hex);
        return md5Hex;
    }
}
