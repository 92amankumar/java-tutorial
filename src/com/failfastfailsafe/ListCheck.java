package com.failfastfailsafe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListCheck {
	public static void main(String[] args) {
		Integer[] arr = new Integer[]{0,1,2,3,4,5,6,7,8,9};
		List<Integer> list = new ArrayList<>(Arrays.asList(arr));
		System.out.println("Size Before-->"+list.size());
		try {
			for (int i = 1; i < list.size(); i++) {					//FAIL SAFE
				System.out.println("G1-->"+list.get(i));
				System.out.println("R1-->"+list.remove(i+1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Size After-->"+list.size());
		
		System.out.println("11111111111111111111111111111111111");
		
		list = new ArrayList<>(Arrays.asList(arr));
		System.out.println("Size Before-->"+list.size());
		try {
			for (Integer i : list) {								//FAIL FAST
				System.out.println("G2-->"+list.get(i));
				System.out.println("R2-->"+list.remove(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Size After-->"+list.size());

		System.out.println("222222222222222222222222222222222");
		
		list = new ArrayList<>(Arrays.asList(arr));
		System.out.println("Size Before-->"+list.size());
		try {
			Iterator<Integer> iterator = list.iterator();			//FAIL FAST
			while(iterator.hasNext()){
				System.out.println("G3-->"+iterator.next());
				System.out.println("R3-->"+list.remove(iterator.next()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Size After-->"+list.size());
		
		System.out.println("3333333333333333333333333");
		
		list = new ArrayList<>(Arrays.asList(arr));
		System.out.println("Size Before-->"+list.size());	
		try {
			ListIterator<Integer> iterator = list.listIterator();
			int counter = 0;
			while(iterator.hasNext()){												
				System.out.println("G4-->"+iterator.next());
				System.out.println("hasPrevious-->"+iterator.hasPrevious());
				System.out.println("hasNext-->"+iterator.hasNext());
				System.out.println("nextIndex-->"+iterator.nextIndex());
				System.out.println("previousIndex-->"+iterator.previousIndex());
				System.out.println("Adding");
				iterator.add(counter);							//If we keep on adding it will not go till infinity it will iterate till size of previous list
				/*System.out.println("Removing");
				iterator.remove();*/								//Same for removing
				/*System.out.println("Setting");
				iterator.set(5);*/									//Nothing for SET

				//Note if we do add/ remove/ set together we wil get illegalStateException 
				/*if(counter==5){
					System.out.println("R4-->"+list.remove(iterator.next()));			// FAIL FAST
				}*/
				if(counter==4){
					System.out.println("Removing");
					iterator.remove();
				}
				counter++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Size After-->"+list.size());
	}
}
