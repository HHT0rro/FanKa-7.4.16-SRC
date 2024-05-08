package com.vivo.push.restructure.a.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.aa;
import com.vivo.push.util.ab;
import com.vivo.push.util.ag;
import com.vivo.push.util.u;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CheckNode.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c extends a<com.vivo.push.restructure.a.a> {

    /* renamed from: b, reason: collision with root package name */
    private static final List<Integer> f46302b = Arrays.asList(3);

    public c(com.vivo.push.restructure.a.a aVar, i iVar) {
        super("CheckNode", aVar, iVar);
    }

    private static boolean b(Intent intent) {
        try {
            Context b4 = com.vivo.push.restructure.a.a().b();
            String b10 = ag.b(b4, "com.vivo.pushservice");
            u.d("CheckNode", " 配置的验签参数 = ".concat(String.valueOf(b10)));
            if (!TextUtils.equals(b10, "1")) {
                return true;
            }
            String stringExtra = intent.getStringExtra("security_avoid_pull_rsa");
            String stringExtra2 = intent.getStringExtra("security_avoid_rsa_public_key");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                if (!TextUtils.equals(stringExtra, "com.vivo.pushservice") && !TextUtils.equals(stringExtra2, "com.vivo.pushservice")) {
                    if (com.vivo.push.e.b.a().a(b4).a("com.vivo.pushservice".getBytes("UTF-8"), ab.a(stringExtra2), Base64.decode(stringExtra, 2))) {
                        u.d("CheckNode", " RSA验签通过  ");
                        return true;
                    }
                    u.d("CheckNode", " RSA验签 不通过  ");
                    return false;
                }
                u.a("CheckNode", " 验签参数传入错误 securityContent = " + stringExtra + " publickKey= " + stringExtra2);
                return true;
            }
            u.a("CheckNode", "!decrypt.equals, so securityContent == " + stringExtra + " or publickKey isempty ");
            return false;
        } catch (Exception e2) {
            u.a("CheckNode", "checkIntentIsSecurity Exception: " + e2.getMessage());
            return true;
        }
    }

    @Override // com.vivo.push.restructure.a.a.a
    public final /* bridge */ /* synthetic */ int a(com.vivo.push.restructure.a.a aVar) {
        return a2(aVar);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static int a2(com.vivo.push.restructure.a.a aVar) {
        try {
        } catch (Exception e2) {
            u.a("CheckNode", e2);
        }
        if (!com.vivo.push.restructure.a.a().e().l().isAgreePrivacyStatement()) {
            u.d("CheckNode", " checkNeedReportByPrivacyStatement is false  ");
            return 2809;
        }
        Intent b4 = aVar.b();
        String b10 = com.vivo.push.sdk.a.a().b();
        if (!TextUtils.isEmpty(b10) && b10.contains("CommandService")) {
            if (!(b4 != null && a(b4) && b(b4))) {
                u.a("CheckNode", " !checkIntentIsSecurity(intent)");
                return 2801;
            }
        }
        Context b11 = com.vivo.push.restructure.a.a().b();
        String packageName = b11.getPackageName();
        String stringExtra = b4.getStringExtra("command_type");
        if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver")) {
            int intExtra = b4.getIntExtra("command", -1);
            if (intExtra < 0) {
                intExtra = b4.getIntExtra("method", -1);
            }
            if (f46302b.contains(Integer.valueOf(intExtra)) && aa.c(b11, packageName) && !aa.b(b11)) {
                u.a("CheckNode", "METHOD_ON_MESSAGE is not support");
                return 2803;
            }
            String action = b4.getAction();
            if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().e().a(b11, action))) {
                u.d("CheckNode", " reflectReceiver error: receiver for: " + action + " not found, package: " + packageName);
                b4.setPackage(packageName);
                b11.sendBroadcast(b4);
                return 2802;
            }
            return 0;
        }
        u.a("CheckNode", "commandTypeStr is not satisfy == ".concat(String.valueOf(stringExtra)));
        return 2801;
    }

    private static boolean a(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("security_avoid_pull");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    String b4 = com.vivo.push.util.a.a(com.vivo.push.restructure.a.a().b()).b(stringExtra);
                    if ("com.vivo.pushservice".equals(b4)) {
                        return true;
                    }
                    u.a("CheckNode", "!decrypt.equals, so decrypt == ".concat(String.valueOf(b4)));
                    return false;
                } catch (Exception e2) {
                    u.a("CheckNode", "checkIntentIsSecurity Exception: " + e2.getMessage());
                    return false;
                }
            }
            u.a("CheckNode", "checkIntentIsSecurityTextUtils.isEmpty");
            return true;
        } catch (Exception unused) {
            u.a("CheckNode", "getStringExtra error");
            return true;
        }
    }
}
