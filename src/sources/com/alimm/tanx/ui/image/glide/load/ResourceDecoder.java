package com.alimm.tanx.ui.image.glide.load;

import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ResourceDecoder<T, Z> {
    Resource<Z> decode(T t2, int i10, int i11) throws IOException;

    String getId();
}
