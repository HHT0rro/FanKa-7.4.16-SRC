package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthTerrainTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private Context f6945a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<IAMapDelegate> f6946b;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f6947c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f6948d;

    /* renamed from: e, reason: collision with root package name */
    private a f6949e;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f6950f = new Runnable() { // from class: com.amap.api.col.3l.v.1
        @Override // java.lang.Runnable
        public final void run() {
            if (v.this.f6949e == null) {
                v vVar = v.this;
                vVar.f6949e = new a(vVar.f6945a, v.this);
            }
            dv.a().a(v.this.f6949e);
        }
    };

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f6951g = new Runnable() { // from class: com.amap.api.col.3l.v.2
        @Override // java.lang.Runnable
        public final void run() {
            IAMapDelegate iAMapDelegate = (IAMapDelegate) v.this.f6946b.get();
            if (iAMapDelegate != null) {
                iAMapDelegate.setTerrainAuth(false);
            }
            dd.a(v.this.f6945a, "地形图鉴权失败，当前key没有地形图的使用权限，地形图，将不会呈现！");
        }
    };

    /* compiled from: AuthTerrainTask.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a extends je {

        /* renamed from: a, reason: collision with root package name */
        private Context f6954a;

        /* renamed from: b, reason: collision with root package name */
        private v f6955b;

        /* renamed from: c, reason: collision with root package name */
        private b f6956c;

        public a(Context context, v vVar) {
            this.f6954a = context;
            this.f6955b = vVar;
            this.f6956c = new b(context, "");
        }

        @Override // com.amap.api.col.p0003l.je
        public final void runTask() {
            try {
                c d10 = this.f6956c.d();
                if (d10 == null) {
                    this.f6955b.a(30000L);
                } else {
                    if (d10.f6961d) {
                        return;
                    }
                    this.f6955b.c();
                }
            } catch (fa e2) {
                e2.printStackTrace();
                this.f6955b.a(30000L);
            }
        }
    }

    /* compiled from: AuthTerrainTask.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b extends fb<String, c> {

        /* renamed from: f, reason: collision with root package name */
        private boolean f6957f;

        public b(Context context, String str) {
            super(context, str);
            ((fb) this).f5702d = "/rest/feedback/terrain";
            this.isPostFlag = false;
            this.f6957f = true;
        }

        private static c b(byte[] bArr) throws fa {
            String str;
            try {
                str = new String(bArr, "utf-8");
            } catch (Exception e2) {
                e2.printStackTrace();
                str = null;
            }
            if (str == null || "".equals(str)) {
                return null;
            }
            return b(str);
        }

        @Override // com.amap.api.col.p0003l.fb
        public final /* synthetic */ c a(String str) throws fa {
            return b(str);
        }

        @Override // com.amap.api.col.p0003l.fb
        public final String c() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.id
        public final String getIPV6URL() {
            return dx.a(getURL());
        }

        @Override // com.amap.api.col.p0003l.db, com.amap.api.col.p0003l.id
        public final Map<String, String> getParams() {
            Hashtable hashtable = new Hashtable(16);
            hashtable.put("key", fj.f(((fb) this).f5701c));
            if (this.f6957f) {
                hashtable.put("pname", "3dmap");
            }
            String a10 = fl.a();
            String a11 = fl.a(((fb) this).f5701c, a10, fv.b(hashtable));
            hashtable.put("ts", a10);
            hashtable.put("scode", a11);
            return hashtable;
        }

        @Override // com.amap.api.col.p0003l.id
        public final String getURL() {
            return "http://restsdk.amap.com" + ((fb) this).f5702d;
        }

        @Override // com.amap.api.col.p0003l.id
        public final boolean isSupportIPV6() {
            return true;
        }

        @Override // com.amap.api.col.p0003l.fb
        public final /* synthetic */ c a(byte[] bArr) throws fa {
            return b(bArr);
        }

        private static c b(String str) throws fa {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("info");
                String optString2 = jSONObject.optString("infocode");
                String optString3 = jSONObject.optString("status");
                boolean z10 = false;
                z10 = false;
                c cVar = new c(z10 ? (byte) 1 : (byte) 0);
                cVar.f6958a = optString;
                cVar.f6959b = optString2;
                cVar.f6960c = optString3;
                if (!TextUtils.isEmpty(optString2) && TextUtils.equals(optString2, "10000")) {
                    z10 = true;
                }
                cVar.f6961d = z10;
                return cVar;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public v(Context context, IAMapDelegate iAMapDelegate) {
        this.f6945a = context.getApplicationContext();
        this.f6946b = new WeakReference<>(iAMapDelegate);
        b();
    }

    /* compiled from: AuthTerrainTask.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f6958a;

        /* renamed from: b, reason: collision with root package name */
        public String f6959b;

        /* renamed from: c, reason: collision with root package name */
        public String f6960c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f6961d;

        private c() {
            this.f6961d = false;
        }

        public /* synthetic */ c(byte b4) {
            this();
        }
    }

    private void b() {
        if (this.f6947c == null) {
            HandlerThread handlerThread = new HandlerThread("terrain_auth");
            this.f6947c = handlerThread;
            handlerThread.start();
            this.f6948d = new Handler(this.f6947c.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Handler handler = this.f6948d;
        if (handler != null) {
            handler.postDelayed(this.f6951g, 1000L);
        }
    }

    public final void a(long j10) {
        Handler handler = this.f6948d;
        if (handler != null) {
            handler.postDelayed(this.f6950f, j10);
        }
    }

    public final void a() {
        Handler handler = this.f6948d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f6948d = null;
        }
        HandlerThread handlerThread = this.f6947c;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f6947c = null;
        }
    }
}
