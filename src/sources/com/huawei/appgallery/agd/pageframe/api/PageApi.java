package com.huawei.appgallery.agd.pageframe.api;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.common.FlavorApi;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.common.gcd.DispatchBlock;
import com.huawei.appgallery.agd.common.gcd.DispatchQoS;
import com.huawei.appgallery.agd.common.gcd.DispatchQueue;
import com.huawei.appgallery.agd.common.utils.FileUtil;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import com.huawei.appgallery.agd.core.impl.report.MaintData;
import com.huawei.appgallery.agd.core.impl.report.MaintKey;
import com.huawei.appgallery.agd.pageframe.PageFrameLog;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.log.LogcatNode;
import com.huawei.flexiblelayout.services.action.CardActionService;
import com.huawei.flexiblelayout.services.configuration.ServerUrlProvider;
import com.huawei.flexiblelayout.services.imageloader.ImageLoaderService;
import com.huawei.hmf.md.spec.jmessage;
import com.huawei.hmf.repository.ComponentRepository;
import com.huawei.hmf.services.internal.ApplicationContext;
import com.huawei.jmessage.api.EventSourceManager;
import com.huawei.ok3httpservice.api.Ok3HttpService;
import com.huawei.pnodesupport.api.FLPNodeSupport;
import com.huawei.qcardsupport.qcard.QCardSupport;
import com.huawei.qcardsupport.qcard.cardmanager.CloudCardProvider;
import com.huawei.qcardsupport.qcard.cardmanager.InputStreamProvider;
import com.huawei.quickcard.QuickCardEngine;
import com.huawei.quickcard.action.JsFunctionAction;
import com.huawei.quickcard.framework.ui.ComponentRegistry;
import com.huawei.quickcard.rating.component.Rating;
import com.huawei.quickcard.video.component.Video;
import com.huawei.serverrequest.api.service.HttpService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ConcurrentModificationException;
import org.json.JSONArray;
import u9.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class PageApi {

    /* renamed from: a, reason: collision with root package name */
    public static IPageCallback f27508a;

    /* renamed from: b, reason: collision with root package name */
    public static Context f27509b;

    public static void c(FLEngine fLEngine) {
        CloudCardProvider.getInstance(fLEngine).addStreamProvider(new InputStreamProvider() { // from class: com.huawei.appgallery.agd.pageframe.api.PageApi.3
            @Override // com.huawei.qcardsupport.qcard.cardmanager.InputStreamProvider
            @NonNull
            public InputStream open() throws IOException {
                return ApplicationWrapper.getInstance().getContext().getResources().getAssets().open("presetLayouts.json");
            }
        });
    }

    public static void d(Context context) {
        ((CardActionService) FLEngine.getInstance(context).getService(CardActionService.class)).registerActionHandler(new CardActionService.ActionHandler() { // from class: com.huawei.appgallery.agd.pageframe.api.a
            @Override // com.huawei.flexiblelayout.services.action.CardActionService.ActionHandler
            public final boolean onAction(FLContext fLContext, FLCell fLCell, CardActionService.Action action) {
                boolean e2;
                e2 = PageApi.e(fLContext, fLCell, action);
                return e2;
            }
        });
    }

    public static /* synthetic */ boolean e(FLContext fLContext, FLCell fLCell, CardActionService.Action action) {
        if (fLContext != null && fLCell != null && action != null) {
            PageFrameLog.LOG.i("PageApi", "action type: " + action.getType() + ",param: " + action.getParam());
            getCallBack().onCardAction(new CardEventInfo(fLContext, fLCell, action));
            return true;
        }
        PageFrameLog.LOG.e("PageApi", "onAction param null");
        return false;
    }

    public static void f() {
        String str;
        FLEngine fLEngine = FLEngine.getInstance(f27509b);
        try {
            fLEngine.registerService(HttpService.class, new Ok3HttpService(f27509b));
            CloudCardProvider.getInstance(fLEngine).setServerUrlProvider(new ServerUrlProvider() { // from class: com.huawei.appgallery.agd.pageframe.api.PageApi.1
                @Override // com.huawei.flexiblelayout.services.configuration.ServerUrlProvider
                public String getUrl() {
                    String quickCardUrl = FlavorApi.getQuickCardUrl();
                    PageFrameLog.LOG.i("PageApi", "page init quickUrl : " + quickCardUrl);
                    return quickCardUrl;
                }
            });
            str = "";
        } catch (ConcurrentModificationException unused) {
            str = "registerQuickCardUrl fail modification exception";
        } catch (Exception e2) {
            str = "registerQuickCardUrl fail " + e2.getMessage();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MaintBi.report(new MaintData.Builder(MaintKey.EVENT_AGD_GLOBAL_ERROR).setErrorCode(2L).setReason(str).build());
        PageFrameLog.LOG.e("PageApi", str);
    }

    public static void fetchPresetCardTemplates() {
        final FLEngine fLEngine = FLEngine.getInstance(ApplicationWrapper.getInstance().getContext());
        DispatchQueue.GLOBAL.async(DispatchQoS.SERIAL, new DispatchBlock() { // from class: com.huawei.appgallery.agd.pageframe.api.PageApi.2
            @Override // java.lang.Runnable
            public void run() {
                PageFrameLog.LOG.i("PageApi", "fetch preset template");
                PageApi.c(FLEngine.this);
            }
        });
    }

    public static IPageCallback getCallBack() {
        return f27508a;
    }

    public static Context getContext() {
        return f27509b;
    }

    public static boolean init(@NonNull Context context, String str, @NonNull IPageCallback iPageCallback) {
        PageFrameLog pageFrameLog = PageFrameLog.LOG;
        pageFrameLog.i("PageApi", "page init storeUrl: " + str);
        f27508a = iPageCallback;
        Context applicationContext = context.getApplicationContext();
        f27509b = applicationContext;
        ApplicationContext.setContext(applicationContext);
        ApplicationWrapper.init(f27509b);
        Log.setTag("AGDFLCore");
        Log.setLogNode(new LogcatNode());
        if (TextUtils.isEmpty(str)) {
            pageFrameLog.e("PageApi", "storeUrl url empty");
            return false;
        }
        QCardSupport.getInstance(f27509b).initialize();
        f();
        d(f27509b);
        ((ImageLoaderService) FLEngine.getInstance(f27509b).getService(ImageLoaderService.class)).registerImageLoader(new AgdGlideImageLoader());
        ComponentRegistry.register(new Rating());
        ComponentRegistry.register(new Video());
        QuickCardEngine.registerActions("jsFunction", JsFunctionAction.class);
        FLPNodeSupport.init(f27509b);
        FileUtil.deleteFile(new File(FileUtil.getImagesResourceRootDir()));
        EventSourceManager eventSourceManager = (EventSourceManager) ComponentRepository.getRepository().lookup(jmessage.name).create(EventSourceManager.class);
        eventSourceManager.register("appstatus", (String) new u9.a());
        eventSourceManager.register("ShakeEvent", (String) new c());
        return QuickCardEngine.isInitialized();
    }

    public static void release() {
        EventSourceManager eventSourceManager = (EventSourceManager) ComponentRepository.getRepository().lookup(jmessage.name).create(EventSourceManager.class);
        eventSourceManager.unregister("appstatus");
        eventSourceManager.unregister("ShakeEvent");
        QuickCardEngine.destroy(f27509b);
    }

    public static void saveCardTemplate(@NonNull JSONArray jSONArray) {
        String str;
        PageFrameLog.LOG.i("PageApi", "saveCardTemplate num: " + jSONArray.length());
        try {
            CloudCardProvider.getInstance(FLEngine.getInstance(ApplicationWrapper.getInstance().getContext())).addFromArray(jSONArray);
            str = "";
        } catch (ConcurrentModificationException unused) {
            str = "saveCardTemplate fail modification exception";
        } catch (Exception e2) {
            str = "saveCardTemplate fail " + e2.getMessage();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MaintBi.report(new MaintData.Builder(MaintKey.EVENT_AGD_GLOBAL_ERROR).setErrorCode(2L).setReason(str).build());
        PageFrameLog.LOG.e("PageApi", str);
    }
}
