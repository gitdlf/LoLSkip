package cn.lfsenior.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import cn.lfsenior.dao.ISkipList_Xml;
import cn.lfsenior.entry.Hero_Skip_Info;
import cn.lfsenior.util.xml.XmlUtil;

public class SkipList_Xml implements ISkipList_Xml {

	@Override
	public List<Hero_Skip_Info> findByName(String name, String path) {
		Document doc = XmlUtil.readXml(path);
		List<Element> elements = doc.selectNodes("//hero[@hero_Name='" + name
				+ "']");
		List<Hero_Skip_Info> hsiList = new ArrayList<Hero_Skip_Info>();
		for (Element elem : elements) {
			Hero_Skip_Info hsi = new Hero_Skip_Info();
			hsi.setHero_Name(elem.attributeValue("hero_Name"));
			hsi.setSkip_Name(elem.elementText("skip_Name"));
			hsi.setSkip_Path(elem.elementText("skip_Path"));
			hsi.setSkip_Zip_Info(elem.elementText("skip_Zip_Info"));
			hsi.setUpdata_Time(elem.elementText("updata_Time"));
			hsi.setLoad_Info(elem.elementText("load_Info"));
			hsiList.add(hsi);
		}
		return hsiList;
	}

	@Override
	public List<Hero_Skip_Info> findByKeyWords(String keys, String path) {
		// TODO Auto-generated method stub
		List<Hero_Skip_Info> hsiAll=findAll(path);
		List<Hero_Skip_Info> hsiList=new ArrayList<Hero_Skip_Info>();
		for (Hero_Skip_Info hsi : hsiAll) {
			if(hsi.getHero_Name().contains(keys)||hsi.getSkip_Name().contains(keys)){
				hsiList.add(hsi);
			}
		}
		return hsiList;
	}

	@Override
	public List<Hero_Skip_Info> findAll(String path) {
		Document doc = XmlUtil.readXml(path);
		List<Element> elements = doc.selectNodes("//hero");
		List<Hero_Skip_Info> hsiList = new ArrayList<Hero_Skip_Info>();
		for (Element elem : elements) {
			Hero_Skip_Info hsi = new Hero_Skip_Info();
			hsi.setHero_Name(elem.attributeValue("hero_Name"));
			hsi.setSkip_Name(elem.elementText("skip_Name"));
			hsi.setSkip_Path(elem.elementText("skip_Path"));
			hsi.setSkip_Zip_Info(elem.elementText("skip_Zip_Info"));
			hsi.setUpdata_Time(elem.elementText("updata_Time"));
			hsi.setLoad_Info(elem.elementText("load_Info"));
			hsiList.add(hsi);
		}
		return hsiList;
	}

	@Override
	public Hero_Skip_Info findBySkipName(String heroName,String skipName,String path) {
		List<Hero_Skip_Info> hsiList = new ArrayList<Hero_Skip_Info>();
		Hero_Skip_Info selectHSI=null;
		hsiList=findByName(heroName, path);
		for (Hero_Skip_Info hsi : hsiList) {
			if(hsi.getSkip_Name().equals(skipName)){
				selectHSI=hsi;
				break;
			}
		}
		return selectHSI;
	}

}
