package com.kwad.sdk.api.core.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

@KsAdSdkDynamicApi
@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class KsDialogFragment extends KsFragment implements IDialogFragmentLifecycle {
    private DelegateDialogFragment mBase;

    @KsAdSdkDynamicApi
    @Keep
    public KsDialogFragment() {
        super(null);
        ResDialogFragment resDialogFragment = new ResDialogFragment(this);
        this.mBase = resDialogFragment;
        setBase(resDialogFragment);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void dismiss() {
        this.mBase.dismiss();
    }

    @KsAdSdkDynamicApi
    @Keep
    public void dismissAllowingStateLoss() {
        this.mBase.dismissAllowingStateLoss();
    }

    @KsAdSdkDynamicApi
    @Keep
    public Dialog getDialog() {
        return this.mBase.getDialog();
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean getShowsDialog() {
        return this.mBase.getShowsDialog();
    }

    @KsAdSdkDynamicApi
    @Keep
    public int getTheme() {
        return this.mBase.getTheme();
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean isCancelable() {
        return this.mBase.isCancelable();
    }

    @Override // com.kwad.sdk.api.core.fragment.IDialogFragmentLifecycle
    @KsAdSdkDynamicApi
    @Keep
    public void onCancel(DialogInterface dialogInterface) {
        this.mBase.superOnCancel(dialogInterface);
    }

    @Override // com.kwad.sdk.api.core.fragment.IDialogFragmentLifecycle
    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    public Dialog onCreateDialog(Bundle bundle) {
        return this.mBase.superOnCreateDialog(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.IDialogFragmentLifecycle
    @KsAdSdkDynamicApi
    @Keep
    public void onDismiss(DialogInterface dialogInterface) {
        this.mBase.superOnDismiss(dialogInterface);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setCancelable(boolean z10) {
        this.mBase.setCancelable(z10);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setShowsDialog(boolean z10) {
        this.mBase.setShowsDialog(z10);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setStyle(int i10, int i11) {
        this.mBase.setStyle(i10, i11);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setupDialog(Dialog dialog, int i10) {
        this.mBase.setupDialog(dialog, i10);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void show(KsFragmentManager ksFragmentManager, String str) {
        this.mBase.show(ksFragmentManager.getBase(), str);
    }

    @KsAdSdkDynamicApi
    @Keep
    public int show(KsFragmentTransaction ksFragmentTransaction, String str) {
        return this.mBase.show(ksFragmentTransaction.getBase(), str);
    }

    @Keep
    public KsDialogFragment(DelegateDialogFragment delegateDialogFragment) {
        super(delegateDialogFragment);
        this.mBase = delegateDialogFragment;
    }
}
