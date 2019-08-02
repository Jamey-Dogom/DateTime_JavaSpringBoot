package com.jd.displaydate.datetime;

//import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
//import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DisplayDate {
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	
	@RequestMapping("/date")
	public  String date(Model model) {
		
		
		LocalDate ld = LocalDate.now() ;
		Month month = ld.getMonth();
		DayOfWeek dow = ld.getDayOfWeek();
		int dayOfMonth = ld.getDayOfMonth();
		int year = ld.getYear();
		
		
		String output = String.format("%s, the %dst of %s,  %d", dow, dayOfMonth, month, year);
		
		model.addAttribute("date", output);
		return "date.jsp";
		
	}
	
	@RequestMapping("/time")
	public  String time(Model model) {
		
		
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
		
		model.addAttribute("time", sdf.format(date));
		return "time.jsp";
		
	}
	

}
