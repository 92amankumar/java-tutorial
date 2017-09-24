package com.immutable;

import java.util.Date;

public class ImmutableDemo {
	public static void main(String[] args) {
		Immutable i = new Immutable(1, "ABC", new Date());
		i.getDate().setTime(1506150066868L);
		System.out.println(i.getDate().getTime());
	}
}

final class Immutable {
	private final int i;
	private final String s;
	private final Date date;

	public Immutable(int i, String s, Date date) {
		super();
		this.i = i;
		this.s = s;
		this.date = date;
	}

	public int getI() {
		return i;
	}

	public String getS() {
		return s;
	}

	public Date getDate() {
		return new Date(this.date.getTime()); // Important
	}
}