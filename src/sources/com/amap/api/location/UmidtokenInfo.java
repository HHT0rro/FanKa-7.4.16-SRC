package com.amap.api.location;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.p0003l.fm;
import com.autonavi.aps.amapapi.utils.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class UmidtokenInfo {

    /* renamed from: d, reason: collision with root package name */
    private static AMapLocationClient f8147d;

    /* renamed from: a, reason: collision with root package name */
    public static Handler f8144a = new Handler();

    /* renamed from: b, reason: collision with root package name */
    public static String f8145b = null;

    /* renamed from: e, reason: collision with root package name */
    private static long f8148e = 30000;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f8146c = true;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a implements AMapLocationListener {
        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            try {
                if (UmidtokenInfo.f8147d != null) {
                    UmidtokenInfo.f8144a.removeCallbacksAndMessages(null);
                    UmidtokenInfo.f8147d.onDestroy();
                }
            } catch (Throwable th) {
                b.a(th, "UmidListener", "onLocationChanged");
            }
        }
    }

    public static String getUmidtoken() {
        return f8145b;
    }

    public static void setLocAble(boolean z10) {
        f8146c = z10;
    }

    public static synchronized void setUmidtoken(Context context, String str) {
        synchronized (UmidtokenInfo.class) {
            try {
                f8145b = str;
                fm.a(str);
                if (f8147d == null && f8146c) {
                    a aVar = new a();
                    f8147d = new AMapLocationClient(context);
                    AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
                    aMapLocationClientOption.setOnceLocation(true);
                    aMapLocationClientOption.setNeedAddress(false);
                    f8147d.setLocationOption(aMapLocationClientOption);
                    f8147d.setLocationListener(aVar);
                    f8147d.startLocation();
                    f8144a.postDelayed(new Runnable() { // from class: com.amap.api.location.UmidtokenInfo.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (UmidtokenInfo.f8147d != null) {
                                    UmidtokenInfo.f8147d.onDestroy();
                                }
                            } catch (Throwable th) {
                                b.a(th, "UmidListener", "postDelayed");
                            }
                        }
                    }, 30000L);
                }
            } catch (Throwable th) {
                b.a(th, "UmidListener", "setUmidtoken");
            }
        }
    }
}
