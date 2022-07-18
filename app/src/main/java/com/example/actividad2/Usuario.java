package com.example.actividad2;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario implements Parcelable{

    private String nick;
    private String usuario;
    private String clave;

    public Usuario(String nick, String usuario, String clave) {
        this.nick = nick;

        this.usuario = usuario;
        this.clave = clave;
    }

    protected Usuario(Parcel in) {
        nick = in.readString();
        usuario = in.readString();
        clave = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    @Override
    public int describeContents() {return 0;}

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nick);
        dest.writeString(usuario);
        dest.writeString(clave);
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Usuario() {
    }

    public float NivelSeguridad(String clave) {
        float resp = 0;
        Pattern p = Pattern.compile("\\W");
        Matcher m = p.matcher(clave);
        while (m.find()) resp++;

        if (clave.length() >= 12 && resp >= 4) return 5;
        else if (clave.length() >= 10 && resp >= 2) return 4;
        else if (clave.length() >= 8 && resp >= 1) return 3;
        else if (clave.length() >= 8) return 2;
        else return 1;

    }

    public boolean ValidarClave(String clave, String repclave, TextView resultado){
        if (clave.equals(repclave)){
            if (clave.length()>4){
                resultado.setVisibility(View.VISIBLE);

                return true;



            }else{
                return false;
            }


        }else{
            return false;
        }

    }
}
