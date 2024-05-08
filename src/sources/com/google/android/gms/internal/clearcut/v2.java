package com.google.android.gms.internal.clearcut;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class v2 extends u2 {
    public v2(int i10) {
        super(i10, null);
    }

    @Override // com.google.android.gms.internal.clearcut.u2
    public final void q() {
        if (!a()) {
            for (int i10 = 0; i10 < l(); i10++) {
                Map.Entry g3 = g(i10);
                if (((t0) g3.getKey()).c0()) {
                    g3.setValue(Collections.unmodifiableList((List) g3.getValue()));
                }
            }
            for (Map.Entry entry : m()) {
                if (((t0) entry.getKey()).c0()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.q();
    }
}
