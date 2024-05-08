package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final SparseIntArray f23691a = new SparseIntArray();

    /* renamed from: b, reason: collision with root package name */
    public com.google.android.gms.common.b f23692b;

    public o(@NonNull com.google.android.gms.common.b bVar) {
        h.h(bVar);
        this.f23692b = bVar;
    }

    public final int a(@NonNull Context context, @NonNull a.f fVar) {
        h.h(context);
        h.h(fVar);
        int i10 = 0;
        if (!fVar.i()) {
            return 0;
        }
        int g3 = fVar.g();
        int i11 = this.f23691a.get(g3, -1);
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        while (true) {
            if (i12 >= this.f23691a.size()) {
                i10 = i11;
                break;
            }
            int keyAt = this.f23691a.keyAt(i12);
            if (keyAt > g3 && this.f23691a.get(keyAt) == 0) {
                break;
            }
            i12++;
        }
        if (i10 == -1) {
            i10 = this.f23692b.h(context, g3);
        }
        this.f23691a.put(g3, i10);
        return i10;
    }

    public final void b() {
        this.f23691a.clear();
    }
}
