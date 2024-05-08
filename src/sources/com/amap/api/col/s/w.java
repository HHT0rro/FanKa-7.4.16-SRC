package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.s.am;
import com.amap.api.col.s.bx;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONObject;

/* compiled from: ManifestConfig.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public static ch f7978a;

    /* renamed from: b, reason: collision with root package name */
    private static w f7979b;

    /* renamed from: c, reason: collision with root package name */
    private static Context f7980c;

    /* renamed from: d, reason: collision with root package name */
    private a f7981d;

    /* renamed from: e, reason: collision with root package name */
    private HandlerThread f7982e = new HandlerThread("manifestThread") { // from class: com.amap.api.col.s.w.1
        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            Thread.currentThread().setName("ManifestConfigThread");
            ch a10 = m.a(false);
            w.c(w.f7980c);
            bx.a(w.f7980c, a10, "11K;001;184;185", new bx.a() { // from class: com.amap.api.col.s.w.1.1
                @Override // com.amap.api.col.s.bx.a
                public final void a(bx.b bVar) {
                    a aVar;
                    JSONObject jSONObject;
                    JSONObject optJSONObject;
                    JSONObject jSONObject2;
                    JSONObject optJSONObject2;
                    Message message = new Message();
                    if (bVar != null) {
                        try {
                            bx.b.a aVar2 = bVar.f7358g;
                            if (aVar2 != null) {
                                message.obj = new x(aVar2.f7362b, aVar2.f7361a);
                            }
                        } catch (Throwable th) {
                            try {
                                n.a(th, "ManifestConfig", "run");
                                if (aVar == null) {
                                    return;
                                }
                            } finally {
                                message.what = 3;
                                if (w.this.f7981d != null) {
                                    w.this.f7981d.sendMessage(message);
                                }
                            }
                        }
                    }
                    if (bVar != null && (jSONObject2 = bVar.f7357f) != null && (optJSONObject2 = jSONObject2.optJSONObject("184")) != null) {
                        w.d(optJSONObject2);
                        av.a(w.f7980c, "amap_search", "cache_control", optJSONObject2.toString());
                    }
                    if (bVar != null && (jSONObject = bVar.f7357f) != null && (optJSONObject = jSONObject.optJSONObject("185")) != null) {
                        w.c(optJSONObject);
                        av.a(w.f7980c, "amap_search", "parm_control", optJSONObject.toString());
                    }
                    message.what = 3;
                    if (w.this.f7981d == null) {
                    }
                }
            });
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    };

    /* compiled from: ManifestConfig.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public String f7985a;

        public a(Looper looper) {
            super(looper);
            this.f7985a = "handleMessage";
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message != null && message.what == 3) {
                try {
                    x xVar = (x) message.obj;
                    if (xVar == null) {
                        xVar = new x(false, false);
                    }
                    df.a(w.f7980c, m.a(xVar.a()));
                    w.f7978a = m.a(xVar.a());
                } catch (Throwable th) {
                    n.a(th, "ManifestConfig", this.f7985a);
                }
            }
        }
    }

    private w(Context context) {
        f7980c = context;
        f7978a = m.a(false);
        try {
            b();
            this.f7981d = new a(Looper.getMainLooper());
            this.f7982e.start();
        } catch (Throwable th) {
            n.a(th, "ManifestConfig", "ManifestConfig");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        try {
            String str = (String) av.b(context, "amap_search", "cache_control", "");
            if (!TextUtils.isEmpty(str)) {
                d(new JSONObject(str));
            }
            String str2 = (String) av.b(context, "amap_search", "parm_control", "");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            c(new JSONObject(str2));
        } catch (Throwable th) {
            n.a(th, "ManifestConfig", "ManifestConfig-readAuthFromCache");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("able")) {
                    am.a a10 = a(jSONObject, true, (am.a) null);
                    am.a().a(a10);
                    if (a10.a()) {
                        a("regeo", jSONObject, a10);
                        a("geo", jSONObject, a10);
                        a("placeText", jSONObject, a10);
                        a("placeAround", jSONObject, a10);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void b() {
        al.a();
    }

    public static w a(Context context) {
        if (f7979b == null) {
            f7979b = new w(context);
        }
        return f7979b;
    }

    private static void a(String str, JSONObject jSONObject, am.a aVar) {
        if (jSONObject != null && jSONObject.has(str)) {
            am.a().a(str, a(jSONObject.optJSONObject(str), false, aVar));
        }
    }

    private static am.a a(JSONObject jSONObject, boolean z10, am.a aVar) {
        am.a aVar2;
        boolean optBoolean;
        am.a aVar3 = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            aVar2 = new am.a();
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (z10) {
                optBoolean = bx.a(jSONObject.optString("able"), aVar == null || aVar.a());
            } else {
                optBoolean = jSONObject.optBoolean("able", aVar == null || aVar.a());
            }
            int optInt = jSONObject.optInt("timeoffset", aVar != null ? (int) aVar.b() : RemoteMessageConst.DEFAULT_TTL);
            int optInt2 = jSONObject.optInt("num", aVar != null ? aVar.c() : 10);
            double optDouble = jSONObject.optDouble("limitDistance", aVar != null ? aVar.d() : ShadowDrawableWrapper.COS_45);
            aVar2.a(optBoolean);
            aVar2.a(optInt);
            aVar2.a(optInt2);
            aVar2.a(optDouble);
            return aVar2;
        } catch (Throwable th2) {
            th = th2;
            aVar3 = aVar2;
            th.printStackTrace();
            return aVar3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                boolean a10 = bx.a(jSONObject.optString("passAreaAble"), true);
                boolean a11 = bx.a(jSONObject.optString("truckAble"), true);
                boolean a12 = bx.a(jSONObject.optString("poiPageAble"), true);
                boolean a13 = bx.a(jSONObject.optString("rideAble"), true);
                boolean a14 = bx.a(jSONObject.optString("walkAble"), true);
                boolean a15 = bx.a(jSONObject.optString("passPointAble"), true);
                boolean a16 = bx.a(jSONObject.optString("keyWordLenAble"), true);
                int optInt = jSONObject.optInt("poiPageMaxSize", 25);
                int optInt2 = jSONObject.optInt("passAreaMaxCount", 100);
                int optInt3 = jSONObject.optInt("walkMaxLength", 100);
                int optInt4 = jSONObject.optInt("passPointMaxCount", 6);
                int optInt5 = jSONObject.optInt("poiPageMaxNum", 100);
                int optInt6 = jSONObject.optInt("truckMaxLength", 5000);
                int optInt7 = jSONObject.optInt("rideMaxLength", 1200);
                int optInt8 = jSONObject.optInt("passAreaMaxArea", 100000000);
                int optInt9 = jSONObject.optInt("passAreaPointCount", 16);
                int optInt10 = jSONObject.optInt("keyWordLenMaxNum", 100);
                ap.a().a(a10);
                ap.a().c(optInt2);
                ap.a().i(optInt8);
                ap.a().j(optInt9);
                ap.a().b(a11);
                ap.a().g(optInt6);
                ap.a().c(a12);
                ap.a().f(optInt5);
                ap.a().a(optInt);
                ap.a().b(optInt10);
                ap.a().g(a16);
                ap.a().d(a13);
                ap.a().h(optInt7);
                ap.a().e(a14);
                ap.a().d(optInt3);
                ap.a().f(a15);
                ap.a().e(optInt4);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
