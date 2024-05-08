package com.cupidapp.live.base.share.view;

import com.cupidapp.live.base.share.model.ShareBaseType;
import com.cupidapp.live.base.share.model.ShareItemHandledResult;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ShareItemClickListener.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface b {

    /* compiled from: ShareItemClickListener.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public static void a(@NotNull b bVar, @NotNull ShareItemHandledResult result) {
            s.i(result, "result");
        }
    }

    void a(@NotNull ShareItemHandledResult shareItemHandledResult);

    void b(@NotNull ShareBaseType shareBaseType);
}
