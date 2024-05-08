package com.bytedance.pangle.a;

import com.bytedance.pangle.d.e;
import java.util.concurrent.CountDownLatch;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final CountDownLatch f10619a;

    /* renamed from: b, reason: collision with root package name */
    public Throwable f10620b;

    /* renamed from: com.bytedance.pangle.a.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface InterfaceC0117a {
        void a();
    }

    private a(InterfaceC0117a[] interfaceC0117aArr) {
        this.f10619a = new CountDownLatch(interfaceC0117aArr.length);
        for (final InterfaceC0117a interfaceC0117a : interfaceC0117aArr) {
            e.a(new Runnable() { // from class: com.bytedance.pangle.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        interfaceC0117a.a();
                    } catch (Throwable th) {
                        a.this.f10620b = th;
                    }
                    a.this.f10619a.countDown();
                }
            });
        }
    }

    public static void a(InterfaceC0117a... interfaceC0117aArr) {
        a aVar = new a(interfaceC0117aArr);
        try {
            aVar.f10619a.await();
            Throwable th = aVar.f10620b;
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2);
        }
    }
}
