package com.huawei.quickcard.video.utils;

import android.app.Activity;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class VideoFullScreenHelper extends VideoFullScreenHelperBase {
    private static final String TAG = "VideoFullScreenHelper";

    @Deprecated
    public static VideoFullScreenHelper getInstance() {
        return new VideoFullScreenHelper();
    }

    @Override // com.huawei.quickcard.video.utils.VideoFullScreenHelperBase
    public void handleActivityOrientation(@NonNull Activity activity, int i10) {
        activity.setRequestedOrientation(i10);
    }
}
