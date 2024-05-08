package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveHornLinkModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveHornModel {
    private boolean animatorEnd;
    private boolean animatorStart;

    @NotNull
    private final String backgroundUrl;

    @Nullable
    private Integer bigHornSurplusTime;

    @NotNull
    private final String content;
    private final int hornCode;

    @Nullable
    private final FKLiveHornLinkModel liveInner;

    @Nullable
    private final FKLiveHornLinkModel liveOuter;
    private final int loopCount;

    @Nullable
    private final String scene;

    @NotNull
    private final String style;
    private final int suspTime;
    private final int type;

    public FKLiveHornModel(int i10, @NotNull String style, int i11, int i12, int i13, @NotNull String backgroundUrl, @NotNull String content, @Nullable String str, @Nullable FKLiveHornLinkModel fKLiveHornLinkModel, @Nullable FKLiveHornLinkModel fKLiveHornLinkModel2, boolean z10, boolean z11, @Nullable Integer num) {
        s.i(style, "style");
        s.i(backgroundUrl, "backgroundUrl");
        s.i(content, "content");
        this.type = i10;
        this.style = style;
        this.hornCode = i11;
        this.suspTime = i12;
        this.loopCount = i13;
        this.backgroundUrl = backgroundUrl;
        this.content = content;
        this.scene = str;
        this.liveInner = fKLiveHornLinkModel;
        this.liveOuter = fKLiveHornLinkModel2;
        this.animatorEnd = z10;
        this.animatorStart = z11;
        this.bigHornSurplusTime = num;
    }

    public final int component1() {
        return this.type;
    }

    @Nullable
    public final FKLiveHornLinkModel component10() {
        return this.liveOuter;
    }

    public final boolean component11() {
        return this.animatorEnd;
    }

    public final boolean component12() {
        return this.animatorStart;
    }

    @Nullable
    public final Integer component13() {
        return this.bigHornSurplusTime;
    }

    @NotNull
    public final String component2() {
        return this.style;
    }

    public final int component3() {
        return this.hornCode;
    }

    public final int component4() {
        return this.suspTime;
    }

    public final int component5() {
        return this.loopCount;
    }

    @NotNull
    public final String component6() {
        return this.backgroundUrl;
    }

    @NotNull
    public final String component7() {
        return this.content;
    }

    @Nullable
    public final String component8() {
        return this.scene;
    }

    @Nullable
    public final FKLiveHornLinkModel component9() {
        return this.liveInner;
    }

    @NotNull
    public final FKLiveHornModel copy(int i10, @NotNull String style, int i11, int i12, int i13, @NotNull String backgroundUrl, @NotNull String content, @Nullable String str, @Nullable FKLiveHornLinkModel fKLiveHornLinkModel, @Nullable FKLiveHornLinkModel fKLiveHornLinkModel2, boolean z10, boolean z11, @Nullable Integer num) {
        s.i(style, "style");
        s.i(backgroundUrl, "backgroundUrl");
        s.i(content, "content");
        return new FKLiveHornModel(i10, style, i11, i12, i13, backgroundUrl, content, str, fKLiveHornLinkModel, fKLiveHornLinkModel2, z10, z11, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKLiveHornModel)) {
            return false;
        }
        FKLiveHornModel fKLiveHornModel = (FKLiveHornModel) obj;
        return this.type == fKLiveHornModel.type && s.d(this.style, fKLiveHornModel.style) && this.hornCode == fKLiveHornModel.hornCode && this.suspTime == fKLiveHornModel.suspTime && this.loopCount == fKLiveHornModel.loopCount && s.d(this.backgroundUrl, fKLiveHornModel.backgroundUrl) && s.d(this.content, fKLiveHornModel.content) && s.d(this.scene, fKLiveHornModel.scene) && s.d(this.liveInner, fKLiveHornModel.liveInner) && s.d(this.liveOuter, fKLiveHornModel.liveOuter) && this.animatorEnd == fKLiveHornModel.animatorEnd && this.animatorStart == fKLiveHornModel.animatorStart && s.d(this.bigHornSurplusTime, fKLiveHornModel.bigHornSurplusTime);
    }

    public final boolean getAnimatorEnd() {
        return this.animatorEnd;
    }

    public final boolean getAnimatorStart() {
        return this.animatorStart;
    }

    @NotNull
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    @Nullable
    public final Integer getBigHornSurplusTime() {
        return this.bigHornSurplusTime;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final int getHornCode() {
        return this.hornCode;
    }

    @Nullable
    public final FKLiveHornLinkModel getLiveInner() {
        return this.liveInner;
    }

    @Nullable
    public final FKLiveHornLinkModel getLiveOuter() {
        return this.liveOuter;
    }

    public final int getLoopCount() {
        return this.loopCount;
    }

    @Nullable
    public final String getScene() {
        return this.scene;
    }

    @NotNull
    public final String getStyle() {
        return this.style;
    }

    public final int getSuspTime() {
        return this.suspTime;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((this.type * 31) + this.style.hashCode()) * 31) + this.hornCode) * 31) + this.suspTime) * 31) + this.loopCount) * 31) + this.backgroundUrl.hashCode()) * 31) + this.content.hashCode()) * 31;
        String str = this.scene;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        FKLiveHornLinkModel fKLiveHornLinkModel = this.liveInner;
        int hashCode3 = (hashCode2 + (fKLiveHornLinkModel == null ? 0 : fKLiveHornLinkModel.hashCode())) * 31;
        FKLiveHornLinkModel fKLiveHornLinkModel2 = this.liveOuter;
        int hashCode4 = (hashCode3 + (fKLiveHornLinkModel2 == null ? 0 : fKLiveHornLinkModel2.hashCode())) * 31;
        boolean z10 = this.animatorEnd;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode4 + i10) * 31;
        boolean z11 = this.animatorStart;
        int i12 = (i11 + (z11 ? 1 : z11 ? 1 : 0)) * 31;
        Integer num = this.bigHornSurplusTime;
        return i12 + (num != null ? num.hashCode() : 0);
    }

    public final void setAnimatorEnd(boolean z10) {
        this.animatorEnd = z10;
    }

    public final void setAnimatorStart(boolean z10) {
        this.animatorStart = z10;
    }

    public final void setBigHornSurplusTime(@Nullable Integer num) {
        this.bigHornSurplusTime = num;
    }

    @NotNull
    public String toString() {
        int i10 = this.type;
        String str = this.style;
        int i11 = this.hornCode;
        int i12 = this.suspTime;
        int i13 = this.loopCount;
        String str2 = this.backgroundUrl;
        String str3 = this.content;
        String str4 = this.scene;
        FKLiveHornLinkModel fKLiveHornLinkModel = this.liveInner;
        FKLiveHornLinkModel fKLiveHornLinkModel2 = this.liveOuter;
        return "FKLiveHornModel(type=" + i10 + ", style=" + str + ", hornCode=" + i11 + ", suspTime=" + i12 + ", loopCount=" + i13 + ", backgroundUrl=" + str2 + ", content=" + str3 + ", scene=" + str4 + ", liveInner=" + ((Object) fKLiveHornLinkModel) + ", liveOuter=" + ((Object) fKLiveHornLinkModel2) + ", animatorEnd=" + this.animatorEnd + ", animatorStart=" + this.animatorStart + ", bigHornSurplusTime=" + ((Object) this.bigHornSurplusTime) + ")";
    }

    public /* synthetic */ FKLiveHornModel(int i10, String str, int i11, int i12, int i13, String str2, String str3, String str4, FKLiveHornLinkModel fKLiveHornLinkModel, FKLiveHornLinkModel fKLiveHornLinkModel2, boolean z10, boolean z11, Integer num, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, str, i11, i12, i13, str2, str3, str4, (i14 & 256) != 0 ? null : fKLiveHornLinkModel, (i14 & 512) != 0 ? null : fKLiveHornLinkModel2, (i14 & 1024) != 0 ? false : z10, (i14 & 2048) != 0 ? false : z11, (i14 & 4096) != 0 ? null : num);
    }
}
