package com.zego.zegoavkit2.enums;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum VideoCodecType {
    CODEC_TYPE_AVC_AVCC(0),
    CODEC_TYPE_AVC_ANNEXB(1);

    private int mValue;

    VideoCodecType(int i10) {
        this.mValue = i10;
    }

    public int value() {
        return this.mValue;
    }

    public static VideoCodecType valueOf(int i10) {
        if (i10 == 0) {
            return CODEC_TYPE_AVC_AVCC;
        }
        if (i10 != 1) {
            return null;
        }
        return CODEC_TYPE_AVC_ANNEXB;
    }
}
