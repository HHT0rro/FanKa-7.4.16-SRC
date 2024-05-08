package com.alimm.tanx.ui.image.glide.request;

import com.alimm.tanx.ui.image.glide.request.target.Target;
import java.util.concurrent.Future;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface FutureTarget<R> extends Future<R>, Target<R> {
    void clear();
}
