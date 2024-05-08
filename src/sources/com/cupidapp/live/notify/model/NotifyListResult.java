package com.cupidapp.live.notify.model;

import com.cupidapp.live.appdialog.model.AppDialogModel;
import com.cupidapp.live.base.network.model.ImageModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NotifyListResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NotifyListResult<T> {
    private final int alohaGetCount;

    @Nullable
    private final Boolean avatarWindowTipShow;

    @Nullable
    private String buttonContent;

    @Nullable
    private ImageModel closeFriendDefaultImage;

    @Nullable
    private String filtrateSpammerToast;

    @Nullable
    private String guideContent;

    @Nullable
    private String jumpInfo;

    @Nullable
    private String leftTime;

    @Nullable
    private List<T> list;
    private int mosaicNum;

    @Nullable
    private String nextCursorId;

    @Nullable
    private final NotifyPopupInfoModel popupInfo;
    private final boolean svipRequired;

    @Nullable
    private final String title;

    @NotNull
    private String type;

    @Nullable
    private final List<AppDialogModel> windows;

    /* JADX WARN: Multi-variable type inference failed */
    public NotifyListResult(@Nullable List<T> list, @NotNull String type, @Nullable String str, int i10, @Nullable List<? extends AppDialogModel> list2, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable ImageModel imageModel, int i11, @Nullable String str6, boolean z10, @Nullable String str7, @Nullable Boolean bool, @Nullable NotifyPopupInfoModel notifyPopupInfoModel) {
        s.i(type, "type");
        this.list = list;
        this.type = type;
        this.nextCursorId = str;
        this.alohaGetCount = i10;
        this.windows = list2;
        this.guideContent = str2;
        this.buttonContent = str3;
        this.jumpInfo = str4;
        this.filtrateSpammerToast = str5;
        this.closeFriendDefaultImage = imageModel;
        this.mosaicNum = i11;
        this.leftTime = str6;
        this.svipRequired = z10;
        this.title = str7;
        this.avatarWindowTipShow = bool;
        this.popupInfo = notifyPopupInfoModel;
    }

    @Nullable
    public final List<T> component1() {
        return this.list;
    }

    @Nullable
    public final ImageModel component10() {
        return this.closeFriendDefaultImage;
    }

    public final int component11() {
        return this.mosaicNum;
    }

    @Nullable
    public final String component12() {
        return this.leftTime;
    }

    public final boolean component13() {
        return this.svipRequired;
    }

    @Nullable
    public final String component14() {
        return this.title;
    }

    @Nullable
    public final Boolean component15() {
        return this.avatarWindowTipShow;
    }

    @Nullable
    public final NotifyPopupInfoModel component16() {
        return this.popupInfo;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    @Nullable
    public final String component3() {
        return this.nextCursorId;
    }

    public final int component4() {
        return this.alohaGetCount;
    }

    @Nullable
    public final List<AppDialogModel> component5() {
        return this.windows;
    }

    @Nullable
    public final String component6() {
        return this.guideContent;
    }

    @Nullable
    public final String component7() {
        return this.buttonContent;
    }

    @Nullable
    public final String component8() {
        return this.jumpInfo;
    }

    @Nullable
    public final String component9() {
        return this.filtrateSpammerToast;
    }

    @NotNull
    public final NotifyListResult<T> copy(@Nullable List<T> list, @NotNull String type, @Nullable String str, int i10, @Nullable List<? extends AppDialogModel> list2, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable ImageModel imageModel, int i11, @Nullable String str6, boolean z10, @Nullable String str7, @Nullable Boolean bool, @Nullable NotifyPopupInfoModel notifyPopupInfoModel) {
        s.i(type, "type");
        return new NotifyListResult<>(list, type, str, i10, list2, str2, str3, str4, str5, imageModel, i11, str6, z10, str7, bool, notifyPopupInfoModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotifyListResult)) {
            return false;
        }
        NotifyListResult notifyListResult = (NotifyListResult) obj;
        return s.d(this.list, notifyListResult.list) && s.d(this.type, notifyListResult.type) && s.d(this.nextCursorId, notifyListResult.nextCursorId) && this.alohaGetCount == notifyListResult.alohaGetCount && s.d(this.windows, notifyListResult.windows) && s.d(this.guideContent, notifyListResult.guideContent) && s.d(this.buttonContent, notifyListResult.buttonContent) && s.d(this.jumpInfo, notifyListResult.jumpInfo) && s.d(this.filtrateSpammerToast, notifyListResult.filtrateSpammerToast) && s.d(this.closeFriendDefaultImage, notifyListResult.closeFriendDefaultImage) && this.mosaicNum == notifyListResult.mosaicNum && s.d(this.leftTime, notifyListResult.leftTime) && this.svipRequired == notifyListResult.svipRequired && s.d(this.title, notifyListResult.title) && s.d(this.avatarWindowTipShow, notifyListResult.avatarWindowTipShow) && s.d(this.popupInfo, notifyListResult.popupInfo);
    }

    public final int getAlohaGetCount() {
        return this.alohaGetCount;
    }

    @Nullable
    public final Boolean getAvatarWindowTipShow() {
        return this.avatarWindowTipShow;
    }

    @Nullable
    public final String getButtonContent() {
        return this.buttonContent;
    }

    @Nullable
    public final ImageModel getCloseFriendDefaultImage() {
        return this.closeFriendDefaultImage;
    }

    @Nullable
    public final String getFiltrateSpammerToast() {
        return this.filtrateSpammerToast;
    }

    @Nullable
    public final String getGuideContent() {
        return this.guideContent;
    }

    @Nullable
    public final String getJumpInfo() {
        return this.jumpInfo;
    }

    @Nullable
    public final String getLeftTime() {
        return this.leftTime;
    }

    @Nullable
    public final List<T> getList() {
        return this.list;
    }

    public final int getMosaicNum() {
        return this.mosaicNum;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    @Nullable
    public final NotifyPopupInfoModel getPopupInfo() {
        return this.popupInfo;
    }

    public final boolean getSvipRequired() {
        return this.svipRequired;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final List<AppDialogModel> getWindows() {
        return this.windows;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<T> list = this.list;
        int hashCode = (((list == null ? 0 : list.hashCode()) * 31) + this.type.hashCode()) * 31;
        String str = this.nextCursorId;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.alohaGetCount) * 31;
        List<AppDialogModel> list2 = this.windows;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.guideContent;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.buttonContent;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.jumpInfo;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.filtrateSpammerToast;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        ImageModel imageModel = this.closeFriendDefaultImage;
        int hashCode8 = (((hashCode7 + (imageModel == null ? 0 : imageModel.hashCode())) * 31) + this.mosaicNum) * 31;
        String str6 = this.leftTime;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        boolean z10 = this.svipRequired;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode9 + i10) * 31;
        String str7 = this.title;
        int hashCode10 = (i11 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Boolean bool = this.avatarWindowTipShow;
        int hashCode11 = (hashCode10 + (bool == null ? 0 : bool.hashCode())) * 31;
        NotifyPopupInfoModel notifyPopupInfoModel = this.popupInfo;
        return hashCode11 + (notifyPopupInfoModel != null ? notifyPopupInfoModel.hashCode() : 0);
    }

    public final void setButtonContent(@Nullable String str) {
        this.buttonContent = str;
    }

    public final void setCloseFriendDefaultImage(@Nullable ImageModel imageModel) {
        this.closeFriendDefaultImage = imageModel;
    }

    public final void setFiltrateSpammerToast(@Nullable String str) {
        this.filtrateSpammerToast = str;
    }

    public final void setGuideContent(@Nullable String str) {
        this.guideContent = str;
    }

    public final void setJumpInfo(@Nullable String str) {
        this.jumpInfo = str;
    }

    public final void setLeftTime(@Nullable String str) {
        this.leftTime = str;
    }

    public final void setList(@Nullable List<T> list) {
        this.list = list;
    }

    public final void setMosaicNum(int i10) {
        this.mosaicNum = i10;
    }

    public final void setNextCursorId(@Nullable String str) {
        this.nextCursorId = str;
    }

    public final void setType(@NotNull String str) {
        s.i(str, "<set-?>");
        this.type = str;
    }

    @NotNull
    public String toString() {
        List<T> list = this.list;
        String str = this.type;
        String str2 = this.nextCursorId;
        int i10 = this.alohaGetCount;
        List<AppDialogModel> list2 = this.windows;
        String str3 = this.guideContent;
        String str4 = this.buttonContent;
        String str5 = this.jumpInfo;
        String str6 = this.filtrateSpammerToast;
        ImageModel imageModel = this.closeFriendDefaultImage;
        return "NotifyListResult(list=" + ((Object) list) + ", type=" + str + ", nextCursorId=" + str2 + ", alohaGetCount=" + i10 + ", windows=" + ((Object) list2) + ", guideContent=" + str3 + ", buttonContent=" + str4 + ", jumpInfo=" + str5 + ", filtrateSpammerToast=" + str6 + ", closeFriendDefaultImage=" + ((Object) imageModel) + ", mosaicNum=" + this.mosaicNum + ", leftTime=" + this.leftTime + ", svipRequired=" + this.svipRequired + ", title=" + this.title + ", avatarWindowTipShow=" + ((Object) this.avatarWindowTipShow) + ", popupInfo=" + ((Object) this.popupInfo) + ")";
    }

    public /* synthetic */ NotifyListResult(List list, String str, String str2, int i10, List list2, String str3, String str4, String str5, String str6, ImageModel imageModel, int i11, String str7, boolean z10, String str8, Boolean bool, NotifyPopupInfoModel notifyPopupInfoModel, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, str2, (i12 & 8) != 0 ? 0 : i10, list2, str3, str4, str5, str6, imageModel, (i12 & 1024) != 0 ? 2 : i11, str7, (i12 & 4096) != 0 ? false : z10, (i12 & 8192) != 0 ? null : str8, bool, notifyPopupInfoModel);
    }
}
