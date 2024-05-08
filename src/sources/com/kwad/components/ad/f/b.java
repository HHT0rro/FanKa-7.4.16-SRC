package com.kwad.components.ad.f;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.bq;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b {
    private com.kwad.sdk.core.g.d eg;

    /* renamed from: me, reason: collision with root package name */
    private CopyOnWriteArrayList<C0403b> f36425me = new CopyOnWriteArrayList<>();
    private int mf;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class a {
        private static final b mi = new b();
    }

    /* renamed from: com.kwad.components.ad.f.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class C0403b {
        private final c mj;
        private final WeakReference<View> mk;

        public C0403b(c cVar, View view) {
            this.mk = new WeakReference<>(view);
            this.mj = cVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface c {
        void f(double d10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void e(double d10) {
        CopyOnWriteArrayList<C0403b> copyOnWriteArrayList = this.f36425me;
        int Cl = (int) (com.kwad.sdk.core.config.d.Cl() * 100.0f);
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        int i10 = Integer.MAX_VALUE;
        Iterator<C0403b> iterator2 = copyOnWriteArrayList.iterator2();
        C0403b c0403b = null;
        C0403b c0403b2 = null;
        while (iterator2.hasNext()) {
            C0403b next = iterator2.next();
            WeakReference weakReference = next.mk;
            if (weakReference != null) {
                Rect rect = new Rect();
                if (((View) weakReference.get()).getGlobalVisibleRect(rect) && bq.o((View) weakReference.get(), Cl)) {
                    int i11 = this.mf / 2;
                    int min = Math.min(Math.abs(rect.top - i11), Math.abs(rect.bottom - i11));
                    if (min < i10) {
                        c0403b = next;
                        i10 = min;
                    } else if (min == i10) {
                        c0403b2 = next;
                    }
                }
            }
        }
        if (c0403b != null) {
            if (c0403b2 != null) {
                Rect rect2 = new Rect();
                ((View) c0403b.mk.get()).getGlobalVisibleRect(rect2);
                Rect rect3 = new Rect();
                ((View) c0403b2.mk.get()).getGlobalVisibleRect(rect2);
                if (rect2.top < rect3.top) {
                    c0403b = c0403b2;
                }
            }
            c0403b.mj.f(d10);
        }
    }

    public static b el() {
        return a.mi;
    }

    public final void a(float f10, View view, c cVar) {
        if (view == null || view.getContext() == null) {
            return;
        }
        if (this.eg == null) {
            this.mf = com.kwad.sdk.d.a.a.aI(view.getContext());
            a(f10, view.getContext());
        }
        this.f36425me.add(new C0403b(cVar, view));
    }

    public final void a(c cVar) {
        Iterator<C0403b> iterator2 = this.f36425me.iterator2();
        while (iterator2.hasNext()) {
            C0403b next = iterator2.next();
            if (next.mj == cVar) {
                this.f36425me.remove(next);
            }
        }
        com.kwad.sdk.core.e.c.d("KSNativeAdShakeManager", "sShakeItems size " + this.f36425me.size());
    }

    private void a(float f10, Context context) {
        this.eg = new com.kwad.sdk.core.g.d(f10);
        this.f36425me = new CopyOnWriteArrayList<>();
        this.eg.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.f.b.1
            @Override // com.kwad.sdk.core.g.b
            public final void a(double d10) {
                if (b.this.f36425me != null) {
                    b.this.e(d10);
                    bn.a(new ay() { // from class: com.kwad.components.ad.f.b.1.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            com.kwad.sdk.core.e.c.d("KSNativeAdShakeManager", "onShakeEvent openGate2");
                            b.this.eg.Fu();
                        }
                    }, null, 500L);
                }
            }

            @Override // com.kwad.sdk.core.g.b
            public final void aV() {
            }
        });
        this.eg.e(f10);
        this.eg.bi(context);
    }
}
