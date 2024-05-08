package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.am;
import com.amap.api.col.s.dz;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.util.Map;

/* compiled from: BasicHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class e<T, V> extends cd {

    /* renamed from: b, reason: collision with root package name */
    public T f7860b;

    /* renamed from: e, reason: collision with root package name */
    public Context f7863e;

    /* renamed from: a, reason: collision with root package name */
    public boolean f7859a = true;

    /* renamed from: c, reason: collision with root package name */
    public int f7861c = 1;

    /* renamed from: d, reason: collision with root package name */
    public String f7862d = "";

    /* renamed from: g, reason: collision with root package name */
    private int f7865g = 1;

    /* renamed from: f, reason: collision with root package name */
    public String f7864f = "";

    public e(Context context, T t2) {
        a(context, t2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V A() throws AMapException {
        V v2;
        am amVar;
        am.c a10;
        Object obj;
        try {
            am.b e2 = e();
            boolean b4 = am.a().b(e2);
            boolean z10 = false;
            int i10 = 0;
            V v10 = null;
            boolean z11 = false;
            while (i10 < this.f7861c) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    try {
                        try {
                            int protocol = ServiceSettings.getInstance().getProtocol();
                            cc.a().a(this.f7863e);
                            dy b10 = dy.b();
                            if (b4 && (a10 = am.a().a(e2)) != null && (obj = a10.f7100a) != 0) {
                                try {
                                    aw.a(this.f7863e, e2.f7098a, a10.f7101b);
                                    v10 = obj;
                                    z11 = true;
                                } catch (bv e10) {
                                    e = e10;
                                    v10 = obj;
                                    z11 = true;
                                    aw.a(this.f7863e, z(), System.currentTimeMillis() - currentTimeMillis, z10);
                                    i10++;
                                    if (i10 < this.f7861c) {
                                        try {
                                            Thread.sleep(this.f7865g * 1000);
                                            if (b4 && !z11) {
                                                am.a().a(e2, v10);
                                            }
                                            z10 = false;
                                        } catch (InterruptedException unused) {
                                            if (!com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_SOCKET.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(e.getMessage())) {
                                                throw new AMapException(e.a(), 1, e.c());
                                            }
                                            throw new AMapException(AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, e.c());
                                        }
                                    } else {
                                        if (!com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_SOCKET.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_UNKNOWN.equals(e.a()) && !com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(e.getMessage())) {
                                            throw new AMapException(e.a(), 1, e.c());
                                        }
                                        throw new AMapException(AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, e.c());
                                    }
                                } catch (AMapException e11) {
                                    e = e11;
                                    v10 = obj;
                                    z11 = true;
                                    aw.a(this.f7863e, z(), System.currentTimeMillis() - currentTimeMillis, z10);
                                    i10++;
                                    if (i10 >= this.f7861c) {
                                        throw e;
                                    }
                                    if (b4 && !z11) {
                                        amVar = am.a();
                                        amVar.a(e2, v10);
                                    }
                                    z10 = false;
                                } catch (Throwable th) {
                                    th = th;
                                    v2 = obj;
                                    z11 = true;
                                    if (b4) {
                                        am.a().a(e2, v2);
                                    }
                                    throw th;
                                }
                            }
                            if (v10 == null) {
                                byte[] a11 = a(protocol, b10, this);
                                long currentTimeMillis2 = System.currentTimeMillis();
                                v10 = b(a11);
                                aw.a(this.f7863e, z(), currentTimeMillis2 - currentTimeMillis, true);
                            }
                            i10 = this.f7861c;
                        } catch (bv e12) {
                            e = e12;
                        } catch (AMapException e13) {
                            e = e13;
                        }
                        if (b4 && !z11) {
                            amVar = am.a();
                            amVar.a(e2, v10);
                        }
                        z10 = false;
                    } catch (Throwable th2) {
                        th = th2;
                        v2 = v10;
                        if (b4 && !z11) {
                            am.a().a(e2, v2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    v2 = null;
                }
            }
            return v10;
        } catch (AMapException e14) {
            throw e14;
        } catch (Throwable th4) {
            th4.printStackTrace();
            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    private void a(Context context, T t2) {
        this.f7863e = context;
        this.f7860b = t2;
        this.f7861c = 1;
        b(ServiceSettings.getInstance().getSoTimeOut());
        a(ServiceSettings.getInstance().getConnectionTimeOut());
    }

    private V b(byte[] bArr) throws AMapException {
        return a(bArr);
    }

    private String j() {
        return this.f7864f;
    }

    private String z() {
        String a10 = a();
        if (a10 == null) {
            return null;
        }
        try {
            int indexOf = a10.indexOf(".com/");
            int indexOf2 = a10.indexOf(SymbolValues.QUESTION_EN_SYMBOL);
            if (indexOf2 == -1) {
                return a10.substring(indexOf + 5);
            }
            return a10.substring(indexOf + 5, indexOf2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public abstract V a(String str) throws AMapException;

    public abstract String a_();

    public final V c() throws AMapException {
        if (this.f7860b == null) {
            return null;
        }
        try {
            return A();
        } catch (AMapException e2) {
            aw.a(z(), j(), e2);
            throw e2;
        }
    }

    @Override // com.amap.api.col.s.dz
    public final String d() {
        return "sea";
    }

    public am.b e() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public Map<String, String> f() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public Map<String, String> g() {
        return null;
    }

    public V a(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e2) {
            n.a(e2, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        n.b(str);
        return a(str);
    }

    private byte[] a(int i10, dy dyVar, cd cdVar) throws bv {
        ea e2;
        a(i10 == 1 ? dz.c.HTTP : dz.c.HTTPS);
        if (this.f7859a) {
            e2 = dt.a(cdVar);
        } else {
            e2 = dy.e(cdVar);
        }
        if (e2 == null) {
            return null;
        }
        byte[] bArr = e2.f7866a;
        this.f7864f = e2.f7869d;
        return bArr;
    }
}
