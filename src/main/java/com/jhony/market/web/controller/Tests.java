package com.jhony.market.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
//import java.util.Date;

@RestController
@RequestMapping("/tests")
public class Tests {


    @GetMapping("/calendarTest")
    public String CalendarTest(){

        //Version anterior de fechas
        //Date fecha = new Date();
        //int year = fecha.getYear(); //Date no debe ser mas usado

        //Metodo 1, no recomendado
        Calendar fecha = Calendar.getInstance();
        int year = fecha.get(Calendar.YEAR);
        int month = fecha.get(Calendar.MONTH);
        int day = fecha.get(Calendar.DAY_OF_MONTH);
        System.out.println(year + "-" + month + "-" + day + " Este es mi mensaje");

        //Metodo 2, recomendado
        Calendar calendar = new GregorianCalendar(2023, Calendar.SEPTEMBER, 8);
        int newYear = calendar.get(Calendar.YEAR);
        int newMonth = calendar.get(Calendar.MONTH) + 1; // Sumar 1 para obtener el mes correcto
        int newDay = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(newYear + "-" + newMonth + "-" + newDay + " Este es mi mensaje");

        //Setear una fecha
        calendar.set(2022, Calendar.JANUARY, 2);

        //Obtener Unix en milisegundos
        long unixTimestamp = calendar.getTimeInMillis();

        //Obtener elemento Date
        Date unix = calendar.getTime();

        //Pasar una fecha en str a calendar  -------
        String dateString = "2023-08-10"; // Your date string
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar calendarOwn = Calendar.getInstance();
        calendarOwn.setTime(parsedDate);

        return "Este es mi mensaje ";
    }

    @GetMapping("/dateTest")
    public String dateTest(){

        //Util para pasar tipo fecha a texto
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
        //Version anterior de fechas
        Date fecha = new Date();
        int year = fecha.getYear(); //Date no debe ser mas usado

        String dateformatter = sdf.format(fecha);

        return dateformatter + "Este es mi mensaje ";
    }
}
