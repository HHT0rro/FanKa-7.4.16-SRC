package com.bytedance.pangle.g;

import android.system.Os;
import android.system.OsConstants;
import java.io.FileDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class l implements k {

    /* renamed from: a, reason: collision with root package name */
    private static final long f10797a = Os.sysconf(OsConstants._SC_PAGESIZE);

    /* renamed from: b, reason: collision with root package name */
    private final FileDescriptor f10798b;

    /* renamed from: c, reason: collision with root package name */
    private final long f10799c;

    /* renamed from: d, reason: collision with root package name */
    private final long f10800d;

    public l(FileDescriptor fileDescriptor, long j10, long j11) {
        this.f10798b = fileDescriptor;
        this.f10799c = j10;
        this.f10800d = j11;
    }

    @Override // com.bytedance.pangle.g.k
    public final long a() {
        return this.f10800d;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.pangle.g.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.bytedance.pangle.g.j r20, long r21, int r23) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.g.l.a(com.bytedance.pangle.g.j, long, int):void");
    }
}
