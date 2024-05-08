package com.xiaomi.push;

import java.net.UnknownHostException;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d6 {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public fl f47181a;

        /* renamed from: b, reason: collision with root package name */
        public String f47182b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Throwable] */
    public static a a(Exception exc) {
        b(exc);
        boolean z10 = exc instanceof gh;
        Exception exc2 = exc;
        if (z10) {
            gh ghVar = (gh) exc;
            exc2 = exc;
            if (ghVar.a() != null) {
                exc2 = ghVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + com.huawei.openalliance.ad.constant.u.bD + message;
        int a10 = w4.a(exc2);
        if (a10 != 0) {
            aVar.f47181a = fl.a(fl.GSLB_REQUEST_SUCCESS.a() + a10);
        }
        if (aVar.f47181a == null) {
            aVar.f47181a = fl.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.f47181a == fl.GSLB_TCP_ERR_OTHER) {
            aVar.f47182b = str;
        }
        return aVar;
    }

    public static void b(Exception exc) {
        Objects.requireNonNull(exc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.Throwable] */
    public static a c(Exception exc) {
        fl flVar;
        fl flVar2;
        Throwable cause;
        b(exc);
        boolean z10 = exc instanceof gh;
        Exception exc2 = exc;
        if (z10) {
            gh ghVar = (gh) exc;
            exc2 = exc;
            if (ghVar.a() != null) {
                exc2 = ghVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a10 = w4.a(exc2);
        String str = exc2.getClass().getSimpleName() + com.huawei.openalliance.ad.constant.u.bD + message;
        if (a10 != 0) {
            fl a11 = fl.a(fl.CONN_SUCCESS.a() + a10);
            aVar.f47181a = a11;
            if (a11 == fl.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                flVar = fl.CONN_BOSH_UNKNOWNHOST;
            }
            flVar2 = aVar.f47181a;
            if (flVar2 != fl.CONN_TCP_ERR_OTHER || flVar2 == fl.CONN_XMPP_ERR || flVar2 == fl.CONN_BOSH_ERR) {
                aVar.f47182b = str;
            }
            return aVar;
        }
        flVar = fl.CONN_XMPP_ERR;
        aVar.f47181a = flVar;
        flVar2 = aVar.f47181a;
        if (flVar2 != fl.CONN_TCP_ERR_OTHER) {
        }
        aVar.f47182b = str;
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Throwable] */
    public static a d(Exception exc) {
        fl flVar;
        fl flVar2;
        b(exc);
        boolean z10 = exc instanceof gh;
        Exception exc2 = exc;
        if (z10) {
            gh ghVar = (gh) exc;
            exc2 = exc;
            if (ghVar.a() != null) {
                exc2 = ghVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a10 = w4.a(exc2);
        String str = exc2.getClass().getSimpleName() + com.huawei.openalliance.ad.constant.u.bD + message;
        if (a10 == 105) {
            flVar = fl.BIND_TCP_READ_TIMEOUT;
        } else if (a10 == 199) {
            flVar = fl.BIND_TCP_ERR;
        } else {
            if (a10 == 499) {
                aVar.f47181a = fl.BIND_BOSH_ERR;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    flVar = fl.BIND_BOSH_ITEM_NOT_FOUND;
                }
                flVar2 = aVar.f47181a;
                if (flVar2 != fl.BIND_TCP_ERR || flVar2 == fl.BIND_XMPP_ERR || flVar2 == fl.BIND_BOSH_ERR) {
                    aVar.f47182b = str;
                }
                return aVar;
            }
            flVar = a10 != 109 ? a10 != 110 ? fl.BIND_XMPP_ERR : fl.BIND_TCP_BROKEN_PIPE : fl.BIND_TCP_CONNRESET;
        }
        aVar.f47181a = flVar;
        flVar2 = aVar.f47181a;
        if (flVar2 != fl.BIND_TCP_ERR) {
        }
        aVar.f47182b = str;
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Throwable] */
    public static a e(Exception exc) {
        fl flVar;
        fl flVar2;
        b(exc);
        boolean z10 = exc instanceof gh;
        Exception exc2 = exc;
        if (z10) {
            gh ghVar = (gh) exc;
            exc2 = exc;
            if (ghVar.a() != null) {
                exc2 = ghVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        int a10 = w4.a(exc2);
        String str = exc2.getClass().getSimpleName() + com.huawei.openalliance.ad.constant.u.bD + message;
        if (a10 == 105) {
            flVar = fl.CHANNEL_TCP_READTIMEOUT;
        } else if (a10 == 199) {
            flVar = fl.CHANNEL_TCP_ERR;
        } else {
            if (a10 == 499) {
                aVar.f47181a = fl.CHANNEL_BOSH_EXCEPTION;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    flVar = fl.CHANNEL_BOSH_ITEMNOTFIND;
                }
                flVar2 = aVar.f47181a;
                if (flVar2 != fl.CHANNEL_TCP_ERR || flVar2 == fl.CHANNEL_XMPPEXCEPTION || flVar2 == fl.CHANNEL_BOSH_EXCEPTION) {
                    aVar.f47182b = str;
                }
                return aVar;
            }
            flVar = a10 != 109 ? a10 != 110 ? fl.CHANNEL_XMPPEXCEPTION : fl.CHANNEL_TCP_BROKEN_PIPE : fl.CHANNEL_TCP_CONNRESET;
        }
        aVar.f47181a = flVar;
        flVar2 = aVar.f47181a;
        if (flVar2 != fl.CHANNEL_TCP_ERR) {
        }
        aVar.f47182b = str;
        return aVar;
    }
}
