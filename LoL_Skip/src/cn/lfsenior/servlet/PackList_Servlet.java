package cn.lfsenior.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lfsenior.entry.Hero_Skip_Info;
import cn.lfsenior.service.imp.SkipList_Service;
import cn.lfsenior.service.util.GetSkipList_Service;

public class PackList_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 传入的属性flag 值：name findByName;keys findByKeyWords ;all findAll
		 * 属性value，为待查询的值
		 */
		String uri = null;
		String path = this.getServletConfig().getServletContext()
				.getRealPath("/")
				+ "data\\hero_skip_Info.xml";
		try {
			List<Hero_Skip_Info> hsiList = new ArrayList<Hero_Skip_Info>();
			String flag = request.getParameter("flag");
			String str=request.getParameter("value");
			String value =null;
			if(str!=null){
				value = new String(str.getBytes(
						"ISO-8859-1"), "utf-8");
			}
			SkipList_Service skip_Service = new GetSkipList_Service()
					.getSkipList_Service();
			if (flag != null) {
				switch (flag) {
				case "name":
					 hsiList=skip_Service.findByName(value,path);
					break;
				case "keys":
					 hsiList=skip_Service.findByKeyWords(value,path);
					break;
				case "all":
					 hsiList=skip_Service.findAll(path);
					break;
				}
			}
			/**
			 * 保存所有英雄名字
			 */
			Set<String> heroName=new HashSet<>();
			for(Hero_Skip_Info hsi:skip_Service.findAll(path)){
				heroName.add(hsi.getHero_Name());
			}
			request.setAttribute("heroName", heroName);
			request.setAttribute("hsiList", hsiList);
			/**
			 * 传递一个是否安装成功的信息过去
			 */
			request.setAttribute("judgeLoad",request.getAttribute("judgeLoad"));
			uri = "skippach.jsp";
			
		} catch (Exception e) {
			uri = "error.jsp";
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher(uri).forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
