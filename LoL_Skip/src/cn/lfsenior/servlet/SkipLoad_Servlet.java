package cn.lfsenior.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.lfsenior.entry.Hero_Skip_Info;
import cn.lfsenior.service.util.GetSkipList_Service;

public class SkipLoad_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * // 获取请求参数： 区分不同的操作类型 String method = request.getParameter("method");
		 * if ("upload".equals(method)) { // 上传 upload(request, response); }
		 * else if ("down".equals(method)) { // 下载 down(request, response); }
		 */
		down(request, response);
	}

	/**
	 * 1. 上传
	 */
	private void upload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 1. 创建工厂对象
			FileItemFactory factory = new DiskFileItemFactory();
			// 2. 文件上传核心工具类
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 设置大小限制参数
			upload.setFileSizeMax(10 * 1024 * 1024); // 单个文件大小限制
			upload.setSizeMax(50 * 1024 * 1024); // 总文件大小限制
			upload.setHeaderEncoding("UTF-8"); // 对中文文件编码处理

			// 判断
			if (upload.isMultipartContent(request)) {
				// 3. 把请求数据转换为list集合
				List<FileItem> list = upload.parseRequest(request);
				// 遍历
				for (FileItem item : list) {
					// 判断：普通文本数据
					if (item.isFormField()) {
						// 获取名称
						String name = item.getFieldName();
						// 获取值
						String value = item.getString();
						System.out.println(value);
					}
					// 文件表单项
					else {
						/******** 文件上传 ***********/
						// a. 获取文件名称
						String name = item.getName();
						// ----处理上传文件名重名问题----
						// a1. 先得到唯一标记
						String id = UUID.randomUUID().toString();
						// a2. 拼接文件名
						name = id + "#" + name;

						// b. 得到上传目录
						String basePath = getServletContext().getRealPath(
								"/upload");
						// c. 创建要上传的文件对象
						File file = new File(basePath, name);
						// d. 上传
						item.write(file);
						item.delete(); // 删除组件运行时产生的临时文件
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 3. 处理下载
	 */
	private void down(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取用户下载的文件名称(url地址后追加数据,get)
		String skipName = request.getParameter("skipName");
		String heroName = request.getParameter("heroName");
		heroName = new String(heroName.getBytes("ISO8859-1"), "UTF-8");
		skipName = new String(skipName.getBytes("ISO8859-1"), "UTF-8");
		String path = this.getServletConfig().getServletContext()
				.getRealPath("/")
				+ "data\\hero_skip_Info.xml";
		// 先获取上传目录路径
		Hero_Skip_Info hsi = new GetSkipList_Service().getSkipList_Service()
				.findBySkipName(heroName, skipName, path);
		String basePath = hsi.getSkip_Path();
		// 获取一个文件流
		InputStream in = new FileInputStream(new File(basePath));

		// 如果文件名是中文，需要进行url编码
		skipName = URLEncoder.encode(skipName, "UTF-8");
		heroName=URLEncoder.encode(heroName, "UTF-8");
		// 设置下载的响应头
		response.setHeader("content-disposition",
				"attachment;fileName=" +heroName+"="+skipName+"="+ hsi.getSkip_Zip_Info()+".zip");
		// 获取response字节流//众星之子+索拉卡=20161115+6众星之子+索拉卡+源代码.zip=soraka.zip
		OutputStream out = response.getOutputStream();
		byte[] b = new byte[1024];
		int len = -1;
		while ((len = in.read(b)) != -1) {
			out.write(b, 0, len);
		}
		// 关闭
		out.close();
		in.close();
		request.setAttribute("judgeLoad", "已安装");
		request.getRequestDispatcher("SkipList_Servlet").forward(request,
				response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
