package com.alimm.tanx.ui.image.glide.load;

import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface Encoder<T> {
    boolean encode(T t2, OutputStream outputStream);

    String getId();
}