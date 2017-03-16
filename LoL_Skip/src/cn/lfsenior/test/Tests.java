package cn.lfsenior.test;

import java.io.File;
import java.util.List;

import org.junit.Test;

//import cn.lfsenior.admin.util.SkipInfo_Admin;
//import cn.lfsenior.admin.util.SkipInfo_Load;
import cn.lfsenior.dao.imp.SkipList_Xml;
import cn.lfsenior.entry.Hero_Skip_Info;
import cn.lfsenior.service.util.GetSkipList_Service;


public class Tests {

	@Test
	public void test_Admin_GetHero_Skip_Name(){
//		SkipInfo_Admin sa=new SkipInfo_Admin();
//		sa.read_SkipInfo("F:\\skip");
//		for(int i=0;i<sa.hsiList.size();i++){
//			Hero_Skip_Info hsi=sa.hsiList.get(i);
//			System.out.println(hsi.getHero_Name());
//			System.out.println(hsi.getSkip_Path());
//		}
	}
	
	@Test
	public void test_AddElement(){
//		SkipInfo_Load sil=new SkipInfo_Load();
//		sil.load_SkipInfo("F:\\skip");
	}
	
	@Test
	public void getSkipInfo(){
		SkipList_Xml sx=new SkipList_Xml();
		List<Hero_Skip_Info> list=sx.findByName("雪人骑士 努努","F:\\skip");
		System.out.println(list.isEmpty());
		System.out.println(list.toString());
	}
	
	@Test
	public void repString(){
		String path="20161115 6众星之子 索拉卡 源代码.zip";
//		String path=new GetSkipList_Service().getSkipList_Service().findBySkipName("众星之子 索拉卡", "20161115 6众星之子 索拉卡 源代码.zip", ".\\data\\hero_skip_Info.xml").getSkip_Path();
//		File file=new File(path);
//		System.out.println(file.length());
//		System.out.println(path);
		System.out.println(path.replaceFirst(path.substring(0, path.lastIndexOf(".")), "yasuo"));
	}
}
