package com.bytedance.pangle.util;

import android.content.SharedPreferences;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class l {

    /* renamed from: b, reason: collision with root package name */
    private static volatile l f11000b;

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f11001a = Zeus.getAppApplication().getSharedPreferences("pangle_meta_data_sp", 0);

    private l() {
    }

    public static l a() {
        if (f11000b == null) {
            synchronized (l.class) {
                if (f11000b == null) {
                    f11000b = new l();
                }
            }
        }
        return f11000b;
    }

    public final String b(String str) {
        String string = this.f11001a.getString("HOST_IDENTITY_".concat(String.valueOf(str)), "");
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getHostIdentity pluginPKg = " + str + ", hostIdentity = " + string);
        return string;
    }

    public final void c(String str, int i10, boolean z10) {
        SharedPreferences.Editor edit = this.f11001a.edit();
        edit.putBoolean("dex_remove_state_" + str + "_" + i10, z10);
        edit.apply();
    }

    public final void b(String str, int i10, boolean z10) {
        SharedPreferences.Editor edit = this.f11001a.edit();
        edit.putBoolean("dex_opt_state_" + str + "_" + i10, z10);
        edit.apply();
    }

    public final int a(String str) {
        int i10 = this.f11001a.getInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), 0);
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + str + ", pluginApiVersion = " + i10);
        return i10;
    }

    public final int b(String str, int i10) {
        return this.f11001a.getInt("remove_entry_flag_" + str + "_" + i10, 0);
    }

    public final void a(String str, int i10, boolean z10) {
        SharedPreferences.Editor edit = this.f11001a.edit();
        String str2 = "INSTALLED_" + str + "-" + i10;
        if (z10) {
            edit.putBoolean(str2, true);
        } else {
            edit.remove(str2);
        }
        edit.apply();
    }

    public final int b(String str, int i10, String str2) {
        return this.f11001a.getInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i10, 0);
    }

    public final boolean a(String str, int i10) {
        return this.f11001a.getBoolean(String.format(Locale.getDefault(), "INSTALLED_%s-%d", str, Integer.valueOf(i10)), false);
    }

    public final void a(String str, int i10, String str2) {
        int b4 = b(str, i10, str2);
        SharedPreferences.Editor edit = this.f11001a.edit();
        edit.putInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i10, b4 + 1);
        edit.apply();
    }
}
