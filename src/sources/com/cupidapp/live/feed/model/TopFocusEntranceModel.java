package com.cupidapp.live.feed.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TopFocusEntranceModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TopFocusEntranceModel implements IBaseFeedModel {

    @Nullable
    private Integer focusCount;

    public TopFocusEntranceModel(@Nullable Integer num) {
        this.focusCount = num;
    }

    @Nullable
    public final Integer getFocusCount() {
        return this.focusCount;
    }

    @Override // com.cupidapp.live.feed.model.IBaseFeedModel
    @NotNull
    public String getSensorFeedType() {
        return "TopSpecialFocusManage";
    }

    public final void setFocusCount(@Nullable Integer num) {
        this.focusCount = num;
    }
}
