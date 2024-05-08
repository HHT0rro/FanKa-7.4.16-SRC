package w9;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.common.grs.AgdDataSp;
import com.huawei.hms.framework.network.grs.GrsApp;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class i {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f54309c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static i f54310d;

    /* renamed from: a, reason: collision with root package name */
    public String f54311a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f54312b = "";

    public static i b() {
        i iVar;
        synchronized (f54309c) {
            if (f54310d == null) {
                f54310d = new i();
            }
            iVar = f54310d;
        }
        return iVar;
    }

    public String a(Context context) {
        String a10 = new g(context).a(AgdDataSp.AGD_DATA_GRS_APP_NAME, "");
        this.f54312b = a10;
        return a10;
    }

    public void c(@NonNull Context context, String str) {
        if (str == null) {
            str = "";
        }
        if (this.f54312b.equals(str)) {
            return;
        }
        this.f54312b = str;
        new g(context).b(AgdDataSp.AGD_DATA_GRS_APP_NAME, str);
    }

    public String d(Context context) {
        String a10 = new g(context).a(AgdDataSp.AGD_DATA_HOMECOUNTRY, "");
        this.f54311a = a10;
        if (TextUtils.isEmpty(a10)) {
            this.f54311a = GrsApp.getInstance().getIssueCountryCode(context);
        }
        return this.f54311a;
    }

    public void e(@NonNull Context context, String str) {
        if (str == null) {
            str = "";
        }
        if (this.f54311a.equals(str)) {
            return;
        }
        this.f54311a = str;
        new g(context).b(AgdDataSp.AGD_DATA_HOMECOUNTRY, str);
    }
}
