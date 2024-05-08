package gd;

import android.database.Cursor;
import android.text.TextUtils;
import com.tanx.exposer.achieve.AdMonitorType;
import com.tanx.exposer.achieve.retry.AdMonitorRetryType;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import rc.c;
import rc.f;

/* compiled from: RequestWrapper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public long f49455a;

    /* renamed from: b, reason: collision with root package name */
    public String f49456b;

    /* renamed from: c, reason: collision with root package name */
    public String f49457c;

    /* renamed from: d, reason: collision with root package name */
    public String f49458d;

    /* renamed from: e, reason: collision with root package name */
    public AdMonitorType f49459e;

    /* renamed from: f, reason: collision with root package name */
    public String f49460f;

    /* renamed from: g, reason: collision with root package name */
    public f f49461g;

    /* renamed from: h, reason: collision with root package name */
    public final int f49462h;

    /* renamed from: i, reason: collision with root package name */
    public AtomicInteger f49463i;

    /* renamed from: j, reason: collision with root package name */
    public long f49464j;

    /* renamed from: k, reason: collision with root package name */
    public String f49465k;

    /* renamed from: l, reason: collision with root package name */
    public AdMonitorRetryType f49466l;

    public a(String str, String str2, AdMonitorType adMonitorType, String str3, String str4, int i10) {
        this.f49455a = -1L;
        this.f49463i = new AtomicInteger(0);
        this.f49466l = AdMonitorRetryType.MEMORY;
        this.f49456b = str;
        this.f49457c = str2;
        this.f49459e = adMonitorType;
        this.f49458d = str3;
        this.f49460f = str4;
        this.f49462h = i10;
        long currentTimeMillis = System.currentTimeMillis();
        this.f49465k = c.a(currentTimeMillis, "yyyy-MM-dd");
        this.f49464j = currentTimeMillis + 86400000;
    }

    public a(Cursor cursor) {
        this.f49455a = -1L;
        this.f49463i = new AtomicInteger(0);
        this.f49466l = AdMonitorRetryType.MEMORY;
        this.f49455a = cursor.getLong(cursor.getColumnIndex("id"));
        this.f49459e = AdMonitorType.valueOf(cursor.getString(cursor.getColumnIndex("monitor_type")));
        this.f49456b = cursor.getString(cursor.getColumnIndex("monitor_url"));
        this.f49457c = cursor.getString(cursor.getColumnIndex("monitor_original_url"));
        this.f49458d = cursor.getString(cursor.getColumnIndex("monitor_url_host"));
        this.f49460f = cursor.getString(cursor.getColumnIndex("monitor_url_hash"));
        this.f49463i = new AtomicInteger(cursor.getInt(cursor.getColumnIndex("retry_times")));
        this.f49462h = cursor.getInt(cursor.getColumnIndex("max_retry_times"));
        this.f49465k = cursor.getString(cursor.getColumnIndex("date"));
        this.f49464j = cursor.getLong(cursor.getColumnIndex("expire_time"));
        String string = cursor.getString(cursor.getColumnIndex("monitor_extra_params"));
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            this.f49461g = new f(string);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
