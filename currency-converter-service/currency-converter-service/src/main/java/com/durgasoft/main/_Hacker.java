package com.durgasoft.main;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

class _Hacker {
	public static void main(String[] args) {
		// LocalTime lt = LocalTime.parse("scan.next();").
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		ArrayList<Integer> finalCount = new ArrayList<Integer>();
		for (int i = 1; i <= t; i++) {
			System.out.println("..."  +i);
			int n = scan.nextInt();
			int count = 1;

			HashMap<Long, Timing> hm = new HashMap<Long, Timing>();
			ArrayList<Timing> al = new ArrayList<Timing>();
			for (int j = 1; j <= n; j++) {
				scan.next();
				Timing timing = new Timing();
				timing.setStart(LocalTime.parse(scan.next()));
				timing.setEnd(LocalTime.parse(scan.next()));
				long range = timing.getRange();
				hm.put(range, timing);
				al.add(timing);

			}
			Collections.sort(al, new CustomComparator());

			for (int j = 1; j < al.size(); j++) {

				for (int j2 = 0; j2 < j; j2++) {
					if (al.get(j).getStart().equals(al.get(j2).getStart())
							|| al.get(j).getStart().equals(al.get(j2).getEnd())
							|| al.get(j).getEnd().equals(al.get(j2).getStart())
									&& al.get(j).getEnd().equals(al.get(j2).getEnd()))
						break;
					if (al.get(j).getStart().isBefore(al.get(j2).getStart())
							&& al.get(j).getStart().isBefore(al.get(j2).getEnd())) {
						if (al.get(j).getEnd().isBefore(al.get(j2).getStart())
								&& al.get(j).getEnd().isBefore(al.get(j2).getEnd())) {
							count++;
						}
					}

					if (al.get(j).getStart().isAfter(al.get(j2).getStart())
							&& al.get(j).getStart().isAfter(al.get(j2).getEnd())) {
						if (al.get(j).getEnd().isAfter(al.get(j2).getStart())
								&& al.get(j).getEnd().isAfter(al.get(j2).getEnd())) {
							count++;
						}
					}
				}

			}
			System.out.println(count);
			System.out.println(".....");
		}

	}
}

class Timing {
	private LocalTime start;
	private LocalTime end;

	// private long range = getRange();
	public LocalTime getStart() {
		return start;
	}

	public void setStart(LocalTime start) {
		this.start = start;
	}

	public LocalTime getEnd() {
		return end;
	}

	public void setEnd(LocalTime end) {
		this.end = end;
	}

	public long getRange() {
		return Duration.between(start, end).toMinutes();
	}

}

class CustomComparator implements Comparator<Timing> {

	@Override
	public int compare(Timing o1, Timing o2) {

		int compare = Long.compare(o1.getRange(), o2.getRange());
		return compare < 0 ? -1 : 1;
	}
}