package com.tencent.youtu.liveness;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class YTCommonInterface {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f46001a = true;

    /* renamed from: b, reason: collision with root package name */
    private static String f46002b = "YTCommon";

    /* renamed from: c, reason: collision with root package name */
    private static int f46003c = 1;

    public static int a(String str, String str2) {
        if (!f46001a && str == null) {
            throw new AssertionError();
        }
        if (str2 == null) {
            str2 = "";
        }
        return nativeInitAuthByString(str, str2);
    }

    public static native long getEndTime();

    public static native int[] getSDKList();

    public static native String getSDKNameByID(int i10);

    public static native String getVersion();

    private static native int nativeGetDeviceInfo(YTDeviceInfo yTDeviceInfo);

    private static native int nativeInitAuthByAssets(String str, String str2);

    private static native int nativeInitAuthByString(String str, String str2);

    private static native int nativeInitAuthForQQ();

    private static native void nativePrintAuthResult(int i10);

    private static native void nativeSetEnableLog(int i10);
}
