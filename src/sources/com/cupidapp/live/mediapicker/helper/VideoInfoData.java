package com.cupidapp.live.mediapicker.helper;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoTrimUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VideoInfoData {
    private final long duration;
    private final int height;
    private final float rotation;
    private final int width;

    public VideoInfoData(int i10, int i11, long j10, float f10) {
        this.width = i10;
        this.height = i11;
        this.duration = j10;
        this.rotation = f10;
    }

    public static /* synthetic */ VideoInfoData copy$default(VideoInfoData videoInfoData, int i10, int i11, long j10, float f10, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = videoInfoData.width;
        }
        if ((i12 & 2) != 0) {
            i11 = videoInfoData.height;
        }
        int i13 = i11;
        if ((i12 & 4) != 0) {
            j10 = videoInfoData.duration;
        }
        long j11 = j10;
        if ((i12 & 8) != 0) {
            f10 = videoInfoData.rotation;
        }
        return videoInfoData.copy(i10, i13, j11, f10);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final long component3() {
        return this.duration;
    }

    public final float component4() {
        return this.rotation;
    }

    @NotNull
    public final VideoInfoData copy(int i10, int i11, long j10, float f10) {
        return new VideoInfoData(i10, i11, j10, f10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoInfoData)) {
            return false;
        }
        VideoInfoData videoInfoData = (VideoInfoData) obj;
        return this.width == videoInfoData.width && this.height == videoInfoData.height && this.duration == videoInfoData.duration && Float.compare(this.rotation, videoInfoData.rotation) == 0;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getHeight() {
        return this.height;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((this.width * 31) + this.height) * 31) + b2.a.a(this.duration)) * 31) + Float.floatToIntBits(this.rotation);
    }

    @NotNull
    public String toString() {
        return "VideoInfoData(width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", rotation=" + this.rotation + ")";
    }
}
