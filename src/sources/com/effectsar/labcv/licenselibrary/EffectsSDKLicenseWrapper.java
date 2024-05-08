package com.effectsar.labcv.licenselibrary;

import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class EffectsSDKLicenseWrapper implements EffectsSDKLicenseInterface {
    public static boolean mLoadLib;
    private HttpRequestProvider _provider;
    private long mNativeWrapperPtr = 0;

    public EffectsSDKLicenseWrapper(HashMap<String, String> hashMap, HttpRequestProvider httpRequestProvider) {
        this._provider = null;
        if (!mLoadLib) {
            loadLib();
            mLoadLib = true;
        }
        this._provider = httpRequestProvider;
        nativeGetInstanceWithParam(hashMap);
    }

    public static void loadLib() throws UnsatisfiedLinkError {
        try {
            System.loadLibrary("effect");
            System.err.println("licenseWrapper_jni: library load!");
        } catch (UnsatisfiedLinkError e2) {
            System.err.println("WARNING: licenseWrapper_jni Could not load library in default path!");
            System.err.print(e2);
        }
    }

    private native void nativeClearParams();

    private native int nativeGetInstanceWithParam(HashMap<String, String> hashMap);

    private native int nativeGetLicenseWithParams(HashMap<String, String> hashMap, boolean z10, LicenseCallback licenseCallback);

    private native String nativeGetParam(String str);

    private native void nativeSetParam(String str, String str2);

    private native int nativeUpdateLicenseWithParams(HashMap<String, String> hashMap, boolean z10, LicenseCallback licenseCallback);

    @Override // com.effectsar.labcv.licenselibrary.EffectsSDKLicenseInterface
    public void clearParams() {
        nativeClearParams();
    }

    @Override // com.effectsar.labcv.licenselibrary.EffectsSDKLicenseInterface
    public int getLicenseWithParams(HashMap<String, String> hashMap, boolean z10, LicenseCallback licenseCallback) {
        return nativeGetLicenseWithParams(hashMap, z10, licenseCallback);
    }

    @Override // com.effectsar.labcv.licenselibrary.EffectsSDKLicenseInterface
    public String getParam(String str) {
        return nativeGetParam(str);
    }

    @Override // com.effectsar.labcv.licenselibrary.EffectsSDKLicenseInterface
    public void registerHttpProvider(HttpRequestProvider httpRequestProvider) {
        this._provider = httpRequestProvider;
    }

    @Override // com.effectsar.labcv.licenselibrary.EffectsSDKLicenseInterface
    public void setParam(String str, String str2) {
        nativeSetParam(str, str2);
    }

    @Override // com.effectsar.labcv.licenselibrary.EffectsSDKLicenseInterface
    public int updateLicenseWithParams(HashMap<String, String> hashMap, boolean z10, LicenseCallback licenseCallback) {
        return nativeUpdateLicenseWithParams(hashMap, z10, licenseCallback);
    }
}
