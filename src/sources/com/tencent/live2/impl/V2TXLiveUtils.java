package com.tencent.live2.impl;

import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.android.internal.logging.nano.MetricsProto;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.live2.V2TXLiveDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class V2TXLiveUtils {
    private static final String TAG = "V2TXLiveUtils";
    public static final String TRTC_ADDRESS1 = "room://cloud.tencent.com/rtc";
    public static final String TRTC_ADDRESS2 = "room://rtc.tencent.com";

    /* renamed from: com.tencent.live2.impl.V2TXLiveUtils$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45080a;

        static {
            int[] iArr = new int[V2TXLiveDef.V2TXLiveVideoResolution.values().length];
            f45080a = iArr;
            try {
                iArr[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution160x160.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45080a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution270x270.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45080a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution480x480.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45080a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution320x240.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f45080a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution480x360.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f45080a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution640x480.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f45080a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution320x180.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f45080a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution480x270.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f45080a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution640x360.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f45080a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution960x540.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f45080a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution1280x720.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f45080a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution1920x1080.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f45081a;

        /* renamed from: b, reason: collision with root package name */
        public int f45082b;

        public a(int i10, int i11) {
            this.f45081a = i10;
            this.f45082b = i11;
        }
    }

    public static a getBitrateByResolution(V2TXLiveDef.V2TXLiveVideoResolution v2TXLiveVideoResolution) {
        int i10 = 900;
        int i11 = 600;
        switch (AnonymousClass1.f45080a[v2TXLiveVideoResolution.ordinal()]) {
            case 1:
                i11 = 100;
                i10 = 150;
                break;
            case 2:
                i11 = 200;
                i10 = 300;
                break;
            case 3:
                i10 = MetricsProto.MetricsEvent.PROVISIONING_FINALIZATION_ACTIVITY_TIME_MS;
                i11 = 350;
                break;
            case 4:
                i10 = 375;
                i11 = 250;
                break;
            case 5:
                i10 = 600;
                i11 = 400;
                break;
            case 6:
                break;
            case 7:
                i10 = 400;
                i11 = 250;
                break;
            case 8:
                i10 = MetricsProto.MetricsEvent.DIALOG_BILLING_BYTE_LIMIT;
                i11 = 350;
                break;
            case 9:
                i11 = 500;
                break;
            case 10:
            default:
                i10 = 1500;
                i11 = 800;
                break;
            case 11:
                i11 = 1000;
                i10 = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
                break;
            case 12:
                i11 = 2500;
                i10 = 3000;
                break;
        }
        return new a(i11, i10);
    }

    public static V2TXLiveDef.V2TXLiveMode parseLiveMode(String str) {
        if (!str.startsWith("trtc://") && !str.startsWith(TRTC_ADDRESS1) && !str.startsWith(TRTC_ADDRESS2)) {
            TXCLog.i(TAG, "parseLiveMode: rtmp.");
            return V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP;
        }
        TXCLog.i(TAG, "parseLiveMode: rtc.");
        return V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC;
    }

    public static String removeURLSensitiveInfo(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String[] strArr = {"roomsig", "privatemapkey", "usersig"};
            for (int i10 = 0; i10 < 3; i10++) {
                if (str.contains(strArr[i10]) && (indexOf = str.indexOf(strArr[i10])) != -1) {
                    int indexOf2 = str.indexOf("&", indexOf);
                    str = indexOf2 == -1 ? str.substring(0, indexOf) : str.substring(0, indexOf) + str.substring(indexOf2);
                }
            }
        } catch (Exception e2) {
            TXCLog.e(TAG, "remove url sensitive info failed.", e2);
        }
        return str;
    }
}
