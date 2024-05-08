package com.tencent.liteav.videoconsumer.decoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videoconsumer.decoder.ad;
import com.tencent.liteav.videoconsumer.decoder.b;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ag extends ad {

    /* renamed from: i, reason: collision with root package name */
    private int f43847i;

    /* renamed from: j, reason: collision with root package name */
    private int f43848j;

    public ag(com.tencent.liteav.videobase.utils.h hVar, Size size, IVideoReporter iVideoReporter, boolean z10, ad.b bVar, CustomHandler customHandler) {
        super(hVar, size, iVideoReporter, z10, bVar, customHandler);
        this.f43847i = 0;
        this.f43848j = 0;
        this.f43829a = "MediaCodecOutputBufferDecoder";
    }

    public static boolean a(int i10) {
        return i10 == 19 || i10 == 21;
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ad
    public final void a(MediaCodec mediaCodec) {
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00f2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00f3  */
    @Override // com.tencent.liteav.videoconsumer.decoder.ad
    @androidx.annotation.RequiresApi(api = 21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(android.media.MediaCodec r25, android.media.MediaCodec.BufferInfo r26, int r27) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoconsumer.decoder.ag.a(android.media.MediaCodec, android.media.MediaCodec$BufferInfo, int):boolean");
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ad
    public final boolean a(Object obj) {
        return true;
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ad
    public final void a(MediaFormat mediaFormat) {
        LiteavLog.i(this.f43829a, "decode output format changed: ".concat(String.valueOf(mediaFormat)));
        int integer = mediaFormat.getInteger("width");
        int integer2 = mediaFormat.getInteger("height");
        this.f43847i = integer;
        this.f43848j = integer2;
        if (mediaFormat.containsKey("stride")) {
            this.f43847i = mediaFormat.getInteger("stride");
        }
        if (mediaFormat.containsKey("slice-height")) {
            this.f43848j = mediaFormat.getInteger("slice-height");
        }
        this.f43847i = Math.max(integer, this.f43847i);
        this.f43848j = Math.max(integer2, this.f43848j);
    }

    private static int a(MediaFormat mediaFormat, String str) {
        if (mediaFormat.containsKey(str)) {
            return mediaFormat.getInteger(str);
        }
        return 2;
    }

    private static void a(ByteBuffer byteBuffer, int i10, ByteBuffer byteBuffer2, int i11, int i12, int i13, int i14) {
        OpenGlUtils.nativeCopyYuvFromByteBufferToByteBuffer(byteBuffer, i10, byteBuffer2, i11, i12, i13, i14);
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ad
    public final boolean a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        b.a.a();
        int a10 = b.a(mediaFormat.getString(DatabaseSourceInfoStorage.COLUMN_MIME));
        if (a10 <= 0) {
            return false;
        }
        mediaFormat.setInteger("color-format", a10);
        am.a(mediaCodec, mediaFormat, null);
        return true;
    }
}
