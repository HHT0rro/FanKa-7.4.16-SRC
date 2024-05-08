package com.alimm.tanx.core.view.player.cache.videocache.sourcestorage;

import com.alimm.tanx.core.view.player.cache.videocache.SourceInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface SourceInfoStorage {
    SourceInfo get(String str);

    void put(String str, SourceInfo sourceInfo);

    void release();
}
