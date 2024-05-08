package com.bef.effectsdk.text.data;

import h0.a;

@a
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum BitmapType {
    TEXT_BITMAP_NONE(-1),
    TEXT_BITMAP_TYPE_ALPHA(0),
    TEXT_BITMAP_TYPE_RGBA8888(1),
    TEXT_BITMAP_NEON_ALPHA(2),
    TEXT_BITMAP_SINGLE_CHAR_ALPHA(3),
    TEXT_BITMAP_SHAKE_ALPHA(4);

    public int value;

    @a
    BitmapType(int i10) {
        this.value = i10;
    }

    @a
    public static BitmapType valueOf(int i10) {
        for (BitmapType bitmapType : values()) {
            if (bitmapType.value == i10) {
                return bitmapType;
            }
        }
        return TEXT_BITMAP_NONE;
    }
}
