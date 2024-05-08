package com.huawei.hianalytics.framework.session;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.b;
import java.util.Calendar;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public long f28829a = 1800000;

    /* renamed from: b, reason: collision with root package name */
    public long f28830b = 30000;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f28831c = false;

    /* renamed from: d, reason: collision with root package name */
    public volatile long f28832d = 0;

    /* renamed from: e, reason: collision with root package name */
    public C0276a f28833e = null;

    public String b() {
        C0276a c0276a = this.f28833e;
        if (c0276a == null) {
            HiLog.w("SessionWrapper", "getSessionName(): session not prepared. onEvent() must be called first.");
            return "";
        }
        return c0276a.f28834a;
    }

    public boolean c() {
        C0276a c0276a = this.f28833e;
        if (c0276a == null) {
            HiLog.sw("SessionWrapper", "isFirstEvent(): session not prepared. onEvent() must be called first.");
            return false;
        }
        return c0276a.f28835b;
    }

    public void d(long j10) {
        this.f28829a = j10;
    }

    public void a(String str, long j10) {
        C0276a c0276a = this.f28833e;
        if (c0276a == null) {
            HiLog.i("SessionWrapper", "Session is first flush");
            this.f28833e = new C0276a(j10);
        } else {
            c0276a.a(str, j10);
        }
    }

    public void b(long j10) {
        this.f28830b = j10;
    }

    public void c(long j10) {
        this.f28831c = true;
        this.f28832d = j10;
    }

    public void a(long j10) {
        if (this.f28832d == 0) {
            HiLog.w("SessionWrapper", "OnBackground() need to be called before!");
        } else {
            this.f28831c = j10 - this.f28832d > this.f28830b;
            this.f28832d = 0L;
        }
    }

    /* renamed from: com.huawei.hianalytics.framework.session.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class C0276a {

        /* renamed from: a, reason: collision with root package name */
        public String f28834a = UUID.randomUUID().toString().replace("-", "");

        /* renamed from: b, reason: collision with root package name */
        public boolean f28835b;

        /* renamed from: c, reason: collision with root package name */
        public long f28836c;

        public C0276a(long j10) {
            this.f28834a += "_" + j10;
            this.f28836c = j10;
            this.f28835b = true;
            a.this.f28831c = false;
        }

        private boolean b(long j10, long j11) {
            return j11 - j10 >= a.this.f28829a;
        }

        public void a(String str, long j10) {
            com.huawei.hianalytics.framework.data.a a10 = b.a(str);
            if (a10 == null || !a10.b()) {
                if (a.this.f28831c && j10 - a.this.f28832d > a.this.f28830b) {
                    a.this.f28831c = false;
                    a.this.f28832d = 0L;
                    a(j10);
                    return;
                } else if (!b(this.f28836c, j10) && !a(this.f28836c, j10)) {
                    this.f28836c = j10;
                    this.f28835b = false;
                    return;
                } else {
                    a(j10);
                    return;
                }
            }
            a10.a(false);
            a(j10);
        }

        private void a(long j10) {
            HiLog.i("SessionWrapper", "getNewSession() session is flush!");
            String uuid = UUID.randomUUID().toString();
            this.f28834a = uuid;
            this.f28834a = uuid.replace("-", "");
            this.f28834a += "_" + j10;
            this.f28836c = j10;
            this.f28835b = true;
        }

        private boolean a(long j10, long j11) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j10);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j11);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
        }
    }

    public void a() {
        this.f28833e = null;
        this.f28832d = 0L;
        this.f28831c = false;
    }
}
