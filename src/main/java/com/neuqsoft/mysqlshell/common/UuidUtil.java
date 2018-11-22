package com.neuqsoft.mysqlshell.common;

import java.util.UUID;

/**<p>类路径 : com.neuqsoft.zx.common.utils.UuidUtil
 * <p>类描述 : UUID生成工具类
 * <p>类详情 : 无
 * 
 * @author 宋延军
 * @version 1.0.0
 * <p>
 * --------------------------------------------------------------<br>
 * 修改履历：<br>
 *        <li>2017年2月27日，songyanjun，新增注释；<br>
 * --------------------------------------------------------------<br>
 * </p>
 */
public class UuidUtil {

	public static String[] chars = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
			"q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A",
			"B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };

	/**<p>功能描述 : 生成原生36位的UUID
	 * <p>详细说明 : 无
	 *
	 * @return
	 * @author
	 * <p>
	 * --------------------------------------------------------------<br>
	 * 修改履历：<br>
	 *        <li>2017年2月27日，songyanjun，新增注释；<br>
	 * --------------------------------------------------------------<br>
	 * </p>
	 */
	public static String id() {

		String uuid = UUID.randomUUID().toString();
		return uuid;
	}

	/**<p>功能描述 : 生成32位的UUID
	 * <p>详细说明 : （不带横杠符号的）
	 *
	 * @return
	 * @author
	 * <p>
	 * --------------------------------------------------------------<br>
	 * 修改履历：<br>
	 *        <li>2017年2月27日，songyanjun，新增注释；<br>
	 * --------------------------------------------------------------<br>
	 * </p>
	 */
	public static String idNoline() {

		return id().replaceAll("-", "");
	}

	/**<p>功能描述 : 生成8位的UUID
	 * <p>详细说明 : （不带横杠符号的短UUID，可以做验证码^^）
	 *
	 * @return
	 * @author
	 * <p>
	 * --------------------------------------------------------------<br>
	 * 修改履历：<br>
	 *        <li>2017年2月27日，songyanjun，新增注释；<br>
	 * --------------------------------------------------------------<br>
	 * </p>
	 */
	public static String shortidNoline() {

		StringBuffer shortBuffer = new StringBuffer();
		String uuid = idNoline();
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[(x % 62)]);
		}
		return shortBuffer.toString();
	}

}
