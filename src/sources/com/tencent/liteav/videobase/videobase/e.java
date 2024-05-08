package com.tencent.liteav.videobase.videobase;

import com.tencent.liteav.base.Log;
import com.tencent.liteav.videobase.videobase.h;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class e implements IVideoReporter {
    private static final String TAG = "NativeVideoReporter";
    public long mNativeVideoReporter;

    public abstract void nativeNotifyError(long j10, int i10, String str);

    public abstract void nativeNotifyEvent(long j10, int i10, Object obj, String str);

    public abstract void nativeNotifyKeyEvent(long j10, int i10, int i11, String str);

    public abstract void nativeNotifyKeyWarning(long j10, int i10, int i11, String str);

    public abstract void nativeNotifyWarning(long j10, int i10, String str);

    public abstract void nativeUpdateKeyStatus(long j10, int i10, int i11, double d10);

    public abstract void nativeUpdateKeyStatusObject(long j10, int i10, int i11, Object obj);

    public abstract void nativeUpdateStatus(long j10, int i10, double d10);

    public abstract void nativeUpdateStatusObject(long j10, int i10, Object obj);

    public abstract void nativeUpdateStatusString(long j10, int i10, String str);

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public synchronized void notifyError(h.a aVar, String str) {
        if (this.mNativeVideoReporter != 0) {
            int a10 = h.a(aVar);
            if (a10 != 0) {
                nativeNotifyError(this.mNativeVideoReporter, a10, str);
                return;
            }
            Log.i(TAG, "notifyError error code:" + ((Object) aVar) + ", do not need transfer to LiteAvCode:" + a10, new Object[0]);
        }
    }

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public synchronized void notifyEvent(h.b bVar, Object obj, String str) {
        if (this.mNativeVideoReporter == 0) {
            return;
        }
        int a10 = h.a(bVar);
        if (a10 != 0) {
            if (h.b(bVar)) {
                nativeNotifyWarning(this.mNativeVideoReporter, a10, str);
                return;
            } else {
                nativeNotifyEvent(this.mNativeVideoReporter, a10, obj, str);
                return;
            }
        }
        Log.i(TAG, "notifyEvent event code:" + ((Object) bVar) + ", do not need transfer to LiteAvCode:" + a10, new Object[0]);
    }

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public synchronized void notifyWarning(h.c cVar, String str) {
        if (this.mNativeVideoReporter != 0) {
            int a10 = h.a(cVar);
            if (a10 != 0) {
                nativeNotifyWarning(this.mNativeVideoReporter, a10, str);
                return;
            }
            Log.i(TAG, "notifyWarning warning code:" + ((Object) cVar) + ", do not need transfer to LiteAvCode:" + a10, new Object[0]);
        }
    }

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public synchronized void updateStatus(i iVar, Object obj) {
        long j10 = this.mNativeVideoReporter;
        if (j10 != 0) {
            int i10 = iVar.value;
            if (i10 < i.STATUS_VIDEO_CAPTURE_FRAME.value) {
                return;
            }
            if (obj instanceof Double) {
                nativeUpdateStatus(this.mNativeVideoReporter, iVar.value, ((Double) obj).doubleValue());
                return;
            }
            if (obj instanceof Float) {
                nativeUpdateStatus(this.mNativeVideoReporter, iVar.value, ((Float) obj).floatValue());
                return;
            }
            if (obj instanceof Long) {
                nativeUpdateStatus(this.mNativeVideoReporter, iVar.value, ((Long) obj).longValue());
            } else if (obj instanceof Integer) {
                nativeUpdateStatus(this.mNativeVideoReporter, iVar.value, ((Integer) obj).intValue());
            } else {
                if (obj instanceof String) {
                    nativeUpdateStatusString(j10, i10, (String) obj);
                    return;
                }
                nativeUpdateStatusObject(j10, i10, obj);
            }
        }
    }

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public synchronized void notifyEvent(h.b bVar, int i10, String str) {
        if (this.mNativeVideoReporter == 0) {
            return;
        }
        int a10 = h.a(bVar);
        if (a10 != 0) {
            if (h.b(bVar)) {
                nativeNotifyKeyWarning(this.mNativeVideoReporter, a10, i10, str);
                return;
            } else {
                nativeNotifyKeyEvent(this.mNativeVideoReporter, a10, i10, str);
                return;
            }
        }
        Log.i(TAG, "notifyEvent event code:" + ((Object) bVar) + ", do not need transfer to LiteAvCode:" + a10, new Object[0]);
    }

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public synchronized void updateStatus(i iVar, int i10, Object obj) {
        long j10 = this.mNativeVideoReporter;
        if (j10 != 0) {
            int i11 = iVar.value;
            if (i11 < i.STATUS_VIDEO_CAPTURE_FRAME.value) {
                return;
            }
            if (obj instanceof Double) {
                nativeUpdateKeyStatus(this.mNativeVideoReporter, iVar.value, i10, ((Double) obj).doubleValue());
                return;
            }
            if (obj instanceof Float) {
                nativeUpdateKeyStatus(this.mNativeVideoReporter, iVar.value, i10, ((Float) obj).floatValue());
            } else if (obj instanceof Integer) {
                nativeUpdateKeyStatus(this.mNativeVideoReporter, iVar.value, i10, ((Integer) obj).intValue());
            } else {
                if (obj instanceof Long) {
                    nativeUpdateKeyStatus(this.mNativeVideoReporter, iVar.value, i10, ((Long) obj).longValue());
                    return;
                }
                nativeUpdateKeyStatusObject(j10, i11, i10, obj);
            }
        }
    }
}
