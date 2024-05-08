package com.ss.android.download.api.m;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.ve;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.dk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m implements ve {
    @Override // com.ss.android.download.api.config.ve
    public Dialog dk(@NonNull com.ss.android.download.api.model.dk dkVar) {
        return m(dkVar);
    }

    @Override // com.ss.android.download.api.config.ve
    public void m(int i10, @Nullable Context context, DownloadModel downloadModel, String str, Drawable drawable, int i11) {
        Toast.makeText(context, str, 0).show();
    }

    private static Dialog m(final com.ss.android.download.api.model.dk dkVar) {
        if (dkVar == null) {
            return null;
        }
        AlertDialog show = new AlertDialog.Builder(dkVar.f38406m).setTitle(dkVar.dk).setMessage(dkVar.ej).setPositiveButton(dkVar.f38405l, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.m.m.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                dk.InterfaceC0572dk interfaceC0572dk = com.ss.android.download.api.model.dk.this.f38403e;
                if (interfaceC0572dk != null) {
                    interfaceC0572dk.m(dialogInterface);
                }
            }
        }).setNegativeButton(dkVar.np, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.m.m.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                dk.InterfaceC0572dk interfaceC0572dk = com.ss.android.download.api.model.dk.this.f38403e;
                if (interfaceC0572dk != null) {
                    interfaceC0572dk.dk(dialogInterface);
                }
            }
        }).show();
        show.setCanceledOnTouchOutside(dkVar.f38407n);
        show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.download.api.m.m.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                dk.InterfaceC0572dk interfaceC0572dk = com.ss.android.download.api.model.dk.this.f38403e;
                if (interfaceC0572dk != null) {
                    interfaceC0572dk.ej(dialogInterface);
                }
            }
        });
        Drawable drawable = dkVar.f38404hc;
        if (drawable != null) {
            show.setIcon(drawable);
        }
        return show;
    }
}
