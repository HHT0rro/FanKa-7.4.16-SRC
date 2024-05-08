package androidx.core.app;

import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class PictureInPictureModeChangedInfo {
    private final boolean mIsInPictureInPictureMode;
    private final Configuration mNewConfig;

    public PictureInPictureModeChangedInfo(boolean z10) {
        this.mIsInPictureInPictureMode = z10;
        this.mNewConfig = null;
    }

    @NonNull
    @RequiresApi(26)
    public Configuration getNewConfig() {
        Configuration configuration = this.mNewConfig;
        if (configuration != null) {
            return configuration;
        }
        throw new IllegalStateException("PictureInPictureModeChangedInfo must be constructed with the constructor that takes a Configuration to call getNewConfig(). Are you running on an API 26 or higher device that makes this information available?");
    }

    public boolean isInPictureInPictureMode() {
        return this.mIsInPictureInPictureMode;
    }

    @RequiresApi(26)
    public PictureInPictureModeChangedInfo(boolean z10, @NonNull Configuration configuration) {
        this.mIsInPictureInPictureMode = z10;
        this.mNewConfig = configuration;
    }
}
