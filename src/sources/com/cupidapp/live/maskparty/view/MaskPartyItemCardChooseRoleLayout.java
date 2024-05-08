package com.cupidapp.live.maskparty.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.maskparty.model.RoleType;
import com.cupidapp.live.maskparty.view.MaskPartyItemCardChooseRoleLayout;
import com.google.android.material.badge.BadgeDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.r;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: MaskPartyItemCardChooseRoleLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyItemCardChooseRoleLayout extends LinearLayout {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16400c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final List<RoleType> f16401d = s.m(RoleType.Top, RoleType.VersTop, RoleType.Vers, RoleType.VersBottom, RoleType.Bottom, RoleType.Others);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16402b;

    /* compiled from: MaskPartyItemCardChooseRoleLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* compiled from: MaskPartyItemCardChooseRoleLayout.kt */
        @kotlin.d
        /* renamed from: com.cupidapp.live.maskparty.view.MaskPartyItemCardChooseRoleLayout$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public /* synthetic */ class C0164a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f16403a;

            static {
                int[] iArr = new int[RoleType.values().length];
                try {
                    iArr[RoleType.Top.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RoleType.VersTop.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RoleType.Vers.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[RoleType.VersBottom.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[RoleType.Bottom.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[RoleType.Others.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                f16403a = iArr;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void c(MaskPartyItemCardChooseRoleLayout layout, Function1 chooseCallback, DialogInterface dialogInterface) {
            SensorsLogKeyButtonClick.PropCard propCard;
            kotlin.jvm.internal.s.i(layout, "$layout");
            kotlin.jvm.internal.s.i(chooseCallback, "$chooseCallback");
            ArrayList arrayList = new ArrayList();
            int childCount = layout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = layout.getChildAt(i10);
                kotlin.jvm.internal.s.h(childAt, "getChildAt(index)");
                if (childAt.isSelected()) {
                    arrayList.add(MaskPartyItemCardChooseRoleLayout.f16401d.get(i10));
                }
            }
            p1.g.f52734a.Q1(arrayList);
            chooseCallback.invoke(arrayList);
            if (!arrayList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList(t.t(arrayList, 10));
                Iterator<E> iterator2 = arrayList.iterator2();
                while (iterator2.hasNext()) {
                    switch (C0164a.f16403a[((RoleType) iterator2.next()).ordinal()]) {
                        case 1:
                            propCard = SensorsLogKeyButtonClick.PropCard.TOP;
                            break;
                        case 2:
                            propCard = SensorsLogKeyButtonClick.PropCard.VERS_TOP;
                            break;
                        case 3:
                            propCard = SensorsLogKeyButtonClick.PropCard.VERS;
                            break;
                        case 4:
                            propCard = SensorsLogKeyButtonClick.PropCard.VERS_BOTTOM;
                            break;
                        case 5:
                            propCard = SensorsLogKeyButtonClick.PropCard.BOTTOM;
                            break;
                        case 6:
                            propCard = SensorsLogKeyButtonClick.PropCard.OTHERS;
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    arrayList2.add(propCard.buttonName());
                }
                SensorsLogKeyButtonClick sensorsLogKeyButtonClick = SensorsLogKeyButtonClick.f12211a;
                String value = SensorPosition.PropCard.getValue();
                Iterator<E> iterator22 = arrayList2.iterator2();
                if (iterator22.hasNext()) {
                    Object next = iterator22.next();
                    while (iterator22.hasNext()) {
                        next = ((String) next) + "," + ((String) iterator22.next());
                    }
                    sensorsLogKeyButtonClick.c(value, (String) next);
                    return;
                }
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
        }

        public final void b(@NotNull Context context, @NotNull View anchorView, @NotNull final Function1<? super List<? extends RoleType>, p> chooseCallback) {
            AlertDialog g3;
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(anchorView, "anchorView");
            kotlin.jvm.internal.s.i(chooseCallback, "chooseCallback");
            int[] iArr = new int[2];
            anchorView.getLocationInWindow(iArr);
            int height = iArr[1] + anchorView.getHeight() + z0.h.c(this, 4.0f);
            final MaskPartyItemCardChooseRoleLayout maskPartyItemCardChooseRoleLayout = new MaskPartyItemCardChooseRoleLayout(context);
            maskPartyItemCardChooseRoleLayout.c();
            g3 = z0.b.f54812a.g(context, maskPartyItemCardChooseRoleLayout, iArr[0], height, z0.h.c(this, 160.0f), -2, (r32 & 64) != 0 ? 17 : BadgeDrawable.TOP_START, (r32 & 128) != 0 ? null : null, (r32 & 256) != 0 ? null : null, (r32 & 512) != 0 ? null : null, (r32 & 1024) != 0 ? null : null, (r32 & 2048) != 0 ? null : null, (r32 & 4096) != 0 ? null : null, (r32 & 8192) != 0 ? null : null);
            g3.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.maskparty.view.h
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    MaskPartyItemCardChooseRoleLayout.a.c(MaskPartyItemCardChooseRoleLayout.this, chooseCallback, dialogInterface);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyItemCardChooseRoleLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16402b = new LinkedHashMap();
        d();
    }

    public final void c() {
        List<RoleType> O0 = p1.g.f52734a.O0();
        for (RoleType roleType : f16401d) {
            boolean z10 = false;
            final View b4 = z.b(this, R$layout.layout_choose_role_item, false, 2, null);
            final TextView textView = (TextView) b4.findViewById(R$id.role_textview);
            final ImageView imageView = (ImageView) b4.findViewById(R$id.selected_imageview);
            textView.setText(roleType.getValue());
            if (O0 != null && O0.contains(roleType)) {
                z10 = true;
            }
            textView.getPaint().setFakeBoldText(z10);
            imageView.setSelected(z10);
            b4.setSelected(z10);
            y.d(b4, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyItemCardChooseRoleLayout$configChooseRoleLayout$1$1
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
                    if (View.this.isSelected()) {
                        textView.getPaint().setFakeBoldText(false);
                        imageView.setSelected(false);
                        View.this.setSelected(false);
                    } else {
                        textView.getPaint().setFakeBoldText(true);
                        imageView.setSelected(true);
                        View.this.setSelected(true);
                    }
                }
            });
            addView(b4);
        }
    }

    public final void d() {
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setOrientation(1);
        y.i(this, (r18 & 1) != 0 ? 0.0f : z0.h.c(this, 6.0f), r.e(-1), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyItemCardChooseRoleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16402b = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyItemCardChooseRoleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16402b = new LinkedHashMap();
        d();
    }
}
