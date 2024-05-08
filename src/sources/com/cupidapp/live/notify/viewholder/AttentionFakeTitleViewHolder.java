package com.cupidapp.live.notify.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.dialog.BgColor;
import com.cupidapp.live.base.view.dialog.BgType;
import com.cupidapp.live.base.view.dialog.FKPointerDialog;
import com.cupidapp.live.base.view.dialog.PointerPos;
import com.cupidapp.live.notify.fragment.NotifyContainerNewFragment;
import com.cupidapp.live.notify.model.NotifyPopupInfoModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: AttentionFakeTitleViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AttentionFakeTitleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17569c = new a(null);

    /* compiled from: AttentionFakeTitleViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AttentionFakeTitleViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new AttentionFakeTitleViewHolder(z.b(parent, R$layout.view_holder_attention_fake_title, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttentionFakeTitleViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        ((TextView) itemView.findViewById(R$id.attentionFakeTitleTextView)).getPaint().setFakeBoldText(true);
    }

    public static final void t(AttentionFakeTitleViewHolder this$0, Ref$ObjectRef content, TextView textView) {
        s.i(this$0, "this$0");
        s.i(content, "$content");
        List<Integer> m10 = kotlin.collections.s.m(-14848, -35328);
        FKPointerDialog.a aVar = FKPointerDialog.f12718p;
        Context context = this$0.itemView.getContext();
        s.h(context, "itemView.context");
        FKPointerDialog.y(aVar.a(context).l(BgType.GRADIENT).k(m10).n((CharSequence) content.element).q(PointerPos.TOP_CENTER, BgColor.DEFAULT).m(false).j(Float.valueOf(0.0f)), textView, 0, h.c(this$0, 4.0f), 0, 10, null);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable final Object obj) {
        if (obj instanceof AttentionFakeTitleViewModel) {
            View view = this.itemView;
            int i10 = R$id.attentionFakeTitleTextView;
            AttentionFakeTitleViewModel attentionFakeTitleViewModel = (AttentionFakeTitleViewModel) obj;
            ((TextView) view.findViewById(i10)).setText(attentionFakeTitleViewModel.getText());
            String btnText = attentionFakeTitleViewModel.getBtnText();
            if (btnText != null && !TextUtils.isEmpty(btnText)) {
                View view2 = this.itemView;
                int i11 = R$id.btn_action;
                TextView textView = (TextView) view2.findViewById(i11);
                if (textView != null) {
                    textView.setText(btnText);
                }
                TextView btn_action = (TextView) this.itemView.findViewById(i11);
                if (btn_action != null) {
                    s.h(btn_action, "btn_action");
                    y.d(btn_action, new Function1<View, p>() { // from class: com.cupidapp.live.notify.viewholder.AttentionFakeTitleViewHolder$config$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ p invoke(View view3) {
                            invoke2(view3);
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@Nullable View view3) {
                            String btnAction = ((AttentionFakeTitleViewModel) Object.this).getBtnAction();
                            if (btnAction != null) {
                                Object obj2 = Object.this;
                                AttentionFakeTitleViewHolder attentionFakeTitleViewHolder = this;
                                SensorsLogKeyButtonClick.f12211a.c(SensorPosition.NotifyAloha.getValue(), ((AttentionFakeTitleViewModel) obj2).getBtnText());
                                j.f12156c.a(attentionFakeTitleViewHolder.itemView.getContext(), btnAction, null);
                            }
                        }
                    });
                }
                s(attentionFakeTitleViewModel.getPopupInfo());
            }
            if (TextUtils.isEmpty(attentionFakeTitleViewModel.getBtnText())) {
                TextView textView2 = (TextView) this.itemView.findViewById(R$id.btn_action);
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                TextView textView3 = (TextView) this.itemView.findViewById(i10);
                if (textView3 != null) {
                    textView3.setGravity(17);
                    this.itemView.setBackgroundResource(0);
                    this.itemView.setElevation(0.0f);
                    textView3.setTextColor(ContextCompat.getColor(textView3.getContext(), R$color.gray_7C7C7C));
                    return;
                }
                return;
            }
            TextView textView4 = (TextView) this.itemView.findViewById(R$id.btn_action);
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            TextView textView5 = (TextView) this.itemView.findViewById(i10);
            if (textView5 != null) {
                textView5.setGravity(8388611);
                this.itemView.setBackgroundResource(R$drawable.shape_white_r12);
                this.itemView.setElevation(h.c(this, 2.0f));
                textView5.setTextColor(ContextCompat.getColor(textView5.getContext(), R$color.black_40));
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v17, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v18, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v22, types: [T, java.lang.String] */
    public final void s(NotifyPopupInfoModel notifyPopupInfoModel) {
        if (notifyPopupInfoModel != null) {
            NotifyContainerNewFragment.a aVar = NotifyContainerNewFragment.f17540h;
            if (aVar.a()) {
                final TextView textView = (TextView) this.itemView.findViewById(R$id.btn_action);
                if (textView.getVisibility() != 0) {
                    return;
                }
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = "";
                String title = notifyPopupInfoModel.getTitle();
                if (!(title == null || title.length() == 0)) {
                    ref$ObjectRef.element = notifyPopupInfoModel.getTitle();
                }
                String subTitle = notifyPopupInfoModel.getSubTitle();
                if (!(subTitle == null || subTitle.length() == 0)) {
                    if (((CharSequence) ref$ObjectRef.element).length() == 0) {
                        ref$ObjectRef.element = notifyPopupInfoModel.getSubTitle();
                    } else {
                        ref$ObjectRef.element = ref$ObjectRef.element + "\n" + notifyPopupInfoModel.getSubTitle();
                    }
                }
                if (((CharSequence) ref$ObjectRef.element).length() == 0) {
                    return;
                }
                aVar.c(false);
                GroupOthersLog.L(GroupOthersLog.f18702a, SensorPosition.NotifyAloha, notifyPopupInfoModel.getActName(), null, 4, null);
                textView.post(new Runnable() { // from class: com.cupidapp.live.notify.viewholder.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AttentionFakeTitleViewHolder.t(AttentionFakeTitleViewHolder.this, ref$ObjectRef, textView);
                    }
                });
            }
        }
    }
}
