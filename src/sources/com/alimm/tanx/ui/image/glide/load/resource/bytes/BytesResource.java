package com.alimm.tanx.ui.image.glide.load.resource.bytes;

import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BytesResource implements Resource<byte[]> {
    public final byte[] bytes;

    public BytesResource(byte[] bArr) {
        Objects.requireNonNull(bArr, "Bytes must not be null");
        this.bytes = bArr;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public int getSize() {
        return this.bytes.length;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public void recycle() {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public byte[] get() {
        return this.bytes;
    }
}
