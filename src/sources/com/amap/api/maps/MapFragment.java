package com.amap.api.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcel;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.col.p0003l.ab;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MapFragment extends Fragment implements BaseMapView {
    private AMap aMap;
    private IMapFragmentDelegate mapFragmentDelegate;

    public static MapFragment newInstance() {
        return newInstance(new AMapOptions());
    }

    public AMap getMap() {
        IMapFragmentDelegate mapFragmentDelegate = getMapFragmentDelegate();
        if (mapFragmentDelegate == null) {
            return null;
        }
        try {
            IAMap map = mapFragmentDelegate.getMap();
            if (map == null) {
                return null;
            }
            if (this.aMap == null) {
                this.aMap = new AMap(map);
            }
            return this.aMap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public IMapFragmentDelegate getMapFragmentDelegate() {
        if (this.mapFragmentDelegate == null) {
            ab abVar = new ab(0);
            this.mapFragmentDelegate = abVar;
            abVar.setContext(getActivity());
        }
        return this.mapFragmentDelegate;
    }

    @Override // com.amap.api.maps.BaseMapView
    public void loadWorldVectorMap(boolean z10) {
        try {
            getMapFragmentDelegate().loadWorldVectorMap(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            getMapFragmentDelegate().onCreate(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = getArguments();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return getMapFragmentDelegate().onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        try {
            getMapFragmentDelegate().onDestroy();
            this.aMap = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        try {
            getMapFragmentDelegate().onDestroyView();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        try {
            getMapFragmentDelegate().onInflate(activity, new AMapOptions(), bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        try {
            getMapFragmentDelegate().onLowMemory();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        try {
            getMapFragmentDelegate().onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            getMapFragmentDelegate().onResume();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        try {
            getMapFragmentDelegate().onSaveInstanceState(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Fragment
    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z10) {
        if (z10) {
            getMapFragmentDelegate().setVisibility(0);
        } else {
            getMapFragmentDelegate().setVisibility(8);
        }
    }

    public static MapFragment newInstance(AMapOptions aMapOptions) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        try {
            Parcel obtain = Parcel.obtain();
            aMapOptions.writeToParcel(obtain, 0);
            bundle.putByteArray("MAP_OPTIONS", obtain.marshall());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        mapFragment.setArguments(bundle);
        return mapFragment;
    }
}
