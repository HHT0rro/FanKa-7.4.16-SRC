package com.bumptech.glide.gifdecoder;

import androidx.annotation.ColorInt;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
class GifFrame {
    public static final int DISPOSAL_BACKGROUND = 2;
    public static final int DISPOSAL_NONE = 1;
    public static final int DISPOSAL_PREVIOUS = 3;
    public static final int DISPOSAL_UNSPECIFIED = 0;
    public int bufferFrameStart;
    public int delay;
    public int dispose;
    public int ih;
    public boolean interlace;
    public int iw;
    public int ix;
    public int iy;

    @ColorInt
    public int[] lct;
    public int transIndex;
    public boolean transparency;
}
