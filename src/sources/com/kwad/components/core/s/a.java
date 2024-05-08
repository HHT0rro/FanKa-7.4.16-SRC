package com.kwad.components.core.s;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.utils.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {
    private static volatile a SW;
    private com.kwad.sdk.utils.h SS;
    private List<WeakReference<OfflineOnAudioConflictListener>> ST = new ArrayList();
    private boolean SU = false;
    private boolean SV = false;

    private a(@NonNull Context context) {
        init(context);
    }

    public static a ah(@NonNull Context context) {
        if (SW == null) {
            synchronized (a.class) {
                if (SW == null) {
                    SW = new a(context.getApplicationContext());
                }
            }
        }
        return SW;
    }

    private void init(Context context) {
        this.SU = false;
        com.kwad.sdk.utils.h hVar = new com.kwad.sdk.utils.h(context);
        this.SS = hVar;
        hVar.c(new h.a() { // from class: com.kwad.components.core.s.a.1
            @Override // com.kwad.sdk.utils.h.a
            public final void onAudioBeOccupied() {
                Iterator iterator2 = a.this.ST.iterator2();
                while (iterator2.hasNext()) {
                    WeakReference weakReference = (WeakReference) iterator2.next();
                    if (weakReference == null) {
                        iterator2.remove();
                    } else {
                        OfflineOnAudioConflictListener offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get();
                        if (offlineOnAudioConflictListener != null) {
                            offlineOnAudioConflictListener.onAudioBeOccupied();
                        } else {
                            iterator2.remove();
                        }
                    }
                }
                a.a(a.this, true);
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void onAudioBeReleased() {
                Iterator iterator2 = a.this.ST.iterator2();
                while (iterator2.hasNext()) {
                    WeakReference weakReference = (WeakReference) iterator2.next();
                    if (weakReference == null) {
                        iterator2.remove();
                    } else {
                        OfflineOnAudioConflictListener offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get();
                        if (offlineOnAudioConflictListener != null) {
                            offlineOnAudioConflictListener.onAudioBeReleased();
                        } else {
                            iterator2.remove();
                        }
                    }
                }
            }
        });
    }

    public final boolean aN(boolean z10) {
        com.kwad.sdk.utils.h hVar = this.SS;
        if (hVar == null) {
            return false;
        }
        if (!z10 && this.SU) {
            return false;
        }
        this.SU = true;
        this.SV = false;
        return hVar.Le();
    }

    public final void b(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        Iterator<WeakReference<OfflineOnAudioConflictListener>> iterator2 = this.ST.iterator2();
        while (iterator2.hasNext()) {
            WeakReference<OfflineOnAudioConflictListener> next = iterator2.next();
            if (next == null || next.get() == offlineOnAudioConflictListener) {
                iterator2.remove();
            }
        }
    }

    public final boolean qW() {
        return this.SV;
    }

    public final boolean qX() {
        return this.SU;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z10) {
        aVar.SV = true;
        return true;
    }

    public final void a(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        this.ST.add(new WeakReference<>(offlineOnAudioConflictListener));
    }
}
