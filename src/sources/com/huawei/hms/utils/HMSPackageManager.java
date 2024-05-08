package com.huawei.hms.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Pair;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.mlsdk.common.internal.client.event.MonitorResult;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HMSPackageManager {

    /* renamed from: o, reason: collision with root package name */
    private static HMSPackageManager f31933o;

    /* renamed from: p, reason: collision with root package name */
    private static final Object f31934p = new Object();

    /* renamed from: q, reason: collision with root package name */
    private static final Object f31935q = new Object();

    /* renamed from: r, reason: collision with root package name */
    private static final Object f31936r = new Object();

    /* renamed from: s, reason: collision with root package name */
    private static final Map<String, String> f31937s;

    /* renamed from: a, reason: collision with root package name */
    private final Context f31938a;

    /* renamed from: b, reason: collision with root package name */
    private final PackageManagerHelper f31939b;

    /* renamed from: c, reason: collision with root package name */
    private String f31940c;

    /* renamed from: d, reason: collision with root package name */
    private String f31941d;

    /* renamed from: e, reason: collision with root package name */
    private int f31942e;

    /* renamed from: f, reason: collision with root package name */
    private String f31943f;

    /* renamed from: g, reason: collision with root package name */
    private String f31944g;

    /* renamed from: h, reason: collision with root package name */
    private String f31945h;

    /* renamed from: i, reason: collision with root package name */
    private String f31946i;

    /* renamed from: j, reason: collision with root package name */
    private int f31947j;

    /* renamed from: k, reason: collision with root package name */
    private int f31948k;

    /* renamed from: l, reason: collision with root package name */
    private long f31949l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f31950m;

    /* renamed from: n, reason: collision with root package name */
    private int f31951n;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class PackagePriorityInfo implements Comparable<PackagePriorityInfo> {

        /* renamed from: a, reason: collision with root package name */
        private String f31952a;

        /* renamed from: b, reason: collision with root package name */
        private String f31953b;

        /* renamed from: c, reason: collision with root package name */
        private String f31954c;

        /* renamed from: d, reason: collision with root package name */
        private String f31955d;

        /* renamed from: e, reason: collision with root package name */
        private String f31956e;

        /* renamed from: f, reason: collision with root package name */
        private Long f31957f;

        public PackagePriorityInfo(String str, String str2, String str3, String str4, String str5, long j10) {
            this.f31952a = str;
            this.f31953b = str2;
            this.f31954c = str3;
            this.f31955d = str4;
            this.f31956e = str5;
            this.f31957f = Long.valueOf(j10);
        }

        @Override // java.lang.Comparable
        public int compareTo(PackagePriorityInfo packagePriorityInfo) {
            if (TextUtils.equals(this.f31956e, packagePriorityInfo.f31956e)) {
                return this.f31957f.compareTo(packagePriorityInfo.f31957f);
            }
            return this.f31956e.compareTo(packagePriorityInfo.f31956e);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Comparator<ResolveInfo> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ResolveInfo resolveInfo, ResolveInfo resolveInfo2) {
            String str = resolveInfo.serviceInfo.applicationInfo.packageName;
            String str2 = resolveInfo2.serviceInfo.applicationInfo.packageName;
            if (!HMSPackageManager.f31937s.containsKey(str) || !HMSPackageManager.f31937s.containsKey(str2)) {
                if (HMSPackageManager.f31937s.containsKey(str)) {
                    return -1;
                }
                return HMSPackageManager.f31937s.containsKey(str2) ? 1 : 0;
            }
            return str.compareTo(str2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.i("HMSPackageManager", "enter asyncOnceCheckMDMState");
            try {
                List<ResolveInfo> queryIntentServices = HMSPackageManager.this.f31938a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
                if (queryIntentServices == null || queryIntentServices.size() == 0) {
                    return;
                }
                Iterator<ResolveInfo> iterator2 = queryIntentServices.iterator2();
                while (iterator2.hasNext()) {
                    if ("com.huawei.hwid".equals(iterator2.next().serviceInfo.applicationInfo.packageName)) {
                        HMSPackageManager.this.d();
                    }
                }
                HMSLog.i("HMSPackageManager", "quit asyncOnceCheckMDMState");
            } catch (Exception e2) {
                HMSLog.e("HMSPackageManager", "asyncOnceCheckMDMState query hms action failed. " + e2.getMessage());
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f31937s = hashMap;
        hashMap.put("com.huawei.hwid", "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05");
        hashMap.put("com.huawei.hwid.tv", "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C");
    }

    private HMSPackageManager(Context context) {
        this.f31938a = context;
        this.f31939b = new PackageManagerHelper(context);
    }

    private boolean c(String str, String str2) {
        return Objects.equals(str2, this.f31939b.getPackageSigningCertificate(str)) || Objects.equals(str2, this.f31939b.getPackageSignature(str));
    }

    private Pair<String, String> d(String str, String str2) {
        if (!f31937s.containsKey(str) || !PackageConstants.SERVICES_SIGNATURE_V3.equalsIgnoreCase(str2)) {
            return null;
        }
        this.f31951n = 3;
        return new Pair<>(str, str2);
    }

    private void e(String str) {
        if (SystemUtils.isHuawei() || SystemUtils.isSystemApp(this.f31938a, str) || Build.VERSION.SDK_INT < 28 || b(str)) {
            AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
        }
    }

    private void f() {
        synchronized (f31935q) {
            this.f31940c = null;
            this.f31941d = null;
            this.f31942e = 0;
        }
    }

    private Pair<String, String> g() {
        try {
            List<ResolveInfo> queryIntentServices = this.f31938a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
            if (queryIntentServices != null && queryIntentServices.size() != 0) {
                a(queryIntentServices);
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                    String packageSigningCertificate = this.f31939b.getPackageSigningCertificate(str);
                    String packageSignature = this.f31939b.getPackageSignature(str);
                    Pair<String, String> d10 = d(str, packageSigningCertificate);
                    if (d10 != null) {
                        HMSLog.i("HMSPackageManager", "signature V3 check success");
                        return d10;
                    }
                    Pair<String, String> a10 = a(resolveInfo.serviceInfo.metaData, str, packageSigningCertificate, packageSignature);
                    if (a10 != null) {
                        HMSLog.i("HMSPackageManager", "DSS signature check success");
                        return a10;
                    }
                    Pair<String, String> a11 = a(str, packageSignature);
                    if (a11 != null) {
                        HMSLog.i("HMSPackageManager", "signature V2 check success");
                        return a11;
                    }
                }
                return null;
            }
            HMSLog.e("HMSPackageManager", "query hms action, resolveInfoList is null or empty.");
            return null;
        } catch (Exception e2) {
            HMSLog.e("HMSPackageManager", "getHmsPackageName query hms action failed. " + e2.getMessage());
            return null;
        }
    }

    public static HMSPackageManager getInstance(Context context) {
        synchronized (f31934p) {
            if (f31933o == null && context != null) {
                if (context.getApplicationContext() != null) {
                    f31933o = new HMSPackageManager(context.getApplicationContext());
                } else {
                    f31933o = new HMSPackageManager(context);
                }
                f31933o.k();
                f31933o.b();
            }
        }
        return f31933o;
    }

    private Pair<String, String> h() {
        Pair<String, String> g3 = g();
        if (g3 != null) {
            HMSLog.i("HMSPackageManager", "aidlService pkgName: " + ((String) g3.first));
            this.f31945h = "com.huawei.hms.core.aidlservice";
            this.f31946i = null;
            return g3;
        }
        ArrayList<PackagePriorityInfo> i10 = i();
        if (i10 == null) {
            HMSLog.e("HMSPackageManager", "PackagePriorityInfo list is null");
            return null;
        }
        Iterator<PackagePriorityInfo> iterator2 = i10.iterator2();
        while (iterator2.hasNext()) {
            PackagePriorityInfo next = iterator2.next();
            String str = next.f31952a;
            String str2 = next.f31953b;
            String str3 = next.f31954c;
            String str4 = next.f31955d;
            String packageSignature = this.f31939b.getPackageSignature(str);
            if (a(str + "&" + packageSignature + "&" + str2, str3, str4)) {
                HMSLog.i("HMSPackageManager", "result: " + str + ", " + str2 + ", " + ((Object) next.f31957f));
                this.f31945h = PackageConstants.GENERAL_SERVICES_ACTION;
                d(str2);
                return new Pair<>(str, packageSignature);
            }
        }
        return null;
    }

    private ArrayList<PackagePriorityInfo> i() {
        try {
            List<ResolveInfo> queryIntentServices = this.f31938a.getPackageManager().queryIntentServices(new Intent(PackageConstants.GENERAL_SERVICES_ACTION), 128);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                ArrayList<PackagePriorityInfo> arrayList = new ArrayList<>();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                    long packageFirstInstallTime = this.f31939b.getPackageFirstInstallTime(str);
                    Bundle bundle = resolveInfo.serviceInfo.metaData;
                    if (bundle == null) {
                        HMSLog.e("HMSPackageManager", "package " + str + " get metaData is null");
                    } else {
                        String a10 = a(bundle, "hms_app_checker_config");
                        String a11 = a(a10);
                        if (TextUtils.isEmpty(a11)) {
                            HMSLog.i("HMSPackageManager", "get priority fail. hmsCheckerCfg: " + a10);
                        } else {
                            String a12 = a(bundle, "hms_app_signer_v2");
                            if (TextUtils.isEmpty(a12)) {
                                HMSLog.i("HMSPackageManager", "get signerV2 fail.");
                            } else {
                                String a13 = a(bundle, "hms_app_cert_chain");
                                if (TextUtils.isEmpty(a13)) {
                                    HMSLog.i("HMSPackageManager", "get certChain fail.");
                                } else {
                                    HMSLog.i("HMSPackageManager", "add: " + str + ", " + a10 + ", " + packageFirstInstallTime);
                                    arrayList.add(new PackagePriorityInfo(str, a10, a12, a13, a11, packageFirstInstallTime));
                                }
                            }
                        }
                    }
                }
                Collections.sort(arrayList);
                return arrayList;
            }
            HMSLog.e("HMSPackageManager", "query aglite action, resolveInfoList is null or empty");
            return null;
        } catch (Exception e2) {
            HMSLog.e("HMSPackageManager", "query aglite action failed. " + e2.getMessage());
            return null;
        }
    }

    private void j() {
        synchronized (f31935q) {
            Pair<String, String> g3 = g();
            if (g3 == null) {
                HMSLog.e("HMSPackageManager", "<initHmsPackageInfo> Failed to find HMS apk");
                f();
                return;
            }
            String str = (String) g3.first;
            this.f31940c = str;
            this.f31941d = (String) g3.second;
            this.f31942e = this.f31939b.getPackageVersionCode(str);
            HMSLog.i("HMSPackageManager", "<initHmsPackageInfo> Succeed to find HMS apk: " + this.f31940c + " version: " + this.f31942e);
        }
    }

    private void k() {
        synchronized (f31935q) {
            Pair<String, String> h10 = h();
            if (h10 == null) {
                HMSLog.e("HMSPackageManager", "<initHmsPackageInfoForMultiService> Failed to find HMS apk");
                e();
                AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
                return;
            }
            this.f31943f = (String) h10.first;
            this.f31944g = (String) h10.second;
            this.f31947j = this.f31939b.getPackageVersionCode(getHMSPackageNameForMultiService());
            e(this.f31943f);
            HMSLog.i("HMSPackageManager", "<initHmsPackageInfoForMultiService> Succeed to find HMS apk: " + this.f31943f + " version: " + this.f31947j);
        }
    }

    private boolean l() {
        Bundle bundle;
        PackageManager packageManager = this.f31938a.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
            return true;
        }
        try {
        } catch (AndroidException unused) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
        } catch (RuntimeException e2) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.", e2);
        }
        if (!TextUtils.isEmpty(this.f31945h) && (this.f31945h.equals(PackageConstants.GENERAL_SERVICES_ACTION) || this.f31945h.equals(PackageConstants.INTERNAL_SERVICES_ACTION))) {
            HMSLog.i("HMSPackageManager", "action = " + this.f31945h + " exist");
            return false;
        }
        ApplicationInfo applicationInfo = packageManager.getPackageInfo(getHMSPackageName(), 128).applicationInfo;
        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("com.huawei.hms.kit.api_level:hmscore") && (getHmsVersionCode() >= 50000000 || getHmsVersionCode() <= 19999999)) {
            HMSLog.i("HMSPackageManager", "MinApkVersion is disabled.");
            return false;
        }
        return true;
    }

    public String getHMSFingerprint() {
        String str = this.f31941d;
        return str == null ? "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05" : str;
    }

    public String getHMSPackageName() {
        HMSLog.i("HMSPackageManager", "Enter getHMSPackageName");
        refresh();
        String str = this.f31940c;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f31939b.getPackageStates(str))) {
                HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                j();
            }
            String str2 = this.f31940c;
            if (str2 != null) {
                return str2;
            }
        }
        HMSLog.i("HMSPackageManager", "return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public String getHMSPackageNameForMultiService() {
        HMSLog.i("HMSPackageManager", "Enter getHMSPackageNameForMultiService");
        refreshForMultiService();
        String str = this.f31943f;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f31939b.getPackageStates(str))) {
                HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                k();
            }
            String str2 = this.f31943f;
            if (str2 != null) {
                return str2;
            }
        }
        HMSLog.i("HMSPackageManager", "return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public PackageManagerHelper.PackageStates getHMSPackageStates() {
        synchronized (f31934p) {
            refresh();
            PackageManagerHelper.PackageStates packageStates = this.f31939b.getPackageStates(this.f31940c);
            PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
            if (packageStates == packageStates2) {
                f();
                return packageStates2;
            }
            boolean z10 = false;
            if ("com.huawei.hwid".equals(this.f31940c) && d() == 1) {
                return PackageManagerHelper.PackageStates.SPOOF;
            }
            if (packageStates == PackageManagerHelper.PackageStates.ENABLED && !c(this.f31940c, this.f31941d)) {
                z10 = true;
            }
            return z10 ? packageStates2 : packageStates;
        }
    }

    public PackageManagerHelper.PackageStates getHMSPackageStatesForMultiService() {
        synchronized (f31934p) {
            refreshForMultiService();
            PackageManagerHelper.PackageStates packageStates = this.f31939b.getPackageStates(this.f31943f);
            PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
            if (packageStates == packageStates2) {
                e();
                return packageStates2;
            }
            boolean z10 = false;
            if ("com.huawei.hwid".equals(this.f31943f) && d() == 1) {
                return PackageManagerHelper.PackageStates.SPOOF;
            }
            if (packageStates == PackageManagerHelper.PackageStates.ENABLED && !c(this.f31943f, this.f31944g)) {
                z10 = true;
            }
            return z10 ? packageStates2 : packageStates;
        }
    }

    public int getHmsMultiServiceVersion() {
        return this.f31939b.getPackageVersionCode(getHMSPackageNameForMultiService());
    }

    public int getHmsVersionCode() {
        return this.f31939b.getPackageVersionCode(getHMSPackageName());
    }

    public String getInnerServiceAction() {
        return PackageConstants.INTERNAL_SERVICES_ACTION;
    }

    public String getServiceAction() {
        return !TextUtils.isEmpty(this.f31945h) ? this.f31945h : "com.huawei.hms.core.aidlservice";
    }

    public boolean hmsVerHigherThan(int i10) {
        if (this.f31942e >= i10 || !l()) {
            return true;
        }
        int packageVersionCode = this.f31939b.getPackageVersionCode(getHMSPackageName());
        this.f31942e = packageVersionCode;
        return packageVersionCode >= i10;
    }

    public boolean isApkNeedUpdate(int i10) {
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", target version requirements: " + i10);
        return hmsVersionCode < i10;
    }

    public boolean isApkUpdateNecessary(int i10) {
        if (isUpdateHmsForThirdPartyDevice()) {
            return true;
        }
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", minimum version requirements: " + i10);
        return l() && hmsVersionCode < i10;
    }

    public boolean isUpdateHmsForThirdPartyDevice() {
        return "com.huawei.hwid".equals(this.f31943f) && AgHmsUpdateState.getInstance().isUpdateHms();
    }

    public boolean isUseOldCertificate() {
        return this.f31950m;
    }

    public void refresh() {
        if (TextUtils.isEmpty(this.f31940c) || TextUtils.isEmpty(this.f31941d)) {
            j();
        }
        c(this.f31940c);
    }

    public void refreshForMultiService() {
        if (TextUtils.isEmpty(this.f31943f) || TextUtils.isEmpty(this.f31944g)) {
            k();
        }
        c(this.f31943f);
    }

    public void resetMultiServiceState() {
        e();
    }

    public void setUseOldCertificate(boolean z10) {
        this.f31950m = z10;
    }

    private boolean b(String str) {
        return !"com.huawei.hwid".equals(str) || this.f31951n == 3;
    }

    private void a(List<ResolveInfo> list) {
        if (list.size() <= 1) {
            return;
        }
        Collections.sort(list, new a());
    }

    private boolean b(String str, String str2) {
        Map<String, String> map = f31937s;
        return map.containsKey(str) && map.get(str).equalsIgnoreCase(str2);
    }

    private void c(String str) {
        if ("com.huawei.hwid".equals(str) && AgHmsUpdateState.getInstance().isUpdateHms() && this.f31939b.getPackageVersionCode(str) >= AgHmsUpdateState.getInstance().getTargetVersionCode()) {
            AgHmsUpdateState.getInstance().resetUpdateState();
            HMSLog.i("HMSPackageManager", "refresh update state for HMS V3");
        }
    }

    private Pair<String, String> a(Bundle bundle, String str, String str2, String str3) {
        String str4;
        if (bundle == null) {
            HMSLog.e("HMSPackageManager", "DSS check: " + str + " for metadata is null");
            return null;
        }
        this.f31951n = 2;
        if (a(bundle, str, str2)) {
            HMSLog.i("HMSPackageManager", "support DSS V3 check");
            str3 = str2;
            str4 = "hms_app_signer_v3";
        } else {
            str4 = "hms_app_signer";
        }
        if (!bundle.containsKey(str4)) {
            HMSLog.e("HMSPackageManager", "skip package " + str + " for no " + str4);
            return null;
        }
        if (!bundle.containsKey("hms_app_cert_chain")) {
            HMSLog.e("HMSPackageManager", "skip package " + str + " for no cert chain");
            return null;
        }
        if (!a(str + "&" + str3, bundle.getString(str4), bundle.getString("hms_app_cert_chain"))) {
            HMSLog.e("HMSPackageManager", "checkSigner failed");
            return null;
        }
        if (str4.equals("hms_app_signer_v3")) {
            this.f31951n = 3;
        }
        return new Pair<>(str, str3);
    }

    private void b() {
        new Thread(new b(), "Thread-asyncOnceCheckMDMState").start();
    }

    private void d(String str) {
        String a10 = a(str);
        if (TextUtils.isEmpty(a10)) {
            return;
        }
        this.f31946i = a10.substring(9);
    }

    private void e() {
        synchronized (f31935q) {
            this.f31943f = null;
            this.f31944g = null;
            this.f31945h = null;
            this.f31946i = null;
            this.f31947j = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0024 A[Catch: all -> 0x0077, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0018, B:11:0x0024, B:12:0x0042, B:15:0x0044, B:18:0x004b, B:19:0x0073), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044 A[Catch: all -> 0x0077, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0018, B:11:0x0024, B:12:0x0042, B:15:0x0044, B:18:0x004b, B:19:0x0073), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int d() {
        /*
            r7 = this;
            java.lang.Object r0 = com.huawei.hms.utils.HMSPackageManager.f31936r
            monitor-enter(r0)
            java.lang.String r1 = "HMSPackageManager"
            java.lang.String r2 = "enter checkHmsIsSpoof"
            com.huawei.hms.support.log.HMSLog.i(r1, r2)     // Catch: java.lang.Throwable -> L77
            com.huawei.hms.utils.PackageManagerHelper r1 = r7.f31939b     // Catch: java.lang.Throwable -> L77
            java.lang.String r2 = "com.huawei.hwid"
            long r1 = r1.getPackageFirstInstallTime(r2)     // Catch: java.lang.Throwable -> L77
            int r3 = r7.f31948k     // Catch: java.lang.Throwable -> L77
            r4 = 3
            r5 = 1
            if (r3 == r4) goto L21
            long r3 = r7.f31949l     // Catch: java.lang.Throwable -> L77
            int r6 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r6 == 0) goto L1f
            goto L21
        L1f:
            r1 = 0
            goto L22
        L21:
            r1 = 1
        L22:
            if (r1 != 0) goto L44
            java.lang.String r1 = "HMSPackageManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r2.<init>()     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = "quit checkHmsIsSpoof cached state: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L77
            int r3 = r7.f31948k     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = a(r3)     // Catch: java.lang.Throwable -> L77
            r2.append(r3)     // Catch: java.lang.Throwable -> L77
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L77
            com.huawei.hms.support.log.HMSLog.i(r1, r2)     // Catch: java.lang.Throwable -> L77
            int r1 = r7.f31948k     // Catch: java.lang.Throwable -> L77
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L77
            return r1
        L44:
            boolean r1 = r7.c()     // Catch: java.lang.Throwable -> L77
            if (r1 == 0) goto L4b
            r5 = 2
        L4b:
            r7.f31948k = r5     // Catch: java.lang.Throwable -> L77
            com.huawei.hms.utils.PackageManagerHelper r1 = r7.f31939b     // Catch: java.lang.Throwable -> L77
            java.lang.String r2 = "com.huawei.hwid"
            long r1 = r1.getPackageFirstInstallTime(r2)     // Catch: java.lang.Throwable -> L77
            r7.f31949l = r1     // Catch: java.lang.Throwable -> L77
            java.lang.String r1 = "HMSPackageManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r2.<init>()     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = "quit checkHmsIsSpoof state: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L77
            int r3 = r7.f31948k     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = a(r3)     // Catch: java.lang.Throwable -> L77
            r2.append(r3)     // Catch: java.lang.Throwable -> L77
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L77
            com.huawei.hms.support.log.HMSLog.i(r1, r2)     // Catch: java.lang.Throwable -> L77
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L77
            int r0 = r7.f31948k
            return r0
        L77:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L77
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.utils.HMSPackageManager.d():int");
    }

    private boolean c() {
        String hmsPath = ReadApkFileUtil.getHmsPath(this.f31938a);
        if (hmsPath == null) {
            HMSLog.i("HMSPackageManager", "hmsPath is null!");
            return false;
        }
        if (!ReadApkFileUtil.isCertFound(hmsPath)) {
            HMSLog.i("HMSPackageManager", "NO huawer.cer in HMS!");
            return false;
        }
        if (!ReadApkFileUtil.checkSignature()) {
            HMSLog.i("HMSPackageManager", "checkSignature fail!");
            return false;
        }
        if (ReadApkFileUtil.verifyApkHash(hmsPath)) {
            return true;
        }
        HMSLog.i("HMSPackageManager", "verifyApkHash fail!");
        return false;
    }

    private Pair<String, String> a(String str, String str2) {
        if (b(str, str2)) {
            return new Pair<>(str, str2);
        }
        HMSLog.w("HMSPackageManager", "check sign fail: " + str + "_" + str2);
        return null;
    }

    private boolean a(Bundle bundle, String str, String str2) {
        return bundle.containsKey("hms_app_signer_v3") && !b(str, str2) && Build.VERSION.SDK_INT >= 28;
    }

    private String a(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            HMSLog.e("HMSPackageManager", "no " + str + " in metaData");
            return null;
        }
        return bundle.getString(str);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("priority=");
        if (indexOf == -1) {
            HMSLog.e("HMSPackageManager", "get indexOfIdentifier -1");
            return null;
        }
        int indexOf2 = str.indexOf(",", indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        return str.substring(indexOf, indexOf2);
    }

    private boolean a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            List<X509Certificate> b4 = com.huawei.hms.device.a.b(str3);
            if (b4.size() == 0) {
                HMSLog.e("HMSPackageManager", "certChain is empty");
                return false;
            }
            if (!com.huawei.hms.device.a.a(com.huawei.hms.device.a.a(this.f31938a), b4)) {
                HMSLog.e("HMSPackageManager", "failed to verify cert chain");
                return false;
            }
            X509Certificate x509Certificate = b4.get(b4.size() - 1);
            if (!com.huawei.hms.device.a.a(x509Certificate, "Huawei CBG HMS")) {
                HMSLog.e("HMSPackageManager", "CN is invalid");
                return false;
            }
            if (!com.huawei.hms.device.a.b(x509Certificate, "Huawei CBG Cloud Security Signer")) {
                HMSLog.e("HMSPackageManager", "OU is invalid");
                return false;
            }
            if (com.huawei.hms.device.a.a(x509Certificate, str, str2)) {
                return true;
            }
            HMSLog.e("HMSPackageManager", "signature is invalid: " + str);
            return false;
        }
        HMSLog.e("HMSPackageManager", "args is invalid");
        return false;
    }

    private static String a(int i10) {
        if (i10 == 1) {
            return "SPOOFED";
        }
        if (i10 == 2) {
            return MonitorResult.SUCCESS;
        }
        if (i10 == 3) {
            return "UNCHECKED";
        }
        HMSLog.e("HMSPackageManager", "invalid checkMDM state: " + i10);
        return "";
    }
}
