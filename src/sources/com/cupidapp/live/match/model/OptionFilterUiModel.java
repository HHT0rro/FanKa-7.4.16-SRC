package com.cupidapp.live.match.model;

import com.cupidapp.live.vip.model.VipDiscountDescriptionResult;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchFilterUiModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class OptionFilterUiModel extends FilterUiModel {

    @NotNull
    private final FilterTabModel filterTabModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OptionFilterUiModel(@NotNull FilterTabModel filterTabModel, @NotNull String tabKey, @NotNull String tabName, @Nullable VipDiscountDescriptionResult vipDiscountDescriptionResult) {
        super(tabName, tabKey, vipDiscountDescriptionResult);
        s.i(filterTabModel, "filterTabModel");
        s.i(tabKey, "tabKey");
        s.i(tabName, "tabName");
        this.filterTabModel = filterTabModel;
    }

    @NotNull
    public final FilterTabModel getFilterTabModel() {
        return this.filterTabModel;
    }
}
