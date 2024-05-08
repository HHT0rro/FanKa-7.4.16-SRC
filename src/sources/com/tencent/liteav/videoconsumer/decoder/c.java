package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.liteav.videobase.common.MediaCodecAbility;
import com.tencent.liteav.videoconsumer.consumer.VideoConsumerServerConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43931a;

    private c(b bVar) {
        this.f43931a = bVar;
    }

    public static Runnable a(b bVar) {
        return new c(bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.tencent.liteav.base.storage.PersistStorage] */
    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43931a;
        ?? isDecoderSupportHevc = !VideoConsumerServerConfig.isHWHevcDecodeAllowed() ? 0 : MediaCodecAbility.isDecoderSupportHevc();
        ?? persistStorage = new PersistStorage(PersistStorage.GLOBAL_DOMAIN);
        persistStorage.put("Liteav.Video.android.local.decoder.enable.hw.hevc", isDecoderSupportHevc);
        synchronized (bVar) {
            bVar.f43885a.f43814c = b.a();
        }
        persistStorage.put("Liteav.Video.android.local.decoder.enable.sw.mediacodec.hevc", VideoConsumerServerConfig.isHWHevcDecodeAllowed() ? MediaCodecAbility.isMediaCodecSWHevcDecodeSupport() : 0);
        int b4 = b.b(com.alibaba.security.biometrics.service.build.ah.f2598d);
        if (b4 > 0) {
            persistStorage.put("Liteav.Video.android.local.decoder.avc.color.format", b4);
        }
        int b10 = b.b("video/hevc");
        if (b10 > 0) {
            persistStorage.put("Liteav.Video.android.local.decoder.hevc.color.format", b10);
        }
        persistStorage.commit();
    }
}
