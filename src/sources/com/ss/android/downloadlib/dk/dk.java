package com.ss.android.downloadlib.dk;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class dk {
    public void m(@NonNull final com.ss.android.downloadad.api.m.dk dkVar, @NonNull final hc hcVar, int i10) {
        com.ss.android.downloadlib.l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.dk.dk.1
            @Override // java.lang.Runnable
            public void run() {
                if (w.m(dkVar)) {
                    hcVar.m(false);
                } else if (!n.m(dkVar)) {
                    hcVar.m(false);
                } else {
                    n.m(dkVar, new e() { // from class: com.ss.android.downloadlib.dk.dk.1.1
                        @Override // com.ss.android.downloadlib.dk.e
                        public void m(boolean z10) {
                            hcVar.m(z10);
                        }
                    });
                }
            }
        }, i10);
    }
}
