package com.cupidapp.live.base.share.model;

import com.cupidapp.live.base.web.model.ClubActivityInfoModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKShareModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CustomShareItemModel extends BaseShareItemModel {

    @Nullable
    private ClubActivityInfoModel clubActivityInfo;

    public /* synthetic */ CustomShareItemModel(ShareBaseType shareBaseType, ClubActivityInfoModel clubActivityInfoModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(shareBaseType, (i10 & 2) != 0 ? null : clubActivityInfoModel);
    }

    @Nullable
    public final ClubActivityInfoModel getClubActivityInfo() {
        return this.clubActivityInfo;
    }

    public final void setClubActivityInfo(@Nullable ClubActivityInfoModel clubActivityInfoModel) {
        this.clubActivityInfo = clubActivityInfoModel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomShareItemModel(@NotNull ShareBaseType type, @Nullable ClubActivityInfoModel clubActivityInfoModel) {
        super(type);
        s.i(type, "type");
        this.clubActivityInfo = clubActivityInfoModel;
    }
}
