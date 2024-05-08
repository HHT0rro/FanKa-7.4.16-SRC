package com.cupidapp.live.club.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class QuoteInfoModel {

    @Nullable
    private final String activityJumpUrl;

    @Nullable
    private Boolean cancel;

    @Nullable
    private final ImageModel image;

    @Nullable
    private final String imagePath;

    @Nullable
    private final String messageId;

    @Nullable
    private final String nickname;

    @Nullable
    private String text;

    @Nullable
    private final String type;

    public QuoteInfoModel(@Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable String str4, @Nullable ImageModel imageModel, @Nullable String str5, @Nullable String str6) {
        this.messageId = str;
        this.type = str2;
        this.cancel = bool;
        this.nickname = str3;
        this.text = str4;
        this.image = imageModel;
        this.imagePath = str5;
        this.activityJumpUrl = str6;
    }

    @Nullable
    public final String component1() {
        return this.messageId;
    }

    @Nullable
    public final String component2() {
        return this.type;
    }

    @Nullable
    public final Boolean component3() {
        return this.cancel;
    }

    @Nullable
    public final String component4() {
        return this.nickname;
    }

    @Nullable
    public final String component5() {
        return this.text;
    }

    @Nullable
    public final ImageModel component6() {
        return this.image;
    }

    @Nullable
    public final String component7() {
        return this.imagePath;
    }

    @Nullable
    public final String component8() {
        return this.activityJumpUrl;
    }

    @NotNull
    public final QuoteInfoModel copy(@Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable String str4, @Nullable ImageModel imageModel, @Nullable String str5, @Nullable String str6) {
        return new QuoteInfoModel(str, str2, bool, str3, str4, imageModel, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuoteInfoModel)) {
            return false;
        }
        QuoteInfoModel quoteInfoModel = (QuoteInfoModel) obj;
        return s.d(this.messageId, quoteInfoModel.messageId) && s.d(this.type, quoteInfoModel.type) && s.d(this.cancel, quoteInfoModel.cancel) && s.d(this.nickname, quoteInfoModel.nickname) && s.d(this.text, quoteInfoModel.text) && s.d(this.image, quoteInfoModel.image) && s.d(this.imagePath, quoteInfoModel.imagePath) && s.d(this.activityJumpUrl, quoteInfoModel.activityJumpUrl);
    }

    @Nullable
    public final String getActivityJumpUrl() {
        return this.activityJumpUrl;
    }

    @Nullable
    public final Boolean getCancel() {
        return this.cancel;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    public final String getImagePath() {
        return this.imagePath;
    }

    @Nullable
    public final String getMessageId() {
        return this.messageId;
    }

    @Nullable
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.messageId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.cancel;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.nickname;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.text;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        ImageModel imageModel = this.image;
        int hashCode6 = (hashCode5 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str5 = this.imagePath;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.activityJumpUrl;
        return hashCode7 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setCancel(@Nullable Boolean bool) {
        this.cancel = bool;
    }

    public final void setText(@Nullable String str) {
        this.text = str;
    }

    @NotNull
    public String toString() {
        String str = this.messageId;
        String str2 = this.type;
        Boolean bool = this.cancel;
        String str3 = this.nickname;
        String str4 = this.text;
        ImageModel imageModel = this.image;
        return "QuoteInfoModel(messageId=" + str + ", type=" + str2 + ", cancel=" + ((Object) bool) + ", nickname=" + str3 + ", text=" + str4 + ", image=" + ((Object) imageModel) + ", imagePath=" + this.imagePath + ", activityJumpUrl=" + this.activityJumpUrl + ")";
    }
}
