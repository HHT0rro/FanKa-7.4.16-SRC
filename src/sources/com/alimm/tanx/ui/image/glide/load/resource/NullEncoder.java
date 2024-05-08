package com.alimm.tanx.ui.image.glide.load.resource;

import com.alimm.tanx.ui.image.glide.load.Encoder;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class NullEncoder<T> implements Encoder<T> {
    public static final NullEncoder<?> NULL_ENCODER = new NullEncoder<>();

    public static <T> Encoder<T> get() {
        return NULL_ENCODER;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public boolean encode(T t2, OutputStream outputStream) {
        return false;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public String getId() {
        return "";
    }
}
