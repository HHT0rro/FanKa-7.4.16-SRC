package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a0 implements d0 {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public final List<d0> f24159a;

    public a0(Context context, z zVar) {
        ArrayList arrayList = new ArrayList();
        this.f24159a = arrayList;
        if (zVar.c()) {
            arrayList.add(new k0(context, zVar));
        }
        if (zVar.b()) {
            arrayList.add(new f0(context));
        }
    }
}
