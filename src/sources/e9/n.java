package e9;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.huawei.appgallery.agd.agdpro.R$id;
import com.huawei.appgallery.agd.agdpro.R$layout;
import com.huawei.appgallery.agd.agdpro.R$string;
import com.huawei.appgallery.agd.agdpro.impl.web.WebViewLauncher;
import com.huawei.appgallery.agd.core.impl.IAgdAd;
import com.huawei.appgallery.agd.core.impl.report.MaintKey;
import com.huawei.appgallery.agd.core.impl.report.OperationBi;
import com.huawei.appgallery.agd.pageframe.api.CardEventInfo;
import com.huawei.appgallery.agd.serverreq.utils.network.NetworkUtil;
import com.huawei.flexiblelayout.FLContext;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class n {
    public static /* synthetic */ void e(Activity activity, int i10) {
        if (activity != null && !activity.isFinishing()) {
            Context applicationContext = activity.getApplicationContext();
            String string = applicationContext.getResources().getString(i10);
            Toast toast = new Toast(applicationContext);
            View inflate = LayoutInflater.from(applicationContext).inflate(R$layout.toast_reward, (ViewGroup) null);
            ((TextView) inflate.findViewById(R$id.tv_toast_content)).setText(string);
            toast.setDuration(1);
            toast.setView(inflate);
            toast.show();
            return;
        }
        e.f48945d.w("CardActionDispatcher", "showToast#Activity invisible");
    }

    public final long a(IAgdAd iAgdAd) {
        long currentTimeMillis = System.currentTimeMillis();
        if (iAgdAd instanceof b) {
            currentTimeMillis = ((b) iAgdAd).c();
        }
        return System.currentTimeMillis() - currentTimeMillis;
    }

    @Nullable
    public final Activity b(@NonNull CardEventInfo cardEventInfo) {
        FLContext fLContext = cardEventInfo.flContext;
        if (fLContext != null && fLContext.getActivity() != null) {
            return cardEventInfo.flContext.getActivity();
        }
        e.f48945d.e("CardActionDispatcher", "handleClickOpenAppDetail getActivity fail");
        return null;
    }

    public final void c(@NonNull final Activity activity, @StringRes final int i10) {
        activity.runOnUiThread(new Runnable() { // from class: e9.m
            @Override // java.lang.Runnable
            public final void run() {
                n.e(activity, i10);
            }
        });
    }

    public final void d(String str, CardEventInfo cardEventInfo) {
        if (TextUtils.equals(cardEventInfo.clickSource, "btn")) {
            OperationBi.reportAdAreaOperate(OperationBi.ACTION_BUTTON_AREA, str, cardEventInfo.slotId);
        } else if (TextUtils.equals(cardEventInfo.clickSource, OperationBi.ACTION_SHAKE_AREA)) {
            OperationBi.reportAdAreaOperate(OperationBi.ACTION_SHAKE_AREA, str, cardEventInfo.slotId);
        } else {
            OperationBi.reportAdAreaOperate(OperationBi.ACTION_ICON_AREA, str, cardEventInfo.slotId);
        }
    }

    public final void f(@NonNull CardEventInfo cardEventInfo) {
        e eVar = e.f48945d;
        a.c("handleClickOpenWeb with clickInfo: ", cardEventInfo, eVar, "CardActionDispatcher");
        Activity b4 = b(cardEventInfo);
        if (!TextUtils.isEmpty(cardEventInfo.adWapUrl) && b4 != null) {
            if (!NetworkUtil.hasActiveNetwork(cardEventInfo.flContext.getContext())) {
                eVar.w("CardActionDispatcher", "showToast#Activity invisible");
                c(cardEventInfo.flContext.getActivity(), R$string.rewardad_no_network);
                t.e(cardEventInfo, MaintKey.EVENT_WAP_PAGE_START_ERROR, "rewardAd_no_network", cardEventInfo.adWapUrl);
                return;
            }
            try {
                WebViewLauncher.startWebViewActivity(b4, cardEventInfo);
                t.e(cardEventInfo, MaintKey.EVENT_WAP_PAGE_START_ERROR, "", cardEventInfo.adWapUrl);
                d("openWeb", cardEventInfo);
                g(cardEventInfo);
                return;
            } catch (Exception e2) {
                a.b("handleClickOpenWeb failed : ").append(e2.getMessage());
                t.e(cardEventInfo, MaintKey.EVENT_WAP_PAGE_START_ERROR, e2.getMessage(), cardEventInfo.adWapUrl);
                return;
            }
        }
        eVar.e("CardActionDispatcher", "handleClickOpenWeb webUrl or activity is empty");
        t.e(cardEventInfo, MaintKey.EVENT_WAP_PAGE_START_ERROR, "webUrl is empty", cardEventInfo.adWapUrl);
    }

    public final void g(CardEventInfo cardEventInfo) {
        if (TextUtils.equals(cardEventInfo.clickSource, "btn")) {
            t.c(2, cardEventInfo);
        } else {
            t.c(3, cardEventInfo);
        }
    }
}
