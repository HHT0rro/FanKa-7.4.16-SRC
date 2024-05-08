package com.cupidapp.live.liveshow.view.bottommenu;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import e1.a;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.x;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReportLiveShowHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ReportLiveShowHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ReportLiveShowHelper f15334a = new ReportLiveShowHelper();

    public static final void d(Context context, List reportList, DialogInterface dialogInterface, int i10) {
        s.i(reportList, "$reportList");
        f15334a.b(context, (String) CollectionsKt___CollectionsKt.S(((Map) reportList.get(i10)).h()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(final Context context, String str) {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        Observable b4 = a.C0726a.b(NetworkClient.f11868a.i(), itemId, str, null, 4, null);
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = b4.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.ReportLiveShowHelper$report$$inlined$handleByContext$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                com.cupidapp.live.base.view.h.f12779a.c(context, R$string.report_success);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void c(@Nullable final Context context) {
        final List<Map<String, String>> reportType;
        ConstantsResult q10 = p1.g.f52734a.q();
        if (q10 == null || (reportType = q10.getReportType()) == null) {
            return;
        }
        AlertDialog.Builder e2 = z0.b.f54812a.e(context);
        ArrayList arrayList = new ArrayList();
        Iterator<Map<String, String>> iterator2 = reportType.iterator2();
        while (iterator2.hasNext()) {
            x.x(arrayList, iterator2.next().values());
        }
        AlertDialog create = e2.setAdapter(new g(arrayList), new DialogInterface.OnClickListener() { // from class: com.cupidapp.live.liveshow.view.bottommenu.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                ReportLiveShowHelper.d(context, reportType, dialogInterface, i10);
            }
        }).create();
        create.show();
        Window window = create.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.dialog_translate_anim);
            window.setLayout(z0.h.c(window, 200.0f), -2);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }
}
