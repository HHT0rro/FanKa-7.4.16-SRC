package com.tencent.cloud.huiyansdkface.record.h264;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.view.Surface;
import com.alibaba.security.biometrics.service.build.ah;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.record.h264.CodecManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.Arrays;
import sun.util.locale.LanguageTag;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class EncoderDebugger {
    public static final String TAG = "EncoderDebugger";

    /* renamed from: a, reason: collision with root package name */
    private int f42148a;

    /* renamed from: b, reason: collision with root package name */
    private String f42149b;

    /* renamed from: c, reason: collision with root package name */
    private String f42150c;

    /* renamed from: d, reason: collision with root package name */
    private MediaCodec f42151d;

    /* renamed from: e, reason: collision with root package name */
    private int f42152e;

    /* renamed from: f, reason: collision with root package name */
    private int f42153f;

    /* renamed from: g, reason: collision with root package name */
    private int f42154g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f42155h;

    /* renamed from: i, reason: collision with root package name */
    private byte[] f42156i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f42157j;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f42158k;

    /* renamed from: l, reason: collision with root package name */
    private NV21Convert f42159l;

    /* renamed from: m, reason: collision with root package name */
    private SharedPreferences f42160m;

    /* renamed from: n, reason: collision with root package name */
    private byte[][] f42161n;

    /* renamed from: o, reason: collision with root package name */
    private byte[][] f42162o;

    /* renamed from: p, reason: collision with root package name */
    private String f42163p;

    /* renamed from: q, reason: collision with root package name */
    private String f42164q;

    private EncoderDebugger(SharedPreferences sharedPreferences, int i10, int i11) {
        WLogger.e(TAG, TAG);
        this.f42160m = sharedPreferences;
        this.f42152e = i10;
        this.f42153f = i11;
        this.f42154g = i10 * i11;
        a();
    }

    private void a() {
        this.f42159l = new NV21Convert();
        this.f42161n = new byte[50];
        this.f42162o = new byte[34];
        this.f42150c = "";
        this.f42156i = null;
        this.f42155h = null;
    }

    private void a(boolean z10) {
        String str = this.f42152e + LanguageTag.PRIVATEUSE + this.f42153f + "-";
        SharedPreferences.Editor edit = this.f42160m.edit();
        edit.putBoolean("libstreaming-" + str + "success", z10);
        if (z10) {
            edit.putInt("libstreaming-" + str + "lastSdk", Build.VERSION.SDK_INT);
            edit.putInt("libstreaming-" + str + "lastVersion", 3);
            edit.putInt("libstreaming-" + str + "sliceHeight", this.f42159l.getSliceHeight());
            edit.putInt("libstreaming-" + str + "stride", this.f42159l.getStride());
            edit.putInt("libstreaming-" + str + "padding", this.f42159l.getYPadding());
            edit.putBoolean("libstreaming-" + str + "planar", this.f42159l.getPlanar());
            edit.putBoolean("libstreaming-" + str + "reversed", this.f42159l.getUVPanesReversed());
            edit.putString("libstreaming-" + str + "encoderName", this.f42149b);
            edit.putInt("libstreaming-" + str + "colorFormat", this.f42148a);
            edit.putString("libstreaming-" + str + "encoderName", this.f42149b);
            edit.putString("libstreaming-" + str + "pps", this.f42163p);
            edit.putString("libstreaming-" + str + "sps", this.f42164q);
        }
        edit.commit();
    }

    private void a(boolean z10, String str) {
        if (z10) {
            return;
        }
        WLogger.e(TAG, str);
        throw new IllegalStateException(str);
    }

    private void b() {
        if (!c()) {
            String str = this.f42152e + LanguageTag.PRIVATEUSE + this.f42153f + "-";
            if (!this.f42160m.getBoolean("libstreaming-" + str + "success", false)) {
                throw new RuntimeException("Phone not supported with this resolution (" + this.f42152e + LanguageTag.PRIVATEUSE + this.f42153f + ")");
            }
            this.f42159l.setSize(this.f42152e, this.f42153f);
            this.f42159l.setSliceHeight(this.f42160m.getInt("libstreaming-" + str + "sliceHeight", 0));
            this.f42159l.setStride(this.f42160m.getInt("libstreaming-" + str + "stride", 0));
            this.f42159l.setYPadding(this.f42160m.getInt("libstreaming-" + str + "padding", 0));
            this.f42159l.setPlanar(this.f42160m.getBoolean("libstreaming-" + str + "planar", false));
            this.f42159l.setColorPanesReversed(this.f42160m.getBoolean("libstreaming-" + str + "reversed", false));
            this.f42149b = this.f42160m.getString("libstreaming-" + str + "encoderName", "");
            this.f42148a = this.f42160m.getInt("libstreaming-" + str + "colorFormat", 0);
            this.f42163p = this.f42160m.getString("libstreaming-" + str + "pps", "");
            this.f42164q = this.f42160m.getString("libstreaming-" + str + "sps", "");
            return;
        }
        WLogger.d(TAG, ">>>> Testing the phone for resolution " + this.f42152e + LanguageTag.PRIVATEUSE + this.f42153f);
        CodecManager.a[] findEncodersForMimeType = CodecManager.findEncodersForMimeType(ah.f2598d);
        int i10 = 0;
        for (CodecManager.a aVar : findEncodersForMimeType) {
            i10 += aVar.f42147b.length;
        }
        int i11 = 1;
        for (int i12 = 0; i12 < findEncodersForMimeType.length; i12++) {
            int i13 = 0;
            while (i13 < findEncodersForMimeType[i12].f42147b.length) {
                a();
                this.f42149b = findEncodersForMimeType[i12].f42146a;
                this.f42148a = findEncodersForMimeType[i12].f42147b[i13].intValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(">> Test ");
                int i14 = i11 + 1;
                sb2.append(i11);
                sb2.append("/");
                sb2.append(i10);
                sb2.append(": ");
                sb2.append(this.f42149b);
                sb2.append(" with color format ");
                sb2.append(this.f42148a);
                sb2.append(" at ");
                sb2.append(this.f42152e);
                sb2.append(LanguageTag.PRIVATEUSE);
                sb2.append(this.f42153f);
                WLogger.v(TAG, sb2.toString());
                this.f42159l.setSize(this.f42152e, this.f42153f);
                this.f42159l.setSliceHeight(this.f42153f);
                this.f42159l.setStride(this.f42152e);
                this.f42159l.setYPadding(0);
                this.f42159l.setEncoderColorFormat(this.f42148a);
                d();
                this.f42157j = this.f42159l.convert(this.f42158k);
                try {
                    try {
                        e();
                        g();
                        a(true);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("The encoder ");
                        sb3.append(this.f42149b);
                        sb3.append(" is usable with resolution ");
                        sb3.append(this.f42152e);
                        sb3.append(LanguageTag.PRIVATEUSE);
                        sb3.append(this.f42153f);
                        return;
                    } catch (Exception e2) {
                        StringWriter stringWriter = new StringWriter();
                        e2.printStackTrace(new PrintWriter(stringWriter));
                        String stringWriter2 = stringWriter.toString();
                        String str2 = "Encoder " + this.f42149b + " cannot be used with color format " + this.f42148a;
                        WLogger.e(TAG, str2 + "," + e2.toString());
                        this.f42150c += str2 + "\n" + stringWriter2;
                        e2.printStackTrace();
                        f();
                        i13++;
                        i11 = i14;
                    }
                } finally {
                    f();
                }
            }
        }
        a(false);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("No usable encoder were found on the phone for resolution ");
        sb4.append(this.f42152e);
        sb4.append(LanguageTag.PRIVATEUSE);
        sb4.append(this.f42153f);
        throw new RuntimeException("No usable encoder were found on the phone for resolution " + this.f42152e + LanguageTag.PRIVATEUSE + this.f42153f);
    }

    private boolean c() {
        String str = this.f42152e + LanguageTag.PRIVATEUSE + this.f42153f + "-";
        SharedPreferences sharedPreferences = this.f42160m;
        if (sharedPreferences == null) {
            return true;
        }
        if (sharedPreferences.contains("libstreaming-" + str + "lastSdk")) {
            int i10 = this.f42160m.getInt("libstreaming-" + str + "lastSdk", 0);
            int i11 = this.f42160m.getInt("libstreaming-" + str + "lastVersion", 0);
            if (Build.VERSION.SDK_INT <= i10 && 3 <= i11) {
                return false;
            }
        }
        return true;
    }

    private void d() {
        int i10;
        this.f42158k = new byte[(this.f42154g * 3) / 2];
        int i11 = 0;
        while (true) {
            i10 = this.f42154g;
            if (i11 >= i10) {
                break;
            }
            this.f42158k[i11] = (byte) ((i11 % 199) + 40);
            i11++;
        }
        while (i10 < (this.f42154g * 3) / 2) {
            byte[] bArr = this.f42158k;
            bArr[i10] = (byte) ((i10 % 200) + 40);
            bArr[i10 + 1] = (byte) (((i10 + 99) % 200) + 40);
            i10 += 2;
        }
    }

    public static synchronized EncoderDebugger debug(Context context, int i10, int i11) {
        EncoderDebugger debug;
        synchronized (EncoderDebugger.class) {
            WLogger.e(TAG, "EncoderDebugger debug");
            debug = debug(PreferenceManager.getDefaultSharedPreferences(context), i10, i11);
        }
        return debug;
    }

    public static synchronized EncoderDebugger debug(SharedPreferences sharedPreferences, int i10, int i11) {
        EncoderDebugger encoderDebugger;
        synchronized (EncoderDebugger.class) {
            WLogger.e(TAG, "EncoderDebugger debug2");
            encoderDebugger = new EncoderDebugger(sharedPreferences, i10, i11);
            encoderDebugger.b();
        }
        return encoderDebugger;
    }

    private void e() throws IOException {
        WLogger.e(TAG, "configureEncoder");
        this.f42151d = MediaCodec.createByCodecName(this.f42149b);
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(ah.f2598d, this.f42152e, this.f42153f);
        createVideoFormat.setInteger(FFmpegMediaMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, 1000000);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("color-format", this.f42148a);
        createVideoFormat.setInteger("i-frame-interval", 5);
        this.f42151d.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f42151d.start();
    }

    private void f() {
        MediaCodec mediaCodec = this.f42151d;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
            } catch (Exception unused) {
            }
            try {
                this.f42151d.release();
            } catch (Exception unused2) {
            }
        }
    }

    private long g() {
        long j10;
        WLogger.e(TAG, "searchSPSandPPS");
        long h10 = h();
        ByteBuffer[] inputBuffers = this.f42151d.getInputBuffers();
        ByteBuffer[] outputBuffers = this.f42151d.getOutputBuffers();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        byte[] bArr = new byte[128];
        long j11 = 0;
        int i10 = 4;
        int i11 = 4;
        while (j11 < 3000000 && (this.f42155h == null || this.f42156i == null)) {
            j10 = j11;
            int dequeueInputBuffer = this.f42151d.dequeueInputBuffer(50000L);
            if (dequeueInputBuffer >= 0) {
                a(inputBuffers[dequeueInputBuffer].capacity() >= this.f42157j.length, "The input buffer is not big enough.");
                inputBuffers[dequeueInputBuffer].clear();
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byte[] bArr2 = this.f42157j;
                byteBuffer.put(bArr2, 0, bArr2.length);
                this.f42151d.queueInputBuffer(dequeueInputBuffer, 0, this.f42157j.length, h(), 0);
            } else {
                WLogger.e(TAG, "No buffer available !");
            }
            int dequeueOutputBuffer = this.f42151d.dequeueOutputBuffer(bufferInfo, 50000L);
            if (dequeueOutputBuffer == -2) {
                MediaFormat outputFormat = this.f42151d.getOutputFormat();
                ByteBuffer byteBuffer2 = outputFormat.getByteBuffer("csd-0");
                ByteBuffer byteBuffer3 = outputFormat.getByteBuffer("csd-1");
                this.f42155h = new byte[byteBuffer2.capacity() - 4];
                byteBuffer2.position(4);
                byte[] bArr3 = this.f42155h;
                byteBuffer2.get(bArr3, 0, bArr3.length);
                this.f42156i = new byte[byteBuffer3.capacity() - 4];
                byteBuffer3.position(4);
                byte[] bArr4 = this.f42156i;
                byteBuffer3.get(bArr4, 0, bArr4.length);
                break;
            }
            if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f42151d.getOutputBuffers();
            } else if (dequeueOutputBuffer >= 0) {
                int i12 = bufferInfo.size;
                if (i12 < 128) {
                    outputBuffers[dequeueOutputBuffer].get(bArr, 0, i12);
                    if (i12 > 0 && bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 1) {
                        while (i10 < i12) {
                            while (true) {
                                if (bArr[i10 + 0] == 0 && bArr[i10 + 1] == 0 && bArr[i10 + 2] == 0) {
                                    if (bArr[i10 + 3] == 1) {
                                        break;
                                    }
                                }
                                if (i10 + 3 >= i12) {
                                    break;
                                }
                                i10++;
                            }
                            if (i10 + 3 >= i12) {
                                i10 = i12;
                            }
                            if ((bArr[i11] & 31) == 7) {
                                int i13 = i10 - i11;
                                byte[] bArr5 = new byte[i13];
                                this.f42155h = bArr5;
                                System.arraycopy((Object) bArr, i11, (Object) bArr5, 0, i13);
                            } else {
                                int i14 = i10 - i11;
                                byte[] bArr6 = new byte[i14];
                                this.f42156i = bArr6;
                                System.arraycopy((Object) bArr, i11, (Object) bArr6, 0, i14);
                            }
                            i11 = i10 + 4;
                            i10 = i11;
                        }
                    }
                }
                this.f42151d.releaseOutputBuffer(dequeueOutputBuffer, false);
            }
            j11 = h() - h10;
        }
        j10 = j11;
        a((this.f42156i != null) & (this.f42155h != null), "Could not determine the SPS & PPS.");
        byte[] bArr7 = this.f42156i;
        this.f42163p = Base64.encodeToString(bArr7, 0, bArr7.length, 2);
        byte[] bArr8 = this.f42155h;
        this.f42164q = Base64.encodeToString(bArr8, 0, bArr8.length, 2);
        WLogger.e(TAG, "searchSPSandPPS end");
        return j10;
    }

    private long h() {
        return System.nanoTime() / 1000;
    }

    public int getEncoderColorFormat() {
        return this.f42148a;
    }

    public String getEncoderName() {
        return this.f42149b;
    }

    public String getErrorLog() {
        return this.f42150c;
    }

    public NV21Convert getNV21Convertor() {
        return this.f42159l;
    }

    public String toString() {
        return "EncoderDebugger [mEncoderColorFormat=" + this.f42148a + ", mEncoderName=" + this.f42149b + ", mErrorLog=" + this.f42150c + ", mEncoder=" + ((Object) this.f42151d) + ", mWidth=" + this.f42152e + ", mHeight=" + this.f42153f + ", mSize=" + this.f42154g + ", mSPS=" + Arrays.toString(this.f42155h) + ", mPPS=" + Arrays.toString(this.f42156i) + ", mData=" + Arrays.toString(this.f42157j) + ", mInitialImage=" + Arrays.toString(this.f42158k) + ", mNV21=" + ((Object) this.f42159l) + ", mPreferences=" + ((Object) this.f42160m) + ", mVideo=" + Arrays.toString(this.f42161n) + ", mDecodedVideo=" + Arrays.toString(this.f42162o) + ", mB64PPS=" + this.f42163p + ", mB64SPS=" + this.f42164q + "]";
    }
}
