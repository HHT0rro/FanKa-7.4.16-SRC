package com.alimm.tanx.ui.image.glide.load.resource;

import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class NullDecoder<T, Z> implements ResourceDecoder<T, Z> {
    public static final NullDecoder<?, ?> NULL_DECODER = new NullDecoder<>();

    public static <T, Z> NullDecoder<T, Z> get() {
        return (NullDecoder<T, Z>) NULL_DECODER;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public Resource<Z> decode(T t2, int i10, int i11) {
        return null;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public String getId() {
        return "";
    }
}
