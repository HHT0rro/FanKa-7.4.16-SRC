package com.huawei.flexiblelayout.services.imageloader;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ImageOptions {

    /* renamed from: a, reason: collision with root package name */
    private String f28608a = "";

    /* renamed from: b, reason: collision with root package name */
    private boolean f28609b = false;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f28610c = null;

    /* renamed from: d, reason: collision with root package name */
    private int[] f28611d = null;

    /* renamed from: e, reason: collision with root package name */
    private Length[] f28612e = null;

    @Nullable
    public Length[] getClipRect() {
        return this.f28612e;
    }

    @Nullable
    public Drawable getPlaceholder() {
        return this.f28610c;
    }

    @Nullable
    public int[] getSize() {
        return this.f28611d;
    }

    public String getUrl() {
        return this.f28608a;
    }

    public boolean isSkipCache() {
        return this.f28609b;
    }

    public void setClipRect(Length length, Length length2, Length length3, Length length4) {
        this.f28612e = new Length[]{length, length2, length3, length4};
    }

    public void setPlaceholder(Drawable drawable) {
        this.f28610c = drawable;
    }

    public void setSize(int i10, int i11) {
        this.f28611d = new int[]{i10, i11};
    }

    public void setSkipCache(boolean z10) {
        this.f28609b = z10;
    }

    public void setUrl(String str) {
        this.f28608a = str;
    }
}
