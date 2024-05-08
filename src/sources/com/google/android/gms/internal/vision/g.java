package com.google.android.gms.internal.vision;

import android.os.Build;
import androidx.annotation.GuardedBy;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f25470a = !a();

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("DirectBootUtils.class")
    public static boolean f25471b = false;

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
