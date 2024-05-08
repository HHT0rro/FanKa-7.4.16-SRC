package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.R$string;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OpenAppJumperManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class f0 implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        if (context == null) {
            return;
        }
        m1.a aVar = m1.a.f51796a;
        if (aVar.a(context)) {
            m1.a.c(aVar, context, null, 2, null);
        } else {
            com.cupidapp.live.base.view.h.f12779a.r(context, R$string.update_app);
        }
    }
}
