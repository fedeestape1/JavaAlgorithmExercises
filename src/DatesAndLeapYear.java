import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

/*
 * LA SIGUIENTE SOLUCION DEVUELVE EXACTAMENTE todo JOSHA AMIGO
 * 
 * El siguiente ejercicio me lo tomaron para entrar a Toptal (me fue mal... me falto una ESTUPIDEZ)
 * Recibis 4 parametros: int year (el año), string beginMonth (el mes de comienzo), string endMonth (el mes final), string firstJaunaryDay 
 * (el día del 1ero de enero de ese año)
 * El día del 1ero de enero ME LO PASO POR LA CHOTA para resolverlo porque te aseguran que el calendario coincide con el calendario gregoriano...
 * así que...
 * 
 * La consigna es:
 * "un wachin se quiere ir la mayor cantidad de días de vacaciones a Miami. Pero el vuelo de ida sale sólo los lunes y el vuelo de vuelta sale sólo
 * los domingos... (la duracion del vuelo es instantanea e irrelevante). El beginMonth es el mes en el cual COMIENZA a tomarse vacaciones. el endMonth
 * es el mes en el cual debe terminar las vacaciones.
 * Escribir la función que dados esos parámetros devuelva la cantidad de SEMANAS que se puede ir de vacaciones.
 * Restrictions: year siempre va desde el 2001 al 2099; el beginMonth siempre va a ser menor al endMonth, y el firstJanuaryDay siempre va a ser
 * real al calendario gregoriano. ES DEBER tener en cuenta los años biciestos / leap years. Para ello, considerar que todos los biciestos son
 * todos aquellos años DIVISIBLES por 4 (year % 4 == 0)"
 * 
 * Ejemplo. Si beginMonth = April, endMonth = May, year = 2021 el resultado es 8
 * porque se iría desde el Lun 5 abril al dom 30 mayo = 8 semanas.
 */

public class DatesAndLeapYear {

	public static void main(String[] args) {
		System.out.println(vacationWeeks(2021, "apr", "may", "FRIDAY"));
	}

	public static Integer vacationWeeks(int year, String beginMonth, String endMonth, String firstJanuaryDay) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
		
		HashMap<String, String> monthFormaterMap = new HashMap<String, String>();
		monthFormaterMap.put("jan", "01");
		monthFormaterMap.put("feb", "02");
		monthFormaterMap.put("mar", "03");
		monthFormaterMap.put("apr", "04");
		monthFormaterMap.put("may", "05");
		monthFormaterMap.put("jun", "06");
		monthFormaterMap.put("jul", "07");
		monthFormaterMap.put("aug", "08");
		monthFormaterMap.put("sep", "09");
		monthFormaterMap.put("oct", "10");
		monthFormaterMap.put("nov", "11");
		monthFormaterMap.put("dec", "12");
		
		
		LocalDate date1 = LocalDate.parse("01 " + monthFormaterMap.get(beginMonth) + " "+ year, dtf);
		
		//Con esta linea de abajo obtenemos el último día del mes, y ADEMAS tomamos en cuenta si es biciesto o no. HER MO SO
		LocalDate date2 = LocalDate.parse("01 " + monthFormaterMap.get(endMonth) + " "+ year, dtf);
		date2 = date2.withDayOfMonth(
				date2.getMonth().length(date2.isLeapYear()));
		
		System.out.println("last date of month: "+ date2);
		
		HashMap<String, Long> beginDateSum = new HashMap<String, Long>();
		beginDateSum.put("MONDAY", 0L);
		beginDateSum.put("TUESDAY", 6L);
		beginDateSum.put("WEDNESDAY", 5L);
		beginDateSum.put("THURSDAY", 4L);
		beginDateSum.put("FRIDAY", 3L);
		beginDateSum.put("SATURDAY", 2L);
		beginDateSum.put("SUNDAY", 1L);
		
		HashMap<String, Long> endDateSum = new HashMap<String, Long>();
		endDateSum.put("MONDAY", -1L);
		endDateSum.put("TUESDAY", -2L);
		endDateSum.put("WEDNESDAY", -3L);
		endDateSum.put("THURSDAY", -4L);
		endDateSum.put("FRIDAY", -5L);
		endDateSum.put("SATURDAY", -6L);
		endDateSum.put("SUNDAY", 0L);
		
		LocalDate beginDate = date1.plusDays(beginDateSum.get(date1.getDayOfWeek().toString()));
		LocalDate endDate = date2.plusDays(endDateSum.get(date2.getDayOfWeek().toString()));
		
		Long days = ChronoUnit.DAYS.between(beginDate, endDate);
		System.out.println("begin date: "+ beginDate);
		System.out.println("end date: "+ endDate);
		
		return (days.intValue() + 1) / 7;
	}
	
}
