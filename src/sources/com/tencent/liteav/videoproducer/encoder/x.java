package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import com.nirvana.tools.logger.cache.db.DBHelpTool;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public boolean f44724a = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f44725b = true;

    /* renamed from: c, reason: collision with root package name */
    private final MediaCodec f44726c;

    /* renamed from: d, reason: collision with root package name */
    private final String f44727d;

    /* renamed from: e, reason: collision with root package name */
    private final VideoEncodeParams f44728e;

    /* renamed from: f, reason: collision with root package name */
    private final ServerVideoProducerConfig f44729f;

    /* renamed from: com.tencent.liteav.videoproducer.encoder.x$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44730a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f44731b;

        static {
            int[] iArr = new int[VideoEncoderDef.EncoderProfile.values().length];
            f44731b = iArr;
            try {
                iArr[VideoEncoderDef.EncoderProfile.PROFILE_MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44731b[VideoEncoderDef.EncoderProfile.PROFILE_HIGH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44731b[VideoEncoderDef.EncoderProfile.PROFILE_BASELINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[VideoEncoderDef.BitrateMode.values().length];
            f44730a = iArr2;
            try {
                iArr2[VideoEncoderDef.BitrateMode.CBR.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f44730a[VideoEncoderDef.BitrateMode.VBR.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f44730a[VideoEncoderDef.BitrateMode.CQ.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public x(MediaCodec mediaCodec, String str, VideoEncodeParams videoEncodeParams, ServerVideoProducerConfig serverVideoProducerConfig) {
        this.f44726c = mediaCodec;
        this.f44727d = str;
        this.f44728e = videoEncodeParams;
        this.f44729f = serverVideoProducerConfig;
    }

    @RequiresApi(api = 21)
    private boolean a(int i10, MediaCodecInfo.EncoderCapabilities encoderCapabilities) {
        ServerVideoProducerConfig serverVideoProducerConfig;
        Boolean isHardwareEncoderBitrateModeCBRSupported;
        if (i10 == 2 && (serverVideoProducerConfig = this.f44729f) != null && (isHardwareEncoderBitrateModeCBRSupported = serverVideoProducerConfig.isHardwareEncoderBitrateModeCBRSupported()) != null) {
            return isHardwareEncoderBitrateModeCBRSupported.booleanValue();
        }
        return encoderCapabilities.isBitrateModeSupported(i10);
    }

    @RequiresApi(api = 23)
    private static Pair<Integer, Integer> a(MediaFormat mediaFormat) {
        int i10;
        int i11 = 0;
        try {
            i10 = mediaFormat.getInteger("profile");
        } catch (Throwable th) {
            LiteavLog.i("MediaFormatBuilder", "get profile fail.", th);
            i10 = 0;
        }
        try {
            i11 = mediaFormat.getInteger(DBHelpTool.RecordEntry.COLUMN_NAME_LEVEL);
        } catch (Throwable th2) {
            LiteavLog.i("MediaFormatBuilder", "get level fail.", th2);
        }
        return new Pair<>(Integer.valueOf(i10), Integer.valueOf(i11));
    }

    @RequiresApi(api = 21)
    private MediaCodecInfo.VideoCapabilities a(int i10, int i11) {
        MediaCodecInfo.CodecCapabilities createFromProfileLevel;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 21 && (createFromProfileLevel = MediaCodecInfo.CodecCapabilities.createFromProfileLevel(this.f44727d, i10, i11)) != null) {
            return createFromProfileLevel.getVideoCapabilities();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.media.MediaFormat a() {
        /*
            Method dump skipped, instructions count: 1144
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.encoder.x.a():android.media.MediaFormat");
    }
}
