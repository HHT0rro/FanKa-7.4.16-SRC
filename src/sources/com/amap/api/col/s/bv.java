package com.amap.api.col.s;

import com.amap.api.maps.AMapException;
import java.util.List;
import java.util.Map;

/* compiled from: AMapCoreException.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bv extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private String f7306a;

    /* renamed from: b, reason: collision with root package name */
    private String f7307b;

    /* renamed from: c, reason: collision with root package name */
    private String f7308c;

    /* renamed from: d, reason: collision with root package name */
    private String f7309d;

    /* renamed from: e, reason: collision with root package name */
    private String f7310e;

    /* renamed from: f, reason: collision with root package name */
    private int f7311f;

    /* renamed from: g, reason: collision with root package name */
    private int f7312g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f7313h;

    /* renamed from: i, reason: collision with root package name */
    private String f7314i;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, List<String>> f7315j;

    public bv(String str) {
        super(str);
        this.f7306a = AMapException.ERROR_UNKNOWN;
        this.f7307b = "";
        this.f7308c = "";
        this.f7309d = "1900";
        this.f7310e = "UnknownError";
        this.f7311f = -1;
        this.f7312g = -1;
        this.f7313h = false;
        this.f7306a = str;
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f7311f = 21;
            this.f7309d = "1902";
            this.f7310e = "IOException";
        } else if (AMapException.ERROR_SOCKET.equals(str)) {
            this.f7311f = 22;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f7311f = 23;
            this.f7309d = "1802";
            this.f7310e = "SocketTimeoutException";
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f7311f = 24;
            this.f7309d = "1901";
            this.f7310e = "IllegalArgumentException";
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f7311f = 25;
            this.f7309d = "1903";
            this.f7310e = "NullPointException";
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f7311f = 26;
            this.f7309d = "1803";
            this.f7310e = "MalformedURLException";
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f7311f = 27;
            this.f7309d = "1804";
            this.f7310e = "UnknownHostException";
        } else if (AMapException.ERROR_UNKNOW_SERVICE.equals(str)) {
            this.f7311f = 28;
            this.f7309d = "1805";
            this.f7310e = "CannotConnectToHostException";
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f7311f = 29;
            this.f7309d = "1801";
            this.f7310e = "ProtocolException";
        } else if (AMapException.ERROR_CONNECTION.equals(str)) {
            this.f7311f = 30;
            this.f7309d = "1806";
            this.f7310e = "ConnectionException";
        } else if ("服务QPS超限".equalsIgnoreCase(str)) {
            this.f7311f = 30;
            this.f7309d = "2001";
            this.f7310e = "ConnectionException";
        } else if (AMapException.ERROR_UNKNOWN.equals(str)) {
            this.f7311f = 31;
        } else if (AMapException.ERROR_FAILURE_AUTH.equals(str)) {
            this.f7311f = 32;
        } else if ("requeust is null".equals(str)) {
            this.f7311f = 1;
        } else if ("request url is empty".equals(str)) {
            this.f7311f = 2;
        } else if ("response is null".equals(str)) {
            this.f7311f = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f7311f = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f7311f = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f7311f = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f7311f = 7;
        } else if ("线程池为空".equals(str)) {
            this.f7311f = 8;
        } else if ("获取对象错误".equals(str)) {
            this.f7311f = 101;
        } else if ("DNS解析失败".equals(str)) {
            this.f7311f = 3;
        } else {
            this.f7311f = -1;
        }
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f7312g = 7;
            return;
        }
        if (AMapException.ERROR_SOCKET.equals(str)) {
            this.f7312g = 6;
            return;
        }
        if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f7312g = 2;
            return;
        }
        if (!"未知主机 - UnKnowHostException".equals(str)) {
            if (AMapException.ERROR_CONNECTION.equals(str)) {
                this.f7312g = 6;
                return;
            } else if (!AMapException.ERROR_UNKNOWN.equals(str) && "DNS解析失败".equals(str)) {
                this.f7312g = 3;
                return;
            }
        }
        this.f7312g = 9;
    }

    public final String a() {
        return this.f7306a;
    }

    public final String b() {
        return this.f7309d;
    }

    public final String c() {
        return this.f7310e;
    }

    public final String d() {
        return this.f7307b;
    }

    public final String e() {
        return this.f7308c;
    }

    public final int f() {
        return this.f7311f;
    }

    public final int g() {
        return this.f7312g;
    }

    public final int h() {
        this.f7312g = 10;
        return 10;
    }

    public final boolean i() {
        return this.f7313h;
    }

    public final void j() {
        this.f7313h = true;
    }

    public final void a(String str) {
        this.f7314i = str;
    }

    public final void a(Map<String, List<String>> map) {
        this.f7315j = map;
    }

    public bv(String str, String str2, String str3) {
        this(str);
        this.f7307b = str2;
        this.f7308c = str3;
    }
}
