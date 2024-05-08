package com.vivo.push.f;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: NotifyOpenClientClickTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e extends aa {
    public e(com.vivo.push.v vVar) {
        super(vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        Intent parseUri;
        String str;
        com.vivo.push.b.p pVar = (com.vivo.push.b.p) vVar;
        InsideNotificationItem f10 = pVar.f();
        if (f10 == null) {
            com.vivo.push.util.u.d("NotifyOpenClientTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage a10 = com.vivo.push.util.v.a(f10);
        boolean equals = this.f46360a.getPackageName().equals(pVar.d());
        if (equals) {
            NotifyAdapterUtil.cancelNotify(this.f46360a);
        }
        if (equals) {
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(1030L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("type", "2");
            hashMap.put("messageID", String.valueOf(pVar.e()));
            hashMap.put(Constants.PARAM_PLATFORM, this.f46360a.getPackageName());
            String a11 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a11)) {
                hashMap.put("remoteAppId", a11);
            }
            xVar.a(hashMap);
            com.vivo.push.m.a().a(xVar);
            com.vivo.push.util.u.d("NotifyOpenClientTask", "notification is clicked by skip type[" + a10.getSkipType() + "]");
            int skipType = a10.getSkipType();
            boolean z10 = true;
            if (skipType == 1) {
                new Thread(new f(this, this.f46360a, a10.getParams())).start();
                a(a10);
                return;
            }
            if (skipType == 2) {
                String skipContent = a10.getSkipContent();
                if (!skipContent.startsWith("http://") && !skipContent.startsWith("https://")) {
                    z10 = false;
                }
                if (z10) {
                    Uri parse = Uri.parse(skipContent);
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.setFlags(268435456);
                    b(intent, a10.getParams());
                    try {
                        this.f46360a.startActivity(intent);
                    } catch (Exception unused) {
                        com.vivo.push.util.u.a("NotifyOpenClientTask", "startActivity error : ".concat(String.valueOf(parse)));
                    }
                } else {
                    com.vivo.push.util.u.a("NotifyOpenClientTask", "url not legal");
                }
                a(a10);
                return;
            }
            if (skipType == 3) {
                a(a10);
                return;
            }
            if (skipType != 4) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "illegitmacy skip type error : " + a10.getSkipType());
                return;
            }
            String skipContent2 = a10.getSkipContent();
            try {
                parseUri = Intent.parseUri(skipContent2, 1);
                str = parseUri.getPackage();
            } catch (Exception e2) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "open activity error : ".concat(String.valueOf(skipContent2)), e2);
            }
            if (!TextUtils.isEmpty(str) && !this.f46360a.getPackageName().equals(str)) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "open activity error : local pkgName is " + this.f46360a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                return;
            }
            String packageName = parseUri.getComponent() == null ? null : parseUri.getComponent().getPackageName();
            if (!TextUtils.isEmpty(packageName) && !this.f46360a.getPackageName().equals(packageName)) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "open activity component error : local pkgName is " + this.f46360a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                return;
            }
            parseUri.setSelector(null);
            parseUri.setPackage(this.f46360a.getPackageName());
            parseUri.addFlags(335544320);
            b(parseUri, a10.getParams());
            ActivityInfo resolveActivityInfo = parseUri.resolveActivityInfo(this.f46360a.getPackageManager(), 65536);
            if (resolveActivityInfo != null && !resolveActivityInfo.exported) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "activity is not exported : " + resolveActivityInfo.toString());
                return;
            } else {
                this.f46360a.startActivity(parseUri);
                a(a10);
                return;
            }
        }
        com.vivo.push.util.u.a("NotifyOpenClientTask", "notify is " + ((Object) a10) + " ; isMatch is " + equals);
    }

    private void a(UPSNotificationMessage uPSNotificationMessage) {
        com.vivo.push.t.c(new g(this, uPSNotificationMessage));
    }
}
