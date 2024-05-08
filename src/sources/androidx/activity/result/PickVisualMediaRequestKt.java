package androidx.activity.result;

import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PickVisualMediaRequest.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class PickVisualMediaRequestKt {
    @NotNull
    public static final PickVisualMediaRequest PickVisualMediaRequest(@NotNull ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType) {
        s.i(mediaType, "mediaType");
        return new PickVisualMediaRequest.Builder().setMediaType(mediaType).build();
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        return PickVisualMediaRequest(visualMediaType);
    }
}
