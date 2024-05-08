package com.cupidapp.live.base.share.model;

import androidx.annotation.StringRes;
import com.cupidapp.live.vip.model.VipType;
import javax.annotation.Resource;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKShareModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKShareItemModel extends BaseShareItemModel {
    private final int contentId;

    @Resource
    private final int drawableId;

    @Nullable
    private final VipType needVipType;
    private final boolean showNewDot;

    public /* synthetic */ FKShareItemModel(ShareBaseType shareBaseType, int i10, int i11, boolean z10, VipType vipType, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(shareBaseType, (i12 & 2) != 0 ? 0 : i10, (i12 & 4) != 0 ? 0 : i11, (i12 & 8) != 0 ? false : z10, (i12 & 16) != 0 ? null : vipType);
    }

    public final int getContentId() {
        return this.contentId;
    }

    public final int getDrawableId() {
        return this.drawableId;
    }

    @Nullable
    public final VipType getNeedVipType() {
        return this.needVipType;
    }

    public final boolean getShowNewDot() {
        return this.showNewDot;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKShareItemModel(@NotNull ShareBaseType type, @StringRes int i10, int i11, boolean z10, @Nullable VipType vipType) {
        super(type);
        s.i(type, "type");
        this.contentId = i10;
        this.drawableId = i11;
        this.showNewDot = z10;
        this.needVipType = vipType;
    }
}
