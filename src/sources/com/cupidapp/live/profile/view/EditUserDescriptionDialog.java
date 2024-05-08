package com.cupidapp.live.profile.view;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.profile.persenter.EditUserDescriptionPresenter;
import com.cupidapp.live.track.group.GroupSocialLog;
import j1.i;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.t;
import z0.z;

/* compiled from: EditUserDescriptionDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class EditUserDescriptionDialog extends FrameLayout implements com.cupidapp.live.profile.persenter.a {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f17847g = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public SensorPosition f17848b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public AlertDialog f17849c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public String f17850d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f17851e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17852f;

    /* compiled from: EditUserDescriptionDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EditUserDescriptionDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new EditUserDescriptionDialog(context, null);
        }
    }

    /* compiled from: TextView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
            String obj;
            TextView textView = (TextView) EditUserDescriptionDialog.this.c(R$id.user_des_edit_number);
            y yVar = y.f51038a;
            String string = EditUserDescriptionDialog.this.getContext().getString(R$string.how_many_characters_can_input);
            s.h(string, "context.getString(R.stri…any_characters_can_input)");
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(140 - ((editable == null || (obj = editable.toString()) == null) ? 0 : obj.length()));
            String format = String.format(string, Arrays.copyOf(objArr, 1));
            s.h(format, "format(format, *args)");
            textView.setText(format);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditUserDescriptionDialog(Context context) {
        super(context);
        this.f17852f = new LinkedHashMap();
        this.f17851e = kotlin.c.b(new Function0<EditUserDescriptionPresenter>() { // from class: com.cupidapp.live.profile.view.EditUserDescriptionDialog$presenter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final EditUserDescriptionPresenter invoke() {
                return new EditUserDescriptionPresenter(EditUserDescriptionDialog.this);
            }
        });
        g();
    }

    public /* synthetic */ EditUserDescriptionDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditUserDescriptionPresenter getPresenter() {
        return (EditUserDescriptionPresenter) this.f17851e.getValue();
    }

    public static final boolean h(EditUserDescriptionDialog this$0, View view, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        this$0.performClick();
        Context context = this$0.getContext();
        if (context == null) {
            return false;
        }
        h.p(context, (EditText) this$0.c(R$id.user_des_edit));
        return false;
    }

    @Override // com.cupidapp.live.profile.persenter.a
    public void a() {
        com.cupidapp.live.base.view.h hVar = com.cupidapp.live.base.view.h.f12779a;
        Context context = getContext();
        String str = this.f17850d;
        if (str == null) {
            str = getContext().getString(R$string.edit_suc);
            s.h(str, "context.getString(R.string.edit_suc)");
        }
        hVar.d(context, str);
        AlertDialog alertDialog = this.f17849c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        GroupSocialLog.f18708a.P();
    }

    @Nullable
    public View c(int i10) {
        Map<Integer, View> map = this.f17852f;
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
    public final EditUserDescriptionDialog f(@Nullable String str, @NotNull SensorPosition position) {
        s.i(position, "position");
        this.f17850d = str;
        this.f17848b = position;
        return this;
    }

    public final void g() {
        z.a(this, R$layout.dialog_edit_profile, true);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.profile.view.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean h10;
                h10 = EditUserDescriptionDialog.h(EditUserDescriptionDialog.this, view, motionEvent);
                return h10;
            }
        });
        ImageView user_des_close_img = (ImageView) c(R$id.user_des_close_img);
        s.h(user_des_close_img, "user_des_close_img");
        z0.y.d(user_des_close_img, new Function1<View, p>() { // from class: com.cupidapp.live.profile.view.EditUserDescriptionDialog$initView$2
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
                com.cupidapp.live.base.view.h.f12779a.m(EditUserDescriptionDialog.this.getContext(), EditUserDescriptionDialog.this.getContext().getString(R$string.close_edit_des_tip));
                alertDialog = EditUserDescriptionDialog.this.f17849c;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        FKUniversalButton user_des_save = (FKUniversalButton) c(R$id.user_des_save);
        s.h(user_des_save, "user_des_save");
        z0.y.d(user_des_save, new Function1<View, p>() { // from class: com.cupidapp.live.profile.view.EditUserDescriptionDialog$initView$3
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
                EditUserDescriptionPresenter presenter;
                String obj = ((EditText) EditUserDescriptionDialog.this.c(R$id.user_des_edit)).getText().toString();
                if (obj.length() == 0) {
                    com.cupidapp.live.base.view.h.f12779a.q(R$string.not_fill_content);
                    return;
                }
                presenter = EditUserDescriptionDialog.this.getPresenter();
                Context context = EditUserDescriptionDialog.this.getContext();
                s.h(context, "context");
                presenter.b(obj, context);
            }
        });
        TextView textView = (TextView) c(R$id.user_des_edit_number);
        y yVar = y.f51038a;
        String string = getContext().getString(R$string.how_many_characters_can_input);
        s.h(string, "context.getString(R.stri…any_characters_can_input)");
        String format = String.format(string, Arrays.copyOf(new Object[]{140}, 1));
        s.h(format, "format(format, *args)");
        textView.setText(format);
        TextView textView2 = (TextView) c(R$id.user_des_tip);
        String string2 = getContext().getString(R$string.fill_user_des_tip);
        s.h(string2, "context.getString(R.string.fill_user_des_tip)");
        textView2.setText(t.k(string2, -49088, new String[]{"+37%"}, false, 4, null));
        EditText user_des_edit = (EditText) c(R$id.user_des_edit);
        s.h(user_des_edit, "user_des_edit");
        user_des_edit.addTextChangedListener(new b());
    }

    public final void i() {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f17849c = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(false);
        }
        AlertDialog alertDialog = this.f17849c;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f17849c;
        if (alertDialog2 != null && (window = alertDialog2.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -2);
            window.setGravity(80);
        }
        i.g(i.f50236a, PopupName.FILL_PERSON_INTRODUCE, this.f17848b, null, 4, null);
    }
}
