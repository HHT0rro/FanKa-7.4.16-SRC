package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkInfoModel implements Serializable {

    @NotNull
    private final List<MultiPkAnchorInfoModel> anchors;

    @Nullable
    private final Integer countdownSeconds;

    @NotNull
    private final String jumpUrl;

    @NotNull
    private final String mixStreamId;

    @Nullable
    private final String pkPairId;
    private final boolean showBorder;

    @NotNull
    private final String stage;

    @Nullable
    private final Long startTimeMills;

    public MultiPkInfoModel(@NotNull String stage, @NotNull String mixStreamId, @Nullable Integer num, @Nullable Long l10, @NotNull String jumpUrl, @Nullable String str, @NotNull List<MultiPkAnchorInfoModel> anchors, boolean z10) {
        s.i(stage, "stage");
        s.i(mixStreamId, "mixStreamId");
        s.i(jumpUrl, "jumpUrl");
        s.i(anchors, "anchors");
        this.stage = stage;
        this.mixStreamId = mixStreamId;
        this.countdownSeconds = num;
        this.startTimeMills = l10;
        this.jumpUrl = jumpUrl;
        this.pkPairId = str;
        this.anchors = anchors;
        this.showBorder = z10;
    }

    @NotNull
    public final String component1() {
        return this.stage;
    }

    @NotNull
    public final String component2() {
        return this.mixStreamId;
    }

    @Nullable
    public final Integer component3() {
        return this.countdownSeconds;
    }

    @Nullable
    public final Long component4() {
        return this.startTimeMills;
    }

    @NotNull
    public final String component5() {
        return this.jumpUrl;
    }

    @Nullable
    public final String component6() {
        return this.pkPairId;
    }

    @NotNull
    public final List<MultiPkAnchorInfoModel> component7() {
        return this.anchors;
    }

    public final boolean component8() {
        return this.showBorder;
    }

    @NotNull
    public final MultiPkInfoModel copy(@NotNull String stage, @NotNull String mixStreamId, @Nullable Integer num, @Nullable Long l10, @NotNull String jumpUrl, @Nullable String str, @NotNull List<MultiPkAnchorInfoModel> anchors, boolean z10) {
        s.i(stage, "stage");
        s.i(mixStreamId, "mixStreamId");
        s.i(jumpUrl, "jumpUrl");
        s.i(anchors, "anchors");
        return new MultiPkInfoModel(stage, mixStreamId, num, l10, jumpUrl, str, anchors, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiPkInfoModel)) {
            return false;
        }
        MultiPkInfoModel multiPkInfoModel = (MultiPkInfoModel) obj;
        return s.d(this.stage, multiPkInfoModel.stage) && s.d(this.mixStreamId, multiPkInfoModel.mixStreamId) && s.d(this.countdownSeconds, multiPkInfoModel.countdownSeconds) && s.d(this.startTimeMills, multiPkInfoModel.startTimeMills) && s.d(this.jumpUrl, multiPkInfoModel.jumpUrl) && s.d(this.pkPairId, multiPkInfoModel.pkPairId) && s.d(this.anchors, multiPkInfoModel.anchors) && this.showBorder == multiPkInfoModel.showBorder;
    }

    @NotNull
    public final List<MultiPkAnchorInfoModel> getAnchors() {
        return this.anchors;
    }

    @Nullable
    public final Integer getCountdownSeconds() {
        return this.countdownSeconds;
    }

    @NotNull
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    public final String getMixStreamId() {
        return this.mixStreamId;
    }

    @Nullable
    public final String getPkPairId() {
        return this.pkPairId;
    }

    public final boolean getShowBorder() {
        return this.showBorder;
    }

    @NotNull
    public final String getStage() {
        return this.stage;
    }

    @Nullable
    public final Long getStartTimeMills() {
        return this.startTimeMills;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.stage.hashCode() * 31) + this.mixStreamId.hashCode()) * 31;
        Integer num = this.countdownSeconds;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Long l10 = this.startTimeMills;
        int hashCode3 = (((hashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31) + this.jumpUrl.hashCode()) * 31;
        String str = this.pkPairId;
        int hashCode4 = (((hashCode3 + (str != null ? str.hashCode() : 0)) * 31) + this.anchors.hashCode()) * 31;
        boolean z10 = this.showBorder;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode4 + i10;
    }

    @NotNull
    public String toString() {
        String str = this.stage;
        String str2 = this.mixStreamId;
        Integer num = this.countdownSeconds;
        Long l10 = this.startTimeMills;
        String str3 = this.jumpUrl;
        String str4 = this.pkPairId;
        List<MultiPkAnchorInfoModel> list = this.anchors;
        return "MultiPkInfoModel(stage=" + str + ", mixStreamId=" + str2 + ", countdownSeconds=" + ((Object) num) + ", startTimeMills=" + ((Object) l10) + ", jumpUrl=" + str3 + ", pkPairId=" + str4 + ", anchors=" + ((Object) list) + ", showBorder=" + this.showBorder + ")";
    }
}
