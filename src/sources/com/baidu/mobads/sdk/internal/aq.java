package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class aq {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9816a = x.f10431p;

    /* renamed from: b, reason: collision with root package name */
    private static final String f9817b = "pauseDlByPk";

    /* renamed from: c, reason: collision with root package name */
    private static final String f9818c = "cancelDlByPk";

    /* renamed from: d, reason: collision with root package name */
    private static final String f9819d = "resumeDownload";

    /* renamed from: e, reason: collision with root package name */
    private static final String f9820e = "getDownloadStatus";

    /* renamed from: g, reason: collision with root package name */
    private static aq f9821g;

    /* renamed from: f, reason: collision with root package name */
    private ar f9822f;

    private aq(Context context) {
        this.f9822f = ar.a(context, f9816a);
    }

    public static aq a(Context context) {
        if (f9821g == null) {
            synchronized (aq.class) {
                if (f9821g == null) {
                    f9821g = new aq(context);
                }
            }
        }
        return f9821g;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f9822f.a(null, f9818c, str);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f9822f.a(null, f9817b, str, 1);
    }

    public boolean a(Context context, JSONObject jSONObject, String str, String str2) {
        if (context != null && jSONObject != null) {
            Object b4 = this.f9822f.b(null, f9819d, context, jSONObject, str, str2);
            if (b4 instanceof Boolean) {
                return ((Boolean) b4).booleanValue();
            }
        }
        return false;
    }

    public int a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (bt.a(context, str)) {
            return 103;
        }
        Object b4 = this.f9822f.b(null, f9820e, str);
        if (b4 instanceof Integer) {
            return ((Integer) b4).intValue();
        }
        return -1;
    }
}
