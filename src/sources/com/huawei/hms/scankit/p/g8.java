package com.huawei.hms.scankit.p;

/* compiled from: VersionThree.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class g8 {

    /* renamed from: a, reason: collision with root package name */
    private static final double[] f31029a = {158.0d, 176.0d, 194.0d, 212.0d, 230.0d, 248.0d, 266.0d, 284.0d};

    /* renamed from: b, reason: collision with root package name */
    private static final double[] f31030b = {0.2619d, 0.3428d, 0.4237d, 0.5046d, 0.5855d, 0.6664d, 0.7473d, 0.8282d, 0.9091d, 0.99d, 1.0709d, 1.1518d, 1.2327d, 1.3136d, 1.3945d, 1.4754d, 1.5563d, 1.6372d, 1.7181d, 1.799d, 1.8799d, 1.9608d, 2.0417d, 2.1226d, 2.2035d, 2.2844d, 2.3653d, 2.4462d, 2.5271d, 2.608d, 2.6889d, 2.7698d, 2.8507d};

    /* renamed from: c, reason: collision with root package name */
    private static final double[] f31031c = {3.4035d, 3.4844d, 3.5653d, 3.6462d, 3.7271d, 3.808d, 3.8889d, 3.9698d, 4.0507d, 4.1316d, 4.2125d, 4.2934d, 4.3743d, 4.4552d, 4.5361d, 4.617d, 4.6979d, 4.7788d, 4.8597d, 4.9406d, 5.0215d, 5.1024d, 5.1833d, 5.2642d, 5.3451d, 5.426d, 5.5069d, 5.5878d, 5.6687d, 5.7496d, 5.8305d, 5.9114d, 5.9923d};

    /* renamed from: d, reason: collision with root package name */
    private static final double[] f31032d = {0.2353d, 0.3088d, 0.3823d, 0.4558d, 0.5293d, 0.6028d, 0.6763d, 0.7498d, 0.8233d, 0.8968d, 0.9703d, 1.0438d, 1.1173d, 1.1908d, 1.2643d, 1.3378d, 1.4113d, 1.4848d, 1.5583d, 1.6318d, 1.7053d, 1.7788d, 1.8523d, 1.9258d, 1.9993d, 2.0728d, 2.1463d, 2.2198d, 2.2933d, 2.3668d, 2.4403d, 2.5138d, 2.5873d, 2.6608d, 2.7343d, 2.8078d, 2.8813d};

    /* renamed from: e, reason: collision with root package name */
    private static final double[] f31033e = {3.3769d, 3.4504d, 3.5239d, 3.5974d, 3.6709d, 3.7444d, 3.8179d, 3.8914d, 3.9649d, 4.0384d, 4.1119d, 4.1854d, 4.2589d, 4.3324d, 4.4059d, 4.4794d, 4.5529d, 4.6264d, 4.6999d, 4.7734d, 4.8469d, 4.9204d, 4.9939d, 5.0674d, 5.1409d, 5.2144d, 5.2879d, 5.3614d, 5.4349d, 5.5084d, 5.5819d, 5.6554d, 5.7289d, 5.8024d, 5.8759d, 5.9494d, 6.0229d};

    /* renamed from: f, reason: collision with root package name */
    private static final double[] f31034f = {0.2137d, 0.2846d, 0.3555d, 0.4264d, 0.4973d, 0.5682d, 0.6391d, 0.71d, 0.7809d, 0.8518d, 0.9227d, 0.9936d, 1.0645d, 1.1354d, 1.2063d, 1.2772d, 1.3481d, 1.419d, 1.4899d, 1.5608d, 1.6317d, 1.7026d, 1.7735d, 1.8444d, 1.9153d, 1.9862d, 2.0571d, 2.128d, 2.1989d, 2.2698d, 2.3407d, 2.4116d, 2.4825d, 2.5534d, 2.6243d, 2.6952d, 2.7661d, 2.837d, 2.9079d};

    /* renamed from: g, reason: collision with root package name */
    private static final double[] f31035g = {3.3553d, 3.4262d, 3.4971d, 3.568d, 3.6389d, 3.7098d, 3.7807d, 3.8516d, 3.9225d, 3.9934d, 4.0643d, 4.1352d, 4.2061d, 4.277d, 4.3479d, 4.4188d, 4.4897d, 4.5606d, 4.6315d, 4.7024d, 4.7733d, 4.8442d, 4.9151d, 4.986d, 5.0569d, 5.1278d, 5.1987d, 5.2696d, 5.3405d, 5.4114d, 5.4823d, 5.5532d, 5.6241d, 5.695d, 5.7659d, 5.8368d, 5.9077d, 5.9786d, 6.0495d};

    /* renamed from: h, reason: collision with root package name */
    private static final double[] f31036h = {0.1958d, 0.2553d, 0.3148d, 0.3743d, 0.4338d, 0.4933d, 0.5528d, 0.6123d, 0.6718d, 0.7313d, 0.7908d, 0.8503d, 0.9098d, 0.9693d, 1.0288d, 1.0883d, 1.1478d, 1.2073d, 1.2668d, 1.3263d, 1.3858d, 1.4453d, 1.5048d, 1.5643d, 1.6238d, 1.6833d, 1.7428d, 1.8023d, 1.8618d, 1.9213d, 1.9808d, 2.0403d, 2.0998d, 2.1593d, 2.2188d, 2.2783d, 2.3378d, 2.3973d, 2.4568d, 2.5163d, 2.5758d, 2.6353d, 2.6948d, 2.7543d, 2.8138d, 2.8733d, 2.9328d};

    /* renamed from: i, reason: collision with root package name */
    private static final double[] f31037i = {3.3374d, 3.3969d, 3.4564d, 3.5159d, 3.5754d, 3.6349d, 3.6944d, 3.7539d, 3.8134d, 3.8729d, 3.9324d, 3.9919d, 4.0514d, 4.1109d, 4.1704d, 4.2299d, 4.2894d, 4.3489d, 4.4084d, 4.4679d, 4.5274d, 4.5869d, 4.6464d, 4.7059d, 4.7654d, 4.8249d, 4.8844d, 4.9439d, 5.0034d, 5.0629d, 5.1224d, 5.1819d, 5.2414d, 5.3009d, 5.3604d, 5.4199d, 5.4794d, 5.5389d, 5.5984d, 5.6579d, 5.7174d, 5.7769d, 5.8364d, 5.8959d, 5.9554d, 6.0149d, 6.0744d};

    /* renamed from: j, reason: collision with root package name */
    private static final double[] f31038j = {0.1808d, 0.2384d, 0.296d, 0.3536d, 0.4112d, 0.4688d, 0.5264d, 0.584d, 0.6416d, 0.9296d, 0.9872d, 1.0448d, 1.1024d, 1.16d, 1.2176d, 1.2752d, 1.3328d, 1.3904d, 1.448d, 1.5056d, 1.5632d, 1.6208d, 1.6784d, 1.736d, 1.7936d, 1.8512d, 1.9088d, 1.9664d, 2.024d, 2.0816d, 2.1392d, 2.1968d, 2.4848d, 2.5424d, 2.6d, 2.6576d, 2.7152d, 2.7728d, 2.8304d, 2.888d, 2.9456d};

    /* renamed from: k, reason: collision with root package name */
    private static final double[] f31039k = {3.3224d, 3.38d, 3.4376d, 3.4952d, 3.5528d, 3.6104d, 3.668d, 3.7256d, 3.7832d, 4.0712d, 4.1288d, 4.1864d, 4.244d, 4.3016d, 4.3592d, 4.4168d, 4.4744d, 4.532d, 4.5896d, 4.6472d, 4.7048d, 4.7624d, 4.82d, 4.8776d, 4.9352d, 4.9928d, 5.0504d, 5.108d, 5.1656d, 5.2232d, 5.2808d, 5.3384d, 5.6264d, 5.684d, 5.7416d, 5.7992d, 5.8568d, 5.9144d, 5.972d, 6.0296d, 6.0872d};

    /* renamed from: l, reason: collision with root package name */
    private static final double[] f31040l = {0.168d, 0.2228d, 0.2776d, 0.3324d, 0.3872d, 0.442d, 0.4968d, 0.5516d, 0.6064d, 0.99d, 1.0448d, 1.0996d, 1.1544d, 1.2092d, 1.264d, 1.3188d, 1.3736d, 1.4284d, 1.4832d, 1.538d, 1.5928d, 1.6476d, 1.7024d, 1.7572d, 1.812d, 1.8668d, 1.9216d, 1.9764d, 2.0312d, 2.086d, 2.1408d, 2.1956d, 2.5244d, 2.5792d, 2.634d, 2.6888d, 2.7436d, 2.7984d, 2.8532d, 2.908d, 2.9628d};

    /* renamed from: m, reason: collision with root package name */
    private static final double[] f31041m = {3.3096d, 3.3644d, 3.4192d, 3.474d, 3.5288d, 3.5836d, 3.6384d, 3.6932d, 3.748d, 4.1316d, 4.1864d, 4.2412d, 4.296d, 4.3508d, 4.4056d, 4.4604d, 4.5152d, 4.57d, 4.6248d, 4.6796d, 4.7344d, 4.7892d, 4.844d, 4.8988d, 4.9536d, 5.0084d, 5.0632d, 5.118d, 5.1728d, 5.2276d, 5.2824d, 5.3372d, 5.666d, 5.7208d, 5.7756d, 5.8304d, 5.8852d, 5.94d, 5.9948d, 6.0496d, 6.1044d};

    /* renamed from: n, reason: collision with root package name */
    private static final double[] f31042n = {0.1569d, 0.209d, 0.2611d, 0.3132d, 0.3653d, 0.4174d, 0.4695d, 0.5216d, 0.5737d, 0.9905d, 1.0426d, 1.0947d, 1.1468d, 1.1989d, 1.251d, 1.3031d, 1.3552d, 1.4073d, 1.4594d, 1.5115d, 1.5636d, 1.6157d, 1.6678d, 1.7199d, 1.772d, 1.8241d, 1.8762d, 1.9283d, 1.9804d, 2.0325d, 2.0846d, 2.1367d, 2.1888d, 2.5535d, 2.6056d, 2.6577d, 2.7098d, 2.7619d, 2.814d, 2.8661d, 2.9182d, 2.9703d};

    /* renamed from: o, reason: collision with root package name */
    private static final double[] f31043o = {3.2985d, 3.3506d, 3.4027d, 3.4548d, 3.5069d, 3.559d, 3.6111d, 3.6632d, 3.7153d, 4.1321d, 4.1842d, 4.2363d, 4.2884d, 4.3405d, 4.3926d, 4.4447d, 4.4968d, 4.5489d, 4.601d, 4.6531d, 4.7052d, 4.7573d, 4.8094d, 4.8615d, 4.9136d, 4.9657d, 5.0178d, 5.0699d, 5.122d, 5.1741d, 5.2262d, 5.2783d, 5.3304d, 5.6951d, 5.7472d, 5.7993d, 5.8514d, 5.9035d, 5.9556d, 6.0077d, 6.0598d, 6.1119d};

    /* renamed from: p, reason: collision with root package name */
    private static final double[] f31044p = {0.1473d, 0.197d, 0.2467d, 0.2964d, 0.3461d, 0.3958d, 0.4455d, 0.4952d, 0.5449d, 0.5946d, 0.9922d, 1.0419d, 1.0916d, 1.1413d, 1.191d, 1.2407d, 1.2904d, 1.3401d, 1.3898d, 1.4395d, 1.4892d, 1.5389d, 1.5886d, 1.6383d, 1.688d, 1.7377d, 1.7874d, 1.8371d, 1.8868d, 1.9365d, 1.9862d, 2.0359d, 2.0856d, 2.1353d, 2.185d, 2.5329d, 2.5826d, 2.6323d, 2.682d, 2.7317d, 2.7814d, 2.8311d, 2.8808d, 2.9305d, 2.9802d};

    /* renamed from: q, reason: collision with root package name */
    private static final double[] f31045q = {3.2889d, 3.3386d, 3.3883d, 3.438d, 3.4877d, 3.5374d, 3.5871d, 3.6368d, 3.6865d, 3.7362d, 4.1338d, 4.1835d, 4.2332d, 4.2829d, 4.3326d, 4.3823d, 4.432d, 4.4817d, 4.5314d, 4.5811d, 4.6308d, 4.6805d, 4.7302d, 4.7799d, 4.8296d, 4.8793d, 4.929d, 4.9787d, 5.0284d, 5.0781d, 5.1278d, 5.1775d, 5.2272d, 5.2769d, 5.3266d, 5.6745d, 5.7242d, 5.7739d, 5.8236d, 5.8733d, 5.923d, 5.9727d, 6.0224d, 6.0721d, 6.1218d};

    public static String a() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer a10 = i5.a(f31030b);
        StringBuffer a11 = i5.a(f31031c);
        StringBuffer a12 = i5.a(f31032d);
        StringBuffer a13 = i5.a(f31033e);
        StringBuffer a14 = i5.a(f31034f);
        StringBuffer a15 = i5.a(f31035g);
        StringBuffer a16 = i5.a(f31036h);
        StringBuffer a17 = i5.a(f31037i);
        StringBuffer a18 = i5.a(f31038j);
        StringBuffer a19 = i5.a(f31039k);
        StringBuffer a20 = i5.a(f31040l);
        StringBuffer a21 = i5.a(f31041m);
        StringBuffer a22 = i5.a(f31042n);
        StringBuffer a23 = i5.a(f31043o);
        StringBuffer a24 = i5.a(f31044p);
        StringBuffer a25 = i5.a(f31045q);
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
        stringBuffer.append(a20);
        stringBuffer.append(a21);
        stringBuffer.append(a22);
        stringBuffer.append(a23);
        stringBuffer.append(a24);
        stringBuffer.append(a25);
        return stringBuffer.toString();
    }

    public static s a(s sVar, s sVar2, int i10, double d10) {
        return i5.a(sVar, sVar2, i10, i5.a(d10, f31029a, a()));
    }
}
