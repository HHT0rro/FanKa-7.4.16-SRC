package com.cupidapp.live.base.router.jumper;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OpenAppJumperManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class g0 implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        if (context == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("url");
        if (queryParameter == null || queryParameter.length() == 0) {
            return;
        }
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(queryParameter)));
        } catch (ActivityNotFoundException e2) {
            com.cupidapp.live.base.view.h.f12779a.m(context, "请先安装此应用");
            e2.printStackTrace();
        }
    }
}
