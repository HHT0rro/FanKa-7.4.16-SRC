package androidx.core.app;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface OnPictureInPictureModeChangedProvider {
    void addOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> consumer);

    void removeOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> consumer);
}
