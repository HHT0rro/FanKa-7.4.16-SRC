package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.AMapException;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* compiled from: AbstractBasicHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class fb<T, V> extends db {

    /* renamed from: a, reason: collision with root package name */
    public T f5699a;

    /* renamed from: c, reason: collision with root package name */
    public Context f5701c;

    /* renamed from: d, reason: collision with root package name */
    public String f5702d;

    /* renamed from: b, reason: collision with root package name */
    public int f5700b = 1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5703e = false;

    public fb(Context context, T t2) {
        a(context, t2);
    }

    private void a(Context context, T t2) {
        this.f5701c = context;
        this.f5699a = t2;
        this.f5700b = 1;
        setSoTimeout(30000);
        setConnectionTimeout(30000);
    }

    private V b(byte[] bArr) throws fa {
        return a(bArr);
    }

    private V e() throws fa {
        V v2 = null;
        int i10 = 0;
        while (i10 < this.f5700b) {
            try {
                setProxy(ft.a(this.f5701c));
                if (this.f5703e) {
                    v2 = b(makeHttpRequestNeedHeader());
                } else {
                    v2 = b(makeHttpRequest());
                }
                i10 = this.f5700b;
            } catch (fa e2) {
                i10++;
                if (i10 >= this.f5700b) {
                    throw new fa(e2.a());
                }
            } catch (fi e10) {
                i10++;
                if (i10 < this.f5700b) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException unused) {
                        if (!AMapException.ERROR_CONNECTION.equals(e10.getMessage()) && !AMapException.ERROR_SOCKET.equals(e10.getMessage()) && !AMapException.ERROR_UNKNOW_SERVICE.equals(e10.getMessage())) {
                            throw new fa(e10.a());
                        }
                        throw new fa(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
                    }
                } else {
                    if (!AMapException.ERROR_CONNECTION.equals(e10.getMessage()) && !AMapException.ERROR_SOCKET.equals(e10.getMessage()) && !AMapException.ERROR_UNKNOWN.equals(e10.a()) && !AMapException.ERROR_UNKNOW_SERVICE.equals(e10.getMessage())) {
                        throw new fa(e10.a());
                    }
                    throw new fa(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
                }
            }
        }
        return v2;
    }

    public V a(ie ieVar) throws fa {
        return null;
    }

    public abstract V a(String str) throws fa;

    public abstract String c();

    public final V d() throws fa {
        if (this.f5699a == null) {
            return null;
        }
        try {
            return e();
        } catch (fa e2) {
            dx.a(e2);
            throw e2;
        }
    }

    @Override // com.amap.api.col.p0003l.id
    public Map<String, String> getRequestHead() {
        fu a10 = dx.a();
        String b4 = a10 != null ? a10.b() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", w.f6964c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", b4, "3dmap"));
        hashtable.put("X-INFO", fl.b(this.f5701c));
        hashtable.put("key", fj.f(this.f5701c));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    private V b(ie ieVar) throws fa {
        return a(ieVar);
    }

    public V a(byte[] bArr) throws fa {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            str = null;
        }
        if (str == null || "".equals(str)) {
            return null;
        }
        fd.a(str);
        return a(str);
    }
}
