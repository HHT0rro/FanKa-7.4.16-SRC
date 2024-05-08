package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKTurnTableModel extends LiveMenuBtnModel {
    private boolean crit;

    @Nullable
    private final ImageModel critIconImage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKTurnTableModel(@NotNull String url, @Nullable String str, boolean z10, @NotNull ImageModel iconImage, boolean z11, @Nullable ImageModel imageModel) {
        super(url, str, z10, iconImage);
        s.i(url, "url");
        s.i(iconImage, "iconImage");
        this.crit = z11;
        this.critIconImage = imageModel;
    }

    public final boolean getCrit() {
        return this.crit;
    }

    @Nullable
    public final ImageModel getCritIconImage() {
        return this.critIconImage;
    }

    public final void setCrit(boolean z10) {
        this.crit = z10;
    }
}
