package com.estudio_credito_preaprobado.estudio_credito.exceptions;

public class SolicitudNotFoundException extends Exception{

    public SolicitudNotFoundException() {
        super("La solicitud con ese id no existe en la base de datos, vuelva a intentar");
    }

    public SolicitudNotFoundException(String mensaje) {
        super(mensaje);
    }

}
