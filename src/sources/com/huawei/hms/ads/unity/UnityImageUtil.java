package com.huawei.hms.ads.unity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.bt;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.g;
import com.huawei.openalliance.ad.inter.data.k;
import com.huawei.openalliance.ad.utils.aj;
import com.huawei.openalliance.ad.utils.y;

@AllApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class UnityImageUtil {
    private static UnityImageUtil I;
    private static final byte[] V = new byte[0];

    /* renamed from: com.huawei.hms.ads.unity.UnityImageUtil$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[UnityImageType.values().length];
            Code = iArr;
            try {
                iArr[UnityImageType.ICON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[UnityImageType.IMAGES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[UnityImageType.CHOICESINFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private UnityImageUtil() {
    }

    private k Code(g gVar, String str, UnityImageType unityImageType) {
        int i10 = AnonymousClass2.Code[unityImageType.ordinal()];
        if (i10 == 1) {
            k I2 = gVar.I();
            if (TextUtils.equals(str, I2.Z())) {
                return I2;
            }
            return null;
        }
        if (i10 != 2) {
            return null;
        }
        for (k kVar : gVar.Z()) {
            if (TextUtils.equals(str, kVar.Z())) {
                return kVar;
            }
        }
        return null;
    }

    @AllApi
    public static UnityImageUtil getInstance() {
        UnityImageUtil unityImageUtil;
        synchronized (V) {
            if (I == null) {
                I = new UnityImageUtil();
            }
            unityImageUtil = I;
        }
        return unityImageUtil;
    }

    @AllApi
    public void unityLoadImage(final UnityImageDelegate unityImageDelegate, Context context, NativeAd nativeAd, UnityImageType unityImageType) {
        if (unityImageDelegate == null || unityImageDelegate.getUri() == null) {
            return;
        }
        Uri uri = unityImageDelegate.getUri();
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(uri.toString());
        sourceParam.Code(52428800L);
        sourceParam.I(true);
        if (nativeAd == null || !(nativeAd instanceof bt)) {
            return;
        }
        g Code = ((bt) nativeAd).Code();
        final k Code2 = Code(Code, uri.toString(), unityImageType);
        if (Code2 == null) {
            gl.Code("UnityImageUtil", "illegal image");
            return;
        }
        sourceParam.V(Code2.I());
        sourceParam.V(Code2.S());
        if (Code != null) {
            y.Code(context, sourceParam, Code.D(), new aj() { // from class: com.huawei.hms.ads.unity.UnityImageUtil.1
                @Override // com.huawei.openalliance.ad.utils.aj
                public void Code() {
                    gl.I("UnityImageUtil", "unity load image fail");
                }

                @Override // com.huawei.openalliance.ad.utils.aj
                public void Code(String str, Drawable drawable) {
                    k kVar = Code2;
                    if (kVar == null || !TextUtils.equals(str, kVar.Z())) {
                        return;
                    }
                    gl.Code("UnityImageUtil", "unity load image success");
                    unityImageDelegate.setDrawable(drawable);
                }
            });
        }
    }
}
