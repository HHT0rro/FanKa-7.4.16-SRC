package com.cupidapp.live.mediapicker.model;

import com.cupidapp.live.appdialog.model.AppDialogModel;
import com.cupidapp.live.feed.model.PostBoostModel;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoResult.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VideoResult<T> implements Serializable {

    @Nullable
    private final PostBoostModel postBoost;

    @Nullable
    private final String url;
    private final T video;

    @Nullable
    private final List<AppDialogModel> windows;

    /* JADX WARN: Multi-variable type inference failed */
    public VideoResult(T t2, @Nullable PostBoostModel postBoostModel, @Nullable String str, @Nullable List<? extends AppDialogModel> list) {
        this.video = t2;
        this.postBoost = postBoostModel;
        this.url = str;
        this.windows = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideoResult copy$default(VideoResult videoResult, Object obj, PostBoostModel postBoostModel, String str, List list, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = videoResult.video;
        }
        if ((i10 & 2) != 0) {
            postBoostModel = videoResult.postBoost;
        }
        if ((i10 & 4) != 0) {
            str = videoResult.url;
        }
        if ((i10 & 8) != 0) {
            list = videoResult.windows;
        }
        return videoResult.copy(obj, postBoostModel, str, list);
    }

    public final T component1() {
        return this.video;
    }

    @Nullable
    public final PostBoostModel component2() {
        return this.postBoost;
    }

    @Nullable
    public final String component3() {
        return this.url;
    }

    @Nullable
    public final List<AppDialogModel> component4() {
        return this.windows;
    }

    @NotNull
    public final VideoResult<T> copy(T t2, @Nullable PostBoostModel postBoostModel, @Nullable String str, @Nullable List<? extends AppDialogModel> list) {
        return new VideoResult<>(t2, postBoostModel, str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoResult)) {
            return false;
        }
        VideoResult videoResult = (VideoResult) obj;
        return s.d(this.video, videoResult.video) && s.d(this.postBoost, videoResult.postBoost) && s.d(this.url, videoResult.url) && s.d(this.windows, videoResult.windows);
    }

    @Nullable
    public final PostBoostModel getPostBoost() {
        return this.postBoost;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public final T getVideo() {
        return this.video;
    }

    @Nullable
    public final List<AppDialogModel> getWindows() {
        return this.windows;
    }

    public int hashCode() {
        T t2 = this.video;
        int hashCode = (t2 == null ? 0 : t2.hashCode()) * 31;
        PostBoostModel postBoostModel = this.postBoost;
        int hashCode2 = (hashCode + (postBoostModel == null ? 0 : postBoostModel.hashCode())) * 31;
        String str = this.url;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        List<AppDialogModel> list = this.windows;
        return hashCode3 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        T t2 = this.video;
        PostBoostModel postBoostModel = this.postBoost;
        return "VideoResult(video=" + ((Object) t2) + ", postBoost=" + ((Object) postBoostModel) + ", url=" + this.url + ", windows=" + ((Object) this.windows) + ")";
    }
}
