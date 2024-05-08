package com.kwad.sdk.core.f;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.core.f.a.b;
import com.kwad.sdk.core.f.a.c;
import com.kwad.sdk.core.f.a.d;
import com.kwad.sdk.core.f.a.e;
import com.kwad.sdk.core.f.a.f;
import com.kwad.sdk.core.f.a.g;
import com.kwad.sdk.core.f.a.h;
import com.kwad.sdk.core.f.a.i;
import com.kwad.sdk.core.f.a.j;
import com.kwad.sdk.oaid.OADIDSDKHelper;
import com.kwad.sdk.oaid.OADIDSDKHelper25;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.y;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.CharUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static String awV = "";
    private static final AtomicBoolean awW = new AtomicBoolean();
    private static final AtomicBoolean awX = new AtomicBoolean();
    private static boolean sGetOaidFail;

    private static String Et() {
        if (awX.getAndSet(true)) {
            return awV;
        }
        String j10 = y.j("ksadsdk_pref", "kasd_oaid_key", "");
        awV = j10;
        return j10;
    }

    public static /* synthetic */ String Eu() {
        return Et();
    }

    public static /* synthetic */ void Ev() {
    }

    public static String bc(Context context) {
        if (au.Mo() && !TextUtils.isEmpty(au.Mp())) {
            return au.Mp();
        }
        if (!TextUtils.isEmpty(awV)) {
            return awV;
        }
        if (!au.Mo() && o.Lk()) {
            initAsync(context);
            return awV;
        }
        String Et = Et();
        awV = Et;
        return Et;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bd(Context context) {
        if (!TextUtils.isEmpty(awV) || context == null || sGetOaidFail) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            String upperCase = Build.MANUFACTURER.toUpperCase();
            char c4 = 65535;
            switch (upperCase.hashCode()) {
                case -2053026509:
                    if (upperCase.equals("LENOVO")) {
                        c4 = 6;
                        break;
                    }
                    break;
                case -1712043046:
                    if (upperCase.equals("SAMSUNG")) {
                        c4 = '\n';
                        break;
                    }
                    break;
                case -1706170181:
                    if (upperCase.equals("XIAOMI")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case -1134767290:
                    if (upperCase.equals("BLACKSHARK")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case -602397472:
                    if (upperCase.equals("ONEPLUS")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case 89163:
                    if (upperCase.equals("ZTE")) {
                        c4 = '\f';
                        break;
                    }
                    break;
                case 2018896:
                    if (upperCase.equals("ASUS")) {
                        c4 = 11;
                        break;
                    }
                    break;
                case 2432928:
                    if (upperCase.equals("OPPO")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case 2555124:
                    if (upperCase.equals("SSUI")) {
                        c4 = 14;
                        break;
                    }
                    break;
                case 2634924:
                    if (upperCase.equals("VIVO")) {
                        c4 = 5;
                        break;
                    }
                    break;
                case 73239724:
                    if (upperCase.equals("MEIZU")) {
                        c4 = '\b';
                        break;
                    }
                    break;
                case 74632627:
                    if (upperCase.equals("NUBIA")) {
                        c4 = '\t';
                        break;
                    }
                    break;
                case 630905871:
                    if (upperCase.equals("MOTOLORA")) {
                        c4 = 7;
                        break;
                    }
                    break;
                case 976565563:
                    if (upperCase.equals("FERRMEOS")) {
                        c4 = CharUtils.CR;
                        break;
                    }
                    break;
                case 2141820391:
                    if (upperCase.equals("HUAWEI")) {
                        c4 = 0;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    awV = new b(applicationContext).getOAID();
                    break;
                case 1:
                case 2:
                    awV = new i(applicationContext).getOAID();
                    break;
                case 3:
                case 4:
                    awV = new f(applicationContext).getOAID();
                    break;
                case 5:
                    awV = new h(applicationContext).getOAID();
                    break;
                case 6:
                case 7:
                    awV = new c(applicationContext).getOAID();
                    break;
                case '\b':
                    awV = new d(applicationContext).getOAID();
                    break;
                case '\t':
                    awV = new e(applicationContext).getOAID();
                    break;
                case '\n':
                    awV = new g(applicationContext).getOAID();
                    break;
                case 11:
                    awV = new com.kwad.sdk.core.f.a.a(applicationContext).getOAID();
                    break;
                case '\f':
                case '\r':
                case 14:
                    awV = new j(applicationContext).getOAID();
                    break;
            }
            com.kwad.sdk.core.e.c.i("OAIDHelper", "manufacturer:" + upperCase + "--OAID:" + awV);
            if (TextUtils.isEmpty(awV)) {
                sGetOaidFail = true;
            }
            ej(awV);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ej(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        y.i("ksadsdk_pref", "kasd_oaid_key", str);
    }

    private static void initAsync(final Context context) {
        if (context == null || awW.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.sdk.core.f.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                String unused = a.awV = a.Eu();
                if (TextUtils.isEmpty(a.awV)) {
                    a.bd(context);
                    if (OADIDSDKHelper.isSupport()) {
                        OADIDSDKHelper.getOAId(context, new OADIDSDKHelper.a() { // from class: com.kwad.sdk.core.f.a.1.1
                            @Override // com.kwad.sdk.oaid.OADIDSDKHelper.a
                            public final void em(String str) {
                                String unused2 = a.awV = str;
                                a.ej(str);
                                a.Ev();
                            }
                        });
                    } else if (OADIDSDKHelper25.isSupport()) {
                        OADIDSDKHelper25.getOAId(context, new OADIDSDKHelper25.a() { // from class: com.kwad.sdk.core.f.a.1.2
                            @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
                            public final void em(String str) {
                                String unused2 = a.awV = str;
                                a.ej(str);
                                a.Ev();
                            }
                        });
                    }
                    a.awW.set(false);
                }
            }
        });
    }
}
