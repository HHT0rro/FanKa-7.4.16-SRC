package com.huawei.hms.ads.dynamicloader;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import com.huawei.hms.ads.uiengineloader.aa;
import com.huawei.hms.ads.uiengineloader.w;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e extends a {

    /* renamed from: c, reason: collision with root package name */
    private static final String f29155c = "DynamicContext";

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadLocal<ApplicationInfo> f29156d = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    public final PackageInfo f29157a;

    /* renamed from: b, reason: collision with root package name */
    public final String f29158b;

    /* renamed from: e, reason: collision with root package name */
    private final ClassLoader f29159e;

    /* renamed from: f, reason: collision with root package name */
    private final Resources f29160f;

    /* renamed from: g, reason: collision with root package name */
    private final Resources f29161g;

    public e(Context context, String str, int i10) {
        super(context);
        PackageInfo packageArchiveInfo = getBaseContext().getPackageManager().getPackageArchiveInfo(str, 128);
        this.f29157a = packageArchiveInfo;
        this.f29159e = ((w.a() && com.huawei.hms.ads.uiengineloader.i.a(context)) ? new com.huawei.hms.ads.uiengineloader.i() : new com.huawei.hms.ads.uiengineloader.j()).a(context, str, i10, packageArchiveInfo);
        this.f29161g = a(str);
        this.f29160f = context.getResources();
        this.f29158b = str;
        aa.b(f29155c, "Create dynamicContext success.");
    }

    private PackageInfo a() {
        return this.f29157a;
    }

    private Resources a(String str) {
        ApplicationInfo applicationInfo = this.f29157a.applicationInfo;
        applicationInfo.publicSourceDir = str;
        applicationInfo.sourceDir = str;
        try {
            return getBaseContext().getPackageManager().getResourcesForApplication(this.f29157a.applicationInfo);
        } catch (PackageManager.NameNotFoundException e2) {
            aa.c(f29155c, "NameNotFoundException:" + e2.getLocalizedMessage());
            return null;
        }
    }

    private String b() {
        return this.f29158b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return this;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        ThreadLocal<ApplicationInfo> threadLocal = f29156d;
        return threadLocal.get() != null ? threadLocal.get() : super.getApplicationInfo();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return this.f29159e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        PackageInfo packageInfo = this.f29157a;
        if (packageInfo != null) {
            String str = packageInfo.packageName;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return super.getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        Resources resources = this.f29161g;
        return resources == null ? this.f29160f : resources;
    }

    @Override // com.huawei.hms.ads.dynamicloader.a, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (Arrays.asList("connectivity", "location", "wifi", UserData.NAME).contains(str)) {
            return getBaseContext().getSystemService(str);
        }
        Arrays.asList("sensor").contains(str);
        return super.getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        super.getApplicationContext().registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        super.getApplicationContext().unregisterComponentCallbacks(componentCallbacks);
    }
}
