package com.mobile.auth.c;

import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private String f36690b;

    /* renamed from: d, reason: collision with root package name */
    private String f36692d;

    /* renamed from: f, reason: collision with root package name */
    private String f36694f;

    /* renamed from: g, reason: collision with root package name */
    private String f36695g;

    /* renamed from: h, reason: collision with root package name */
    private String f36696h;

    /* renamed from: i, reason: collision with root package name */
    private String f36697i;

    /* renamed from: j, reason: collision with root package name */
    private String f36698j;

    /* renamed from: k, reason: collision with root package name */
    private String f36699k;

    /* renamed from: l, reason: collision with root package name */
    private String f36700l;

    /* renamed from: o, reason: collision with root package name */
    private int f36703o;

    /* renamed from: q, reason: collision with root package name */
    private long f36705q;

    /* renamed from: r, reason: collision with root package name */
    private long f36706r;

    /* renamed from: s, reason: collision with root package name */
    private String f36707s;

    /* renamed from: u, reason: collision with root package name */
    private long f36709u;

    /* renamed from: v, reason: collision with root package name */
    private long f36710v;

    /* renamed from: w, reason: collision with root package name */
    private String f36711w;

    /* renamed from: t, reason: collision with root package name */
    private StringBuffer f36708t = new StringBuffer();

    /* renamed from: c, reason: collision with root package name */
    private String f36691c = "";

    /* renamed from: e, reason: collision with root package name */
    private String f36693e = "";

    /* renamed from: n, reason: collision with root package name */
    private String f36702n = "";

    /* renamed from: m, reason: collision with root package name */
    private String f36701m = "";

    /* renamed from: p, reason: collision with root package name */
    private String f36704p = "";

    /* renamed from: a, reason: collision with root package name */
    private String f36689a = "1.1";

    public b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f36709u = currentTimeMillis;
        this.f36690b = a(currentTimeMillis);
        this.f36692d = "";
        this.f36694f = "";
        this.f36695g = Build.BRAND;
        this.f36696h = Build.MODEL;
        this.f36697i = "Android";
        this.f36698j = Build.VERSION.RELEASE;
        this.f36699k = "SDK-JJ-v3.7.4";
        this.f36700l = str;
        this.f36707s = "0";
        this.f36711w = "";
    }

    public static String a(long j10) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA).format(new Date(j10));
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return "";
            } catch (Throwable th2) {
                try {
                    ExceptionProcessor.processException(th2);
                    return null;
                } catch (Throwable th3) {
                    ExceptionProcessor.processException(th3);
                    return null;
                }
            }
        }
    }

    public b a(int i10) {
        try {
            this.f36703o = i10;
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

    public b a(String str) {
        try {
            this.f36692d = str;
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

    public b b(long j10) {
        try {
            this.f36705q = j10;
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

    public b b(String str) {
        try {
            this.f36693e = str;
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

    public b c(String str) {
        try {
            this.f36694f = str;
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

    public b d(String str) {
        try {
            this.f36701m = str;
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

    public b e(String str) {
        try {
            this.f36702n = str;
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

    public b f(String str) {
        try {
            this.f36704p = str;
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

    public b g(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f36707s = str;
            }
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

    public b h(String str) {
        try {
            StringBuffer stringBuffer = this.f36708t;
            stringBuffer.append(str);
            stringBuffer.append("\n");
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

    public b i(String str) {
        try {
            this.f36711w = str;
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

    public String toString() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f36710v = currentTimeMillis;
            this.f36706r = currentTimeMillis - this.f36709u;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(t.f36218c, this.f36689a);
            jSONObject.put("t", this.f36690b);
            jSONObject.put("tag", this.f36691c);
            jSONObject.put("ai", this.f36692d);
            jSONObject.put("di", this.f36693e);
            jSONObject.put("ns", this.f36694f);
            jSONObject.put("br", this.f36695g);
            jSONObject.put("ml", this.f36696h);
            jSONObject.put("os", this.f36697i);
            jSONObject.put("ov", this.f36698j);
            jSONObject.put(com.alipay.sdk.sys.a.f4667h, this.f36699k);
            jSONObject.put("ri", this.f36700l);
            jSONObject.put("api", this.f36701m);
            jSONObject.put(t.f36217b, this.f36702n);
            jSONObject.put("rt", this.f36703o);
            jSONObject.put("msg", this.f36704p);
            jSONObject.put(Segment.JsonKey.START, this.f36705q);
            jSONObject.put("tt", this.f36706r);
            jSONObject.put("ot", this.f36707s);
            jSONObject.put("ep", this.f36708t.toString());
            jSONObject.put("aip", this.f36711w);
            return jSONObject.toString();
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return "";
            } catch (Throwable th2) {
                try {
                    ExceptionProcessor.processException(th2);
                    return null;
                } catch (Throwable th3) {
                    ExceptionProcessor.processException(th3);
                    return null;
                }
            }
        }
    }
}
