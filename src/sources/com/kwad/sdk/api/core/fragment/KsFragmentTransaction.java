package com.kwad.sdk.api.core.fragment;

import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

@KsAdSdkDynamicApi
@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class KsFragmentTransaction {
    private final FragmentTransaction mBase;

    public KsFragmentTransaction(FragmentTransaction fragmentTransaction) {
        this.mBase = fragmentTransaction;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction add(KsFragment ksFragment, String str) {
        this.mBase.add(ksFragment.getBase(), str);
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction addSharedElement(View view, String str) {
        this.mBase.addSharedElement(view, str);
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction addToBackStack(@Nullable String str) {
        this.mBase.addToBackStack(str);
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction attach(KsFragment ksFragment) {
        this.mBase.attach(ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public int commit() {
        return this.mBase.commit();
    }

    @KsAdSdkDynamicApi
    @Keep
    public int commitAllowingStateLoss() {
        return this.mBase.commitAllowingStateLoss();
    }

    @KsAdSdkDynamicApi
    @Keep
    public void commitNow() {
        this.mBase.commitNow();
    }

    @KsAdSdkDynamicApi
    @Keep
    public void commitNowAllowingStateLoss() {
        this.mBase.commitNowAllowingStateLoss();
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction detach(KsFragment ksFragment) {
        this.mBase.detach(ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction disallowAddToBackStack() {
        this.mBase.disallowAddToBackStack();
        return this;
    }

    public FragmentTransaction getBase() {
        return this.mBase;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction hide(KsFragment ksFragment) {
        this.mBase.hide(ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean isAddToBackStackAllowed() {
        return this.mBase.isAddToBackStackAllowed();
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean isEmpty() {
        return this.mBase.isEmpty();
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction remove(KsFragment ksFragment) {
        this.mBase.remove(ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction replace(int i10, KsFragment ksFragment) {
        this.mBase.replace(i10, ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction runOnCommit(Runnable runnable) {
        this.mBase.runOnCommit(runnable);
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    @Deprecated
    public KsFragmentTransaction setAllowOptimization(boolean z10) {
        this.mBase.setAllowOptimization(z10);
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setBreadCrumbShortTitle(int i10) {
        this.mBase.setBreadCrumbShortTitle(i10);
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setBreadCrumbTitle(int i10) {
        this.mBase.setBreadCrumbTitle(i10);
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setCustomAnimations(int i10, int i11) {
        this.mBase.setCustomAnimations(i10, i11);
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setPrimaryNavigationFragment(KsFragment ksFragment) {
        this.mBase.setPrimaryNavigationFragment(ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setReorderingAllowed(boolean z10) {
        this.mBase.setReorderingAllowed(z10);
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setTransition(int i10) {
        this.mBase.setTransition(i10);
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setTransitionStyle(int i10) {
        this.mBase.setTransitionStyle(i10);
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction show(KsFragment ksFragment) {
        this.mBase.show(ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction add(int i10, KsFragment ksFragment) {
        this.mBase.add(i10, ksFragment.getBase());
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction replace(int i10, KsFragment ksFragment, @Nullable String str) {
        this.mBase.replace(i10, ksFragment.getBase(), str);
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setBreadCrumbShortTitle(CharSequence charSequence) {
        this.mBase.setBreadCrumbShortTitle(charSequence);
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setBreadCrumbTitle(CharSequence charSequence) {
        this.mBase.setBreadCrumbTitle(charSequence);
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setCustomAnimations(int i10, int i11, int i12, int i13) {
        this.mBase.setCustomAnimations(i10, i11, i12, i13);
        return this;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction add(int i10, KsFragment ksFragment, @Nullable String str) {
        this.mBase.add(i10, ksFragment.getBase(), str);
        return this;
    }
}
