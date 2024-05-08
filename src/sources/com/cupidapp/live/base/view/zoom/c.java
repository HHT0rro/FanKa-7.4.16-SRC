package com.cupidapp.live.base.view.zoom;

import android.graphics.Matrix;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ObjectsPool.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class c extends d<Matrix> {
    public c(int i10) {
        super(i10);
    }

    @Override // com.cupidapp.live.base.view.zoom.d
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Matrix b() {
        return new Matrix();
    }

    @Override // com.cupidapp.live.base.view.zoom.d
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Matrix c(@NotNull Matrix obj) {
        s.i(obj, "obj");
        obj.reset();
        return obj;
    }
}
