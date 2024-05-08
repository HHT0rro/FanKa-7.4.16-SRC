package com.cupidapp.live.voiceparty.layout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.voiceparty.model.VoicePartyQuestionModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: VoiceQuestionTypeItemLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoiceQuestionTypeItemLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f19032b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceQuestionTypeItemLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f19032b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f19032b;
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

    public final void b(@NotNull VoicePartyQuestionModel model) {
        com.cupidapp.live.base.imageloader.b bVar;
        s.i(model, "model");
        VoiceQuestionType a10 = VoiceQuestionType.Companion.a(model.getType());
        if (a10 != null) {
            if (model.getCanSelect()) {
                bVar = new com.cupidapp.live.base.imageloader.b(false, null, null, null, Integer.valueOf(a10.getTypeImage()), null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 516079, null);
            } else {
                bVar = new com.cupidapp.live.base.imageloader.b(false, null, null, null, Integer.valueOf(a10.getTypeImage()), null, null, 0, 0, null, null, null, null, true, 0, 0, false, null, null, 516079, null);
            }
            ImageLoaderView voice_question_type_img = (ImageLoaderView) a(R$id.voice_question_type_img);
            s.h(voice_question_type_img, "voice_question_type_img");
            ImageLoaderView.f(voice_question_type_img, bVar, null, 2, null);
        }
        String desc = model.getDesc();
        if (desc == null || desc.length() == 0) {
            return;
        }
        int i10 = R$id.voice_question_type_open_hours;
        TextView textView = (TextView) a(i10);
        if (model.getCanSelect()) {
            textView.setTextColor(-15066598);
            textView.setBackgroundTintList(ColorStateList.valueOf(-13703535));
            textView.setBackgroundResource(R$drawable.shape_white_bg_two_corners);
        } else {
            textView.setTextColor(-1);
            textView.setBackgroundTintList(ColorStateList.valueOf(h.a(-16777216, 0.77f)));
            textView.setBackgroundResource(R$drawable.shape_white_bg_two_corners);
        }
        ((TextView) textView.findViewById(i10)).setText(model.getDesc());
    }

    public final void c() {
        z.a(this, R$layout.layout_voice_question_type_item, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceQuestionTypeItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f19032b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceQuestionTypeItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f19032b = new LinkedHashMap();
        c();
    }
}
