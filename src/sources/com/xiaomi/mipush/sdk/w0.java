package com.xiaomi.mipush.sdk;

import com.xiaomi.push.hv;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class w0 {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<d, a> f47087a = new HashMap<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f47088a;

        /* renamed from: b, reason: collision with root package name */
        public String f47089b;

        public a(String str, String str2) {
            this.f47088a = str;
            this.f47089b = str2;
        }
    }

    static {
        d(d.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        d(d.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        d(d.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        d(d.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    public static av a(d dVar) {
        int i10 = x0.f47094a[dVar.ordinal()];
        if (i10 == 1) {
            return av.UPLOAD_HUAWEI_TOKEN;
        }
        if (i10 == 2) {
            return av.UPLOAD_FCM_TOKEN;
        }
        if (i10 == 3) {
            return av.UPLOAD_COS_TOKEN;
        }
        if (i10 != 4) {
            return null;
        }
        return av.UPLOAD_FTOS_TOKEN;
    }

    public static a b(d dVar) {
        return f47087a.get(dVar);
    }

    public static hv c(d dVar) {
        return hv.AggregatePushSwitch;
    }

    public static void d(d dVar, a aVar) {
        if (aVar != null) {
            f47087a.put(dVar, aVar);
        }
    }
}
