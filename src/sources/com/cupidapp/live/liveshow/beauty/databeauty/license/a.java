package com.cupidapp.live.liveshow.beauty.databeauty.license;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.security.realidentity.build.aq;
import com.cupidapp.live.liveshow.beauty.databeauty.license.EffectLicenseProvider;
import com.effectsar.labcv.licenselibrary.EffectsSDKLicenseWrapper;
import com.effectsar.labcv.licenselibrary.HttpRequestProvider;
import com.effectsar.labcv.licenselibrary.LicenseCallback;
import java.io.File;
import java.util.HashMap;
import l2.d;
import q2.c;

/* compiled from: EffectLicenseHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a implements EffectLicenseProvider {

    /* renamed from: g, reason: collision with root package name */
    public static String f14832g = "https://cv.iccvlog.com/cv_tob/v1/api/sdk/tob_license/getlicense";

    /* renamed from: h, reason: collision with root package name */
    public static a f14833h = null;

    /* renamed from: i, reason: collision with root package name */
    public static String f14834i = "cv_test_online1";

    /* renamed from: j, reason: collision with root package name */
    public static String f14835j = "e479f002-4018-11eb-a1e0-b8599f494dc4";

    /* renamed from: a, reason: collision with root package name */
    public Context f14836a;

    /* renamed from: b, reason: collision with root package name */
    public EffectLicenseProvider.LICENSE_MODE_ENUM f14837b;

    /* renamed from: c, reason: collision with root package name */
    public int f14838c;

    /* renamed from: d, reason: collision with root package name */
    public String f14839d;

    /* renamed from: e, reason: collision with root package name */
    public EffectsSDKLicenseWrapper f14840e;

    /* renamed from: f, reason: collision with root package name */
    public HttpRequestProvider f14841f;

    /* compiled from: EffectLicenseHelper.java */
    /* renamed from: com.cupidapp.live.liveshow.beauty.databeauty.license.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class C0155a implements LicenseCallback {
        public C0155a() {
        }

        @Override // com.effectsar.labcv.licenselibrary.LicenseCallback
        public void execute(String str, int i10, int i11, String str2) {
            a.this.f14838c = i11;
            a.this.f14839d = str2;
        }
    }

    public a(Context context) {
        EffectLicenseProvider.LICENSE_MODE_ENUM license_mode_enum = EffectLicenseProvider.LICENSE_MODE_ENUM.OFFLINE_LICENSE;
        this.f14837b = license_mode_enum;
        this.f14838c = 0;
        this.f14839d = "";
        this.f14840e = null;
        this.f14841f = null;
        this.f14836a = context;
        HashMap hashMap = new HashMap();
        EffectLicenseProvider.LICENSE_MODE_ENUM license_mode_enum2 = this.f14837b;
        if (license_mode_enum2 == EffectLicenseProvider.LICENSE_MODE_ENUM.ONLINE_LICENSE) {
            hashMap.put("mode", "ONLINE");
            hashMap.put("url", f14832g);
            hashMap.put("key", f14834i);
            hashMap.put(aq.N, f14835j);
            hashMap.put("licensePath", context.getFilesDir().getPath() + "/license.bag");
        } else if (license_mode_enum2 == license_mode_enum) {
            hashMap.put("mode", "OFFLINE");
            hashMap.put("licensePath", new File(new File(d.h("AndroidBeautyLicense.bundle"), "AndroidBeautyLicense.bundle"), "fanka_com.cupidapp.live.licbag").getAbsolutePath());
        }
        m2.a aVar = new m2.a();
        this.f14841f = aVar;
        this.f14840e = new EffectsSDKLicenseWrapper(hashMap, aVar);
    }

    public static a h(Context context) {
        if (f14833h == null) {
            synchronized (a.class) {
                if (f14833h == null) {
                    f14833h = new a(context);
                }
            }
        }
        return f14833h;
    }

    @Override // com.cupidapp.live.liveshow.beauty.databeauty.license.EffectLicenseProvider
    public String a() {
        this.f14838c = 0;
        this.f14839d = "";
        int licenseWithParams = this.f14840e.getLicenseWithParams(new HashMap<>(), false, new C0155a());
        if (licenseWithParams != 0) {
            this.f14838c = licenseWithParams;
            this.f14839d = "{zh} jni注册失败，检查是否注入网络请求 {en} Jni registration failed, check whether the network request is injected";
        }
        return !b("getLicensePath") ? "" : this.f14840e.getParam("licensePath");
    }

    @Override // com.cupidapp.live.liveshow.beauty.databeauty.license.EffectLicenseProvider
    public boolean b(String str) {
        if (this.f14838c == 0) {
            return true;
        }
        String str2 = str + " error: " + this.f14838c;
        c.b(str2);
        String str3 = this.f14839d;
        if (str3 != "") {
            str2 = str3;
        }
        Intent intent = new Intent("com.effectsar.labcv.core.check_result:action");
        intent.putExtra("msg", str2);
        LocalBroadcastManager.getInstance(this.f14836a).sendBroadcast(intent);
        return false;
    }

    @Override // com.cupidapp.live.liveshow.beauty.databeauty.license.EffectLicenseProvider
    public String c() {
        return new File(new File(d.h("AndroidBeautyLicense.bundle"), "AndroidBeautyLicense.bundle"), "resource.json").getAbsolutePath();
    }

    @Override // com.cupidapp.live.liveshow.beauty.databeauty.license.EffectLicenseProvider
    public int d() {
        return this.f14838c;
    }

    @Override // com.cupidapp.live.liveshow.beauty.databeauty.license.EffectLicenseProvider
    public EffectLicenseProvider.LICENSE_MODE_ENUM e() {
        return this.f14837b;
    }
}
