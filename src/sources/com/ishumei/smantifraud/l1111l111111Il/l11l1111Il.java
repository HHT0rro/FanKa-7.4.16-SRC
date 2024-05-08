package com.ishumei.smantifraud.l1111l111111Il;

import android.os.Build;
import com.ishumei.smantifraud.SmAntiFraud;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l11l1111Il {
    private final SmAntiFraud.SmOption l1111l111111Il;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class l1111l111111Il {
        private static final l11l1111Il l1111l111111Il = new l11l1111Il(0);

        private l1111l111111Il() {
        }
    }

    private l11l1111Il() {
        this.l1111l111111Il = SmAntiFraud.option;
    }

    public /* synthetic */ l11l1111Il(byte b4) {
        this();
    }

    public static l11l1111Il l1111l111111Il() {
        return l1111l111111Il.l1111l111111Il;
    }

    private l11l1111I1ll l111l11111lIl() {
        l11l1111I1ll l11l1111i1ll = new l11l1111I1ll();
        l11l1111i1ll.l11l1111I11l("exception");
        l11l1111i1ll.l111l1111llIl("android");
        l11l1111i1ll.l111l1111lIl("3.7.3");
        l11l1111i1ll.l11l1111I1ll(com.ishumei.smantifraud.l111l11111I1l.l111l11111lIl.l111l11111lIl());
        l11l1111i1ll.l11l1111Il(com.ishumei.smantifraud.l111l11111I1l.l111l11111lIl.l111l11111I1l());
        l11l1111i1ll.l111l1111lI1l(Build.VERSION.RELEASE);
        l11l1111i1ll.l11l1111lIIl(Build.MODEL);
        SmAntiFraud.SmOption smOption = this.l1111l111111Il;
        if (smOption != null) {
            l11l1111i1ll.l111l11111Il(smOption.l11l1111I1l());
            l11l1111i1ll.l111l1111l1Il(this.l1111l111111Il.l11l11IlIIll());
        }
        l11l1111i1ll.l111l11111lIl(com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il.l1111l111111Il().l111l11111Il());
        com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il.l1111l111111Il();
        l11l1111i1ll.l111l11111I1l("");
        l11l1111i1ll.l1111l111111Il(com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il.l1111l111111Il().l111l11111I1l());
        return l11l1111i1ll;
    }

    private static String l111l11111lIl(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            do {
                th.printStackTrace(printWriter);
                th = th.getCause();
            } while (th != null);
            printWriter.close();
            String obj = stringWriter.toString();
            return obj.length() > 4096 ? obj.substring(0, 4096) : obj;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String l1111l111111Il(Throwable th) {
        try {
            l11l1111I1ll l11l1111i1ll = new l11l1111I1ll();
            l11l1111i1ll.l11l1111I11l("exception");
            l11l1111i1ll.l111l1111llIl("android");
            l11l1111i1ll.l111l1111lIl("3.7.3");
            l11l1111i1ll.l11l1111I1ll(com.ishumei.smantifraud.l111l11111I1l.l111l11111lIl.l111l11111lIl());
            l11l1111i1ll.l11l1111Il(com.ishumei.smantifraud.l111l11111I1l.l111l11111lIl.l111l11111I1l());
            l11l1111i1ll.l111l1111lI1l(Build.VERSION.RELEASE);
            l11l1111i1ll.l11l1111lIIl(Build.MODEL);
            SmAntiFraud.SmOption smOption = this.l1111l111111Il;
            if (smOption != null) {
                l11l1111i1ll.l111l11111Il(smOption.l11l1111I1l());
                l11l1111i1ll.l111l1111l1Il(this.l1111l111111Il.l11l11IlIIll());
            }
            l11l1111i1ll.l111l11111lIl(com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il.l1111l111111Il().l111l11111Il());
            com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il.l1111l111111Il();
            l11l1111i1ll.l111l11111I1l("");
            l11l1111i1ll.l1111l111111Il(com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il.l1111l111111Il().l111l11111I1l());
            l11l1111i1ll.l11l1111I1l(l111l11111lIl(th));
            String l1111l111111Il2 = com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il(com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il(l11l1111i1ll, (Set<String>) null).toString().getBytes());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("organization", l11l1111i1ll.l1111l111111Il());
            jSONObject.put("os", "android");
            SmAntiFraud.SmOption smOption2 = this.l1111l111111Il;
            if (smOption2 != null) {
                jSONObject.put("appId", smOption2.l11l11IlIIll());
            }
            jSONObject.put("encode", 1);
            jSONObject.put("data", l1111l111111Il2);
            jSONObject.put("tn", "");
            jSONObject.put("ep", "");
            return jSONObject.toString();
        } catch (Throwable th2) {
            return th2.toString();
        }
    }
}
