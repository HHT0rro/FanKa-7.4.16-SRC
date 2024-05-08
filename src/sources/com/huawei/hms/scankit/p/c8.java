package com.huawei.hms.scankit.p;

/* compiled from: VersionFive.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c8 {

    /* renamed from: a, reason: collision with root package name */
    private static final double[] f30808a = {164.0d, 176.0d, 188.0d, 200.0d, 212.0d, 224.0d, 236.0d, 248.0d, 260.0d, 272.0d, 284.0d};

    /* renamed from: b, reason: collision with root package name */
    private static final double[] f30809b = {0.2524d, 0.3213d, 0.3902d, 0.4591d, 0.528d, 0.5969d, 0.6658d, 0.7347d, 0.8036d, 0.8725d, 0.9414d, 1.0103d, 1.0792d, 1.1481d, 1.217d, 1.2859d, 1.3548d, 1.4237d, 1.4926d, 1.5615d, 1.6304d, 1.6993d, 1.7682d, 1.8371d, 1.906d, 1.9749d, 2.0438d, 2.1127d, 2.1816d, 2.2505d, 2.3194d, 2.3883d, 2.4572d, 2.5261d, 2.595d, 2.6639d, 2.7328d, 2.8017d, 2.8706d};

    /* renamed from: c, reason: collision with root package name */
    private static final double[] f30810c = {3.394d, 3.4629d, 3.5318d, 3.6007d, 3.6696d, 3.7385d, 3.8074d, 3.8763d, 3.9452d, 4.0141d, 4.083d, 4.1519d, 4.2208d, 4.2897d, 4.3586d, 4.4275d, 4.4964d, 4.5653d, 4.6342d, 4.7031d, 4.772d, 4.8409d, 4.9098d, 4.9787d, 5.0476d, 5.1165d, 5.1854d, 5.2543d, 5.3232d, 5.3921d, 5.461d, 5.5299d, 5.5988d, 5.6677d, 5.7366d, 5.8055d, 5.8744d, 5.9433d, 6.0122d};

    /* renamed from: d, reason: collision with root package name */
    private static final double[] f30811d = {0.2353d, 0.2969d, 0.3585d, 0.4201d, 0.4817d, 0.5433d, 0.6049d, 0.6665d, 0.7281d, 0.7897d, 0.8513d, 0.9129d, 0.9745d, 1.0361d, 1.0977d, 1.1593d, 1.2209d, 1.2825d, 1.3441d, 1.4057d, 1.4673d, 1.5289d, 1.5905d, 1.6521d, 1.7137d, 1.7753d, 1.8369d, 1.8985d, 1.9601d, 2.0217d, 2.0833d, 2.1449d, 2.2065d, 2.2681d, 2.3297d, 2.3913d, 2.4529d, 2.5145d, 2.5761d, 2.6377d, 2.6993d, 2.7609d, 2.8225d, 2.8841d};

    /* renamed from: e, reason: collision with root package name */
    private static final double[] f30812e = {3.3769d, 3.4385d, 3.5001d, 3.5617d, 3.6233d, 3.6849d, 3.7465d, 3.8081d, 3.8697d, 3.9313d, 3.9929d, 4.0545d, 4.1161d, 4.1777d, 4.2393d, 4.3009d, 4.3625d, 4.4241d, 4.4857d, 4.5473d, 4.6089d, 4.6705d, 4.7321d, 4.7937d, 4.8553d, 4.9169d, 4.9785d, 5.0401d, 5.1017d, 5.1633d, 5.2249d, 5.2865d, 5.3481d, 5.4097d, 5.4713d, 5.5329d, 5.5945d, 5.6561d, 5.7177d, 5.7793d, 5.8409d, 5.9025d, 5.9641d, 6.0257d};

    /* renamed from: f, reason: collision with root package name */
    private static final double[] f30813f = {0.2204d, 0.2775d, 0.3346d, 0.3917d, 0.4488d, 0.5059d, 0.563d, 0.6201d, 0.6772d, 0.7343d, 0.7914d, 0.8485d, 0.9056d, 0.9627d, 1.0198d, 1.0769d, 1.134d, 1.1911d, 1.2482d, 1.3053d, 1.3624d, 1.4195d, 1.4766d, 1.5337d, 1.5908d, 1.6479d, 1.705d, 1.7621d, 1.8192d, 1.8763d, 1.9334d, 1.9905d, 2.0476d, 2.1047d, 2.1618d, 2.2189d, 2.276d, 2.3331d, 2.3902d, 2.4473d, 2.5044d, 2.5615d, 2.6186d, 2.6757d, 2.7328d, 2.7899d, 2.847d, 2.9041d};

    /* renamed from: g, reason: collision with root package name */
    private static final double[] f30814g = {3.362d, 3.4191d, 3.4762d, 3.5333d, 3.5904d, 3.6475d, 3.7046d, 3.7617d, 3.8188d, 3.8759d, 3.933d, 3.9901d, 4.0472d, 4.1043d, 4.1614d, 4.2185d, 4.2756d, 4.3327d, 4.3898d, 4.4469d, 4.504d, 4.5611d, 4.6182d, 4.6753d, 4.7324d, 4.7895d, 4.8466d, 4.9037d, 4.9608d, 5.0179d, 5.075d, 5.1321d, 5.1892d, 5.2463d, 5.3034d, 5.3605d, 5.4176d, 5.4747d, 5.5318d, 5.5889d, 5.646d, 5.7031d, 5.7602d, 5.8173d, 5.8744d, 5.9315d, 5.9886d, 6.0457d};

    /* renamed from: h, reason: collision with root package name */
    private static final double[] f30815h = {0.2074d, 0.2605d, 0.3136d, 0.3667d, 0.4198d, 0.4729d, 0.526d, 0.5791d, 0.6322d, 0.6853d, 0.7384d, 0.7915d, 0.8446d, 0.8977d, 0.9508d, 1.0039d, 1.057d, 1.1101d, 1.1632d, 1.2163d, 1.2694d, 1.3225d, 1.3756d, 1.4287d, 1.4818d, 1.5349d, 1.588d, 1.6411d, 1.6942d, 1.7473d, 1.8004d, 1.8535d, 1.9066d, 1.9597d, 2.0128d, 2.0659d, 2.119d, 2.1721d, 2.2252d, 2.2783d, 2.3314d, 2.3845d, 2.4376d, 2.4907d, 2.5438d, 2.5969d, 2.65d, 2.7031d, 2.7562d, 2.8093d, 2.8624d, 2.9155d};

    /* renamed from: i, reason: collision with root package name */
    private static final double[] f30816i = {3.349d, 3.4021d, 3.4552d, 3.5083d, 3.5614d, 3.6145d, 3.6676d, 3.7207d, 3.7738d, 3.8269d, 3.88d, 3.9331d, 3.9862d, 4.0393d, 4.0924d, 4.1455d, 4.1986d, 4.2517d, 4.3048d, 4.3579d, 4.411d, 4.4641d, 4.5172d, 4.5703d, 4.6234d, 4.6765d, 4.7296d, 4.7827d, 4.8358d, 4.8889d, 4.942d, 4.9951d, 5.0482d, 5.1013d, 5.1544d, 5.2075d, 5.2606d, 5.3137d, 5.3668d, 5.4199d, 5.473d, 5.5261d, 5.5792d, 5.6323d, 5.6854d, 5.7385d, 5.7916d, 5.8447d, 5.8978d, 5.9509d, 6.004d, 6.0571d};

    /* renamed from: j, reason: collision with root package name */
    private static final double[] f30817j = {0.1958d, 0.2484d, 0.301d, 0.3536d, 0.4062d, 0.4588d, 0.5114d, 0.564d, 0.6166d, 0.6692d, 0.7218d, 0.7744d, 0.827d, 0.8796d, 0.9322d, 0.9848d, 1.0374d, 1.09d, 1.1426d, 1.1952d, 1.2478d, 1.3004d, 1.353d, 1.4056d, 1.4582d, 1.5108d, 1.5634d, 1.616d, 1.6686d, 1.7212d, 1.7738d, 1.8264d, 1.879d, 1.9316d, 1.9842d, 2.0368d, 2.0894d, 2.142d, 2.1946d, 2.2472d, 2.2998d, 2.3524d, 2.405d, 2.4576d, 2.5102d, 2.5628d, 2.6154d, 2.668d, 2.7206d, 2.7732d, 2.8258d, 2.8784d, 2.931d};

    /* renamed from: k, reason: collision with root package name */
    private static final double[] f30818k = {3.3374d, 3.39d, 3.4426d, 3.4952d, 3.5478d, 3.6004d, 3.653d, 3.7056d, 3.7582d, 3.8108d, 3.8634d, 3.916d, 3.9686d, 4.0212d, 4.0738d, 4.1264d, 4.179d, 4.2316d, 4.2842d, 4.3368d, 4.3894d, 4.442d, 4.4946d, 4.5472d, 4.5998d, 4.6524d, 4.705d, 4.7576d, 4.8102d, 4.8628d, 4.9154d, 4.968d, 5.0206d, 5.0732d, 5.1258d, 5.1784d, 5.231d, 5.2836d, 5.3362d, 5.3888d, 5.4414d, 5.494d, 5.5466d, 5.5992d, 5.6518d, 5.7044d, 5.757d, 5.8096d, 5.8622d, 5.9148d, 5.9674d, 6.02d, 6.0726d};

    /* renamed from: l, reason: collision with root package name */
    private static final double[] f30819l = {0.1855d, 0.2347d, 0.2839d, 0.3331d, 0.3823d, 0.4315d, 0.4807d, 0.5299d, 0.5791d, 0.6283d, 0.6775d, 0.7267d, 0.7759d, 0.8251d, 0.8743d, 0.9235d, 0.9727d, 1.0219d, 1.0711d, 1.1203d, 1.1695d, 1.2187d, 1.2679d, 1.3171d, 1.3663d, 1.4155d, 1.4647d, 1.5139d, 1.5631d, 1.6123d, 1.6615d, 1.7107d, 1.7599d, 1.8091d, 1.8583d, 1.9075d, 1.9567d, 2.0059d, 2.0551d, 2.1043d, 2.1535d, 2.2027d, 2.2519d, 2.3011d, 2.3503d, 2.3995d, 2.4487d, 2.4979d, 2.5471d, 2.5963d, 2.6455d, 2.6947d, 2.7439d, 2.7931d, 2.8423d, 2.8915d, 2.9407d};

    /* renamed from: m, reason: collision with root package name */
    private static final double[] f30820m = {3.3271d, 3.3763d, 3.4255d, 3.4747d, 3.5239d, 3.5731d, 3.6223d, 3.6715d, 3.7207d, 3.7699d, 3.8191d, 3.8683d, 3.9175d, 3.9667d, 4.0159d, 4.0651d, 4.1143d, 4.1635d, 4.2127d, 4.2619d, 4.3111d, 4.3603d, 4.4095d, 4.4587d, 4.5079d, 4.5571d, 4.6063d, 4.6555d, 4.7047d, 4.7539d, 4.8031d, 4.8523d, 4.9015d, 4.9507d, 4.9999d, 5.0491d, 5.0983d, 5.1475d, 5.1967d, 5.2459d, 5.2951d, 5.3443d, 5.3935d, 5.4427d, 5.4919d, 5.5411d, 5.5903d, 5.6395d, 5.6887d, 5.7379d, 5.7871d, 5.8363d, 5.8855d, 5.9347d, 5.9839d, 6.0331d, 6.0823d};

    /* renamed from: n, reason: collision with root package name */
    private static final double[] f30821n = {0.1763d, 0.2225d, 0.2687d, 0.3149d, 0.3611d, 0.4073d, 0.4535d, 0.4997d, 0.5459d, 0.5921d, 0.6383d, 0.6845d, 0.7307d, 0.7769d, 0.8231d, 0.8693d, 0.9155d, 0.9617d, 1.0079d, 1.0541d, 1.1003d, 1.1465d, 1.1927d, 1.2389d, 1.2851d, 1.3313d, 1.3775d, 1.4237d, 1.4699d, 1.5161d, 1.5623d, 1.6085d, 1.6547d, 1.7009d, 1.7471d, 1.7933d, 1.8395d, 1.8857d, 1.9319d, 1.9781d, 2.0243d, 2.0705d, 2.1167d, 2.1629d, 2.2091d, 2.2553d, 2.3015d, 2.3477d, 2.3939d, 2.4401d, 2.4863d, 2.5325d, 2.5787d, 2.6249d, 2.6711d, 2.7173d, 2.7635d, 2.8097d, 2.8559d, 2.9021d, 2.9483d};

    /* renamed from: o, reason: collision with root package name */
    private static final double[] f30822o = {3.3179d, 3.3641d, 3.4103d, 3.4565d, 3.5027d, 3.5489d, 3.5951d, 3.6413d, 3.6875d, 3.7337d, 3.7799d, 3.8261d, 3.8723d, 3.9185d, 3.9647d, 4.0109d, 4.0571d, 4.1033d, 4.1495d, 4.1957d, 4.2419d, 4.2881d, 4.3343d, 4.3805d, 4.4267d, 4.4729d, 4.5191d, 4.5653d, 4.6115d, 4.6577d, 4.7039d, 4.7501d, 4.7963d, 4.8425d, 4.8887d, 4.9349d, 4.9811d, 5.0273d, 5.0735d, 5.1197d, 5.1659d, 5.2121d, 5.2583d, 5.3045d, 5.3507d, 5.3969d, 5.4431d, 5.4893d, 5.5355d, 5.5817d, 5.6279d, 5.6741d, 5.7203d, 5.7665d, 5.8127d, 5.8589d, 5.9051d, 5.9513d, 5.9975d, 6.0437d, 6.0899d};

    /* renamed from: p, reason: collision with root package name */
    private static final double[] f30823p = {0.168d, 0.2109d, 0.2538d, 0.2967d, 0.3396d, 0.3825d, 0.4254d, 0.4683d, 0.5112d, 0.5541d, 0.597d, 0.6399d, 0.9402d, 0.9831d, 1.026d, 1.0689d, 1.1118d, 1.1547d, 1.1976d, 1.2405d, 1.2834d, 1.3263d, 1.3692d, 1.4121d, 1.455d, 1.4979d, 1.5408d, 1.5837d, 1.6266d, 1.6695d, 1.7124d, 1.7553d, 1.7982d, 1.8411d, 1.884d, 1.9269d, 1.9698d, 2.0127d, 2.0556d, 2.0985d, 2.1414d, 2.1843d, 2.2272d, 2.4846d, 2.5275d, 2.5704d, 2.6133d, 2.6562d, 2.6991d, 2.742d, 2.7849d, 2.8278d, 2.8707d, 2.9136d, 2.9565d};

    /* renamed from: q, reason: collision with root package name */
    private static final double[] f30824q = {3.3096d, 3.3525d, 3.3954d, 3.4383d, 3.4812d, 3.5241d, 3.567d, 3.6099d, 3.6528d, 3.6957d, 3.7386d, 3.7815d, 3.8244d, 4.0389d, 4.0818d, 4.1247d, 4.1676d, 4.2105d, 4.2534d, 4.2963d, 4.3392d, 4.3821d, 4.425d, 4.4679d, 4.5108d, 4.5537d, 4.5966d, 4.6395d, 4.6824d, 4.7253d, 4.7682d, 4.8111d, 4.854d, 4.8969d, 4.9398d, 4.9827d, 5.0256d, 5.0685d, 5.1114d, 5.1543d, 5.1972d, 5.2401d, 5.283d, 5.3259d, 5.3688d, 5.6262d, 5.6691d, 5.712d, 5.7549d, 5.7978d, 5.8407d, 5.8836d, 5.9265d, 5.9694d, 6.0123d, 6.0552d, 6.0981d};

    /* renamed from: r, reason: collision with root package name */
    private static final double[] f30825r = {0.1605d, 0.2024d, 0.2443d, 0.2862d, 0.3281d, 0.37d, 0.4119d, 0.4538d, 0.4957d, 0.5376d, 0.5795d, 0.6214d, 0.9566d, 0.9985d, 1.0404d, 1.0823d, 1.1242d, 1.1661d, 1.208d, 1.2499d, 1.2918d, 1.3337d, 1.3756d, 1.4175d, 1.4594d, 1.5013d, 1.5432d, 1.5851d, 1.627d, 1.6689d, 1.7108d, 1.7527d, 1.7946d, 1.8365d, 1.8784d, 1.9203d, 1.9622d, 2.0041d, 2.046d, 2.0879d, 2.1298d, 2.1717d, 2.2136d, 2.5069d, 2.5488d, 2.5907d, 2.6326d, 2.6745d, 2.7164d, 2.7583d, 2.8002d, 2.8421d, 2.884d, 2.9259d, 2.9678d};

    /* renamed from: s, reason: collision with root package name */
    private static final double[] f30826s = {3.3021d, 3.344d, 3.3859d, 3.4278d, 3.4697d, 3.5116d, 3.5535d, 3.5954d, 3.6373d, 3.6792d, 3.7211d, 3.763d, 3.8049d, 4.0563d, 4.0982d, 4.1401d, 4.182d, 4.2239d, 4.2658d, 4.3077d, 4.3496d, 4.3915d, 4.4334d, 4.4753d, 4.5172d, 4.5591d, 4.601d, 4.6429d, 4.6848d, 4.7267d, 4.7686d, 4.8105d, 4.8524d, 4.8943d, 4.9362d, 4.9781d, 5.02d, 5.0619d, 5.1038d, 5.1457d, 5.1876d, 5.2295d, 5.2714d, 5.3133d, 5.3552d, 5.6485d, 5.6904d, 5.7323d, 5.7742d, 5.8161d, 5.858d, 5.8999d, 5.9418d, 5.9837d, 6.0256d, 6.0675d, 6.1094d};

    /* renamed from: t, reason: collision with root package name */
    private static final double[] f30827t = {0.1536d, 0.1945d, 0.2354d, 0.2763d, 0.3172d, 0.3581d, 0.399d, 0.4399d, 0.4808d, 0.5217d, 0.5626d, 0.6035d, 0.9307d, 0.9716d, 1.0125d, 1.0534d, 1.0943d, 1.1352d, 1.1761d, 1.217d, 1.2579d, 1.2988d, 1.3397d, 1.3806d, 1.4215d, 1.4624d, 1.5033d, 1.5442d, 1.5851d, 1.626d, 1.6669d, 1.7078d, 1.7487d, 1.7896d, 1.8305d, 1.8714d, 1.9123d, 1.9532d, 1.9941d, 2.035d, 2.0759d, 2.1168d, 2.1577d, 2.1986d, 2.5258d, 2.5667d, 2.6076d, 2.6485d, 2.6894d, 2.7303d, 2.7712d, 2.8121d, 2.853d, 2.8939d, 2.9348d, 2.9757d};

    /* renamed from: u, reason: collision with root package name */
    private static final double[] f30828u = {3.2952d, 3.3361d, 3.377d, 3.4179d, 3.4588d, 3.4997d, 3.5406d, 3.5815d, 3.6224d, 3.6633d, 3.7042d, 3.7451d, 3.786d, 4.0723d, 4.1132d, 4.1541d, 4.195d, 4.2359d, 4.2768d, 4.3177d, 4.3586d, 4.3995d, 4.4404d, 4.4813d, 4.5222d, 4.5631d, 4.604d, 4.6449d, 4.6858d, 4.7267d, 4.7676d, 4.8085d, 4.8494d, 4.8903d, 4.9312d, 4.9721d, 5.013d, 5.0539d, 5.0948d, 5.1357d, 5.1766d, 5.2175d, 5.2584d, 5.2993d, 5.3402d, 5.6674d, 5.7083d, 5.7492d, 5.7901d, 5.831d, 5.8719d, 5.9128d, 5.9537d, 5.9946d, 6.0355d, 6.0764d, 6.1173d};

    /* renamed from: v, reason: collision with root package name */
    private static final double[] f30829v = {0.1473d, 0.1867d, 0.2261d, 0.2655d, 0.3049d, 0.3443d, 0.3837d, 0.4231d, 0.4625d, 0.5019d, 0.5413d, 0.5807d, 0.6201d, 0.9353d, 0.9747d, 1.0141d, 1.0535d, 1.0929d, 1.1323d, 1.1717d, 1.2111d, 1.2505d, 1.2899d, 1.3293d, 1.3687d, 1.4081d, 1.4475d, 1.4869d, 1.5263d, 1.5657d, 1.6051d, 1.6445d, 1.6839d, 1.7233d, 1.7627d, 1.8021d, 1.8415d, 1.8809d, 1.9203d, 1.9597d, 1.9991d, 2.0385d, 2.0779d, 2.1173d, 2.1567d, 2.1961d, 2.5507d, 2.5901d, 2.6295d, 2.6689d, 2.7083d, 2.7477d, 2.7871d, 2.8265d, 2.8659d, 2.9053d, 2.9447d, 2.9841d};

    /* renamed from: w, reason: collision with root package name */
    private static final double[] f30830w = {3.2889d, 3.3283d, 3.3677d, 3.4071d, 3.4465d, 3.4859d, 3.5253d, 3.5647d, 3.6041d, 3.6435d, 3.6829d, 3.7223d, 3.7617d, 3.8011d, 4.0769d, 4.1163d, 4.1557d, 4.1951d, 4.2345d, 4.2739d, 4.3133d, 4.3527d, 4.3921d, 4.4315d, 4.4709d, 4.5103d, 4.5497d, 4.5891d, 4.6285d, 4.6679d, 4.7073d, 4.7467d, 4.7861d, 4.8255d, 4.8649d, 4.9043d, 4.9437d, 4.9831d, 5.0225d, 5.0619d, 5.1013d, 5.1407d, 5.1801d, 5.2195d, 5.2589d, 5.2983d, 5.3377d, 5.6923d, 5.7317d, 5.7711d, 5.8105d, 5.8499d, 5.8893d, 5.9287d, 5.9681d, 6.0075d, 6.0469d, 6.0863d, 6.1257d};

    public static String a() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer a10 = i5.a(f30809b);
        StringBuffer a11 = i5.a(f30810c);
        StringBuffer a12 = i5.a(f30811d);
        StringBuffer a13 = i5.a(f30812e);
        StringBuffer a14 = i5.a(f30813f);
        StringBuffer a15 = i5.a(f30814g);
        StringBuffer a16 = i5.a(f30815h);
        StringBuffer a17 = i5.a(f30816i);
        StringBuffer a18 = i5.a(f30817j);
        StringBuffer a19 = i5.a(f30818k);
        StringBuffer a20 = i5.a(f30819l);
        StringBuffer a21 = i5.a(f30820m);
        StringBuffer a22 = i5.a(f30821n);
        StringBuffer a23 = i5.a(f30822o);
        StringBuffer a24 = i5.a(f30823p);
        StringBuffer a25 = i5.a(f30824q);
        StringBuffer a26 = i5.a(f30825r);
        StringBuffer a27 = i5.a(f30826s);
        StringBuffer a28 = i5.a(f30827t);
        StringBuffer a29 = i5.a(f30828u);
        StringBuffer a30 = i5.a(f30829v);
        StringBuffer a31 = i5.a(f30830w);
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
        stringBuffer.append(a30);
        stringBuffer.append(a31);
        return stringBuffer.toString();
    }

    public static s a(s sVar, s sVar2, int i10, double d10) {
        return i5.a(sVar, sVar2, i10, i5.a(d10, f30808a, a()));
    }
}
