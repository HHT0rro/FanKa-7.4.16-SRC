package com.huawei.hms.update.ui;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class UpdateBean implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private boolean f31899a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f31900b;

    /* renamed from: c, reason: collision with root package name */
    private String f31901c;

    /* renamed from: d, reason: collision with root package name */
    private int f31902d;

    /* renamed from: e, reason: collision with root package name */
    private String f31903e;

    /* renamed from: f, reason: collision with root package name */
    private String f31904f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList f31905g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f31906h = true;

    private static <T> T a(T t2) {
        return t2;
    }

    public String getClientAppId() {
        return (String) a(this.f31903e);
    }

    public String getClientAppName() {
        return (String) a(this.f31904f);
    }

    public String getClientPackageName() {
        return (String) a(this.f31901c);
    }

    public int getClientVersionCode() {
        return ((Integer) a(Integer.valueOf(this.f31902d))).intValue();
    }

    public boolean getResolutionInstallHMS() {
        return this.f31900b;
    }

    public ArrayList getTypeList() {
        return (ArrayList) a(this.f31905g);
    }

    public boolean isHmsOrApkUpgrade() {
        return ((Boolean) a(Boolean.valueOf(this.f31899a))).booleanValue();
    }

    public boolean isNeedConfirm() {
        return ((Boolean) a(Boolean.valueOf(this.f31906h))).booleanValue();
    }

    public void setClientAppId(String str) {
        this.f31903e = str;
    }

    public void setClientAppName(String str) {
        this.f31904f = str;
    }

    public void setClientPackageName(String str) {
        this.f31901c = str;
    }

    public void setClientVersionCode(int i10) {
        this.f31902d = i10;
    }

    public void setHmsOrApkUpgrade(boolean z10) {
        this.f31899a = z10;
    }

    public void setNeedConfirm(boolean z10) {
        this.f31906h = z10;
    }

    public void setResolutionInstallHMS(boolean z10) {
        this.f31900b = z10;
    }

    public void setTypeList(ArrayList arrayList) {
        this.f31905g = arrayList;
    }
}
