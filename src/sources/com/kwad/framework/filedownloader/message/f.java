package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.download.d;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.a;
import com.kwad.framework.filedownloader.message.d;
import com.kwad.framework.filedownloader.message.h;
import java.io.File;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f {
    public static MessageSnapshot a(int i10, File file, boolean z10) {
        long length = file.length();
        if (length > ZipUtils.UPPER_UNIXTIME_BOUND) {
            if (z10) {
                return new d.a(i10, true, length);
            }
            return new d.b(i10, true, length);
        }
        if (z10) {
            return new h.a(i10, true, (int) length);
        }
        return new h.b(i10, true, (int) length);
    }

    public static MessageSnapshot e(com.kwad.framework.filedownloader.a aVar) {
        if (aVar.ub()) {
            return new d.e(aVar.getId(), aVar.tT(), aVar.tU());
        }
        return new h.e(aVar.getId(), aVar.getSmallFileSoFarBytes(), aVar.getSmallFileTotalBytes());
    }

    public static MessageSnapshot t(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.tV() == -3) {
            return new a.C0501a(messageSnapshot);
        }
        throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.tV())));
    }

    public static MessageSnapshot a(int i10, long j10, long j11, boolean z10) {
        if (j11 > ZipUtils.UPPER_UNIXTIME_BOUND) {
            if (z10) {
                return new d.i(i10, j10, j11);
            }
            return new d.j(i10, j10, j11);
        }
        if (z10) {
            return new h.i(i10, (int) j10, (int) j11);
        }
        return new h.j(i10, (int) j10, (int) j11);
    }

    public static MessageSnapshot a(int i10, long j10, Throwable th) {
        if (j10 > ZipUtils.UPPER_UNIXTIME_BOUND) {
            return new d.C0502d(i10, j10, th);
        }
        return new h.d(i10, (int) j10, th);
    }

    public static MessageSnapshot a(byte b4, com.kwad.framework.filedownloader.d.c cVar, d.a aVar) {
        MessageSnapshot dVar;
        IllegalStateException illegalStateException;
        int id2 = cVar.getId();
        if (b4 == -4) {
            throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("please use #catchWarn instead %d", Integer.valueOf(id2)));
        }
        if (b4 == -3) {
            if (cVar.ub()) {
                return new d.b(id2, false, cVar.getTotal());
            }
            return new h.b(id2, false, (int) cVar.getTotal());
        }
        if (b4 != -1) {
            if (b4 == 1) {
                if (cVar.ub()) {
                    return new d.f(id2, cVar.wl(), cVar.getTotal());
                }
                return new h.f(id2, (int) cVar.wl(), (int) cVar.getTotal());
            }
            if (b4 == 2) {
                String filename = cVar.tR() ? cVar.getFilename() : null;
                if (cVar.ub()) {
                    return new d.c(id2, aVar.vQ(), cVar.getTotal(), cVar.wm(), filename);
                }
                return new h.c(id2, aVar.vQ(), (int) cVar.getTotal(), cVar.wm(), filename);
            }
            if (b4 == 3) {
                if (cVar.ub()) {
                    return new d.g(id2, cVar.wl());
                }
                return new h.g(id2, (int) cVar.wl());
            }
            if (b4 != 5) {
                if (b4 != 6) {
                    String b10 = com.kwad.framework.filedownloader.f.f.b("it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b4));
                    com.kwad.framework.filedownloader.f.d.d(f.class, "it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b4));
                    if (aVar.getException() != null) {
                        illegalStateException = new IllegalStateException(b10, aVar.getException());
                    } else {
                        illegalStateException = new IllegalStateException(b10);
                    }
                    if (cVar.ub()) {
                        return new d.C0502d(id2, cVar.wl(), illegalStateException);
                    }
                    return new h.d(id2, (int) cVar.wl(), illegalStateException);
                }
                return new MessageSnapshot.b(id2);
            }
            if (cVar.ub()) {
                dVar = new d.h(id2, cVar.wl(), aVar.getException(), aVar.tZ());
            } else {
                dVar = new h.C0503h(id2, (int) cVar.wl(), aVar.getException(), aVar.tZ());
            }
        } else if (cVar.ub()) {
            dVar = new d.C0502d(id2, cVar.wl(), aVar.getException());
        } else {
            dVar = new h.d(id2, (int) cVar.wl(), aVar.getException());
        }
        return dVar;
    }
}
