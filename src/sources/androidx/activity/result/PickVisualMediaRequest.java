package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContracts;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PickVisualMediaRequest.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class PickVisualMediaRequest {

    @NotNull
    private ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;

    /* compiled from: PickVisualMediaRequest.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class Builder {

        @NotNull
        private ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;

        @NotNull
        public final PickVisualMediaRequest build() {
            PickVisualMediaRequest pickVisualMediaRequest = new PickVisualMediaRequest();
            pickVisualMediaRequest.setMediaType$activity_release(this.mediaType);
            return pickVisualMediaRequest;
        }

        @NotNull
        public final Builder setMediaType(@NotNull ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType) {
            s.i(mediaType, "mediaType");
            this.mediaType = mediaType;
            return this;
        }
    }

    @NotNull
    public final ActivityResultContracts.PickVisualMedia.VisualMediaType getMediaType() {
        return this.mediaType;
    }

    public final void setMediaType$activity_release(@NotNull ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType) {
        s.i(visualMediaType, "<set-?>");
        this.mediaType = visualMediaType;
    }
}
