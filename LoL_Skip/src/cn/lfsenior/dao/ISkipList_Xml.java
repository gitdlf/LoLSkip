package cn.lfsenior.dao;

import java.util.List;

import cn.lfsenior.entry.Hero_Skip_Info;

public interface ISkipList_Xml {
	/**
	 * 通过英雄名查找皮肤信息
	 * 
	 * @param name
	 *            英雄名
	 * @return 返回英雄皮肤集合
	 * @param path
	 *            xml文件位置
	 */
	List<Hero_Skip_Info> findByName(String name, String path);

	/**
	 * 通过关键字查找皮肤信息
	 * 
	 * @param keys
	 * @return 返回英雄皮肤集合
	 * @param path
	 *            xml文件位置
	 */
	List<Hero_Skip_Info> findByKeyWords(String keys, String path);

	/**
	 * 查找所有皮肤信息
	 * 
	 * @return 返回英雄皮肤集合
	 * @param path
	 *            xml文件位置
	 */
	List<Hero_Skip_Info> findAll(String path);

	/**
	 * 通过皮肤名来查找皮肤信息
	 * 
	 * @param path
	 *            xml文件位置
	 * @param heroName
	 *            英雄名
	 * @param skipName
	 *            皮肤名
	 * @return 放回英雄皮肤信息对象
	 */
	Hero_Skip_Info findBySkipName(String heroName, String skipName, String path);
}
