package org.apache.commons.collections4.properties;

import java.util.Properties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class PropertiesFactory extends AbstractPropertiesFactory<Properties> {
    public static final PropertiesFactory INSTANCE = new PropertiesFactory();

    private PropertiesFactory() {
    }

    @Override // org.apache.commons.collections4.properties.AbstractPropertiesFactory
    public Properties createProperties() {
        return new Properties();
    }
}
