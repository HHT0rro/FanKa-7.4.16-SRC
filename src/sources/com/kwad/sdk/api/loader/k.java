package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class k {
    private final String amA;
    private final String amB;
    private final String amC;
    private Resources amD;
    private ClassLoader amE;
    private IKsAdSDK amF;

    private k(String str, String str2, String str3) {
        this.amA = str;
        this.amB = str2;
        this.amC = str3;
    }

    private void Ag() {
        if (!TextUtils.isEmpty(this.amA)) {
            File file = new File(this.amA);
            if (!file.isFile() || !file.exists()) {
                throw new RuntimeException("mApk not a file");
            }
            return;
        }
        throw new RuntimeException("mApk is null");
    }

    public static synchronized k a(Context context, ClassLoader classLoader, String str) {
        k b4;
        synchronized (k.class) {
            try {
                b4 = b(context, classLoader, h.s(context, str), h.t(context, str), h.u(context, str));
            } catch (Throwable th) {
                com.kwad.sdk.api.c.m(th);
                return null;
            }
        }
        return b4;
    }

    public static k b(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                k kVar = new k(str, str2, str3);
                kVar.a(context, classLoader);
                return kVar;
            }
            throw new RuntimeException("mApk not a file");
        }
        throw new RuntimeException("mApk is null");
    }

    public final Resources Ae() {
        return this.amD;
    }

    public final IKsAdSDK Af() {
        return this.amF;
    }

    public final ClassLoader getClassLoader() {
        return this.amE;
    }

    public final String toString() {
        return "ExternalPackage{mApk='" + this.amA + "', mDexDir='" + this.amB + "', mNativeLibDir='" + this.amC + "', mResource=" + ((Object) this.amD) + ", mClassLoader=" + ((Object) this.amE) + ", mKsSdk=" + ((Object) this.amF) + '}';
    }

    private void a(Context context, ClassLoader classLoader) {
        Ag();
        Resources a10 = q.a(context, context.getResources(), this.amA);
        ClassLoader a11 = e.a(context, classLoader, this.amA, this.amB, this.amC);
        IKsAdSDK a12 = Loader.a(a11);
        this.amD = a10;
        this.amE = a11;
        this.amF = a12;
        int sDKType = a12.getSDKType();
        if (sDKType == 1) {
            return;
        }
        throw new RuntimeException("sdkType error apiType: 1 , sdkType:" + sDKType);
    }
}
