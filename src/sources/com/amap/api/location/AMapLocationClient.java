package com.amap.api.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.amap.api.col.p0003l.d;
import com.amap.api.col.p0003l.fm;
import com.amap.api.col.p0003l.fr;
import com.amap.api.col.p0003l.fs;
import com.amap.api.col.p0003l.hw;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.h;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AMapLocationClient {

    /* renamed from: a, reason: collision with root package name */
    public Context f8083a;

    /* renamed from: b, reason: collision with root package name */
    public d f8084b;

    public AMapLocationClient(Context context) throws Exception {
        a(context);
        try {
            if (context != null) {
                Context applicationContext = context.getApplicationContext();
                this.f8083a = applicationContext;
                com.autonavi.aps.amapapi.utils.d.a(applicationContext);
                this.f8084b = new d(context, null, null);
                return;
            }
            throw new IllegalArgumentException("Context参数不能为null");
        } catch (Throwable th) {
            b.a(th, "AMClt", "ne1");
        }
    }

    private static void a(Context context) throws Exception {
        fs a10 = fr.a(context, b.c());
        if (a10.f5947a != fr.c.SuccessCode) {
            throw new Exception(a10.f5948b);
        }
    }

    public static String getDeviceId(Context context) {
        return fm.q(context);
    }

    public static void setApiKey(String str) {
        try {
            AMapLocationClientOption.f8085a = str;
        } catch (Throwable th) {
            b.a(th, "AMClt", "sKey");
        }
    }

    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            hw.f6309a = -1;
            hw.f6310b = "";
        } else {
            hw.f6309a = 1;
            hw.f6310b = str;
        }
    }

    public static void updatePrivacyAgree(Context context, boolean z10) {
        fr.a(context, z10, b.c());
    }

    public static void updatePrivacyShow(Context context, boolean z10, boolean z11) {
        fr.a(context, z10, z11, b.c());
    }

    public void disableBackgroundLocation(boolean z10) {
        try {
            d dVar = this.f8084b;
            if (dVar != null) {
                dVar.a(z10);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "dBackL");
        }
    }

    public void enableBackgroundLocation(int i10, Notification notification) {
        try {
            d dVar = this.f8084b;
            if (dVar != null) {
                dVar.a(i10, notification);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "eBackL");
        }
    }

    public AMapLocation getLastKnownLocation() {
        try {
            d dVar = this.f8084b;
            if (dVar != null) {
                return dVar.e();
            }
            return null;
        } catch (Throwable th) {
            b.a(th, "AMClt", "gLastL");
            return null;
        }
    }

    public String getVersion() {
        return "6.4.1";
    }

    public boolean isStarted() {
        try {
            d dVar = this.f8084b;
            if (dVar != null) {
                return dVar.a();
            }
            return false;
        } catch (Throwable th) {
            b.a(th, "AMClt", "isS");
            return false;
        }
    }

    public void onDestroy() {
        try {
            d dVar = this.f8084b;
            if (dVar != null) {
                dVar.d();
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "onDy");
        }
    }

    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            if (aMapLocationListener != null) {
                d dVar = this.f8084b;
                if (dVar != null) {
                    dVar.a(aMapLocationListener);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("listener参数不能为null");
        } catch (Throwable th) {
            b.a(th, "AMClt", "sLocL");
        }
    }

    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        try {
            if (aMapLocationClientOption != null) {
                d dVar = this.f8084b;
                if (dVar != null) {
                    dVar.a(aMapLocationClientOption);
                }
                if (aMapLocationClientOption.f8091b) {
                    aMapLocationClientOption.f8091b = false;
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(aMapLocationClientOption.f8092c)) {
                        jSONObject.put("amap_loc_scenes_type", aMapLocationClientOption.f8092c);
                    }
                    h.a(this.f8083a, "O019", jSONObject);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("LocationManagerOption参数不能为null");
        } catch (Throwable th) {
            b.a(th, "AMClt", "sLocnO");
        }
    }

    public void startAssistantLocation(WebView webView) {
        try {
            d dVar = this.f8084b;
            if (dVar != null) {
                dVar.a(webView);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "sttAssL1");
        }
    }

    public void startLocation() {
        try {
            d dVar = this.f8084b;
            if (dVar != null) {
                dVar.b();
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "stl");
        }
    }

    public void stopAssistantLocation() {
        try {
            d dVar = this.f8084b;
            if (dVar != null) {
                dVar.f();
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "stAssL");
        }
    }

    public void stopLocation() {
        try {
            d dVar = this.f8084b;
            if (dVar != null) {
                dVar.c();
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "stl");
        }
    }

    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            d dVar = this.f8084b;
            if (dVar != null) {
                dVar.b(aMapLocationListener);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "unRL");
        }
    }

    public AMapLocationClient(Context context, Intent intent) throws Exception {
        a(context);
        try {
            if (context != null) {
                this.f8083a = context.getApplicationContext();
                this.f8084b = new d(this.f8083a, intent, null);
                return;
            }
            throw new IllegalArgumentException("Context参数不能为null");
        } catch (Throwable th) {
            b.a(th, "AMClt", "ne2");
        }
    }

    public AMapLocationClient(Looper looper, Context context) throws Exception {
        a(context);
        try {
            if (context != null) {
                this.f8083a = context.getApplicationContext();
                this.f8084b = new d(this.f8083a, null, looper);
                return;
            }
            throw new IllegalArgumentException("Context参数不能为null");
        } catch (Throwable th) {
            b.a(th, "AMClt", "ne3");
        }
    }
}
