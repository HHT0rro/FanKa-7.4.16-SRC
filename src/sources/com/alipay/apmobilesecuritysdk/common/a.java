package com.alipay.apmobilesecuritysdk.common;

import android.content.Context;
import com.alimm.tanx.core.web.cache.utils.TimeUtils;
import com.alipay.apmobilesecuritysdk.e.h;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class a {
    public static boolean a(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(h.e(context));
        return a(arrayList) || a(new ArrayList<String>() { // from class: com.alipay.apmobilesecuritysdk.common.RushTimeUtil$1
            {
                add("2018-06-17&2018-06-18");
                add("2018-09-08&2018-09-09");
                add("2018-11-10&2018-11-11");
                add("2018-12-11&2018-12-12");
                add("2019-06-17&2019-06-18");
                add("2019-09-08&2019-09-09");
                add("2019-11-10&2019-11-11");
                add("2019-12-11&2019-12-12");
                add("2020-06-17&2020-06-18");
                add("2020-09-08&2020-09-09");
                add("2020-11-10&2020-11-11");
                add("2020-12-11&2020-12-12");
                add("2021-06-17&2021-06-18");
                add("2021-09-08&2021-09-09");
                add("2021-11-10&2021-11-11");
                add("2021-12-11&2021-12-12");
                add("2022-06-17&2022-06-18");
                add("2022-09-08&2022-09-09");
                add("2022-11-10&2022-11-11");
                add("2022-12-11&2022-12-12");
            }
        });
    }

    private static boolean a(List<String> list) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeUtils.STARD_FROMAT);
        simpleDateFormat.setLenient(false);
        int random = ((int) (Math.random() * 24.0d * 60.0d * 60.0d)) * 1;
        try {
            Iterator<String> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                String[] split = iterator2.next().split("&");
                if (split != null && split.length == 2) {
                    Date date = new Date();
                    Date parse = simpleDateFormat.parse(split[0] + " 00:00:00");
                    Date parse2 = simpleDateFormat.parse(split[1] + " 23:59:59");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(parse2);
                    calendar.add(13, random);
                    Date time = calendar.getTime();
                    if (date.after(parse) && date.before(time)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
