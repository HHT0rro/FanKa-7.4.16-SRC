package com.huawei.quickcard;

import android.graphics.Canvas;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.framework.drawable.IBorderDrawable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class l extends g implements IBorderDrawable {

    /* renamed from: e, reason: collision with root package name */
    public View f34090e;

    /* renamed from: f, reason: collision with root package name */
    public Border f34091f;

    public l(boolean z10) {
        super(z10);
        this.f34090e = null;
        this.f34091f = null;
    }

    @Override // com.huawei.quickcard.g
    public void a() {
        a(this.f34091f);
    }

    public abstract void a(@NonNull Canvas canvas, Border border);

    public abstract void a(Border border);

    @Override // com.huawei.quickcard.framework.drawable.IBorderDrawable
    public void updateBorder(Border border) {
        this.f34091f = border;
    }

    @Override // com.huawei.quickcard.framework.drawable.IBorderDrawable
    public void updateContext(View view) {
        this.f34090e = view;
    }

    @Override // com.huawei.quickcard.g
    public void a(@NonNull Canvas canvas) {
        a(canvas, this.f34091f);
    }

    public l(boolean z10, View view) {
        this(z10, null, view);
    }

    public l(boolean z10, Border border) {
        this(z10, border, null);
    }

    public l(boolean z10, Border border, View view) {
        this(z10);
        this.f34091f = border;
        this.f34090e = view;
    }
}
