package m9;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.core.impl.store.configlist.ConfigListResponse;
import com.huawei.appgallery.agd.core.internalapi.IQueryConfigList;
import com.huawei.appgallery.agd.core.internalapi.IReloadWhiteList;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class j {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a implements IQueryConfigList.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IReloadWhiteList f51971a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f51972b;

        public a(IReloadWhiteList iReloadWhiteList, CountDownLatch countDownLatch) {
            this.f51971a = iReloadWhiteList;
            this.f51972b = countDownLatch;
        }

        @Override // com.huawei.appgallery.agd.core.internalapi.IQueryConfigList.Callback
        public void onFail(int i10, String str) {
            n9.a.f52175d.e("WebUrlUtils", "getConfigList failed, errorCode = " + i10 + ", msg = " + str);
            this.f51972b.countDown();
        }

        @Override // com.huawei.appgallery.agd.core.internalapi.IQueryConfigList.Callback
        public void onSuccess(ConfigListResponse configListResponse) {
            this.f51971a.reloadWhiteListSuccess();
            this.f51972b.countDown();
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (str.contains("{")) {
                str = str.replaceAll("\\{", "");
            }
            if (str.contains(com.alipay.sdk.util.i.f4738d)) {
                str = str.replaceAll("\\}", "");
            }
            return new URI(str).getHost();
        } catch (Exception e2) {
            n9.a.f52175d.e("WebUrlUtils", "get host error " + e2.getClass().getSimpleName());
            return null;
        }
    }

    public static void b(Activity activity, @NonNull String str) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str));
            activity.startActivity(intent);
        } catch (Exception e2) {
            n9.a.f52175d.e("WebUrlUtils", "jump browser failed: " + e2.getMessage());
        }
    }

    public static boolean c(WebView webView, IReloadWhiteList iReloadWhiteList) {
        String a10 = a(new com.huawei.appgallery.agd.core.internalapi.b(webView).b());
        if (TextUtils.isEmpty(a10)) {
            return false;
        }
        if (i.e().a().contains(a10)) {
            return true;
        }
        if (!iReloadWhiteList.needReloadWhiteList()) {
            return false;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        i.e().c(new a(iReloadWhiteList, countDownLatch));
        try {
            countDownLatch.await();
        } catch (Exception e2) {
            n9.a.f52175d.e("WebUrlUtils", "checkWebUrlWithWhiteList: InterruptedException " + e2.getMessage(), e2);
        }
        String a11 = a(new com.huawei.appgallery.agd.core.internalapi.b(webView).b());
        if (TextUtils.isEmpty(a11)) {
            return false;
        }
        return i.e().a().contains(a11);
    }

    public static boolean d(@NonNull String str) {
        return Pattern.compile("^(https://)", 2).matcher(str).find();
    }
}
