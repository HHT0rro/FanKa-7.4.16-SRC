package com.huawei.openalliance.ad.download.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class j {
    public static final String Code = "AppPermissionsDialog";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void Code();
    }

    public static void Code(Context context, AppInfo appInfo) {
        Code(context, appInfo, null);
    }

    public static void Code(Context context, AppInfo appInfo, final a aVar) {
        int i10;
        Window window;
        gl.V(Code, "show, context:" + ((Object) context));
        AlertDialog.Builder Code2 = com.huawei.openalliance.ad.utils.m.Code(context);
        Code2.setTitle("");
        if (aVar != null) {
            Code2.setPositiveButton(R.string.hiad_dialog_accept, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.download.app.j.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i11) {
                    a.this.Code();
                }
            });
            i10 = R.string.hiad_dialog_cancel;
        } else {
            i10 = R.string.hiad_dialog_close;
        }
        Code2.setNeutralButton(i10, (DialogInterface.OnClickListener) null);
        View inflate = LayoutInflater.from(context).inflate(R.layout.hiad_permission_dialog_cotent, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.hiad_permissions_dialog_content_title_tv)).setText(context.getResources().getString(R.string.hiad_permission_dialog_title, appInfo.L()));
        ((ListView) inflate.findViewById(R.id.hiad_permissions_dialog_content_lv)).setAdapter((ListAdapter) new i(context, appInfo.b()));
        Code2.setView(inflate);
        AlertDialog create = Code2.create();
        if (!(context instanceof Activity) && (window = create.getWindow()) != null) {
            window.setType(Build.VERSION.SDK_INT >= 26 ? 2038 : 2003);
        }
        gl.Code(Code, "show, time:%s", Long.valueOf(System.currentTimeMillis()));
        create.show();
    }
}
