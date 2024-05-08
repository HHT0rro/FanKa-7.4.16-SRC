package com.mobile.auth.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.nirvana.tools.core.MobileNetRequestManager;
import java.net.InetAddress;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36759a = "e";

    /* renamed from: e, reason: collision with root package name */
    private a f36763e;

    /* renamed from: b, reason: collision with root package name */
    private boolean f36760b = false;

    /* renamed from: c, reason: collision with root package name */
    private ConnectivityManager f36761c = null;

    /* renamed from: d, reason: collision with root package name */
    private ConnectivityManager.NetworkCallback f36762d = null;

    /* renamed from: f, reason: collision with root package name */
    private long f36764f = 0;

    /* renamed from: g, reason: collision with root package name */
    private long f36765g = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a();

        void a(int i10, String str, long j10);

        void a(Network network, long j10);
    }

    public static int a(String str) {
        try {
            try {
                byte[] address = InetAddress.getByName(str).getAddress();
                return (address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8);
            } catch (Throwable th) {
                com.mobile.auth.a.a.a(f36759a, "When InetAddress.getByName(),throws exception", th);
                return -1;
            }
        } catch (Throwable th2) {
            try {
                ExceptionProcessor.processException(th2);
                return -1;
            } catch (Throwable th3) {
                ExceptionProcessor.processException(th3);
                return -1;
            }
        }
    }

    public static /* synthetic */ long a(e eVar, long j10) {
        try {
            eVar.f36764f = j10;
            return j10;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return -1L;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return -1L;
            }
        }
    }

    public static /* synthetic */ ConnectivityManager a(e eVar, ConnectivityManager connectivityManager) {
        try {
            eVar.f36761c = connectivityManager;
            return connectivityManager;
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

    public static /* synthetic */ String a() {
        try {
            return f36759a;
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

    private void a(Context context) {
        try {
            this.f36764f = 0L;
            this.f36761c = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            this.f36765g = System.currentTimeMillis();
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            NetworkRequest build = builder.build();
            ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.mobile.auth.d.e.2
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        e eVar = e.this;
                        e.a(eVar, currentTimeMillis - e.d(eVar));
                        e.a(e.this, true);
                        if (e.b(e.this) != null) {
                            e.b(e.this).a(network, e.e(e.this));
                        }
                        if (e.f(e.this) != null) {
                            try {
                                e.f(e.this).unregisterNetworkCallback(this);
                                e.a(e.this, (ConnectivityManager) null);
                            } catch (Throwable th) {
                                com.mobile.auth.a.a.a(e.a(), "switchToMobileForAboveL", th);
                            }
                        }
                    } catch (Throwable th2) {
                        try {
                            ExceptionProcessor.processException(th2);
                        } catch (Throwable th3) {
                            ExceptionProcessor.processException(th3);
                        }
                    }
                }
            };
            this.f36762d = networkCallback;
            this.f36761c.requestNetwork(build, networkCallback);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ boolean a(e eVar) {
        try {
            return eVar.f36760b;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public static /* synthetic */ boolean a(e eVar, boolean z10) {
        try {
            eVar.f36760b = z10;
            return z10;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public static /* synthetic */ a b(e eVar) {
        try {
            return eVar.f36763e;
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

    public static String b(String str) {
        try {
            int indexOf = str.indexOf("://");
            if (indexOf > 0) {
                str = str.substring(indexOf + 3);
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 >= 0) {
                str = str.substring(0, indexOf2);
            }
            int indexOf3 = str.indexOf(47);
            if (indexOf3 >= 0) {
                str = str.substring(0, indexOf3);
            }
            int indexOf4 = str.indexOf(63);
            return indexOf4 >= 0 ? str.substring(0, indexOf4) : str;
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

    private void b() {
        ConnectivityManager.NetworkCallback networkCallback;
        try {
            ConnectivityManager connectivityManager = this.f36761c;
            if (connectivityManager == null || (networkCallback = this.f36762d) == null) {
                return;
            }
            try {
                connectivityManager.unregisterNetworkCallback(networkCallback);
            } catch (Throwable th) {
                com.mobile.auth.a.a.a(f36759a, "unregisterNetworkCallback", th);
            }
            this.f36761c = null;
        } catch (Throwable th2) {
            try {
                ExceptionProcessor.processException(th2);
            } catch (Throwable th3) {
                ExceptionProcessor.processException(th3);
            }
        }
    }

    private boolean b(Context context, String str) {
        boolean z10;
        try {
            Class<?> cls = Class.forName("android.net.ConnectivityManager");
            this.f36764f = 0L;
            this.f36765g = System.currentTimeMillis();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.f36761c = connectivityManager;
            if (connectivityManager.getNetworkInfo(5).getState().compareTo((Enum) NetworkInfo.State.CONNECTED) != 0) {
                cls.getMethod("startUsingNetworkFeature", Integer.TYPE, String.class).invoke(this.f36761c, 0, "enableHIPRI");
                for (int i10 = 0; i10 < 5; i10++) {
                    try {
                        if (this.f36761c.getNetworkInfo(5).getState().compareTo((Enum) NetworkInfo.State.CONNECTED) == 0) {
                            break;
                        }
                        Thread.sleep(500L);
                    } catch (Throwable th) {
                        com.mobile.auth.a.a.a(f36759a, "switchToMobileForUnderL", th);
                    }
                }
            }
            int a10 = a(b(str));
            Class<Integer> cls2 = Integer.TYPE;
            boolean booleanValue = ((Boolean) cls.getMethod("requestRouteToHost", cls2, cls2).invoke(this.f36761c, 5, Integer.valueOf(a10))).booleanValue();
            try {
                this.f36764f = System.currentTimeMillis() - this.f36765g;
                com.mobile.auth.a.a.a(f36759a, "Switch network result ： " + booleanValue + " (4.x) , expendTime ：" + this.f36764f);
                return booleanValue;
            } catch (Throwable th2) {
                z10 = booleanValue;
                th = th2;
                try {
                    com.mobile.auth.a.a.a(f36759a, "4.x网络切换异常", th);
                    return z10;
                } catch (Throwable th3) {
                    try {
                        ExceptionProcessor.processException(th3);
                        return false;
                    } catch (Throwable th4) {
                        ExceptionProcessor.processException(th4);
                        return false;
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
            z10 = false;
        }
    }

    public static /* synthetic */ void c(e eVar) {
        try {
            eVar.b();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ long d(e eVar) {
        try {
            return eVar.f36765g;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return -1L;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return -1L;
            }
        }
    }

    public static /* synthetic */ long e(e eVar) {
        try {
            return eVar.f36764f;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return -1L;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return -1L;
            }
        }
    }

    public static /* synthetic */ ConnectivityManager f(e eVar) {
        try {
            return eVar.f36761c;
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

    public void a(final int i10) {
        try {
            i.a().a(new Runnable() { // from class: com.mobile.auth.d.e.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (i10 > 2500) {
                            try {
                                Thread.sleep(2500L);
                            } catch (Throwable th) {
                                com.mobile.auth.a.a.a(e.a(), "timeoutCheckRunnable exception!", th);
                            }
                            if (!e.a(e.this)) {
                                if (e.b(e.this) != null) {
                                    e.b(e.this).a(MobileNetRequestManager.CODE_SWITCH_TIMEOUT, MobileNetRequestManager.MSG_SWITCH_TIMEOUT, 2500L);
                                }
                                com.mobile.auth.a.a.a(e.a(), "切换网络超时(L)");
                                e.c(e.this);
                                return;
                            }
                        }
                        try {
                            int i11 = i10;
                            if (i11 > 2500) {
                                i11 -= 2500;
                            }
                            Thread.sleep(i11);
                        } catch (Throwable th2) {
                            com.mobile.auth.a.a.a(e.a(), "timeoutCheckRunnable exception!", th2);
                        }
                        if (e.b(e.this) != null) {
                            if (e.a(e.this)) {
                                e.b(e.this).a();
                            } else {
                                e.b(e.this).a(MobileNetRequestManager.CODE_SWITCH_TIMEOUT, MobileNetRequestManager.MSG_SWITCH_TIMEOUT, 2500L);
                                e.c(e.this);
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            ExceptionProcessor.processException(th3);
                        } catch (Throwable th4) {
                            ExceptionProcessor.processException(th4);
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

    public void a(Context context, a aVar) {
        try {
            this.f36763e = aVar;
            try {
                a(context);
            } catch (Throwable th) {
                com.mobile.auth.a.a.a(f36759a, "switchToMobileForAboveL", th);
                if (this.f36763e != null) {
                    this.f36763e.a(MobileNetRequestManager.CODE_SWITCH_EXCEPTION, MobileNetRequestManager.MSG_SWITCH_EXCEPTION, -1L);
                }
            }
        } catch (Throwable th2) {
            try {
                ExceptionProcessor.processException(th2);
            } catch (Throwable th3) {
                ExceptionProcessor.processException(th3);
            }
        }
    }

    public boolean a(Context context, String str) {
        try {
            return b(context, str);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }
}
