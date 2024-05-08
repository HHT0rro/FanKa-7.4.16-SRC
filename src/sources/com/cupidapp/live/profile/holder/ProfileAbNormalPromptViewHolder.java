package com.cupidapp.live.profile.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ProfileAbNormalPromptViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileAbNormalPromptViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17818c = new a(null);

    /* compiled from: ProfileAbNormalPromptViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProfileAbNormalPromptViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            ProfileAbNormalPromptViewHolder profileAbNormalPromptViewHolder = new ProfileAbNormalPromptViewHolder(z.b(parent, R$layout.view_holder_profile_abnormal_prompt, false, 2, null));
            profileAbNormalPromptViewHolder.q();
            return profileAbNormalPromptViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileAbNormalPromptViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ProfileAbNormalPromptViewModel) {
            ProfileAbNormalPromptViewModel profileAbNormalPromptViewModel = (ProfileAbNormalPromptViewModel) obj;
            if (profileAbNormalPromptViewModel.getAbNormal()) {
                this.itemView.setVisibility(0);
                View view = this.itemView;
                int i10 = R$id.promptMessage;
                ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
                ((TextView) this.itemView.findViewById(i10)).setText(profileAbNormalPromptViewModel.getPrompt());
                return;
            }
            this.itemView.setVisibility(8);
        }
    }
}
