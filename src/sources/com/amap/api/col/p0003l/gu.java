package com.amap.api.col.p0003l;

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
public final class gu {

    /* renamed from: a, reason: collision with root package name */
    private static volatile gt f6157a;

    /* renamed from: b, reason: collision with root package name */
    private static Properties f6158b = b();

    private gu() {
    }

    public static gt a() {
        if (f6157a == null) {
            synchronized (gu.class) {
                if (f6157a == null) {
                    try {
                        gt a10 = a(Build.MANUFACTURER);
                        if ("".equals(a10.a())) {
                            Iterator iterator2 = Arrays.asList(gt.MIUI.a(), gt.Flyme.a(), gt.RH.a(), gt.ColorOS.a(), gt.FuntouchOS.a(), gt.SmartisanOS.a(), gt.AmigoOS.a(), gt.Sense.a(), gt.LG.a(), gt.Google.a(), gt.NubiaUI.a()).iterator2();
                            while (true) {
                                if (iterator2.hasNext()) {
                                    gt a11 = a((String) iterator2.next());
                                    if (!"".equals(a11.a())) {
                                        a10 = a11;
                                        break;
                                    }
                                } else {
                                    a10 = gt.Other;
                                    break;
                                }
                            }
                        }
                        f6157a = a10;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return f6157a;
    }

    private static String b(String str) {
        String property = f6158b.getProperty("[" + str + "]", null);
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

    private static boolean d(gt gtVar) {
        String b4 = b("ro.build.version.opporom");
        if (TextUtils.isEmpty(b4)) {
            return false;
        }
        a(gtVar, b4);
        gtVar.b(b4);
        return true;
    }

    private static boolean e(gt gtVar) {
        String b4 = b("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(b4)) {
            return false;
        }
        a(gtVar, b4);
        gtVar.b(b4);
        return true;
    }

    private static boolean f(gt gtVar) {
        String b4 = b("ro.smartisan.version");
        if (TextUtils.isEmpty(b4)) {
            return false;
        }
        a(gtVar, b4);
        gtVar.b(b4);
        return true;
    }

    private static boolean g(gt gtVar) {
        String b4 = b("ro.build.display.id");
        if (TextUtils.isEmpty(b4) || !b4.matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return false;
        }
        a(gtVar, b4);
        gtVar.b(b4);
        return true;
    }

    private static boolean h(gt gtVar) {
        String b4 = b("ro.letv.release.version");
        if (TextUtils.isEmpty(b4)) {
            return false;
        }
        a(gtVar, b4);
        gtVar.b(b4);
        return true;
    }

    private static boolean i(gt gtVar) {
        String b4 = b("ro.build.sense.version");
        if (TextUtils.isEmpty(b4)) {
            return false;
        }
        a(gtVar, b4);
        gtVar.b(b4);
        return true;
    }

    private static boolean j(gt gtVar) {
        String b4 = b("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(b4)) {
            return false;
        }
        a(gtVar, b4);
        gtVar.b(b4);
        return true;
    }

    private static boolean k(gt gtVar) {
        if (!"android-google".equals(b("ro.com.google.clientidbase"))) {
            return false;
        }
        String b4 = b("ro.build.version.release");
        gtVar.a(Build.VERSION.SDK_INT);
        gtVar.b(b4);
        return true;
    }

    private static boolean l(gt gtVar) {
        String b4 = b("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(b4)) {
            return false;
        }
        a(gtVar, b4);
        gtVar.b(b4);
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

    private static boolean c(gt gtVar) {
        String b4 = b("ro.build.version.emui");
        if (TextUtils.isEmpty(b4)) {
            return false;
        }
        a(gtVar, b4);
        gtVar.b(b4);
        return true;
    }

    private static boolean b(gt gtVar) {
        String b4 = b("ro.flyme.published");
        String b10 = b("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(b4) && TextUtils.isEmpty(b10)) {
            return false;
        }
        String b11 = b("ro.build.display.id");
        a(gtVar, b11);
        gtVar.b(b11);
        return true;
    }

    private static gt a(String str) {
        if (str != null && str.length() > 0) {
            gt gtVar = gt.MIUI;
            if (str.equals(gtVar.a())) {
                if (a(gtVar)) {
                    return gtVar;
                }
            } else {
                gt gtVar2 = gt.Flyme;
                if (str.equals(gtVar2.a())) {
                    if (b(gtVar2)) {
                        return gtVar2;
                    }
                } else {
                    gt gtVar3 = gt.RH;
                    if (str.equals(gtVar3.a())) {
                        if (c(gtVar3)) {
                            return gtVar3;
                        }
                    } else {
                        gt gtVar4 = gt.ColorOS;
                        if (str.equals(gtVar4.a())) {
                            if (d(gtVar4)) {
                                return gtVar4;
                            }
                        } else {
                            gt gtVar5 = gt.FuntouchOS;
                            if (str.equals(gtVar5.a())) {
                                if (e(gtVar5)) {
                                    return gtVar5;
                                }
                            } else {
                                gt gtVar6 = gt.SmartisanOS;
                                if (str.equals(gtVar6.a())) {
                                    if (f(gtVar6)) {
                                        return gtVar6;
                                    }
                                } else {
                                    gt gtVar7 = gt.AmigoOS;
                                    if (str.equals(gtVar7.a())) {
                                        if (g(gtVar7)) {
                                            return gtVar7;
                                        }
                                    } else {
                                        gt gtVar8 = gt.EUI;
                                        if (str.equals(gtVar8.a())) {
                                            if (h(gtVar8)) {
                                                return gtVar8;
                                            }
                                        } else {
                                            gt gtVar9 = gt.Sense;
                                            if (str.equals(gtVar9.a())) {
                                                if (i(gtVar9)) {
                                                    return gtVar9;
                                                }
                                            } else {
                                                gt gtVar10 = gt.LG;
                                                if (str.equals(gtVar10.a())) {
                                                    if (j(gtVar10)) {
                                                        return gtVar10;
                                                    }
                                                } else {
                                                    gt gtVar11 = gt.Google;
                                                    if (str.equals(gtVar11.a())) {
                                                        if (k(gtVar11)) {
                                                            return gtVar11;
                                                        }
                                                    } else {
                                                        gt gtVar12 = gt.NubiaUI;
                                                        if (str.equals(gtVar12.a()) && l(gtVar12)) {
                                                            return gtVar12;
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
            return gt.Other;
        }
        return gt.Other;
    }

    private static void a(gt gtVar, String str) {
        Matcher matcher = Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group(1);
                gtVar.a(group);
                gtVar.a(Integer.parseInt(group.split("\\.")[0]));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static boolean a(gt gtVar) {
        if (TextUtils.isEmpty(b("ro.miui.ui.version.name"))) {
            return false;
        }
        String b4 = b("ro.build.version.incremental");
        a(gtVar, b4);
        gtVar.b(b4);
        return true;
    }
}
