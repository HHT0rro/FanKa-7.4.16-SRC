package com.cupidapp.live.notify.model;

import b2.a;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AttentionNotifyModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AttentionNotifyModel {
    private long createTimeMillis;

    @NotNull
    private User fromUser;
    private final boolean showMosaic;

    @Nullable
    private final Integer specialLabelType;

    @NotNull
    private final String type;
    private boolean unread;

    @Nullable
    private final String userSpecialLabel;

    public AttentionNotifyModel(@NotNull User fromUser, @NotNull String type, boolean z10, long j10, boolean z11, @Nullable String str, @Nullable Integer num) {
        s.i(fromUser, "fromUser");
        s.i(type, "type");
        this.fromUser = fromUser;
        this.type = type;
        this.unread = z10;
        this.createTimeMillis = j10;
        this.showMosaic = z11;
        this.userSpecialLabel = str;
        this.specialLabelType = num;
    }

    @NotNull
    public final User component1() {
        return this.fromUser;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    public final boolean component3() {
        return this.unread;
    }

    public final long component4() {
        return this.createTimeMillis;
    }

    public final boolean component5() {
        return this.showMosaic;
    }

    @Nullable
    public final String component6() {
        return this.userSpecialLabel;
    }

    @Nullable
    public final Integer component7() {
        return this.specialLabelType;
    }

    @NotNull
    public final AttentionNotifyModel copy(@NotNull User fromUser, @NotNull String type, boolean z10, long j10, boolean z11, @Nullable String str, @Nullable Integer num) {
        s.i(fromUser, "fromUser");
        s.i(type, "type");
        return new AttentionNotifyModel(fromUser, type, z10, j10, z11, str, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AttentionNotifyModel)) {
            return false;
        }
        AttentionNotifyModel attentionNotifyModel = (AttentionNotifyModel) obj;
        return s.d(this.fromUser, attentionNotifyModel.fromUser) && s.d(this.type, attentionNotifyModel.type) && this.unread == attentionNotifyModel.unread && this.createTimeMillis == attentionNotifyModel.createTimeMillis && this.showMosaic == attentionNotifyModel.showMosaic && s.d(this.userSpecialLabel, attentionNotifyModel.userSpecialLabel) && s.d(this.specialLabelType, attentionNotifyModel.specialLabelType);
    }

    public final long getCreateTimeMillis() {
        return this.createTimeMillis;
    }

    @NotNull
    public final User getFromUser() {
        return this.fromUser;
    }

    public final boolean getShowMosaic() {
        return this.showMosaic;
    }

    @Nullable
    public final Integer getSpecialLabelType() {
        return this.specialLabelType;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final boolean getUnread() {
        return this.unread;
    }

    @Nullable
    public final String getUserSpecialLabel() {
        return this.userSpecialLabel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.fromUser.hashCode() * 31) + this.type.hashCode()) * 31;
        boolean z10 = this.unread;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int a10 = (((hashCode + i10) * 31) + a.a(this.createTimeMillis)) * 31;
        boolean z11 = this.showMosaic;
        int i11 = (a10 + (z11 ? 1 : z11 ? 1 : 0)) * 31;
        String str = this.userSpecialLabel;
        int hashCode2 = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.specialLabelType;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    public final void setCreateTimeMillis(long j10) {
        this.createTimeMillis = j10;
    }

    public final void setFromUser(@NotNull User user) {
        s.i(user, "<set-?>");
        this.fromUser = user;
    }

    public final void setUnread(boolean z10) {
        this.unread = z10;
    }

    @NotNull
    public String toString() {
        User user = this.fromUser;
        return "AttentionNotifyModel(fromUser=" + ((Object) user) + ", type=" + this.type + ", unread=" + this.unread + ", createTimeMillis=" + this.createTimeMillis + ", showMosaic=" + this.showMosaic + ", userSpecialLabel=" + this.userSpecialLabel + ", specialLabelType=" + ((Object) this.specialLabelType) + ")";
    }

    public /* synthetic */ AttentionNotifyModel(User user, String str, boolean z10, long j10, boolean z11, String str2, Integer num, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, str, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? 0L : j10, z11, str2, num);
    }
}
