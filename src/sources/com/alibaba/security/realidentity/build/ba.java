package com.alibaba.security.realidentity.build;

import android.content.Context;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.build.j;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NativeVerifyApi.java */
@aw(a = "startVerifyByNative")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ba extends aq {

    /* compiled from: NativeVerifyApi.java */
    /* renamed from: com.alibaba.security.realidentity.build.ba$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass2 extends RPEventListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RPEventListener f3145a;

        public AnonymousClass2(RPEventListener rPEventListener) {
            this.f3145a = rPEventListener;
        }

        @Override // com.alibaba.security.realidentity.RPEventListener
        public final void onFinish(RPResult rPResult, String str, String str2) {
            this.f3145a.onFinish(rPResult, str, str2);
        }
    }

    /* compiled from: NativeVerifyApi.java */
    /* renamed from: com.alibaba.security.realidentity.build.ba$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3147a;

        static {
            int[] iArr = new int[RPResult.values().length];
            f3147a = iArr;
            try {
                iArr[RPResult.AUDIT_NOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3147a[RPResult.AUDIT_PASS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void b(Context context, String str, RPEventListener rPEventListener) {
        new o(context, str, new AnonymousClass2(rPEventListener)).a(null);
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final String a() {
        return "startVerifyByNative";
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean a(String str, final ay ayVar) {
        try {
            String string = new JSONObject(str).getString(aq.f3108d);
            Context context = this.al;
            RPEventListener rPEventListener = new RPEventListener() { // from class: com.alibaba.security.realidentity.build.ba.1
                @Override // com.alibaba.security.realidentity.RPEventListener
                public final void onFinish(RPResult rPResult, String str2, String str3) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        int i10 = AnonymousClass3.f3147a[rPResult.ordinal()];
                        int i11 = 2;
                        if (i10 == 1) {
                            i11 = -1;
                        } else if (i10 == 2) {
                            i11 = 1;
                        }
                        jSONObject.put(aq.C, i11);
                        jSONObject.put("errorCode", str2);
                        bf bfVar = new bf();
                        bfVar.f3165a = 1;
                        bfVar.f3166k = jSONObject;
                        ayVar.b(bfVar);
                        ba.this.a(bfVar, true);
                    } catch (JSONException e2) {
                        aq.a(ayVar);
                        aq.a("NativeVerifyApi start verify assemble error: " + str2 + " msg is: " + str3, e2);
                    }
                }
            };
            j.a.f3944a.f3895e = string;
            new o(context, string, new AnonymousClass2(rPEventListener)).a(null);
            return true;
        } catch (JSONException e2) {
            if (RPLogging.isEnable()) {
                RPLogging.e(aq.f3100a, "NativeVerifyApi parse params error", e2);
            }
            aq.a("NativeVerifyApi parse params error", e2);
            aq.a(ayVar);
            return false;
        }
    }

    private void a(Context context, String str, RPEventListener rPEventListener) {
        j.a.f3944a.f3895e = str;
        new o(context, str, new AnonymousClass2(rPEventListener)).a(null);
    }
}
