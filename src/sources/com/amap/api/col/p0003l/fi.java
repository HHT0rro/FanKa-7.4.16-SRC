package com.amap.api.col.p0003l;

import com.amap.api.maps.AMapException;
import java.util.List;
import java.util.Map;

/* compiled from: AMapCoreException.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fi extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private String f5753a;

    /* renamed from: b, reason: collision with root package name */
    private String f5754b;

    /* renamed from: c, reason: collision with root package name */
    private String f5755c;

    /* renamed from: d, reason: collision with root package name */
    private String f5756d;

    /* renamed from: e, reason: collision with root package name */
    private String f5757e;

    /* renamed from: f, reason: collision with root package name */
    private int f5758f;

    /* renamed from: g, reason: collision with root package name */
    private int f5759g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f5760h;

    /* renamed from: i, reason: collision with root package name */
    private String f5761i;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, List<String>> f5762j;

    public fi(String str) {
        super(str);
        this.f5753a = AMapException.ERROR_UNKNOWN;
        this.f5754b = "";
        this.f5755c = "";
        this.f5756d = "1900";
        this.f5757e = "UnknownError";
        this.f5758f = -1;
        this.f5759g = -1;
        this.f5760h = false;
        this.f5753a = str;
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f5758f = 21;
            this.f5756d = "1902";
            this.f5757e = "IOException";
        } else if (AMapException.ERROR_SOCKET.equals(str)) {
            this.f5758f = 22;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f5758f = 23;
            this.f5756d = "1802";
            this.f5757e = "SocketTimeoutException";
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f5758f = 24;
            this.f5756d = "1901";
            this.f5757e = "IllegalArgumentException";
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f5758f = 25;
            this.f5756d = "1903";
            this.f5757e = "NullPointException";
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f5758f = 26;
            this.f5756d = "1803";
            this.f5757e = "MalformedURLException";
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f5758f = 27;
            this.f5756d = "1804";
            this.f5757e = "UnknownHostException";
        } else if (AMapException.ERROR_UNKNOW_SERVICE.equals(str)) {
            this.f5758f = 28;
            this.f5756d = "1805";
            this.f5757e = "CannotConnectToHostException";
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f5758f = 29;
            this.f5756d = "1801";
            this.f5757e = "ProtocolException";
        } else if (AMapException.ERROR_CONNECTION.equals(str)) {
            this.f5758f = 30;
            this.f5756d = "1806";
            this.f5757e = "ConnectionException";
        } else if ("服务QPS超限".equalsIgnoreCase(str)) {
            this.f5758f = 30;
            this.f5756d = "2001";
            this.f5757e = "ConnectionException";
        } else if (AMapException.ERROR_UNKNOWN.equals(str)) {
            this.f5758f = 31;
        } else if (AMapException.ERROR_FAILURE_AUTH.equals(str)) {
            this.f5758f = 32;
        } else if ("requeust is null".equals(str)) {
            this.f5758f = 1;
        } else if ("request url is empty".equals(str)) {
            this.f5758f = 2;
        } else if ("response is null".equals(str)) {
            this.f5758f = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f5758f = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f5758f = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f5758f = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f5758f = 7;
        } else if ("线程池为空".equals(str)) {
            this.f5758f = 8;
        } else if ("获取对象错误".equals(str)) {
            this.f5758f = 101;
        } else if ("DNS解析失败".equals(str)) {
            this.f5758f = 3;
        } else {
            this.f5758f = -1;
        }
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f5759g = 7;
            return;
        }
        if (AMapException.ERROR_SOCKET.equals(str)) {
            this.f5759g = 6;
            return;
        }
        if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f5759g = 2;
            return;
        }
        if (!"未知主机 - UnKnowHostException".equals(str)) {
            if (AMapException.ERROR_CONNECTION.equals(str)) {
                this.f5759g = 6;
                return;
            } else if (!AMapException.ERROR_UNKNOWN.equals(str) && "DNS解析失败".equals(str)) {
                this.f5759g = 3;
                return;
            }
        }
        this.f5759g = 9;
    }

    public final String a() {
        return this.f5753a;
    }

    public final String b() {
        return this.f5756d;
    }

    public final String c() {
        return this.f5757e;
    }

    public final String d() {
        return this.f5754b;
    }

    public final String e() {
        return this.f5755c;
    }

    public final int f() {
        return this.f5758f;
    }

    public final int g() {
        return this.f5759g;
    }

    public final int h() {
        this.f5759g = 10;
        return 10;
    }

    public final boolean i() {
        return this.f5760h;
    }

    public final void j() {
        this.f5760h = true;
    }

    public final void a(int i10) {
        this.f5758f = i10;
    }

    public final void a(String str) {
        this.f5761i = str;
    }

    public final void a(Map<String, List<String>> map) {
        this.f5762j = map;
    }

    public fi(String str, String str2, String str3) {
        this(str);
        this.f5754b = str2;
        this.f5755c = str3;
    }
}
