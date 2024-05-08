package com.cupidapp.live.setting.model;

import java.io.Serializable;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitSettingModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PostLimitSettingModel implements Serializable {
    private final int messageLimit;
    private final int readLimit;

    public PostLimitSettingModel(int i10, int i11) {
        this.readLimit = i10;
        this.messageLimit = i11;
    }

    public static /* synthetic */ PostLimitSettingModel copy$default(PostLimitSettingModel postLimitSettingModel, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = postLimitSettingModel.readLimit;
        }
        if ((i12 & 2) != 0) {
            i11 = postLimitSettingModel.messageLimit;
        }
        return postLimitSettingModel.copy(i10, i11);
    }

    public final int component1() {
        return this.readLimit;
    }

    public final int component2() {
        return this.messageLimit;
    }

    @NotNull
    public final PostLimitSettingModel copy(int i10, int i11) {
        return new PostLimitSettingModel(i10, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostLimitSettingModel)) {
            return false;
        }
        PostLimitSettingModel postLimitSettingModel = (PostLimitSettingModel) obj;
        return this.readLimit == postLimitSettingModel.readLimit && this.messageLimit == postLimitSettingModel.messageLimit;
    }

    public final int getMessageLimit() {
        return this.messageLimit;
    }

    @NotNull
    public final LimitRangeType getMsgLimitType() {
        int i10 = this.messageLimit;
        LimitRangeType limitRangeType = LimitRangeType.FANS;
        if (i10 == limitRangeType.getValue()) {
            return limitRangeType;
        }
        LimitRangeType limitRangeType2 = LimitRangeType.MATCH;
        return i10 == limitRangeType2.getValue() ? limitRangeType2 : LimitRangeType.PUBLIC;
    }

    public final int getReadLimit() {
        return this.readLimit;
    }

    @NotNull
    public final LimitRangeType getReadLimitType() {
        int i10 = this.readLimit;
        LimitRangeType limitRangeType = LimitRangeType.FANS;
        if (i10 == limitRangeType.getValue()) {
            return limitRangeType;
        }
        LimitRangeType limitRangeType2 = LimitRangeType.MATCH;
        return i10 == limitRangeType2.getValue() ? limitRangeType2 : LimitRangeType.PUBLIC;
    }

    public int hashCode() {
        return (this.readLimit * 31) + this.messageLimit;
    }

    @NotNull
    public String toString() {
        return "PostLimitSettingModel(readLimit=" + this.readLimit + ", messageLimit=" + this.messageLimit + ")";
    }
}
