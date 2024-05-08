package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;

/* compiled from: PushClientSp.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class i extends PushPreferences {

    /* renamed from: c, reason: collision with root package name */
    private static final String f30336c = "i";

    /* renamed from: b, reason: collision with root package name */
    private Context f30337b;

    private i(Context context) {
        super(context, "push_client_self_info");
        this.f30337b = context;
    }

    public static i a(Context context) {
        return new i(context);
    }

    public String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return a("token_info_v2");
            }
            return a(str);
        } catch (Exception e2) {
            HMSLog.e(f30336c, "getSecureData" + e2.getMessage());
            return "";
        }
    }

    public boolean c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return removeKey("token_info_v2");
            }
            return removeKey(str);
        } catch (Exception e2) {
            HMSLog.e(f30336c, "removeToken" + e2.getMessage());
            return false;
        }
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return PushEncrypter.decrypter(this.f30337b, getString(str));
        } catch (Exception e2) {
            HMSLog.e(f30336c, "getSecureData" + e2.getMessage());
            return "";
        }
    }

    public boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return saveString(str, PushEncrypter.encrypter(this.f30337b, str2));
        } catch (Exception e2) {
            HMSLog.e(f30336c, "saveSecureData" + e2.getMessage());
            return false;
        }
    }

    public boolean b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return a("token_info_v2", str2);
            }
            return a(str, str2);
        } catch (Exception e2) {
            HMSLog.e(f30336c, "saveSecureData" + e2.getMessage());
            return false;
        }
    }

    public void a() {
        Map<String, ?> all = getAll();
        if (all.isEmpty() || all.h().isEmpty()) {
            return;
        }
        for (String str : all.h()) {
            if (!"push_kit_auto_init_enabled".equals(str) && !"_proxy_init".equals(str)) {
                removeKey(str);
            }
        }
    }
}
