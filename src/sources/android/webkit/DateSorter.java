package android.webkit;

import android.content.Context;
import android.content.res.Resources;
import android.util.PluralsMessageFormatter;
import com.android.icu.text.DateSorterBridge;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DateSorter {
    public static final int DAY_COUNT = 5;
    private static final String LOGTAG = "webkit";
    private static final int NUM_DAYS_AGO = 7;
    private long[] mBins = new long[4];
    private String[] mLabels = new String[5];

    public DateSorter(Context context) {
        Resources resources = context.getResources();
        Calendar c4 = Calendar.getInstance();
        beginningOfDay(c4);
        this.mBins[0] = c4.getTimeInMillis();
        c4.add(6, -1);
        this.mBins[1] = c4.getTimeInMillis();
        c4.add(6, -6);
        this.mBins[2] = c4.getTimeInMillis();
        c4.add(6, 7);
        c4.add(2, -1);
        this.mBins[3] = c4.getTimeInMillis();
        Locale locale = resources.getConfiguration().locale;
        DateSorterBridge dateSorterBridge = DateSorterBridge.createInstance(locale == null ? Locale.getDefault() : locale);
        this.mLabels[0] = dateSorterBridge.getToday();
        this.mLabels[1] = dateSorterBridge.getYesterday();
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("count", 7);
        this.mLabels[2] = PluralsMessageFormatter.format(resources, arguments, 17040636);
        this.mLabels[3] = context.getString(17040635);
        this.mLabels[4] = context.getString(17040997);
    }

    public int getIndex(long time) {
        for (int i10 = 0; i10 < 4; i10++) {
            if (time > this.mBins[i10]) {
                return i10;
            }
        }
        return 4;
    }

    public String getLabel(int index) {
        if (index < 0 || index >= 5) {
            return "";
        }
        return this.mLabels[index];
    }

    public long getBoundary(int index) {
        if (index < 0 || index > 4) {
            index = 0;
        }
        if (index == 4) {
            return Long.MIN_VALUE;
        }
        return this.mBins[index];
    }

    private void beginningOfDay(Calendar c4) {
        c4.set(11, 0);
        c4.set(12, 0);
        c4.set(13, 0);
        c4.set(14, 0);
    }
}
