package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.match.fragment.FKMatchContainerFragment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a0 implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        if (context == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("source");
        MainActivity.F.d(context, FKMatchContainerFragment.f16640u.a(context, FKMatchContainerFragment.MatchTabType.Match));
        if (kotlin.jvm.internal.s.d(queryParameter, "filterReward")) {
            com.cupidapp.live.base.view.h.p(com.cupidapp.live.base.view.h.f12779a, context, context.getString(R$string.acquire_filter_tip), Integer.valueOf(R$mipmap.ic_toast_filter), 0, z0.h.c(this, 4.0f), 0, 40, null);
        } else if (kotlin.jvm.internal.s.d(queryParameter, "superLikeReward")) {
            com.cupidapp.live.base.view.h.p(com.cupidapp.live.base.view.h.f12779a, context, context.getString(R$string.acquire_super_like_tip), Integer.valueOf(R$mipmap.ic_toast_superlike), 0, z0.h.c(this, 4.0f), 0, 40, null);
        }
    }
}
