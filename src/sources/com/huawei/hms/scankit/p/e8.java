package com.huawei.hms.scankit.p;

/* compiled from: VersionOne.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e8 {

    /* renamed from: a, reason: collision with root package name */
    private static final double[] f30947a = {158.0d, 184.0d, 210.0d, 236.0d};

    /* renamed from: b, reason: collision with root package name */
    private static final double[] f30948b = {0.2619d, 0.3459d, 0.4299d, 0.5139d, 0.5979d, 0.6819d, 0.7659d, 0.8499d, 0.9339d, 1.0179d, 1.1019d, 1.1859d, 1.2699d, 1.3539d, 1.4379d, 1.5219d, 1.6059d, 1.6899d, 1.7739d, 1.8579d, 1.9419d, 2.0259d, 2.1099d, 2.1939d, 2.2779d, 2.3619d, 2.4459d, 2.5299d, 2.6139d, 2.6979d, 2.7819d, 2.8659d};

    /* renamed from: c, reason: collision with root package name */
    private static final double[] f30949c = {3.4035d, 3.4875d, 3.5715d, 3.6555d, 3.7395d, 3.8235d, 3.9075d, 3.9915d, 4.0755d, 4.1595d, 4.2435d, 4.3275d, 4.4115d, 4.4955d, 4.5795d, 4.6635d, 4.7475d, 4.8315d, 4.9155d, 4.9995d, 5.0835d, 5.1675d, 5.2515d, 5.3355d, 5.4195d, 5.5035d, 5.5875d, 5.6715d, 5.7555d, 5.8395d, 5.9235d, 6.0075d};

    /* renamed from: d, reason: collision with root package name */
    private static final double[] f30950d = {0.2251d, 0.2973d, 0.3695d, 0.4417d, 0.5139d, 1.0193d, 1.0915d, 1.1637d, 1.2359d, 1.3081d, 1.3803d, 1.4525d, 1.5247d, 1.5969d, 1.6691d, 1.7413d, 1.8135d, 1.8857d, 1.9579d, 2.0301d, 2.1023d, 2.6077d, 2.6799d, 2.7521d, 2.8243d, 2.8965d};

    /* renamed from: e, reason: collision with root package name */
    private static final double[] f30951e = {3.3667d, 3.4389d, 3.5111d, 3.5833d, 3.6555d, 3.7277d, 4.0887d, 4.1609d, 4.2331d, 4.3053d, 4.3775d, 4.4497d, 4.5219d, 4.5941d, 4.6663d, 4.7385d, 4.8107d, 4.8829d, 4.9551d, 5.0273d, 5.0995d, 5.1717d, 5.2439d, 5.7493d, 5.8215d, 5.8937d, 5.9659d, 6.0381d};

    /* renamed from: f, reason: collision with root package name */
    private static final double[] f30952f = {0.1976d, 0.2658d, 0.334d, 0.4022d, 0.4704d, 0.5386d, 1.016d, 1.0842d, 1.1524d, 1.2206d, 1.2888d, 1.357d, 1.4252d, 1.4934d, 1.5616d, 1.6298d, 1.698d, 1.7662d, 1.8344d, 1.9026d, 1.9708d, 2.039d, 2.1072d, 2.5846d, 2.6528d, 2.721d, 2.7892d, 2.8574d, 2.9256d};

    /* renamed from: g, reason: collision with root package name */
    private static final double[] f30953g = {3.3392d, 3.4074d, 3.4756d, 3.5438d, 3.612d, 3.6802d, 3.7484d, 4.0894d, 4.1576d, 4.2258d, 4.294d, 4.3622d, 4.4304d, 4.4986d, 4.5668d, 4.635d, 4.7032d, 4.7714d, 4.8396d, 4.9078d, 4.976d, 5.0442d, 5.1124d, 5.1806d, 5.2488d, 5.7262d, 5.7944d, 5.8626d, 5.9308d, 5.999d, 6.0672d};

    /* renamed from: h, reason: collision with root package name */
    private static final double[] f30954h = {0.1763d, 0.2342d, 0.2921d, 0.35d, 0.4079d, 0.4658d, 0.5237d, 0.9869d, 1.0448d, 1.1027d, 1.1606d, 1.2185d, 1.2764d, 1.3343d, 1.3922d, 1.4501d, 1.508d, 1.5659d, 1.6238d, 1.6817d, 1.7396d, 1.7975d, 1.8554d, 1.9133d, 1.9712d, 2.0291d, 2.087d, 2.1449d, 2.5502d, 2.6081d, 2.666d, 2.7239d, 2.7818d, 2.8397d, 2.8976d, 2.9555d};

    /* renamed from: i, reason: collision with root package name */
    private static final double[] f30955i = {3.3179d, 3.3758d, 3.4337d, 3.4916d, 3.5495d, 3.6074d, 3.6653d, 3.7232d, 3.7811d, 4.0706d, 4.1285d, 4.1864d, 4.2443d, 4.3022d, 4.3601d, 4.418d, 4.4759d, 4.5338d, 4.5917d, 4.6496d, 4.7075d, 4.7654d, 4.8233d, 4.8812d, 4.9391d, 4.997d, 5.0549d, 5.1128d, 5.1707d, 5.2286d, 5.2865d, 5.6918d, 5.7497d, 5.8076d, 5.8655d, 5.9234d, 5.9813d, 6.0392d, 6.0971d};

    public static String a() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer a10 = i5.a(f30948b);
        StringBuffer a11 = i5.a(f30949c);
        StringBuffer a12 = i5.a(f30950d);
        StringBuffer a13 = i5.a(f30951e);
        StringBuffer a14 = i5.a(f30952f);
        StringBuffer a15 = i5.a(f30953g);
        StringBuffer a16 = i5.a(f30954h);
        StringBuffer a17 = i5.a(f30955i);
        stringBuffer.append(a10);
        stringBuffer.append(a11);
        stringBuffer.append(a12);
        stringBuffer.append(a13);
        stringBuffer.append(a14);
        stringBuffer.append(a15);
        stringBuffer.append(a16);
        stringBuffer.append(a17);
        return stringBuffer.toString();
    }

    public static s a(s sVar, s sVar2, int i10, double d10) {
        return i5.a(sVar, sVar2, i10, i5.a(d10, f30947a, a()));
    }
}
