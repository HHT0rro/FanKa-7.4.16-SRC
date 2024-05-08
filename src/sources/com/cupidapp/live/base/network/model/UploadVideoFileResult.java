package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class UploadVideoFileResult {

    @NotNull
    private final VideoModel video;

    public UploadVideoFileResult(@NotNull VideoModel video) {
        s.i(video, "video");
        this.video = video;
    }

    public static /* synthetic */ UploadVideoFileResult copy$default(UploadVideoFileResult uploadVideoFileResult, VideoModel videoModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            videoModel = uploadVideoFileResult.video;
        }
        return uploadVideoFileResult.copy(videoModel);
    }

    @NotNull
    public final VideoModel component1() {
        return this.video;
    }

    @NotNull
    public final UploadVideoFileResult copy(@NotNull VideoModel video) {
        s.i(video, "video");
        return new UploadVideoFileResult(video);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UploadVideoFileResult) && s.d(this.video, ((UploadVideoFileResult) obj).video);
    }

    @NotNull
    public final VideoModel getVideo() {
        return this.video;
    }

    public int hashCode() {
        return this.video.hashCode();
    }

    @NotNull
    public String toString() {
        return "UploadVideoFileResult(video=" + ((Object) this.video) + ")";
    }
}
