package com.kwad.components.core.k;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.e.c;
import java.text.SimpleDateFormat;
import java.util.Date;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat Mp = new SimpleDateFormat("yyyy-MM-dd");
    public int Mq;
    public long Mr;

    public final boolean j(int i10, int i11) {
        c.d("AdForceActiveInfo", "checkAndAddCount forceActiveIntervalHour: " + i10 + ", forceActiveThreshold: " + i11);
        if (this.Mr > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            String format = Mp.format(new Date(this.Mr));
            String format2 = Mp.format(new Date(currentTimeMillis));
            c.d("AdForceActiveInfo", "checkAndAddCount lastDate: " + format + ", currentDate: " + format2);
            if (!format.equals(format2)) {
                this.Mq = 0;
                oI();
                return true;
            }
            long j10 = this.Mr + (i10 * 60 * 60 * 1000);
            c.d("AdForceActiveInfo", "checkAndAddCount minTimestamp: " + j10 + ", currentActiveCount: " + this.Mq);
            if (j10 >= currentTimeMillis || this.Mq > i11) {
                return false;
            }
            oI();
            return true;
        }
        oI();
        return true;
    }

    public final void oI() {
        this.Mr = System.currentTimeMillis();
        this.Mq++;
        c.d("AdForceActiveInfo", "doAddCount, lastForceActiveTimestamp: " + this.Mr + ", currentActiveCount " + this.Mq);
    }
}
