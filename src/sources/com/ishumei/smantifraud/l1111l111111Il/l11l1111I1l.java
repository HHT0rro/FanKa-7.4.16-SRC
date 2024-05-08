package com.ishumei.smantifraud.l1111l111111Il;

import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import com.ishumei.smantifraud.AbsDetector;
import com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l11l1111I1l extends AbsDetector {
    @Override // com.ishumei.smantifraud.AbsDetector
    public final String getEventId() {
        return "devicefieldcheck";
    }

    public final JSONObject l1111l111111Il() {
        l11l1111I11l l11l1111i11l = new l11l1111I11l();
        l11l1111i11l.l1111l111111Il(System.currentTimeMillis());
        l11l1111i11l.l1111l111111Il(getAndIncrementSerial());
        l11l1111i11l.l1111l111111Il(com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l111l1111llIl());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l111l11111I1l());
        l11l1111i11l.l111l11111lIl(sb2.toString());
        StatFs l111l11111Il = com.ishumei.smantifraud.l111l11111I1l.l111l1111llIl.l111l11111Il();
        if (l111l11111Il != null) {
            l11l1111i11l.l1111l111111Il(Long.valueOf(l111l11111Il.getAvailableBytes()));
            l11l1111i11l.l111l11111Il(Long.valueOf(l111l11111Il.getTotalBytes()));
        }
        l11l1111i11l.l111l11111I1l(Build.getRadioVersion());
        l11l1111i11l.l111l11111lIl(l1111l111111Il.AnonymousClass1.l1111l111111Il());
        l11l1111i11l.l111l11111Il(com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l111l1111lIl());
        l11l1111i11l.l111l11111lIl(Long.valueOf(com.ishumei.smantifraud.l111l11111I1l.l11l1111I1l.l111l11111lIl()));
        l11l1111i11l.l1111l111111Il(Integer.valueOf(com.ishumei.smantifraud.l111l11111I1l.l111l1111l1Il.l111l11111lIl()));
        l11l1111i11l.l111l11111lIl(Integer.valueOf(Debug.isDebuggerConnected() ? 1 : 0));
        l11l1111i11l.l111l1111l1Il(com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il.getFilesDir().toString());
        l11l1111i11l.l111l11111I1l(Long.valueOf(com.ishumei.smantifraud.l111l11111I1l.l111l1111l1Il.l111l11111Il()));
        l11l1111i11l.l1111l111111Il(com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l111l11111lIl());
        l11l1111i11l.l111l1111llIl(Build.VERSION.RELEASE);
        l11l1111i11l.l111l1111lI1l(com.ishumei.smantifraud.l111l11111I1l.l111l1111lIl.l1111l111111Il());
        l11l1111i11l.l111l1111lIl(com.ishumei.smantifraud.l111l11111I1l.l111l1111llIl.l1111l111111Il());
        l11l1111i11l.l1111l111111Il(com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il.l1111l111111Il().l111l11111I1l());
        l11l1111i11l.l11l1111lIIl("3.7.3");
        return l11l1111i11l.l1111l111111Il();
    }
}
