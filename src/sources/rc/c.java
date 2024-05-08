package rc;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: Utils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c {
    public static String a(long j10, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        return new SimpleDateFormat(str).format(calendar.getTime());
    }
}
