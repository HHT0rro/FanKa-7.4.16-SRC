package com.alipay.sdk.packet;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f4623a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4624b;

    public b(String str, String str2) {
        this.f4623a = str;
        this.f4624b = str2;
    }

    public String a() {
        return this.f4623a;
    }

    public String b() {
        return this.f4624b;
    }

    public JSONObject c() {
        if (TextUtils.isEmpty(this.f4624b)) {
            return null;
        }
        try {
            return new JSONObject(this.f4624b);
        } catch (Exception e2) {
            com.alipay.sdk.util.c.a(e2);
            return null;
        }
    }

    public String toString() {
        return String.format("<Letter envelop=%s body=%s>", this.f4623a, this.f4624b);
    }
}
