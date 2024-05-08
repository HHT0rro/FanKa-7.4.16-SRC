package com.cupidapp.live.chat.service;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContactService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class VisitorInfoModel {

    @NotNull
    private final String jumpUrl;
    private final int newVisitorCount;

    @NotNull
    private final ImageModel pretendAvatar;

    @NotNull
    private final String pretendName;
    private final int visitorCount;
    private final boolean visitorEnable;

    public VisitorInfoModel(int i10, int i11, @NotNull String pretendName, @NotNull ImageModel pretendAvatar, boolean z10, @NotNull String jumpUrl) {
        s.i(pretendName, "pretendName");
        s.i(pretendAvatar, "pretendAvatar");
        s.i(jumpUrl, "jumpUrl");
        this.visitorCount = i10;
        this.newVisitorCount = i11;
        this.pretendName = pretendName;
        this.pretendAvatar = pretendAvatar;
        this.visitorEnable = z10;
        this.jumpUrl = jumpUrl;
    }

    public static /* synthetic */ VisitorInfoModel copy$default(VisitorInfoModel visitorInfoModel, int i10, int i11, String str, ImageModel imageModel, boolean z10, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = visitorInfoModel.visitorCount;
        }
        if ((i12 & 2) != 0) {
            i11 = visitorInfoModel.newVisitorCount;
        }
        int i13 = i11;
        if ((i12 & 4) != 0) {
            str = visitorInfoModel.pretendName;
        }
        String str3 = str;
        if ((i12 & 8) != 0) {
            imageModel = visitorInfoModel.pretendAvatar;
        }
        ImageModel imageModel2 = imageModel;
        if ((i12 & 16) != 0) {
            z10 = visitorInfoModel.visitorEnable;
        }
        boolean z11 = z10;
        if ((i12 & 32) != 0) {
            str2 = visitorInfoModel.jumpUrl;
        }
        return visitorInfoModel.copy(i10, i13, str3, imageModel2, z11, str2);
    }

    public final int component1() {
        return this.visitorCount;
    }

    public final int component2() {
        return this.newVisitorCount;
    }

    @NotNull
    public final String component3() {
        return this.pretendName;
    }

    @NotNull
    public final ImageModel component4() {
        return this.pretendAvatar;
    }

    public final boolean component5() {
        return this.visitorEnable;
    }

    @NotNull
    public final String component6() {
        return this.jumpUrl;
    }

    @NotNull
    public final VisitorInfoModel copy(int i10, int i11, @NotNull String pretendName, @NotNull ImageModel pretendAvatar, boolean z10, @NotNull String jumpUrl) {
        s.i(pretendName, "pretendName");
        s.i(pretendAvatar, "pretendAvatar");
        s.i(jumpUrl, "jumpUrl");
        return new VisitorInfoModel(i10, i11, pretendName, pretendAvatar, z10, jumpUrl);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisitorInfoModel)) {
            return false;
        }
        VisitorInfoModel visitorInfoModel = (VisitorInfoModel) obj;
        return this.visitorCount == visitorInfoModel.visitorCount && this.newVisitorCount == visitorInfoModel.newVisitorCount && s.d(this.pretendName, visitorInfoModel.pretendName) && s.d(this.pretendAvatar, visitorInfoModel.pretendAvatar) && this.visitorEnable == visitorInfoModel.visitorEnable && s.d(this.jumpUrl, visitorInfoModel.jumpUrl);
    }

    @NotNull
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final int getNewVisitorCount() {
        return this.newVisitorCount;
    }

    @NotNull
    public final ImageModel getPretendAvatar() {
        return this.pretendAvatar;
    }

    @NotNull
    public final String getPretendName() {
        return this.pretendName;
    }

    public final int getVisitorCount() {
        return this.visitorCount;
    }

    public final boolean getVisitorEnable() {
        return this.visitorEnable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.visitorCount * 31) + this.newVisitorCount) * 31) + this.pretendName.hashCode()) * 31) + this.pretendAvatar.hashCode()) * 31;
        boolean z10 = this.visitorEnable;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return ((hashCode + i10) * 31) + this.jumpUrl.hashCode();
    }

    @NotNull
    public String toString() {
        int i10 = this.visitorCount;
        int i11 = this.newVisitorCount;
        String str = this.pretendName;
        ImageModel imageModel = this.pretendAvatar;
        return "VisitorInfoModel(visitorCount=" + i10 + ", newVisitorCount=" + i11 + ", pretendName=" + str + ", pretendAvatar=" + ((Object) imageModel) + ", visitorEnable=" + this.visitorEnable + ", jumpUrl=" + this.jumpUrl + ")";
    }

    public /* synthetic */ VisitorInfoModel(int i10, int i11, String str, ImageModel imageModel, boolean z10, String str2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, i11, str, imageModel, (i12 & 16) != 0 ? false : z10, str2);
    }
}
