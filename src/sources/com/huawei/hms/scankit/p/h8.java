package com.huawei.hms.scankit.p;

/* compiled from: VersionTwo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h8 {

    /* renamed from: a, reason: collision with root package name */
    private static final double[] f31069a = {158.0d, 184.0d, 210.0d, 236.0d, 262.0d};

    /* renamed from: b, reason: collision with root package name */
    private static final double[] f31070b = {0.2619d, 0.3406d, 0.4193d, 0.498d, 0.5767d, 0.6554d, 0.7341d, 0.8128d, 0.8915d, 0.9702d, 1.0489d, 1.1276d, 1.2063d, 1.285d, 1.3637d, 1.4424d, 1.5211d, 1.5998d, 1.6785d, 1.7572d, 1.8359d, 1.9146d, 1.9933d, 2.072d, 2.1507d, 2.2294d, 2.3081d, 2.3868d, 2.4655d, 2.5442d, 2.6229d, 2.7016d, 2.7803d, 2.859d};

    /* renamed from: c, reason: collision with root package name */
    private static final double[] f31071c = {3.4035d, 3.4822d, 3.5609d, 3.6396d, 3.7183d, 3.797d, 3.8757d, 3.9544d, 4.0331d, 4.1118d, 4.1905d, 4.2692d, 4.3479d, 4.4266d, 4.5053d, 4.584d, 4.6627d, 4.7414d, 4.8201d, 4.8988d, 4.9775d, 5.0562d, 5.1349d, 5.2136d, 5.2923d, 5.371d, 5.4497d, 5.5284d, 5.6071d, 5.6858d, 5.7645d, 5.8432d, 5.9219d, 6.0006d};

    /* renamed from: d, reason: collision with root package name */
    private static final double[] f31072d = {0.2251d, 0.2902d, 0.3553d, 0.4204d, 0.4855d, 0.5506d, 0.6157d, 0.6808d, 0.7459d, 0.811d, 0.8761d, 0.9412d, 1.0063d, 1.0714d, 1.1365d, 1.2016d, 1.2667d, 1.3318d, 1.3969d, 1.462d, 1.5271d, 1.5922d, 1.6573d, 1.7224d, 1.7875d, 1.8526d, 1.9177d, 1.9828d, 2.0479d, 2.113d, 2.1781d, 2.2432d, 2.3083d, 2.3734d, 2.4385d, 2.5036d, 2.5687d, 2.6338d, 2.6989d, 2.764d, 2.8291d, 2.8942d};

    /* renamed from: e, reason: collision with root package name */
    private static final double[] f31073e = {3.3667d, 3.4318d, 3.4969d, 3.562d, 3.6271d, 3.6922d, 3.7573d, 3.8224d, 3.8875d, 3.9526d, 4.0177d, 4.0828d, 4.1479d, 4.213d, 4.2781d, 4.3432d, 4.4083d, 4.4734d, 4.5385d, 4.6036d, 4.6687d, 4.7338d, 4.7989d, 4.864d, 4.9291d, 4.9942d, 5.0593d, 5.1244d, 5.1895d, 5.2546d, 5.3197d, 5.3848d, 5.4499d, 5.515d, 5.5801d, 5.6452d, 5.7103d, 5.7754d, 5.8405d, 5.9056d, 5.9707d, 6.0358d};

    /* renamed from: f, reason: collision with root package name */
    private static final double[] f31074f = {0.1976d, 0.257d, 0.3164d, 0.3758d, 0.4352d, 0.4946d, 0.554d, 0.6134d, 0.9698d, 1.0292d, 1.0886d, 1.148d, 1.2074d, 1.2668d, 1.3262d, 1.3856d, 1.445d, 1.5044d, 1.5638d, 1.6232d, 1.6826d, 1.742d, 1.8014d, 1.8608d, 1.9202d, 1.9796d, 2.039d, 2.0984d, 2.1578d, 2.2172d, 2.5142d, 2.5736d, 2.633d, 2.6924d, 2.7518d, 2.8112d, 2.8706d, 2.93d};

    /* renamed from: g, reason: collision with root package name */
    private static final double[] f31075g = {3.3392d, 3.3986d, 3.458d, 3.5174d, 3.5768d, 3.6362d, 3.6956d, 3.755d, 3.8144d, 4.052d, 4.1114d, 4.1708d, 4.2302d, 4.2896d, 4.349d, 4.4084d, 4.4678d, 4.5272d, 4.5866d, 4.646d, 4.7054d, 4.7648d, 4.8242d, 4.8836d, 4.943d, 5.0024d, 5.0618d, 5.1212d, 5.1806d, 5.24d, 5.2994d, 5.3588d, 5.6558d, 5.7152d, 5.7746d, 5.834d, 5.8934d, 5.9528d, 6.0122d, 6.0716d};

    /* renamed from: h, reason: collision with root package name */
    private static final double[] f31076h = {0.1763d, 0.2287d, 0.2811d, 0.3335d, 0.3859d, 0.4383d, 0.4907d, 0.5431d, 0.5955d, 0.9623d, 1.0147d, 1.0671d, 1.1195d, 1.1719d, 1.2243d, 1.2767d, 1.3291d, 1.3815d, 1.4339d, 1.4863d, 1.5387d, 1.5911d, 1.6435d, 1.6959d, 1.7483d, 1.8007d, 1.8531d, 1.9055d, 1.9579d, 2.0103d, 2.0627d, 2.1151d, 2.1675d, 2.5343d, 2.5867d, 2.6391d, 2.6915d, 2.7439d, 2.7963d, 2.8487d, 2.9011d, 2.9535d};

    /* renamed from: i, reason: collision with root package name */
    private static final double[] f31077i = {3.3179d, 3.3703d, 3.4227d, 3.4751d, 3.5275d, 3.5799d, 3.6323d, 3.6847d, 3.7371d, 3.7895d, 4.1039d, 4.1563d, 4.2087d, 4.2611d, 4.3135d, 4.3659d, 4.4183d, 4.4707d, 4.5231d, 4.5755d, 4.6279d, 4.6803d, 4.7327d, 4.7851d, 4.8375d, 4.8899d, 4.9423d, 4.9947d, 5.0471d, 5.0995d, 5.1519d, 5.2043d, 5.2567d, 5.3091d, 5.6759d, 5.7283d, 5.7807d, 5.8331d, 5.8855d, 5.9379d, 5.9903d, 6.0427d, 6.0951d};

    /* renamed from: j, reason: collision with root package name */
    private static final double[] f31078j = {0.1593d, 0.2078d, 0.2563d, 0.3048d, 0.3533d, 0.4018d, 0.4503d, 0.4988d, 0.5473d, 0.5958d, 0.9353d, 0.9838d, 1.0323d, 1.0808d, 1.1293d, 1.1778d, 1.2263d, 1.2748d, 1.3233d, 1.3718d, 1.4203d, 1.4688d, 1.5173d, 1.5658d, 1.6143d, 1.6628d, 1.7113d, 1.7598d, 1.8083d, 1.8568d, 1.9053d, 1.9538d, 2.0023d, 2.0508d, 2.0993d, 2.1478d, 2.5358d, 2.5843d, 2.6328d, 2.6813d, 2.7298d, 2.7783d, 2.8268d, 2.8753d, 2.9238d, 2.9723d};

    /* renamed from: k, reason: collision with root package name */
    private static final double[] f31079k = {3.3009d, 3.3494d, 3.3979d, 3.4464d, 3.4949d, 3.5434d, 3.5919d, 3.6404d, 3.6889d, 3.7374d, 3.7859d, 4.0769d, 4.1254d, 4.1739d, 4.2224d, 4.2709d, 4.3194d, 4.3679d, 4.4164d, 4.4649d, 4.5134d, 4.5619d, 4.6104d, 4.6589d, 4.7074d, 4.7559d, 4.8044d, 4.8529d, 4.9014d, 4.9499d, 4.9984d, 5.0469d, 5.0954d, 5.1439d, 5.1924d, 5.2409d, 5.2894d, 5.6774d, 5.7259d, 5.7744d, 5.8229d, 5.8714d, 5.9199d, 5.9684d, 6.0169d, 6.0654d, 6.1139d};

    public static String a() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer a10 = i5.a(f31070b);
        StringBuffer a11 = i5.a(f31071c);
        StringBuffer a12 = i5.a(f31072d);
        StringBuffer a13 = i5.a(f31073e);
        StringBuffer a14 = i5.a(f31074f);
        StringBuffer a15 = i5.a(f31075g);
        StringBuffer a16 = i5.a(f31076h);
        StringBuffer a17 = i5.a(f31077i);
        StringBuffer a18 = i5.a(f31078j);
        StringBuffer a19 = i5.a(f31079k);
        stringBuffer.append(a10);
        stringBuffer.append(a11);
        stringBuffer.append(a12);
        stringBuffer.append(a13);
        stringBuffer.append(a14);
        stringBuffer.append(a15);
        stringBuffer.append(a16);
        stringBuffer.append(a17);
        stringBuffer.append(a18);
        stringBuffer.append(a19);
        return stringBuffer.toString();
    }

    public static s a(s sVar, s sVar2, int i10, double d10) {
        return i5.a(sVar, sVar2, i10, i5.a(d10, f31069a, a()));
    }
}
