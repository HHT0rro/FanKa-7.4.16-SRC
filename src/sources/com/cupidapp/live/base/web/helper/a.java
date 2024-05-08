package com.cupidapp.live.base.web.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.cupidapp.live.base.utils.j;
import java.io.File;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Abi64WebViewCompat.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f13097a = new a();

    public final void a(File file) {
        File[] listFiles = file.listFiles();
        if (file.isDirectory()) {
            boolean z10 = true;
            if (listFiles != null) {
                if (!(listFiles.length == 0)) {
                    z10 = false;
                }
            }
            if (!z10) {
                s.h(listFiles, "listFiles");
                for (File file2 : listFiles) {
                    j.f12332a.a("Abi64WebViewCompat", "file: " + ((Object) file2));
                    s.h(file2, "file");
                    a(file2);
                }
            }
        }
        j.f12332a.a("Abi64WebViewCompat", "fileOrDirectory: " + ((Object) file) + " isSuccessDelete: " + file.delete());
    }

    public final void b(@NotNull Context context) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor clear;
        s.i(context, "context");
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("WebViewChromiumPrefs", 0);
            j.f12332a.a("Abi64WebViewCompat", "chromiumPrefs: " + ((Object) sharedPreferences));
            if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null && (clear = edit.clear()) != null) {
                clear.apply();
            }
            File dataDir = context.getDataDir();
            String str = File.separator;
            a(new File(((Object) dataDir) + str + "app_webview" + str + "GPUCache"));
        } catch (Exception e2) {
            e2.printStackTrace();
            j.f12332a.a("Abi64WebViewCompat", "message: " + e2.getMessage());
        }
    }
}
