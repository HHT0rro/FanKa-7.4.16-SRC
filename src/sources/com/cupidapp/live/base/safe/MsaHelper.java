package com.cupidapp.live.base.safe;

import android.content.Context;
import com.bun.miitmdid.core.ErrorCode;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.utils.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;

/* compiled from: MsaHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MsaHelper implements IIdentifierListener {

    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: MsaHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            s.i(context, "context");
            try {
                new MsaHelper().getDeviceId(context);
            } catch (Exception e2) {
                j.a aVar = j.f12332a;
                Throwable cause = e2.getCause();
                aVar.a("MsaHelper", "initFaild: " + ((Object) cause) + e2.getMessage());
            }
        }
    }

    private final void checkUpdateOAIDValueToService(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return;
        }
        if ((str == null || str.length() == 0) || !s.d(str, str2)) {
            Disposable disposed = NetworkClient.f11868a.I().b(ImeiHelper.f12176a.e(), h.d(str2)).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.safe.MsaHelper$checkUpdateOAIDValueToService$$inlined$handle$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                    j.f12332a.a("MsaHelper", "UpdateOAIDValueToService succeed");
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.safe.MsaHelper$checkUpdateOAIDValueToService$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    s.i(it, "it");
                    j.f12332a.a("MsaHelper", "UpdateOAIDValueToService failed");
                    return Boolean.TRUE;
                }
            }, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getDeviceId(Context context) {
        try {
            switch (MdidSdkHelper.InitSdk(context, true, this)) {
                case ErrorCode.INIT_ERROR_MANUFACTURER_NOSUPPORT /* 1008611 */:
                    j.f12332a.a("MsaHelper", "1008611 不支持的设备厂商");
                    break;
                case ErrorCode.INIT_ERROR_DEVICE_NOSUPPORT /* 1008612 */:
                    j.f12332a.a("MsaHelper", "1008612 不支持的设备");
                    break;
                case ErrorCode.INIT_ERROR_LOAD_CONFIGFILE /* 1008613 */:
                    j.f12332a.a("MsaHelper", "1008613 加载配置文件出错");
                    break;
                case ErrorCode.INIT_ERROR_RESULT_DELAY /* 1008614 */:
                    j.f12332a.a("MsaHelper", "1008614 获取接口是异步的，结果会在回调中返回，回调执行的回调可能在工作线程");
                    break;
                case ErrorCode.INIT_HELPER_CALL_ERROR /* 1008615 */:
                    j.f12332a.a("MsaHelper", "1008615 反射调用出错");
                    break;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdentifierListener
    public void OnSupport(boolean z10, @Nullable IdSupplier idSupplier) {
        try {
            j.f12332a.a("MsaHelper", "p0:" + z10 + "  oaid:" + (idSupplier != null ? idSupplier.getOAID() : null));
            if (z10) {
                g gVar = g.f52734a;
                checkUpdateOAIDValueToService(gVar.f().c(), idSupplier != null ? idSupplier.getOAID() : null);
                gVar.f().d(idSupplier != null ? idSupplier.getOAID() : null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
