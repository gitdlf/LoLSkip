package cn.lfsenior.entry;

/**
 * 该类为英雄皮肤信息的实体类
 * 	保存了四个属性
 * @author LFSenior
 *
 *下午1:08:27
 *
 */
public class Hero_Skip_Info {
	/**
	 */
	private String hero_Name;
	/**
	 * 皮肤名
	 */
	private String skip_Name;
	/**
	 * 加载信息
	 */
	private String load_Info="未加载";
	/**
	 * 更新时间
	 */
	private String updata_Time;
	/**
	 * 官方皮肤压缩名
	 */
	private String skip_Zip_Info;
	/**
	 * 皮肤路径
	 */
	private String skip_Path;
	
	
	
	
	public String getSkip_Path() {
		return skip_Path;
	}
	public void setSkip_Path(String skip_Path) {
		this.skip_Path = skip_Path;
	}
	public String getSkip_Zip_Info() {
		return skip_Zip_Info;
	}
	public void setSkip_Zip_Info(String skip_Zip_Info) {
		this.skip_Zip_Info = skip_Zip_Info;
	}
	public String getHero_Name() {
		return hero_Name;
	}
	public void setHero_Name(String hero_Name) {
		this.hero_Name = hero_Name;
	}
	public String getSkip_Name() {
		return skip_Name;
	}
	public void setSkip_Name(String skip_Name) {
		this.skip_Name = skip_Name;
	}
	public String getLoad_Info() {
		return load_Info;
	}
	public void setLoad_Info(String load_Info) {
		this.load_Info = load_Info;
	}
	public String getUpdata_Time() {
		return updata_Time;
	}
	public void setUpdata_Time(String updata_Time) {
		this.updata_Time = updata_Time;
	}
	@Override
	public String toString() {
		return "Hero_Skip_Info [hero_Name=" + hero_Name + ", skip_Name="
				+ skip_Name + ", load_Info=" + load_Info + ", updata_Time="
				+ updata_Time + ", skip_Zip_Info=" + skip_Zip_Info
				+ ", skip_Path=" + skip_Path + "]";
	}
}
