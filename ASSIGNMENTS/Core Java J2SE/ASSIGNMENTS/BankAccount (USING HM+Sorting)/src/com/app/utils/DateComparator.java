package com.app.utils;

import java.time.LocalDate;
import java.util.Comparator;

import com.app.banking.BankAccount;


public class DateComparator implements Comparator<BankAccount>{

	
	// WRITTING COMPARE METHOD TO SORT BANK ACCOUNT AS PER ASCENDING ORDER OF OPENING DATE
	@Override
	public int compare(BankAccount a1, BankAccount a2) {
		LocalDate d1 = a1.getAccountOpeningDate();
		LocalDate d2 = a2.getAccountOpeningDate();
		return d1.compareTo(d2);
	}

}
