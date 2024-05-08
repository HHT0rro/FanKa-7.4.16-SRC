package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import com.alibaba.security.common.track.model.TrackConstants;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.a.a;
import com.bytedance.pangle.c.b;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.h;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.e;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.i;
import com.bytedance.pangle.util.l;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final h f10843a = h.a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class a extends IOException {
        public /* synthetic */ a(String str, byte b4) {
            this(str);
        }

        public /* synthetic */ a(String str, Throwable th, byte b4) {
            this(str, th);
        }

        private a(String str) {
            super(str);
        }

        private a(String str, Throwable th) {
            super(str, th);
        }
    }

    public static boolean a(final File file, final String str, final int i10) {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useOpt;");
        final boolean[] zArr = {false};
        try {
            h hVar = f10843a;
            hVar.a(1000, 0, str, i10, null);
            com.bytedance.pangle.log.a a10 = com.bytedance.pangle.log.a.a(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
            a(com.bytedance.pangle.c.b.f10641e, b.a.f10665r, str, i10, -1L, null);
            int b4 = l.a().b(str, i10, "install");
            int b10 = l.a().b(str, i10, TrackConstants.Method.LOAD);
            int removeApkEntryFlag = GlobalParam.getInstance().getRemoveApkEntryFlag(str);
            if (b4 > 3 || b10 > 3) {
                removeApkEntryFlag = 0;
            }
            SharedPreferences.Editor edit = l.a().f11001a.edit();
            edit.putInt("remove_entry_flag_" + str + "_" + i10, removeApkEntryFlag);
            edit.apply();
            l.a().c(str, i10, false);
            g.a(com.bytedance.pangle.d.c.a(str, i10));
            com.bytedance.pangle.a.a.a(new a.InterfaceC0117a() { // from class: com.bytedance.pangle.plugin.b.1
                @Override // com.bytedance.pangle.a.a.InterfaceC0117a
                public final void a() {
                    b.a(File.this, str, i10, stringBuffer);
                }
            }, new a.InterfaceC0117a() { // from class: com.bytedance.pangle.plugin.b.2
                @Override // com.bytedance.pangle.a.a.InterfaceC0117a
                public final void a() {
                    final Map f10 = b.f(File.this, str, i10, stringBuffer);
                    b.c(File.this, str, i10, stringBuffer);
                    b.a(b.g(File.this, str, i10, stringBuffer), str, i10, stringBuffer);
                    if (!i.f() && !i.b()) {
                        b.a(str, i10, f10, stringBuffer);
                        zArr[0] = b.a(str, i10, false, stringBuffer);
                        b.a(str, i10);
                    } else {
                        final boolean[] zArr2 = {false};
                        com.bytedance.pangle.a.a.a(new a.InterfaceC0117a() { // from class: com.bytedance.pangle.plugin.b.2.1
                            @Override // com.bytedance.pangle.a.a.InterfaceC0117a
                            public final void a() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                b.a(str, i10, f10, stringBuffer);
                            }
                        }, new a.InterfaceC0117a() { // from class: com.bytedance.pangle.plugin.b.2.2
                            @Override // com.bytedance.pangle.a.a.InterfaceC0117a
                            public final void a() {
                                boolean[] zArr3 = zArr2;
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                zArr3[0] = b.h(File.this, str, i10, stringBuffer);
                            }
                        });
                        zArr[0] = b.a(str, i10, zArr2[0], stringBuffer);
                    }
                }
            });
            g.a(file);
            a(com.bytedance.pangle.c.b.f10642f, b.a.f10666s, str, i10, a10.a(), stringBuffer.toString());
            a10.a("success");
            hVar.a(1100, 0, str, i10, null);
            return true;
        } catch (Throwable th) {
            if (th instanceof a) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed.", th);
            } else {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", th);
                a(com.bytedance.pangle.c.b.f10642f, b.a.f10667t, str, i10, -1L, stringBuffer.toString());
                f10843a.a(1100, -1, str, i10, th);
            }
            if (zArr[0]) {
                l.a().a(str, i10, "install");
            }
            return false;
        }
    }

    public static /* synthetic */ void c(File file, String str, int i10, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        byte b4 = 0;
        try {
            try {
                PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 4096);
                PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 4096);
                List asList = Arrays.asList(packageInfo.requestedPermissions);
                String[] strArr = packageArchiveInfo.requestedPermissions;
                if (strArr != null && strArr.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : packageArchiveInfo.requestedPermissions) {
                        if (!asList.contains(str2)) {
                            arrayList.add(str2);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        ZeusLogger.w("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        if (GlobalParam.getInstance().checkPermission()) {
                            throw new a("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)), b4);
                        }
                    }
                }
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f10642f, b.a.f10669v, str, i10, -1L, null);
                f10843a.a(1100, -4, str, i10, e2);
                throw new a("安装包权限校验失败", e2, b4);
            }
        } finally {
            stringBuffer.append("checkPermissions cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, List<ZipEntry>> f(File file, String str, int i10, StringBuffer stringBuffer) {
        String str2 = "插件包包含so不符合宿主ABI类型";
        if (!GlobalParam.getInstance().checkMatchHostAbi()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        byte b4 = 0;
        try {
            try {
                e<Boolean, Map<String, List<ZipEntry>>> a10 = com.bytedance.pangle.d.b.a(file);
                boolean booleanValue = a10.f10992a.booleanValue();
                Map<String, List<ZipEntry>> map = a10.f10993b;
                if (booleanValue) {
                    return map;
                }
                throw new a(str2, b4);
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f10642f, b.a.A, str, i10, -1L, null);
                f10843a.a(1100, -5, str, i10, e2);
                throw new a(str2, e2, b4);
            }
        } finally {
            stringBuffer.append("checkMatchHostAbi cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(File file, String str, int i10, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        String b4 = com.bytedance.pangle.d.c.b(str, i10);
        try {
            try {
                com.bytedance.pangle.util.h.a(file.getAbsolutePath(), b4);
                return b4;
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f10642f, b.a.f10670w, str, i10, -1L, null);
                f10843a.a(1100, -6, str, i10, e2);
                throw new a("安装包拷贝失败", e2, (byte) 0);
            }
        } finally {
            stringBuffer.append("copyApk cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    /*  JADX ERROR: Types fix failed
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:183)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:242)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x023b: MOVE (r9 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:92:0x023b */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x023f: MOVE (r9 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:88:0x023f */
    public static boolean h(java.io.File r21, java.lang.String r22, int r23, java.lang.StringBuffer r24) {
        /*
            Method dump skipped, instructions count: 619
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.plugin.b.h(java.io.File, java.lang.String, int, java.lang.StringBuffer):boolean");
    }

    private static void a(String str, int i10, @NonNull String str2, int i11, long j10, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt(MonitorConstants.STATUS_CODE, com.bytedance.pangle.log.b.a(Integer.valueOf(i10)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i11)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.b.b(Long.valueOf(j10))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.b.a(str3));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    public static /* synthetic */ void a(File file, String str, int i10, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (com.bytedance.pangle.g.e.a(file.getAbsolutePath(), str)) {
                } else {
                    throw new RuntimeException("安装包签名校验失败[1]");
                }
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f10642f, b.a.f10668u, str, i10, -1L, null);
                f10843a.a(1100, -3, str, i10, e2);
                throw new a(e2.getMessage(), e2, (byte) 0);
            }
        } finally {
            stringBuffer.append("checkSignature cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    public static /* synthetic */ void a(String str, String str2, int i10, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        byte b4 = 0;
        int a10 = new com.bytedance.pangle.res.a.c().a(new File(str), false, sb2);
        stringBuffer.append(a10 == 100 ? "modifyRes" : "noModifyRes");
        stringBuffer.append(" cost:");
        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(";");
        if (a10 == 100 || a10 == 200) {
            return;
        }
        String sb3 = sb2.toString();
        a(com.bytedance.pangle.c.b.f10642f, b.a.B, str2, i10, -1L, sb3);
        f10843a.a(1100, -2, str2, i10, null);
        throw new a("modifyRes failed. result = " + a10 + ", errorLog = " + sb3, b4);
    }

    public static /* synthetic */ void a(String str, int i10, Map map, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.d.b.a(new File(com.bytedance.pangle.d.c.b(str, i10)), new File(com.bytedance.pangle.d.c.d(str, i10)), str, (Map<String, List<ZipEntry>>) map);
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f10642f, b.a.f10671x, str, i10, -1L, null);
                f10843a.a(1100, -7, str, i10, e2);
                throw new a("安装包动态库拷贝失败", e2, (byte) 0);
            }
        } finally {
            stringBuffer.append("copySo cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    public static /* synthetic */ boolean a(String str, int i10, boolean z10, StringBuffer stringBuffer) {
        int b4 = l.a().b(str, i10);
        boolean z11 = (b4 & 1) != 0;
        boolean z12 = (b4 & 2) != 0;
        if (!z11 && !z12) {
            stringBuffer.append("removeEntry skip;");
            return false;
        }
        boolean z13 = z10 && z11;
        String b10 = com.bytedance.pangle.d.c.b(str, i10);
        long currentTimeMillis = System.currentTimeMillis();
        boolean a10 = com.bytedance.pangle.util.b.b.a(b10, z13, z12, str, i10, 1);
        stringBuffer.append("removeEntry cost:");
        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(";");
        return a10;
    }

    public static /* synthetic */ void a(String str, int i10) {
        byte b4 = 0;
        try {
            if (i.e() || i.g()) {
                l.a().b(str, i10, false);
                com.bytedance.pangle.e.b.a(Zeus.getAppApplication()).edit().putInt(str, i10).apply();
                f.a();
            }
        } catch (Exception e2) {
            a(com.bytedance.pangle.c.b.f10642f, b.a.f10673z, str, i10, -1L, null);
            throw new a("dexOpt2失败", e2, b4);
        }
    }
}
