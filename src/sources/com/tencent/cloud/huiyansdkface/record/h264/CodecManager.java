package com.tencent.cloud.huiyansdkface.record.h264;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CodecManager {
    public static final String TAG = "CodecManager";
    public static final int[] SUPPORTED_COLOR_FORMATS = {21, 39, 19, 20, 2130706688};

    /* renamed from: a, reason: collision with root package name */
    private static a[] f42145a = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f42146a;

        /* renamed from: b, reason: collision with root package name */
        public Integer[] f42147b;

        public a(String str, Integer[] numArr) {
            this.f42146a = str;
            this.f42147b = numArr;
        }
    }

    public static synchronized a[] findEncodersForMimeType(String str) {
        synchronized (CodecManager.class) {
            a[] aVarArr = f42145a;
            if (aVarArr != null) {
                return aVarArr;
            }
            ArrayList arrayList = new ArrayList();
            for (int codecCount = MediaCodecList.getCodecCount() - 1; codecCount >= 0; codecCount--) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(codecCount);
                if (codecInfoAt.isEncoder()) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str);
                                HashSet hashSet = new HashSet();
                                int i10 = 0;
                                while (true) {
                                    int[] iArr = capabilitiesForType.colorFormats;
                                    if (i10 >= iArr.length) {
                                        break;
                                    }
                                    int i11 = iArr[i10];
                                    int i12 = 0;
                                    while (true) {
                                        int[] iArr2 = SUPPORTED_COLOR_FORMATS;
                                        if (i12 >= iArr2.length) {
                                            break;
                                        }
                                        if (i11 == iArr2[i12]) {
                                            hashSet.add(Integer.valueOf(i11));
                                            break;
                                        }
                                        i12++;
                                    }
                                    i10++;
                                }
                                arrayList.add(new a(codecInfoAt.getName(), (Integer[]) hashSet.toArray(new Integer[hashSet.size()])));
                            } catch (Exception e2) {
                                Log.wtf(TAG, e2);
                            }
                        }
                    }
                }
            }
            a[] aVarArr2 = (a[]) arrayList.toArray(new a[arrayList.size()]);
            f42145a = aVarArr2;
            if (aVarArr2.length == 0) {
                f42145a = new a[]{new a(null, new Integer[]{0})};
            }
            return f42145a;
        }
    }
}
