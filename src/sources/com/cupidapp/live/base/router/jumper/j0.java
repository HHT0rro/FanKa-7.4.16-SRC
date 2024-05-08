package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.R$string;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SystemFunctionJumperManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class j0 implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        String queryParameter;
        kotlin.jvm.internal.s.i(uri, "uri");
        if (context == null || (queryParameter = uri.getQueryParameter("content")) == null) {
            return;
        }
        q1.c cVar = q1.c.f53005a;
        cVar.a(context);
        cVar.b(context, queryParameter);
        com.cupidapp.live.base.view.h.f12779a.k(R$string.copy_successful);
    }
}
