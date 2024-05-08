package com.cupidapp.live.chat.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$style;
import com.cupidapp.live.chat.fragment.BottomFaceDialog;
import com.cupidapp.live.chat.model.CustomEmojiCode;
import com.cupidapp.live.chat.view.FaceLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BottomFaceDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BottomFaceDialog extends AppCompatDialogFragment {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13137d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public b f13138b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13139c = new LinkedHashMap();

    /* compiled from: BottomFaceDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BottomFaceDialog a() {
            return new BottomFaceDialog();
        }
    }

    /* compiled from: BottomFaceDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface b {
        void a(@NotNull CustomEmojiCode customEmojiCode);
    }

    public static final void R0(BottomFaceDialog this$0, View view) {
        s.i(this$0, "this$0");
        this$0.dismiss();
    }

    public void O0() {
        this.f13139c.clear();
    }

    @Nullable
    public View P0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f13139c;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void S0(@NotNull FragmentManager manager, @NotNull b clickListener) {
        s.i(manager, "manager");
        s.i(clickListener, "clickListener");
        this.f13138b = clickListener;
        super.show(manager, BottomFaceDialog.class.getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.dialog_bottom_face, viewGroup, false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setGravity(80);
            }
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setBackgroundDrawableResource(17170445);
            }
            Window window3 = dialog.getWindow();
            if (window3 != null) {
                window3.setLayout(-1, -1);
            }
            Window window4 = dialog.getWindow();
            if (window4 != null) {
                window4.setWindowAnimations(R$style.dialog_translate_anim);
            }
        }
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        ((ConstraintLayout) P0(R$id.face_root)).setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.chat.fragment.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BottomFaceDialog.R0(BottomFaceDialog.this, view2);
            }
        });
        int l10 = ((z0.h.l(this) - z0.h.c(this, 18.0f)) / 7) - z0.h.c(this, 6.0f);
        int i10 = R$id.face_layout;
        ((FaceLayout) P0(i10)).e(l10, l10);
        ((FaceLayout) P0(i10)).setItemClickListener(new Function1<CustomEmojiCode, p>() { // from class: com.cupidapp.live.chat.fragment.BottomFaceDialog$onViewCreated$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(CustomEmojiCode customEmojiCode) {
                invoke2(customEmojiCode);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull CustomEmojiCode it) {
                BottomFaceDialog.b bVar;
                s.i(it, "it");
                bVar = BottomFaceDialog.this.f13138b;
                if (bVar != null) {
                    bVar.a(it);
                }
                BottomFaceDialog.this.dismiss();
            }
        });
    }
}
