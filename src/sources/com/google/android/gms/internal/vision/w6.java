package com.google.android.gms.internal.vision;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class w6 extends x6 {
    public w6(int i10) {
        super(i10, null);
    }

    @Override // com.google.android.gms.internal.vision.x6
    public final void e() {
        if (!i()) {
            for (int i10 = 0; i10 < j(); i10++) {
                Map.Entry h10 = h(i10);
                if (((s4) h10.getKey()).zzd()) {
                    h10.setValue(Collections.unmodifiableList((List) h10.getValue()));
                }
            }
            for (Map.Entry entry : m()) {
                if (((s4) entry.getKey()).zzd()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.e();
    }
}
