package com.bef.effectsdk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ModelnamesAssigner {
    private ModelnamesAssigner() {
    }

    private static native int nativeSetAssignedModelNames(long j10, String[] strArr, String[] strArr2);

    private static native int nativeSetAssignedModelNamesWithPriority(long j10, String[] strArr, String[] strArr2, int[] iArr);

    public static int setAssignedModelNames(long j10, String[] strArr, String[] strArr2) {
        return nativeSetAssignedModelNames(j10, strArr, strArr2);
    }

    public static int setAssignedModelNamesWithPriority(long j10, String[] strArr, String[] strArr2, int[] iArr) {
        return nativeSetAssignedModelNamesWithPriority(j10, strArr, strArr2, iArr);
    }
}
