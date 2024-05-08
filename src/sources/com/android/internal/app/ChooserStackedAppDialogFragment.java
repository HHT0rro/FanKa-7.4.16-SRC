package com.android.internal.app;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.UserHandle;
import com.android.internal.app.chooser.DisplayResolveInfo;
import com.android.internal.app.chooser.MultiDisplayResolveInfo;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ChooserStackedAppDialogFragment extends ChooserTargetActionsDialogFragment implements DialogInterface.OnClickListener {
    static final String MULTI_DRI_KEY = "multi_dri_key";
    static final String WHICH_KEY = "which_key";
    private MultiDisplayResolveInfo mMultiDisplayResolveInfo;
    private int mParentWhich;

    @Override // com.android.internal.app.ChooserTargetActionsDialogFragment
    void setStateFromBundle(Bundle b4) {
        MultiDisplayResolveInfo multiDisplayResolveInfo = (MultiDisplayResolveInfo) b4.get(MULTI_DRI_KEY);
        this.mMultiDisplayResolveInfo = multiDisplayResolveInfo;
        this.mTargetInfos = multiDisplayResolveInfo.getTargets();
        this.mUserHandle = (UserHandle) b4.get(ChooserTargetActionsDialogFragment.USER_HANDLE_KEY);
        this.mParentWhich = b4.getInt(WHICH_KEY);
    }

    @Override // com.android.internal.app.ChooserTargetActionsDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(WHICH_KEY, this.mParentWhich);
        outState.putParcelable(MULTI_DRI_KEY, this.mMultiDisplayResolveInfo);
    }

    @Override // com.android.internal.app.ChooserTargetActionsDialogFragment
    protected CharSequence getItemLabel(DisplayResolveInfo dri) {
        PackageManager pm = getContext().getPackageManager();
        return dri.getResolveInfo().loadLabel(pm);
    }

    @Override // com.android.internal.app.ChooserTargetActionsDialogFragment
    protected Drawable getItemIcon(DisplayResolveInfo dri) {
        return null;
    }

    @Override // com.android.internal.app.ChooserTargetActionsDialogFragment, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialog, int which) {
        this.mMultiDisplayResolveInfo.setSelected(which);
        ((ChooserActivity) getActivity()).startSelected(this.mParentWhich, false, true);
        dismiss();
    }
}
