package com.xiaomi.push;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum fk {
    COMMAND_REGISTER("register"),
    COMMAND_UNREGISTER("unregister"),
    COMMAND_SET_ALIAS("set-alias"),
    COMMAND_UNSET_ALIAS("unset-alias"),
    COMMAND_SET_ACCOUNT("set-account"),
    COMMAND_UNSET_ACCOUNT("unset-account"),
    COMMAND_SUBSCRIBE_TOPIC("subscribe-topic"),
    COMMAND_UNSUBSCRIBE_TOPIC("unsubscibe-topic"),
    COMMAND_SET_ACCEPT_TIME("accept-time"),
    COMMAND_CHK_VDEVID("check-vdeviceid");


    /* renamed from: a, reason: collision with other field name */
    public final String f266a;

    fk(String str) {
        this.f266a = str;
    }

    public static int a(String str) {
        int i10 = -1;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        for (fk fkVar : values()) {
            if (fkVar.f266a.equals(str)) {
                i10 = h4.b(fkVar);
            }
        }
        return i10;
    }
}
