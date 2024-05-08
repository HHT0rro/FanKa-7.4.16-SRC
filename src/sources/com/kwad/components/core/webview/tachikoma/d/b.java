package com.kwad.components.core.webview.tachikoma.d;

import com.kwad.components.core.webview.tachikoma.e.e;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    private final Set<e> aaW;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private static final b abc = new b(0);
    }

    public /* synthetic */ b(byte b4) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, String str2) {
        if (this.aaW.size() == 0) {
            return;
        }
        Iterator<E> iterator2 = new HashSet(this.aaW).iterator2();
        while (iterator2.hasNext()) {
            ((e) iterator2.next()).q(str2);
        }
    }

    public static b tc() {
        return a.abc;
    }

    public final void b(e eVar) {
        this.aaW.remove(eVar);
    }

    public final void c(final String str, final long j10, final long j11, final long j12) {
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.webview.tachikoma.d.b.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                b.this.b(str, j10, j11, j12);
            }
        });
    }

    public final void s(final String str, final String str2) {
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.webview.tachikoma.d.b.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                b.this.r(str, str2);
            }
        });
    }

    public final void td() {
        this.aaW.clear();
    }

    private b() {
        this.aaW = new CopyOnWriteArraySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j10, long j11, long j12) {
        if (this.aaW.size() == 0) {
            return;
        }
        Iterator<E> iterator2 = new HashSet(this.aaW).iterator2();
        while (iterator2.hasNext()) {
            ((e) iterator2.next()).a(str, j10, j11, j12);
        }
    }

    public final void a(e eVar) {
        if (eVar != null) {
            this.aaW.add(eVar);
        }
    }
}
