package com.cupidapp.live.appdialog.layout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import com.cupidapp.live.appdialog.model.ReChangeTabEvent;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.BaseLayout;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TabBaseDialogLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class TabBaseDialogLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public AlertDialog f11707d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11708e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11709f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11710g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabBaseDialogLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11710g = new LinkedHashMap();
    }

    public static final void A(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void B(TabBaseDialogLayout this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.f11708e = true;
        this$0.m();
    }

    public static final void o(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void p(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void s(TabBaseDialogLayout this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.f11709f = true;
        this$0.m();
    }

    public static final void t(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void x(TabBaseDialogLayout tabBaseDialogLayout, int i10, int i11, int i12, boolean z10, Integer num, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDialog");
        }
        if ((i13 & 1) != 0) {
            i10 = -1;
        }
        int i14 = (i13 & 2) != 0 ? -2 : i11;
        int i15 = (i13 & 4) != 0 ? 17 : i12;
        boolean z11 = (i13 & 8) != 0 ? true : z10;
        if ((i13 & 16) != 0) {
            num = null;
        }
        tabBaseDialogLayout.w(i10, i14, i15, z11, num);
    }

    public static final void y(final TabBaseDialogLayout this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        Completable v2 = this$0.v();
        Action action = new Action() { // from class: com.cupidapp.live.appdialog.layout.o
            @Override // io.reactivex.functions.Action
            public final void run() {
                TabBaseDialogLayout.z(TabBaseDialogLayout.this);
            }
        };
        final TabBaseDialogLayout$showDialog$1$2 tabBaseDialogLayout$showDialog$1$2 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.TabBaseDialogLayout$showDialog$1$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        v2.subscribe(action, new Consumer() { // from class: com.cupidapp.live.appdialog.layout.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TabBaseDialogLayout.A(Function1.this, obj);
            }
        });
    }

    public static final void z(TabBaseDialogLayout this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.f11709f = true;
        this$0.m();
    }

    @NotNull
    public abstract SensorPosition getPosition();

    public final void m() {
        if (this.f11709f && this.f11708e && u()) {
            Observable delay = Observable.just(getPosition()).delay(200L, TimeUnit.MILLISECONDS);
            final Function1<SensorPosition, kotlin.p> function1 = new Function1<SensorPosition, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.TabBaseDialogLayout$checkPostReChangeTabEvent$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(SensorPosition sensorPosition) {
                    invoke2(sensorPosition);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SensorPosition sensorPosition) {
                    EventBus.c().o(new ReChangeTabEvent(TabBaseDialogLayout.this.getPosition()));
                }
            };
            Consumer consumer = new Consumer() { // from class: com.cupidapp.live.appdialog.layout.q
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    TabBaseDialogLayout.o(Function1.this, obj);
                }
            };
            final TabBaseDialogLayout$checkPostReChangeTabEvent$2 tabBaseDialogLayout$checkPostReChangeTabEvent$2 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.TabBaseDialogLayout$checkPostReChangeTabEvent$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                    invoke2(th);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                }
            };
            delay.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.appdialog.layout.r
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    TabBaseDialogLayout.p(Function1.this, obj);
                }
            });
        }
    }

    public final void q() {
        AlertDialog alertDialog = this.f11707d;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final void r() {
        AlertDialog alertDialog = this.f11707d;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.f11708e = true;
        Completable v2 = v();
        Action action = new Action() { // from class: com.cupidapp.live.appdialog.layout.n
            @Override // io.reactivex.functions.Action
            public final void run() {
                TabBaseDialogLayout.s(TabBaseDialogLayout.this);
            }
        };
        final TabBaseDialogLayout$onlyReportShow$2 tabBaseDialogLayout$onlyReportShow$2 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.TabBaseDialogLayout$onlyReportShow$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        v2.subscribe(action, new Consumer() { // from class: com.cupidapp.live.appdialog.layout.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TabBaseDialogLayout.t(Function1.this, obj);
            }
        });
    }

    public abstract boolean u();

    @NotNull
    public abstract Completable v();

    public final void w(int i10, int i11, int i12, boolean z10, @Nullable Integer num) {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).create();
        this.f11707d = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(z10);
        }
        AlertDialog alertDialog = this.f11707d;
        if (alertDialog != null) {
            alertDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.appdialog.layout.m
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    TabBaseDialogLayout.y(TabBaseDialogLayout.this, dialogInterface);
                }
            });
        }
        AlertDialog alertDialog2 = this.f11707d;
        if (alertDialog2 != null) {
            alertDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.appdialog.layout.l
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    TabBaseDialogLayout.B(TabBaseDialogLayout.this, dialogInterface);
                }
            });
        }
        AlertDialog alertDialog3 = this.f11707d;
        if (alertDialog3 != null) {
            alertDialog3.show();
        }
        AlertDialog alertDialog4 = this.f11707d;
        if (alertDialog4 != null) {
            alertDialog4.setContentView(this);
        }
        AlertDialog alertDialog5 = this.f11707d;
        if (alertDialog5 == null || (window = alertDialog5.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        if (num != null) {
            window.setWindowAnimations(num.intValue());
        }
        window.setLayout(i10, i11);
        window.setGravity(i12);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabBaseDialogLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11710g = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabBaseDialogLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11710g = new LinkedHashMap();
    }
}
