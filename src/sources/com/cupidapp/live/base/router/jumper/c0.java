package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.base.sensorslog.SensorsLogMatch;
import com.cupidapp.live.liveshow.view.miniprofile.ShowLiveMiniProfileViewModel;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MiniUserUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c0 implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        String path = uri.getPath();
        String A = path != null ? kotlin.text.p.A(path, "/", "", false, 4, null) : null;
        if (A == null || A.length() == 0) {
            return;
        }
        EventBus.c().l(new ShowLiveMiniProfileViewModel(A, SensorsLogMatch.AlohaGetPosition.Others, null, false, false, false, 60, null));
    }
}
