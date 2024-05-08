package com.cupidapp.live.profile.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.network.model.InnerFunctionModel;
import com.cupidapp.live.base.recyclerview.model.FKDecorationModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.profile.adapter.InnerFunctionAdapter;
import com.cupidapp.live.track.group.GroupOthersLog;
import j1.i;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: InnerFunctionDialog.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class InnerFunctionDialog extends FrameLayout implements com.cupidapp.live.base.fragment.d {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f17721f = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f17722b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f17723c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f17724d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17725e;

    /* compiled from: InnerFunctionDialog.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final InnerFunctionDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new InnerFunctionDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerFunctionDialog(final Context context) {
        super(context);
        this.f17725e = new LinkedHashMap();
        this.f17723c = true;
        this.f17724d = c.b(new Function0<InnerFunctionAdapter>() { // from class: com.cupidapp.live.profile.dialog.InnerFunctionDialog$adapter$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final InnerFunctionAdapter invoke() {
                InnerFunctionAdapter innerFunctionAdapter = new InnerFunctionAdapter();
                final InnerFunctionDialog innerFunctionDialog = InnerFunctionDialog.this;
                final Context context2 = context;
                innerFunctionAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.dialog.InnerFunctionDialog$adapter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        AlertDialog alertDialog;
                        if (obj instanceof InnerFunctionModel) {
                            alertDialog = InnerFunctionDialog.this.f17722b;
                            if (alertDialog != null) {
                                alertDialog.dismiss();
                            }
                            InnerFunctionModel innerFunctionModel = (InnerFunctionModel) obj;
                            j.a.b(j.f12156c, context2, innerFunctionModel.getUrl(), null, 4, null);
                            GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
                            SensorPosition sensorPosition = SensorPosition.Setting;
                            String value = sensorPosition != null ? sensorPosition.getValue() : null;
                            String trackName = innerFunctionModel.getTrackName();
                            if (trackName == null) {
                                trackName = "";
                            }
                            GroupOthersLog.Y(groupOthersLog, "PROFILE_MORE", value, trackName, null, 8, null);
                        }
                    }
                });
                return innerFunctionAdapter;
            }
        });
        j();
    }

    public /* synthetic */ InnerFunctionDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public static final void g(InnerFunctionDialog this$0, DialogInterface dialogInterface) {
        s.i(this$0, "this$0");
        com.cupidapp.live.base.fragment.b.f11807a.a(this$0);
    }

    private final InnerFunctionAdapter getAdapter() {
        return (InnerFunctionAdapter) this.f17724d.getValue();
    }

    public static final void h(InnerFunctionDialog this$0, DialogInterface dialogInterface) {
        s.i(this$0, "this$0");
        com.cupidapp.live.base.fragment.b.f11807a.d(this$0);
    }

    @Override // com.cupidapp.live.base.fragment.d
    public void L() {
        try {
            i();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Nullable
    public View c(int i10) {
        Map<Integer, View> map = this.f17725e;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @NotNull
    public final InnerFunctionDialog e(@NotNull List<? extends List<InnerFunctionModel>> list) {
        s.i(list, "list");
        getAdapter().j().clear();
        int size = list.size();
        int i10 = 0;
        for (List<InnerFunctionModel> list2 : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            Iterator<InnerFunctionModel> iterator2 = list2.iterator2();
            while (iterator2.hasNext()) {
                getAdapter().d(iterator2.next());
            }
            if (i10 == size - 1) {
                getAdapter().d(new FKFooterViewModel(false, false, null, 0, h.c(this, 6.0f), 0, 46, null));
            } else {
                getAdapter().d(new FKDecorationModel(h.c(this, 21.0f), 0, 2, null));
            }
            i10 = i11;
        }
        getAdapter().notifyDataSetChanged();
        return this;
    }

    @NotNull
    public final InnerFunctionDialog f() {
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f17722b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(this.f17723c);
        }
        AlertDialog alertDialog = this.f17722b;
        if (alertDialog != null) {
            alertDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.profile.dialog.b
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    InnerFunctionDialog.g(InnerFunctionDialog.this, dialogInterface);
                }
            });
        }
        AlertDialog alertDialog2 = this.f17722b;
        if (alertDialog2 != null) {
            alertDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.profile.dialog.a
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    InnerFunctionDialog.h(InnerFunctionDialog.this, dialogInterface);
                }
            });
        }
        return this;
    }

    public final void i() {
        AlertDialog alertDialog;
        AlertDialog alertDialog2 = this.f17722b;
        if (!(alertDialog2 != null && alertDialog2.isShowing()) || (alertDialog = this.f17722b) == null) {
            return;
        }
        alertDialog.dismiss();
    }

    public final void j() {
        z.a(this, R$layout.dialog_inner_function_bottom, true);
        int i10 = R$id.inner_function_rv;
        ((RecyclerView) c(i10)).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        ((RecyclerView) c(i10)).setAdapter(getAdapter());
    }

    public final void k() {
        Window window;
        AlertDialog alertDialog = this.f17722b;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f17722b;
        if (alertDialog2 != null && (window = alertDialog2.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -2);
            window.setGravity(80);
        }
        i.g(i.f50236a, PopupName.PROFILE_MORE, SensorPosition.Setting, null, 4, null);
    }
}
