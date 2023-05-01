
package com.classes;

/**
 *
 * @author Jorge Alberto
 */

public class CatalogoDeSexo {

private int id_cat_sexo;    
private String tipo;

public CatalogoDeSexo (int id_cat_sexo) {
    this.id_cat_sexo = id_cat_sexo;
}

public CatalogoDeSexo (int id_cat_sexo,String tipo) {
    this.id_cat_sexo = id_cat_sexo;
    this.tipo = tipo;
}

public CatalogoDeSexo (String tipo){
    this.tipo = tipo;
}

    public int getId_cat_sexo() {
        return id_cat_sexo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId_cat_sexo(int id_cat_sexo) {
        this.id_cat_sexo = id_cat_sexo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

@Override
    public String toString() {
        return "CatalogoDeSexo{" + "id_cat_sexo=" + id_cat_sexo + ", tipo=" + tipo +'}';
    }
}