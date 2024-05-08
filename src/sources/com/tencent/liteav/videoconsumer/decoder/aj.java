package com.tencent.liteav.videoconsumer.decoder;

import android.media.ImageReader;
import android.media.MediaCodec;
import android.media.MediaFormat;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class aj implements ac {

    /* renamed from: b, reason: collision with root package name */
    public MediaFormat f43859b;

    /* renamed from: c, reason: collision with root package name */
    public MediaCodec f43860c;

    /* renamed from: d, reason: collision with root package name */
    public ImageReader f43861d;

    /* renamed from: a, reason: collision with root package name */
    public String f43858a = "MediaCodecPreload";

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.liteav.base.util.l f43862e = new com.tencent.liteav.base.util.l(1, "MediaCodecPreload");

    @Override // com.tencent.liteav.videoconsumer.decoder.ac
    public final void a(MediaFormat mediaFormat) {
        this.f43862e.a(ak.a(this, mediaFormat), 500L);
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ac
    @Nullable
    public final MediaCodec b(MediaFormat mediaFormat) {
        MediaCodec mediaCodec;
        MediaFormat mediaFormat2;
        synchronized (this) {
            mediaCodec = this.f43860c;
            mediaFormat2 = this.f43859b;
        }
        if (mediaFormat2 == null) {
            a();
            return null;
        }
        try {
            int integer = mediaFormat2.getInteger("width");
            int integer2 = mediaFormat2.getInteger("height");
            String string = mediaFormat2.getString(DatabaseSourceInfoStorage.COLUMN_MIME);
            int integer3 = mediaFormat.getInteger("width");
            int integer4 = mediaFormat.getInteger("height");
            String string2 = mediaFormat.getString(DatabaseSourceInfoStorage.COLUMN_MIME);
            LiteavLog.i(this.f43858a, "get preload MediaCodec, preloadFormat:" + ((Object) mediaFormat2) + ", realFormat:" + ((Object) mediaFormat));
            if (integer3 <= integer && integer4 <= integer2 && integer3 * integer4 <= integer * integer2 && string.equals(string2)) {
                synchronized (this) {
                    this.f43860c = null;
                }
                return mediaCodec;
            }
            a();
            return null;
        } catch (Exception unused) {
            a();
            return null;
        }
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ac
    public final void a() {
        this.f43862e.a(al.a(this));
    }

    public final void a(MediaCodec mediaCodec) {
        try {
            try {
                if (mediaCodec == null) {
                    return;
                }
                try {
                    LiteavLog.i(this.f43858a, "preload MediaCodec stop");
                    mediaCodec.stop();
                    LiteavLog.i(this.f43858a, "preload MediaCodec release");
                    mediaCodec.release();
                } catch (Exception e2) {
                    LiteavLog.e(this.f43858a, "preload MediaCodec stop failed." + e2.getMessage());
                    LiteavLog.i(this.f43858a, "preload MediaCodec release");
                    mediaCodec.release();
                }
            } catch (Exception e10) {
                LiteavLog.e(this.f43858a, "preload MediaCodec release failed.", e10);
            }
        } catch (Throwable th) {
            try {
                LiteavLog.i(this.f43858a, "preload MediaCodec release");
                mediaCodec.release();
            } catch (Exception e11) {
                LiteavLog.e(this.f43858a, "preload MediaCodec release failed.", e11);
            }
            throw th;
        }
    }

    public final void b() {
        ImageReader imageReader = this.f43861d;
        if (imageReader != null) {
            imageReader.close();
            this.f43861d = null;
        }
    }
}
