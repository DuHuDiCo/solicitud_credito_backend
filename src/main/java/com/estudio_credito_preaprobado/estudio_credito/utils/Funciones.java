
package com.estudio_credito_preaprobado.estudio_credito.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Funciones {
    
    
    public static Timestamp obtenerLocalDateTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS");
        String fecha =  dtf.format(LocalDateTime.now());
        Timestamp times = Timestamp.valueOf(fecha);
       return times;
        
        
    }
    
    public static Date obtenerDate(){
        Calendar calendar = Calendar.getInstance();
        Date fecha = calendar.getTime();
        return fecha;
        
    }
    
}
