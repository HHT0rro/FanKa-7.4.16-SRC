package com.cupidapp.live.base.grpc;

import com.cupidapp.live.base.network.gson.BaseLiveShowTagModel;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.profile.model.User;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NotifyMessageModel {

    @Nullable
    private final String bgColor;

    @Nullable
    private final ImageModel leftIcon;

    @Nullable
    private final String message;
    private final int messageType;

    @Nullable
    private final String path;

    @Nullable
    private final String point;

    @Nullable
    private final String style;

    @Nullable
    private final List<BaseLiveShowTagModel> systemLabels;

    @Nullable
    private final User user;

    /* JADX WARN: Multi-variable type inference failed */
    public NotifyMessageModel(@Nullable String str, @Nullable String str2, int i10, @Nullable User user, @Nullable String str3, @Nullable ImageModel imageModel, @Nullable String str4, @Nullable String str5, @Nullable List<? extends BaseLiveShowTagModel> list) {
        this.message = str;
        this.style = str2;
        this.messageType = i10;
        this.user = user;
        this.bgColor = str3;
        this.leftIcon = imageModel;
        this.path = str4;
        this.point = str5;
        this.systemLabels = list;
    }

    @Nullable
    public final String component1() {
        return this.message;
    }

    @Nullable
    public final String component2() {
        return this.style;
    }

    public final int component3() {
        return this.messageType;
    }

    @Nullable
    public final User component4() {
        return this.user;
    }

    @Nullable
    public final String component5() {
        return this.bgColor;
    }

    @Nullable
    public final ImageModel component6() {
        return this.leftIcon;
    }

    @Nullable
    public final String component7() {
        return this.path;
    }

    @Nullable
    public final String component8() {
        return this.point;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> component9() {
        return this.systemLabels;
    }

    @NotNull
    public final NotifyMessageModel copy(@Nullable String str, @Nullable String str2, int i10, @Nullable User user, @Nullable String str3, @Nullable ImageModel imageModel, @Nullable String str4, @Nullable String str5, @Nullable List<? extends BaseLiveShowTagModel> list) {
        return new NotifyMessageModel(str, str2, i10, user, str3, imageModel, str4, str5, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotifyMessageModel)) {
            return false;
        }
        NotifyMessageModel notifyMessageModel = (NotifyMessageModel) obj;
        return kotlin.jvm.internal.s.d(this.message, notifyMessageModel.message) && kotlin.jvm.internal.s.d(this.style, notifyMessageModel.style) && this.messageType == notifyMessageModel.messageType && kotlin.jvm.internal.s.d(this.user, notifyMessageModel.user) && kotlin.jvm.internal.s.d(this.bgColor, notifyMessageModel.bgColor) && kotlin.jvm.internal.s.d(this.leftIcon, notifyMessageModel.leftIcon) && kotlin.jvm.internal.s.d(this.path, notifyMessageModel.path) && kotlin.jvm.internal.s.d(this.point, notifyMessageModel.point) && kotlin.jvm.internal.s.d(this.systemLabels, notifyMessageModel.systemLabels);
    }

    @Nullable
    public final String getBgColor() {
        return this.bgColor;
    }

    @Nullable
    public final ImageModel getLeftIcon() {
        return this.leftIcon;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    public final int getMessageType() {
        return this.messageType;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    @Nullable
    public final String getPoint() {
        return this.point;
    }

    @Nullable
    public final String getStyle() {
        return this.style;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> getSystemLabels() {
        return this.systemLabels;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        String str = this.message;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.style;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.messageType) * 31;
        User user = this.user;
        int hashCode3 = (hashCode2 + (user == null ? 0 : user.hashCode())) * 31;
        String str3 = this.bgColor;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ImageModel imageModel = this.leftIcon;
        int hashCode5 = (hashCode4 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str4 = this.path;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.point;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<BaseLiveShowTagModel> list = this.systemLabels;
        return hashCode7 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.message;
        String str2 = this.style;
        int i10 = this.messageType;
        User user = this.user;
        String str3 = this.bgColor;
        ImageModel imageModel = this.leftIcon;
        return "NotifyMessageModel(message=" + str + ", style=" + str2 + ", messageType=" + i10 + ", user=" + ((Object) user) + ", bgColor=" + str3 + ", leftIcon=" + ((Object) imageModel) + ", path=" + this.path + ", point=" + this.point + ", systemLabels=" + ((Object) this.systemLabels) + ")";
    }
}
