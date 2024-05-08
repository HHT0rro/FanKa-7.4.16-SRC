package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.datatransport.Priority;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class x6 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f24705a;

    static {
        int[] iArr = new int[Priority.values().length];
        f24705a = iArr;
        try {
            iArr[Priority.HIGHEST.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f24705a[Priority.VERY_LOW.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f24705a[Priority.DEFAULT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
