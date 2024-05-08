package com.zego.zegoavkit2.videorender;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum VideoRenderType {
    VIDEO_RENDER_TYPE_NONE(0),
    VIDEO_RENDER_TYPE_RGB(1),
    VIDEO_RENDER_TYPE_YUV(2),
    VIDEO_RENDER_TYPE_ANY(3),
    VIDEO_RENDER_TYPE_EXTERNAL_INTERNAL_RGB(4),
    VIDEO_RENDER_TYPE_EXTERNAL_INTERNAL_YUV(5);

    private int mType;

    VideoRenderType(int i10) {
        this.mType = i10;
    }

    public int value() {
        return this.mType;
    }

    public static VideoRenderType valueOf(int i10) {
        if (i10 == 0) {
            return VIDEO_RENDER_TYPE_NONE;
        }
        if (i10 == 1) {
            return VIDEO_RENDER_TYPE_RGB;
        }
        if (i10 == 2) {
            return VIDEO_RENDER_TYPE_YUV;
        }
        if (i10 == 3) {
            return VIDEO_RENDER_TYPE_ANY;
        }
        if (i10 == 4) {
            return VIDEO_RENDER_TYPE_EXTERNAL_INTERNAL_RGB;
        }
        if (i10 != 5) {
            return VIDEO_RENDER_TYPE_NONE;
        }
        return VIDEO_RENDER_TYPE_EXTERNAL_INTERNAL_YUV;
    }
}
