package com.tencent.cloud.huiyansdkface.facelight.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private AtomicInteger f40653a;

    /* renamed from: b, reason: collision with root package name */
    private final Runnable f40654b;

    /* renamed from: c, reason: collision with root package name */
    private List<a> f40655c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public boolean f40660a;
    }

    public d(int i10) {
        this(i10, null);
    }

    public d(int i10, Runnable runnable) {
        this.f40655c = new ArrayList();
        if (i10 <= 0) {
            throw new IllegalArgumentException("resourceCount <= 0");
        }
        this.f40653a = new AtomicInteger(i10);
        this.f40654b = runnable;
    }

    private void b() {
        for (a aVar : Collections.unmodifiableList(this.f40655c)) {
            synchronized (this) {
                if (!aVar.f40660a) {
                    aVar.f40660a = true;
                    aVar.run();
                }
            }
        }
    }

    public void a(Runnable runnable) {
        if (this.f40653a.decrementAndGet() == 0) {
            if (runnable != null) {
                runnable.run();
            }
            Runnable runnable2 = this.f40654b;
            if (runnable2 != null) {
                runnable2.run();
            }
            b();
        }
    }

    public boolean a() {
        return this.f40653a.get() <= 0;
    }
}
