package com.google.common.util.concurrent;

import java.util.concurrent.locks.LockSupport;

/* compiled from: OverflowAvoidingLockSupport.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class r {
    public static void a(Object obj, long j10) {
        LockSupport.parkNanos(obj, Math.min(j10, 2147483647999999999L));
    }
}
