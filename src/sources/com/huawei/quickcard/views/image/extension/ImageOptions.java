package com.huawei.quickcard.views.image.extension;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.util.Pair;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ImageOptions {

    /* renamed from: a, reason: collision with root package name */
    private String f34527a;

    /* renamed from: b, reason: collision with root package name */
    private Pair<String, Drawable> f34528b;

    /* renamed from: f, reason: collision with root package name */
    private FitMode f34532f;

    /* renamed from: h, reason: collision with root package name */
    private ClipRect f34534h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f34535i;

    /* renamed from: c, reason: collision with root package name */
    private int f34529c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f34530d = -1;

    /* renamed from: e, reason: collision with root package name */
    private boolean f34531e = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f34533g = true;

    public ClipRect getClipRect() {
        return this.f34534h;
    }

    public FitMode getFitMode() {
        return this.f34532f;
    }

    public int getHeight() {
        return this.f34530d;
    }

    public Pair<String, Drawable> getPlaceHolder() {
        return this.f34528b;
    }

    public ImageView getTargetView() {
        return this.f34535i;
    }

    public String getUrl() {
        return this.f34527a;
    }

    public int getWidth() {
        return this.f34529c;
    }

    public boolean isEnableCache() {
        return this.f34531e;
    }

    public boolean isNetworkEnhance() {
        return this.f34533g;
    }

    public void setClipRect(ClipRect clipRect) {
        this.f34534h = clipRect;
    }

    public void setEnableCache(boolean z10) {
        this.f34531e = z10;
    }

    public void setFitMode(FitMode fitMode) {
        this.f34532f = fitMode;
    }

    public void setHeight(int i10) {
        this.f34530d = i10;
    }

    public void setNetworkEnhance(boolean z10) {
        this.f34533g = z10;
    }

    public void setPlaceHolder(Pair<String, Drawable> pair) {
        this.f34528b = pair;
    }

    public void setTargetView(ImageView imageView) {
        this.f34535i = imageView;
    }

    public void setUrl(String str) {
        this.f34527a = str;
    }

    public void setWidth(int i10) {
        this.f34529c = i10;
    }
}
