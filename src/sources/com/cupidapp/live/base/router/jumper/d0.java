package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.MainActivity;
import com.huawei.openalliance.ad.constant.as;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewMatchUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class d0 implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        if (context == null) {
            return;
        }
        MainActivity.a aVar = MainActivity.F;
        aVar.d(context, MainActivity.a.b(aVar, context, MainActivity.MainPagerType.Chat, null, 4, null));
        EventBus.c().o(new OpenNewMatchProfileEvent(uri.getQueryParameter(as.f32242q)));
    }
}
