package com.cupidapp.live.base.network.model;

import com.android.internal.logging.nano.MetricsProto;
import kotlin.d;

/* compiled from: ImageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ImageSizeConstants {
    SQUARE_TINNY_SIZE(120),
    SQUARE_SMALL_SIZE(240),
    SQUARE_MIDDLE_SIZE(480),
    SQUARE_BIG_SIZE(768),
    SQUARE_ORIGIN_SIZE(MetricsProto.MetricsEvent.ACTION_HUSH_GESTURE);

    private final int width;

    ImageSizeConstants(int i10) {
        this.width = i10;
    }

    public final int getWidth() {
        return this.width;
    }
}
