package br.com.mintecommerce.Enum;

public enum EnumStatusProduto {
    Inativo(0),
    Ativo(1);

    private Integer enumValue;

    EnumStatusProduto(Integer enumValue) {
        this.enumValue = enumValue;
    }

    public Integer getEnumValue() {
        return enumValue;
    }
}
