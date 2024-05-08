package com.huawei.openalliance.ad.inter.data;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.InstallConfig;
import com.huawei.openalliance.ad.beans.metadata.Permission;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.au;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AppInfo implements Serializable {
    private static final String TAG = "AppInfo";
    private static final long serialVersionUID = 30414300;
    private String actName;
    private String afDlBtnText;
    private long allAreaPopDelay;
    private String appDesc;
    private String appName;
    private int appType;
    private List<Integer> btnClickActionList;
    private boolean checkSha256;
    private String contiBtn;
    private String curInstallWay;
    private String dlBtnText;
    private String downloadUrl;
    private long fileSize;
    private Integer hasPermissions;
    private String iconUrl;
    private InstallConfig installConfig;
    private String installPermiText;
    private String installPureModeText;
    private String intent;
    private String intentPackage;
    private String intentUri;
    private String nextInstallWays;
    private String packageName;
    private boolean permPromptForCard;
    private boolean permPromptForLanding;
    private List<PermissionEntity> permissions;
    private int popNotify;
    private String popUpAfterInstallText;
    private int popUpStyle;
    private String priorInstallWay;
    private String pureModeText;
    private String realPkgName;
    private String reservedPkgName;
    private String safeDownloadUrl;
    private String sha256;
    private int trafficReminder;
    private String uniqueId;
    private String versionCode;

    /* renamed from: com.huawei.openalliance.ad.inter.data.AppInfo$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[com.huawei.openalliance.ad.download.app.k.values().length];
            Code = iArr;
            try {
                iArr[com.huawei.openalliance.ad.download.app.k.INSTALLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public AppInfo() {
        this.permPromptForCard = true;
        this.permPromptForLanding = false;
        this.appType = 1;
    }

    public AppInfo(ApkInfo apkInfo) {
        this.permPromptForCard = true;
        this.permPromptForLanding = false;
        this.appType = 1;
        if (apkInfo != null) {
            this.appName = au.V(apkInfo.S());
            this.iconUrl = apkInfo.f();
            this.packageName = apkInfo.Code();
            this.versionCode = apkInfo.V();
            this.downloadUrl = apkInfo.I();
            this.fileSize = apkInfo.Z();
            this.sha256 = apkInfo.B();
            this.checkSha256 = apkInfo.r() == 0;
            this.safeDownloadUrl = apkInfo.C();
            this.permPromptForCard = "1".equals(apkInfo.a());
            this.permPromptForLanding = "1".equals(apkInfo.b());
            this.dlBtnText = au.V(apkInfo.m());
            this.afDlBtnText = au.V(apkInfo.n());
            this.popNotify = apkInfo.o();
            this.popUpAfterInstallText = apkInfo.d();
            Code(apkInfo.F());
            this.iconUrl = apkInfo.f();
            this.appDesc = au.V(apkInfo.h());
            this.trafficReminder = apkInfo.j();
            String D = apkInfo.D();
            if (!TextUtils.isEmpty(D)) {
                this.priorInstallWay = D;
            }
            this.installConfig = apkInfo.L();
            this.curInstallWay = this.priorInstallWay;
            this.intent = apkInfo.k();
            this.intentPackage = apkInfo.l();
            this.hasPermissions = apkInfo.p();
            this.nextInstallWays = apkInfo.q();
            this.actName = apkInfo.s();
            this.btnClickActionList = apkInfo.t();
            this.appType = apkInfo.u();
            this.allAreaPopDelay = apkInfo.v();
            this.popUpStyle = apkInfo.w();
            this.installPermiText = apkInfo.x();
            this.pureModeText = apkInfo.y();
            this.installPureModeText = apkInfo.y();
            this.contiBtn = apkInfo.A();
            this.reservedPkgName = apkInfo.E();
            this.realPkgName = apkInfo.G();
        }
    }

    public static long w() {
        return serialVersionUID;
    }

    public String A() {
        return this.installPureModeText;
    }

    @com.huawei.openalliance.ad.annotations.b
    public long B() {
        return this.fileSize;
    }

    public void B(String str) {
        this.intentPackage = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String C() {
        return this.sha256;
    }

    public void C(String str) {
        this.dlBtnText = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String Code() {
        return this.packageName;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String Code(com.huawei.openalliance.ad.download.app.k kVar) {
        int i10 = AnonymousClass1.Code[kVar.ordinal()];
        if (i10 == 1) {
            return this.afDlBtnText;
        }
        if (i10 != 2) {
            return null;
        }
        return this.dlBtnText;
    }

    public void Code(int i10) {
        this.popNotify = i10;
    }

    public void Code(long j10) {
        this.allAreaPopDelay = j10;
    }

    public void Code(String str) {
        this.intentUri = str;
    }

    public void Code(List<Permission> list) {
        StringBuilder sb2;
        String sb3;
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            ArrayMap arrayMap = new ArrayMap();
            for (Permission permission : list) {
                List list2 = (List) arrayMap.get(permission.V());
                if (list2 == null) {
                    list2 = new ArrayList();
                    arrayMap.put(permission.V(), list2);
                }
                list2.add(new PermissionEntity(au.V(permission.Code()), 1));
            }
            this.permissions = new ArrayList();
            for (Map.Entry entry : arrayMap.entrySet()) {
                this.permissions.add(new PermissionEntity(au.V((String) entry.getKey()), 0));
                this.permissions.addAll((Collection) entry.getValue());
            }
        } catch (RuntimeException e2) {
            sb3 = "parsePermission RuntimeException:" + e2.getClass().getSimpleName();
            gl.Z(TAG, sb3);
        } catch (Exception e10) {
            e = e10;
            sb2 = new StringBuilder();
            sb2.append("parsePermission Exception:");
            sb2.append(e.getClass().getSimpleName());
            sb3 = sb2.toString();
            gl.Z(TAG, sb3);
        } catch (Throwable th) {
            e = th;
            sb2 = new StringBuilder();
            sb2.append("parsePermission Exception:");
            sb2.append(e.getClass().getSimpleName());
            sb3 = sb2.toString();
            gl.Z(TAG, sb3);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public String D() {
        return this.intentUri;
    }

    public void D(String str) {
        this.packageName = str;
    }

    public String E() {
        return this.contiBtn;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String F() {
        return this.safeDownloadUrl;
    }

    public void F(String str) {
        this.popUpAfterInstallText = str;
    }

    public String G() {
        return this.reservedPkgName;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String H() {
        return this.realPkgName;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String I() {
        return this.iconUrl;
    }

    public void I(int i10) {
        this.popUpStyle = i10;
    }

    public void I(String str) {
        this.priorInstallWay = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String L() {
        String str = this.appName;
        return str == null ? "" : str;
    }

    public void L(String str) {
        this.nextInstallWays = str;
    }

    public void S(String str) {
        this.afDlBtnText = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public boolean S() {
        return this.checkSha256;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String V() {
        return this.versionCode;
    }

    public void V(int i10) {
        this.appType = i10;
    }

    public void V(String str) {
        this.uniqueId = str;
    }

    public void V(List<Integer> list) {
        this.btnClickActionList = list;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String Z() {
        return this.downloadUrl;
    }

    public void Z(String str) {
        this.intent = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String a() {
        String str = this.appDesc;
        return str == null ? "" : str;
    }

    public void a(String str) {
        this.curInstallWay = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public List<PermissionEntity> b() {
        return this.permissions;
    }

    public void b(String str) {
        this.actName = str;
    }

    public void c(String str) {
        this.installPermiText = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public boolean c() {
        return this.permPromptForCard;
    }

    public void d(String str) {
        this.pureModeText = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public boolean d() {
        return this.permPromptForLanding;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String e() {
        return this.uniqueId;
    }

    public void e(String str) {
        this.installPureModeText = str;
    }

    public int f() {
        return this.trafficReminder;
    }

    public void f(String str) {
        this.contiBtn = str;
    }

    public String g() {
        return TextUtils.isEmpty(this.priorInstallWay) ? "4" : this.priorInstallWay;
    }

    public void g(String str) {
        this.reservedPkgName = str;
    }

    public String h() {
        return this.intent;
    }

    public void h(String str) {
        this.realPkgName = str;
    }

    public String i() {
        return this.intentPackage;
    }

    public String j() {
        return this.dlBtnText;
    }

    public String k() {
        return this.afDlBtnText;
    }

    public int l() {
        return this.popNotify;
    }

    public String m() {
        return this.popUpAfterInstallText;
    }

    public boolean n() {
        Integer num = this.hasPermissions;
        return num != null ? num.intValue() == 1 : !aa.Code(this.permissions);
    }

    public boolean o() {
        if (TextUtils.isEmpty(this.packageName)) {
            return false;
        }
        String r10 = r();
        if (TextUtils.isEmpty(r10)) {
            return false;
        }
        return r10.equals("8") || r10.equals("6") || r10.equals("5");
    }

    public String p() {
        return this.nextInstallWays;
    }

    public String q() {
        return this.curInstallWay;
    }

    public String r() {
        String q10 = q();
        return TextUtils.isEmpty(q10) ? g() : q10;
    }

    public String s() {
        return this.actName;
    }

    public List<Integer> t() {
        return this.btnClickActionList;
    }

    public int u() {
        return this.appType;
    }

    public long v() {
        return this.allAreaPopDelay;
    }

    public int x() {
        return this.popUpStyle;
    }

    public String y() {
        return this.installPermiText;
    }

    public String z() {
        return this.pureModeText;
    }
}
