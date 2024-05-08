package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.liveshow.helper.FKStartLiveHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PreviewLiveShowJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class l0 implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        FKBaseActivity fKBaseActivity = context instanceof FKBaseActivity ? (FKBaseActivity) context : null;
        if (fKBaseActivity != null) {
            FKStartLiveHelper.f15071a.e(fKBaseActivity);
        }
    }
}
