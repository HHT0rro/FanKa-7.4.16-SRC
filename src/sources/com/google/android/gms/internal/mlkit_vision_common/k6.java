package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k6 implements p6 {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public final List<p6> f24422a;

    public k6(Context context, j6 j6Var) {
        ArrayList arrayList = new ArrayList();
        this.f24422a = arrayList;
        if (j6Var.c()) {
            arrayList.add(new y6(context, j6Var));
        }
        if (j6Var.b()) {
            arrayList.add(new s6(context));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.p6
    public final void a(r6 r6Var) {
        Iterator<p6> iterator2 = this.f24422a.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a(r6Var);
        }
    }
}
