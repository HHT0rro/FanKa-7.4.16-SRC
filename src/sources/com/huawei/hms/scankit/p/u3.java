package com.huawei.hms.scankit.p;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.huawei.quickcard.framework.bean.ConfigBean;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HaLog.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class u3 {

    /* renamed from: d, reason: collision with root package name */
    public static String f31572d = "FORMAT_UNKNOWN";

    /* renamed from: e, reason: collision with root package name */
    public static String f31573e = "OTHER";

    /* renamed from: f, reason: collision with root package name */
    public static SparseArray<String> f31574f = new a();

    /* renamed from: g, reason: collision with root package name */
    public static SparseArray<String> f31575g = new b();

    /* renamed from: a, reason: collision with root package name */
    public Context f31576a;

    /* renamed from: b, reason: collision with root package name */
    public LinkedHashMap<String, String> f31577b = new LinkedHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public volatile long f31578c;

    /* compiled from: HaLog.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends SparseArray<String> {
        public a() {
            put(HmsScanBase.AZTEC_SCAN_TYPE, "AZTEC");
            put(HmsScanBase.CODABAR_SCAN_TYPE, "CODABAR");
            put(HmsScanBase.CODE39_SCAN_TYPE, "CODE39");
            put(HmsScanBase.CODE93_SCAN_TYPE, "CODE93");
            put(HmsScanBase.CODE128_SCAN_TYPE, "CODE128");
            put(HmsScanBase.DATAMATRIX_SCAN_TYPE, "DATAMATRIX");
            put(HmsScanBase.EAN8_SCAN_TYPE, "EAN8");
            put(HmsScanBase.EAN13_SCAN_TYPE, "EAN13");
            put(HmsScanBase.ITF14_SCAN_TYPE, "ITF14");
            put(HmsScanBase.PDF417_SCAN_TYPE, "PDF417");
            put(HmsScanBase.QRCODE_SCAN_TYPE, "QRCODE");
            put(HmsScanBase.UPCCODE_A_SCAN_TYPE, "UPCCODE_A");
            put(HmsScanBase.UPCCODE_E_SCAN_TYPE, "UPCCODE_E");
            put(HmsScanBase.FORMAT_UNKNOWN, u3.f31572d);
        }
    }

    /* compiled from: HaLog.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b extends SparseArray<String> {
        public b() {
            put(HmsScan.ARTICLE_NUMBER_FORM, "ARTICLE_NUMBER");
            put(HmsScan.EMAIL_CONTENT_FORM, "EMAIL_CONTENT");
            put(HmsScan.TEL_PHONE_NUMBER_FORM, "TEL_PHONE_NUMBER");
            put(HmsScan.PURE_TEXT_FORM, "PURE_TEXT");
            put(HmsScan.SMS_FORM, "SMS");
            put(HmsScan.URL_FORM, "URL");
            put(HmsScan.WIFI_CONNECT_INFO_FORM, "WIFI_CONNECT_INFO");
            put(HmsScan.EVENT_INFO_FORM, "EVENT_INFO");
            put(HmsScan.CONTACT_DETAIL_FORM, "CONTACT_DETAIL");
            put(HmsScan.DRIVER_INFO_FORM, "DRIVER_INFO");
            put(HmsScan.LOCATION_COORDINATE_FORM, "LOCATION_COORDINATE");
            put(HmsScan.ISBN_NUMBER_FORM, "ISBN_NUMBER");
            put(-1, u3.f31573e);
        }
    }

    public u3(Bundle bundle, Context context) {
        this.f31576a = context;
        b(bundle);
    }

    private void b(Bundle bundle) {
        try {
            String packageName = this.f31576a.getPackageName();
            this.f31577b.put("package", packageName);
            if (bundle != null && bundle.containsKey("appid")) {
                this.f31577b.put("appid", bundle.getString("appid"));
            } else {
                this.f31577b.put("appid", packageName);
            }
            PackageManager packageManager = this.f31576a.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 128);
            this.f31577b.put("appName", applicationInfo.loadLabel(packageManager).toString());
            this.f31577b.put("version", a(applicationInfo.metaData));
            String d10 = d();
            this.f31577b.put("hmscoreVersion", d10);
            this.f31577b.put("isHMSCore", "unknown".equals(d10) ? "0" : "1");
        } catch (PackageManager.NameNotFoundException unused) {
            o4.b("HaLog", "PackageManager.NameNotFoundException");
        } catch (Exception unused2) {
            o4.b("HaLog", "initValue Exception");
        }
        try {
            this.f31577b.put("sdkName", "scankit");
            this.f31577b.put("algopt", b());
            this.f31577b.put("isFullSdk", "FULLSDK");
            this.f31577b.put(WiseOpenHianalyticsData.UNION_APP_VERSION, c());
            if (!b4.f30737a) {
                this.f31577b.put("apkVersion", "unknown");
            } else {
                this.f31577b.put("apkVersion", b4.f30738b);
            }
            this.f31577b.put("service", "com.huawei.hms.scankit");
            this.f31577b.put("operator", b4.b(this.f31576a));
            this.f31577b.put(ConfigBean.Field.NETWORK_TYPE, b4.a(this.f31576a));
            this.f31577b.put(MLApplicationSetting.BundleKeyConstants.AppInfo.COUNTRY_CODE, b4.a(this.f31576a, false));
            this.f31577b.put("deviceType", b4.c());
            this.f31577b.put("emuiVersion", b4.d());
            this.f31577b.put("androidVersion", b4.a());
            this.f31577b.put("deviceCategory", b4.b());
        } catch (RuntimeException unused3) {
            o4.b("HaLog", "initValue RuntimeException");
        } catch (Exception unused4) {
            o4.b("HaLog", "initValue Exception");
        }
    }

    private String c() {
        try {
            return this.f31576a.getPackageManager().getPackageInfo(this.f31576a.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return "unknown";
        }
    }

    private String d() {
        try {
            return this.f31576a.getPackageManager().getPackageInfo("com.huawei.hwid", 0).versionName;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return "unknown";
        }
    }

    private boolean e() {
        try {
            String property = SystemPropUtils.getProperty(MonitorConstants.CONNECT_TYPE_GET, com.huawei.openalliance.ad.utils.j.Code, "android.os.SystemProperties", GrsBaseInfo.CountryCodeSource.UNKNOWN);
            TelephonyManager telephonyManager = (TelephonyManager) this.f31576a.getApplicationContext().getSystemService("phone");
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            String simCountryIso = telephonyManager.getSimCountryIso();
            if ("CN".equalsIgnoreCase(property) && "CN".equalsIgnoreCase(networkCountryIso)) {
                return "CN".equalsIgnoreCase(simCountryIso);
            }
            return false;
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    private boolean f() {
        return true;
    }

    public boolean a() {
        if (w7.c(this.f31576a)) {
            return false;
        }
        try {
            if (!f() && !e()) {
                if (Settings.Secure.getInt(this.f31576a.getContentResolver(), "hw_app_analytics_state", 0) != 1) {
                    return false;
                }
            }
            return true;
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    public void g() {
        String str;
        o4.d("HaLog", "update HiAnalyticsLogUtils.apk_mode " + b4.f30737a + " HiAnalyticsLogUtils.apkVersion " + b4.f30738b);
        if (!b4.f30737a || (str = b4.f30738b) == null) {
            return;
        }
        this.f31577b.put("apkVersion", str);
    }

    public static String a(int i10) {
        return f31574f.get(i10, f31572d);
    }

    private String a(Bundle bundle) {
        String[] strArr = {"huawei_module_scankit_sdk_version", "com.huawei.hms.client.service.name:scan", "com.huawei.hms.client.service.name:scanplus", "com.huawei.hms.client.service.name:scankit"};
        if (bundle == null) {
            return "scankit:1.0.2.300";
        }
        for (int i10 = 0; i10 < 4; i10++) {
            String str = strArr[i10];
            if (bundle.getString(str) != null) {
                return bundle.getString(str);
            }
        }
        return "scankit:1.0.2.300";
    }

    private String b() {
        return Build.VERSION.SDK_INT == 24 ? "full-noso" : "full";
    }

    public static String b(int i10) {
        return f31575g.get(i10, f31573e);
    }
}
