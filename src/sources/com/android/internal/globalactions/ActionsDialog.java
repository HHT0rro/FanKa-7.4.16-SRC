package com.android.internal.globalactions;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ListView;
import com.android.internal.app.AlertController;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class ActionsDialog extends Dialog implements DialogInterface {
    private final ActionsAdapter mAdapter;
    private final AlertController mAlert;
    private final Context mContext;

    public ActionsDialog(Context context, AlertController.AlertParams params) {
        super(context, getDialogTheme(context));
        Context context2 = getContext();
        this.mContext = context2;
        AlertController create = AlertController.create(context2, this, getWindow());
        this.mAlert = create;
        this.mAdapter = (ActionsAdapter) params.mAdapter;
        params.apply(create);
    }

    private static int getDialogTheme(Context context) {
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, outValue, true);
        return outValue.resourceId;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.setCanceledOnTouchOutside(true);
        super.onStart();
    }

    public ListView getListView() {
        return this.mAlert.getListView();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mAlert.installContent();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        if (event.getEventType() == 32) {
            for (int i10 = 0; i10 < this.mAdapter.getCount(); i10++) {
                CharSequence label = this.mAdapter.getItem(i10).getLabelForAccessibility(getContext());
                if (label != null) {
                    event.getText().add(label);
                }
            }
        }
        return super.dispatchPopulateAccessibilityEvent(event);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this.mAlert.onKeyDown(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (this.mAlert.onKeyUp(keyCode, event)) {
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
}
