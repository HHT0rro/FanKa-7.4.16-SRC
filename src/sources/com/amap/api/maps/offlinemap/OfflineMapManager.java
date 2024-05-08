package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.p0003l.ax;
import com.amap.api.col.p0003l.ay;
import com.amap.api.col.p0003l.bc;
import com.amap.api.col.p0003l.du;
import com.amap.api.col.p0003l.dx;
import com.amap.api.col.p0003l.fo;
import com.amap.api.col.p0003l.fr;
import com.amap.api.col.p0003l.fs;
import com.amap.api.col.p0003l.gy;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OfflineMapManager {

    /* renamed from: a, reason: collision with root package name */
    public bc f8282a;

    /* renamed from: b, reason: collision with root package name */
    public ay f8283b;

    /* renamed from: c, reason: collision with root package name */
    private Context f8284c;

    /* renamed from: d, reason: collision with root package name */
    private OfflineMapDownloadListener f8285d;

    /* renamed from: e, reason: collision with root package name */
    private OfflineLoadedListener f8286e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f8287f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f8288g;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OfflineLoadedListener {
        void onVerifyComplete();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OfflineMapDownloadListener {
        void onCheckUpdate(boolean z10, String str);

        void onDownload(int i10, int i11, String str);

        void onRemove(boolean z10, String str, String str2);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener) throws Exception {
        fs a10 = fr.a(context, dx.a());
        if (a10.f5947a == fr.c.SuccessCode) {
            this.f8285d = offlineMapDownloadListener;
            this.f8284c = context.getApplicationContext();
            this.f8287f = new Handler(this.f8284c.getMainLooper());
            this.f8288g = new Handler(this.f8284c.getMainLooper());
            a(context);
            fo.a().a(this.f8284c);
            return;
        }
        throw new Exception(a10.f5948b);
    }

    public final void destroy() {
        try {
            ay ayVar = this.f8283b;
            if (ayVar != null) {
                ayVar.f();
            }
            b();
            Handler handler = this.f8287f;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f8287f = null;
            Handler handler2 = this.f8288g;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            this.f8288g = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityCode(String str) throws AMapException {
        try {
            this.f8283b.f(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityName(String str) throws AMapException {
        try {
            this.f8283b.e(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByProvinceName(String str) throws AMapException {
        try {
            a();
            OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
            if (itemByProvinceName != null) {
                Iterator<OfflineMapCity> iterator2 = itemByProvinceName.getCityList().iterator2();
                while (iterator2.hasNext()) {
                    final String city = iterator2.next().getCity();
                    this.f8288g.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                OfflineMapManager.this.f8283b.e(city);
                            } catch (AMapException e2) {
                                gy.b(e2, "OfflineMapManager", "downloadByProvinceName");
                            }
                        }
                    });
                }
                return;
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (Throwable th) {
            if (!(th instanceof AMapException)) {
                gy.b(th, "OfflineMapManager", "downloadByProvinceName");
                return;
            }
            throw th;
        }
    }

    public final ArrayList<OfflineMapCity> getDownloadOfflineMapCityList() {
        return this.f8282a.c();
    }

    public final ArrayList<OfflineMapProvince> getDownloadOfflineMapProvinceList() {
        return this.f8282a.d();
    }

    public final ArrayList<OfflineMapCity> getDownloadingCityList() {
        return this.f8282a.e();
    }

    public final ArrayList<OfflineMapProvince> getDownloadingProvinceList() {
        return this.f8282a.f();
    }

    public final OfflineMapCity getItemByCityCode(String str) {
        return this.f8282a.a(str);
    }

    public final OfflineMapCity getItemByCityName(String str) {
        return this.f8282a.b(str);
    }

    public final OfflineMapProvince getItemByProvinceName(String str) {
        return this.f8282a.c(str);
    }

    public final ArrayList<OfflineMapCity> getOfflineMapCityList() {
        return this.f8282a.b();
    }

    public final ArrayList<OfflineMapProvince> getOfflineMapProvinceList() {
        return this.f8282a.a();
    }

    public final void pause() {
        this.f8283b.e();
    }

    public final void pauseByName(String str) {
        this.f8283b.d(str);
    }

    public final void remove(String str) {
        try {
            if (this.f8283b.b(str)) {
                this.f8283b.c(str);
                return;
            }
            OfflineMapProvince c4 = this.f8282a.c(str);
            if (c4 != null && c4.getCityList() != null) {
                Iterator<OfflineMapCity> iterator2 = c4.getCityList().iterator2();
                while (iterator2.hasNext()) {
                    final String city = iterator2.next().getCity();
                    this.f8288g.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            OfflineMapManager.this.f8283b.c(city);
                        }
                    });
                }
                return;
            }
            OfflineMapDownloadListener offlineMapDownloadListener = this.f8285d;
            if (offlineMapDownloadListener != null) {
                offlineMapDownloadListener.onRemove(false, str, "没有该城市");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void restart() {
    }

    public final void setOnOfflineLoadedListener(OfflineLoadedListener offlineLoadedListener) {
        this.f8286e = offlineLoadedListener;
    }

    public final void stop() {
        this.f8283b.d();
    }

    public final void updateOfflineCityByCode(String str) throws AMapException {
        OfflineMapCity itemByCityCode = getItemByCityCode(str);
        if (itemByCityCode != null && itemByCityCode.getCity() != null) {
            a(itemByCityCode.getCity());
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public final void updateOfflineCityByName(String str) throws AMapException {
        a(str);
    }

    public final void updateOfflineMapProvinceByName(String str) throws AMapException {
        a(str);
    }

    private void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f8284c = applicationContext;
        ay.f5078b = false;
        ay a10 = ay.a(applicationContext);
        this.f8283b = a10;
        a10.a(new ay.a() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1
            @Override // com.amap.api.col.3l.ay.a
            public final void a(final ax axVar) {
                if (OfflineMapManager.this.f8285d == null || axVar == null) {
                    return;
                }
                OfflineMapManager.this.f8287f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            OfflineMapManager.this.f8285d.onDownload(axVar.c().b(), axVar.getcompleteCode(), axVar.getCity());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.col.3l.ay.a
            public final void b(final ax axVar) {
                if (OfflineMapManager.this.f8285d == null || axVar == null) {
                    return;
                }
                OfflineMapManager.this.f8287f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (!axVar.c().equals(axVar.f5062g) && !axVar.c().equals(axVar.f5056a)) {
                                OfflineMapManager.this.f8285d.onCheckUpdate(false, axVar.getCity());
                                return;
                            }
                            OfflineMapManager.this.f8285d.onCheckUpdate(true, axVar.getCity());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.col.3l.ay.a
            public final void c(final ax axVar) {
                if (OfflineMapManager.this.f8285d == null || axVar == null) {
                    return;
                }
                OfflineMapManager.this.f8287f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (axVar.c().equals(axVar.f5056a)) {
                                OfflineMapManager.this.f8285d.onRemove(true, axVar.getCity(), "");
                            } else {
                                OfflineMapManager.this.f8285d.onRemove(false, axVar.getCity(), "");
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.col.3l.ay.a
            public final void a() {
                if (OfflineMapManager.this.f8286e != null) {
                    OfflineMapManager.this.f8287f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                OfflineMapManager.this.f8286e.onVerifyComplete();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
        try {
            this.f8283b.a();
            this.f8282a = this.f8283b.f5083f;
            du.b(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b() {
        this.f8285d = null;
    }

    private void a(String str) throws AMapException {
        this.f8283b.a(str);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener, AMap aMap) {
        this.f8285d = offlineMapDownloadListener;
        this.f8284c = context.getApplicationContext();
        this.f8287f = new Handler(this.f8284c.getMainLooper());
        this.f8288g = new Handler(this.f8284c.getMainLooper());
        try {
            a(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() throws AMapException {
        if (!dx.d(this.f8284c)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }
}
