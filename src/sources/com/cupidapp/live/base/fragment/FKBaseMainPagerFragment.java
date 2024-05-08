package com.cupidapp.live.base.fragment;

import android.content.Context;
import android.view.View;
import com.cupidapp.live.appdialog.model.AppDialogModel;
import com.cupidapp.live.appdialog.model.BottomTabName;
import com.cupidapp.live.appdialog.model.ChangeTabModelResult;
import com.cupidapp.live.appdialog.model.ReChangeTabEvent;
import com.cupidapp.live.appdialog.wrapper.AppDialogWrapper;
import com.cupidapp.live.base.fragment.FKBaseMainPagerFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import he.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBaseMainPagerFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FKBaseMainPagerFragment extends FKBaseFragment {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f11794g = new a(null);

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public static BottomTabName f11795h;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11796e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11797f = new LinkedHashMap();

    /* compiled from: FKBaseMainPagerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FKBaseMainPagerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11798a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f11799b;

        static {
            int[] iArr = new int[BottomTabName.values().length];
            try {
                iArr[BottomTabName.Match.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BottomTabName.Live.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BottomTabName.Feed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BottomTabName.Inbox.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BottomTabName.Profile.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f11798a = iArr;
            int[] iArr2 = new int[SensorPosition.values().length];
            try {
                iArr2[SensorPosition.Match.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[SensorPosition.LiveShow.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[SensorPosition.Feed.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[SensorPosition.Message.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[SensorPosition.Setting.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            f11799b = iArr2;
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f11797f.clear();
    }

    public void V0() {
    }

    public void W0() {
    }

    public void X0() {
    }

    public void Y0(@NotNull Context context) {
        s.i(context, "context");
    }

    public void Z0() {
    }

    public void a1(@Nullable String str) {
    }

    public void b1(long j10) {
    }

    public void c1(boolean z10) {
    }

    public final void d1(AppDialogModel appDialogModel, SensorPosition sensorPosition) {
        AppDialogWrapper.f11746a.e(getContext(), appDialogModel, sensorPosition);
    }

    public final void e1(@NotNull final BottomTabName tab) {
        s.i(tab, "tab");
        f11795h = tab;
        Disposable disposed = NetworkClient.f11868a.i().u(tab.getTabName()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ChangeTabModelResult, p>() { // from class: com.cupidapp.live.base.fragment.FKBaseMainPagerFragment$showAppDialog$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ChangeTabModelResult changeTabModelResult) {
                m2457invoke(changeTabModelResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2457invoke(ChangeTabModelResult changeTabModelResult) {
                BottomTabName bottomTabName;
                BottomTabName bottomTabName2;
                SensorPosition sensorPosition;
                AppDialogModel appDialogModel;
                ChangeTabModelResult changeTabModelResult2 = changeTabModelResult;
                FKBaseMainPagerFragment fKBaseMainPagerFragment = FKBaseMainPagerFragment.this;
                String tab2 = changeTabModelResult2.getTab();
                bottomTabName = FKBaseMainPagerFragment.f11795h;
                boolean d10 = s.d(tab2, bottomTabName != null ? bottomTabName.getTabName() : null);
                boolean z10 = false;
                if (d10) {
                    List<AppDialogModel> windows = changeTabModelResult2.getWindows();
                    if ((windows == null || (appDialogModel = (AppDialogModel) CollectionsKt___CollectionsKt.V(windows)) == null || !appDialogModel.getReTabChange()) ? false : true) {
                        z10 = true;
                    }
                }
                fKBaseMainPagerFragment.f11796e = z10;
                if (FKRxPermissionAlertDialog.f12016a.e()) {
                    return;
                }
                String tab3 = changeTabModelResult2.getTab();
                bottomTabName2 = FKBaseMainPagerFragment.f11795h;
                if (s.d(tab3, bottomTabName2 != null ? bottomTabName2.getTabName() : null) && FKBaseMainPagerFragment.this.isResumed()) {
                    int i10 = FKBaseMainPagerFragment.b.f11798a[tab.ordinal()];
                    if (i10 == 1) {
                        sensorPosition = SensorPosition.Match;
                    } else if (i10 == 2) {
                        sensorPosition = SensorPosition.LiveShow;
                    } else if (i10 == 3) {
                        sensorPosition = SensorPosition.Feed;
                    } else if (i10 == 4) {
                        sensorPosition = SensorPosition.Message;
                    } else {
                        if (i10 != 5) {
                            throw new NoWhenBranchMatchedException();
                        }
                        sensorPosition = SensorPosition.Setting;
                    }
                    List<AppDialogModel> windows2 = changeTabModelResult2.getWindows();
                    if (windows2 != null) {
                        Iterator<AppDialogModel> iterator2 = windows2.iterator2();
                        while (iterator2.hasNext()) {
                            FKBaseMainPagerFragment.this.d1(iterator2.next(), sensorPosition);
                        }
                    }
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.fragment.FKBaseMainPagerFragment$showAppDialog$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                FKBaseMainPagerFragment.this.f11796e = false;
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public void f1() {
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ReChangeTabEvent event) {
        BottomTabName bottomTabName;
        s.i(event, "event");
        if (this.f11796e) {
            this.f11796e = false;
            EventBus.c().r(event);
            int i10 = b.f11799b[event.getPosition().ordinal()];
            if (i10 == 1) {
                bottomTabName = BottomTabName.Match;
            } else if (i10 == 2) {
                bottomTabName = BottomTabName.Live;
            } else if (i10 == 3) {
                bottomTabName = BottomTabName.Feed;
            } else if (i10 != 4) {
                bottomTabName = i10 != 5 ? null : BottomTabName.Profile;
            } else {
                bottomTabName = BottomTabName.Inbox;
            }
            if ((bottomTabName == null || bottomTabName == f11795h) && bottomTabName != null) {
                e1(bottomTabName);
            }
        }
    }
}
