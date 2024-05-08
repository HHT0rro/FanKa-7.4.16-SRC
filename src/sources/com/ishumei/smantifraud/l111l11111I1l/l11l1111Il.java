package com.ishumei.smantifraud.l111l11111I1l;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.telephony.CellLocation;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.core.app.NotificationCompat;
import com.android.internal.os.PowerProfile;
import com.huawei.quickcard.base.code.AbilityCode;
import com.kuaishou.weapon.p0.g;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l11l1111Il {
    private Object l1111l111111Il;
    private Context l111l11111lIl;

    public l11l1111Il() {
        this.l1111l111111Il = null;
        this.l111l11111lIl = null;
        try {
            Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
            if (context != null) {
                this.l111l11111lIl = context;
                this.l1111l111111Il = com.ishumei.smantifraud.l111l1111llIl.l111l11111I1l.l1111l111111Il(context, "getSystemService", new Class[]{String.class}, new Object[]{"phone"});
            }
        } catch (Exception unused) {
        }
    }

    private static int l1111l111111Il(Object obj, String str, Object... objArr) {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, new Class[0]);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return ((Integer) declaredMethod.invoke(obj, objArr)).intValue();
    }

    private CellLocation l1111l111111Il(List<?> list) {
        int l1111l111111Il;
        int l1111l111111Il2;
        GsmCellLocation gsmCellLocation;
        GsmCellLocation gsmCellLocation2 = null;
        if (list != null && !list.isEmpty()) {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            CdmaCellLocation cdmaCellLocation = null;
            int i10 = 0;
            char c4 = 0;
            while (true) {
                if (i10 >= list.size()) {
                    break;
                }
                Object obj = list.get(i10);
                if (obj != null) {
                    try {
                        Class<?> loadClass = systemClassLoader.loadClass("android.telephony.CellInfoGsm");
                        Class<?> loadClass2 = systemClassLoader.loadClass("android.telephony.CellInfoWcdma");
                        Class<?> loadClass3 = systemClassLoader.loadClass("android.telephony.CellInfoLte");
                        Class<?> loadClass4 = systemClassLoader.loadClass("android.telephony.CellInfoCdma");
                        c4 = loadClass.isInstance(obj) ? (char) 1 : loadClass2.isInstance(obj) ? (char) 2 : loadClass3.isInstance(obj) ? (char) 3 : loadClass4.isInstance(obj) ? (char) 4 : (char) 0;
                        if (c4 <= 0) {
                            continue;
                        } else {
                            Object l111l11111lIl = l111l11111lIl(c4 == 1 ? loadClass.cast(obj) : c4 == 2 ? loadClass2.cast(obj) : c4 == 3 ? loadClass3.cast(obj) : loadClass4.cast(obj), "getCellIdentity", new Object[0]);
                            if (l111l11111lIl != null) {
                                if (c4 == 4) {
                                    CdmaCellLocation cdmaCellLocation2 = new CdmaCellLocation();
                                    try {
                                        cdmaCellLocation2.setCellLocationData(l1111l111111Il(l111l11111lIl, "getBasestationId", new Object[0]), l1111l111111Il(l111l11111lIl, "getLatitude", new Object[0]), l1111l111111Il(l111l11111lIl, "getLongitude", new Object[0]), l1111l111111Il(l111l11111lIl, "getSystemId", new Object[0]), l1111l111111Il(l111l11111lIl, "getNetworkId", new Object[0]));
                                        cdmaCellLocation = cdmaCellLocation2;
                                        break;
                                    } catch (Exception unused) {
                                        cdmaCellLocation = cdmaCellLocation2;
                                    }
                                } else {
                                    if (c4 == 3) {
                                        l1111l111111Il = l1111l111111Il(l111l11111lIl, "getTac", new Object[0]);
                                        l1111l111111Il2 = l1111l111111Il(l111l11111lIl, "getCi", new Object[0]);
                                        gsmCellLocation = new GsmCellLocation();
                                    } else {
                                        l1111l111111Il = l1111l111111Il(l111l11111lIl, "getLac", new Object[0]);
                                        l1111l111111Il2 = l1111l111111Il(l111l11111lIl, "getCid", new Object[0]);
                                        gsmCellLocation = new GsmCellLocation();
                                    }
                                    try {
                                        gsmCellLocation.setLacAndCid(l1111l111111Il, l1111l111111Il2);
                                        gsmCellLocation2 = gsmCellLocation;
                                        break;
                                    } catch (Exception unused2) {
                                        gsmCellLocation2 = gsmCellLocation;
                                    }
                                }
                            }
                        }
                    } catch (Exception unused3) {
                        continue;
                    }
                }
                i10++;
            }
            if (c4 == 4) {
                return cdmaCellLocation;
            }
        }
        return gsmCellLocation2;
    }

    private Object l1111l111111Il(String str) {
        try {
            Context context = this.l111l11111lIl;
            if (context != null) {
                return com.ishumei.smantifraud.l111l1111llIl.l111l11111I1l.l1111l111111Il(context.getApplicationContext(), "getSystemService", new Class[]{String.class}, new Object[]{str});
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Map<String, Integer> l111l11111I1l() {
        try {
            AudioManager audioManager = (AudioManager) com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il.getSystemService(PowerProfile.POWER_AUDIO);
            HashMap hashMap = new HashMap();
            hashMap.put("call", Integer.valueOf(audioManager.getStreamVolume(0)));
            hashMap.put("system", Integer.valueOf(audioManager.getStreamVolume(1)));
            hashMap.put("ring", Integer.valueOf(audioManager.getStreamVolume(2)));
            hashMap.put("music", Integer.valueOf(audioManager.getStreamVolume(3)));
            hashMap.put(NotificationCompat.CATEGORY_ALARM, Integer.valueOf(audioManager.getStreamVolume(4)));
            return hashMap;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Object l111l11111lIl(Object obj, String str, Object... objArr) {
        Class<?> cls = obj.getClass();
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            clsArr[i10] = objArr[i10].getClass();
            if (clsArr[i10] == Integer.class) {
                clsArr[i10] = Integer.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(obj, objArr);
    }

    private String l111l1111lI1l() {
        Object obj;
        try {
            if (!com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l111l11111lIl(g.f36117c) || (obj = this.l1111l111111Il) == null) {
                return "";
            }
            String str = (String) com.ishumei.smantifraud.l111l1111llIl.l111l11111I1l.l1111l111111Il(obj, "getSubscriberId");
            return str == null ? "" : str;
        } catch (SecurityException | Exception unused) {
            return "";
        }
    }

    private static int l111l1111lIl() {
        try {
            try {
                Class.forName("android.telephony.MSimTelephonyManager");
                return 1;
            } catch (SecurityException unused) {
                return AbilityCode.SHARE_INSTALLED_ERROR;
            } catch (Exception unused2) {
                return 0;
            }
        } catch (Exception unused3) {
            Class.forName("android.telephony.TelephonyManager2");
            return 2;
        }
    }

    private String l111l1111llIl() {
        Object obj;
        try {
            if (!com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l111l11111lIl(g.f36117c) || (obj = this.l1111l111111Il) == null) {
                return "";
            }
            String str = (String) com.ishumei.smantifraud.l111l1111llIl.l111l11111I1l.l1111l111111Il(obj, "getDeviceId");
            return str == null ? "" : str;
        } catch (SecurityException | Exception unused) {
            return "";
        }
    }

    private Class<?> l11l1111I11l() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        int l111l1111lIl = l111l1111lIl();
        try {
            return systemClassLoader.loadClass(l111l1111lIl != 0 ? l111l1111lIl != 1 ? l111l1111lIl != 2 ? null : "android.telephony.TelephonyManager2" : "android.telephony.MSimTelephonyManager" : "android.telephony.TelephonyManager");
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001f A[Catch: Exception -> 0x0082, TryCatch #4 {Exception -> 0x0082, blocks: (B:3:0x0001, B:12:0x001f, B:14:0x0029, B:29:0x0077, B:33:0x007f, B:49:0x0011), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.telephony.CellLocation l11l1111I1l() {
        /*
            r8 = this;
            r0 = 0
            int r1 = l111l1111lIl()     // Catch: java.lang.Exception -> L82
            r2 = 1
            if (r1 == 0) goto L19
            if (r1 == r2) goto L16
            r3 = 2
            if (r1 == r3) goto Lf
            r1 = r0
            goto L1c
        Lf:
            java.lang.String r1 = "phone2"
        L11:
            java.lang.Object r1 = r8.l1111l111111Il(r1)     // Catch: java.lang.Exception -> L82
            goto L1c
        L16:
            java.lang.String r1 = "phone_msim"
            goto L11
        L19:
            java.lang.String r1 = "phone"
            goto L11
        L1c:
            if (r1 != 0) goto L1f
            return r0
        L1f:
            java.lang.Class r3 = r8.l11l1111I11l()     // Catch: java.lang.Exception -> L82
            boolean r4 = r3.isInstance(r1)     // Catch: java.lang.Exception -> L82
            if (r4 == 0) goto L7c
            java.lang.Object r1 = r3.cast(r1)     // Catch: java.lang.Exception -> L82
            java.lang.String r3 = "getCellLocation"
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> L37
            java.lang.Object r5 = l111l11111lIl(r1, r3, r5)     // Catch: java.lang.Exception -> L37
            goto L38
        L37:
            r5 = r0
        L38:
            if (r5 != 0) goto L57
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L56
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Exception -> L56
            r6[r4] = r7     // Catch: java.lang.Exception -> L56
            java.lang.Object r5 = l111l11111lIl(r1, r3, r6)     // Catch: java.lang.Exception -> L56
            if (r5 != 0) goto L57
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L56
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L56
            r6[r4] = r7     // Catch: java.lang.Exception -> L56
            java.lang.Object r3 = l111l11111lIl(r1, r3, r6)     // Catch: java.lang.Exception -> L56
            r5 = r3
            goto L57
        L56:
        L57:
            if (r5 != 0) goto L69
            java.lang.String r3 = "getCellLocationGemini"
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L68
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L68
            r6[r4] = r2     // Catch: java.lang.Exception -> L68
            java.lang.Object r5 = l111l11111lIl(r1, r3, r6)     // Catch: java.lang.Exception -> L68
            goto L69
        L68:
        L69:
            if (r5 != 0) goto L7d
            java.lang.String r2 = "getAllCellInfo"
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> L76
            java.lang.Object r1 = l111l11111lIl(r1, r2, r3)     // Catch: java.lang.Exception -> L76
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Exception -> L76
            goto L77
        L76:
            r1 = r0
        L77:
            android.telephony.CellLocation r5 = r8.l1111l111111Il(r1)     // Catch: java.lang.Exception -> L82
            goto L7d
        L7c:
            r5 = r0
        L7d:
            if (r5 == 0) goto L82
            android.telephony.CellLocation r5 = (android.telephony.CellLocation) r5     // Catch: java.lang.Exception -> L82
            r0 = r5
        L82:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.smantifraud.l111l11111I1l.l11l1111Il.l11l1111I1l():android.telephony.CellLocation");
    }

    private Object l11l1111lIIl() {
        String str;
        int l111l1111lIl = l111l1111lIl();
        if (l111l1111lIl == 0) {
            str = "phone";
        } else if (l111l1111lIl == 1) {
            str = "phone_msim";
        } else {
            if (l111l1111lIl != 2) {
                return null;
            }
            str = "phone2";
        }
        return l1111l111111Il(str);
    }

    public final String l1111l111111Il() {
        try {
            Object obj = this.l1111l111111Il;
            if (obj == null) {
                return "";
            }
            String str = (String) com.ishumei.smantifraud.l111l1111llIl.l111l11111I1l.l1111l111111Il(obj, "getSimOperator");
            if (str != null) {
                try {
                    if (str.isEmpty()) {
                    }
                } catch (Exception unused) {
                }
                return str;
            }
            String str2 = (String) com.ishumei.smantifraud.l111l1111llIl.l111l11111I1l.l1111l111111Il(this.l1111l111111Il, "getNetworkOperatorName");
            return str2 == null ? "" : str2;
        } catch (Exception unused2) {
            return "";
        }
    }

    public final String l111l11111Il() {
        try {
            Object l1111l111111Il = l1111l111111Il("phone");
            Method declaredMethod = l1111l111111Il.getClass().getDeclaredMethod("getSimCountryIso", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(l1111l111111Il, new Object[0]);
        } catch (Exception unused) {
            return "";
        }
    }

    public final HashMap<String, String> l111l11111lIl() {
        String str;
        int checkPermission;
        int checkPermission2;
        String str2;
        int baseStationLongitude;
        Object obj;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            PackageManager packageManager = this.l111l11111lIl.getPackageManager();
            checkPermission = packageManager.checkPermission(g.f36121g, this.l111l11111lIl.getPackageName());
            checkPermission2 = packageManager.checkPermission(g.f36122h, this.l111l11111lIl.getPackageName());
        } catch (Exception unused) {
            str = "";
        }
        if (checkPermission != 0 && checkPermission2 != 0) {
            return hashMap;
        }
        str = "NOPERM";
        try {
            CellLocation l11l1111I1l = l11l1111I1l();
            if (l11l1111I1l == null && (obj = this.l1111l111111Il) != null) {
                l11l1111I1l = (CellLocation) com.ishumei.smantifraud.l111l1111llIl.l111l11111I1l.l1111l111111Il(obj, "getCellLocation");
            }
            if (l11l1111I1l != null) {
                if (l11l1111I1l instanceof GsmCellLocation) {
                    hashMap.put("type", "gsm");
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) l11l1111I1l;
                    hashMap.put("cid", String.valueOf(gsmCellLocation.getCid()));
                    str2 = "lac";
                    baseStationLongitude = gsmCellLocation.getLac();
                } else if (l11l1111I1l instanceof CdmaCellLocation) {
                    hashMap.put("type", "cdma");
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) l11l1111I1l;
                    hashMap.put("bid", String.valueOf(cdmaCellLocation.getBaseStationId()));
                    hashMap.put("nid", String.valueOf(cdmaCellLocation.getNetworkId()));
                    hashMap.put("sid", String.valueOf(cdmaCellLocation.getSystemId()));
                    hashMap.put("lat", String.valueOf(cdmaCellLocation.getBaseStationLatitude()));
                    str2 = "lng";
                    baseStationLongitude = cdmaCellLocation.getBaseStationLongitude();
                }
                hashMap.put(str2, String.valueOf(baseStationLongitude));
            }
        } catch (Exception unused2) {
            hashMap.put("type", str);
            return hashMap;
        }
        return hashMap;
    }

    public final String l111l1111l1Il() {
        try {
            Object l1111l111111Il = l1111l111111Il("phone");
            Method declaredMethod = l1111l111111Il.getClass().getDeclaredMethod("getNetworkCountryIso", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(l1111l111111Il, new Object[0]);
        } catch (Exception unused) {
            return "";
        }
    }
}
