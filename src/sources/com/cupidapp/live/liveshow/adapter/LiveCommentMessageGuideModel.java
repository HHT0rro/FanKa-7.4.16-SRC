package com.cupidapp.live.liveshow.adapter;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.liveshow.model.LiveCommentGuideType;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveCommentAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveCommentMessageGuideModel implements FKLiveMessageViewModel {

    @Nullable
    private final List<Integer> bgColor;
    private final boolean canClick;

    @Nullable
    private final Integer icon;

    @Nullable
    private final ImageModel iconImage;

    @Nullable
    private final String message;

    @NotNull
    private final LiveCommentGuideType messageType;

    @Nullable
    private final String url;

    public LiveCommentMessageGuideModel(@Nullable Integer num, @Nullable String str, @Nullable List<Integer> list, @NotNull LiveCommentGuideType messageType, @Nullable ImageModel imageModel, @Nullable String str2, boolean z10) {
        s.i(messageType, "messageType");
        this.icon = num;
        this.message = str;
        this.bgColor = list;
        this.messageType = messageType;
        this.iconImage = imageModel;
        this.url = str2;
        this.canClick = z10;
    }

    public static /* synthetic */ LiveCommentMessageGuideModel copy$default(LiveCommentMessageGuideModel liveCommentMessageGuideModel, Integer num, String str, List list, LiveCommentGuideType liveCommentGuideType, ImageModel imageModel, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = liveCommentMessageGuideModel.icon;
        }
        if ((i10 & 2) != 0) {
            str = liveCommentMessageGuideModel.message;
        }
        String str3 = str;
        if ((i10 & 4) != 0) {
            list = liveCommentMessageGuideModel.bgColor;
        }
        List list2 = list;
        if ((i10 & 8) != 0) {
            liveCommentGuideType = liveCommentMessageGuideModel.messageType;
        }
        LiveCommentGuideType liveCommentGuideType2 = liveCommentGuideType;
        if ((i10 & 16) != 0) {
            imageModel = liveCommentMessageGuideModel.iconImage;
        }
        ImageModel imageModel2 = imageModel;
        if ((i10 & 32) != 0) {
            str2 = liveCommentMessageGuideModel.url;
        }
        String str4 = str2;
        if ((i10 & 64) != 0) {
            z10 = liveCommentMessageGuideModel.canClick;
        }
        return liveCommentMessageGuideModel.copy(num, str3, list2, liveCommentGuideType2, imageModel2, str4, z10);
    }

    @Nullable
    public final Integer component1() {
        return this.icon;
    }

    @Nullable
    public final String component2() {
        return this.message;
    }

    @Nullable
    public final List<Integer> component3() {
        return this.bgColor;
    }

    @NotNull
    public final LiveCommentGuideType component4() {
        return this.messageType;
    }

    @Nullable
    public final ImageModel component5() {
        return this.iconImage;
    }

    @Nullable
    public final String component6() {
        return this.url;
    }

    public final boolean component7() {
        return this.canClick;
    }

    @NotNull
    public final LiveCommentMessageGuideModel copy(@Nullable Integer num, @Nullable String str, @Nullable List<Integer> list, @NotNull LiveCommentGuideType messageType, @Nullable ImageModel imageModel, @Nullable String str2, boolean z10) {
        s.i(messageType, "messageType");
        return new LiveCommentMessageGuideModel(num, str, list, messageType, imageModel, str2, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveCommentMessageGuideModel)) {
            return false;
        }
        LiveCommentMessageGuideModel liveCommentMessageGuideModel = (LiveCommentMessageGuideModel) obj;
        return s.d(this.icon, liveCommentMessageGuideModel.icon) && s.d(this.message, liveCommentMessageGuideModel.message) && s.d(this.bgColor, liveCommentMessageGuideModel.bgColor) && this.messageType == liveCommentMessageGuideModel.messageType && s.d(this.iconImage, liveCommentMessageGuideModel.iconImage) && s.d(this.url, liveCommentMessageGuideModel.url) && this.canClick == liveCommentMessageGuideModel.canClick;
    }

    @Nullable
    public final List<Integer> getBgColor() {
        return this.bgColor;
    }

    public final boolean getCanClick() {
        return this.canClick;
    }

    @Nullable
    public final Integer getIcon() {
        return this.icon;
    }

    @Nullable
    public final ImageModel getIconImage() {
        return this.iconImage;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final LiveCommentGuideType getMessageType() {
        return this.messageType;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Integer num = this.icon;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.message;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<Integer> list = this.bgColor;
        int hashCode3 = (((hashCode2 + (list == null ? 0 : list.hashCode())) * 31) + this.messageType.hashCode()) * 31;
        ImageModel imageModel = this.iconImage;
        int hashCode4 = (hashCode3 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str2 = this.url;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z10 = this.canClick;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode5 + i10;
    }

    @NotNull
    public String toString() {
        Integer num = this.icon;
        String str = this.message;
        List<Integer> list = this.bgColor;
        LiveCommentGuideType liveCommentGuideType = this.messageType;
        ImageModel imageModel = this.iconImage;
        return "LiveCommentMessageGuideModel(icon=" + ((Object) num) + ", message=" + str + ", bgColor=" + ((Object) list) + ", messageType=" + ((Object) liveCommentGuideType) + ", iconImage=" + ((Object) imageModel) + ", url=" + this.url + ", canClick=" + this.canClick + ")";
    }

    public /* synthetic */ LiveCommentMessageGuideModel(Integer num, String str, List list, LiveCommentGuideType liveCommentGuideType, ImageModel imageModel, String str2, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, str, list, liveCommentGuideType, (i10 & 16) != 0 ? null : imageModel, (i10 & 32) != 0 ? null : str2, (i10 & 64) != 0 ? true : z10);
    }
}
