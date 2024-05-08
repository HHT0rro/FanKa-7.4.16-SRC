package com.huawei.hms.scankit.p;

/* compiled from: VersionFour.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d8 {

    /* renamed from: a, reason: collision with root package name */
    private static final double[] f30875a = {158.0d, 169.0d, 180.0d, 191.0d, 202.0d, 213.0d, 224.0d, 235.0d, 246.0d, 257.0d};

    /* renamed from: b, reason: collision with root package name */
    private static final double[] f30876b = {0.2619d, 0.3269d, 0.3919d, 0.4569d, 0.5219d, 0.5869d, 0.6519d, 0.7169d, 0.7819d, 0.8469d, 0.9119d, 0.9769d, 1.0419d, 1.1069d, 1.1719d, 1.2369d, 1.3019d, 1.3669d, 1.4319d, 1.4969d, 1.5619d, 1.6269d, 1.6919d, 1.7569d, 1.8219d, 1.8869d, 1.9519d, 2.0169d, 2.0819d, 2.1469d, 2.2119d, 2.2769d, 2.3419d, 2.4069d, 2.4719d, 2.5369d, 2.6019d, 2.6669d, 2.7319d, 2.7969d, 2.8619d};

    /* renamed from: c, reason: collision with root package name */
    private static final double[] f30877c = {3.4035d, 3.4685d, 3.5335d, 3.5985d, 3.6635d, 3.7285d, 3.7935d, 3.8585d, 3.9235d, 3.9885d, 4.0535d, 4.1185d, 4.1835d, 4.2485d, 4.3135d, 4.3785d, 4.4435d, 4.5085d, 4.5735d, 4.6385d, 4.7035d, 4.7685d, 4.8335d, 4.8985d, 4.9635d, 5.0285d, 5.0935d, 5.1585d, 5.2235d, 5.2885d, 5.3535d, 5.4185d, 5.4835d, 5.5485d, 5.6135d, 5.6785d, 5.7435d, 5.8085d, 5.8735d, 5.9385d, 6.0035d};

    /* renamed from: d, reason: collision with root package name */
    private static final double[] f30878d = {0.245d, 0.305d, 0.365d, 0.425d, 0.485d, 0.545d, 0.605d, 0.665d, 0.725d, 0.785d, 0.845d, 0.905d, 0.965d, 1.025d, 1.085d, 1.145d, 1.205d, 1.265d, 1.325d, 1.385d, 1.445d, 1.505d, 1.565d, 1.625d, 1.685d, 1.745d, 1.805d, 1.865d, 1.925d, 1.985d, 2.045d, 2.105d, 2.165d, 2.225d, 2.285d, 2.345d, 2.405d, 2.465d, 2.525d, 2.585d, 2.645d, 2.705d, 2.765d, 2.825d, 2.885d};

    /* renamed from: e, reason: collision with root package name */
    private static final double[] f30879e = {3.3865d, 3.4465d, 3.5065d, 3.5665d, 3.6265d, 3.6865d, 3.7465d, 3.8065d, 3.8665d, 3.9265d, 3.9865d, 4.0465d, 4.1065d, 4.1665d, 4.2265d, 4.2865d, 4.3465d, 4.4065d, 4.4665d, 4.5265d, 4.5865d, 4.6465d, 4.7065d, 4.7665d, 4.8265d, 4.8865d, 4.9465d, 5.0065d, 5.0665d, 5.1265d, 5.1865d, 5.2465d, 5.3065d, 5.3665d, 5.4265d, 5.4865d, 5.5465d, 5.6065d, 5.6665d, 5.7265d, 5.7865d, 5.8465d, 5.9065d, 5.9665d, 6.0265d};

    /* renamed from: f, reason: collision with root package name */
    private static final double[] f30880f = {0.2301d, 0.2867d, 0.3433d, 0.3999d, 0.4565d, 0.5131d, 0.5697d, 0.6263d, 0.6829d, 0.7395d, 0.7961d, 0.8527d, 0.9093d, 0.9659d, 1.0225d, 1.0791d, 1.1357d, 1.1923d, 1.2489d, 1.3055d, 1.3621d, 1.4187d, 1.4753d, 1.5319d, 1.5885d, 1.6451d, 1.7017d, 1.7583d, 1.8149d, 1.8715d, 1.9281d, 1.9847d, 2.0413d, 2.0979d, 2.1545d, 2.2111d, 2.2677d, 2.3243d, 2.3809d, 2.4375d, 2.4941d, 2.5507d, 2.6073d, 2.6639d, 2.7205d, 2.7771d, 2.8337d, 2.8903d};

    /* renamed from: g, reason: collision with root package name */
    private static final double[] f30881g = {3.3717d, 3.4283d, 3.4849d, 3.5415d, 3.5981d, 3.6547d, 3.7113d, 3.7679d, 3.8245d, 3.8811d, 3.9377d, 3.9943d, 4.0509d, 4.1075d, 4.1641d, 4.2207d, 4.2773d, 4.3339d, 4.3905d, 4.4471d, 4.5037d, 4.5603d, 4.6169d, 4.6735d, 4.7301d, 4.7867d, 4.8433d, 4.8999d, 4.9565d, 5.0131d, 5.0697d, 5.1263d, 5.1829d, 5.2395d, 5.2961d, 5.3527d, 5.4093d, 5.4659d, 5.5225d, 5.5791d, 5.6357d, 5.6923d, 5.7489d, 5.8055d, 5.8621d, 5.9187d, 5.9753d, 6.0319d};

    /* renamed from: h, reason: collision with root package name */
    private static final double[] f30882h = {0.217d, 0.2668d, 0.3166d, 0.3664d, 0.4162d, 0.466d, 0.5158d, 0.5656d, 0.6154d, 0.6652d, 0.715d, 0.7648d, 0.8146d, 0.8644d, 0.9142d, 0.964d, 1.0138d, 1.0636d, 1.1134d, 1.1632d, 1.213d, 1.2628d, 1.3126d, 1.3624d, 1.4122d, 1.462d, 1.5118d, 1.5616d, 1.6114d, 1.6612d, 1.711d, 1.7608d, 1.8106d, 1.8604d, 1.9102d, 1.96d, 2.0098d, 2.0596d, 2.1094d, 2.1592d, 2.209d, 2.2588d, 2.3086d, 2.3584d, 2.4082d, 2.458d, 2.5078d, 2.5576d, 2.6074d, 2.6572d, 2.707d, 2.7568d, 2.8066d, 2.8564d, 2.9062d};

    /* renamed from: i, reason: collision with root package name */
    private static final double[] f30883i = {3.3586d, 3.4084d, 3.4582d, 3.508d, 3.5578d, 3.6076d, 3.6574d, 3.7072d, 3.757d, 3.8068d, 3.8566d, 3.9064d, 3.9562d, 4.006d, 4.0558d, 4.1056d, 4.1554d, 4.2052d, 4.255d, 4.3048d, 4.3546d, 4.4044d, 4.4542d, 4.504d, 4.5538d, 4.6036d, 4.6534d, 4.7032d, 4.753d, 4.8028d, 4.8526d, 4.9024d, 4.9522d, 5.002d, 5.0518d, 5.1016d, 5.1514d, 5.2012d, 5.251d, 5.3008d, 5.3506d, 5.4004d, 5.4502d, 5.5d, 5.5498d, 5.5996d, 5.6494d, 5.6992d, 5.749d, 5.7988d, 5.8486d, 5.8984d, 5.9482d, 5.998d, 6.0478d};

    /* renamed from: j, reason: collision with root package name */
    private static final double[] f30884j = {0.2053d, 0.2538d, 0.3023d, 0.3508d, 0.3993d, 0.4478d, 0.4963d, 0.5448d, 0.5933d, 0.6418d, 0.6903d, 0.7388d, 0.7873d, 0.8358d, 0.8843d, 0.9328d, 0.9813d, 1.0298d, 1.0783d, 1.1268d, 1.1753d, 1.2238d, 1.2723d, 1.3208d, 1.3693d, 1.4178d, 1.4663d, 1.5148d, 1.5633d, 1.6118d, 1.6603d, 1.7088d, 1.7573d, 1.8058d, 1.8543d, 1.9028d, 1.9513d, 1.9998d, 2.0483d, 2.0968d, 2.1453d, 2.1938d, 2.2423d, 2.2908d, 2.3393d, 2.3878d, 2.4363d, 2.4848d, 2.5333d, 2.5818d, 2.6303d, 2.6788d, 2.7273d, 2.7758d, 2.8243d, 2.8728d, 2.9213d};

    /* renamed from: k, reason: collision with root package name */
    private static final double[] f30885k = {3.3469d, 3.3954d, 3.4439d, 3.4924d, 3.5409d, 3.5894d, 3.6379d, 3.6864d, 3.7349d, 3.7834d, 3.8319d, 3.8804d, 3.9289d, 3.9774d, 4.0259d, 4.0744d, 4.1229d, 4.1714d, 4.2199d, 4.2684d, 4.3169d, 4.3654d, 4.4139d, 4.4624d, 4.5109d, 4.5594d, 4.6079d, 4.6564d, 4.7049d, 4.7534d, 4.8019d, 4.8504d, 4.8989d, 4.9474d, 4.9959d, 5.0444d, 5.0929d, 5.1414d, 5.1899d, 5.2384d, 5.2869d, 5.3354d, 5.3839d, 5.4324d, 5.4809d, 5.5294d, 5.5779d, 5.6264d, 5.6749d, 5.7234d, 5.7719d, 5.8204d, 5.8689d, 5.9174d, 5.9659d, 6.0144d, 6.0629d};

    /* renamed from: l, reason: collision with root package name */
    private static final double[] f30886l = {0.1949d, 0.2397d, 0.2845d, 0.3293d, 0.3741d, 0.4189d, 0.4637d, 0.5085d, 0.5533d, 0.5981d, 0.6429d, 0.6877d, 0.7325d, 0.7773d, 0.8221d, 0.8669d, 0.9117d, 0.9565d, 1.0013d, 1.0461d, 1.0909d, 1.1357d, 1.1805d, 1.2253d, 1.2701d, 1.3149d, 1.3597d, 1.4045d, 1.4493d, 1.4941d, 1.5389d, 1.5837d, 1.6285d, 1.6733d, 1.7181d, 1.7629d, 1.8077d, 1.8525d, 1.8973d, 1.9421d, 1.9869d, 2.0317d, 2.0765d, 2.1213d, 2.1661d, 2.2109d, 2.2557d, 2.3005d, 2.3453d, 2.3901d, 2.4349d, 2.4797d, 2.5245d, 2.5693d, 2.6141d, 2.6589d, 2.7037d, 2.7485d, 2.7933d, 2.8381d, 2.8829d, 2.9277d};

    /* renamed from: m, reason: collision with root package name */
    private static final double[] f30887m = {3.3365d, 3.3813d, 3.4261d, 3.4709d, 3.5157d, 3.5605d, 3.6053d, 3.6501d, 3.6949d, 3.7397d, 3.7845d, 3.8293d, 3.8741d, 3.9189d, 3.9637d, 4.0085d, 4.0533d, 4.0981d, 4.1429d, 4.1877d, 4.2325d, 4.2773d, 4.3221d, 4.3669d, 4.4117d, 4.4565d, 4.5013d, 4.5461d, 4.5909d, 4.6357d, 4.6805d, 4.7253d, 4.7701d, 4.8149d, 4.8597d, 4.9045d, 4.9493d, 4.9941d, 5.0389d, 5.0837d, 5.1285d, 5.1733d, 5.2181d, 5.2629d, 5.3077d, 5.3525d, 5.3973d, 5.4421d, 5.4869d, 5.5317d, 5.5765d, 5.6213d, 5.6661d, 5.7109d, 5.7557d, 5.8005d, 5.8453d, 5.8901d, 5.9349d, 5.9797d, 6.0245d, 6.0693d};

    /* renamed from: n, reason: collision with root package name */
    private static final double[] f30888n = {0.1855d, 0.2279d, 0.2703d, 0.3127d, 0.3551d, 0.3975d, 0.4399d, 0.4823d, 0.5247d, 0.5671d, 0.6095d, 0.6519d, 0.9063d, 0.9487d, 0.9911d, 1.0335d, 1.0759d, 1.1183d, 1.1607d, 1.2031d, 1.2455d, 1.2879d, 1.3303d, 1.3727d, 1.4151d, 1.4575d, 1.4999d, 1.5423d, 1.5847d, 1.6271d, 1.6695d, 1.7119d, 1.7543d, 1.7967d, 1.8391d, 1.8815d, 1.9239d, 1.9663d, 2.0087d, 2.0511d, 2.0935d, 2.1359d, 2.1783d, 2.2207d, 2.4751d, 2.5175d, 2.5599d, 2.6023d, 2.6447d, 2.6871d, 2.7295d, 2.7719d, 2.8143d, 2.8567d, 2.8991d, 2.9415d};

    /* renamed from: o, reason: collision with root package name */
    private static final double[] f30889o = {3.3271d, 3.3695d, 3.4119d, 3.4543d, 3.4967d, 3.5391d, 3.5815d, 3.6239d, 3.6663d, 3.7087d, 3.7511d, 3.7935d, 4.0479d, 4.0903d, 4.1327d, 4.1751d, 4.2175d, 4.2599d, 4.3023d, 4.3447d, 4.3871d, 4.4295d, 4.4719d, 4.5143d, 4.5567d, 4.5991d, 4.6415d, 4.6839d, 4.7263d, 4.7687d, 4.8111d, 4.8535d, 4.8959d, 4.9383d, 4.9807d, 5.0231d, 5.0655d, 5.1079d, 5.1503d, 5.1927d, 5.2351d, 5.2775d, 5.3199d, 5.3623d, 5.6167d, 5.6591d, 5.7015d, 5.7439d, 5.7863d, 5.8287d, 5.8711d, 5.9135d, 5.9559d, 5.9983d, 6.0407d, 6.0831d};

    /* renamed from: p, reason: collision with root package name */
    private static final double[] f30890p = {0.177d, 0.2172d, 0.2574d, 0.2976d, 0.3378d, 0.378d, 0.4182d, 0.4584d, 0.4986d, 0.5388d, 0.579d, 0.6192d, 0.9408d, 0.981d, 1.0212d, 1.0614d, 1.1016d, 1.1418d, 1.182d, 1.2222d, 1.2624d, 1.3026d, 1.3428d, 1.383d, 1.4232d, 1.4634d, 1.5036d, 1.5438d, 1.584d, 1.6242d, 1.6644d, 1.7046d, 1.7448d, 1.785d, 1.8252d, 1.8654d, 1.9056d, 1.9458d, 1.986d, 2.0262d, 2.0664d, 2.1066d, 2.1468d, 2.187d, 2.5086d, 2.5488d, 2.589d, 2.6292d, 2.6694d, 2.7096d, 2.7498d, 2.79d, 2.8302d, 2.8704d, 2.9106d, 2.9508d};

    /* renamed from: q, reason: collision with root package name */
    private static final double[] f30891q = {3.3186d, 3.3588d, 3.399d, 3.4392d, 3.4794d, 3.5196d, 3.5598d, 3.6d, 3.6402d, 3.6804d, 3.7206d, 3.7608d, 4.0824d, 4.1226d, 4.1628d, 4.203d, 4.2432d, 4.2834d, 4.3236d, 4.3638d, 4.404d, 4.4442d, 4.4844d, 4.5246d, 4.5648d, 4.605d, 4.6452d, 4.6854d, 4.7256d, 4.7658d, 4.806d, 4.8462d, 4.8864d, 4.9266d, 4.9668d, 5.007d, 5.0472d, 5.0874d, 5.1276d, 5.1678d, 5.208d, 5.2482d, 5.2884d, 5.3286d, 5.6502d, 5.6904d, 5.7306d, 5.7708d, 5.811d, 5.8512d, 5.8914d, 5.9316d, 5.9718d, 6.012d, 6.0522d, 6.0924d};

    /* renamed from: r, reason: collision with root package name */
    private static final double[] f30892r = {0.1693d, 0.2092d, 0.2491d, 0.289d, 0.3289d, 0.3688d, 0.4087d, 0.4486d, 0.4885d, 0.5284d, 0.5683d, 0.6082d, 0.9274d, 0.9673d, 1.0072d, 1.0471d, 1.087d, 1.1269d, 1.1668d, 1.2067d, 1.2466d, 1.2865d, 1.3264d, 1.3663d, 1.4062d, 1.4461d, 1.486d, 1.5259d, 1.5658d, 1.6057d, 1.6456d, 1.6855d, 1.7254d, 1.7653d, 1.8052d, 1.8451d, 1.885d, 1.9249d, 1.9648d, 2.0047d, 2.0446d, 2.0845d, 2.1244d, 2.1643d, 2.5234d, 2.5633d, 2.6032d, 2.6431d, 2.683d, 2.7229d, 2.7628d, 2.8027d, 2.8426d, 2.8825d, 2.9224d, 2.9623d};

    /* renamed from: s, reason: collision with root package name */
    private static final double[] f30893s = {3.3109d, 3.3508d, 3.3907d, 3.4306d, 3.4705d, 3.5104d, 3.5503d, 3.5902d, 3.6301d, 3.67d, 3.7099d, 3.7498d, 4.069d, 4.1089d, 4.1488d, 4.1887d, 4.2286d, 4.2685d, 4.3084d, 4.3483d, 4.3882d, 4.4281d, 4.468d, 4.5079d, 4.5478d, 4.5877d, 4.6276d, 4.6675d, 4.7074d, 4.7473d, 4.7872d, 4.8271d, 4.867d, 4.9069d, 4.9468d, 4.9867d, 5.0266d, 5.0665d, 5.1064d, 5.1463d, 5.1862d, 5.2261d, 5.266d, 5.3059d, 5.665d, 5.7049d, 5.7448d, 5.7847d, 5.8246d, 5.8645d, 5.9044d, 5.9443d, 5.9842d, 6.0241d, 6.064d, 6.1039d};

    /* renamed from: t, reason: collision with root package name */
    private static final double[] f30894t = {0.1623d, 0.2002d, 0.2381d, 0.276d, 0.3139d, 0.3518d, 0.3897d, 0.4276d, 0.4655d, 0.5034d, 0.5413d, 0.5792d, 0.6171d, 0.9203d, 0.9582d, 0.9961d, 1.034d, 1.0719d, 1.1098d, 1.1477d, 1.1856d, 1.2235d, 1.2614d, 1.2993d, 1.3372d, 1.3751d, 1.413d, 1.4509d, 1.4888d, 1.5267d, 1.5646d, 1.6025d, 1.6404d, 1.6783d, 1.7162d, 1.7541d, 1.792d, 1.8299d, 1.8678d, 1.9057d, 1.9436d, 1.9815d, 2.0194d, 2.0573d, 2.0952d, 2.1331d, 2.171d, 2.55d, 2.5879d, 2.6258d, 2.6637d, 2.7016d, 2.7395d, 2.7774d, 2.8153d, 2.8532d, 2.8911d, 2.929d, 2.9669d};

    /* renamed from: u, reason: collision with root package name */
    private static final double[] f30895u = {3.3039d, 3.3418d, 3.3797d, 3.4176d, 3.4555d, 3.4934d, 3.5313d, 3.5692d, 3.6071d, 3.645d, 3.6829d, 3.7208d, 3.7587d, 4.0619d, 4.0998d, 4.1377d, 4.1756d, 4.2135d, 4.2514d, 4.2893d, 4.3272d, 4.3651d, 4.403d, 4.4409d, 4.4788d, 4.5167d, 4.5546d, 4.5925d, 4.6304d, 4.6683d, 4.7062d, 4.7441d, 4.782d, 4.8199d, 4.8578d, 4.8957d, 4.9336d, 4.9715d, 5.0094d, 5.0473d, 5.0852d, 5.1231d, 5.161d, 5.1989d, 5.2368d, 5.2747d, 5.3126d, 5.6916d, 5.7295d, 5.7674d, 5.8053d, 5.8432d, 5.8811d, 5.919d, 5.9569d, 5.9948d, 6.0327d, 6.0706d, 6.1085d};

    public static String a() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer a10 = i5.a(f30876b);
        StringBuffer a11 = i5.a(f30877c);
        StringBuffer a12 = i5.a(f30878d);
        StringBuffer a13 = i5.a(f30879e);
        StringBuffer a14 = i5.a(f30880f);
        StringBuffer a15 = i5.a(f30881g);
        StringBuffer a16 = i5.a(f30882h);
        StringBuffer a17 = i5.a(f30883i);
        StringBuffer a18 = i5.a(f30884j);
        StringBuffer a19 = i5.a(f30885k);
        StringBuffer a20 = i5.a(f30886l);
        StringBuffer a21 = i5.a(f30887m);
        StringBuffer a22 = i5.a(f30888n);
        StringBuffer a23 = i5.a(f30889o);
        StringBuffer a24 = i5.a(f30890p);
        StringBuffer a25 = i5.a(f30891q);
        StringBuffer a26 = i5.a(f30892r);
        StringBuffer a27 = i5.a(f30893s);
        StringBuffer a28 = i5.a(f30894t);
        StringBuffer a29 = i5.a(f30895u);
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
        stringBuffer.append(a26);
        stringBuffer.append(a27);
        stringBuffer.append(a28);
        stringBuffer.append(a29);
        return stringBuffer.toString();
    }

    public static s a(s sVar, s sVar2, int i10, double d10) {
        return i5.a(sVar, sVar2, i10, i5.a(d10, f30875a, a()));
    }
}
