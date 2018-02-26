package com.hongedu.honghr.util.upload;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;

import com.hongedu.honghr.honghr.common.constant.FileConstant;

public class UploadUtil {
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
		String fileName = UUID.randomUUID().toString() + ".jpg";
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