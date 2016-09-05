package lab5_6;

import java.util.LinkedList;

public class KruskalsTable {
	public LinkedList [] myTable;
	public  KruskalsTable(int size){
		myTable = new LinkedList [size];
		for(int i = 0; i < myTable.length; i++){
			myTable[i] = new LinkedList();
		}
	}
}
