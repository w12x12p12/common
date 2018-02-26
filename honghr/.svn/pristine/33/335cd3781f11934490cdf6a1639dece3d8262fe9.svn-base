package com.hongedu.honghr.util.excel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * 导出EXCEL文档
 * 
 * <p>Title: ExportExcel</p> 
 * <p>Description: </p>
 *	  ExportExcel 
 */
public class ExportExcel {
	
	public static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");
	public static final String TIME_FORMAT = "yyyy-MM-dd";// 设定时间默认输出格式
	public static final String DIRECTORY_FOLDER = "docs";// 目录文件夹
	public static final String FOLDER_SUFFIX = ".xls";// 文件后缀名
	public static final String FONT_STYLE = "Courier New";// 默认字体
	
	/**
	 * 生成文件并导出
	 * 
	 * <p>Title: exportExcel</p> 
	 * <p>Description: </p>  
	 * @time 下午6:21:27 
	 * @param request
	 * @param response
	 * @param fileName 文件名
	 * @param headers 表格属性列名数组
	 * @param dataset 需要显示的数据集合
	 * @param pattern 如果有时间数据，设定输出格式
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static HSSFWorkbook exportExcel(HttpServletRequest request, HttpServletResponse response, 
			String fileName,String[] headers, List<Object[]> dataset, String pattern) {
		String docsPath = request.getSession().getServletContext().getRealPath(DIRECTORY_FOLDER);//文件夹目录
		String filePath = docsPath + FILE_SEPARATOR + fileName + FOLDER_SUFFIX;
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格(名字可以自定义)
		HSSFSheet sheet = workbook.createSheet(fileName);
		// 设置表格默认列宽度为15个字节
		// sheet.setDefaultColumnWidth((short) 15);
		// 生成一个表格标题行样式
		HSSFCellStyle style = getColumnTopStyle(workbook);
		// 生成非标题样式
		HSSFCellStyle style2 = getColumnStyle(workbook);
		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		// 遍历集合数据，产生数据行
		Iterator<Object[]> it = dataset.iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);// 从第1行开始创建
			Object[] obj = (Object[]) it.next();
			for (short i = 0; i < obj.length; i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style2);
				Object value = obj[i];
				String textValue = null;
				if (!"".equals(value) && value != null) {
					if (value instanceof Integer) {
						int intValue = (Integer) value;
						cell.setCellValue(intValue);
					} else if (value instanceof Float) {
						float fValue = (Float) value;
						cell.setCellValue(fValue);
					} else if (value instanceof Double) {
						double dValue = (Double) value;
						cell.setCellValue(dValue);
					} else if (value instanceof Long) {
						long longValue = (Long) value;
						cell.setCellValue(longValue);
					} else if (value instanceof Date) {
						Date date = (Date) value;
						if (null == pattern || pattern.equals("")) {
							pattern = TIME_FORMAT;
						}
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
						textValue = simpleDateFormat.format(date);
						cell.setCellValue(textValue);
					} else {
						// 其它数据类型都当作字符串简单处理
						textValue = value.toString();
						cell.setCellValue(textValue); // 设置单元格的值
					}
				} else {
					cell.setCellValue("");
				}
			}
		}
		// 让列宽随着导出的列长自动适应
		for (int colNum = 0; colNum < headers.length; colNum++) {
			int columnWidth = sheet.getColumnWidth(colNum) / 256;
			for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
				HSSFRow currentRow;
				// 当前行未被使用过
				if (sheet.getRow(rowNum) == null) {
					currentRow = sheet.createRow(rowNum);
				} else {
					currentRow = sheet.getRow(rowNum);
				}
				if (currentRow.getCell(colNum) != null) {
					HSSFCell currentCell = currentRow.getCell(colNum);
					if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
						int length = currentCell.getStringCellValue() != null
								? currentCell.getStringCellValue().getBytes().length
								: 10;
						if (columnWidth < length) {
							columnWidth = length;
						}
					}
				}
			}
			if (colNum == 0) {
				sheet.setColumnWidth(colNum, (columnWidth - 2) * 256);
			} else {
				sheet.setColumnWidth(colNum, (columnWidth + 4) * 256);
			}
		}
		try {
			if (createDir(docsPath)) {
				OutputStream out = new FileOutputStream(filePath);
				workbook.write(out);
				out.close();
				download(filePath, response);// 执行下载
				File file = new File(docsPath);
				deleteFile(file);// 删除已完成下载的文件
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook;
	}

	/**
	 * 下载
	 * 
	 * <p>Title: download</p> 
	 * <p>Description: </p>  
	 * @time 下午6:20:59 
	 * @param path
	 * @param response
	 */
	public static void download(String path, HttpServletResponse response) {
		try {
			File file = new File(path);
			String filename = file.getName();
			InputStream inputStream = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[inputStream.available()];
			inputStream.read(buffer);
			inputStream.close();
			response.reset();
			response.addHeader("Content-disposition",
					"attachment;filename=" + new String(filename.getBytes(), "iso-8859-1"));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/vnd.ms-excel;UTF-8");
			outputStream.write(buffer);
			outputStream.flush();
			outputStream.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 创建目录
	 * 
	 * <p>Title: createDir</p> 
	 * <p>Description: </p>  
	 * @time 下午6:20:19 
	 * @param destDirName
	 * @return
	 */
	public static boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {
			return true;
		}
		if (!destDirName.endsWith(File.separator)) {
			destDirName = destDirName + File.separator;
		}
		if (dir.mkdirs()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 删除文件&文件夹
	 * 
	 * <p>Title: cleanFile</p> 
	 * <p>Description: </p>  
	 * @time 下午6:20:49 
	 * @param docsPath
	 */
	public static void deleteFile(File file) {
        if (file.isFile() || file.list().length == 0) {
            file.delete();
        } else {
            for (File files : file.listFiles()) {
            	deleteFile(files);
            }
            file.delete();
        }
    }

	/**
	 * 列头单元格样式
	 * 
	 * <p>Title: getColumnTopStyle</p> 
	 * <p>Description: </p>  
	 * @time 下午6:20:37 
	 * @param workbook
	 * @return
	 */
	public static HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {
		// 设置样式;
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置底边框;
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// 设置底边框颜色;
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		// 设置左边框;
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// 设置左边框颜色;
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		// 设置右边框;
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// 设置右边框颜色;
		style.setRightBorderColor(HSSFColor.BLACK.index);
		// 设置顶边框;
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		// 设置顶边框颜色;
		style.setTopBorderColor(HSSFColor.BLACK.index);
		// 设置自动换行;
		style.setWrapText(false);
		// 设置水平对齐的样式为居中对齐;
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 设置垂直对齐的样式为居中对齐;
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		// 设置字体
		HSSFFont font = workbook.createFont();
		// 设置字体颜色
		font.setColor(HSSFColor.BLACK.index);
		// 设置字体大小
		font.setFontHeightInPoints((short) 12);
		// 字体加粗
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 设置字体名字
		font.setFontName(FONT_STYLE);
		// 在样式用应用设置的字体;
		style.setFont(font);

		return style;
	}

	/**
	 * 列数据信息单元格样式
	 * 
	 * <p>Title: getColumnStyle</p> 
	 * <p>Description: </p>  
	 * @time 下午6:20:04 
	 * @param workbook
	 * @return
	 */
	public static HSSFCellStyle getColumnStyle(HSSFWorkbook workbook) {
		// 设置样式;
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置底边框;
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// 设置底边框颜色;
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		// 设置左边框;
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// 设置左边框颜色;
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		// 设置右边框;
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// 设置右边框颜色;
		style.setRightBorderColor(HSSFColor.BLACK.index);
		// 设置顶边框;
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		// 设置顶边框颜色;
		style.setTopBorderColor(HSSFColor.BLACK.index);
		// 设置自动换行;
		style.setWrapText(false);
		// 设置水平对齐的样式为居中对齐;
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 设置垂直对齐的样式为居中对齐;
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		// 设置字体
		HSSFFont font = workbook.createFont();
		// 设置字体大小
		font.setFontHeightInPoints((short) 10);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// 设置字体名字
		font.setFontName(FONT_STYLE);
		// 在样式用应用设置的字体;
		style.setFont(font);
		return style;
	}
}
