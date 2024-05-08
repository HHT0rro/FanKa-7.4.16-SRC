package com.kwad.components.ad.reward;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a {
    private final Set<com.kwad.components.ad.reward.e.j> og;

    /* renamed from: com.kwad.components.ad.reward.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class C0425a {
        private static final a ok = new a(0);
    }

    public /* synthetic */ a(byte b4) {
        this();
    }

    public static a eX() {
        return C0425a.ok;
    }

    private void eZ() {
        if (this.og.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> iterator2 = this.og.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().bY();
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void b(com.kwad.components.ad.reward.e.j jVar) {
        this.og.remove(jVar);
    }

    public final void c(final PlayableSource playableSource, @Nullable final com.kwad.components.ad.reward.e.n nVar) {
        if (isMainThread()) {
            b(playableSource, nVar);
        } else {
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.a.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    a.this.b(playableSource, nVar);
                }
            });
        }
    }

    public final void eY() {
        if (isMainThread()) {
            eZ();
        } else {
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.a.2
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    a.this.eY();
                }
            });
        }
    }

    private a() {
        this.og = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
        if (this.og.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> iterator2 = this.og.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a(playableSource, nVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.e.j jVar) {
        if (jVar != null) {
            this.og.add(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PlayableSource playableSource) {
        if (this.og.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> iterator2 = this.og.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().bZ();
        }
    }

    public final void a(PlayableSource playableSource) {
        c(playableSource, null);
    }

    public final void b(final PlayableSource playableSource) {
        if (isMainThread()) {
            c(playableSource);
        } else {
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.a.3
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    a.this.c(playableSource);
                }
            });
        }
    }
}
