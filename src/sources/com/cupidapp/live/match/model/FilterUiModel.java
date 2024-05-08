package com.cupidapp.live.match.model;

import com.cupidapp.live.vip.model.VipDiscountDescriptionResult;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchFilterUiModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class FilterUiModel {

    @NotNull
    private final String tabKey;

    @NotNull
    private final String tabName;

    @Nullable
    private final VipDiscountDescriptionResult vipDiscount;

    public FilterUiModel(@NotNull String tabName, @NotNull String tabKey, @Nullable VipDiscountDescriptionResult vipDiscountDescriptionResult) {
        s.i(tabName, "tabName");
        s.i(tabKey, "tabKey");
        this.tabName = tabName;
        this.tabKey = tabKey;
        this.vipDiscount = vipDiscountDescriptionResult;
    }

    @NotNull
    public final String getTabKey() {
        return this.tabKey;
    }

    @NotNull
    public final String getTabName() {
        return this.tabName;
    }

    @Nullable
    public final VipDiscountDescriptionResult getVipDiscount() {
        return this.vipDiscount;
    }
}
