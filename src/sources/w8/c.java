package w8;

import android.content.Context;
import android.content.Intent;
import com.heytap.msp.push.mode.BaseMode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class c implements d {
    public static List<BaseMode> b(Context context, Intent intent) {
        BaseMode a10;
        if (intent == null) {
            return null;
        }
        int i10 = 4096;
        try {
            i10 = Integer.parseInt(y8.a.d(intent.getStringExtra("type")));
        } catch (Exception e2) {
            y8.c.b("MessageParser--getMessageByIntent--Exception:" + e2.getMessage());
        }
        y8.c.a("MessageParser--getMessageByIntent--type:" + i10);
        ArrayList arrayList = new ArrayList();
        for (d dVar : t8.b.C().G()) {
            if (dVar != null && (a10 = dVar.a(context, i10, intent)) != null) {
                arrayList.add(a10);
            }
        }
        return arrayList;
    }
}
