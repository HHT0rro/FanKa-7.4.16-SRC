package com.cupidapp.live.mediapicker.model;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoAttributeViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VideoEditAttributeModel implements Serializable {
    private final long durationMs;
    private final int height;
    private final long maxDurationMs;
    private final float rotation;
    private long selectCoverImageTimeMs;
    private long trimInMs;
    private long trimOutMs;

    @NotNull
    private final String uriString;
    private final int width;

    public VideoEditAttributeModel(@NotNull String uriString, int i10, int i11, long j10, float f10, long j11, long j12, long j13, long j14) {
        s.i(uriString, "uriString");
        this.uriString = uriString;
        this.width = i10;
        this.height = i11;
        this.durationMs = j10;
        this.rotation = f10;
        this.maxDurationMs = j11;
        this.selectCoverImageTimeMs = j12;
        this.trimInMs = j13;
        this.trimOutMs = j14;
    }

    @NotNull
    public final String component1() {
        return this.uriString;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final long component4() {
        return this.durationMs;
    }

    public final float component5() {
        return this.rotation;
    }

    public final long component6() {
        return this.maxDurationMs;
    }

    public final long component7() {
        return this.selectCoverImageTimeMs;
    }

    public final long component8() {
        return this.trimInMs;
    }

    public final long component9() {
        return this.trimOutMs;
    }

    @NotNull
    public final VideoEditAttributeModel copy(@NotNull String uriString, int i10, int i11, long j10, float f10, long j11, long j12, long j13, long j14) {
        s.i(uriString, "uriString");
        return new VideoEditAttributeModel(uriString, i10, i11, j10, f10, j11, j12, j13, j14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoEditAttributeModel)) {
            return false;
        }
        VideoEditAttributeModel videoEditAttributeModel = (VideoEditAttributeModel) obj;
        return s.d(this.uriString, videoEditAttributeModel.uriString) && this.width == videoEditAttributeModel.width && this.height == videoEditAttributeModel.height && this.durationMs == videoEditAttributeModel.durationMs && Float.compare(this.rotation, videoEditAttributeModel.rotation) == 0 && this.maxDurationMs == videoEditAttributeModel.maxDurationMs && this.selectCoverImageTimeMs == videoEditAttributeModel.selectCoverImageTimeMs && this.trimInMs == videoEditAttributeModel.trimInMs && this.trimOutMs == videoEditAttributeModel.trimOutMs;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final int getHeight() {
        return this.height;
    }

    public final long getMaxDurationMs() {
        return this.maxDurationMs;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final long getSelectCoverImageTimeMs() {
        return this.selectCoverImageTimeMs;
    }

    public final long getTrimInMs() {
        return this.trimInMs;
    }

    public final long getTrimOutMs() {
        return this.trimOutMs;
    }

    @NotNull
    public final String getUriString() {
        return this.uriString;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((((((((((((this.uriString.hashCode() * 31) + this.width) * 31) + this.height) * 31) + b2.a.a(this.durationMs)) * 31) + Float.floatToIntBits(this.rotation)) * 31) + b2.a.a(this.maxDurationMs)) * 31) + b2.a.a(this.selectCoverImageTimeMs)) * 31) + b2.a.a(this.trimInMs)) * 31) + b2.a.a(this.trimOutMs);
    }

    public final void setSelectCoverImageTimeMs(long j10) {
        this.selectCoverImageTimeMs = j10;
    }

    public final void setTrimInMs(long j10) {
        this.trimInMs = j10;
    }

    public final void setTrimOutMs(long j10) {
        this.trimOutMs = j10;
    }

    @NotNull
    public String toString() {
        return "VideoEditAttributeModel(uriString=" + this.uriString + ", width=" + this.width + ", height=" + this.height + ", durationMs=" + this.durationMs + ", rotation=" + this.rotation + ", maxDurationMs=" + this.maxDurationMs + ", selectCoverImageTimeMs=" + this.selectCoverImageTimeMs + ", trimInMs=" + this.trimInMs + ", trimOutMs=" + this.trimOutMs + ")";
    }

    public /* synthetic */ VideoEditAttributeModel(String str, int i10, int i11, long j10, float f10, long j11, long j12, long j13, long j14, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i10, i11, j10, f10, j11, (i12 & 64) != 0 ? 0L : j12, (i12 & 128) != 0 ? 0L : j13, (i12 & 256) != 0 ? 0L : j14);
    }
}
