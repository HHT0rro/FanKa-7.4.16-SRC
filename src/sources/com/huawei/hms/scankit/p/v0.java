package com.huawei.hms.scankit.p;

import com.alibaba.wireless.security.SecExceptionCode;
import com.android.internal.accessibility.common.ShortcutConstants;
import com.android.internal.logging.nano.MetricsProto;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.openalliance.ad.constant.ad;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Code93Reader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class v0 extends g5 {

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f31601c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f31602d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f31603e;

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f31604a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    private final int[] f31605b = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, ad.f32204q, 420, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, SecExceptionCode.SEC_ERROR_DYN_ENC_DECRYPT_FAILED, 406, 410, 364, 358, 310, 314, 302, MetricsProto.MetricsEvent.ACTION_DELETION_HELPER_CANCEL, MetricsProto.MetricsEvent.ACTION_DELETION_DOWNLOADS_COLLAPSED, MetricsProto.MetricsEvent.STORAGE_MANAGER_SETTINGS, 366, 374, 430, 294, MetricsProto.MetricsEvent.DASHBOARD_CONTAINER, MetricsProto.MetricsEvent.ACTION_DELETION_HELPER_REMOVE_CANCEL, 306, 350};
        f31602d = iArr;
        f31603e = iArr[47];
    }

    private static int b(int[] iArr) {
        int i10 = 0;
        for (int i11 : iArr) {
            i10 += i11;
        }
        int length = iArr.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            int round = Math.round((iArr[i13] * 9.0f) / i10);
            if (round < 1 || round > 4) {
                return -1;
            }
            if ((i13 & 1) == 0) {
                for (int i14 = 0; i14 < round; i14++) {
                    i12 = (i12 << 1) | 1;
                }
            } else {
                i12 <<= round;
            }
        }
        return i12;
    }

    @Override // com.huawei.hms.scankit.p.g5
    public s6 a(int i10, r rVar, Map<l1, ?> map) throws a {
        int c4 = rVar.c(a(rVar)[1]);
        int e2 = rVar.e();
        int[] iArr = this.f31605b;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f31604a;
        sb2.setLength(0);
        while (true) {
            g5.a(rVar, c4, iArr);
            int b4 = b(iArr);
            if (b4 >= 0) {
                char a10 = a(b4);
                sb2.append(a10);
                int i11 = c4;
                for (int i12 : iArr) {
                    i11 += i12;
                }
                int c10 = rVar.c(i11);
                if (a10 == '*') {
                    sb2.deleteCharAt(sb2.length() - 1);
                    int i13 = 0;
                    for (int i14 : iArr) {
                        i13 += i14;
                    }
                    if (c10 != e2 && rVar.b(c10)) {
                        if (sb2.length() >= 2) {
                            a(sb2);
                            sb2.setLength(sb2.length() - 2);
                            float f10 = i10;
                            return new s6(b(sb2), null, new u6[]{new u6(r14[0], f10), new u6(c4 + ((i13 * 10) / 9), f10)}, BarcodeFormat.CODE_93);
                        }
                        throw a.a();
                    }
                    throw a.a();
                }
                c4 = c10;
            } else {
                throw a.a();
            }
        }
    }

    private static String b(CharSequence charSequence) throws a {
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i10 = 0;
        while (i10 < length) {
            char charAt = charSequence.charAt(i10);
            if (charAt < 'a' || charAt > 'd') {
                sb2.append(charAt);
            } else if (i10 < length - 1) {
                i10++;
                sb2.append(a(charAt, charSequence.charAt(i10)));
            } else {
                throw a.a();
            }
            i10++;
        }
        return sb2.toString();
    }

    private int[] a(r rVar) throws a {
        int e2 = rVar.e();
        int c4 = rVar.c(0);
        Arrays.fill(this.f31605b, 0);
        int[] iArr = this.f31605b;
        int length = iArr.length;
        int i10 = c4;
        boolean z10 = false;
        int i11 = 0;
        while (c4 < e2) {
            if (rVar.b(c4) != z10) {
                if (i11 >= 0 && i11 < iArr.length) {
                    iArr[i11] = iArr[i11] + 1;
                } else {
                    throw a.a();
                }
            } else {
                if (i11 != length - 1) {
                    i11++;
                } else {
                    if (b(iArr) == f31603e) {
                        return new int[]{i10, c4};
                    }
                    i10 += iArr[0] + iArr[1];
                    int i12 = i11 - 1;
                    System.arraycopy((Object) iArr, 2, (Object) iArr, 0, i12);
                    iArr[i12] = 0;
                    iArr[i11] = 0;
                    i11--;
                }
                iArr[i11] = 1;
                z10 = !z10;
            }
            c4++;
        }
        throw a.a();
    }

    private static char a(int i10) throws a {
        int i11 = 0;
        while (true) {
            int[] iArr = f31602d;
            if (i11 < iArr.length) {
                if (iArr[i11] == i10) {
                    return f31601c[i11];
                }
                i11++;
            } else {
                throw a.a();
            }
        }
    }

    private static char a(char c4, char c10) throws a {
        int i10;
        switch (c4) {
            case 'a':
                if (c10 >= 'A' && c10 <= 'Z') {
                    i10 = c10 - '@';
                    break;
                } else {
                    throw a.a();
                }
            case 'b':
                if (c10 >= 'A' && c10 <= 'E') {
                    i10 = c10 - '&';
                    break;
                } else if (c10 >= 'F' && c10 <= 'J') {
                    i10 = c10 - 11;
                    break;
                } else if (c10 >= 'K' && c10 <= 'O') {
                    i10 = c10 + 16;
                    break;
                } else if (c10 >= 'P' && c10 <= 'S') {
                    i10 = c10 + '+';
                    break;
                } else {
                    if (c10 < 'T' || c10 > 'Z') {
                        throw a.a();
                    }
                    return (char) 127;
                }
                break;
            case 'c':
                if (c10 >= 'A' && c10 <= 'O') {
                    i10 = c10 - ' ';
                    break;
                } else {
                    if (c10 == 'Z') {
                        return ShortcutConstants.SERVICES_SEPARATOR;
                    }
                    throw a.a();
                }
            case 'd':
                if (c10 >= 'A' && c10 <= 'Z') {
                    i10 = c10 + ' ';
                    break;
                } else {
                    throw a.a();
                }
            default:
                return (char) 0;
        }
        return (char) i10;
    }

    private static void a(CharSequence charSequence) throws a {
        int length = charSequence.length();
        a(charSequence, length - 2, 20);
        a(charSequence, length - 1, 15);
    }

    private static void a(CharSequence charSequence, int i10, int i11) throws a {
        int i12 = 0;
        int i13 = 1;
        for (int i14 = i10 - 1; i14 >= 0; i14--) {
            i12 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i14)) * i13;
            i13++;
            if (i13 > i11) {
                i13 = 1;
            }
        }
        if (charSequence.charAt(i10) != f31601c[i12 % 47]) {
            throw a.a();
        }
    }
}
