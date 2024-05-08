package com.cupidapp.live.mediapicker.model;

import com.cupidapp.live.appdialog.model.AppDialogModel;
import com.cupidapp.live.feed.model.PostBoostModel;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImageResult.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImageResult<T> implements Serializable {
    private final T image;

    @Nullable
    private final PostBoostModel postBoost;

    @Nullable
    private final String url;

    @Nullable
    private final List<AppDialogModel> windows;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageResult(T t2, @Nullable String str, @Nullable PostBoostModel postBoostModel, @Nullable List<? extends AppDialogModel> list) {
        this.image = t2;
        this.url = str;
        this.postBoost = postBoostModel;
        this.windows = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageResult copy$default(ImageResult imageResult, Object obj, String str, PostBoostModel postBoostModel, List list, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = imageResult.image;
        }
        if ((i10 & 2) != 0) {
            str = imageResult.url;
        }
        if ((i10 & 4) != 0) {
            postBoostModel = imageResult.postBoost;
        }
        if ((i10 & 8) != 0) {
            list = imageResult.windows;
        }
        return imageResult.copy(obj, str, postBoostModel, list);
    }

    public final T component1() {
        return this.image;
    }

    @Nullable
    public final String component2() {
        return this.url;
    }

    @Nullable
    public final PostBoostModel component3() {
        return this.postBoost;
    }

    @Nullable
    public final List<AppDialogModel> component4() {
        return this.windows;
    }

    @NotNull
    public final ImageResult<T> copy(T t2, @Nullable String str, @Nullable PostBoostModel postBoostModel, @Nullable List<? extends AppDialogModel> list) {
        return new ImageResult<>(t2, str, postBoostModel, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageResult)) {
            return false;
        }
        ImageResult imageResult = (ImageResult) obj;
        return s.d(this.image, imageResult.image) && s.d(this.url, imageResult.url) && s.d(this.postBoost, imageResult.postBoost) && s.d(this.windows, imageResult.windows);
    }

    public final T getImage() {
        return this.image;
    }

    @Nullable
    public final PostBoostModel getPostBoost() {
        return this.postBoost;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final List<AppDialogModel> getWindows() {
        return this.windows;
    }

    public int hashCode() {
        T t2 = this.image;
        int hashCode = (t2 == null ? 0 : t2.hashCode()) * 31;
        String str = this.url;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        PostBoostModel postBoostModel = this.postBoost;
        int hashCode3 = (hashCode2 + (postBoostModel == null ? 0 : postBoostModel.hashCode())) * 31;
        List<AppDialogModel> list = this.windows;
        return hashCode3 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        T t2 = this.image;
        return "ImageResult(image=" + ((Object) t2) + ", url=" + this.url + ", postBoost=" + ((Object) this.postBoost) + ", windows=" + ((Object) this.windows) + ")";
    }
}
