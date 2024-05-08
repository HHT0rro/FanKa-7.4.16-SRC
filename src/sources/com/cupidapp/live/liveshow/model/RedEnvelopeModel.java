package com.cupidapp.live.liveshow.model;

import b2.a;
import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RedEnvelopeModel implements Serializable {
    private final int countdownSeconds;

    @NotNull
    private final String entranceUrl;

    @NotNull
    private final ImageModel redPacketIcon;

    @NotNull
    private final String redPacketId;

    @NotNull
    private final ImageModel redPacketOpenIcon;
    private final long startTimeMills;
    private final int waitSeconds;

    public RedEnvelopeModel(@NotNull ImageModel redPacketIcon, @NotNull ImageModel redPacketOpenIcon, @NotNull String redPacketId, @NotNull String entranceUrl, long j10, int i10, int i11) {
        s.i(redPacketIcon, "redPacketIcon");
        s.i(redPacketOpenIcon, "redPacketOpenIcon");
        s.i(redPacketId, "redPacketId");
        s.i(entranceUrl, "entranceUrl");
        this.redPacketIcon = redPacketIcon;
        this.redPacketOpenIcon = redPacketOpenIcon;
        this.redPacketId = redPacketId;
        this.entranceUrl = entranceUrl;
        this.startTimeMills = j10;
        this.countdownSeconds = i10;
        this.waitSeconds = i11;
    }

    @NotNull
    public final ImageModel component1() {
        return this.redPacketIcon;
    }

    @NotNull
    public final ImageModel component2() {
        return this.redPacketOpenIcon;
    }

    @NotNull
    public final String component3() {
        return this.redPacketId;
    }

    @NotNull
    public final String component4() {
        return this.entranceUrl;
    }

    public final long component5() {
        return this.startTimeMills;
    }

    public final int component6() {
        return this.countdownSeconds;
    }

    public final int component7() {
        return this.waitSeconds;
    }

    @NotNull
    public final RedEnvelopeModel copy(@NotNull ImageModel redPacketIcon, @NotNull ImageModel redPacketOpenIcon, @NotNull String redPacketId, @NotNull String entranceUrl, long j10, int i10, int i11) {
        s.i(redPacketIcon, "redPacketIcon");
        s.i(redPacketOpenIcon, "redPacketOpenIcon");
        s.i(redPacketId, "redPacketId");
        s.i(entranceUrl, "entranceUrl");
        return new RedEnvelopeModel(redPacketIcon, redPacketOpenIcon, redPacketId, entranceUrl, j10, i10, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedEnvelopeModel)) {
            return false;
        }
        RedEnvelopeModel redEnvelopeModel = (RedEnvelopeModel) obj;
        return s.d(this.redPacketIcon, redEnvelopeModel.redPacketIcon) && s.d(this.redPacketOpenIcon, redEnvelopeModel.redPacketOpenIcon) && s.d(this.redPacketId, redEnvelopeModel.redPacketId) && s.d(this.entranceUrl, redEnvelopeModel.entranceUrl) && this.startTimeMills == redEnvelopeModel.startTimeMills && this.countdownSeconds == redEnvelopeModel.countdownSeconds && this.waitSeconds == redEnvelopeModel.waitSeconds;
    }

    public final int getCountdownSeconds() {
        return this.countdownSeconds;
    }

    @NotNull
    public final String getEntranceUrl() {
        return this.entranceUrl;
    }

    @NotNull
    public final ImageModel getRedPacketIcon() {
        return this.redPacketIcon;
    }

    @NotNull
    public final String getRedPacketId() {
        return this.redPacketId;
    }

    @NotNull
    public final ImageModel getRedPacketOpenIcon() {
        return this.redPacketOpenIcon;
    }

    public final long getStartTimeMills() {
        return this.startTimeMills;
    }

    public final int getWaitSeconds() {
        return this.waitSeconds;
    }

    public int hashCode() {
        return (((((((((((this.redPacketIcon.hashCode() * 31) + this.redPacketOpenIcon.hashCode()) * 31) + this.redPacketId.hashCode()) * 31) + this.entranceUrl.hashCode()) * 31) + a.a(this.startTimeMills)) * 31) + this.countdownSeconds) * 31) + this.waitSeconds;
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.redPacketIcon;
        ImageModel imageModel2 = this.redPacketOpenIcon;
        return "RedEnvelopeModel(redPacketIcon=" + ((Object) imageModel) + ", redPacketOpenIcon=" + ((Object) imageModel2) + ", redPacketId=" + this.redPacketId + ", entranceUrl=" + this.entranceUrl + ", startTimeMills=" + this.startTimeMills + ", countdownSeconds=" + this.countdownSeconds + ", waitSeconds=" + this.waitSeconds + ")";
    }
}
