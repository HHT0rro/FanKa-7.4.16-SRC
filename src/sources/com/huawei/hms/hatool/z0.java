package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class z0 {

    /* renamed from: a, reason: collision with root package name */
    private String f30248a;

    /* renamed from: b, reason: collision with root package name */
    public l1 f30249b;

    public z0(String str) {
        this.f30248a = str;
        this.f30249b = new l1(str);
        s.c().a(this.f30248a, this.f30249b);
    }

    private s0 b(int i10) {
        if (i10 == 0) {
            return this.f30249b.c();
        }
        if (i10 == 1) {
            return this.f30249b.b();
        }
        if (i10 == 2) {
            return this.f30249b.d();
        }
        if (i10 != 3) {
            return null;
        }
        return this.f30249b.a();
    }

    private boolean c(int i10) {
        String str;
        if (i10 != 2) {
            s0 b4 = b(i10);
            if (b4 != null && !TextUtils.isEmpty(b4.h())) {
                return true;
            }
            str = "verifyURL(): URL check failed. type: " + i10;
        } else {
            if ("_default_config_tag".equals(this.f30248a)) {
                return true;
            }
            str = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        }
        v.e("hmsSdk", str);
        return false;
    }

    public void a(int i10) {
        v.d("hmsSdk", "onReport. TAG: " + this.f30248a + ", TYPE: " + i10);
        g0.a().a(this.f30248a, i10);
    }

    public void a(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        v.d("hmsSdk", "onEvent. TAG: " + this.f30248a + ", TYPE: " + i10 + ", eventId : " + str);
        if (e1.a(str) || !c(i10)) {
            v.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f30248a + ", TYPE: " + i10);
            return;
        }
        if (!e1.a(linkedHashMap)) {
            v.e("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.f30248a + ", TYPE: " + i10);
            linkedHashMap = null;
        }
        g0.a().a(this.f30248a, i10, str, linkedHashMap);
    }

    public void a(Context context, String str, String str2) {
        v.d("hmsSdk", "onEvent(context). TAG: " + this.f30248a + ", eventId : " + str);
        if (context == null) {
            v.e("hmsSdk", "context is null in onevent ");
            return;
        }
        if (e1.a(str) || !c(0)) {
            v.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f30248a);
            return;
        }
        if (!e1.a("value", str2, 65536)) {
            v.e("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.f30248a);
            str2 = "";
        }
        g0.a().a(this.f30248a, context, str, str2);
    }

    public void a(s0 s0Var) {
        v.c("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.f30248a);
        if (s0Var != null) {
            this.f30249b.a(s0Var);
        } else {
            v.e("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
            this.f30249b.a((s0) null);
        }
    }

    public void b(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        v.d("hmsSdk", "onStreamEvent. TAG: " + this.f30248a + ", TYPE: " + i10 + ", eventId : " + str);
        if (e1.a(str) || !c(i10)) {
            v.e("hmsSdk", "onStreamEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f30248a + ", TYPE: " + i10);
            return;
        }
        if (!e1.a(linkedHashMap)) {
            v.e("hmsSdk", "onStreamEvent() parameter mapValue will be cleared.TAG: " + this.f30248a + ", TYPE: " + i10);
            linkedHashMap = null;
        }
        g0.a().b(this.f30248a, i10, str, linkedHashMap);
    }

    public void b(s0 s0Var) {
        v.c("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.f30248a);
        if (s0Var != null) {
            this.f30249b.b(s0Var);
        } else {
            this.f30249b.b(null);
            v.e("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
        }
    }
}
