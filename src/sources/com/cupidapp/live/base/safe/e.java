package com.cupidapp.live.base.safe;

import android.os.SystemClock;
import com.cupidapp.live.base.utils.j;
import com.ishumei.smantifraud.SmAntiFraud;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SmAntiFraudHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f12185a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static long f12186b;

    @NotNull
    public final String a() {
        String deviceId = (f12186b <= 0 || SystemClock.uptimeMillis() - f12186b <= 2000) ? "" : SmAntiFraud.getDeviceId();
        j.f12332a.a("SmAntiFraudHelper", "deviceId:" + deviceId);
        s.h(deviceId, "deviceId");
        return deviceId;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if ((r5.length() > 0) == true) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(@org.jetbrains.annotations.NotNull android.content.Context r4, @org.jetbrains.annotations.Nullable java.lang.String r5, @org.jetbrains.annotations.Nullable java.lang.String r6) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.s.i(r4, r0)
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L15
            int r2 = r5.length()
            if (r2 <= 0) goto L11
            r2 = 1
            goto L12
        L11:
            r2 = 0
        L12:
            if (r2 != r0) goto L15
            goto L16
        L15:
            r0 = 0
        L16:
            if (r0 == 0) goto L90
            boolean r5 = kotlin.jvm.internal.s.d(r5, r6)
            if (r5 == 0) goto L90
            com.ishumei.smantifraud.SmAntiFraud$SmOption r5 = new com.ishumei.smantifraud.SmAntiFraud$SmOption
            r5.<init>()
            java.lang.String r6 = "qRLrIEyYwqE1vOhOACQy"
            r5.setOrganization(r6)
            java.lang.String r6 = "finka"
            r5.setAppId(r6)
            java.lang.String r6 = "MIIDOzCCAiOgAwIBAgIBMDANBgkqhkiG9w0BAQUFADA4MQswCQYDVQQGEwJDTjENMAsGA1UECwwEQ05DQjEaMBgGA1UEAwwRZS5iYW5rLmVjaXRpYy5jb20wHhcNMTgwMjExMDg0NTIyWhcNMzgwMjA2MDg0NTIyWjA4MQswCQYDVQQGEwJDTjENMAsGA1UECwwEQ05DQjEaMBgGA1UEAwwRZS5iYW5rLmVjaXRpYy5jb20wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCkF+2AicVKj7SaHw3dbJt3i6fkL1WfLw1WRqe8r8Cc7qJOshaqNvCzW1qRX6E5H/umtl1Uj99V07uewUFk96xY/+s/GuBnbGoSrcu3OAHDgEGuY5atZo+umIk7LufAif2VUcNGY3nWxGcig20ExO/6nAf/G3Xxo4QL8fBdPG/prOXxSvtJiPls1Qg9zzSgAH+HMCAINMsuJmzDQiTt6Me8k7YHts+jWQF7KF25plITcW1Qmy3Aw8qYjVhbHn8KTAEeuQhmM5RS6KP1Hu71q4DYOWcx44QThSbiAYwG1JQBBwM8XnBfVYMpr6Qi0owibNYoZ/S6xwfRFGB0W1HeG9WfAgMBAAGjUDBOMB0GA1UdDgQWBBT0iLEXY9HIKNy5DG4d72l+R7Nf1zAfBgNVHSMEGDAWgBT0iLEXY9HIKNy5DG4d72l+R7Nf1zAMBgNVHRMEBTADAQH/MA0GCSqGSIb3DQEBBQUAA4IBAQB5MWz1RGFG537rJCtHp+LqxR9iJSFsHiW3ZoLIAeyD0oJ69RcL2gE/TNWmE9zYUkd9TdNtXqxlNPpj1P1/+x781neWnGou/n/XFS82T5S339X3DIjHc/IqOzwnxEOKH2V0NmK9iKgx6H05Q9MMvUXFsL3QK2hDMAVY28roRiC4S1yfJJaA08DfvXZf6cVx1xfWl+ks57+3knkoWap1rjwh1RdGk5ChPbzD0AnAcWTMWRCbjuJnttlmWZnI1I6mhcQUKUEMoj8sR8m11YJ5woscYPsIle/rJOOosuMghczD1vRcg3eLUaWn1A5rsBa82RyxhiuYocEQVX59Hy6v3npT"
            r5.setPublicKey(r6)
            java.lang.String r6 = "bj"
            r5.setArea(r6)
            java.lang.String r6 = "http://fp-it-acc.fengkongcloud.com"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            java.lang.String r1 = "/deviceprofile/v4"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.setUrl(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            java.lang.String r6 = "/v3/cloudconf"
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r5.setConfUrl(r6)
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>()
            java.lang.String r0 = "bssid"
            r6.add(r0)
            r5.setNotCollect(r6)
            boolean r4 = com.ishumei.smantifraud.SmAntiFraud.create(r4, r5)
            long r5 = android.os.SystemClock.uptimeMillis()
            com.cupidapp.live.base.safe.e.f12186b = r5
            com.cupidapp.live.base.utils.j$a r5 = com.cupidapp.live.base.utils.j.f12332a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "createResult:"
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            java.lang.String r6 = "SmAntiFraudHelper"
            r5.a(r6, r4)
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.safe.e.b(android.content.Context, java.lang.String, java.lang.String):void");
    }
}
