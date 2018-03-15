package com.hongedu.honghr.util.upload;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hongedu.honghr.honghr.common.constant.FileConstant;

public class UploadUtil {

	private UploadUtil() {
	}

	/**
	 * 上传资源的方法
	 * 
	 * @param request:请求
	 * @param file:文件
	 * @param savePath:上传目录
	 * @return 相对路径
	 */
	public static Map<String, Object> uploadFile(HttpServletRequest request, MultipartFile file, String savePath) {
		Map<String, Object> resultMap = null;
		try {
			// 获取资源的真实路径
			String realPath = request.getSession().getServletContext().getRealPath(savePath);
			String fileName = file.getOriginalFilename();
			// 获取新的资源名称
			StringBuffer buffer = new StringBuffer();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String newFileName = buffer.append(UUID.randomUUID().toString().replaceAll("-", "")).append("_")
					.append(format.format(new Date())).append(fileName.substring(fileName.lastIndexOf("."))).toString();
			// 创建文件夹
			File realfile = new File(realPath);
			if (!realfile.exists()) {
				realfile.mkdirs();
			}
			realfile = new File(realPath + "/" + newFileName);
			FileUtils.copyInputStreamToFile(file.getInputStream(), realfile);
			resultMap = new HashMap<String, Object>();
			// 保存物理路径和相对路径
			resultMap.put(FileConstant.PHYSICS_URL, realPath + File.separator + newFileName);
			resultMap.put(FileConstant.WEB_URL, savePath + newFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}

	/**
	 * 上传自定义裁剪图片的方法
	 * 
	 * @param request请求
	 * @param image编码后的图片内容
	 * @param savePath保存的路径
	 * @return 结果的集合
	 */
	public static Map<String, Object> uploadCustomImage(HttpServletRequest request, String image, String savePath) {
		Base64 base64 = new Base64();
		byte[] k = base64.decode(image.substring("data:image/jpeg;base64,".length()));
		String realPath = request.getSession().getServletContext().getRealPath(savePath);
		String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".jpg";
		File imageFile = new File(realPath, fileName);
		if (!imageFile.exists()) {
			imageFile.mkdirs();
		}
		InputStream input = new ByteArrayInputStream(k);
		try {
			BufferedImage bufferedImage = ImageIO.read(input);
			ImageIO.write(bufferedImage, "jpg", imageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(FileConstant.PHYSICS_URL, realPath + File.separator + fileName);
		resultMap.put(FileConstant.WEB_URL, savePath + fileName);
		return resultMap;
	}
}