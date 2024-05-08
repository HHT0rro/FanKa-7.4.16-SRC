package com.sina.weibo.sdk.net;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h {

    /* renamed from: q, reason: collision with root package name */
    private HashMap<String, String> f38359q = new HashMap<>();

    public final String j() {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (String str : this.f38359q.h()) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append("&");
            }
            String str2 = this.f38359q.get(str);
            if (!TextUtils.isEmpty(str2)) {
                try {
                    sb2.append(URLEncoder.encode(str, "UTF-8"));
                    sb2.append("=");
                    sb2.append(URLEncoder.encode(str2, "UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return sb2.toString();
    }

    public final void put(String str, String str2) {
        this.f38359q.put(str, str2);
    }
}
