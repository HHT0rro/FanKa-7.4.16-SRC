package com.google.android.gms.internal.mlkit_vision_face;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p8 implements v8 {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public final List<v8> f25146a;

    public p8(Context context, o8 o8Var) {
        ArrayList arrayList = new ArrayList();
        this.f25146a = arrayList;
        if (o8Var.c()) {
            arrayList.add(new e9(context, o8Var));
        }
        if (o8Var.b()) {
            arrayList.add(new y8(context));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.v8
    public final void a(x8 x8Var) {
        Iterator<v8> iterator2 = this.f25146a.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a(x8Var);
        }
    }
}
