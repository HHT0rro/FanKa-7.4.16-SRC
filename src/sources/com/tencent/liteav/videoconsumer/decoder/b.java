package com.tencent.liteav.videoconsumer.decoder;

import android.media.MediaCodec;
import android.text.TextUtils;
import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.consumer.VideoConsumerServerConfig;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {

    /* renamed from: a */
    public final VideoDecoderDef.DecodeAbility f43885a;

    /* renamed from: b */
    private final com.tencent.liteav.base.util.l f43886b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a */
        private static final b f43887a = new b((byte) 0);

        public static /* synthetic */ b a() {
            return f43887a;
        }
    }

    public /* synthetic */ b(byte b4) {
        this();
    }

    public static boolean a() {
        return b() || SoftwareVideoDecoder.nativeIsSoftwareHevcDecoderSupport();
    }

    public static boolean b() {
        if (!VideoConsumerServerConfig.isHWHevcDecodeAllowed()) {
            return false;
        }
        Integer num = new PersistStorage(PersistStorage.GLOBAL_DOMAIN).getInt("Liteav.Video.android.local.decoder.enable.hw.hevc");
        return num == null || num.intValue() > 0;
    }

    private b() {
        VideoDecoderDef.DecodeAbility decodeAbility = new VideoDecoderDef.DecodeAbility();
        this.f43885a = decodeAbility;
        com.tencent.liteav.base.util.l lVar = new com.tencent.liteav.base.util.l();
        this.f43886b = lVar;
        lVar.a(c.a(this));
        synchronized (this) {
            decodeAbility.f43814c = a();
        }
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        PersistStorage persistStorage = new PersistStorage(PersistStorage.GLOBAL_DOMAIN);
        Integer num = null;
        if (str.equals(com.alibaba.security.biometrics.service.build.ah.f2598d)) {
            num = persistStorage.getInt("Liteav.Video.android.local.decoder.avc.color.format");
        } else if (str.equals("video/hevc")) {
            num = persistStorage.getInt("Liteav.Video.android.local.decoder.hevc.color.format");
        }
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static int b(String str) {
        int i10;
        int i11 = 0;
        try {
            int[] iArr = MediaCodec.createDecoderByType(str).getCodecInfo().getCapabilitiesForType(str).colorFormats;
            int length = iArr.length;
            int i12 = 0;
            while (true) {
                i10 = 21;
                if (i12 >= length) {
                    i10 = 0;
                    break;
                }
                int i13 = iArr[i12];
                if (i13 == 19) {
                    i10 = 19;
                    break;
                }
                if (i13 != 21) {
                    i12++;
                }
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            LiteavLog.i("DecodeAbilityProvider", "decoder(%s) support color format %d ", str, Integer.valueOf(i10));
            return i10;
        } catch (Throwable th2) {
            th = th2;
            i11 = i10;
            LiteavLog.e("DecodeAbilityProvider", "get support color format error ", th);
            return i11;
        }
    }
}
