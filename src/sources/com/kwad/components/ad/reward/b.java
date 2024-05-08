package com.kwad.components.ad.reward;

import android.os.Looper;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b {
    private final Set<com.kwad.components.ad.reward.e.l> ol;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {
        private static final b on = new b(0);
    }

    public /* synthetic */ b(byte b4) {
        this();
    }

    public static b fb() {
        return a.on;
    }

    private void fc() {
        if (this.ol.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.l> iterator2 = this.ol.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onRewardVerify();
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void a(com.kwad.components.ad.reward.e.l lVar) {
        if (lVar != null) {
            this.ol.add(lVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.e.l lVar) {
        this.ol.remove(lVar);
    }

    public final void notifyRewardVerify() {
        if (isMainThread()) {
            fc();
        } else {
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.b.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    b.this.notifyRewardVerify();
                }
            });
        }
    }

    private b() {
        this.ol = new HashSet();
    }
}
