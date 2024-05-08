package com.cupidapp.live.liveshow.view.sticker;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.EditInputBottomSheetDialog;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.view.drag.FKBaseDragLayout;
import com.cupidapp.live.liveshow.model.LiveStickerViewInfoModel;
import com.cupidapp.live.liveshow.model.LiveStickerViewType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: LiveStickerLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveStickerLayout extends FKBaseDragLayout {

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public EditText f15920m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public EditInputBottomSheetDialog f15921n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public String f15922o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public Function0<p> f15923p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15924q;

    /* compiled from: TextView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements TextWatcher {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EditText f15925b;

        public a(EditText editText) {
            this.f15925b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
            if (charSequence == null || charSequence.length() <= 20) {
                return;
            }
            this.f15925b.setText(charSequence.subSequence(0, 20).toString());
            this.f15925b.setSelection(Math.min(i10 + i12, 20));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveStickerLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15924q = new LinkedHashMap();
        q();
    }

    public static final boolean p(LiveStickerLayout this$0, EditText editText, TextView textView, int i10, KeyEvent keyEvent) {
        s.i(this$0, "this$0");
        s.i(editText, "$editText");
        if (i10 != 4) {
            return true;
        }
        this$0.m(editText);
        return true;
    }

    public static final void s(EditInputBottomSheetDialog this_apply, EditText editText, DialogInterface dialogInterface) {
        s.i(this_apply, "$this_apply");
        Context context = this_apply.getContext();
        s.h(context, "context");
        s.h(editText, "editText");
        h.v(context, editText);
    }

    @Nullable
    public final String getTextStickerContent() {
        return this.f15922o;
    }

    @Nullable
    public View i(int i10) {
        Map<Integer, View> map = this.f15924q;
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

    public final void k() {
        this.f15922o = null;
    }

    public final void l(@NotNull LiveStickerViewInfoModel model) {
        s.i(model, "model");
        if (model.getWidth() != null && model.getWidth().intValue() > 0 && model.getHeight() != null && model.getHeight().intValue() > 0) {
            ConstraintLayout text_sticker_root_layout = (ConstraintLayout) i(R$id.text_sticker_root_layout);
            s.h(text_sticker_root_layout, "text_sticker_root_layout");
            y.n(text_sticker_root_layout, model.getWidth(), model.getHeight());
        } else {
            ConstraintLayout text_sticker_root_layout2 = (ConstraintLayout) i(R$id.text_sticker_root_layout);
            s.h(text_sticker_root_layout2, "text_sticker_root_layout");
            y.n(text_sticker_root_layout2, Integer.valueOf(h.c(this, 170.0f)), Integer.valueOf(h.c(this, 60.0f)));
        }
        ImageLoaderView text_sticker_img_bg = (ImageLoaderView) i(R$id.text_sticker_img_bg);
        s.h(text_sticker_img_bg, "text_sticker_img_bg");
        ImageLoaderView.f(text_sticker_img_bg, new com.cupidapp.live.base.imageloader.b(false, model.getImageUrl(), null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
        Integer type = model.getType();
        int value = LiveStickerViewType.TEXT.getValue();
        if (type != null && type.intValue() == value) {
            this.f15922o = model.getContent();
            int i10 = R$id.text_sticker_text_view;
            ((TextView) i(i10)).setVisibility(0);
            TextView textView = (TextView) i(i10);
            String content = model.getContent();
            if (content == null) {
                content = model.getDefaultTipContent();
            }
            textView.setText(content);
            return;
        }
        int value2 = LiveStickerViewType.IMAGE.getValue();
        if (type != null && type.intValue() == value2) {
            ((TextView) i(R$id.text_sticker_text_view)).setVisibility(8);
        }
    }

    public final void m(EditText editText) {
        String obj = editText.getText().toString();
        if (StringsKt__StringsKt.P0(obj).toString().length() == 0) {
            com.cupidapp.live.base.view.h.f12779a.k(R$string.please_enter_correct_sticker_content);
            return;
        }
        this.f15922o = obj;
        Function0<p> function0 = this.f15923p;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void n(@Nullable String str) {
        ((TextView) i(R$id.text_sticker_text_view)).setText(str);
        EditInputBottomSheetDialog editInputBottomSheetDialog = this.f15921n;
        if (editInputBottomSheetDialog != null) {
            editInputBottomSheetDialog.dismiss();
        }
    }

    public final void o(final EditText editText) {
        editText.setInputType(262144);
        editText.setSingleLine(true);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.cupidapp.live.liveshow.view.sticker.f
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                boolean p10;
                p10 = LiveStickerLayout.p(LiveStickerLayout.this, editText, textView, i10, keyEvent);
                return p10;
            }
        });
        editText.addTextChangedListener(new a(editText));
    }

    public final void q() {
        z.a(this, R$layout.layout_live_sticker, true);
    }

    public final void r(@Nullable Integer num, @NotNull Function0<p> confirmCallback) {
        s.i(confirmCallback, "confirmCallback");
        int value = LiveStickerViewType.TEXT.getValue();
        if (num != null && num.intValue() == value) {
            this.f15923p = confirmCallback;
            if (this.f15921n == null) {
                View inflate = View.inflate(getContext(), R$layout.layout_live_text_sticker_input_box, null);
                final EditText editText = (EditText) inflate.findViewById(R$id.text_sticker_edit_text);
                s.h(editText, "editText");
                o(editText);
                this.f15920m = editText;
                ImageView confirmBtn = (ImageView) inflate.findViewById(R$id.text_sticker_input_box_confirm_btn);
                Context context = getContext();
                s.h(context, "context");
                final EditInputBottomSheetDialog editInputBottomSheetDialog = new EditInputBottomSheetDialog(context, false, 2, null);
                editInputBottomSheetDialog.setContentView(inflate);
                editInputBottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.liveshow.view.sticker.e
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        LiveStickerLayout.s(EditInputBottomSheetDialog.this, editText, dialogInterface);
                    }
                });
                s.h(confirmBtn, "confirmBtn");
                y.d(confirmBtn, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.sticker.LiveStickerLayout$showInputBoxDialog$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        LiveStickerLayout liveStickerLayout = LiveStickerLayout.this;
                        EditText editText2 = editText;
                        s.h(editText2, "editText");
                        liveStickerLayout.m(editText2);
                    }
                });
                this.f15921n = editInputBottomSheetDialog;
            }
            String str = this.f15922o;
            if (str == null || str.length() == 0) {
                EditText editText2 = this.f15920m;
                if (editText2 != null) {
                    editText2.setText((CharSequence) null);
                }
            } else {
                EditText editText3 = this.f15920m;
                if (editText3 != null) {
                    editText3.setText(str);
                }
                EditText editText4 = this.f15920m;
                if (editText4 != null) {
                    editText4.setSelection(str.length());
                }
            }
            EditInputBottomSheetDialog editInputBottomSheetDialog2 = this.f15921n;
            if (editInputBottomSheetDialog2 != null) {
                editInputBottomSheetDialog2.show();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveStickerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15924q = new LinkedHashMap();
        q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveStickerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15924q = new LinkedHashMap();
        q();
    }
}
