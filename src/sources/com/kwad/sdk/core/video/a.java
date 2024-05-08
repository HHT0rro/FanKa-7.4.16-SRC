package com.kwad.sdk.core.video;

import android.content.Context;
import android.view.TextureView;
import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends TextureView {
    private int videoHeight;
    private int videoWidth;

    public a(Context context) {
        super(context);
    }

    public final void adaptVideoSize(int i10, int i11) {
        if (this.videoWidth == i10 || this.videoHeight == i11) {
            return;
        }
        this.videoWidth = i10;
        this.videoHeight = i11;
        requestLayout();
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        int i12;
        float rotation = getRotation();
        if (rotation == 90.0f || rotation == 270.0f) {
            i11 = i10;
            i10 = i11;
        }
        int defaultSize = TextureView.getDefaultSize(this.videoWidth, i10);
        int defaultSize2 = TextureView.getDefaultSize(this.videoHeight, i11);
        if (this.videoWidth > 0 && this.videoHeight > 0) {
            int mode = View.MeasureSpec.getMode(i10);
            int size = View.MeasureSpec.getSize(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            int size2 = View.MeasureSpec.getSize(i11);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i13 = this.videoWidth;
                int i14 = i13 * size2;
                int i15 = this.videoHeight;
                if (i14 < size * i15) {
                    defaultSize = (i13 * size2) / i15;
                } else if (i13 * size2 > size * i15) {
                    defaultSize2 = (i15 * size) / i13;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
                defaultSize2 = size2;
            } else if (mode == 1073741824) {
                int i16 = this.videoHeight;
                int i17 = this.videoWidth;
                int i18 = (size * i16) / i17;
                if (mode2 != Integer.MIN_VALUE || i18 <= size2) {
                    defaultSize = size;
                    defaultSize2 = i18;
                } else {
                    defaultSize = (i17 * size2) / i16;
                    defaultSize2 = size2;
                }
            } else {
                if (mode2 == 1073741824) {
                    int i19 = this.videoWidth;
                    int i20 = this.videoHeight;
                    int i21 = (size2 * i19) / i20;
                    if (mode != Integer.MIN_VALUE || i21 <= size) {
                        defaultSize2 = size2;
                        defaultSize = i21;
                    } else {
                        defaultSize2 = (i20 * size) / i19;
                    }
                } else {
                    int i22 = this.videoWidth;
                    int i23 = this.videoHeight;
                    if (mode2 != Integer.MIN_VALUE || i23 <= size2) {
                        i12 = i22;
                        size2 = i23;
                    } else {
                        i12 = (size2 * i22) / i23;
                    }
                    if (mode != Integer.MIN_VALUE || i12 <= size) {
                        defaultSize = i12;
                        defaultSize2 = size2;
                    } else {
                        defaultSize2 = (i23 * size) / i22;
                    }
                }
                defaultSize = size;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.View
    public final void setRotation(float f10) {
        if (f10 != getRotation()) {
            super.setRotation(f10);
            requestLayout();
        }
    }
}
