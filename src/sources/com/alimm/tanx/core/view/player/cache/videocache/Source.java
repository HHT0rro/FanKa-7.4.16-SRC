package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface Source {
    void close() throws ProxyCacheException;

    long length() throws ProxyCacheException;

    void open(long j10) throws ProxyCacheException;

    int read(byte[] bArr) throws ProxyCacheException;
}
