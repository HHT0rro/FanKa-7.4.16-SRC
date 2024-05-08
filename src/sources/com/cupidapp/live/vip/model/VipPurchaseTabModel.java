package com.cupidapp.live.vip.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: VipPurchaseTabModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipPurchaseTabModel extends PurchaseTabModel {

    @NotNull
    private final VipType vipType;

    public /* synthetic */ VipPurchaseTabModel(VipType vipType, String str, String str2, float f10, List list, List list2, int i10, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(vipType, str, str2, f10, list, (i11 & 32) != 0 ? list : list2, (i11 & 64) != 0 ? 0 : i10, (i11 & 128) != 0 ? false : z10);
    }

    @NotNull
    public final VipType getVipType() {
        return this.vipType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPurchaseTabModel(@NotNull VipType vipType, @NotNull String title, @NotNull String content, float f10, @NotNull List<Integer> titleSelectColor, @NotNull List<Integer> contentSelector, int i10, boolean z10) {
        super(title, content, f10, titleSelectColor, contentSelector, i10, z10, false, null, 0.0f, 0.0f, 1920, null);
        s.i(vipType, "vipType");
        s.i(title, "title");
        s.i(content, "content");
        s.i(titleSelectColor, "titleSelectColor");
        s.i(contentSelector, "contentSelector");
        this.vipType = vipType;
    }
}
