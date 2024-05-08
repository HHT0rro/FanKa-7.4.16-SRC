package com.alimm.tanx.ui.image.glide.util;

import android.view.View;
import com.alimm.tanx.ui.image.glide.ListPreloader;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;
import com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback;
import com.alimm.tanx.ui.image.glide.request.target.ViewTarget;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ViewPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback {
    public int[] size;
    public SizeViewTarget viewTarget;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class SizeViewTarget extends ViewTarget<View, Object> {
        public SizeViewTarget(View view, SizeReadyCallback sizeReadyCallback) {
            super(view);
            getSize(sizeReadyCallback);
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.Target
        public void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        }
    }

    public ViewPreloadSizeProvider() {
    }

    @Override // com.alimm.tanx.ui.image.glide.ListPreloader.PreloadSizeProvider
    public int[] getPreloadSize(T t2, int i10, int i11) {
        int[] iArr = this.size;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i10, int i11) {
        this.size = new int[]{i10, i11};
        this.viewTarget = null;
    }

    public void setView(View view) {
        if (this.size == null && this.viewTarget == null) {
            this.viewTarget = new SizeViewTarget(view, this);
        }
    }

    public ViewPreloadSizeProvider(View view) {
        setView(view);
    }
}
