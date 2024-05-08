package androidx.databinding;

import android.view.View;
import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class MergedDataBinderMapper extends DataBinderMapper {
    private static final String TAG = "MergedDataBinderMapper";
    private Set<Class<? extends DataBinderMapper>> mExistingMappers = new HashSet();
    private List<DataBinderMapper> mMappers = new CopyOnWriteArrayList();
    private List<String> mFeatureBindingMappers = new CopyOnWriteArrayList();

    private boolean loadFeatures() {
        boolean z10 = false;
        for (String str : this.mFeatureBindingMappers) {
            try {
                Class<?> cls = Class.forName(str);
                if (DataBinderMapper.class.isAssignableFrom(cls)) {
                    addMapper((DataBinderMapper) cls.newInstance());
                    this.mFeatureBindingMappers.remove(str);
                    z10 = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException unused2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("unable to add feature mapper for ");
                sb2.append(str);
            } catch (InstantiationException unused3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("unable to add feature mapper for ");
                sb3.append(str);
            }
        }
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addMapper(DataBinderMapper dataBinderMapper) {
        if (this.mExistingMappers.add(dataBinderMapper.getClass())) {
            this.mMappers.add(dataBinderMapper);
            Iterator<DataBinderMapper> iterator2 = dataBinderMapper.collectDependencies().iterator2();
            while (iterator2.hasNext()) {
                addMapper(iterator2.next());
            }
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i10) {
        Iterator<DataBinderMapper> iterator2 = this.mMappers.iterator2();
        while (iterator2.hasNext()) {
            String convertBrIdToString = iterator2.next().convertBrIdToString(i10);
            if (convertBrIdToString != null) {
                return convertBrIdToString;
            }
        }
        if (loadFeatures()) {
            return convertBrIdToString(i10);
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i10) {
        Iterator<DataBinderMapper> iterator2 = this.mMappers.iterator2();
        while (iterator2.hasNext()) {
            ViewDataBinding dataBinder = iterator2.next().getDataBinder(dataBindingComponent, view, i10);
            if (dataBinder != null) {
                return dataBinder;
            }
        }
        if (loadFeatures()) {
            return getDataBinder(dataBindingComponent, view, i10);
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Iterator<DataBinderMapper> iterator2 = this.mMappers.iterator2();
        while (iterator2.hasNext()) {
            int layoutId = iterator2.next().getLayoutId(str);
            if (layoutId != 0) {
                return layoutId;
            }
        }
        if (loadFeatures()) {
            return getLayoutId(str);
        }
        return 0;
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i10) {
        Iterator<DataBinderMapper> iterator2 = this.mMappers.iterator2();
        while (iterator2.hasNext()) {
            ViewDataBinding dataBinder = iterator2.next().getDataBinder(dataBindingComponent, viewArr, i10);
            if (dataBinder != null) {
                return dataBinder;
            }
        }
        if (loadFeatures()) {
            return getDataBinder(dataBindingComponent, viewArr, i10);
        }
        return null;
    }

    public void addMapper(String str) {
        this.mFeatureBindingMappers.add(str + ".DataBinderMapperImpl");
    }
}
