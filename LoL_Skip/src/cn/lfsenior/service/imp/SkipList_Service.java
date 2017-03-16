package cn.lfsenior.service.imp;

import java.util.List;

import cn.lfsenior.dao.imp.SkipList_Xml;
import cn.lfsenior.entry.Hero_Skip_Info;
import cn.lfsenior.service.ISkipList_Service;

public class SkipList_Service implements ISkipList_Service {

	@Override
	public List<Hero_Skip_Info> findByName(String name, String path) {
		return new SkipList_Xml().findByName(name, path);
	}

	@Override
	public List<Hero_Skip_Info> findByKeyWords(String keys, String path) {
		return new SkipList_Xml().findByKeyWords(keys, path);
	}

	@Override
	public List<Hero_Skip_Info> findAll(String path) {
		return new SkipList_Xml().findAll(path);
	}

	@Override
	public Hero_Skip_Info findBySkipName(String heroName, String skipName,
			String path) {
		return new SkipList_Xml().findBySkipName(heroName, skipName, path);
	}

}
