package com.atlas.models;

public enum License {
    CC0("0"),
    CC_BY("1"),
    CC_BY_NC("2"),
    CC_BY_NC_ND("3"),
    CC_BY_NC_SA("4");

    private final String numeroLicencia;

    License(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public static License fromNumeroLicencia(String numeroLicencia) {
        for (License licencia : License.values()) {
            if (licencia.numeroLicencia.equals(numeroLicencia)) {
                return licencia;
            }
        }
        throw new IllegalArgumentException("No existe licencia con el número " + numeroLicencia);
    }

    public static String getTextFromNumero(String numeroLicencia) {
        for (License licencia : License.values()) {
            if (licencia.numeroLicencia.equals(numeroLicencia)) {
                return licencia.name();
            }
        }
        throw new IllegalArgumentException("No existe licencia con el número " + numeroLicencia);
    }
}
