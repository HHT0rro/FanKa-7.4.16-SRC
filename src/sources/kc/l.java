package kc;

import com.xiaomi.push.hw;
import com.xiaomi.push.hx;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public /* synthetic */ class l {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f50815a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f50816b;

    static {
        int[] iArr = new int[hx.values().length];
        f50816b = iArr;
        try {
            iArr[hx.INT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f50816b[hx.LONG.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f50816b[hx.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f50816b[hx.BOOLEAN.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[hw.values().length];
        f50815a = iArr2;
        try {
            iArr2[hw.MISC_CONFIG.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f50815a[hw.PLUGIN_CONFIG.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
