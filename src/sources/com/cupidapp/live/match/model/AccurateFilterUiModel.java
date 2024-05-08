package com.cupidapp.live.match.model;

import com.cupidapp.live.vip.model.VipDiscountDescriptionResult;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchFilterUiModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AccurateFilterUiModel extends FilterUiModel {
    private final boolean limitTimeReward;

    @NotNull
    private final List<Object> list;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccurateFilterUiModel(@NotNull List<? extends Object> list, boolean z10, @NotNull String tabName, @NotNull String tabKey, @Nullable VipDiscountDescriptionResult vipDiscountDescriptionResult) {
        super(tabName, tabKey, vipDiscountDescriptionResult);
        s.i(list, "list");
        s.i(tabName, "tabName");
        s.i(tabKey, "tabKey");
        this.list = list;
        this.limitTimeReward = z10;
    }

    public final boolean getLimitTimeReward() {
        return this.limitTimeReward;
    }

    @NotNull
    public final List<Object> getList() {
        return this.list;
    }
}
