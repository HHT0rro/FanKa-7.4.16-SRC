package com.cupidapp.live.mediapicker.model;

import android.graphics.Bitmap;
import org.jetbrains.annotations.Nullable;

/* compiled from: ThumbnailBitmapModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ThumbnailBitmapModel {

    @Nullable
    private Bitmap bitmap;
    private int height;
    private int index;
    private int width;

    public ThumbnailBitmapModel(int i10, @Nullable Bitmap bitmap, int i11, int i12) {
        this.index = i10;
        this.bitmap = bitmap;
        this.width = i11;
        this.height = i12;
    }

    @Nullable
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setBitmap(@Nullable Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public final void setHeight(int i10) {
        this.height = i10;
    }

    public final void setIndex(int i10) {
        this.index = i10;
    }

    public final void setWidth(int i10) {
        this.width = i10;
    }
}
