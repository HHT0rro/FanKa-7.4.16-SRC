package com.huawei.hms.hatool;

import java.util.Calendar;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class p0 {

    /* renamed from: a, reason: collision with root package name */
    private long f30191a = 1800000;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f30192b = false;

    /* renamed from: c, reason: collision with root package name */
    private a f30193c = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String f30194a = UUID.randomUUID().toString().replace("-", "");

        /* renamed from: b, reason: collision with root package name */
        public boolean f30195b;

        /* renamed from: c, reason: collision with root package name */
        private long f30196c;

        public a(long j10) {
            this.f30194a += "_" + j10;
            this.f30196c = j10;
            this.f30195b = true;
            p0.this.f30192b = false;
        }

        private boolean a(long j10, long j11) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j10);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j11);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
        }

        private void b(long j10) {
            v.c("hmsSdk", "getNewSession() session is flush!");
            String uuid = UUID.randomUUID().toString();
            this.f30194a = uuid;
            this.f30194a = uuid.replace("-", "");
            this.f30194a += "_" + j10;
            this.f30196c = j10;
            this.f30195b = true;
        }

        private boolean b(long j10, long j11) {
            return j11 - j10 >= p0.this.f30191a;
        }

        public void a(long j10) {
            if (p0.this.f30192b) {
                p0.this.f30192b = false;
                b(j10);
            } else if (b(this.f30196c, j10) || a(this.f30196c, j10)) {
                b(j10);
            } else {
                this.f30196c = j10;
                this.f30195b = false;
            }
        }
    }

    public String a() {
        a aVar = this.f30193c;
        if (aVar != null) {
            return aVar.f30194a;
        }
        v.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    public void a(long j10) {
        a aVar = this.f30193c;
        if (aVar != null) {
            aVar.a(j10);
        } else {
            v.c("hmsSdk", "Session is first flush");
            this.f30193c = new a(j10);
        }
    }

    public boolean b() {
        a aVar = this.f30193c;
        if (aVar != null) {
            return aVar.f30195b;
        }
        v.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}
