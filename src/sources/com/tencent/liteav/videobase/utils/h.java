package com.tencent.liteav.videobase.utils;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hailiang.advlib.core.ADEvent;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public MediaFormat f43500a;

    /* renamed from: b, reason: collision with root package name */
    public JSONArray f43501b;

    /* renamed from: c, reason: collision with root package name */
    public int f43502c;

    /* renamed from: d, reason: collision with root package name */
    public int f43503d;

    /* renamed from: e, reason: collision with root package name */
    public String f43504e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f43505f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private a f43506g;

    /* renamed from: com.tencent.liteav.videobase.utils.h$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43507a;

        static {
            int[] iArr = new int[a.values().length];
            f43507a = iArr;
            try {
                iArr[a.kQcom.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43507a[a.kHisi.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43507a[a.kExynos.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43507a[a.kAmlogic.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum a {
        kUnKnown,
        kQcom,
        kHisi,
        kExynos,
        kAmlogic
    }

    public h() {
        a aVar = a.kUnKnown;
        this.f43506g = aVar;
        a b4 = b();
        if (b4 == aVar) {
            String lowerCase = LiteavSystemInfo.getHardware().toLowerCase();
            if (lowerCase.contains("qcom")) {
                aVar = a.kQcom;
            } else if (lowerCase.contains("kirin")) {
                aVar = a.kHisi;
            } else if (lowerCase.contains("exynos")) {
                aVar = a.kExynos;
            }
            b4 = aVar;
        }
        this.f43506g = b4;
        LiteavLog.i("HardwareDecoderMediaFormatBuilder", "hardware name:" + LiteavSystemInfo.getHardware().toLowerCase() + " chip brand:" + ((Object) this.f43506g));
    }

    private static a b() {
        int i10;
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            return a.kUnKnown;
        }
        try {
            MediaCodecInfo[] codecInfos = new MediaCodecList(0).getCodecInfos();
            int length = codecInfos.length;
            while (i10 < length) {
                String lowerCase = codecInfos[i10].getName().toLowerCase();
                if (lowerCase.contains("hisi")) {
                    return a.kHisi;
                }
                if (lowerCase.contains("amlogic")) {
                    return a.kAmlogic;
                }
                i10 = (lowerCase.contains("qcom") || lowerCase.contains("qti")) ? 0 : i10 + 1;
                return a.kQcom;
            }
        } catch (Throwable th) {
            LiteavLog.e("HardwareDecoderMediaFormatBuilder", "get mediacode info error:" + th.getMessage());
        }
        return a.kUnKnown;
    }

    public final MediaFormat a() {
        MediaFormat mediaFormat = this.f43500a;
        if (mediaFormat == null) {
            mediaFormat = MediaFormat.createVideoFormat(this.f43504e, this.f43502c, this.f43503d);
        }
        if (this.f43505f) {
            int systemOSVersionInt = LiteavSystemInfo.getSystemOSVersionInt();
            if (systemOSVersionInt >= 30 && this.f43506g != a.kHisi) {
                mediaFormat.setInteger("low-latency", 1);
            }
            if (systemOSVersionInt > 23 || !LiteavSystemInfo.getManufacturer().toLowerCase().contains(ADEvent.XIAOMI)) {
                mediaFormat.setInteger("vdec-lowlatency", 1);
            }
            if (systemOSVersionInt >= 26) {
                int i10 = AnonymousClass1.f43507a[this.f43506g.ordinal()];
                if (i10 == 1) {
                    mediaFormat.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
                    mediaFormat.setInteger("vendor.qti-ext-dec-picture-order.enable", 1);
                } else if (i10 == 2) {
                    mediaFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-req", 1);
                    mediaFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-rdy", -1);
                } else if (i10 == 3) {
                    mediaFormat.setInteger("vendor.rtc-ext-dec-low-latency.enable", 1);
                } else if (i10 == 4) {
                    mediaFormat.setInteger("vendor.low-latency.enable", 1);
                }
            }
        }
        JSONArray jSONArray = this.f43501b;
        if (jSONArray != null) {
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i11);
                    mediaFormat.setInteger(jSONObject.optString("key"), jSONObject.optInt("value"));
                } catch (JSONException e2) {
                    LiteavLog.e("HardwareDecoderMediaFormatBuilder", "set MediaCodec device related params failed.", e2);
                }
            }
        }
        return mediaFormat;
    }
}
