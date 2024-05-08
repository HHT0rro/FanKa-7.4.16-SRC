package com.cupidapp.live.base.permission;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;

/* compiled from: RxPermissionHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RxPermissionHelperKt {

    /* renamed from: a */
    @NotNull
    public static final List<PermissionType> f12022a = new ArrayList();

    /* renamed from: b */
    @NotNull
    public static final List<xb.a> f12023b = new ArrayList();

    /* renamed from: c */
    @Nullable
    public static FKAlertDialog f12024c;

    /* compiled from: RxPermissionHelper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f12025a;

        static {
            int[] iArr = new int[PermissionType.values().length];
            try {
                iArr[PermissionType.StoragePermission.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PermissionType.LocationPermission.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PermissionType.CameraPermission.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PermissionType.AudioPermission.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f12025a = iArr;
        }
    }

    @Nullable
    public static final FKAlertDialog e() {
        return f12024c;
    }

    @NotNull
    public static final String f(@NotNull Context context, @NotNull PermissionType permissionType) {
        s.i(context, "context");
        s.i(permissionType, "permissionType");
        int i10 = a.f12025a[permissionType.ordinal()];
        if (i10 == 1) {
            String string = context.getString(R$string.storage);
            s.h(string, "context.getString(R.string.storage)");
            return string;
        }
        if (i10 == 2) {
            String string2 = context.getString(R$string.location_str);
            s.h(string2, "context.getString(R.string.location_str)");
            return string2;
        }
        if (i10 == 3) {
            String string3 = context.getString(R$string.camera);
            s.h(string3, "context.getString(R.string.camera)");
            return string3;
        }
        if (i10 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        String string4 = context.getString(R$string.microphone);
        s.h(string4, "context.getString(R.string.microphone)");
        return string4;
    }

    public static final String g(Context context, List<? extends PermissionType> list) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<? extends PermissionType> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            String str = f(context, iterator2.next()) + "、";
            if (!StringsKt__StringsKt.K(stringBuffer, str, false, 2, null)) {
                stringBuffer.append(str);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        s.h(stringBuffer2, "stringBuffer.toString()");
        String substring = stringBuffer2.substring(0, stringBuffer.length() - 1);
        s.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean h(@NotNull Context context, @NotNull PermissionType permissionType) {
        s.i(context, "context");
        s.i(permissionType, "permissionType");
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        for (String str : permissionType.getPermission()) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
    }

    public static final void i(Context context, List<? extends PermissionType> list, b bVar, boolean z10) {
        List<xb.a> list2 = f12023b;
        ArrayList arrayList = new ArrayList();
        for (xb.a aVar : list2) {
            if (aVar.f54609b) {
                arrayList.add(aVar);
            }
        }
        List<xb.a> list3 = f12023b;
        ArrayList arrayList2 = new ArrayList();
        for (xb.a aVar2 : list3) {
            if (aVar2.f54610c) {
                arrayList2.add(aVar2);
            }
        }
        j.a aVar3 = j.f12332a;
        List<xb.a> list4 = f12023b;
        aVar3.a("RxPermissionHelper", "grantedList: " + ((Object) arrayList) + " resultList: " + ((Object) list4) + " callback: " + ((Object) bVar));
        if (arrayList.size() == list4.size()) {
            if (bVar != null) {
                bVar.a();
            }
        } else if (!arrayList2.isEmpty()) {
            if (bVar != null) {
                bVar.c();
            }
        } else if (z10) {
            o(context, list, bVar);
        } else if (bVar != null) {
            bVar.d();
        }
        list4.clear();
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [T, com.cupidapp.live.base.permission.FKPermissionInstructionsForUseLayout] */
    public static final void j(final Context context, final xb.b bVar, final List<? extends PermissionType> list, final b bVar2, final boolean z10) {
        j.a aVar = j.f12332a;
        List<PermissionType> list2 = f12022a;
        aVar.a("RxPermissionHelper", "permissionList: " + ((Object) list2));
        if (list2.isEmpty()) {
            i(context, list, bVar2, z10);
            return;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final PermissionType permissionType = (PermissionType) CollectionsKt___CollectionsKt.T(list2);
        String str = (String) m.x(permissionType.getPermission());
        boolean z11 = ContextCompat.checkSelfPermission(context, str) == -1;
        PermissionRequestModel c4 = g.f52734a.B1().c();
        if (c4 == null) {
            c4 = new PermissionRequestModel(new ArrayList());
        }
        final PermissionRequestModel permissionRequestModel = c4;
        if (z11) {
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if ((activity != null ? ActivityCompat.shouldShowRequestPermissionRationale(activity, str) : false) || !permissionRequestModel.getPermissionList().contains(permissionType)) {
                ?? fKPermissionInstructionsForUseLayout = new FKPermissionInstructionsForUseLayout(context);
                ref$ObjectRef.element = fKPermissionInstructionsForUseLayout;
                fKPermissionInstructionsForUseLayout.e(permissionType);
            }
        }
        String[] permission = permissionType.getPermission();
        Observable<xb.a> n10 = bVar.n((String[]) Arrays.copyOf(permission, permission.length));
        final Function1<xb.a, p> function1 = new Function1<xb.a, p>() { // from class: com.cupidapp.live.base.permission.RxPermissionHelperKt$requestEachPermission$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(xb.a aVar2) {
                invoke2(aVar2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(xb.a result) {
                List list3;
                List list4;
                List list5;
                j.f12332a.a("RxPermissionHelper", "result: " + ((Object) result));
                if (!PermissionRequestModel.this.getPermissionList().contains(permissionType)) {
                    PermissionRequestModel.this.getPermissionList().add(permissionType);
                    g.f52734a.B1().d(PermissionRequestModel.this);
                }
                list3 = RxPermissionHelperKt.f12022a;
                if (list3.size() > 0) {
                    list5 = RxPermissionHelperKt.f12022a;
                    list5.remove(0);
                }
                list4 = RxPermissionHelperKt.f12023b;
                s.h(result, "result");
                list4.add(result);
                FKPermissionInstructionsForUseLayout fKPermissionInstructionsForUseLayout2 = ref$ObjectRef.element;
                if (fKPermissionInstructionsForUseLayout2 != null) {
                    fKPermissionInstructionsForUseLayout2.c();
                }
                RxPermissionHelperKt.j(context, bVar, list, bVar2, z10);
            }
        };
        n10.subscribe(new Consumer() { // from class: com.cupidapp.live.base.permission.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RxPermissionHelperKt.k(Function1.this, obj);
            }
        });
    }

    public static final void k(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void l(@NotNull Context context, @NotNull xb.b rxPermissions, @NotNull List<? extends PermissionType> permissionTypeList, @Nullable b bVar, boolean z10) {
        s.i(context, "context");
        s.i(rxPermissions, "rxPermissions");
        s.i(permissionTypeList, "permissionTypeList");
        f12022a.addAll(permissionTypeList);
        j(context, rxPermissions, permissionTypeList, bVar, z10);
    }

    public static /* synthetic */ void m(Context context, xb.b bVar, List list, b bVar2, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            bVar2 = null;
        }
        if ((i10 & 16) != 0) {
            z10 = true;
        }
        l(context, bVar, list, bVar2, z10);
    }

    public static final void n(@Nullable FKAlertDialog fKAlertDialog) {
        f12024c = fKAlertDialog;
    }

    public static final void o(final Context context, List<? extends PermissionType> list, final b bVar) {
        String string = context.getString(R$string.permission_request_content, g(context, list));
        s.h(string, "context.getString(\n     …permissionTypeList)\n    )");
        FKAlertDialog j10 = FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null).D(R$string.permission_request_title).n(string), R$string.go_to_set, null, new Function0<p>() { // from class: com.cupidapp.live.base.permission.RxPermissionHelperKt$showPermissionAlert$1
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
                h.o(context);
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.b();
                }
                RxPermissionHelperKt.n(null);
            }
        }, 2, null), 0, new Function0<p>() { // from class: com.cupidapp.live.base.permission.RxPermissionHelperKt$showPermissionAlert$2
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
                b bVar2 = b.this;
                if (bVar2 != null) {
                    bVar2.d();
                }
                RxPermissionHelperKt.n(null);
            }
        }, 1, null).j(false);
        f12024c = j10;
        if (j10 != null) {
            FKAlertDialog.G(j10, null, 1, null);
        }
    }
}
