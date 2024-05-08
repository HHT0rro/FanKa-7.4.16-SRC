package com.cupidapp.live.voiceparty.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.voiceparty.layout.VoiceQuestionLayout;
import com.cupidapp.live.voiceparty.model.VoicePartyQuestionItemModel;
import com.cupidapp.live.voiceparty.model.VoicePartyQuestionModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: VoiceQuestionLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoiceQuestionLayout extends FrameLayout {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f19026g = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<List<VoicePartyQuestionItemModel>> f19027b;

    /* renamed from: c, reason: collision with root package name */
    public int f19028c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public b f19029d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public VoicePartyQuestionModel f19030e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f19031f;

    /* compiled from: VoiceQuestionLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: VoiceQuestionLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void a(int i10);

        void b(@NotNull VoicePartyQuestionItemModel voicePartyQuestionItemModel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceQuestionLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f19031f = new LinkedHashMap();
        this.f19027b = new ArrayList();
        k();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f19031f;
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

    public final void f() {
        if (this.f19028c == this.f19027b.size() - 1) {
            this.f19028c = 0;
        } else {
            this.f19028c++;
        }
        i();
    }

    public final void g() {
        VoicePartyQuestionModel voicePartyQuestionModel = this.f19030e;
        if (voicePartyQuestionModel != null) {
            h(voicePartyQuestionModel);
        }
    }

    public final void h(VoicePartyQuestionModel voicePartyQuestionModel) {
        this.f19028c = 0;
        this.f19027b.clear();
        List<VoicePartyQuestionItemModel> questions = voicePartyQuestionModel.getQuestions();
        if (questions == null || questions.isEmpty()) {
            return;
        }
        int size = voicePartyQuestionModel.getQuestions().size() / 3;
        for (int i10 = 0; i10 < size; i10++) {
            int i11 = i10 * 3;
            this.f19027b.add(voicePartyQuestionModel.getQuestions().subList(i11, i11 + 3));
        }
        ((TextView) a(R$id.voice_question_title)).setText(getContext().getString(R$string.you_choose_certain_type_question, voicePartyQuestionModel.getTypeName()));
        ((Group) a(R$id.choose_question_type_group)).setVisibility(8);
        ((Group) a(R$id.choose_question_content_group)).setVisibility(0);
        i();
    }

    public final void i() {
        TextView voice_first_question_content = (TextView) a(R$id.voice_first_question_content);
        s.h(voice_first_question_content, "voice_first_question_content");
        int i10 = 0;
        TextView voice_second_question_content = (TextView) a(R$id.voice_second_question_content);
        s.h(voice_second_question_content, "voice_second_question_content");
        TextView voice_third_question_content = (TextView) a(R$id.voice_third_question_content);
        s.h(voice_third_question_content, "voice_third_question_content");
        List m10 = kotlin.collections.s.m(voice_first_question_content, voice_second_question_content, voice_third_question_content);
        for (VoicePartyQuestionItemModel voicePartyQuestionItemModel : this.f19027b.get(this.f19028c)) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            final VoicePartyQuestionItemModel voicePartyQuestionItemModel2 = voicePartyQuestionItemModel;
            TextView textView = (TextView) CollectionsKt___CollectionsKt.W(m10, i10);
            if (textView != null) {
                u.a(textView);
                textView.setText(voicePartyQuestionItemModel2.getContent());
                y.d(textView, new Function1<View, p>() { // from class: com.cupidapp.live.voiceparty.layout.VoiceQuestionLayout$configQuestionItemUI$1$1
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
                        VoiceQuestionLayout.b bVar;
                        bVar = VoiceQuestionLayout.this.f19029d;
                        if (bVar != null) {
                            bVar.b(voicePartyQuestionItemModel2);
                        }
                    }
                });
            }
            i10 = i11;
        }
    }

    public final void j(@NotNull List<VoicePartyQuestionModel> list) {
        s.i(list, "list");
        ((TextView) a(R$id.voice_question_title)).setText(getContext().getString(R$string.you_win));
        int i10 = 0;
        ((Group) a(R$id.choose_question_type_group)).setVisibility(0);
        ((Group) a(R$id.choose_question_content_group)).setVisibility(8);
        VoiceQuestionTypeItemLayout voice_first_question_type = (VoiceQuestionTypeItemLayout) a(R$id.voice_first_question_type);
        s.h(voice_first_question_type, "voice_first_question_type");
        VoiceQuestionTypeItemLayout voice_second_question_type = (VoiceQuestionTypeItemLayout) a(R$id.voice_second_question_type);
        s.h(voice_second_question_type, "voice_second_question_type");
        VoiceQuestionTypeItemLayout voice_third_question_type = (VoiceQuestionTypeItemLayout) a(R$id.voice_third_question_type);
        s.h(voice_third_question_type, "voice_third_question_type");
        List m10 = kotlin.collections.s.m(voice_first_question_type, voice_second_question_type, voice_third_question_type);
        for (VoicePartyQuestionModel voicePartyQuestionModel : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            final VoicePartyQuestionModel voicePartyQuestionModel2 = voicePartyQuestionModel;
            VoiceQuestionTypeItemLayout voiceQuestionTypeItemLayout = (VoiceQuestionTypeItemLayout) CollectionsKt___CollectionsKt.W(m10, i10);
            if (voiceQuestionTypeItemLayout != null) {
                if (VoiceQuestionType.Companion.a(voicePartyQuestionModel2.getType()) != null) {
                    voiceQuestionTypeItemLayout.b(voicePartyQuestionModel2);
                }
                y.d(voiceQuestionTypeItemLayout, new Function1<View, p>() { // from class: com.cupidapp.live.voiceparty.layout.VoiceQuestionLayout$configQuestionTypeLayout$1$2
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
                        VoiceQuestionLayout.b bVar;
                        if (VoicePartyQuestionModel.this.getCanSelect()) {
                            if (VoicePartyQuestionModel.this.getType() == VoiceQuestionType.LateNight.getType()) {
                                this.f19030e = VoicePartyQuestionModel.this;
                            } else {
                                this.h(VoicePartyQuestionModel.this);
                            }
                            bVar = this.f19029d;
                            if (bVar != null) {
                                bVar.a(VoicePartyQuestionModel.this.getType());
                            }
                        }
                    }
                });
            }
            i10 = i11;
        }
    }

    public final void k() {
        z.a(this, R$layout.layout_voice_question, true);
        TextView voice_change_next_btn = (TextView) a(R$id.voice_change_next_btn);
        s.h(voice_change_next_btn, "voice_change_next_btn");
        y.d(voice_change_next_btn, new Function1<View, p>() { // from class: com.cupidapp.live.voiceparty.layout.VoiceQuestionLayout$initView$1
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
                VoiceQuestionLayout.this.f();
            }
        });
    }

    public final void setVoiceQuestionListener(@NotNull b listener) {
        s.i(listener, "listener");
        this.f19029d = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceQuestionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f19031f = new LinkedHashMap();
        this.f19027b = new ArrayList();
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceQuestionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f19031f = new LinkedHashMap();
        this.f19027b = new ArrayList();
        k();
    }
}
