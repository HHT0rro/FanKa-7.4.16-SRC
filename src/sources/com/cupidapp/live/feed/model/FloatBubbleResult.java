package com.cupidapp.live.feed.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedFloatBubbleModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FloatBubbleResult {

    @Nullable
    private final ImageModel image;
    private final int second;

    @Nullable
    private final String url;

    public FloatBubbleResult() {
        this(null, 0, null, 7, null);
    }

    public FloatBubbleResult(@Nullable ImageModel imageModel, int i10, @Nullable String str) {
        this.image = imageModel;
        this.second = i10;
        this.url = str;
    }

    public static /* synthetic */ FloatBubbleResult copy$default(FloatBubbleResult floatBubbleResult, ImageModel imageModel, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            imageModel = floatBubbleResult.image;
        }
        if ((i11 & 2) != 0) {
            i10 = floatBubbleResult.second;
        }
        if ((i11 & 4) != 0) {
            str = floatBubbleResult.url;
        }
        return floatBubbleResult.copy(imageModel, i10, str);
    }

    @Nullable
    public final ImageModel component1() {
        return this.image;
    }

    public final int component2() {
        return this.second;
    }

    @Nullable
    public final String component3() {
        return this.url;
    }

    @NotNull
    public final FloatBubbleResult copy(@Nullable ImageModel imageModel, int i10, @Nullable String str) {
        return new FloatBubbleResult(imageModel, i10, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FloatBubbleResult)) {
            return false;
        }
        FloatBubbleResult floatBubbleResult = (FloatBubbleResult) obj;
        return s.d(this.image, floatBubbleResult.image) && this.second == floatBubbleResult.second && s.d(this.url, floatBubbleResult.url);
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    public final int getSecond() {
        return this.second;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        ImageModel imageModel = this.image;
        int hashCode = (((imageModel == null ? 0 : imageModel.hashCode()) * 31) + this.second) * 31;
        String str = this.url;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.image;
        return "FloatBubbleResult(image=" + ((Object) imageModel) + ", second=" + this.second + ", url=" + this.url + ")";
    }

    public /* synthetic */ FloatBubbleResult(ImageModel imageModel, int i10, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : imageModel, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? null : str);
    }
}
