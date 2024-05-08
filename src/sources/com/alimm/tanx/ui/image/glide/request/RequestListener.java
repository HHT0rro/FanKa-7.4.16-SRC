package com.alimm.tanx.ui.image.glide.request;

import com.alimm.tanx.ui.image.glide.request.target.Target;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface RequestListener<T, R> {
    boolean onException(Exception exc, T t2, Target<R> target, boolean z10);

    boolean onResourceReady(R r10, T t2, Target<R> target, boolean z10, boolean z11);
}
