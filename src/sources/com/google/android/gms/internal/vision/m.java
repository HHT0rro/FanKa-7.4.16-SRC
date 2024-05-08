package com.google.android.gms.internal.vision;

import android.content.Context;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class m<T> {

    /* renamed from: b, reason: collision with root package name */
    public static volatile q f25542b;

    /* renamed from: a, reason: collision with root package name */
    public static final Object f25541a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference<Collection<m<?>>> f25543c = new AtomicReference<>();

    /* renamed from: d, reason: collision with root package name */
    public static r f25544d = new r(n.f25561a);

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicInteger f25545e = new AtomicInteger();

    @Deprecated
    public static void a(final Context context) {
        synchronized (f25541a) {
            q qVar = f25542b;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (qVar == null || qVar.a() != context) {
                h.a();
                p.a();
                j.a();
                f25542b = new i(context, s0.a(new q0(context) { // from class: com.google.android.gms.internal.vision.o

                    /* renamed from: b, reason: collision with root package name */
                    public final Context f25569b;

                    {
                        this.f25569b = context;
                    }

                    @Override // com.google.android.gms.internal.vision.q0
                    public final Object zza() {
                        return m.c(this.f25569b);
                    }
                }));
                f25545e.incrementAndGet();
            }
        }
    }

    public static void b(Context context) {
        if (f25542b != null) {
            return;
        }
        synchronized (f25541a) {
            if (f25542b == null) {
                a(context);
            }
        }
    }

    public static final /* synthetic */ zzcy c(Context context) {
        new l();
        return l.b(context);
    }

    public static final /* synthetic */ boolean d() {
        return true;
    }
}
