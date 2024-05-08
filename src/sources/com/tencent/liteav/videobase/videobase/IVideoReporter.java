package com.tencent.liteav.videobase.videobase;

import com.tencent.liteav.videobase.videobase.h;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IVideoReporter {
    void notifyError(h.a aVar, String str);

    void notifyEvent(h.b bVar, int i10, String str);

    void notifyEvent(h.b bVar, Object obj, String str);

    void notifyWarning(h.c cVar, String str);

    void updateStatus(i iVar, int i10, Object obj);

    void updateStatus(i iVar, Object obj);
}
