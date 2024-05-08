package com.kwad.components.core.e.a;

import android.app.Activity;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class e {
    private final List<b> JK;
    private final Stack<AdTemplate> JL;
    private final AtomicBoolean JM;
    private final Set<String> JN;
    private final String TAG;

    /* renamed from: od, reason: collision with root package name */
    private final AtomicBoolean f36626od;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a {
        private static final e JR = new e(0);
    }

    public /* synthetic */ e(byte b4) {
        this();
    }

    private void an(final AdTemplate adTemplate) {
        if (!this.JM.get() && !this.f36626od.get()) {
            com.kwad.sdk.core.e.c.d("InstalledActivateManager", "showInstalledActivate");
            this.JM.set(true);
            bn.runOnUiThreadDelay(new ay() { // from class: com.kwad.components.core.e.a.e.1
                /* JADX INFO: Access modifiers changed from: private */
                public void nh() {
                    com.kwad.sdk.core.c.b.DD();
                    if (!com.kwad.sdk.core.c.b.isEnable()) {
                        e.this.JM.set(false);
                        return;
                    }
                    com.kwad.sdk.core.c.b.DD();
                    if (com.kwad.sdk.core.c.b.getCurrentActivity() != null) {
                        com.kwad.sdk.core.c.b.DD();
                        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                            ni();
                            return;
                        }
                    }
                    com.kwad.sdk.core.c.b.DD();
                    com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.e.a.e.1.2
                        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                        /* renamed from: onActivityResumed */
                        public final void d(Activity activity) {
                            super.d(activity);
                            com.kwad.sdk.core.c.b.DD();
                            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                            com.kwad.sdk.core.e.c.d("InstalledActivateManager", "startShow onBackToForeground");
                            ni();
                        }
                    });
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void ni() {
                    com.kwad.sdk.core.e.c.d("InstalledActivateManager", "startShow");
                    e.this.ao(adTemplate);
                    e.this.JM.set(false);
                    e.this.JN.remove(com.kwad.sdk.core.response.b.a.ay(com.kwad.sdk.core.response.b.e.dQ(adTemplate)));
                }

                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    final com.kwad.components.ad.b.a.a aVar = (com.kwad.components.ad.b.a.a) com.kwad.sdk.components.c.f(com.kwad.components.ad.b.a.a.class);
                    if (aVar != null && aVar.S()) {
                        aVar.a(new com.kwad.components.ad.b.a.c() { // from class: com.kwad.components.core.e.a.e.1.1
                            @Override // com.kwad.components.ad.b.a.c, com.kwad.components.ad.b.a.b
                            public final void U() {
                                aVar.b(this);
                                nh();
                                com.kwad.sdk.core.e.c.d("InstalledActivateManager", "startShow onPushAdClose");
                            }
                        });
                    } else {
                        nh();
                    }
                }
            }, com.kwad.sdk.core.response.b.b.dk(adTemplate));
        } else {
            com.kwad.sdk.core.e.c.d("InstalledActivateManager", "mLoadDisable: " + this.f36626od.get() + ", mLoadDisable: " + this.JM.get());
            this.JL.add(adTemplate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(AdTemplate adTemplate) {
        if (a(adTemplate, new b() { // from class: com.kwad.components.core.e.a.e.2
            @Override // com.kwad.components.core.e.a.b
            public final void eP() {
                com.kwad.sdk.core.e.c.d("InstalledActivateManager", "onViewClose");
                e.this.dJ();
                e.this.ng();
            }

            @Override // com.kwad.components.core.e.a.b
            public final void nd() {
                com.kwad.sdk.core.e.c.d("InstalledActivateManager", "onViewShow");
                e.this.dZ();
            }
        })) {
            return;
        }
        ng();
    }

    public static e nf() {
        return a.JR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ng() {
        if (this.JL.isEmpty()) {
            return;
        }
        an(this.JL.pop());
    }

    public final synchronized void am(AdTemplate adTemplate) {
        String ay = com.kwad.sdk.core.response.b.a.ay(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
        if (com.kwad.sdk.core.response.b.b.dj(adTemplate) && !this.JN.contains(ay)) {
            this.JN.add(ay);
            an(adTemplate);
        }
    }

    public final void dJ() {
        this.f36626od.set(false);
        Iterator<b> iterator2 = this.JK.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().eP();
        }
    }

    public final void dZ() {
        this.f36626od.set(true);
        Iterator<b> iterator2 = this.JK.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().nd();
        }
    }

    public final boolean isShowing() {
        return this.f36626od.get();
    }

    private e() {
        this.TAG = "InstalledActivateManager";
        this.JK = new CopyOnWriteArrayList();
        this.JL = new Stack<>();
        this.f36626od = new AtomicBoolean();
        this.JM = new AtomicBoolean();
        this.JN = new HashSet();
    }

    public final void b(b bVar) {
        this.JK.remove(bVar);
    }

    public final void a(b bVar) {
        this.JK.add(bVar);
    }

    private static boolean a(AdTemplate adTemplate, b bVar) {
        com.kwad.sdk.core.e.c.d("InstalledActivateManager", "showToActivityWindow");
        return new h().b(adTemplate, bVar);
    }
}
