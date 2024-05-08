package com.kwad.sdk.api.core.fragment;

import android.animation.Animator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.kwad.sdk.api.loader.Wrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ResDialogFragment extends DelegateDialogFragment {
    public ResDialogFragment() {
        super(new KsDialogFragment(null));
        getBase().setBase(this);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, com.kwad.sdk.api.core.fragment.IDelegateFragment
    public final Activity getActivity2() {
        return super.getActivity();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, com.kwad.sdk.api.core.fragment.IDelegateFragment
    public /* bridge */ /* synthetic */ KsFragment getBase() {
        return super.getBase();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public Context getContext() {
        return Wrapper.wrapContextIfNeed(super.getContext());
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public LayoutInflater getLayoutInflater(@Nullable Bundle bundle) {
        return Wrapper.wrapInflaterIfNeed(super.getLayoutInflater(bundle));
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public /* bridge */ /* synthetic */ void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ Animation onCreateAnimation(int i10, boolean z10, int i11) {
        return super.onCreateAnimation(i10, z10, i11);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ Animator onCreateAnimator(int i10, boolean z10, int i11) {
        return super.onCreateAnimator(i10, z10, i11);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public /* bridge */ /* synthetic */ void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public /* bridge */ /* synthetic */ Dialog onCreateDialog(Bundle bundle) {
        return super.onCreateDialog(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    @Nullable
    public /* bridge */ /* synthetic */ View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onDetach() {
        super.onDetach();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public /* bridge */ /* synthetic */ void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        return Wrapper.wrapInflaterIfNeed(super.onGetLayoutInflater(bundle));
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public /* bridge */ /* synthetic */ void onLowMemory() {
        super.onLowMemory();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onMultiWindowModeChanged(boolean z10) {
        super.onMultiWindowModeChanged(z10);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onPause() {
        super.onPause();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onPictureInPictureModeChanged(boolean z10) {
        super.onPictureInPictureModeChanged(z10);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onResume() {
        super.onResume();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onStart() {
        super.onStart();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onStop() {
        super.onStop();
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(Wrapper.wrapContextIfNeed(context));
    }

    @Override // com.kwad.sdk.api.core.fragment.DelegateDialogFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
    }

    public ResDialogFragment(KsDialogFragment ksDialogFragment) {
        super(ksDialogFragment);
    }
}
