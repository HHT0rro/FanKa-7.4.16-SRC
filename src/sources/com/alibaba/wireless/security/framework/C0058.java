package com.alibaba.wireless.security.framework;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import com.alibaba.wireless.security.framework.utils.C0049;
import com.alibaba.wireless.security.framework.utils.C0052;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;

/* renamed from: com.alibaba.wireless.security.framework.в, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class C0058 implements ISGPluginInfo {

    /* renamed from: а, reason: contains not printable characters */
    private String f84;

    /* renamed from: б, reason: contains not printable characters */
    private String f85;

    /* renamed from: в, reason: contains not printable characters */
    private ClassLoader f86;

    /* renamed from: г, reason: contains not printable characters */
    private AssetManager f87;

    /* renamed from: д, reason: contains not printable characters */
    private C0056 f88;

    /* renamed from: е, reason: contains not printable characters */
    private ISecurityGuardPlugin f89;

    /* renamed from: ё, reason: contains not printable characters */
    private ISGPluginManager f90;

    public C0058(String str, ISGPluginManager iSGPluginManager, String str2, ClassLoader classLoader, C0056 c0056, ISecurityGuardPlugin iSecurityGuardPlugin) {
        this.f84 = str;
        this.f90 = iSGPluginManager;
        this.f85 = str2;
        this.f86 = classLoader;
        this.f88 = c0056;
        this.f89 = iSecurityGuardPlugin;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public AssetManager getAssetManager() {
        AssetManager assetManager = this.f87;
        if (assetManager != null) {
            return assetManager;
        }
        try {
            AssetManager assetManager2 = (AssetManager) AssetManager.class.newInstance();
            C0052.m1832(assetManager2).m1841("addAssetPath", this.f84);
            this.f87 = assetManager2;
            return assetManager2;
        } catch (Exception e2) {
            C0049.m1822("", e2);
            return null;
        }
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public ClassLoader getClassLoader() {
        return this.f86;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public PackageInfo getPackageInfo() {
        return this.f88.f71;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public String getPluginName() {
        return this.f85;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public String getPluginPath() {
        return this.f84;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public ISecurityGuardPlugin getSGPluginEntry() {
        return this.f89;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public ISGPluginManager getSGPluginManager() {
        return this.f90;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public String getVersion() {
        C0056 c0056 = this.f88;
        PackageInfo packageInfo = c0056.f71;
        return packageInfo != null ? packageInfo.versionName : c0056.m1853("version");
    }

    /* renamed from: а, reason: contains not printable characters */
    public String m1864(String str) {
        C0056 c0056 = this.f88;
        PackageInfo packageInfo = c0056.f71;
        return packageInfo != null ? packageInfo.applicationInfo.metaData.getString(str) : c0056.m1853(str);
    }
}
