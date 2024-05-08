package com.huawei.qcardsupport.qcard;

import android.content.Context;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.qcardsupport.d;
import com.huawei.qcardsupport.qcard.cardmanager.CloudCardProvider;
import com.huawei.quickcard.QuickCardEngine;
import com.huawei.quickcard.flexiblelayoutadapter.FlexibleLayoutExpressionFactory;
import com.huawei.quickcard.views.image.ImageConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QCardSupport {

    /* renamed from: c, reason: collision with root package name */
    private static volatile QCardSupport f33145c;

    /* renamed from: a, reason: collision with root package name */
    private final Context f33146a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f33147b = false;

    private QCardSupport(Context context) {
        this.f33146a = context.getApplicationContext();
    }

    private void a(FLEngine fLEngine) {
        CloudCardProvider.getInstance(fLEngine);
        QuickCardEngine.initialize(fLEngine.getContext());
        QuickCardEngine.registerExpressionFactory(new FlexibleLayoutExpressionFactory());
        ImageConfig.setImageLoader(new d());
    }

    public static QCardSupport getInstance(Context context) {
        if (f33145c == null) {
            synchronized (QCardSupport.class) {
                if (f33145c == null) {
                    f33145c = new QCardSupport(context);
                }
            }
        }
        return f33145c;
    }

    public void initialize() {
        if (this.f33147b) {
            return;
        }
        synchronized (this) {
            if (this.f33147b) {
                return;
            }
            a(FLEngine.getInstance(this.f33146a));
            this.f33147b = true;
        }
    }
}
