package com.tencent.liteav.videoconsumer.decoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;
import com.tencent.liteav.videoconsumer.decoder.ad;
import com.tencent.liteav.videoconsumer.decoder.b;
import com.tencent.liteav.videoconsumer.decoder.u;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final u f44024a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f44025b;

    /* renamed from: c, reason: collision with root package name */
    private final bl f44026c;

    private v(u uVar, Object obj, bl blVar) {
        this.f44024a = uVar;
        this.f44025b = obj;
        this.f44026c = blVar;
    }

    public static Runnable a(u uVar, Object obj, bl blVar) {
        return new v(uVar, obj, blVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        u uVar = this.f44024a;
        Object obj = this.f44025b;
        bl blVar = this.f44026c;
        LiteavLog.i(uVar.f44000a, "Start decoder with eglContext:%s", obj);
        long currentTimeMillis = System.currentTimeMillis();
        if (uVar.f44003d != null) {
            LiteavLog.w(uVar.f44000a, "Decoder already started.");
            return;
        }
        u.a aVar = uVar.f44009j;
        String str = aVar.f44017b ? "video/hevc" : com.alibaba.security.biometrics.service.build.ah.f2598d;
        MediaFormat mediaFormat = aVar.f44021f;
        if (mediaFormat != null) {
            str = mediaFormat.getString(DatabaseSourceInfoStorage.COLUMN_MIME);
        }
        b.a.a();
        int a10 = b.a(str);
        u.a aVar2 = uVar.f44009j;
        if (aVar2.f44016a) {
            ae aeVar = new ae(uVar.f44008i, aVar2.f44020e, uVar.f44001b, aVar2.f44022g, uVar, uVar.f44004e);
            uVar.f44003d = aeVar;
            aeVar.a(uVar.f44002c);
        } else if (aVar2.f44018c && ag.a(a10)) {
            com.tencent.liteav.videobase.utils.h hVar = uVar.f44008i;
            u.a aVar3 = uVar.f44009j;
            uVar.f44003d = new ag(hVar, aVar3.f44020e, uVar.f44001b, aVar3.f44022g, uVar, uVar.f44004e);
        } else {
            com.tencent.liteav.videobase.utils.h hVar2 = uVar.f44008i;
            u.a aVar4 = uVar.f44009j;
            uVar.f44003d = new ah(hVar2, aVar4.f44020e, uVar.f44001b, aVar4.f44022g, uVar, uVar.f44004e);
        }
        ad adVar = uVar.f44003d;
        adVar.f43833e = uVar.f44007h && uVar.f44006g == VideoDecoderDef.ConsumerScene.RTC;
        adVar.a(obj);
        uVar.f44005f = blVar;
        ad.a a11 = uVar.f44003d.a(uVar.f44009j.f44019d, uVar.f44010k);
        boolean z10 = uVar.f44009j.f44019d && a11.f43841a;
        if (!a11.f43841a) {
            a11 = uVar.f44003d.a(false, (MediaCodec) null);
        }
        if (a11.f43841a) {
            bl blVar2 = uVar.f44005f;
            if (blVar2 != null) {
                blVar2.a(z10);
            }
            uVar.f44001b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_DECODER_CODEC_COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            uVar.f44001b.notifyEvent(h.b.EVT_VIDEO_DECODE_START_SUCCESS, (Object) null, "Start decoder success");
            return;
        }
        uVar.a();
        uVar.b(a11.f43842b, a11.f43843c);
        uVar.f44001b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_HW_DECODE_START_ERROR_TYPE, Integer.valueOf(a11.f43842b.mValue));
    }
}
