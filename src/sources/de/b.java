package de;

import java.text.DecimalFormat;
import org.jetbrains.annotations.NotNull;

/* compiled from: DurationJvm.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f48698a = false;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final ThreadLocal<DecimalFormat>[] f48699b;

    static {
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i10 = 0; i10 < 4; i10++) {
            threadLocalArr[i10] = new ThreadLocal<>();
        }
        f48699b = threadLocalArr;
    }

    public static final boolean a() {
        return f48698a;
    }
}
