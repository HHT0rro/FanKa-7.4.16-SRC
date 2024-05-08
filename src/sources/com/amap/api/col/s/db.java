package com.amap.api.col.s;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: RomIdentifier.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class db {

    /* renamed from: a, reason: collision with root package name */
    private static volatile da f7644a;

    /* renamed from: b, reason: collision with root package name */
    private static Properties f7645b = b();

    private db() {
    }

    public static da a() {
        if (f7644a == null) {
            synchronized (db.class) {
                if (f7644a == null) {
                    try {
                        da a10 = a(Build.MANUFACTURER);
                        if ("".equals(a10.a())) {
                            Iterator iterator2 = Arrays.asList(da.MIUI.a(), da.Flyme.a(), da.RH.a(), da.ColorOS.a(), da.FuntouchOS.a(), da.SmartisanOS.a(), da.AmigoOS.a(), da.Sense.a(), da.LG.a(), da.Google.a(), da.NubiaUI.a()).iterator2();
                            while (true) {
                                if (iterator2.hasNext()) {
                                    da a11 = a((String) iterator2.next());
                                    if (!"".equals(a11.a())) {
                                        a10 = a11;
                                        break;
                                    }
                                } else {
                                    a10 = da.Other;
                                    break;
                                }
                            }
                        }
                        f7644a = a10;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return f7644a;
    }

    private static String b(String str) {
        String property = f7645b.getProperty("[" + str + "]", null);
        if (TextUtils.isEmpty(property)) {
            return c(str);
        }
        return property.replace("[", "").replace("]", "");
    }

    private static String c(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return readLine;
            } catch (IOException unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean d(da daVar) {
        String b4 = b("ro.build.version.opporom");
        if (TextUtils.isEmpty(b4)) {
            return false;
        }
        a(daVar, b4);
        daVar.b(b4);
        return true;
    }

    private static boolean e(da daVar) {
        String b4 = b("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(b4)) {
            return false;
        }
        a(daVar, b4);
        daVar.b(b4);
        return true;
    }

    private static boolean f(da daVar) {
        String b4 = b("ro.smartisan.version");
        if (TextUtils.isEmpty(b4)) {
            return false;
        }
        a(daVar, b4);
        daVar.b(b4);
        return true;
    }

    private static boolean g(da daVar) {
        String b4 = b("ro.build.display.id");
        if (TextUtils.isEmpty(b4) || !b4.matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return false;
        }
        a(daVar, b4);
        daVar.b(b4);
        return true;
    }

    private static boolean h(da daVar) {
        String b4 = b("ro.letv.release.version");
        if (TextUtils.isEmpty(b4)) {
            return false;
        }
        a(daVar, b4);
        daVar.b(b4);
        return true;
    }

    private static boolean i(da daVar) {
        String b4 = b("ro.build.sense.version");
        if (TextUtils.isEmpty(b4)) {
            return false;
        }
        a(daVar, b4);
        daVar.b(b4);
        return true;
    }

    private static boolean j(da daVar) {
        String b4 = b("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(b4)) {
            return false;
        }
        a(daVar, b4);
        daVar.b(b4);
        return true;
    }

    private static boolean k(da daVar) {
        if (!"android-google".equals(b("ro.com.google.clientidbase"))) {
            return false;
        }
        String b4 = b("ro.build.version.release");
        daVar.a(Build.VERSION.SDK_INT);
        daVar.b(b4);
        return true;
    }

    private static boolean l(da daVar) {
        String b4 = b("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(b4)) {
            return false;
        }
        a(daVar, b4);
        daVar.b(b4);
        return true;
    }

    private static Properties b() {
        Properties properties = new Properties();
        try {
            properties.load(Runtime.getRuntime().exec("getprop").getInputStream());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return properties;
    }

    private static boolean c(da daVar) {
        String b4 = b("ro.build.version.emui");
        if (TextUtils.isEmpty(b4)) {
            return false;
        }
        a(daVar, b4);
        daVar.b(b4);
        return true;
    }

    private static boolean b(da daVar) {
        String b4 = b("ro.flyme.published");
        String b10 = b("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(b4) && TextUtils.isEmpty(b10)) {
            return false;
        }
        String b11 = b("ro.build.display.id");
        a(daVar, b11);
        daVar.b(b11);
        return true;
    }

    private static da a(String str) {
        if (str != null && str.length() > 0) {
            da daVar = da.MIUI;
            if (str.equals(daVar.a())) {
                if (a(daVar)) {
                    return daVar;
                }
            } else {
                da daVar2 = da.Flyme;
                if (str.equals(daVar2.a())) {
                    if (b(daVar2)) {
                        return daVar2;
                    }
                } else {
                    da daVar3 = da.RH;
                    if (str.equals(daVar3.a())) {
                        if (c(daVar3)) {
                            return daVar3;
                        }
                    } else {
                        da daVar4 = da.ColorOS;
                        if (str.equals(daVar4.a())) {
                            if (d(daVar4)) {
                                return daVar4;
                            }
                        } else {
                            da daVar5 = da.FuntouchOS;
                            if (str.equals(daVar5.a())) {
                                if (e(daVar5)) {
                                    return daVar5;
                                }
                            } else {
                                da daVar6 = da.SmartisanOS;
                                if (str.equals(daVar6.a())) {
                                    if (f(daVar6)) {
                                        return daVar6;
                                    }
                                } else {
                                    da daVar7 = da.AmigoOS;
                                    if (str.equals(daVar7.a())) {
                                        if (g(daVar7)) {
                                            return daVar7;
                                        }
                                    } else {
                                        da daVar8 = da.EUI;
                                        if (str.equals(daVar8.a())) {
                                            if (h(daVar8)) {
                                                return daVar8;
                                            }
                                        } else {
                                            da daVar9 = da.Sense;
                                            if (str.equals(daVar9.a())) {
                                                if (i(daVar9)) {
                                                    return daVar9;
                                                }
                                            } else {
                                                da daVar10 = da.LG;
                                                if (str.equals(daVar10.a())) {
                                                    if (j(daVar10)) {
                                                        return daVar10;
                                                    }
                                                } else {
                                                    da daVar11 = da.Google;
                                                    if (str.equals(daVar11.a())) {
                                                        if (k(daVar11)) {
                                                            return daVar11;
                                                        }
                                                    } else {
                                                        da daVar12 = da.NubiaUI;
                                                        if (str.equals(daVar12.a()) && l(daVar12)) {
                                                            return daVar12;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return da.Other;
        }
        return da.Other;
    }

    private static void a(da daVar, String str) {
        Matcher matcher = Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group(1);
                daVar.a(group);
                daVar.a(Integer.parseInt(group.split("\\.")[0]));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static boolean a(da daVar) {
        if (TextUtils.isEmpty(b("ro.miui.ui.version.name"))) {
            return false;
        }
        String b4 = b("ro.build.version.incremental");
        a(daVar, b4);
        daVar.b(b4);
        return true;
    }
}
