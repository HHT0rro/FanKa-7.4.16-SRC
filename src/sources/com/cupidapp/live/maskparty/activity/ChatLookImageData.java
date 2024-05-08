package com.cupidapp.live.maskparty.activity;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatLookImageActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ChatLookImageData implements Serializable {

    @Nullable
    private final ImageModel image;

    @Nullable
    private final String imagePath;

    @Nullable
    private final String snapImageLargeUrl;

    public ChatLookImageData(@Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2) {
        this.image = imageModel;
        this.imagePath = str;
        this.snapImageLargeUrl = str2;
    }

    public static /* synthetic */ ChatLookImageData copy$default(ChatLookImageData chatLookImageData, ImageModel imageModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = chatLookImageData.image;
        }
        if ((i10 & 2) != 0) {
            str = chatLookImageData.imagePath;
        }
        if ((i10 & 4) != 0) {
            str2 = chatLookImageData.snapImageLargeUrl;
        }
        return chatLookImageData.copy(imageModel, str, str2);
    }

    @Nullable
    public final ImageModel component1() {
        return this.image;
    }

    @Nullable
    public final String component2() {
        return this.imagePath;
    }

    @Nullable
    public final String component3() {
        return this.snapImageLargeUrl;
    }

    @NotNull
    public final ChatLookImageData copy(@Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2) {
        return new ChatLookImageData(imageModel, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatLookImageData)) {
            return false;
        }
        ChatLookImageData chatLookImageData = (ChatLookImageData) obj;
        return s.d(this.image, chatLookImageData.image) && s.d(this.imagePath, chatLookImageData.imagePath) && s.d(this.snapImageLargeUrl, chatLookImageData.snapImageLargeUrl);
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    public final String getImagePath() {
        return this.imagePath;
    }

    @Nullable
    public final String getSnapImageLargeUrl() {
        return this.snapImageLargeUrl;
    }

    public int hashCode() {
        ImageModel imageModel = this.image;
        int hashCode = (imageModel == null ? 0 : imageModel.hashCode()) * 31;
        String str = this.imagePath;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.snapImageLargeUrl;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.image;
        return "ChatLookImageData(image=" + ((Object) imageModel) + ", imagePath=" + this.imagePath + ", snapImageLargeUrl=" + this.snapImageLargeUrl + ")";
    }
}
