package com.huawei.hianalytics.framework.session;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class SessionHandler {

    /* renamed from: b, reason: collision with root package name */
    public static SessionHandler f28827b;

    /* renamed from: a, reason: collision with root package name */
    public volatile Map<String, a> f28828a = new HashMap();

    public static SessionHandler getInstance() {
        if (f28827b == null) {
            syncInit();
        }
        return f28827b;
    }

    private a getSessionWrapByTag(String str) {
        synchronized (this) {
            if (!this.f28828a.containsKey(str)) {
                this.f28828a.put(str, new a());
            }
        }
        return this.f28828a.get(str);
    }

    public static synchronized void syncInit() {
        synchronized (SessionHandler.class) {
            if (f28827b == null) {
                f28827b = new SessionHandler();
            }
        }
    }

    public void initSessionParameter(String str) {
        a sessionWrapByTag = getSessionWrapByTag(str);
        if (sessionWrapByTag != null) {
            sessionWrapByTag.a();
        }
    }

    public void onBackground(String str, long j10) {
        a sessionWrapByTag = getSessionWrapByTag(str);
        if (sessionWrapByTag != null) {
            sessionWrapByTag.c(j10);
        }
    }

    public void onForeground(String str, long j10) {
        a sessionWrapByTag = getSessionWrapByTag(str);
        if (sessionWrapByTag != null) {
            sessionWrapByTag.a(j10);
        }
    }

    public a refreshSession(String str, long j10) {
        a sessionWrapByTag = getSessionWrapByTag(str);
        if (sessionWrapByTag != null) {
            sessionWrapByTag.a(str, j10);
            return sessionWrapByTag;
        }
        return new a();
    }

    public void setMinSessionDuration(String str, long j10) {
        a sessionWrapByTag = getSessionWrapByTag(str);
        if (sessionWrapByTag != null) {
            sessionWrapByTag.b(j10);
        }
    }

    public void setSessionTimeoutDuration(String str, long j10) {
        a sessionWrapByTag = getSessionWrapByTag(str);
        if (sessionWrapByTag != null) {
            sessionWrapByTag.d(j10);
        }
    }
}
