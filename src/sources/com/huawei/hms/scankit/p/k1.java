package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: DecodeFormatManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class k1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Set<BarcodeFormat> f31198a;

    /* renamed from: b, reason: collision with root package name */
    public static final Set<BarcodeFormat> f31199b;

    /* renamed from: c, reason: collision with root package name */
    public static final Set<BarcodeFormat> f31200c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set<BarcodeFormat> f31201d;

    /* renamed from: e, reason: collision with root package name */
    public static final Set<BarcodeFormat> f31202e;

    /* renamed from: f, reason: collision with root package name */
    public static final Set<BarcodeFormat> f31203f;

    /* renamed from: g, reason: collision with root package name */
    public static final Set<BarcodeFormat> f31204g;

    /* renamed from: h, reason: collision with root package name */
    private static final Map<String, Set<BarcodeFormat>> f31205h;

    static {
        EnumSet of = EnumSet.of(BarcodeFormat.QR_CODE);
        f31201d = of;
        EnumSet of2 = EnumSet.of(BarcodeFormat.AZTEC);
        f31202e = of2;
        EnumSet of3 = EnumSet.of(BarcodeFormat.DATA_MATRIX);
        f31203f = of3;
        EnumSet of4 = EnumSet.of(BarcodeFormat.PDF_417);
        f31204g = of4;
        EnumSet of5 = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR);
        f31200c = of5;
        EnumSet of6 = EnumSet.of(BarcodeFormat.UPC_A, BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8);
        f31198a = of6;
        EnumSet copyOf = EnumSet.copyOf((Collection) of6);
        f31199b = copyOf;
        copyOf.addAll(of5);
        HashMap hashMap = new HashMap();
        f31205h = hashMap;
        hashMap.put("ONE_D_MODE", copyOf);
        hashMap.put("QR_CODE_MODE", of);
        hashMap.put("PRODUCT_MODE", of6);
        hashMap.put("AZTEC_MODE", of2);
        hashMap.put("DATA_MATRIX_MODE", of3);
        hashMap.put("PDF417_MODE", of4);
    }
}
