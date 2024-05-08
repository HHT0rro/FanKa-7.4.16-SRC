package com.cupidapp.live.liveshow.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveListResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AdViewModel {

    @NotNull
    private final List<AdModel> list;

    public AdViewModel(@NotNull List<AdModel> list) {
        s.i(list, "list");
        this.list = list;
    }

    @NotNull
    public final List<AdModel> getList() {
        return this.list;
    }
}
