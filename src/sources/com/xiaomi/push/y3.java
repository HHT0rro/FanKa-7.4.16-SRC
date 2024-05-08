package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class y3 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f48506b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f48507c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f48508d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f48509e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ x3 f48510f;

    public y3(x3 x3Var, String str, Context context, String str2, String str3) {
        this.f48510f = x3Var;
        this.f48506b = str;
        this.f48507c = context;
        this.f48508d = str2;
        this.f48509e = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        String str;
        String str2;
        Context context2;
        String str3;
        String str4;
        x3 x3Var;
        Context context3;
        x3 x3Var2;
        ew ewVar;
        Context context4;
        if (TextUtils.isEmpty(this.f48506b)) {
            context = this.f48507c;
            str = "null";
            str2 = "A receive a incorrect message with empty info";
        } else {
            try {
                t3.a(this.f48507c, this.f48506b, 1001, "get message");
                JSONObject jSONObject = new JSONObject(this.f48506b);
                String optString = jSONObject.optString("action");
                String optString2 = jSONObject.optString("awakened_app_packagename");
                String optString3 = jSONObject.optString("awake_app_packagename");
                String optString4 = jSONObject.optString("awake_app");
                String optString5 = jSONObject.optString("awake_type");
                int optInt = jSONObject.optInt("awake_foreground", 0);
                if (this.f48508d.equals(optString3) && this.f48509e.equals(optString4)) {
                    if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString2)) {
                        this.f48510f.o(optString3);
                        this.f48510f.k(optString4);
                        w3 w3Var = new w3();
                        w3Var.f(optString);
                        w3Var.d(optString2);
                        w3Var.c(optInt);
                        w3Var.j(this.f48506b);
                        if ("service".equals(optString5)) {
                            if (TextUtils.isEmpty(optString)) {
                                w3Var.h("com.xiaomi.mipush.sdk.PushMessageHandler");
                                x3Var2 = this.f48510f;
                                ewVar = ew.SERVICE_COMPONENT;
                                context4 = this.f48507c;
                            } else {
                                x3Var2 = this.f48510f;
                                ewVar = ew.SERVICE_ACTION;
                                context4 = this.f48507c;
                            }
                            x3Var2.i(ewVar, context4, w3Var);
                            return;
                        }
                        ew ewVar2 = ew.ACTIVITY;
                        if (ewVar2.f264a.equals(optString5)) {
                            x3Var = this.f48510f;
                            context3 = this.f48507c;
                        } else {
                            ewVar2 = ew.PROVIDER;
                            if (ewVar2.f264a.equals(optString5)) {
                                x3Var = this.f48510f;
                                context3 = this.f48507c;
                            } else {
                                context2 = this.f48507c;
                                str3 = this.f48506b;
                                str4 = "A receive a incorrect message with unknown type " + optString5;
                            }
                        }
                        x3Var.i(ewVar2, context3, w3Var);
                        return;
                    }
                    context2 = this.f48507c;
                    str3 = this.f48506b;
                    str4 = "A receive a incorrect message with empty type";
                    t3.a(context2, str3, 1008, str4);
                    return;
                }
                t3.a(this.f48507c, this.f48506b, 1008, "A receive a incorrect message with incorrect package info" + optString3);
                return;
            } catch (JSONException e2) {
                fc.c.k(e2);
                context = this.f48507c;
                str = this.f48506b;
                str2 = "A meet a exception when receive the message";
            }
        }
        t3.a(context, str, 1008, str2);
    }
}
