package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.y3;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class y3<M extends y3<M>> extends c4 {

    /* renamed from: c, reason: collision with root package name */
    public z3 f24111c;

    @Override // com.google.android.gms.internal.clearcut.c4
    public void a(x3 x3Var) throws IOException {
        if (this.f24111c == null) {
            return;
        }
        for (int i10 = 0; i10 < this.f24111c.c(); i10++) {
            this.f24111c.d(i10).c(x3Var);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.c4
    public int e() {
        if (this.f24111c != null) {
            for (int i10 = 0; i10 < this.f24111c.c(); i10++) {
                this.f24111c.d(i10).d();
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.clearcut.c4
    /* renamed from: g */
    public /* synthetic */ c4 clone() throws CloneNotSupportedException {
        return (y3) clone();
    }

    @Override // com.google.android.gms.internal.clearcut.c4
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public M clone() throws CloneNotSupportedException {
        M m10 = (M) super.clone();
        b4.h(this, m10);
        return m10;
    }
}
