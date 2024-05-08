package com.alimm.tanx.core.view.player.cache.videocache.sourcestorage;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SourceInfoStorageFactory {
    public static SourceInfoStorage newEmptySourceInfoStorage() {
        return new NoSourceInfoStorage();
    }

    public static SourceInfoStorage newSourceInfoStorage(Context context) {
        return new DatabaseSourceInfoStorage(context);
    }
}
