package com.tencent.turingface.sdk.mfa;

import android.os.Build;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class CFgXs {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference<String> f45537a = new AtomicReference<>();

    public static String a() {
        AtomicReference<String> atomicReference = f45537a;
        String str = atomicReference.get();
        if (str == null) {
            synchronized (atomicReference) {
                str = atomicReference.get();
                if (str == null) {
                    str = Build.MODEL;
                    atomicReference.set(str);
                }
            }
        }
        return str;
    }
}
