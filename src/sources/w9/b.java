package w9;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.text.TextUtils;
import com.huawei.appgallery.coreservice.api.ApiCode;
import com.huawei.appgallery.coreservice.api.IConnectionResult;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b implements IConnectionResult {

    /* renamed from: a, reason: collision with root package name */
    public final int f54290a;

    /* renamed from: b, reason: collision with root package name */
    public final PendingIntent f54291b;

    /* renamed from: c, reason: collision with root package name */
    public final String f54292c;

    public b(int i10) {
        this(i10, null);
    }

    public b(int i10, PendingIntent pendingIntent) {
        this(i10, pendingIntent, ApiCode.getStatusCodeString(i10));
    }

    public b(int i10, PendingIntent pendingIntent, String str) {
        this.f54290a = i10;
        this.f54291b = pendingIntent;
        this.f54292c = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f54290a == bVar.f54290a && this.f54291b == null) {
            if (bVar.f54291b == null) {
                return true;
            }
        } else if (this.f54291b.equals(bVar.f54291b) && TextUtils.equals(this.f54292c, bVar.f54292c)) {
            return true;
        }
        return false;
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public String getErrorMessage() {
        return this.f54292c;
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public PendingIntent getResolution() {
        return this.f54291b;
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public int getStatusCode() {
        return this.f54290a;
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public boolean hasResolution() {
        return (this.f54290a == 0 || this.f54291b == null) ? false : true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f54290a), this.f54291b, this.f54292c});
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public void startResolutionForResult(Activity activity, int i10) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.f54291b.getIntentSender(), i10, null, 0, 0, 0);
        }
    }
}
