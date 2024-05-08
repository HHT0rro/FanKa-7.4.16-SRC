package com.huawei.flexiblelayout;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLNodeData;
import com.huawei.flexiblelayout.script.IScriptService;
import com.huawei.flexiblelayout.script.impl.LocalStorage;
import com.huawei.flexiblelayout.services.task.TaskHandler;
import com.huawei.flexiblelayout.version.Version;
import com.huawei.flexiblelayout.view.LayoutScroller;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLContext {

    /* renamed from: e, reason: collision with root package name */
    private static final Version f27690e = new Version();

    /* renamed from: a, reason: collision with root package name */
    private final FLayout f27691a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f27692b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutScroller f27693c;

    /* renamed from: d, reason: collision with root package name */
    private volatile LocalStorage f27694d;

    public FLContext(FLayout fLayout, Context context) {
        this.f27691a = fLayout;
        this.f27692b = context;
    }

    public static FLNodeData getRootNodeData(FLCardData fLCardData) {
        if (fLCardData == null) {
            return null;
        }
        while (fLCardData.getParent() != null) {
            fLCardData = fLCardData.getParent();
        }
        if (fLCardData instanceof FLNodeData) {
            return (FLNodeData) fLCardData;
        }
        return null;
    }

    public Activity getActivity() {
        Context context = this.f27692b;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public Context getContext() {
        return this.f27692b;
    }

    public FLayout getFLayout() {
        return this.f27691a;
    }

    @NonNull
    public IScriptService getScriptService() {
        return this.f27691a.a();
    }

    public LayoutScroller getScroller() {
        if (this.f27693c == null) {
            this.f27693c = new LayoutScroller(this.f27691a);
        }
        return this.f27693c;
    }

    public TaskHandler getTaskHandler(FLCardData fLCardData) {
        FLNodeData rootNodeData = getRootNodeData(fLCardData);
        if (rootNodeData != null) {
            return rootNodeData.getTaskHandler();
        }
        return null;
    }

    @NonNull
    public LocalStorage localStorage() {
        if (this.f27694d == null) {
            synchronized (this) {
                if (this.f27694d == null) {
                    this.f27694d = new LocalStorage(this.f27692b);
                }
            }
        }
        return this.f27694d;
    }

    @NonNull
    public Version version() {
        return f27690e;
    }
}
