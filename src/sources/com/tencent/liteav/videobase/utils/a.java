package com.tencent.liteav.videobase.utils;

import androidx.annotation.NonNull;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private long f43482a;

    /* renamed from: b, reason: collision with root package name */
    private long f43483b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC0641a f43484c;

    /* renamed from: d, reason: collision with root package name */
    private long f43485d;

    /* renamed from: e, reason: collision with root package name */
    private long f43486e = (int) Math.max(1000L, TimeUnit.SECONDS.toMillis(1));

    /* renamed from: f, reason: collision with root package name */
    private String f43487f;

    /* renamed from: com.tencent.liteav.videobase.utils.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0641a {
    }

    public a(String str, @NonNull InterfaceC0641a interfaceC0641a) {
        this.f43487f = str;
        a();
        this.f43484c = interfaceC0641a;
    }

    public final void a() {
        this.f43482a = 0L;
        this.f43483b = 0L;
        this.f43485d = 0L;
    }
}
