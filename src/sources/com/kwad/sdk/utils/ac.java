package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ac {
    @WorkerThread
    public static String a(String str, a aVar) {
        return (TextUtils.isEmpty(str) || aVar == null) ? str : str.replace("__WIDTH__", ea(aVar.getWidth())).replace("__HEIGHT__", ea(aVar.getHeight())).replace("__DOWN_X__", ea(aVar.LV())).replace("__DOWN_Y__", ea(aVar.LW())).replace("__UP_X__", ea(aVar.LX())).replace("__UP_Y__", ea(aVar.LY()));
    }

    public static String am(Context context, String str) {
        return TextUtils.isEmpty(str) ? str : str.replace("__SCREEN_WIDTH__", String.valueOf(k.getScreenWidth(context))).replace("__SCREEN_HEIGHT__", String.valueOf(k.getScreenHeight(context))).replace("__DEVICE_WIDTH__", String.valueOf(k.bT(context))).replace("__DEVICE_HEIGHT__", String.valueOf(k.bU(context)));
    }

    public static String c(@Nullable Context context, String str, boolean z10) {
        return str.replace("__TS__", String.valueOf(bk.v(context, z10)));
    }

    private static String ea(int i10) {
        return i10 >= 0 ? String.valueOf(i10) : "-999";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private int aPl;
        private int aPm;
        private int aPn;
        private int aPo;
        private int mHeight;
        private int mWidth;

        public a() {
            this.mWidth = -1;
            this.mHeight = -1;
            this.aPl = -1;
            this.aPm = -1;
            this.aPn = -1;
            this.aPo = -1;
        }

        public final int LV() {
            return this.aPl;
        }

        public final int LW() {
            return this.aPm;
        }

        public final int LX() {
            return this.aPn;
        }

        public final int LY() {
            return this.aPo;
        }

        public final void f(float f10, float f11) {
            this.aPl = (int) f10;
            this.aPm = (int) f11;
        }

        public final void g(float f10, float f11) {
            this.aPn = (int) f10;
            this.aPo = (int) f11;
        }

        public final int getHeight() {
            return this.mHeight;
        }

        public final int getWidth() {
            return this.mWidth;
        }

        public final String toString() {
            return "TouchCoords{mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mDownX=" + this.aPl + ", mDownY=" + this.aPm + ", mUpX=" + this.aPn + ", mUpY=" + this.aPo + '}';
        }

        public final void z(int i10, int i11) {
            this.mWidth = i10;
            this.mHeight = i11;
        }

        public a(int i10, int i11) {
            this.aPl = -1;
            this.aPm = -1;
            this.aPn = -1;
            this.aPo = -1;
            this.mWidth = i10;
            this.mHeight = i11;
        }
    }
}
