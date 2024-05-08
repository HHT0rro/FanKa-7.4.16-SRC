package com.cupidapp.live.maskparty.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.maskparty.model.GuessIdentityModel;
import com.cupidapp.live.maskparty.model.IdentityModel;
import com.cupidapp.live.maskparty.model.MaskPartyScriptModel;
import com.cupidapp.live.maskparty.model.MaskPartyScriptTaskModel;
import com.cupidapp.live.maskparty.model.ScriptRoleModel;
import com.cupidapp.live.maskparty.view.script.MaskPartyScriptLayout;
import com.cupidapp.live.maskparty.view.script.RevealedIdentityLayout;
import com.cupidapp.live.maskparty.view.script.ScriptSelectRoleLayout;
import com.cupidapp.live.maskparty.view.script.ScriptTaskLayout;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.b;

/* compiled from: MaskPartyScriptHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyScriptHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MaskPartyScriptHelper f16348a = new MaskPartyScriptHelper();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static i f16349b;

    /* renamed from: c, reason: collision with root package name */
    public static int f16350c;

    public final AlertDialog c(Context context, View view) {
        AlertDialog dialog = b.f54812a.e(context).setView(view).create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R$style.dialog_translate_anim);
            window.setLayout(-1, -2);
            window.setGravity(80);
        }
        s.h(dialog, "dialog");
        return dialog;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [android.app.AlertDialog, T] */
    public final void d(@Nullable Context context, @NotNull GuessIdentityModel identity, @NotNull final Function1<? super IdentityModel, p> selectCallback) {
        s.i(identity, "identity");
        s.i(selectCallback, "selectCallback");
        if (context == null) {
            return;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        RevealedIdentityLayout revealedIdentityLayout = new RevealedIdentityLayout(context);
        revealedIdentityLayout.b(identity);
        revealedIdentityLayout.setSelectIdentityCallback(new Function1<IdentityModel, p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyScriptHelper$showRevealedIdentity$layout$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(IdentityModel identityModel) {
                invoke2(identityModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull IdentityModel it) {
                s.i(it, "it");
                AlertDialog alertDialog = ref$ObjectRef.element;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                selectCallback.invoke(it);
            }
        });
        ref$ObjectRef.element = c(context, revealedIdentityLayout);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [android.app.AlertDialog, T] */
    public final void e(@Nullable Context context, @NotNull MaskPartyScriptModel script) {
        s.i(script, "script");
        if (context == null) {
            return;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        MaskPartyScriptLayout maskPartyScriptLayout = new MaskPartyScriptLayout(context);
        maskPartyScriptLayout.b(script);
        maskPartyScriptLayout.setStartPlayCallback(new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyScriptHelper$showScript$layout$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlertDialog alertDialog = ref$ObjectRef.element;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        ref$ObjectRef.element = c(context, maskPartyScriptLayout);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [android.app.AlertDialog, T] */
    public final void f(@Nullable Context context, @NotNull MaskPartyScriptTaskModel task, final boolean z10, @NotNull final Function0<p> playCallback) {
        s.i(task, "task");
        s.i(playCallback, "playCallback");
        if (context == null) {
            return;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ScriptTaskLayout scriptTaskLayout = new ScriptTaskLayout(context);
        scriptTaskLayout.c(task, z10);
        scriptTaskLayout.setPlayScriptCallback(new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyScriptHelper$showScriptTask$layout$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlertDialog alertDialog = ref$ObjectRef.element;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (z10) {
                    return;
                }
                playCallback.invoke();
            }
        });
        ref$ObjectRef.element = c(context, scriptTaskLayout);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [android.app.AlertDialog, T] */
    public final void g(@Nullable Context context, @NotNull List<ScriptRoleModel> roleList, @NotNull final Function1<? super ScriptRoleModel, p> selectCallback) {
        s.i(roleList, "roleList");
        s.i(selectCallback, "selectCallback");
        if (context == null) {
            return;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ScriptSelectRoleLayout scriptSelectRoleLayout = new ScriptSelectRoleLayout(context);
        scriptSelectRoleLayout.e(roleList);
        scriptSelectRoleLayout.setSelectRoleCallback(new Function1<ScriptRoleModel, p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyScriptHelper$showSelectRole$layout$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ScriptRoleModel scriptRoleModel) {
                invoke2(scriptRoleModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ScriptRoleModel it) {
                s.i(it, "it");
                AlertDialog alertDialog = ref$ObjectRef.element;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                selectCallback.invoke(it);
            }
        });
        ref$ObjectRef.element = c(context, scriptSelectRoleLayout);
    }

    public final void h(int i10, int i11, @NotNull final Function1<? super Integer, p> tickCallback) {
        s.i(tickCallback, "tickCallback");
        f16349b = new i();
        int max = Math.max(i10, i11);
        i iVar = f16349b;
        if (iVar != null) {
            i.d(iVar, Integer.valueOf(max), 1, null, new Function1<Integer, p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyScriptHelper$startCountDown$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Integer num) {
                    invoke(num.intValue());
                    return p.f51048a;
                }

                public final void invoke(int i12) {
                    int i13;
                    int i14;
                    MaskPartyScriptHelper maskPartyScriptHelper = MaskPartyScriptHelper.f16348a;
                    i13 = MaskPartyScriptHelper.f16350c;
                    MaskPartyScriptHelper.f16350c = i13 + 1;
                    Function1<Integer, p> function1 = tickCallback;
                    i14 = MaskPartyScriptHelper.f16350c;
                    function1.invoke(Integer.valueOf(i14));
                }
            }, 4, null);
        }
    }

    public final void i() {
        f16350c = 0;
        i iVar = f16349b;
        if (iVar != null) {
            iVar.g();
        }
        f16349b = null;
    }
}
