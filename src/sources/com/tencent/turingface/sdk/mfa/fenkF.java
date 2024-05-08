package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.hailiang.advlib.core.ADEvent;
import com.tencent.turingface.sdk.mfa.vneRm;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class fenkF {

    /* renamed from: a, reason: collision with root package name */
    public static final String f45789a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f45790b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class spXPg implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f45791a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f45792b;

        public spXPg(Context context, Map map) {
            this.f45791a = context;
            this.f45792b = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            fenkF.a(this.f45791a, (Map<String, String>) this.f45792b);
        }
    }

    static {
        StringBuilder b4 = com.tencent.turingcam.oqKCa.b("turingfd_conf_");
        b4.append(com.tencent.turingcam.oqKCa.f45455a);
        b4.append("_");
        b4.append("mfa");
        f45789a = b4.toString();
    }

    public fenkF(Handler handler) {
        this.f45790b = handler;
    }

    public final void a(Context context, long j10) {
        if (j10 >= Long.MAX_VALUE) {
            j10 = Long.MAX_VALUE;
        }
        a(context, "401", "" + j10, true);
    }

    public final WOMZP b(Context context) {
        System.currentTimeMillis();
        WOMZP womzp = new WOMZP(30);
        for (String str : b(context, "402").split("_")) {
            try {
                womzp.a(Long.valueOf(Long.valueOf(str).longValue()));
            } catch (NumberFormatException unused) {
            }
        }
        return womzp;
    }

    public final void c(Context context, long j10) {
        a(context, "503", "" + j10, true);
    }

    public final vneRm a(Context context) {
        try {
            String b4 = b(context, ADEvent.PRICE_LOW);
            if (TextUtils.isEmpty(b4)) {
                return vneRm.a(1);
            }
            long j10 = 0;
            try {
                j10 = Long.valueOf(b(context, ADEvent.BLACKLIST_FILTER)).longValue();
            } catch (Throwable unused) {
            }
            String b10 = b(context, ADEvent.TIMEOUT_FILTER);
            String b11 = b(context, "105");
            String b12 = b(context, "106");
            String b13 = b(context, "110");
            vneRm.spXPg spxpg = new vneRm.spXPg();
            spxpg.f45975b = j10;
            spxpg.f45974a = b4;
            spxpg.f45976c = b10;
            spxpg.f45977d = b11;
            spxpg.f45978e = b12;
            spxpg.f45979f = b13;
            return new vneRm(spxpg);
        } catch (Throwable unused2) {
            return vneRm.a(1);
        }
    }

    public static String b(Context context, String str) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences(f45789a, 0);
        } catch (Throwable unused) {
            sharedPreferences = null;
        }
        if (sharedPreferences == null) {
            return "";
        }
        String string = sharedPreferences.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            int length = string.length() / 2;
            byte[] bArr = new byte[length];
            char[] charArray = string.toUpperCase().toCharArray();
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = i10 * 2;
                bArr[i10] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i11 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i11])) << 4));
            }
            return new String(com.tencent.turingcam.oqKCa.a(bArr, com.tencent.turingcam.oqKCa.b()), "UTF-8");
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static void a(Context context, Map<String, String> map) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        try {
            sharedPreferences = context.getSharedPreferences(f45789a, 0);
        } catch (Throwable unused) {
            sharedPreferences = null;
        }
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        for (String str : map.h()) {
            try {
                edit.putString(str, com.tencent.turingcam.oqKCa.a(com.tencent.turingcam.oqKCa.b(map.get(str).getBytes(), com.tencent.turingcam.oqKCa.b())));
            } catch (Throwable unused2) {
            }
        }
        try {
            edit.commit();
        } catch (Throwable unused3) {
        }
    }

    public final void b(Context context, long j10) {
        HashMap hashMap = new HashMap();
        hashMap.put("902", "" + j10);
        a(context, hashMap);
    }

    public final void a(Context context, String str, String str2, boolean z10) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        a(context, hashMap, z10);
    }

    public final void a(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        a(context, (Map<String, String>) hashMap, false);
    }

    public final void a(Context context, Map<String, String> map, boolean z10) {
        if (z10) {
            a(context, map);
        } else {
            this.f45790b.post(new spXPg(context, map));
        }
    }

    public final long a(Context context, String str) {
        try {
            return Long.valueOf(b(context, str)).longValue();
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
