package com.huawei.quickcard.base.bi;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.utils.CardThreadUtils;
import com.huawei.quickcard.base.utils.NetworkUtil;
import com.huawei.quickcard.base.utils.QuickCardPlatformUtils;
import com.huawei.quickcard.base.utils.QuickReportUtils;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardReporter {

    /* renamed from: c, reason: collision with root package name */
    private static final String f33310c = "QC01";

    /* renamed from: d, reason: collision with root package name */
    private static final String f33311d = "QC02";

    /* renamed from: e, reason: collision with root package name */
    private static final String f33312e = "QC04";

    /* renamed from: f, reason: collision with root package name */
    private static final String f33313f = "QC05";

    /* renamed from: g, reason: collision with root package name */
    private static final String f33314g = "initialize";

    /* renamed from: h, reason: collision with root package name */
    private static final String f33315h = "renderQuickCard";

    /* renamed from: i, reason: collision with root package name */
    private static final String f33316i = "bindData";

    /* renamed from: j, reason: collision with root package name */
    private static final String f33317j = "downloadCard";

    /* renamed from: a, reason: collision with root package name */
    private CardReportBean f33318a;

    /* renamed from: b, reason: collision with root package name */
    private Context f33319b;

    private CardReporter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        a(this.f33319b, this.f33318a);
        CardReportHelper.onEvent(this.f33319b, f33312e, this.f33318a.convertToMap());
        Iterator<LazyReportBean> it = CardReportHelper.getLazyReportData().iterator2();
        while (it.hasNext()) {
            LazyReportBean next = it.next();
            CardReportHelper.onEvent(this.f33319b, next.getEventId(), next.getReportData());
        }
        CardReportHelper.clearLazyData();
    }

    private void b(final String str) {
        CardThreadUtils.runOnReportThread(new Runnable() { // from class: com.huawei.quickcard.base.bi.b
            @Override // java.lang.Runnable
            public final void run() {
                CardReporter.this.a(str);
            }
        });
    }

    public static CardReporter from(@NonNull Context context) {
        CardReporter cardReporter = new CardReporter();
        cardReporter.f33319b = context.getApplicationContext();
        cardReporter.f33318a = new CardReportBean();
        return cardReporter;
    }

    public CardReporter bean(CardReportBean cardReportBean) {
        this.f33318a = cardReportBean;
        return this;
    }

    public CardReporter begin() {
        this.f33318a.setStartTime(System.currentTimeMillis());
        return this;
    }

    public CardReporter code(int i10) {
        this.f33318a.setErrorCode(i10);
        return this;
    }

    public CardReporter end() {
        this.f33318a.setEndTime(System.currentTimeMillis());
        return this;
    }

    public CardReporter fail(int i10, String str) {
        this.f33318a.setErrorCode(i10);
        this.f33318a.setErrorMsg(str);
        return this;
    }

    public CardReporter msg(String str) {
        this.f33318a.setErrorMsg(str);
        return this;
    }

    public void reportBindData() {
        this.f33318a.setType(f33316i);
        b(f33313f);
    }

    public void reportDownload() {
        this.f33318a.setType(f33317j);
        this.f33318a.setNetwork(NetworkUtil.getNetworkType(this.f33319b));
        b(f33311d);
    }

    public void reportInit(boolean z10) {
        this.f33318a.setType(f33314g);
        if (z10) {
            reportLater(f33310c);
        } else {
            b(f33310c);
        }
    }

    public void reportLater(String str) {
        LazyReportBean lazyReportBean = new LazyReportBean();
        a(this.f33319b, this.f33318a);
        lazyReportBean.setReportData(this.f33318a.convertToMap());
        lazyReportBean.setEventId(str);
        CardReportHelper.putLazyReportData(lazyReportBean);
    }

    public void reportRender() {
        this.f33318a.setType(f33315h);
        CardThreadUtils.runOnReportThread(new Runnable() { // from class: com.huawei.quickcard.base.bi.a
            @Override // java.lang.Runnable
            public final void run() {
                CardReporter.this.a();
            }
        });
    }

    public CardReporter storeUri(String str) {
        this.f33318a.setStoreUrl(str);
        return this;
    }

    public CardReporter success() {
        this.f33318a.setErrorMsg("success");
        this.f33318a.setErrorCode(0);
        return this;
    }

    public CardReporter uri(String str) {
        this.f33318a.setQuickCardUri(str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        a(this.f33319b, this.f33318a);
        CardReportHelper.onEvent(this.f33319b, str, this.f33318a.convertToMap());
    }

    private static void a(Context context, @NonNull CardReportBean cardReportBean) {
        cardReportBean.setEngineVersion(QuickCardPlatformUtils.getEngineVer());
        cardReportBean.setDeviceModel(Build.MODEL);
        cardReportBean.setHostPkg(QuickReportUtils.getPackageName(context));
        cardReportBean.setHostVer(QuickReportUtils.getPackageVer(context));
    }
}
