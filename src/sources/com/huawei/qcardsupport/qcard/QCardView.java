package com.huawei.qcardsupport.qcard;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.cardmanager.CardInfo;
import com.huawei.flexiblelayout.script.IScriptContext;
import com.huawei.qcardsupport.h;
import com.huawei.qcardsupport.l;
import com.huawei.qcardsupport.qcard.cardmanager.QCardManager;
import com.huawei.qcardsupport.qcard.cardmanager.impl.LayoutLoader;
import com.huawei.quickcard.QuickCardView;
import com.huawei.quickcard.framework.bean.QuickCardBean;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QCardView implements QCardManager.LoadReceiver {

    /* renamed from: g, reason: collision with root package name */
    private static final String f33148g = "QCardView";

    /* renamed from: a, reason: collision with root package name */
    private final QuickCardView f33149a;

    /* renamed from: b, reason: collision with root package name */
    private final h f33150b;

    /* renamed from: c, reason: collision with root package name */
    private String f33151c;

    /* renamed from: d, reason: collision with root package name */
    private b f33152d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f33153e;

    /* renamed from: f, reason: collision with root package name */
    private QCardRenderListener f33154f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface QCardRenderListener {
        void onRendered(boolean z10, String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f33155a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f33156b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f33157c;

        public a(String str, Object obj, Object obj2) {
            this.f33155a = str;
            this.f33156b = obj;
            this.f33157c = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            QCardView.this.notifyDataChanged(this.f33155a, this.f33156b, this.f33157c);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum b {
        INIT,
        RENDERING,
        RENDER_OK,
        RENDER_FAIL
    }

    public QCardView(@NonNull Context context) {
        QCardSupport.getInstance(context).initialize();
        this.f33149a = new QuickCardView(context);
        this.f33150b = new h();
        this.f33152d = b.INIT;
    }

    private void a() {
        this.f33150b.a(3);
        int bindData = this.f33149a.bindData(this.f33150b);
        if (bindData != 0) {
            Log.e(f33148g, "Call 'QuickCardView.bindData()', error: " + bindData + ", uri: " + this.f33151c + ".");
        }
        l.a().code(bindData).uri(this.f33151c).put("hashcode", Integer.toHexString(hashCode())).build(getContext()).report();
    }

    private boolean b() {
        this.f33150b.a(1);
        int render = this.f33149a.render(this.f33151c, this.f33150b);
        if (render == 0) {
            return true;
        }
        Log.e(f33148g, "Call 'QuickCardView.render()', error: " + render + ", uri: " + this.f33151c + ".");
        return false;
    }

    private void c() {
        render(this.f33151c);
    }

    private void d() {
        int unbind = this.f33149a.unbind(this.f33150b);
        if (unbind != 0) {
            Log.w(f33148g, "Call 'QuickCardView.unbind()', error: " + unbind);
        }
        this.f33150b.a();
    }

    public void addJsInterface(String str, Object obj, boolean z10) {
        this.f33150b.a(str, obj, z10 ? 1 : 2);
    }

    public void bind() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b bVar = this.f33152d;
            if (bVar == b.RENDER_OK) {
                a();
                return;
            }
            this.f33153e = true;
            if (bVar == b.RENDER_FAIL) {
                c();
                return;
            }
            return;
        }
        throw new IllegalStateException("bind must be called on the UI thread.");
    }

    public Context getContext() {
        return getView().getContext();
    }

    public int getToolkitLevel() {
        JSONObject cardOptions = this.f33149a.getCardOptions();
        if (cardOptions != null) {
            return cardOptions.optInt(QuickCardBean.Field.TOOLKIT_LEVEL, -1);
        }
        return -1;
    }

    @NonNull
    public View getView() {
        return this.f33149a;
    }

    public boolean isRendered() {
        return this.f33152d == b.RENDER_OK;
    }

    public void notifyDataChanged(String str, Object obj, Object obj2) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new a(str, obj, obj2));
        } else {
            this.f33149a.notifyDataChange(str, obj, obj2);
        }
    }

    @Override // com.huawei.qcardsupport.qcard.cardmanager.QCardManager.LoadReceiver
    @MainThread
    public void onLoaded(@NonNull String str, int i10, CardInfo cardInfo) {
        b bVar = this.f33152d;
        b bVar2 = b.RENDER_OK;
        if (bVar == bVar2 || !Objects.equals(str, this.f33151c)) {
            Log.w(f33148g, "Unreachable, " + ((Object) this.f33152d) + ".");
        }
        if (LayoutLoader.Result.isOk(i10) && cardInfo != null) {
            if (this.f33152d != bVar2) {
                if (b()) {
                    this.f33152d = bVar2;
                    a(true, this.f33151c);
                    if (this.f33153e) {
                        this.f33153e = false;
                        a();
                    }
                } else {
                    this.f33152d = b.RENDER_FAIL;
                    a(false, this.f33151c);
                    this.f33149a.setVisibility(8);
                }
            }
        } else {
            this.f33152d = b.RENDER_FAIL;
            if (!LayoutLoader.Result.isRetry(i10)) {
                this.f33149a.setVisibility(8);
            }
        }
        l.b().code(i10).uri(this.f33151c).put("hashcode", Integer.toHexString(hashCode())).build(getContext()).report();
    }

    public void render(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f33150b.a(0);
            this.f33151c = str;
            this.f33152d = b.RENDERING;
            QCardManager.getInstance(getContext()).asyncLoadCard(str, this);
            l.c().uri(this.f33151c).put("hashcode", Integer.toHexString(hashCode())).build(getContext()).report();
            return;
        }
        throw new IllegalStateException("render must be called on the UI thread.");
    }

    public void setRenderListener(QCardRenderListener qCardRenderListener) {
        this.f33154f = qCardRenderListener;
    }

    public void setScriptContext(@NonNull IScriptContext iScriptContext) {
        this.f33150b.a(iScriptContext);
    }

    public void unbind() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.f33152d == b.RENDER_OK) {
                d();
                return;
            }
            return;
        }
        throw new IllegalStateException("unbind must be called on the UI thread.");
    }

    public void addJsInterface(String str, Object obj) {
        this.f33150b.a(str, obj, 2);
    }

    private void a(boolean z10, String str) {
        QCardRenderListener qCardRenderListener = this.f33154f;
        if (qCardRenderListener != null) {
            qCardRenderListener.onRendered(z10, str);
        }
    }
}
