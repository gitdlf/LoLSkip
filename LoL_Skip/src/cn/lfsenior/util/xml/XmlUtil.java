package cn.lfsenior.util.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 该类为xml操作类
 * 
 * @author LFSenior
 * 
 *         下午7:16:17
 * 
 */
public class XmlUtil {
	/**
	 * 根据传入的xml-Path创建xml解析对象对象，返回Document对象
	 * 
	 * @param path
	 *            xml的路径
	 * @return 返回Document对象
	 */
	public static Document readXml(String path) {
		try {
			// 创建xml
			SAXReader reader = new SAXReader();
			// 读取xml文档，返回Document对象
			return reader.read(new File(path));
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将xml文件写到响应位置
	 * 
	 * @param path
	 *            xml文件的路径
	 * @param fileName
	 *            xml文件的文件名
	 * @param doc
	 *            xml文件对象
	 */
	public static void writerXml(String path, String fileName, Document doc) {
		try {
			// 输出位置
			FileOutputStream out = new FileOutputStream(
					new File(path, fileName));
			// 指定格式
			OutputFormat format = OutputFormat.createPrettyPrint();
			// 设置编码
			format.setEncoding("utf-8");
			XMLWriter writer = new XMLWriter(out, format);
			// 写出内容
			writer.write(doc);
			// 关闭资源
			writer.close();
			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writerXml(String path, Document doc) {
		try {
			// 输出位置
			FileOutputStream out = new FileOutputStream(path);
			// 指定格式
			OutputFormat format = OutputFormat.createPrettyPrint();
			// 设置编码
			format.setEncoding("utf-8");
			XMLWriter writer = new XMLWriter(out, format);
			// 写出内容
			writer.write(doc);
			// 关闭资源
			writer.close();
			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}