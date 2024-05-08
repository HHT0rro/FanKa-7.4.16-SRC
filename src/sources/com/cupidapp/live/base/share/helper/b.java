package com.cupidapp.live.base.share.helper;

import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.h;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: CopyLinkShare.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f12254a = new b();

    @Override // com.cupidapp.live.base.share.helper.c
    public void a(@NotNull ShareBuilder shareBuilder) {
        s.i(shareBuilder, "shareBuilder");
        c(shareBuilder);
    }

    @Override // com.cupidapp.live.base.share.helper.c
    public void b(@NotNull ShareBuilder shareBuilder) {
        s.i(shareBuilder, "shareBuilder");
    }

    public final void c(ShareBuilder shareBuilder) {
        String shareUrl = shareBuilder.shareUrl();
        if (shareBuilder.getActivity() == null) {
            h.f12779a.r(shareBuilder.getActivity(), R$string.copy_fail);
        } else {
            q1.c.f53005a.b(shareBuilder.getActivity(), shareUrl);
            h.f12779a.c(shareBuilder.getActivity(), R$string.copy_success);
        }
    }
}
