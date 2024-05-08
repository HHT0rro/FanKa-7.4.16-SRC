package com.cupidapp.live.setting.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewPushLiveShowItemModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NewPushLiveShowUserModel {
    private boolean annualVip;

    @Nullable
    private ImageModel avatarImage;

    /* renamed from: id, reason: collision with root package name */
    @Nullable
    private String f18200id;

    @Nullable
    private final String label;

    @Nullable
    private final String name;

    @Nullable
    private final String nickname;

    @Nullable
    private String userId;
    private boolean vip;

    public NewPushLiveShowUserModel(@Nullable String str, boolean z10, boolean z11, @Nullable ImageModel imageModel, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.userId = str;
        this.vip = z10;
        this.annualVip = z11;
        this.avatarImage = imageModel;
        this.label = str2;
        this.f18200id = str3;
        this.name = str4;
        this.nickname = str5;
    }

    private final String component6() {
        return this.f18200id;
    }

    @Nullable
    public final String component1() {
        return this.userId;
    }

    public final boolean component2() {
        return this.vip;
    }

    public final boolean component3() {
        return this.annualVip;
    }

    @Nullable
    public final ImageModel component4() {
        return this.avatarImage;
    }

    @Nullable
    public final String component5() {
        return this.label;
    }

    @Nullable
    public final String component7() {
        return this.name;
    }

    @Nullable
    public final String component8() {
        return this.nickname;
    }

    @NotNull
    public final NewPushLiveShowUserModel copy(@Nullable String str, boolean z10, boolean z11, @Nullable ImageModel imageModel, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        return new NewPushLiveShowUserModel(str, z10, z11, imageModel, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NewPushLiveShowUserModel)) {
            return false;
        }
        NewPushLiveShowUserModel newPushLiveShowUserModel = (NewPushLiveShowUserModel) obj;
        return s.d(this.userId, newPushLiveShowUserModel.userId) && this.vip == newPushLiveShowUserModel.vip && this.annualVip == newPushLiveShowUserModel.annualVip && s.d(this.avatarImage, newPushLiveShowUserModel.avatarImage) && s.d(this.label, newPushLiveShowUserModel.label) && s.d(this.f18200id, newPushLiveShowUserModel.f18200id) && s.d(this.name, newPushLiveShowUserModel.name) && s.d(this.nickname, newPushLiveShowUserModel.nickname);
    }

    public final boolean getAnnualVip() {
        return this.annualVip;
    }

    @Nullable
    public final ImageModel getAvatarImage() {
        return this.avatarImage;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    public final boolean getVip() {
        return this.vip;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.userId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z10 = this.vip;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        boolean z11 = this.annualVip;
        int i12 = (i11 + (z11 ? 1 : z11 ? 1 : 0)) * 31;
        ImageModel imageModel = this.avatarImage;
        int hashCode2 = (i12 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str2 = this.label;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f18200id;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.name;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.nickname;
        return hashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setAnnualVip(boolean z10) {
        this.annualVip = z10;
    }

    public final void setAvatarImage(@Nullable ImageModel imageModel) {
        this.avatarImage = imageModel;
    }

    public final void setUserId(@Nullable String str) {
        this.userId = str;
    }

    public final void setVip(boolean z10) {
        this.vip = z10;
    }

    @NotNull
    public String toString() {
        String str = this.userId;
        boolean z10 = this.vip;
        boolean z11 = this.annualVip;
        ImageModel imageModel = this.avatarImage;
        return "NewPushLiveShowUserModel(userId=" + str + ", vip=" + z10 + ", annualVip=" + z11 + ", avatarImage=" + ((Object) imageModel) + ", label=" + this.label + ", id=" + this.f18200id + ", name=" + this.name + ", nickname=" + this.nickname + ")";
    }

    public /* synthetic */ NewPushLiveShowUserModel(String str, boolean z10, boolean z11, ImageModel imageModel, String str2, String str3, String str4, String str5, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? false : z11, imageModel, (i10 & 16) != 0 ? null : str2, (i10 & 32) != 0 ? null : str3, (i10 & 64) != 0 ? null : str4, (i10 & 128) != 0 ? null : str5);
    }
}
