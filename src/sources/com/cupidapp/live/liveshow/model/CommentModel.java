package com.cupidapp.live.liveshow.model;

import b2.a;
import com.cupidapp.live.base.network.gson.BaseLiveShowTagModel;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveCommentResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CommentModel implements Serializable {

    @Nullable
    private final String backgroundColor;
    private final boolean barrage;

    @Nullable
    private final List<BaseLiveShowTagModel> barrageLabels;

    @Nullable
    private final String borderColor;

    @Nullable
    private final String commentColor;
    private final long createTimeMillis;

    @Nullable
    private final String endBackgroundColor;

    @Nullable
    private final String endColor;

    @Nullable
    private final ImageModel image;

    @NotNull
    private final String itemId;

    @Nullable
    private final ImageModel leftBottomImage;

    @Nullable
    private final ImageModel leftTopImage;

    @Nullable
    private final List<BaseLiveShowTagModel> liveCommentLabels;

    @NotNull
    private final String message;

    @Nullable
    private final String nameColor;

    @Nullable
    private final String reportData;

    @Nullable
    private final ImageModel rightBottomImage;

    @Nullable
    private final ImageModel rightTopImage;

    @Nullable
    private final String startBackgroundColor;

    @Nullable
    private final String startColor;

    @Nullable
    private final User user;

    /* JADX WARN: Multi-variable type inference failed */
    public CommentModel(long j10, @NotNull String itemId, @NotNull String message, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable User user, @Nullable List<? extends BaseLiveShowTagModel> list, @Nullable List<? extends BaseLiveShowTagModel> list2, @Nullable ImageModel imageModel, boolean z10, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable ImageModel imageModel2, @Nullable ImageModel imageModel3, @Nullable ImageModel imageModel4, @Nullable ImageModel imageModel5, @Nullable String str9) {
        s.i(itemId, "itemId");
        s.i(message, "message");
        this.createTimeMillis = j10;
        this.itemId = itemId;
        this.message = message;
        this.nameColor = str;
        this.commentColor = str2;
        this.backgroundColor = str3;
        this.user = user;
        this.liveCommentLabels = list;
        this.barrageLabels = list2;
        this.image = imageModel;
        this.barrage = z10;
        this.startColor = str4;
        this.endColor = str5;
        this.startBackgroundColor = str6;
        this.endBackgroundColor = str7;
        this.borderColor = str8;
        this.leftTopImage = imageModel2;
        this.rightTopImage = imageModel3;
        this.leftBottomImage = imageModel4;
        this.rightBottomImage = imageModel5;
        this.reportData = str9;
    }

    public final long component1() {
        return this.createTimeMillis;
    }

    @Nullable
    public final ImageModel component10() {
        return this.image;
    }

    public final boolean component11() {
        return this.barrage;
    }

    @Nullable
    public final String component12() {
        return this.startColor;
    }

    @Nullable
    public final String component13() {
        return this.endColor;
    }

    @Nullable
    public final String component14() {
        return this.startBackgroundColor;
    }

    @Nullable
    public final String component15() {
        return this.endBackgroundColor;
    }

    @Nullable
    public final String component16() {
        return this.borderColor;
    }

    @Nullable
    public final ImageModel component17() {
        return this.leftTopImage;
    }

    @Nullable
    public final ImageModel component18() {
        return this.rightTopImage;
    }

    @Nullable
    public final ImageModel component19() {
        return this.leftBottomImage;
    }

    @NotNull
    public final String component2() {
        return this.itemId;
    }

    @Nullable
    public final ImageModel component20() {
        return this.rightBottomImage;
    }

    @Nullable
    public final String component21() {
        return this.reportData;
    }

    @NotNull
    public final String component3() {
        return this.message;
    }

    @Nullable
    public final String component4() {
        return this.nameColor;
    }

    @Nullable
    public final String component5() {
        return this.commentColor;
    }

    @Nullable
    public final String component6() {
        return this.backgroundColor;
    }

    @Nullable
    public final User component7() {
        return this.user;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> component8() {
        return this.liveCommentLabels;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> component9() {
        return this.barrageLabels;
    }

    @NotNull
    public final CommentModel copy(long j10, @NotNull String itemId, @NotNull String message, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable User user, @Nullable List<? extends BaseLiveShowTagModel> list, @Nullable List<? extends BaseLiveShowTagModel> list2, @Nullable ImageModel imageModel, boolean z10, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable ImageModel imageModel2, @Nullable ImageModel imageModel3, @Nullable ImageModel imageModel4, @Nullable ImageModel imageModel5, @Nullable String str9) {
        s.i(itemId, "itemId");
        s.i(message, "message");
        return new CommentModel(j10, itemId, message, str, str2, str3, user, list, list2, imageModel, z10, str4, str5, str6, str7, str8, imageModel2, imageModel3, imageModel4, imageModel5, str9);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentModel)) {
            return false;
        }
        CommentModel commentModel = (CommentModel) obj;
        return this.createTimeMillis == commentModel.createTimeMillis && s.d(this.itemId, commentModel.itemId) && s.d(this.message, commentModel.message) && s.d(this.nameColor, commentModel.nameColor) && s.d(this.commentColor, commentModel.commentColor) && s.d(this.backgroundColor, commentModel.backgroundColor) && s.d(this.user, commentModel.user) && s.d(this.liveCommentLabels, commentModel.liveCommentLabels) && s.d(this.barrageLabels, commentModel.barrageLabels) && s.d(this.image, commentModel.image) && this.barrage == commentModel.barrage && s.d(this.startColor, commentModel.startColor) && s.d(this.endColor, commentModel.endColor) && s.d(this.startBackgroundColor, commentModel.startBackgroundColor) && s.d(this.endBackgroundColor, commentModel.endBackgroundColor) && s.d(this.borderColor, commentModel.borderColor) && s.d(this.leftTopImage, commentModel.leftTopImage) && s.d(this.rightTopImage, commentModel.rightTopImage) && s.d(this.leftBottomImage, commentModel.leftBottomImage) && s.d(this.rightBottomImage, commentModel.rightBottomImage) && s.d(this.reportData, commentModel.reportData);
    }

    @Nullable
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final boolean getBarrage() {
        return this.barrage;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> getBarrageLabels() {
        return this.barrageLabels;
    }

    @Nullable
    public final String getBorderColor() {
        return this.borderColor;
    }

    @Nullable
    public final String getCommentColor() {
        return this.commentColor;
    }

    public final long getCreateTimeMillis() {
        return this.createTimeMillis;
    }

    @Nullable
    public final String getEndBackgroundColor() {
        return this.endBackgroundColor;
    }

    @Nullable
    public final String getEndColor() {
        return this.endColor;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    public final ImageModel getLeftBottomImage() {
        return this.leftBottomImage;
    }

    @Nullable
    public final ImageModel getLeftTopImage() {
        return this.leftTopImage;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> getLiveCommentLabels() {
        return this.liveCommentLabels;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getNameColor() {
        return this.nameColor;
    }

    @Nullable
    public final String getReportData() {
        return this.reportData;
    }

    @Nullable
    public final ImageModel getRightBottomImage() {
        return this.rightBottomImage;
    }

    @Nullable
    public final ImageModel getRightTopImage() {
        return this.rightTopImage;
    }

    @Nullable
    public final String getStartBackgroundColor() {
        return this.startBackgroundColor;
    }

    @Nullable
    public final String getStartColor() {
        return this.startColor;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a10 = ((((a.a(this.createTimeMillis) * 31) + this.itemId.hashCode()) * 31) + this.message.hashCode()) * 31;
        String str = this.nameColor;
        int hashCode = (a10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.commentColor;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.backgroundColor;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        User user = this.user;
        int hashCode4 = (hashCode3 + (user == null ? 0 : user.hashCode())) * 31;
        List<BaseLiveShowTagModel> list = this.liveCommentLabels;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        List<BaseLiveShowTagModel> list2 = this.barrageLabels;
        int hashCode6 = (hashCode5 + (list2 == null ? 0 : list2.hashCode())) * 31;
        ImageModel imageModel = this.image;
        int hashCode7 = (hashCode6 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        boolean z10 = this.barrage;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode7 + i10) * 31;
        String str4 = this.startColor;
        int hashCode8 = (i11 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.endColor;
        int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.startBackgroundColor;
        int hashCode10 = (hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.endBackgroundColor;
        int hashCode11 = (hashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.borderColor;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        ImageModel imageModel2 = this.leftTopImage;
        int hashCode13 = (hashCode12 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        ImageModel imageModel3 = this.rightTopImage;
        int hashCode14 = (hashCode13 + (imageModel3 == null ? 0 : imageModel3.hashCode())) * 31;
        ImageModel imageModel4 = this.leftBottomImage;
        int hashCode15 = (hashCode14 + (imageModel4 == null ? 0 : imageModel4.hashCode())) * 31;
        ImageModel imageModel5 = this.rightBottomImage;
        int hashCode16 = (hashCode15 + (imageModel5 == null ? 0 : imageModel5.hashCode())) * 31;
        String str9 = this.reportData;
        return hashCode16 + (str9 != null ? str9.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        long j10 = this.createTimeMillis;
        String str = this.itemId;
        String str2 = this.message;
        String str3 = this.nameColor;
        String str4 = this.commentColor;
        String str5 = this.backgroundColor;
        User user = this.user;
        List<BaseLiveShowTagModel> list = this.liveCommentLabels;
        List<BaseLiveShowTagModel> list2 = this.barrageLabels;
        ImageModel imageModel = this.image;
        boolean z10 = this.barrage;
        String str6 = this.startColor;
        String str7 = this.endColor;
        String str8 = this.startBackgroundColor;
        String str9 = this.endBackgroundColor;
        String str10 = this.borderColor;
        ImageModel imageModel2 = this.leftTopImage;
        ImageModel imageModel3 = this.rightTopImage;
        ImageModel imageModel4 = this.leftBottomImage;
        ImageModel imageModel5 = this.rightBottomImage;
        return "CommentModel(createTimeMillis=" + j10 + ", itemId=" + str + ", message=" + str2 + ", nameColor=" + str3 + ", commentColor=" + str4 + ", backgroundColor=" + str5 + ", user=" + ((Object) user) + ", liveCommentLabels=" + ((Object) list) + ", barrageLabels=" + ((Object) list2) + ", image=" + ((Object) imageModel) + ", barrage=" + z10 + ", startColor=" + str6 + ", endColor=" + str7 + ", startBackgroundColor=" + str8 + ", endBackgroundColor=" + str9 + ", borderColor=" + str10 + ", leftTopImage=" + ((Object) imageModel2) + ", rightTopImage=" + ((Object) imageModel3) + ", leftBottomImage=" + ((Object) imageModel4) + ", rightBottomImage=" + ((Object) imageModel5) + ", reportData=" + this.reportData + ")";
    }

    public /* synthetic */ CommentModel(long j10, String str, String str2, String str3, String str4, String str5, User user, List list, List list2, ImageModel imageModel, boolean z10, String str6, String str7, String str8, String str9, String str10, ImageModel imageModel2, ImageModel imageModel3, ImageModel imageModel4, ImageModel imageModel5, String str11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(j10, str, str2, str3, str4, str5, user, list, list2, imageModel, z10, str6, str7, str8, str9, str10, imageModel2, imageModel3, imageModel4, imageModel5, (i10 & 1048576) != 0 ? null : str11);
    }
}
