package com.tencent.liteav.sdkcommon;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final g f43191a;

    /* renamed from: b, reason: collision with root package name */
    private final Button f43192b;

    private j(g gVar, Button button) {
        this.f43191a = gVar;
        this.f43192b = button;
    }

    public static View.OnClickListener a(g gVar, Button button) {
        return new j(gVar, button);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        g gVar = this.f43191a;
        boolean z10 = gVar.f43180m;
        if (!z10) {
            gVar.f43169b.height = gVar.f43181n / 2;
        } else {
            WindowManager.LayoutParams layoutParams = gVar.f43169b;
            int i10 = gVar.f43181n;
            layoutParams.height = i10;
            int i11 = layoutParams.f817y;
            int i12 = i10 + i11;
            int i13 = gVar.f43168a.heightPixels;
            if (i12 > i13) {
                layoutParams.height = i13 - i11;
            }
        }
        gVar.f43180m = !z10;
        gVar.f43173f.updateViewLayout(gVar.f43174g, gVar.f43169b);
        ViewGroup.LayoutParams layoutParams2 = gVar.f43178k.getLayoutParams();
        layoutParams2.height = gVar.b();
        gVar.f43178k.setLayoutParams(layoutParams2);
        gVar.f43171d.post(l.a(gVar));
    }
}
