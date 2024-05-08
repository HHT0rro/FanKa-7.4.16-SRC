package com.kwad.sdk.utils;

import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bd {
    private final int mHeight;
    private final int mWidth;

    public bd(int i10, int i11) {
        this.mWidth = i10;
        this.mHeight = i11;
    }

    public final float MG() {
        return this.mWidth;
    }

    public final float MH() {
        return this.mHeight;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof bd) {
            bd bdVar = (bd) obj;
            if (this.mWidth == bdVar.mWidth && this.mHeight == bdVar.mHeight) {
                return true;
            }
        }
        return false;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final int hashCode() {
        int i10 = this.mHeight;
        int i11 = this.mWidth;
        return i10 ^ ((i11 >>> 16) | (i11 << 16));
    }

    public final String toString() {
        return this.mWidth + LanguageTag.PRIVATEUSE + this.mHeight;
    }
}
