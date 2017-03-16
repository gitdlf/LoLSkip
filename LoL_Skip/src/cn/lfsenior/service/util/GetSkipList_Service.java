package cn.lfsenior.service.util;

import cn.lfsenior.service.imp.SkipList_Service;

public class GetSkipList_Service {
	private static SkipList_Service skip_Service=new SkipList_Service();
	public SkipList_Service getSkipList_Service(){
		return this.skip_Service;
	}
}
