package com.alimm.tanx.ui.image.glide;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum MemoryCategory {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);

    public float multiplier;

    MemoryCategory(float f10) {
        this.multiplier = f10;
    }

    public float getMultiplier() {
        return this.multiplier;
    }
}
