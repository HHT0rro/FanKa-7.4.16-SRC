package org.apache.commons.collections4.properties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SortedPropertiesFactory extends AbstractPropertiesFactory<SortedProperties> {
    public static final SortedPropertiesFactory INSTANCE = new SortedPropertiesFactory();

    private SortedPropertiesFactory() {
    }

    @Override // org.apache.commons.collections4.properties.AbstractPropertiesFactory
    public SortedProperties createProperties() {
        return new SortedProperties();
    }
}
