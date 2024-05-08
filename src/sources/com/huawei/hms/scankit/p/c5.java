package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: MultiFormatWriter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c5 implements l8 {

    /* compiled from: MultiFormatWriter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30803a;

        static {
            int[] iArr = new int[BarcodeFormat.values().length];
            f30803a = iArr;
            try {
                iArr[BarcodeFormat.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30803a[BarcodeFormat.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30803a[BarcodeFormat.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30803a[BarcodeFormat.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30803a[BarcodeFormat.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f30803a[BarcodeFormat.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f30803a[BarcodeFormat.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f30803a[BarcodeFormat.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f30803a[BarcodeFormat.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f30803a[BarcodeFormat.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f30803a[BarcodeFormat.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f30803a[BarcodeFormat.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f30803a[BarcodeFormat.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<u2, ?> map) throws WriterException {
        l8 r2Var;
        switch (a.f30803a[barcodeFormat.ordinal()]) {
            case 1:
                r2Var = new r2();
                break;
            case 2:
                r2Var = new t7();
                break;
            case 3:
                r2Var = new p2();
                break;
            case 4:
                r2Var = new m7();
                break;
            case 5:
                r2Var = new k6();
                break;
            case 6:
                r2Var = new u0();
                break;
            case 7:
                r2Var = new w0();
                break;
            case 8:
                r2Var = new s0();
                break;
            case 9:
                r2Var = new k4();
                break;
            case 10:
                r2Var = new u5();
                break;
            case 11:
                r2Var = new q0();
                break;
            case 12:
                r2Var = new j1();
                break;
            case 13:
                r2Var = new i();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + ((Object) barcodeFormat));
        }
        return r2Var.a(str, barcodeFormat, i10, i11, map);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:(5:(14:164|(1:166)(2:167|(1:185))|14|(9:16|(1:18)|19|(1:21)|22|(1:24)|25|(1:27)(1:162)|28)(1:163)|29|(1:31)(2:125|(1:127)(4:128|(1:130)(1:(1:133)(2:134|(1:136)(2:137|(1:139)(2:140|(1:142)(2:143|(1:145)(2:146|(1:148)(2:149|(1:151)(2:152|(1:154)(2:155|(1:157)(2:158|(1:160)(1:161)))))))))))|131|(6:41|42|43|(2:83|(1:85)(6:86|(4:88|(3:90|(2:92|93)(2:95|96)|94)|97|98)|99|100|(3:106|(1:108)(1:110)|109)|111))(4:48|49|50|(1:52)(4:53|(4:55|(3:57|(2:68|(2:70|71)(2:72|73))(2:65|66)|67)|74|75)|76|77))|(1:79)(1:81)|80)(2:38|39)))|32|(1:34)|41|42|43|(0)|83|(0)(0))|43|(0)|83|(0)(0))|41|42) */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02ab, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02ac, code lost:
    
        r17 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0295, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0296, code lost:
    
        r17 = r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0132 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0212 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0213 A[Catch: Exception -> 0x0291, IllegalArgumentException -> 0x0293, OutOfMemoryError -> 0x02c1, TryCatch #3 {OutOfMemoryError -> 0x02c1, blocks: (B:42:0x012e, B:46:0x0134, B:48:0x0138, B:50:0x0155, B:53:0x015c, B:57:0x01b1, B:59:0x01b5, B:61:0x01b9, B:63:0x01bd, B:65:0x01c1, B:67:0x01e3, B:68:0x01d2, B:70:0x01d8, B:72:0x01de, B:75:0x01e6, B:77:0x01e9, B:83:0x0200, B:86:0x0213, B:90:0x0225, B:92:0x022b, B:94:0x0236, B:95:0x0231, B:98:0x0239, B:100:0x023c, B:108:0x026e, B:110:0x0276, B:111:0x027d), top: B:41:0x012e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap a(java.lang.String r28, int r29, int r30, int r31, com.huawei.hms.ml.scan.HmsBuildBitmapOption r32) throws com.huawei.hms.hmsscankit.WriterException {
        /*
            Method dump skipped, instructions count: 760
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.c5.a(java.lang.String, int, int, int, com.huawei.hms.ml.scan.HmsBuildBitmapOption):android.graphics.Bitmap");
    }
}
