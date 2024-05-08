package com.tencent.liteav.videobase.utils;

import android.content.Intent;
import androidx.annotation.Nullable;
import com.tencent.liteav.base.util.LiteavLog;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final com.tencent.liteav.base.b.a f43528a = new com.tencent.liteav.base.b.a(1000);

    @Nullable
    public static byte[] a(int i10) {
        try {
            return new byte[i10];
        } catch (OutOfMemoryError e2) {
            a(e2.getMessage());
            return null;
        }
    }

    @Nullable
    public static ByteBuffer b(int i10) {
        try {
            return ByteBuffer.allocateDirect(i10);
        } catch (OutOfMemoryError e2) {
            a(e2.getMessage());
            return null;
        }
    }

    private static synchronized void a(String str) {
        synchronized (j.class) {
            if (f43528a.a()) {
                LiteavLog.e("MemoryAllocator", "allocate buffer failed with oom error, msg:".concat(String.valueOf(str)));
                i.a().a(new Intent("com.tencent.liteav.video.action.OUT_OF_MEMORY"));
            }
        }
    }
}
