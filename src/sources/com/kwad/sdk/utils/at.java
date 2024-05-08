package com.kwad.sdk.utils;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class at {
    private static String aPE;
    private static String aPF;

    public static boolean Md() {
        return gI("EMUI");
    }

    public static boolean Me() {
        return gI("MIUI");
    }

    public static boolean Mf() {
        return gI("FLYME");
    }

    private static boolean gI(String str) {
        String str2 = aPE;
        if (str2 != null) {
            return str2.contains(str);
        }
        String str3 = bh.get("ro.build.version.opporom");
        aPF = str3;
        if (!TextUtils.isEmpty(str3)) {
            aPE = "OPPO";
        } else {
            String str4 = bh.get("ro.vivo.os.version");
            aPF = str4;
            if (!TextUtils.isEmpty(str4)) {
                aPE = "VIVO";
            } else {
                String str5 = bh.get("ro.build.version.emui");
                aPF = str5;
                if (!TextUtils.isEmpty(str5)) {
                    aPE = "EMUI";
                } else {
                    String str6 = bh.get("ro.miui.ui.version.name");
                    aPF = str6;
                    if (!TextUtils.isEmpty(str6)) {
                        aPE = "MIUI";
                    } else {
                        String str7 = bh.get("ro.product.system.manufacturer");
                        aPF = str7;
                        if (!TextUtils.isEmpty(str7)) {
                            aPE = "OnePlus";
                        } else {
                            String str8 = bh.get("ro.smartisan.version");
                            aPF = str8;
                            if (!TextUtils.isEmpty(str8)) {
                                aPE = "SMARTISAN";
                            } else if (bh.get("ro.product.manufacturer").toUpperCase().contains("SAMSUNG")) {
                                aPE = "SAMSUNG";
                            } else {
                                String str9 = Build.DISPLAY;
                                aPF = str9;
                                if (str9.toUpperCase().contains("FLYME")) {
                                    aPE = "FLYME";
                                } else {
                                    aPF = "unknown";
                                    aPE = Build.MANUFACTURER.toUpperCase();
                                }
                            }
                        }
                    }
                }
            }
        }
        return aPE.contains(str);
    }

    public static String getName() {
        if (aPE == null) {
            gI("");
        }
        return aPE;
    }

    public static String getVersion() {
        if (aPF == null) {
            gI("");
        }
        return aPF;
    }
}
