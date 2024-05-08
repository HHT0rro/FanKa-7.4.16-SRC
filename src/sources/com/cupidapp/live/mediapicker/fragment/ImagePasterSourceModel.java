package com.cupidapp.live.mediapicker.fragment;

import com.cupidapp.live.hashtag.model.HashTagSimpleModel;
import com.cupidapp.live.mediapicker.model.FrameAspectRatio;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImagePasterFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImagePasterSourceModel implements Serializable {

    @NotNull
    private final FrameAspectRatio frameType;

    @Nullable
    private final HashTagSimpleModel hashTagSimpleModel;

    @Nullable
    private final String mediaContentPath;

    @Nullable
    private final String mediaType;

    @Nullable
    private final String originPath;

    @Nullable
    private final String webTitle;

    public ImagePasterSourceModel(@Nullable String str, @Nullable String str2, @NotNull FrameAspectRatio frameType, @Nullable String str3, @Nullable String str4, @Nullable HashTagSimpleModel hashTagSimpleModel) {
        s.i(frameType, "frameType");
        this.originPath = str;
        this.mediaContentPath = str2;
        this.frameType = frameType;
        this.mediaType = str3;
        this.webTitle = str4;
        this.hashTagSimpleModel = hashTagSimpleModel;
    }

    @NotNull
    public final FrameAspectRatio getFrameType() {
        return this.frameType;
    }

    @Nullable
    public final HashTagSimpleModel getHashTagSimpleModel() {
        return this.hashTagSimpleModel;
    }

    @Nullable
    public final String getMediaContentPath() {
        return this.mediaContentPath;
    }

    @Nullable
    public final String getMediaType() {
        return this.mediaType;
    }

    @Nullable
    public final String getOriginPath() {
        return this.originPath;
    }

    @Nullable
    public final String getWebTitle() {
        return this.webTitle;
    }

    public /* synthetic */ ImagePasterSourceModel(String str, String str2, FrameAspectRatio frameAspectRatio, String str3, String str4, HashTagSimpleModel hashTagSimpleModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, frameAspectRatio, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : hashTagSimpleModel);
    }
}
