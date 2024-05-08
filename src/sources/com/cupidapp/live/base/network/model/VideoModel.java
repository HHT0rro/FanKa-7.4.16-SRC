package com.cupidapp.live.base.network.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class VideoModel implements Serializable {
    private final int height;

    @Nullable
    private final String url;

    @NotNull
    private final String videoId;
    private final int width;

    public VideoModel(int i10, int i11, @NotNull String videoId, @Nullable String str) {
        s.i(videoId, "videoId");
        this.width = i10;
        this.height = i11;
        this.videoId = videoId;
        this.url = str;
    }

    public static /* synthetic */ VideoModel copy$default(VideoModel videoModel, int i10, int i11, String str, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = videoModel.width;
        }
        if ((i12 & 2) != 0) {
            i11 = videoModel.height;
        }
        if ((i12 & 4) != 0) {
            str = videoModel.videoId;
        }
        if ((i12 & 8) != 0) {
            str2 = videoModel.url;
        }
        return videoModel.copy(i10, i11, str, str2);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    @NotNull
    public final String component3() {
        return this.videoId;
    }

    @Nullable
    public final String component4() {
        return this.url;
    }

    @NotNull
    public final VideoModel copy(int i10, int i11, @NotNull String videoId, @Nullable String str) {
        s.i(videoId, "videoId");
        return new VideoModel(i10, i11, videoId, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoModel)) {
            return false;
        }
        VideoModel videoModel = (VideoModel) obj;
        return this.width == videoModel.width && this.height == videoModel.height && s.d(this.videoId, videoModel.videoId) && s.d(this.url, videoModel.url);
    }

    public final int getHeight() {
        return this.height;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final String getVideoId() {
        return this.videoId;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int hashCode = ((((this.width * 31) + this.height) * 31) + this.videoId.hashCode()) * 31;
        String str = this.url;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "VideoModel(width=" + this.width + ", height=" + this.height + ", videoId=" + this.videoId + ", url=" + this.url + ")";
    }

    public /* synthetic */ VideoModel(int i10, int i11, String str, String str2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, i11, str, (i12 & 8) != 0 ? null : str2);
    }
}
