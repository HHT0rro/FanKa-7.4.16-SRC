package com.vivo.push.restructure.a;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.util.u;
import com.vivo.push.util.v;
import org.json.JSONException;

/* compiled from: ReceivedMessageImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private Intent f46316a;

    /* renamed from: c, reason: collision with root package name */
    private com.vivo.push.restructure.request.a.a f46318c;

    /* renamed from: e, reason: collision with root package name */
    private InsideNotificationItem f46320e;

    /* renamed from: f, reason: collision with root package name */
    private UnvarnishedMessage f46321f;

    /* renamed from: b, reason: collision with root package name */
    private String f46317b = "";

    /* renamed from: d, reason: collision with root package name */
    private String f46319d = "";

    public b(Intent intent) {
        this.f46316a = intent;
    }

    private boolean m() {
        return j() == 4;
    }

    private boolean n() {
        return j() == 3;
    }

    private InsideNotificationItem o() {
        InsideNotificationItem insideNotificationItem = this.f46320e;
        if (insideNotificationItem != null) {
            return insideNotificationItem;
        }
        InsideNotificationItem insideNotificationItem2 = null;
        Intent intent = this.f46316a;
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("notification_v1");
                if (stringExtra != null && (insideNotificationItem2 = v.a(stringExtra)) != null) {
                    insideNotificationItem2.setMsgId(Long.parseLong(a()));
                }
            } catch (Exception e2) {
                u.a("ReceivedMessageImpl", "getNotificationMessage " + e2.getMessage());
            }
        }
        this.f46320e = insideNotificationItem2;
        return insideNotificationItem2;
    }

    private UnvarnishedMessage p() {
        UnvarnishedMessage unvarnishedMessage;
        Exception e2;
        String stringExtra;
        UnvarnishedMessage unvarnishedMessage2 = this.f46321f;
        if (unvarnishedMessage2 != null) {
            return unvarnishedMessage2;
        }
        UnvarnishedMessage unvarnishedMessage3 = null;
        Intent intent = this.f46316a;
        if (intent != null) {
            try {
                stringExtra = intent.getStringExtra("msg_v1");
            } catch (Exception e10) {
                unvarnishedMessage = null;
                e2 = e10;
            }
            if (!TextUtils.isEmpty(stringExtra)) {
                unvarnishedMessage = new UnvarnishedMessage(stringExtra);
                try {
                    unvarnishedMessage.setMsgId(Long.parseLong(a()));
                } catch (Exception e11) {
                    e2 = e11;
                    u.a("ReceivedMessageImpl", "getTransmissionMessage " + e2.getMessage());
                    unvarnishedMessage3 = unvarnishedMessage;
                    this.f46321f = unvarnishedMessage3;
                    return unvarnishedMessage3;
                }
                unvarnishedMessage3 = unvarnishedMessage;
            }
        }
        this.f46321f = unvarnishedMessage3;
        return unvarnishedMessage3;
    }

    @Override // com.vivo.push.restructure.a.a
    public final String a() {
        Bundle extras;
        Intent intent = this.f46316a;
        long j10 = (intent == null || (extras = intent.getExtras()) == null) ? 0L : extras.getLong("notify_id", 0L);
        return j10 != 0 ? String.valueOf(j10) : "";
    }

    @Override // com.vivo.push.restructure.a.a
    public final Intent b() {
        return this.f46316a;
    }

    @Override // com.vivo.push.restructure.a.a
    public final String c() {
        if (TextUtils.isEmpty(this.f46317b)) {
            this.f46317b = this.f46316a.getStringExtra(ExposeManager.UtArgsNames.reqId);
        }
        return this.f46317b;
    }

    @Override // com.vivo.push.restructure.a.a
    public final long d() {
        Intent intent = this.f46316a;
        if (intent != null) {
            return intent.getLongExtra("ipc_start_time", 0L);
        }
        return 0L;
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean e() {
        Intent intent = this.f46316a;
        if (intent != null) {
            return intent.getBooleanExtra("core_support_monitor", false);
        }
        return false;
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean f() {
        Bundle extras;
        Intent intent = this.f46316a;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return false;
        }
        return extras.getBoolean("client_collect_node", false);
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean g() {
        com.vivo.push.restructure.request.a.a h10 = h();
        return h10 != null && h10.a() == 2018;
    }

    @Override // com.vivo.push.restructure.a.a
    public final com.vivo.push.restructure.request.a.a h() {
        String stringExtra;
        com.vivo.push.restructure.request.a.a.a aVar;
        if (this.f46318c == null && (stringExtra = this.f46316a.getStringExtra("cf_content")) != null) {
            try {
                aVar = new com.vivo.push.restructure.request.a.a.a(stringExtra);
            } catch (JSONException unused) {
                aVar = null;
            }
            if (aVar != null) {
                this.f46318c = com.vivo.push.restructure.request.a.a.f46334a.a(aVar);
            }
        }
        return this.f46318c;
    }

    @Override // com.vivo.push.restructure.a.a
    public final String i() {
        if (TextUtils.isEmpty(this.f46319d)) {
            this.f46319d = this.f46316a.getStringExtra("content");
        }
        return this.f46319d;
    }

    @Override // com.vivo.push.restructure.a.a
    public final int j() {
        Intent intent = this.f46316a;
        if (intent == null) {
            return -1;
        }
        int intExtra = intent.getIntExtra("command", -1);
        return intExtra < 0 ? this.f46316a.getIntExtra("method", -1) : intExtra;
    }

    @Override // com.vivo.push.restructure.a.a
    public final int k() {
        if (this.f46316a == null) {
            return 0;
        }
        if (m() && o() != null) {
            return o().getTargetType();
        }
        if (!n() || p() == null) {
            return 0;
        }
        return p().getTargetType();
    }

    @Override // com.vivo.push.restructure.a.a
    public final String l() {
        if (this.f46316a == null) {
            return "";
        }
        if (!m() || o() == null) {
            return (!n() || p() == null) ? "" : p().getTragetContent();
        }
        return o().getTragetContent();
    }
}
