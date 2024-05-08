package com.mobile.auth.gatewayauth.detectnet;

import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import com.mobile.auth.d.e;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.utils.i;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static volatile e f37141a;

    /* renamed from: g, reason: collision with root package name */
    private String f37147g;

    /* renamed from: h, reason: collision with root package name */
    private String f37148h;

    /* renamed from: c, reason: collision with root package name */
    private AtomicBoolean f37143c = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private int f37145e = 3;

    /* renamed from: f, reason: collision with root package name */
    private int f37146f = 2;

    /* renamed from: b, reason: collision with root package name */
    private ExecutorService f37142b = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new ArrayBlockingQueue(3), new ThreadPoolExecutor.CallerRunsPolicy());

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f37144d = new ConcurrentHashMap<>();

    public e() {
        this.f37148h = "eco.taobao.com";
        try {
            this.f37148h = new URL("https://dypnsapi.aliyuncs.com/?").getHost();
        } catch (MalformedURLException unused) {
        }
    }

    public static /* synthetic */ DetectResult a(e eVar, String str, DetectResult detectResult) {
        try {
            return eVar.b(str, detectResult);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private DetectResult a(String str, DetectResult detectResult) {
        try {
            i.a("pingNet： ping检测top默认");
            c a10 = a(str, this.f37148h);
            detectResult.setTopConnected(a10.a());
            if (a10.a()) {
                detectResult.setTopWholeMS(a10.b());
            } else {
                detectResult.setTopWholeMS(0L);
            }
            return detectResult;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static e a() {
        try {
            if (f37141a == null) {
                synchronized (e.class) {
                    if (f37141a == null) {
                        f37141a = new e();
                    }
                }
            }
            return f37141a;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ AtomicBoolean a(e eVar) {
        try {
            return eVar.f37143c;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private void a(Context context, final String str, final a aVar) {
        try {
            i.a("pingNet：检测 默认网络和蜂窝网络");
            final DetectResult detectResult = new DetectResult();
            detectResult.setRequestIds(this.f37144d.h()).setSessionIds(this.f37144d.values());
            a(str, detectResult);
            new com.mobile.auth.d.e().a(context, new e.a() { // from class: com.mobile.auth.gatewayauth.detectnet.e.2
                @Override // com.mobile.auth.d.e.a
                public void a() {
                    try {
                        i.a("pingNet：切换蜂窝网络超时！");
                        detectResult.setTopCellularConnected(false).setTopCellularWholeMS(0L).setCuCellularConnected(false).setCuCellularWholeMS(0L);
                        e.a(e.this).set(false);
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a(detectResult);
                        }
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                @Override // com.mobile.auth.d.e.a
                public void a(int i10, String str2, long j10) {
                    try {
                        i.a("pingNet：切换蜂窝网络失败！");
                        detectResult.setTopCellularConnected(false).setTopCellularWholeMS(0L).setCuCellularConnected(false).setCuCellularWholeMS(0L);
                        e.a(e.this).set(false);
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a(detectResult);
                        }
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                @Override // com.mobile.auth.d.e.a
                public void a(Network network, long j10) {
                    try {
                        i.a("pingNet：切换蜂窝网络成功！");
                        e.a(e.this, str, detectResult);
                        e.b(e.this, str, detectResult);
                        e.a(e.this).set(false);
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a(detectResult);
                        }
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void a(e eVar, Context context, String str, a aVar) {
        try {
            eVar.a(context, str, aVar);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ DetectResult b(e eVar, String str, DetectResult detectResult) {
        try {
            return eVar.c(str, detectResult);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private DetectResult b(String str, DetectResult detectResult) {
        try {
            i.a("pingNet： ping检测top蜂窝");
            c a10 = a(str, this.f37148h);
            detectResult.setTopCellularConnected(a10.a());
            if (a10.a()) {
                detectResult.setTopCellularWholeMS(a10.b());
            } else {
                detectResult.setTopCellularWholeMS(0L);
            }
            return detectResult;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ ConcurrentHashMap b(e eVar) {
        try {
            return eVar.f37144d;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ DetectResult c(e eVar, String str, DetectResult detectResult) {
        try {
            return eVar.a(str, detectResult);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private DetectResult c(String str, DetectResult detectResult) {
        try {
            i.a("pingNet： ping检测蜂窝");
            if (TextUtils.isEmpty(this.f37147g)) {
                detectResult.setCuCellularConnected(false).setCuCellularWholeMS(0L);
            } else {
                c a10 = a(str, this.f37147g);
                detectResult.setCuCellularConnected(a10.a());
                if (a10.a()) {
                    detectResult.setCuCellularWholeMS(a10.b());
                } else {
                    detectResult.setCuCellularWholeMS(0L);
                }
            }
            return detectResult;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public c a(String str, String str2) {
        try {
            i.a("pingNet：" + str + " ping start");
            c cVar = new c();
            int i10 = 0;
            while (i10 < this.f37146f) {
                cVar = d.a(str2, this.f37145e);
                i.a("pingNet：第" + i10 + "次 result：" + cVar.toString());
                i10++;
                if (cVar.a()) {
                    break;
                }
            }
            i.a("pingNet：" + str + " ping stop");
            i.a("pingNet：" + str + " 总共 ping了:" + i10 + "次");
            return cVar;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public e a(String str) {
        try {
            this.f37147g = str;
            return this;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public void a(final Context context, final String str, final String str2, final a aVar) {
        try {
            i.a("pingNet：" + str + " startDetect");
            this.f37142b.execute(new Runnable() { // from class: com.mobile.auth.gatewayauth.detectnet.e.1
                /* JADX WARN: Code restructure failed: missing block: B:7:0x0075, code lost:
                
                    if (r1 != null) goto L8;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 287
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.gatewayauth.detectnet.e.AnonymousClass1.run():void");
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
