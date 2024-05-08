package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.g;
import java.util.UUID;

/* compiled from: MediaDrmCallback.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface j {
    byte[] a(UUID uuid, g.a aVar) throws MediaDrmCallbackException;

    byte[] b(UUID uuid, g.d dVar) throws MediaDrmCallbackException;
}
