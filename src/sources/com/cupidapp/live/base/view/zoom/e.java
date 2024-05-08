package com.cupidapp.live.base.view.zoom;

import android.graphics.RectF;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ObjectsPool.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class e extends d<RectF> {
    public e(int i10) {
        super(i10);
    }

    @Override // com.cupidapp.live.base.view.zoom.d
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public RectF b() {
        return new RectF();
    }

    @Override // com.cupidapp.live.base.view.zoom.d
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RectF c(@NotNull RectF obj) {
        s.i(obj, "obj");
        obj.setEmpty();
        return obj;
    }
}
