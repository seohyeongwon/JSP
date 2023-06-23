package org.comstudy;

import java.util.ArrayList;
import java.util.List;

public class SaramDAO {
	private static List<SaramData> list = new ArrayList<SaramData>();
	static {
		list.add(new SaramData(1, "HONG", "길동", 21));
		list.add(new SaramData(2, "KIM", "길순", 23));
		list.add(new SaramData(3, "LEE", "길자", 24));
		list.add(new SaramData(4, "PARK", "재동", 25));
		list.add(new SaramData(5, "KANG2", "기동2", 29));
		list.add(new SaramData(6, "MICLE2", "마이클2", 41));
	}
	
	private static int seq = 7;
	
	public List<SaramData> selectAll() {
		return list;
	}
	
	public void insert(SaramData data) {
		data.setSeq(seq++);
		list.add(data);
	}
	
	private int findIndex(int seq) {
		int idx = -1;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getSeq() == seq) {
				idx = i;
				break;
			}
		}
		return idx;
	}
	public void update(SaramData data) {
		int idx = findIndex(data.getSeq());
		if(idx != -1) {			
			list.set(idx, data);
		}
	}
	
	public void delete(SaramData data) {
		int idx = findIndex(data.getSeq());
		if(idx != -1) {			
			list.remove(idx);
		}
	}
}
