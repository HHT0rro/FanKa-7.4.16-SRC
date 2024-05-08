package com.alimm.tanx.core.utils;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.common.tanxc_do;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import wc.b;
import wc.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DeviceIdGetUtil implements NotConfused {
    public static final int IMEI_GET_MAX_COUNT = 2;
    public static final String TAG = "DeviceIdGetUtil-";
    public static Application application;
    public static DeviceIdGetUtil instance;
    public volatile int imeiGetNowCount = 0;

    public DeviceIdGetUtil() {
        b.k().d(application);
    }

    public static DeviceIdGetUtil getInstance(Application application2) {
        if (instance == null) {
            synchronized (b.class) {
                if (instance == null) {
                    application = application2;
                    instance = new DeviceIdGetUtil();
                }
            }
        }
        return instance;
    }

    public void getClientId() {
        String a10 = b.k().a();
        if (!TextUtils.isEmpty(a10)) {
            TanxCoreSdk.getConfig().setClientId(a10);
        }
        LogUtils.d("DeviceIdGetUtil-clientIdGet", a10);
    }

    public void getGuid() {
        String g3 = b.k().g(application);
        if (!TextUtils.isEmpty(g3)) {
            TanxCoreSdk.getConfig().setGuid(g3);
        }
        LogUtils.d("DeviceIdGetUtil-guidGet", g3);
    }

    public void getImei() {
        String i10 = b.k().i(application);
        if (!TextUtils.isEmpty(i10)) {
            TanxCoreSdk.getConfig().setImei(i10);
        }
        LogUtils.d("DeviceIdGetUtil-imeiGet", i10);
    }

    public void getOaid() {
        final long currentTimeMillis = System.currentTimeMillis();
        String oaid = TanxCoreSdk.getConfig().getOaid();
        if (!TextUtils.isEmpty(oaid)) {
            TanxCoreSdk.getConfig().setmOaid(oaid);
        }
        b.k().b(application, new c() { // from class: com.alimm.tanx.core.utils.DeviceIdGetUtil.2
            @Override // wc.c
            public void oaidError(Exception exc) {
                LogUtils.e("DeviceIdGetUtil-oaidGet", exc);
                if (Build.VERSION.SDK_INT >= 29) {
                    TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "DeviceIdGetUtil-oaidGet", LogUtils.getStackTraceMessage(exc), "");
                }
            }

            @Override // wc.c
            public void oaidSucc(String str) {
                if (!TextUtils.isEmpty(str)) {
                    TanxCoreSdk.getConfig().setmOaid(str);
                }
                LogUtils.d("DeviceIdGetUtil-oaidGet", str + "\ntime-> " + (System.currentTimeMillis() - currentTimeMillis));
            }
        });
    }

    public void getPseudoId() {
        String f10 = b.k().f();
        if (!TextUtils.isEmpty(f10)) {
            TanxCoreSdk.getConfig().setPseudoId(f10);
        }
        LogUtils.d("DeviceIdGetUtil-pseudoIdGet", f10);
    }

    public void getWidevineId() {
        String h10 = b.k().h();
        if (!TextUtils.isEmpty(h10)) {
            TanxCoreSdk.getConfig().setWidevineId(h10);
        }
        LogUtils.d("DeviceIdGetUtil-widevineIDGet", h10);
    }

    public void initId() {
        tanxc_do.tanxc_do(new Runnable() { // from class: com.alimm.tanx.core.utils.DeviceIdGetUtil.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (TanxCoreSdk.getConfig().isOaidSwitch()) {
                        DeviceIdGetUtil.this.getOaid();
                    } else {
                        LogUtils.d("DeviceIdGetUtil-oaidGet", "无需获取：isOaidSwitch->" + TanxCoreSdk.getConfig().isOaidSwitch() + "\nnowOaid" + TanxCoreSdk.getConfig().getOaid());
                    }
                    if (TanxCoreSdk.getConfig().isImeiSwitch()) {
                        DeviceIdGetUtil.this.getImei();
                        return;
                    }
                    LogUtils.d("DeviceIdGetUtil-imeiGet", "无需获取：isImeiSwitch->" + TanxCoreSdk.getConfig().isImeiSwitch() + "\nnowImei" + TanxCoreSdk.getConfig().getImei());
                } catch (Exception e2) {
                    LogUtils.e("DeviceIdGetUtil-initAllId", e2);
                    TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "DeviceIdGetUtil-initAllId", LogUtils.getStackTraceMessage(e2), "");
                }
            }
        });
    }

    public void netGetImei() {
        if (this.imeiGetNowCount < 2 && TextUtils.isEmpty(TanxCoreSdk.getConfig().getImei()) && TextUtils.isEmpty(TanxCoreSdk.getConfig().getOaid()) && TanxCoreSdk.getConfig().isImeiSwitch()) {
            getImei();
            this.imeiGetNowCount++;
        }
    }
}
