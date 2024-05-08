package com.kwad.framework.filedownloader.a;

import com.kwad.framework.filedownloader.f.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements c.a {
    @Override // com.kwad.framework.filedownloader.f.c.a
    public final int O(long j10) {
        if (j10 < 1048576) {
            return 1;
        }
        if (j10 < 5242880) {
            return 2;
        }
        if (j10 < 52428800) {
            return 3;
        }
        return j10 < 104857600 ? 4 : 5;
    }
}
