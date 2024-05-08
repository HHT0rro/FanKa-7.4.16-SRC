package com.cupidapp.live.base.web.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WebShareModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubActivityInfoModel {

    @Nullable
    private final String activityId;

    @Nullable
    private final String groupAvatar;

    @Nullable
    private final String groupId;

    @Nullable
    private final String groupName;

    public ClubActivityInfoModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.groupId = str;
        this.groupName = str2;
        this.groupAvatar = str3;
        this.activityId = str4;
    }

    public static /* synthetic */ ClubActivityInfoModel copy$default(ClubActivityInfoModel clubActivityInfoModel, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = clubActivityInfoModel.groupId;
        }
        if ((i10 & 2) != 0) {
            str2 = clubActivityInfoModel.groupName;
        }
        if ((i10 & 4) != 0) {
            str3 = clubActivityInfoModel.groupAvatar;
        }
        if ((i10 & 8) != 0) {
            str4 = clubActivityInfoModel.activityId;
        }
        return clubActivityInfoModel.copy(str, str2, str3, str4);
    }

    @Nullable
    public final String component1() {
        return this.groupId;
    }

    @Nullable
    public final String component2() {
        return this.groupName;
    }

    @Nullable
    public final String component3() {
        return this.groupAvatar;
    }

    @Nullable
    public final String component4() {
        return this.activityId;
    }

    @NotNull
    public final ClubActivityInfoModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new ClubActivityInfoModel(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubActivityInfoModel)) {
            return false;
        }
        ClubActivityInfoModel clubActivityInfoModel = (ClubActivityInfoModel) obj;
        return s.d(this.groupId, clubActivityInfoModel.groupId) && s.d(this.groupName, clubActivityInfoModel.groupName) && s.d(this.groupAvatar, clubActivityInfoModel.groupAvatar) && s.d(this.activityId, clubActivityInfoModel.activityId);
    }

    @Nullable
    public final String getActivityId() {
        return this.activityId;
    }

    @Nullable
    public final String getGroupAvatar() {
        return this.groupAvatar;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final String getGroupName() {
        return this.groupName;
    }

    public int hashCode() {
        String str = this.groupId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.groupName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.groupAvatar;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.activityId;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ClubActivityInfoModel(groupId=" + this.groupId + ", groupName=" + this.groupName + ", groupAvatar=" + this.groupAvatar + ", activityId=" + this.activityId + ")";
    }
}
