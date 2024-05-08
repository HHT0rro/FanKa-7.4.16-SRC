package com.alimm.tanx.ui.image.glide.load.data;

import com.alimm.tanx.ui.image.glide.Priority;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ByteArrayFetcher implements DataFetcher<InputStream> {
    public final byte[] bytes;

    /* renamed from: id, reason: collision with root package name */
    public final String f4190id;

    public ByteArrayFetcher(byte[] bArr, String str) {
        this.bytes = bArr;
        this.f4190id = str;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cleanup() {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public String getId() {
        return this.f4190id;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public InputStream loadData(Priority priority) {
        return new ByteArrayInputStream(this.bytes);
    }
}
