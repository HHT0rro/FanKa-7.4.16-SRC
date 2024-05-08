package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.profile.model.ZodiacElfInfoModel;
import com.cupidapp.live.profile.model.ZodiacElfType;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ZodiacElfMatchTipsLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ZodiacElfMatchTipsLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17018b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZodiacElfMatchTipsLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f17018b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f17018b;
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

    public final void b(@Nullable ZodiacElfInfoModel zodiacElfInfoModel) {
        Integer num = null;
        if ((zodiacElfInfoModel != null ? zodiacElfInfoModel.getType() : null) == null) {
            setVisibility(8);
            return;
        }
        Integer type = zodiacElfInfoModel.getType();
        int value = ZodiacElfType.HEART_BEAT.getValue();
        if (type != null && type.intValue() == value) {
            num = Integer.valueOf(R$drawable.match_zodiac_elf_only_zodiac_bg);
        } else {
            int value2 = ZodiacElfType.ASK_QUESTION.getValue();
            if (type != null && type.intValue() == value2) {
                num = Integer.valueOf(R$drawable.match_zodiac_elf_only_question_bg);
            } else {
                int value3 = ZodiacElfType.ZODIAC_ELF.getValue();
                if (type != null && type.intValue() == value3) {
                    num = Integer.valueOf(R$drawable.match_zodiac_elf_all_bg);
                }
            }
        }
        if (num == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        a(R$id.zodiac_elf_match_bg_view).setBackgroundResource(num.intValue());
        String title = zodiacElfInfoModel.getTitle();
        boolean z10 = true;
        if (title == null || title.length() == 0) {
            ((TextView) a(R$id.zodiac_elf_match_title_text)).setVisibility(8);
        } else {
            int i10 = R$id.zodiac_elf_match_title_text;
            ((TextView) a(i10)).setVisibility(0);
            ((TextView) a(i10)).setText(zodiacElfInfoModel.getTitle());
        }
        String subTitle = zodiacElfInfoModel.getSubTitle();
        if (subTitle != null && subTitle.length() != 0) {
            z10 = false;
        }
        if (z10) {
            ((TextView) a(R$id.zodiac_elf_match_content_text)).setVisibility(8);
            return;
        }
        int i11 = R$id.zodiac_elf_match_content_text;
        ((TextView) a(i11)).setVisibility(0);
        ((TextView) a(i11)).setText(zodiacElfInfoModel.getSubTitle());
    }

    public final void c() {
        z0.z.a(this, R$layout.layout_zodiac_elf_match_tips, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZodiacElfMatchTipsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f17018b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZodiacElfMatchTipsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f17018b = new LinkedHashMap();
        c();
    }
}
