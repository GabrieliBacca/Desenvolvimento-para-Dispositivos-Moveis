package com.ifsc.contaclick;

import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;

public class Aplicativo {
    private String nome;
    private String packageName;
    private ResolveInfo resolveInfo;
    private android.graphics.drawable.Drawable icone;

    public Aplicativo(String nome, String packageName, ResolveInfo resolveInfo, Drawable icone) {
        this.nome = nome;
        this.packageName = packageName;
        this.resolveInfo = resolveInfo;
        this.icone = icone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public ResolveInfo getResolveInfo() {
        return resolveInfo;
    }

    public void setResolveInfo(ResolveInfo resolveInfo) {
        this.resolveInfo = resolveInfo;
    }

    public Drawable getIcone() {
        return icone;
    }

    public void setIcone(Drawable icone) {
        this.icone = icone;
    }
}
