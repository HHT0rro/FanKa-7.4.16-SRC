package com.alimm.tanx.ui.image.glide.gifdecoder;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GifHeader {
    public static final int NETSCAPE_LOOP_COUNT_DOES_NOT_EXIST = -1;
    public static final int NETSCAPE_LOOP_COUNT_FOREVER = 0;
    public int bgColor;
    public int bgIndex;
    public GifFrame currentFrame;
    public boolean gctFlag;
    public int gctSize;
    public int height;
    public int pixelAspect;
    public int width;
    public int[] gct = null;
    public int status = 0;
    public int frameCount = 0;
    public List<GifFrame> frames = new ArrayList();
    public int loopCount = -1;

    public int getHeight() {
        return this.height;
    }

    public int getNumFrames() {
        return this.frameCount;
    }

    public int getStatus() {
        return this.status;
    }

    public int getWidth() {
        return this.width;
    }
}
