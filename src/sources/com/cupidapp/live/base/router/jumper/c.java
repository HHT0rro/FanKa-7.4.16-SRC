package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.setting.activity.BindPhoneActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BindPhoneNumberJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        if (context == null) {
            return;
        }
        BindPhoneActivity.f17923t.a(context, true);
    }
}
