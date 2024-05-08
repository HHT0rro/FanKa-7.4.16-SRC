package com.cupidapp.live.liveshow.fanclub.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FKEditFanClubNameLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKEditFanClubNameLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public AlertDialog f14985d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14986e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKEditFanClubNameLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f14986e = new LinkedHashMap();
        k();
    }

    public static final void o(final FKEditFanClubNameLayout this$0, DialogInterface dialogInterface) {
        s.i(this$0, "this$0");
        this$0.postDelayed(new Runnable() { // from class: com.cupidapp.live.liveshow.fanclub.view.b
            @Override // java.lang.Runnable
            public final void run() {
                FKEditFanClubNameLayout.p(FKEditFanClubNameLayout.this);
            }
        }, 50L);
    }

    public static final void p(FKEditFanClubNameLayout this$0) {
        s.i(this$0, "this$0");
        Context context = this$0.getContext();
        s.h(context, "context");
        EditText editMedalNameEditText = (EditText) this$0.g(R$id.editMedalNameEditText);
        s.h(editMedalNameEditText, "editMedalNameEditText");
        h.v(context, editMedalNameEditText);
    }

    @Nullable
    public View g(int i10) {
        Map<Integer, View> map = this.f14986e;
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

    public final void j() {
        ImageView editFanClubNameBackView = (ImageView) g(R$id.editFanClubNameBackView);
        s.h(editFanClubNameBackView, "editFanClubNameBackView");
        y.d(editFanClubNameBackView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fanclub.view.FKEditFanClubNameLayout$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                AlertDialog alertDialog;
                alertDialog = FKEditFanClubNameLayout.this.f14985d;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        TextView editMedalNameSubmitButton = (TextView) g(R$id.editMedalNameSubmitButton);
        s.h(editMedalNameSubmitButton, "editMedalNameSubmitButton");
        y.d(editMedalNameSubmitButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fanclub.view.FKEditFanClubNameLayout$bindClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FKEditFanClubNameLayout.this.l();
            }
        });
        ImageView clearMedalNameButton = (ImageView) g(R$id.clearMedalNameButton);
        s.h(clearMedalNameButton, "clearMedalNameButton");
        y.d(clearMedalNameButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fanclub.view.FKEditFanClubNameLayout$bindClickEvent$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                ((EditText) FKEditFanClubNameLayout.this.g(R$id.editMedalNameEditText)).setText("");
            }
        });
    }

    public final void k() {
        z.a(this, R$layout.layout_edit_fan_club_name, true);
        j();
    }

    public final void l() {
        LiveShowModel liveShowModel;
        int i10 = R$id.editMedalNameEditText;
        Editable text = ((EditText) g(i10)).getText();
        if ((text == null || text.length() == 0) || (liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().j(liveShowModel.getUser().userId(), ((EditText) g(i10)).getText().toString()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.fanclub.view.FKEditFanClubNameLayout$renameFanClubName$lambda$4$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                AlertDialog alertDialog;
                com.cupidapp.live.base.view.h.f12779a.c(FKEditFanClubNameLayout.this.getContext(), R$string.edit_fan_club_name_success);
                alertDialog = FKEditFanClubNameLayout.this.f14985d;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void m() {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f14985d = create;
        if (create != null) {
            create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.liveshow.fanclub.view.a
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    FKEditFanClubNameLayout.o(FKEditFanClubNameLayout.this, dialogInterface);
                }
            });
        }
        AlertDialog alertDialog = this.f14985d;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f14985d;
        if (alertDialog2 == null || (window = alertDialog2.getWindow()) == null) {
            return;
        }
        window.setLayout(-1, -2);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setGravity(80);
        window.setDimAmount(0.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKEditFanClubNameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f14986e = new LinkedHashMap();
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKEditFanClubNameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f14986e = new LinkedHashMap();
        k();
    }
}
