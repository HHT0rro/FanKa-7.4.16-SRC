package com.alimm.tanx.ui.image.glide.load.resource;

import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class NullResourceEncoder<T> implements ResourceEncoder<T> {
    public static final NullResourceEncoder<?> NULL_ENCODER = new NullResourceEncoder<>();

    public static <T> NullResourceEncoder<T> get() {
        return (NullResourceEncoder<T>) NULL_ENCODER;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public boolean encode(Resource<T> resource, OutputStream outputStream) {
        return false;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public String getId() {
        return "";
    }
}
