package com.alimm.tanx.core.view.player.cache.videocache;

import java.io.ByteArrayInputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ByteArraySource implements Source {
    public ByteArrayInputStream arrayInputStream;
    public final byte[] data;

    public ByteArraySource(byte[] bArr) {
        this.data = bArr;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Source
    public void close() throws ProxyCacheException {
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Source
    public long length() throws ProxyCacheException {
        return this.data.length;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Source
    public void open(long j10) throws ProxyCacheException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.data);
        this.arrayInputStream = byteArrayInputStream;
        byteArrayInputStream.skip(j10);
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Source
    public int read(byte[] bArr) throws ProxyCacheException {
        return this.arrayInputStream.read(bArr, 0, bArr.length);
    }
}
