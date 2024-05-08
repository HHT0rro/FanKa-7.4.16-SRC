package com.kwad.sdk.mvp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Presenter {
    private Object aJN;
    private View mRootView;
    private final List<Presenter> aJM = new CopyOnWriteArrayList();
    private PresenterState aJO = PresenterState.INIT;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'INIT' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class PresenterState {
        private static final /* synthetic */ PresenterState[] $VALUES;
        public static final PresenterState BIND;
        public static final PresenterState CREATE;
        public static final PresenterState DESTROY;
        public static final PresenterState INIT;
        public static final PresenterState UNBIND;
        private int mIndex;

        static {
            int i10 = 0;
            PresenterState presenterState = new PresenterState("INIT", i10, i10) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.1
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                }
            };
            INIT = presenterState;
            int i11 = 1;
            PresenterState presenterState2 = new PresenterState("CREATE", i11, i11) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.2
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator iterator2 = presenter.aJM.iterator2();
                    while (iterator2.hasNext()) {
                        try {
                            ((Presenter) iterator2.next()).G(presenter.mRootView);
                        } catch (Exception e2) {
                            c.gatherException(e2);
                            com.kwad.sdk.core.e.c.printStackTrace(e2);
                        }
                    }
                }
            };
            CREATE = presenterState2;
            int i12 = 2;
            PresenterState presenterState3 = new PresenterState("BIND", i12, i12) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.3
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator iterator2 = presenter.aJM.iterator2();
                    while (iterator2.hasNext()) {
                        try {
                            ((Presenter) iterator2.next()).k(presenter.aJN);
                        } catch (Throwable th) {
                            c.gatherException(th);
                            com.kwad.sdk.core.e.c.printStackTrace(th);
                        }
                    }
                }
            };
            BIND = presenterState3;
            int i13 = 3;
            PresenterState presenterState4 = new PresenterState("UNBIND", i13, i13) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.4
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator iterator2 = presenter.aJM.iterator2();
                    while (iterator2.hasNext()) {
                        try {
                            ((Presenter) iterator2.next()).lW();
                        } catch (Exception e2) {
                            c.gatherException(e2);
                            com.kwad.sdk.core.e.c.printStackTrace(e2);
                        }
                    }
                }
            };
            UNBIND = presenterState4;
            int i14 = 4;
            PresenterState presenterState5 = new PresenterState("DESTROY", i14, i14) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.5
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator iterator2 = presenter.aJM.iterator2();
                    while (iterator2.hasNext()) {
                        try {
                            ((Presenter) iterator2.next()).destroy();
                        } catch (Exception e2) {
                            c.gatherException(e2);
                            com.kwad.sdk.core.e.c.printStackTrace(e2);
                        }
                    }
                }
            };
            DESTROY = presenterState5;
            $VALUES = new PresenterState[]{presenterState, presenterState2, presenterState3, presenterState4, presenterState5};
        }

        public static PresenterState valueOf(String str) {
            return (PresenterState) Enum.valueOf(PresenterState.class, str);
        }

        public static PresenterState[] values() {
            return (PresenterState[]) $VALUES.clone();
        }

        public int index() {
            return this.mIndex;
        }

        public abstract void performCallState(Presenter presenter);

        private PresenterState(String str, int i10, int i11) {
            this.mIndex = i11;
        }
    }

    private boolean Jv() {
        return this.aJO.index() >= PresenterState.CREATE.index();
    }

    private void b(Presenter presenter) {
        Object obj;
        View view;
        int index = this.aJO.index();
        PresenterState presenterState = PresenterState.UNBIND;
        if (index >= presenterState.index() || presenter.aJO.index() >= presenterState.index()) {
            return;
        }
        if (Jv() && !presenter.Jv() && (view = this.mRootView) != null) {
            presenter.G(view);
        }
        if (!isBound() || !presenter.Jv() || presenter.isBound() || (obj = this.aJN) == null) {
            return;
        }
        presenter.k(obj);
    }

    private boolean isBound() {
        return this.aJO == PresenterState.BIND;
    }

    @UiThread
    public final void G(View view) {
        try {
            this.aJO = PresenterState.CREATE;
            this.mRootView = view;
            onCreate();
            this.aJO.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final List<Presenter> Jw() {
        return this.aJM;
    }

    public final Object Jx() {
        return this.aJN;
    }

    public final void a(Presenter presenter) {
        this.aJM.add(presenter);
        if (!Jv() || presenter.Jv()) {
            return;
        }
        G(this.mRootView);
    }

    public void aj() {
    }

    @UiThread
    public final void destroy() {
        try {
            if (this.aJO == PresenterState.BIND) {
                lW();
            }
            this.aJO = PresenterState.DESTROY;
            onDestroy();
            this.aJO.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final <T extends View> T findViewById(int i10) {
        return (T) this.mRootView.findViewById(i10);
    }

    @Nullable
    @UiThread
    public final Activity getActivity() {
        return l.dn(getContext());
    }

    @NonNull
    public final Context getContext() {
        return this.mRootView.getContext();
    }

    public final View getRootView() {
        return this.mRootView;
    }

    @UiThread
    public final void k(@NonNull Object obj) {
        try {
            PresenterState presenterState = this.aJO;
            if (presenterState != PresenterState.INIT) {
                PresenterState presenterState2 = PresenterState.DESTROY;
            }
            PresenterState presenterState3 = PresenterState.BIND;
            if (presenterState == presenterState3) {
                lW();
            }
            this.aJO = presenterState3;
            this.aJN = obj;
            aj();
            this.aJO.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @UiThread
    public final void lW() {
        try {
            this.aJO = PresenterState.UNBIND;
            onUnbind();
            this.aJO.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onUnbind() {
    }

    public final void a(Presenter presenter, boolean z10) {
        this.aJM.add(presenter);
        try {
            b(presenter);
        } catch (Throwable th) {
            c.gatherException(th);
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }
}
